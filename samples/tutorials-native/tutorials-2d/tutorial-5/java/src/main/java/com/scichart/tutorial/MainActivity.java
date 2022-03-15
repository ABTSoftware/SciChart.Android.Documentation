package com.scichart.tutorial;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.scichart.charting.model.dataSeries.XyDataSeries;
import com.scichart.charting.modifiers.LegendModifier;
import com.scichart.charting.modifiers.PinchZoomModifier;
import com.scichart.charting.modifiers.RolloverModifier;
import com.scichart.charting.modifiers.ZoomExtentsModifier;
import com.scichart.charting.modifiers.ZoomPanModifier;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.annotations.HorizontalAnchorPoint;
import com.scichart.charting.visuals.annotations.TextAnnotation;
import com.scichart.charting.visuals.annotations.VerticalAnchorPoint;
import com.scichart.charting.visuals.axes.IAxis;
import com.scichart.charting.visuals.axes.NumericAxis;
import com.scichart.charting.visuals.pointmarkers.EllipsePointMarker;
import com.scichart.charting.visuals.renderableSeries.FastLineRenderableSeries;
import com.scichart.charting.visuals.renderableSeries.IRenderableSeries;
import com.scichart.charting.visuals.renderableSeries.XyScatterRenderableSeries;
import com.scichart.core.annotations.Orientation;
import com.scichart.core.framework.UpdateSuspender;
import com.scichart.core.model.DoubleValues;
import com.scichart.core.model.IntegerValues;
import com.scichart.drawing.common.FontStyle;
import com.scichart.drawing.common.SolidBrushStyle;

import java.util.Collections;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    private int fifoCapacity = 300;
    private int pointsCount = 200;

    private ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
    private ScheduledFuture schedule;

    private SciChartSurface surface;

    private final DoubleValues lineData = new DoubleValues();
    private XyDataSeries lineDataSeries;

    private DoubleValues scatterData = new DoubleValues();
    private XyDataSeries scatterDataSeries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            SciChartSurface.setRuntimeLicenseKey("");
        } catch (Exception e) {
            Log.e("SciChart", "Error during setting license key", e);
        }

        surface = new SciChartSurface(this);
        final LinearLayout chartLayout = findViewById(R.id.chart_layout);
        chartLayout.addView(surface);

        final IAxis xAxis = new NumericAxis(this);
        xAxis.setAxisTitle("X Axis Title");

        final IAxis yAxis = new NumericAxis(this);
        yAxis.setAxisTitle("Y Axis Title");

        UpdateSuspender.using(surface, () -> {
            Collections.addAll(surface.getXAxes(), xAxis);
            Collections.addAll(surface.getYAxes(), yAxis);
        });

        lineDataSeries = new XyDataSeries(Integer.class, Double.class);
        scatterDataSeries = new XyDataSeries(Integer.class, Double.class);

        lineDataSeries.setSeriesName("Line Series");
        scatterDataSeries.setSeriesName("Scatter Series");
        lineDataSeries.setFifoCapacity(fifoCapacity);
        scatterDataSeries.setFifoCapacity(fifoCapacity);

        final IntegerValues xValues = new IntegerValues();
        for (int i = 0; i < pointsCount; i++) {
            xValues.add(i);
            lineData.add(Math.sin(i * 0.1));
            scatterData.add(Math.cos(i * 0.1));
            count += 1;
        }
        lineDataSeries.append(xValues, lineData);
        scatterDataSeries.append(xValues, scatterData);

        final IRenderableSeries lineSeries = new FastLineRenderableSeries();
        lineSeries.setDataSeries(lineDataSeries);

        final EllipsePointMarker pointMarker = new EllipsePointMarker();
        pointMarker.setFillStyle(new SolidBrushStyle(0xFF32CD32));
        pointMarker.setSize(10, 10);

        final IRenderableSeries scatterSeries = new XyScatterRenderableSeries();
        scatterSeries.setDataSeries(scatterDataSeries);
        scatterSeries.setPointMarker(pointMarker);

        final LegendModifier legendModifier = new LegendModifier(this);
        legendModifier.setOrientation(Orientation.HORIZONTAL);
        legendModifier.setLegendPosition(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0, 0, 10);

        UpdateSuspender.using(surface, () -> {
            Collections.addAll(surface.getRenderableSeries(), lineSeries, scatterSeries);
            Collections.addAll(surface.getChartModifiers(), new PinchZoomModifier(), new ZoomPanModifier(), new ZoomExtentsModifier());
            Collections.addAll(surface.getChartModifiers(), legendModifier);
            Collections.addAll(surface.getChartModifiers(), new RolloverModifier());
        });

        schedule = scheduledExecutorService.scheduleWithFixedDelay(updateData, 0, 10, TimeUnit.MILLISECONDS);
    }

    private Integer count = 0;

    // <AddAnnotations>
    private final Runnable updateData = () -> {
        Integer x = count;
        UpdateSuspender.using(surface, () -> {
            lineDataSeries.append(x, Math.sin(x* 0.1));
            scatterDataSeries.append(x, Math.cos(x * 0.1));

            tryAddAnnotationAt(x);

            // zoom series to fit viewport size into X-Axis direction
            surface.zoomExtentsX();
            count += 1;
        });
    };

    private void tryAddAnnotationAt(int x) {
        // add label every 100 data points
        if (x % 100 == 0) {
            final TextAnnotation label = new TextAnnotation(this);
            label.setText("N");
            label.setX1(x);
            label.setY1(0);
            label.setHorizontalAnchorPoint(HorizontalAnchorPoint.Center);
            label.setVerticalAnchorPoint(VerticalAnchorPoint.Center);
            label.setFontStyle(new FontStyle(30f, Color.WHITE));

            // add label into annotation collection
            surface.getAnnotations().add(label);

            // if we add annotation and x > fifoCapacity
            // then we need to remove annotation which goes out of the screen
            if (x > fifoCapacity) {
                surface.getAnnotations().remove(0);
            }
        }
    }
    // </AddAnnotations>
}
