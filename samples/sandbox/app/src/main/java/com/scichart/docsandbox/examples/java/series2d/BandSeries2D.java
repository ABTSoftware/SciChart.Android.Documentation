package com.scichart.docsandbox.examples.java.series2d;

import android.graphics.Color;

import androidx.annotation.NonNull;

import com.scichart.charting.model.dataSeries.IXyyDataSeries;
import com.scichart.charting.model.dataSeries.XyyDataSeries;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.axes.NumericAxis;
import com.scichart.charting.visuals.renderableSeries.FastBandRenderableSeries;
import com.scichart.core.framework.UpdateSuspender;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;
import com.scichart.drawing.common.SolidBrushStyle;
import com.scichart.drawing.common.SolidPenStyle;

import java.util.Collections;

@ExampleDefinition()
public class BandSeries2D extends SingleChart2DFragment {
    // <Example>
    @Override
    protected void initExample(@NonNull SciChartSurface surface) {
        final IXyyDataSeries<Double, Double> dataSeries = new XyyDataSeries<>(Double.class, Double.class);
        dataSeries.append(0.0, 0.0, 1.0);
        dataSeries.append(1.0, 1.0, 0.0);
        dataSeries.append(2.0, 4.0, 0.0);

        final FastBandRenderableSeries bandSeries = new FastBandRenderableSeries();

        bandSeries.setDataSeries(dataSeries);
        bandSeries.setStrokeStyle(new SolidPenStyle(Color.RED, true, 1f, null));
        bandSeries.setStrokeY1Style(new SolidPenStyle(Color.BLUE, true, 1f, null));

        bandSeries.setFillBrushStyle(new SolidBrushStyle(Color.CYAN));
        bandSeries.setFillY1BrushStyle(new SolidBrushStyle(Color.YELLOW));

        UpdateSuspender.using(surface, () -> {
            Collections.addAll(surface.getXAxes(), new NumericAxis(requireContext()));
            Collections.addAll(surface.getYAxes(), new NumericAxis(requireContext()));

            Collections.addAll(surface.getRenderableSeries(), bandSeries);
        });
    }
    // </Example>
}
