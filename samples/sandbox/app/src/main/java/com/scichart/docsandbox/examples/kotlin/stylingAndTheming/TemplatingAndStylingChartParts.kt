package com.scichart.docsandbox.examples.kotlin.stylingAndTheming

import com.scichart.charting.visuals.SciChartSurface
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment
import com.scichart.drawing.common.SolidBrushStyle
import com.scichart.drawing.common.SolidPenStyle
import com.scichart.drawing.utility.ColorUtil

@ExampleDefinition()
class TemplatingAndStylingChartParts : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {
        // <StylingTheChartViewport>
        // surface background. If you set color for chart background than it is color only for axes area
        surface.setBackgroundColor(ColorUtil.Orange)

        // chart area (viewport) background fill color
        surface.renderableSeriesAreaFillStyle = SolidBrushStyle(-0x493f)

        // chart area border color and thickness
        surface.renderableSeriesAreaBorderStyle = SolidPenStyle(-0xb97d4c, true, 2f, null)
        // </StylingTheChartViewport>
    }
}
