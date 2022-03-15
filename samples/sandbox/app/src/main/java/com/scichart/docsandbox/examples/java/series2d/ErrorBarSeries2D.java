package com.scichart.docsandbox.examples.java.series2d;

import androidx.annotation.NonNull;

import com.scichart.charting.model.dataSeries.HlDataSeries;
import com.scichart.charting.model.dataSeries.IHlDataSeries;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.axes.NumericAxis;
import com.scichart.charting.visuals.renderableSeries.ErrorDirection;
import com.scichart.charting.visuals.renderableSeries.ErrorMode;
import com.scichart.charting.visuals.renderableSeries.FastErrorBarsRenderableSeries;
import com.scichart.core.framework.UpdateSuspender;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;
import com.scichart.drawing.common.SolidPenStyle;

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

        final FastErrorBarsRenderableSeries errorBarSeries = new FastErrorBarsRenderableSeries();

        errorBarSeries.setDataSeries(dataSeries);

        errorBarSeries.setStrokeStyle(new SolidPenStyle(0xFFFF1919, true, 2, null));
        errorBarSeries.setErrorMode(ErrorMode.Both);
        errorBarSeries.setErrorDirection(ErrorDirection.Vertical);

        UpdateSuspender.using(surface, () -> {
            Collections.addAll(surface.getXAxes(), new NumericAxis(requireContext()));
            Collections.addAll(surface.getYAxes(), new NumericAxis(requireContext()));

            Collections.addAll(surface.getRenderableSeries(), errorBarSeries);
        });
    }
    // </Example>
}
