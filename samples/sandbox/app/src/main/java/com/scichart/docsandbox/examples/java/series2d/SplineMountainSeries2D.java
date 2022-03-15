package com.scichart.docsandbox.examples.java.series2d;

import android.graphics.Color;

import androidx.annotation.NonNull;

import com.scichart.charting.model.dataSeries.IXyDataSeries;
import com.scichart.charting.model.dataSeries.XyDataSeries;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.axes.NumericAxis;
import com.scichart.charting.visuals.renderableSeries.SplineMountainRenderableSeries;
import com.scichart.core.framework.UpdateSuspender;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;
import com.scichart.drawing.common.SolidBrushStyle;
import com.scichart.drawing.common.SolidPenStyle;

import java.util.Collections;

@ExampleDefinition()
public class SplineMountainSeries2D extends SingleChart2DFragment {
    // <Example>
    @Override
    protected void initExample(@NonNull SciChartSurface surface) {
        final IXyDataSeries<Double, Double> xyDataSeries = new XyDataSeries<>(Double.class, Double.class);
        xyDataSeries.append(0.0, 0.0);
        xyDataSeries.append(1.0, 1.0);
        xyDataSeries.append(2.0, 4.0);

        final SplineMountainRenderableSeries splineMountainSeries = new SplineMountainRenderableSeries();

        splineMountainSeries.setDataSeries(xyDataSeries);
        splineMountainSeries.setAreaStyle(new SolidBrushStyle(Color.CYAN));
        splineMountainSeries.setStrokeStyle(new SolidPenStyle(Color.RED, true, 1f, null));

        UpdateSuspender.using(surface, () -> {
            Collections.addAll(surface.getXAxes(), new NumericAxis(requireContext()));
            Collections.addAll(surface.getYAxes(), new NumericAxis(requireContext()));

            Collections.addAll(surface.getRenderableSeries(), splineMountainSeries);
        });
    }
    // </Example>
}
