package com.scichart.docsandbox.examples.kotlin.chartModifier2D

import com.scichart.charting.modifiers.RolloverModifier
import com.scichart.charting.visuals.SciChartSurface
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment

@ExampleDefinition()
class InteractivityRolloverModifier : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {}

    fun addRolloverModifier(surface: SciChartSurface) {
        // <AddRolloverModifier>
        // Assume a surface has been created and configured somewhere
        surface.chartModifiers.add(RolloverModifier())
        // </AddRolloverModifier>
    }
}

