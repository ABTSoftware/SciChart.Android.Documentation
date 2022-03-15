package com.scichart.docsandbox.examples.kotlin.chartModifier2D

import com.scichart.charting.modifiers.TooltipModifier
import com.scichart.charting.visuals.SciChartSurface
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment

@ExampleDefinition()
class InteractivityTooltipModifier : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {}

    fun addTooltipModifier(surface: SciChartSurface) {
        // <AddTooltipModifier>
        // Assume a surface has been created and configured somewhere
        surface.chartModifiers.add(TooltipModifier())
        // </AddTooltipModifier>
    }
}

