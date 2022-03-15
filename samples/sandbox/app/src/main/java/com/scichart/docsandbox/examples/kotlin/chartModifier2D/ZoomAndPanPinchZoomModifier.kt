package com.scichart.docsandbox.examples.kotlin.chartModifier2D

import com.scichart.charting.Direction2D
import com.scichart.charting.modifiers.PinchZoomModifier
import com.scichart.charting.visuals.SciChartSurface
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment

@ExampleDefinition()
class ZoomAndPanPinchZoomModifier : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {}

    fun addPinchZoomModifier2(surface: SciChartSurface) {
        // <AddPinchZoomModifier2>
        // Assume a surface has been created and configured somewhere
        // Create a Modifier
        val pinchZoomModifier = PinchZoomModifier()
        pinchZoomModifier.direction = Direction2D.XDirection
        pinchZoomModifier.scaleFactor = 1.5f

        // Add the modifier to the surface
        surface.chartModifiers.add(pinchZoomModifier)
        // </AddPinchZoomModifier2>
    }


}

