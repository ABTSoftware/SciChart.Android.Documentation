package com.scichart.docsandbox.examples.java.series2d;

import android.graphics.Color;

import androidx.annotation.NonNull;

import com.scichart.charting.model.dataSeries.IOhlcDataSeries;
import com.scichart.charting.model.dataSeries.OhlcDataSeries;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.axes.NumericAxis;
import com.scichart.charting.visuals.renderableSeries.FastCandlestickRenderableSeries;
import com.scichart.core.framework.UpdateSuspender;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;
import com.scichart.drawing.common.SolidBrushStyle;
import com.scichart.drawing.common.SolidPenStyle;

import java.util.Collections;

@ExampleDefinition()
public class CandlestickSeries2D extends SingleChart2DFragment {
    // <Example>
    @Override
    protected void initExample(@NonNull SciChartSurface surface) {
        final IOhlcDataSeries<Double, Double> dataSeries = new OhlcDataSeries<>(Double.class, Double.class);
        dataSeries.append(0.0, 0.0, 1.0, 0.0, 1.0);
        dataSeries.append(1.0, 1.0, 5.0, 0.0, 4.0);
        dataSeries.append(2.0, 3.0, 5.0, 0.0, 0.0);

        final FastCandlestickRenderableSeries candlestickSeries = new FastCandlestickRenderableSeries();

        candlestickSeries.setDataSeries(dataSeries);

        candlestickSeries.setFillDownBrushStyle(new SolidBrushStyle(Color.RED));
        candlestickSeries.setFillUpBrushStyle(new SolidBrushStyle(Color.GREEN));

        candlestickSeries.setStrokeDownStyle(new SolidPenStyle(Color.RED, true, 1f, null));
        candlestickSeries.setStrokeUpStyle(new SolidPenStyle(Color.GREEN, true, 1f, null));

        UpdateSuspender.using(surface, () -> {
            Collections.addAll(surface.getXAxes(), new NumericAxis(requireContext()));
            Collections.addAll(surface.getYAxes(), new NumericAxis(requireContext()));

            Collections.addAll(surface.getRenderableSeries(), candlestickSeries);
        });
    }
    // </Example>
}
