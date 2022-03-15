package com.scichart.tutorial;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting3d.model.dataSeries.xyz.XyzDataSeries3D;
import com.scichart.charting3d.modifiers.OrbitModifier3D;
import com.scichart.charting3d.modifiers.PinchZoomModifier3D;
import com.scichart.charting3d.modifiers.TooltipModifier3D;
import com.scichart.charting3d.modifiers.ZoomExtentsModifier3D;
import com.scichart.charting3d.visuals.SciChartSurface3D;
import com.scichart.charting3d.visuals.pointMarkers.SpherePointMarker3D;
import com.scichart.charting3d.visuals.renderableSeries.scatter.ScatterRenderableSeries3D;
import com.scichart.core.framework.UpdateSuspender;
import com.scichart.core.model.DoubleValues;
import com.scichart.extensions3d.builders.SciChart3DBuilder;

import java.util.Collections;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    // <DataSeriesSetup>
    private int pointsCount = 200;

    private ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
    private ScheduledFuture schedule;

    private SciChartSurface3D surface;

    private final DoubleValues xValues = new DoubleValues();
    private final DoubleValues yValues = new DoubleValues();
    private final DoubleValues zValues = new DoubleValues();

    private final XyzDataSeries3D dataSeries = new XyzDataSeries3D(Double.class, Double.class, Double.class);
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

        LinearLayout chartLayout = findViewById(R.id.chart_layout);

        surface = new SciChartSurface3D(this);
        chartLayout.addView(surface);

        SciChart3DBuilder.init(this);
        final SciChart3DBuilder sciChartBuilder = SciChart3DBuilder.instance();

        // <AppendDataSeries>
        for (int i = 0; i < pointsCount; i++) {
            xValues.add(getGaussianRandomNumber(5.0, 1.5));
            yValues.add(getGaussianRandomNumber(5.0, 1.5));
            zValues.add(getGaussianRandomNumber(5.0, 1.5));
        }
        dataSeries.append(xValues, yValues, zValues);
        // </AppendDataSeries>

        final SpherePointMarker3D pointMarker = sciChartBuilder.newSpherePointMarker3D()
                .withFill(0xFF32CD32)
                .withSize(10.0f)
                .build();

        final ScatterRenderableSeries3D rSeries = sciChartBuilder.newScatterSeries3D()
                .withDataSeries(dataSeries)
                .withPointMarker(pointMarker)
                .build();

        final TooltipModifier3D tooltipModifier = new TooltipModifier3D();
        tooltipModifier.setExecuteOnPointerCount(2);

        UpdateSuspender.using(surface, () -> {
            surface.setXAxis(sciChartBuilder.newNumericAxis3D().build());
            surface.setYAxis(sciChartBuilder.newNumericAxis3D().build());
            surface.setZAxis(sciChartBuilder.newNumericAxis3D().build());
            Collections.addAll(surface.getRenderableSeries(), rSeries);
            Collections.addAll(surface.getChartModifiers(),
                    new OrbitModifier3D(),
                    new ZoomExtentsModifier3D(),
                    new PinchZoomModifier3D(),
                    tooltipModifier
            );
        });

        // <CreateTimer>
        schedule = scheduledExecutorService.scheduleWithFixedDelay(updateData, 0, 10, TimeUnit.MILLISECONDS);
        // </CreateTimer>
    }

    // <UpdateData>
    private Random random = new Random();

    private final Runnable updateData = () -> {
        for (int i = 0; i < pointsCount; i++) {
            double xValue = xValues.get(i) + random.nextDouble() - 0.5;
            double yValue = yValues.get(i) + random.nextDouble() - 0.5;
            double zValue = zValues.get(i) + random.nextDouble() - 0.5;

            xValues.set(i, xValue);
            yValues.set(i, yValue);
            zValues.set(i, zValue);
        }

        UpdateSuspender.using(surface, () -> {
            dataSeries.updateRangeXyzAt(0, xValues, yValues, zValues);
        });
    };
    // </UpdateData>

    private Double getGaussianRandomNumber(Double mean, Double stdDev) {
        final Random random = new Random();

        final double u1 = random.nextDouble();
        final double u2 = random.nextDouble();

        final double randStdNormal = Math.sqrt(-2.0 * Math.log(u1)) * Math.sin(2.0 * Math.PI * u2);
        return mean * stdDev * randStdNormal;
    }
}
