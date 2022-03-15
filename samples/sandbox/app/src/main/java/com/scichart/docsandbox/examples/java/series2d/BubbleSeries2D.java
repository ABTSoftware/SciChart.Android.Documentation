package com.scichart.docsandbox.examples.java.series2d;

import androidx.annotation.NonNull;

import com.scichart.charting.model.dataSeries.IXyzDataSeries;
import com.scichart.charting.model.dataSeries.XyzDataSeries;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.axes.NumericAxis;
import com.scichart.charting.visuals.renderableSeries.FastBubbleRenderableSeries;
import com.scichart.core.framework.UpdateSuspender;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;
import com.scichart.drawing.common.SolidBrushStyle;
import com.scichart.drawing.common.SolidPenStyle;

import java.util.Collections;

@ExampleDefinition()
public class BubbleSeries2D extends SingleChart2DFragment {
    // <Example>
    @Override
    protected void initExample(@NonNull SciChartSurface surface) {
        final IXyzDataSeries<Double, Double, Double> dataSeries = new XyzDataSeries<>(Double.class, Double.class, Double.class);
        dataSeries.append(0.0, 0.0, 1.0);
        dataSeries.append(1.0, 1.0, 3.0);
        dataSeries.append(2.0, 4.0, 2.0);

        final FastBubbleRenderableSeries bubbleSeries = new FastBubbleRenderableSeries();

        bubbleSeries.setDataSeries(dataSeries);
        bubbleSeries.setStrokeStyle(new SolidPenStyle(0xFFCCCCCC, true, 2f, null));
        bubbleSeries.setBubbleBrushStyle(new SolidBrushStyle(0x77CCCCCC));

        UpdateSuspender.using(surface, () -> {
            Collections.addAll(surface.getXAxes(), new NumericAxis(requireContext()));
            Collections.addAll(surface.getYAxes(), new NumericAxis(requireContext()));

            Collections.addAll(surface.getRenderableSeries(), bubbleSeries);
        });
    }
    // </Example>
}
