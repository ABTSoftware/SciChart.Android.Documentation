package com.scichart.docsandbox.examples.javaBuilder.series2d;

import androidx.annotation.NonNull;

import com.scichart.charting.model.dataSeries.IXyzDataSeries;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.renderableSeries.FastBubbleRenderableSeries;
import com.scichart.core.framework.UpdateSuspender;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;
import com.scichart.drawing.common.SolidBrushStyle;

import java.util.Collections;

@ExampleDefinition()
public class BubbleSeries2D extends SingleChart2DFragment {
    // <Example>
    @Override
    protected void initExample(@NonNull SciChartSurface surface) {
        final IXyzDataSeries<Double, Double, Double> dataSeries = sciChartBuilder.newXyzDataSeries(Double.class, Double.class, Double.class).build();
        dataSeries.append(0.0, 0.0, 1.0);
        dataSeries.append(1.0, 1.0, 3.0);
        dataSeries.append(2.0, 4.0, 2.0);

        final FastBubbleRenderableSeries bubbleSeries = sciChartBuilder.newBubbleSeries()
                .withDataSeries(dataSeries)
                .withStrokeStyle(0xFFCCCCCC, 2f)
                .withBubbleBrushStyle(new SolidBrushStyle(0x77CCCCCC))
                .build();

        UpdateSuspender.using(surface, () -> {
            Collections.addAll(surface.getXAxes(), sciChartBuilder.newNumericAxis().build());
            Collections.addAll(surface.getYAxes(), sciChartBuilder.newNumericAxis().build());

            Collections.addAll(surface.getRenderableSeries(), bubbleSeries);
        });
    }
    // </Example>
}
