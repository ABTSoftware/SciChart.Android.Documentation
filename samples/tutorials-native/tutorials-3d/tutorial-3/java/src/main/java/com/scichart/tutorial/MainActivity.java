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
import com.scichart.charting3d.visuals.axes.NumericAxis3D;
import com.scichart.charting3d.visuals.pointMarkers.SpherePointMarker3D;
import com.scichart.charting3d.visuals.renderableSeries.scatter.ScatterRenderableSeries3D;
import com.scichart.core.framework.UpdateSuspender;

import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private SciChartSurface3D surface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            SciChartSurface.setRuntimeLicenseKey("");
        } catch (Exception e) {
            Log.e("SciChart", "Error during setting license key", e);
        }

        final LinearLayout chartLayout = findViewById(R.id.chart_layout);

        surface = new SciChartSurface3D(this);
        chartLayout.addView(surface);

        final XyzDataSeries3D dataSeries = new XyzDataSeries3D(Double.class, Double.class, Double.class);
        for (int i = 0; i < 200; i++) {
            final double x = getGaussianRandomNumber(5.0, 1.5);
            final double y = getGaussianRandomNumber(5.0, 1.5);
            final double z = getGaussianRandomNumber(5.0, 1.5);
            dataSeries.append(x, y, z);
        }

        final SpherePointMarker3D pointMarker = new SpherePointMarker3D();
        pointMarker.setFill(0xFF32CD32);
        pointMarker.setSize(10.0f);

        final ScatterRenderableSeries3D rSeries = new ScatterRenderableSeries3D();
        rSeries.setDataSeries(dataSeries);
        rSeries.setPointMarker(pointMarker);

        // <CreateTooltipModifier>
        final TooltipModifier3D tooltipModifier = new TooltipModifier3D();
        tooltipModifier.setExecuteOnPointerCount(2);
        // </CreateTooltipModifier>

        UpdateSuspender.using(surface, () -> {
            surface.setXAxis(new NumericAxis3D());
            surface.setYAxis(new NumericAxis3D());
            surface.setZAxis(new NumericAxis3D());
            Collections.addAll(surface.getRenderableSeries(), rSeries);

            // <AddModifiers>
            Collections.addAll(surface.getChartModifiers(),
                    new OrbitModifier3D(),
                    new ZoomExtentsModifier3D(),
                    new PinchZoomModifier3D(),
                    tooltipModifier
            );
            // </AddModifiers>
        });
    }

    private Double getGaussianRandomNumber(Double mean, Double stdDev) {
        final Random random = new Random();

        final double u1 = random.nextDouble();
        final double u2 = random.nextDouble();

        final double randStdNormal = Math.sqrt(-2.0 * Math.log(u1)) * Math.sin(2.0 * Math.PI * u2);
        return mean * stdDev * randStdNormal;
    }
}
