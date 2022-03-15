package com.scichart.docsandbox.examples.javaBuilder.series2d;

import android.graphics.Color;

import androidx.annotation.NonNull;

import com.scichart.charting.model.dataSeries.IXyDataSeries;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.renderableSeries.SplineLineRenderableSeries;
import com.scichart.core.framework.UpdateSuspender;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;

import java.util.Collections;

@ExampleDefinition()
public class SplineLineSeries2D extends SingleChart2DFragment {
    // <Example>
    @Override
    protected void initExample(@NonNull SciChartSurface surface) {
        final IXyDataSeries<Double, Double> dataSeries = sciChartBuilder.newXyDataSeries(Double.class, Double.class).build();
        dataSeries.append(0.0, 0.0);
        dataSeries.append(1.0, 1.0);
        dataSeries.append(2.0, 4.0);

        final SplineLineRenderableSeries splineLineSeries = sciChartBuilder.newSplineLineSeries()
                .withDataSeries(dataSeries)
                .withStrokeStyle(Color.RED, 1f, true)
                .build();

        UpdateSuspender.using(surface, () -> {
            Collections.addAll(surface.getXAxes(), sciChartBuilder.newNumericAxis().build());
            Collections.addAll(surface.getYAxes(), sciChartBuilder.newNumericAxis().build());

            Collections.addAll(surface.getRenderableSeries(), splineLineSeries);
        });
    }
    // </Example>
}
