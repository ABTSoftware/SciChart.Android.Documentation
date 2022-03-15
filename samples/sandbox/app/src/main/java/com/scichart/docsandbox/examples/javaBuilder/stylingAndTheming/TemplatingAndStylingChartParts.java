package com.scichart.docsandbox.examples.javaBuilder.stylingAndTheming;

import androidx.annotation.NonNull;

import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;
import com.scichart.drawing.common.SolidBrushStyle;
import com.scichart.drawing.common.SolidPenStyle;
import com.scichart.drawing.utility.ColorUtil;

@ExampleDefinition()
public class TemplatingAndStylingChartParts extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) {
        // <StylingTheChartViewport>
        // surface background. If you set color for chart background than it is color only for axes area
        surface.setBackgroundColor(ColorUtil.Orange);

        // chart area (viewport) background fill color
        surface.setRenderableSeriesAreaFillStyle(new SolidBrushStyle(0xFFFFB6C1));

        // chart area border color and thickness
        surface.setRenderableSeriesAreaBorderStyle(new SolidPenStyle(0xFF4682b4, true, 2, null));
        // </StylingTheChartViewport>
    }
}
