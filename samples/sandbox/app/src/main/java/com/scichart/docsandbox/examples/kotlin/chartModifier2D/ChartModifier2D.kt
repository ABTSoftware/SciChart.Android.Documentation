package com.scichart.docsandbox.examples.kotlin.chartModifier2D

import com.scichart.charting.modifiers.PinchZoomModifier
import com.scichart.charting.visuals.SciChartSurface
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment

@ExampleDefinition()
class ChartModifier2D : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {}

    fun addPinchZoomModifier(surface: SciChartSurface) {
        // <AddPinchZoomModifier>
        // Assume a surface has been created and configured somewhere
        surface.chartModifiers.add(PinchZoomModifier())
        // </AddPinchZoomModifier>
    }
}
