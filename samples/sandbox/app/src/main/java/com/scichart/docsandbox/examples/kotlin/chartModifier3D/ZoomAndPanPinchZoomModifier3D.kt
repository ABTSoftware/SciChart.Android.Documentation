package com.scichart.docsandbox.examples.kotlin.chartModifier3D

import com.scichart.charting3d.modifiers.PinchZoomModifier3D
import com.scichart.charting3d.visuals.SciChartSurface3D
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart3DFragment

@ExampleDefinition()
class ZoomAndPanPinchZoomModifier3D : SingleChart3DFragment() {
    override fun initExample(surface: SciChartSurface3D) {}

    fun addPinchZoomModifier3D(surface: SciChartSurface3D) {
        // <AddPinchZoomModifier3D>
        // Assume a surface has been created and configured somewhere
        // Create a Modifier
        val pinchZoomModifier3D = PinchZoomModifier3D()
        pinchZoomModifier3D.scaleFactor = 1.5f

        // Add the modifier to the surface
        surface.chartModifiers.add(pinchZoomModifier3D)
        // </AddPinchZoomModifier3D>
    }
}
