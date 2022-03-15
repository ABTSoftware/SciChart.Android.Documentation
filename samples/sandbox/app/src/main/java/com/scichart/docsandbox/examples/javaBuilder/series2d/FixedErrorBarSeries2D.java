package com.scichart.docsandbox.examples.javaBuilder.series2d;

import androidx.annotation.NonNull;

import com.scichart.charting.model.dataSeries.IXyDataSeries;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.renderableSeries.ErrorDirection;
import com.scichart.charting.visuals.renderableSeries.ErrorMode;
import com.scichart.charting.visuals.renderableSeries.FastFixedErrorBarsRenderableSeries;
import com.scichart.core.framework.UpdateSuspender;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;

import java.util.Collections;

@ExampleDefinition()
public class FixedErrorBarSeries2D extends SingleChart2DFragment {
    // <Example>
    @Override
    protected void initExample(@NonNull SciChartSurface surface) {
        final IXyDataSeries<Double, Double> dataSeries = sciChartBuilder.newXyDataSeries(Double.class, Double.class).build();
        dataSeries.append(0.0, 0.0);
        dataSeries.append(1.0, 1.0);
        dataSeries.append(2.0, 4.0);

        final FastFixedErrorBarsRenderableSeries errorBarSeries = sciChartBuilder.newFixedErrorBarsSeries()
                .withDataSeries(dataSeries)
                .withStrokeStyle(0xFFFF1919, 2f)
                .withErrorMode(ErrorMode.Both)
                .withErrorDirection(ErrorDirection.Vertical)
                .withHighError(0.3)
                .withLowError(0.1)
                .build();

        UpdateSuspender.using(surface, () -> {
            Collections.addAll(surface.getXAxes(), sciChartBuilder.newNumericAxis().build());
            Collections.addAll(surface.getYAxes(), sciChartBuilder.newNumericAxis().build());

            Collections.addAll(surface.getRenderableSeries(), errorBarSeries);
        });
    }
    // </Example>
}
