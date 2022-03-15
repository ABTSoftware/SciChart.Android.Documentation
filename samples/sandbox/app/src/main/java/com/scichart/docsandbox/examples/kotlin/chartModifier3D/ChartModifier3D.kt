package com.scichart.docsandbox.examples.kotlin.chartModifier3D

import com.scichart.charting3d.modifiers.PinchZoomModifier3D
import com.scichart.charting3d.visuals.SciChartSurface3D
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart3DFragment

@ExampleDefinition()
class ChartModifier3D : SingleChart3DFragment() {
    override fun initExample(surface: SciChartSurface3D) {}

    fun addPinchZoom(surface: SciChartSurface3D) {
        // <AddPinchZoom>
        // Assume a surface has been created and configured somewhere
        surface.chartModifiers.add(PinchZoomModifier3D())
        // </AddPinchZoom>
    }
}
