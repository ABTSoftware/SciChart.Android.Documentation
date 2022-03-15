package com.scichart.docsandbox.examples.kotlin.chartModifier3D

import com.scichart.charting3d.modifiers.OrbitModifier3D
import com.scichart.charting3d.visuals.SciChartSurface3D
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart3DFragment

@ExampleDefinition()
class ZoomAndPanOrbitModifier3D : SingleChart3DFragment() {
    override fun initExample(surface: SciChartSurface3D) {}

    fun addOrbitModifier3D(surface: SciChartSurface3D) {
        // <AddOrbitModifier3D>
        // Assume a surface has been created and configured somewhere
        // Create a Modifier
        val orbitModifier3D = OrbitModifier3D()
        orbitModifier3D.degreesPerPixelSensitivity = 0.4f

        // Add the modifier to the surface
        surface.chartModifiers.add(orbitModifier3D)
        // </AddOrbitModifier3D>
    }
}
