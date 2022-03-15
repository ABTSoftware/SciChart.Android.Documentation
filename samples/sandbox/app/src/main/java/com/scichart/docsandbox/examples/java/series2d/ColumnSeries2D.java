package com.scichart.docsandbox.examples.java.series2d;

import android.graphics.Color;

import androidx.annotation.NonNull;

import com.scichart.charting.model.dataSeries.IXyDataSeries;
import com.scichart.charting.model.dataSeries.XyDataSeries;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.axes.NumericAxis;
import com.scichart.charting.visuals.renderableSeries.FastColumnRenderableSeries;
import com.scichart.core.framework.UpdateSuspender;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;
import com.scichart.drawing.common.SolidBrushStyle;
import com.scichart.drawing.common.SolidPenStyle;

import java.util.Collections;

@ExampleDefinition()
public class ColumnSeries2D extends SingleChart2DFragment {
    // <Example>
    @Override
    protected void initExample(@NonNull SciChartSurface surface) {
        final IXyDataSeries<Double, Double> dataSeries = new XyDataSeries<>(Double.class, Double.class);
        dataSeries.append(0.0, -3.0);
        dataSeries.append(1.0, 1.0);
        dataSeries.append(2.0, 4.0);

        final FastColumnRenderableSeries columnSeries = new FastColumnRenderableSeries();

        columnSeries.setDataSeries(dataSeries);
        columnSeries.setFillBrushStyle(new SolidBrushStyle(Color.CYAN));
        columnSeries.setStrokeStyle(new SolidPenStyle(Color.RED, true, 1f, null));

        UpdateSuspender.using(surface, () -> {
            Collections.addAll(surface.getXAxes(), new NumericAxis(requireContext()));
            Collections.addAll(surface.getYAxes(), new NumericAxis(requireContext()));

            Collections.addAll(surface.getRenderableSeries(), columnSeries);
        });
    }
    // </Example>
}
