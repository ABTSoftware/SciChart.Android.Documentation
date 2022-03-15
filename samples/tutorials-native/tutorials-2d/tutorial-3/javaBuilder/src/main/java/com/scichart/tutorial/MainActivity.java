package com.scichart.tutorial;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.scichart.charting.model.dataSeries.XyDataSeries;
import com.scichart.charting.modifiers.ModifierGroup;
import com.scichart.charting.modifiers.PinchZoomModifier;
import com.scichart.charting.modifiers.RolloverModifier;
import com.scichart.charting.modifiers.ZoomExtentsModifier;
import com.scichart.charting.modifiers.ZoomPanModifier;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.axes.IAxis;
import com.scichart.charting.visuals.pointmarkers.EllipsePointMarker;
import com.scichart.charting.visuals.renderableSeries.IRenderableSeries;
import com.scichart.core.annotations.Orientation;
import com.scichart.core.framework.UpdateSuspender;
import com.scichart.extensions.builders.SciChartBuilder;

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

        SciChartSurface surface = new SciChartSurface(this);
        LinearLayout chartLayout = findViewById(R.id.chart_layout);
        chartLayout.addView(surface);

        SciChartBuilder.init(this);
        final SciChartBuilder sciChartBuilder = SciChartBuilder.instance();

        final IAxis xAxis = sciChartBuilder.newNumericAxis()
                .withAxisTitle("X Axis Title")
                .build();

        final IAxis yAxis = sciChartBuilder.newNumericAxis()
                .withAxisTitle("Y Axis Title")
                .build();

        UpdateSuspender.using(surface, () -> {
            Collections.addAll(surface.getXAxes(), xAxis);
            Collections.addAll(surface.getYAxes(), yAxis);
        });

        // <AddSeriesName>
        final XyDataSeries lineData = sciChartBuilder.newXyDataSeries(Integer.class, Double.class)
                .withSeriesName("Line Series")
                .build();
        final XyDataSeries scatterData = sciChartBuilder.newXyDataSeries(Integer.class, Double.class)
                .withSeriesName("Scatter Series")
                .build();
        // </AddSeriesName>

        for (int i = 0; i < 1000; i++) {
            lineData.append(i, Math.sin(i * 0.1));
            scatterData.append(i, Math.cos(i * 0.1));
        }

        final IRenderableSeries lineSeries = sciChartBuilder.newLineSeries()
                .withDataSeries(lineData)
                .build();

        final EllipsePointMarker pointMarker = sciChartBuilder
                .newPointMarker(new EllipsePointMarker())
                .withFill(0xFF32CD32)
                .withSize(10)
                .build();

        final IRenderableSeries scatterSeries = sciChartBuilder.newScatterSeries()
                .withDataSeries(scatterData)
                .withPointMarker(pointMarker)
                .build();

        // <CreateLegend>
        ModifierGroup modifierGroup = sciChartBuilder.newModifierGroup()
                .withLegendModifier()
                .withPosition(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 10)
                .withOrientation(Orientation.HORIZONTAL)
                .build()
                .build();
        // </CreateLegend>

        UpdateSuspender.using(surface, () -> {
            Collections.addAll(surface.getRenderableSeries(), lineSeries, scatterSeries);
            Collections.addAll(surface.getChartModifiers(), new PinchZoomModifier(), new ZoomPanModifier(), new ZoomExtentsModifier());

            // <AddLegend>
            Collections.addAll(surface.getChartModifiers(), modifierGroup);
            // </AddLegend>

            // <AddRollover>
            Collections.addAll(surface.getChartModifiers(), new RolloverModifier());
            // </AddRollover>
        });
    }
}
