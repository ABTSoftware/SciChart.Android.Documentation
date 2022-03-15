package com.scichart.docsandbox.examples.kotlin.chartModifier3D

import com.scichart.charting3d.modifiers.FreeLookModifier3D
import com.scichart.charting3d.visuals.SciChartSurface3D
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart3DFragment

@ExampleDefinition()
class ZoomAndPanFreeLookModifier3D : SingleChart3DFragment() {
    override fun initExample(surface: SciChartSurface3D) {}

    fun addFreeLookModifier3D(surface: SciChartSurface3D) {
        // <AddFreeLookModifier3D>
        // Assume a surface has been created and configured somewhere
        // Create a Modifier
        val freeLookModifier3D = FreeLookModifier3D()
        freeLookModifier3D.executeOnPointerCount = 2
        freeLookModifier3D.degreesPerPixelSensitivity = 0.4f

        // Add the modifier to the surface
        surface.chartModifiers.add(freeLookModifier3D)
        // </AddFreeLookModifier3D>
    }
}
