package com.scichart.tutorial;

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
import com.scichart.charting.visuals.axes.IAxis;
import com.scichart.charting.visuals.axes.NumericAxis;
import com.scichart.charting.visuals.pointmarkers.EllipsePointMarker;
import com.scichart.charting.visuals.renderableSeries.FastLineRenderableSeries;
import com.scichart.charting.visuals.renderableSeries.IRenderableSeries;
import com.scichart.charting.visuals.renderableSeries.XyScatterRenderableSeries;
import com.scichart.core.annotations.Orientation;
import com.scichart.core.framework.UpdateSuspender;
import com.scichart.drawing.common.SolidBrushStyle;

import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            SciChartSurface.setRuntimeLicenseKey("");
        } catch (Exception e) {
            Log.e("SciChart", "Error during setting license key", e);
        }

        final SciChartSurface surface = new SciChartSurface(this);
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

        final XyDataSeries lineDataSeries = new XyDataSeries(Integer.class, Double.class);
        final XyDataSeries scatterDataSeries = new XyDataSeries(Integer.class, Double.class);

        // <AddSeriesName>
        lineDataSeries.setSeriesName("Line Series");
        scatterDataSeries.setSeriesName("Scatter Series");
        // </AddSeriesName>

        for (int i = 0; i < 1000; i++) {
            lineDataSeries.append(i, Math.sin(i * 0.1));
            scatterDataSeries.append(i, Math.cos(i * 0.1));
        }

        final IRenderableSeries lineSeries = new FastLineRenderableSeries();
        lineSeries.setDataSeries(lineDataSeries);

        final EllipsePointMarker pointMarker = new EllipsePointMarker();
        pointMarker.setFillStyle(new SolidBrushStyle(0xFF32CD32));
        pointMarker.setSize(10, 10);

        final IRenderableSeries scatterSeries = new XyScatterRenderableSeries();
        scatterSeries.setDataSeries(scatterDataSeries);
        scatterSeries.setPointMarker(pointMarker);

        // <CreateLegend>
        final LegendModifier legendModifier = new LegendModifier(this);
        legendModifier.setOrientation(Orientation.HORIZONTAL);
        legendModifier.setLegendPosition(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0, 0, 10);
        // </CreateLegend>

        UpdateSuspender.using(surface, () -> {
            Collections.addAll(surface.getRenderableSeries(), lineSeries, scatterSeries);
            Collections.addAll(surface.getChartModifiers(), new PinchZoomModifier(), new ZoomPanModifier(), new ZoomExtentsModifier());

            // <AddLegend>
            Collections.addAll(surface.getChartModifiers(), legendModifier);
            // </AddLegend>

            // <AddRollover>
            Collections.addAll(surface.getChartModifiers(), new RolloverModifier());
            // </AddRollover>
        });
    }
}
