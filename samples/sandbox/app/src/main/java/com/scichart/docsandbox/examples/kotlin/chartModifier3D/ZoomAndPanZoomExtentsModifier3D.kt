package com.scichart.docsandbox.examples.kotlin.chartModifier3D

import com.scichart.charting.modifiers.ExecuteOn
import com.scichart.charting3d.common.math.Vector3
import com.scichart.charting3d.modifiers.ZoomExtentsModifier3D
import com.scichart.charting3d.visuals.SciChartSurface3D
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart3DFragment

@ExampleDefinition()
class ZoomAndPanZoomExtentsModifier3D : SingleChart3DFragment() {
    override fun initExample(surface: SciChartSurface3D) {}

    fun addZoomExtentsModifier(surface: SciChartSurface3D) {
        // <AddZoomExtentsModifier>
        // Assume a surface has been created and configured somewhere
        // Create a Modifier
        val zoomExtentsModifier = ZoomExtentsModifier3D()
        zoomExtentsModifier.executeOn = ExecuteOn.DoubleTap
        zoomExtentsModifier.autoFitRadius = false
        zoomExtentsModifier.resetPosition = Vector3(200f, 200f, 200f)
        zoomExtentsModifier.resetTarget = Vector3(0f, 0f, 0f)

        // Add the modifier to the surface
        surface.chartModifiers.add(zoomExtentsModifier)
        // </AddZoomExtentsModifier>
    }
}
