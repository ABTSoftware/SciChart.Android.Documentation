package com.scichart.docsandbox.examples.javaBuilder.series2d;

import android.graphics.Color;

import androidx.annotation.NonNull;

import com.scichart.charting.model.dataSeries.IOhlcDataSeries;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.renderableSeries.FastOhlcRenderableSeries;
import com.scichart.core.framework.UpdateSuspender;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;

import java.util.Collections;

@ExampleDefinition()
public class OhlcSeries2D extends SingleChart2DFragment {
    // <Example>
    @Override
    protected void initExample(@NonNull SciChartSurface surface) {
        final IOhlcDataSeries<Double, Double> dataSeries = sciChartBuilder.newOhlcDataSeries(Double.class, Double.class).build();
        dataSeries.append(0.0, 0.0, 1.0, 0.0, 1.0);
        dataSeries.append(1.0, 1.0, 5.0, 0.0, 4.0);
        dataSeries.append(2.0, 3.0, 5.0, 0.0, 0.0);

        final FastOhlcRenderableSeries ohlcSeries = sciChartBuilder.newOhlcSeries()
                .withDataSeries(dataSeries)
                .withStrokeDown(Color.RED)
                .withStrokeUp(Color.GREEN)
                .build();

        UpdateSuspender.using(surface, () -> {
            Collections.addAll(surface.getXAxes(), sciChartBuilder.newNumericAxis().build());
            Collections.addAll(surface.getYAxes(), sciChartBuilder.newNumericAxis().build());

            Collections.addAll(surface.getRenderableSeries(), ohlcSeries);
        });
    }
    // </Example>
}
