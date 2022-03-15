package com.scichart.docsandbox.examples.kotlin.chartModifier2D

import com.scichart.charting.Direction2D
import com.scichart.charting.modifiers.ExecuteOn
import com.scichart.charting.modifiers.ZoomExtentsModifier
import com.scichart.charting.visuals.SciChartSurface
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment

@ExampleDefinition()
class ZoomAndPanZoomExtentsModifier : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {}

    fun addZoomExtentsModifier(surface: SciChartSurface) {
        // <AddZoomExtentsModifier>
        // Assume a surface has been created and configured somewhere
        // Create a Modifier
        val zoomExtentsModifier = ZoomExtentsModifier()
        zoomExtentsModifier.direction = Direction2D.XDirection
        zoomExtentsModifier.executeOn = ExecuteOn.DoubleTap
        zoomExtentsModifier.isAnimated = true

        // Add the modifier to the surface
        surface.chartModifiers.add(zoomExtentsModifier)
        // </AddZoomExtentsModifier>
    }
}

