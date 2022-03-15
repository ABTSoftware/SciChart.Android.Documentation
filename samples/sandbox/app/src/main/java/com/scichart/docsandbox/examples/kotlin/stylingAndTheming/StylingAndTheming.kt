package com.scichart.docsandbox.examples.kotlin.stylingAndTheming

import com.scichart.charting.visuals.SciChartSurface
import com.scichart.docsandbox.R
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment

@ExampleDefinition()
class StylingAndTheming : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {
        setTheme(surface)
        setCustomTheme(surface)
        setModifiedTheme(surface)
    }

    fun setTheme(surface: SciChartSurface) {
        // <SetTheme>
        surface.theme = R.style.SciChart_SciChartv4DarkStyle
        // </SetTheme>
    }

    fun setCustomTheme(surface: SciChartSurface) {
        // <SetCustomTheme>
        surface.theme = R.style.SciChart_BerryBlue
        // </SetCustomTheme>
    }

    fun setModifiedTheme(surface: SciChartSurface) {
        // <SetModifiedTheme>
        surface.theme = R.style.MyModifiedTheme
        // </SetModifiedTheme>
    }
}
