package com.scichart.tutorial;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.scichart.charting.model.dataSeries.XyDataSeries;
import com.scichart.charting.modifiers.ModifierGroup;
import com.scichart.charting.modifiers.PinchZoomModifier;
import com.scichart.charting.modifiers.RolloverModifier;
import com.scichart.charting.modifiers.YAxisDragModifier;
import com.scichart.charting.modifiers.ZoomExtentsModifier;
import com.scichart.charting.modifiers.ZoomPanModifier;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.annotations.HorizontalAnchorPoint;
import com.scichart.charting.visuals.annotations.TextAnnotation;
import com.scichart.charting.visuals.annotations.VerticalAnchorPoint;
import com.scichart.charting.visuals.axes.AxisAlignment;
import com.scichart.charting.visuals.axes.IAxis;
import com.scichart.charting.visuals.pointmarkers.EllipsePointMarker;
import com.scichart.charting.visuals.renderableSeries.IRenderableSeries;
import com.scichart.core.annotations.Orientation;
import com.scichart.core.framework.UpdateSuspender;
import com.scichart.core.model.DoubleValues;
import com.scichart.core.model.IntegerValues;
import com.scichart.data.model.DoubleRange;
import com.scichart.extensions.builders.SciChartBuilder;

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

    private SciChartBuilder sciChartBuilder;

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
        LinearLayout chartLayout = findViewById(R.id.chart_layout);
        chartLayout.addView(surface);

        SciChartBuilder.init(this);
        sciChartBuilder = SciChartBuilder.instance();

        // <CreateMultipleAxes>
        // Create another numeric axis, right-aligned
        final IAxis yAxisRight = sciChartBuilder.newNumericAxis()
                .withAxisTitle("Primary Y-Axis")
                .withAxisId("Primary Y-Axis")
                .withAxisAlignment(AxisAlignment.Right)
                .build();

        // Create another numeric axis, left-aligned
        final IAxis yAxisLeft = sciChartBuilder.newNumericAxis()
                .withAxisTitle("Secondary Y-Axis")
                .withAxisId("Secondary Y-Axis")
                .withAxisAlignment(AxisAlignment.Left)
                .withGrowBy(new DoubleRange(0.2, 0.2))
                .build();
        // </CreateMultipleAxes>

        UpdateSuspender.using(surface, () -> {
            // <AddMultipleAxes>
            Collections.addAll(surface.getXAxes(), sciChartBuilder.newNumericAxis().build());
            Collections.addAll(surface.getYAxes(), yAxisLeft, yAxisRight);
            // </AddMultipleAxes>
        });

        lineDataSeries = sciChartBuilder.newXyDataSeries(Integer.class, Double.class)
                .withSeriesName("Line Series")
                .withFifoCapacity(fifoCapacity)
                .build();
        scatterDataSeries = sciChartBuilder.newXyDataSeries(Integer.class, Double.class)
                .withSeriesName("Scatter Series")
                .withFifoCapacity(fifoCapacity)
                .build();

        final IntegerValues xValues = new IntegerValues();
        for (int i = 0; i < pointsCount; i++) {
            xValues.add(i);
            lineData.add(Math.sin(i * 0.1));
            scatterData.add(Math.cos(i * 0.1));
            count += 1;
        }
        lineDataSeries.append(xValues, lineData);
        scatterDataSeries.append(xValues, scatterData);

        // <AttachSeriesToAxes1>
        final IRenderableSeries lineSeries = sciChartBuilder.newLineSeries()
                .withYAxisId("Primary Y-Axis")
        // </AttachSeriesToAxes1>
                .withDataSeries(lineDataSeries)
                .build();

        final EllipsePointMarker pointMarker = sciChartBuilder
                .newPointMarker(new EllipsePointMarker())
                .withFill(0xFF32CD32)
                .withSize(10)
                .build();

        // <AttachSeriesToAxes2>
        final IRenderableSeries scatterSeries = sciChartBuilder.newScatterSeries()
                .withYAxisId("Secondary Y-Axis")
        // </AttachSeriesToAxes2>
                .withDataSeries(scatterDataSeries)
                .withPointMarker(pointMarker)
                .build();

        ModifierGroup modifierGroup = sciChartBuilder.newModifierGroup()
                .withLegendModifier()
                .withPosition(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 10)
                .withOrientation(Orientation.HORIZONTAL)
                .build()
                .build();

        UpdateSuspender.using(surface, () -> {
            Collections.addAll(surface.getRenderableSeries(), lineSeries, scatterSeries);
            Collections.addAll(surface.getChartModifiers(), new PinchZoomModifier(), new ZoomPanModifier(), new ZoomExtentsModifier());
            Collections.addAll(surface.getChartModifiers(), modifierGroup);
            Collections.addAll(surface.getChartModifiers(), new RolloverModifier());

            // <AddYAxisDragModifier>
            Collections.addAll(surface.getChartModifiers(), new YAxisDragModifier());
            // </AddYAxisDragModifier>
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
            // <AttachAnnotationsToAxes>
            final TextAnnotation label = sciChartBuilder.newTextAnnotation()
                    .withYAxisId(x % 200 == 0 ? "Primary Y-Axis" : "Secondary Y-Axis")
            // </AttachAnnotationsToAxes>
                    .withText("N")
                    .withX1(x)
                    .withY1(0)
                    .withHorizontalAnchorPoint(HorizontalAnchorPoint.Center)
                    .withVerticalAnchorPoint(VerticalAnchorPoint.Center)
                    .withFontStyle(30f, Color.WHITE)
                    .build();

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
