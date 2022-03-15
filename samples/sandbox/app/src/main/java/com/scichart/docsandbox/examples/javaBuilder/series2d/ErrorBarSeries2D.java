package com.scichart.docsandbox.examples.javaBuilder.series2d;

import androidx.annotation.NonNull;

import com.scichart.charting.model.dataSeries.HlDataSeries;
import com.scichart.charting.model.dataSeries.IHlDataSeries;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.renderableSeries.ErrorDirection;
import com.scichart.charting.visuals.renderableSeries.ErrorMode;
import com.scichart.charting.visuals.renderableSeries.FastErrorBarsRenderableSeries;
import com.scichart.core.framework.UpdateSuspender;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;

import java.util.Collections;

@ExampleDefinition()
public class ErrorBarSeries2D extends SingleChart2DFragment {
    // <Example>
    @Override
    protected void initExample(@NonNull SciChartSurface surface) {
        final IHlDataSeries<Double, Double> dataSeries = new HlDataSeries<>(Double.class, Double.class);
        dataSeries.append(0.0, 0.0, 0.1, 0.3);
        dataSeries.append(1.0, 1.0, 0.2, 0.2);
        dataSeries.append(2.0, 3.0, 0.3, 0.1);

        final FastErrorBarsRenderableSeries errorBarSeries = sciChartBuilder.newErrorBarsSeries()
                .withDataSeries(dataSeries)
                .withStrokeStyle(0xFFFF1919, 2f)
                .withErrorMode(ErrorMode.Both)
                .withErrorDirection(ErrorDirection.Vertical)
                .build();

        UpdateSuspender.using(surface, () -> {
            Collections.addAll(surface.getXAxes(), sciChartBuilder.newNumericAxis().build());
            Collections.addAll(surface.getYAxes(), sciChartBuilder.newNumericAxis().build());

            Collections.addAll(surface.getRenderableSeries(), errorBarSeries);
        });
    }
    // </Example>
}
