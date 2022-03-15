package com.scichart.docsandbox.examples.kotlin.chartModifier3D

import com.scichart.charting3d.modifiers.VertexSelectionModifier3D
import com.scichart.charting3d.visuals.SciChartSurface3D
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart3DFragment

@ExampleDefinition()
class InteractivityVertexSelectionModifier3D : SingleChart3DFragment() {
    override fun initExample(surface: SciChartSurface3D) {}

    fun addVertexSelectionModifier3D(surface: SciChartSurface3D) {
        // <AddVertexSelectionModifier3D>
        // Assume a surface has been created and configured somewhere
        surface.chartModifiers.add(VertexSelectionModifier3D())
        // </AddVertexSelectionModifier3D>
    }
}
