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
import com.scichart.core.model.DoubleValues;
import com.scichart.core.model.IntegerValues;
import com.scichart.extensions.builders.SciChartBuilder;

import java.util.Collections;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    // <DataSeriesSetup>
    private int pointsCount = 200;

    private ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
    private ScheduledFuture schedule;

    private SciChartSurface surface;

    private final DoubleValues lineData = new DoubleValues();
    private XyDataSeries lineDataSeries;

    private DoubleValues scatterData = new DoubleValues();
    private XyDataSeries scatterDataSeries;
    // </DataSeriesSetup>

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

        // <SetFifoCapacity>
        lineDataSeries = sciChartBuilder.newXyDataSeries(Integer.class, Double.class)
                .withSeriesName("Line Series")
                .withFifoCapacity(300)
                .build();
        scatterDataSeries = sciChartBuilder.newXyDataSeries(Integer.class, Double.class)
                .withSeriesName("Scatter Series")
                .withFifoCapacity(300)
                .build();
        // </SetFifoCapacity>

        // <InitialDataSetup>
        final IntegerValues xValues = new IntegerValues();
        for (int i = 0; i < pointsCount; i++) {
            xValues.add(i);
            lineData.add(Math.sin(i * 0.1));
            scatterData.add(Math.cos(i * 0.1));
            count += 1;
        }
        lineDataSeries.append(xValues, lineData);
        scatterDataSeries.append(xValues, scatterData);
        // </InitialDataSetup>

        final IRenderableSeries lineSeries = sciChartBuilder.newLineSeries()
                .withDataSeries(lineDataSeries)
                .build();

        final EllipsePointMarker pointMarker = sciChartBuilder
                .newPointMarker(new EllipsePointMarker())
                .withFill(0xFF32CD32)
                .withSize(10)
                .build();

        final IRenderableSeries scatterSeries = sciChartBuilder.newScatterSeries()
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
        });

        // <CreateTimer>
        schedule = scheduledExecutorService.scheduleWithFixedDelay(updateData, 0, 10, TimeUnit.MILLISECONDS);
        // </CreateTimer>
    }
/*
    // <UpdateData>
    private Double phase = 0.0;

    private final Runnable updateData = () -> {
        for (int i = 0; i < pointsCount; i++) {
            lineData.set(i, Math.sin(i* 0.1 + phase));
            scatterData.set(i, Math.cos(i* 0.1 + phase));
        }

        UpdateSuspender.using(surface, () -> {
            lineDataSeries.updateRangeYAt(0, lineData);
            scatterDataSeries.updateRangeYAt(0, scatterData);

            // zoom series to fit viewport size into X-Axis direction
            surface.zoomExtentsX();
        });

        phase += 0.01;
    };
    // </UpdateData>
 */

    // <AppendData>
    private Integer count = 0;

    private final Runnable updateData = () -> {
        Integer x = count;
        UpdateSuspender.using(surface, () -> {
            lineDataSeries.append(x, Math.sin(x* 0.1));
            scatterDataSeries.append(x, Math.cos(x * 0.1));

            // zoom series to fit viewport size into X-Axis direction
            surface.zoomExtentsX();
            count += 1;
        });
    };
    // </AppendData>
}
