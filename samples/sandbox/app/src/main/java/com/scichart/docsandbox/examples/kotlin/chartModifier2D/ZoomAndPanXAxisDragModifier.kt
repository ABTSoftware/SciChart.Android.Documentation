package com.scichart.docsandbox.examples.kotlin.chartModifier2D

import com.scichart.charting.ClipMode
import com.scichart.charting.ClipModeTarget
import com.scichart.charting.modifiers.AxisDragModifierBase
import com.scichart.charting.modifiers.XAxisDragModifier
import com.scichart.charting.visuals.SciChartSurface
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment

@ExampleDefinition()
class ZoomAndPanXAxisDragModifier : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {}

    fun addXAxisDragModifier(surface: SciChartSurface) {
        // <AddXAxisDragModifier>
        // Assume a surface has been created and configured somewhere
        // Create a Modifier
        val xAxisDragModifier = XAxisDragModifier()
        xAxisDragModifier.dragMode = AxisDragModifierBase.AxisDragMode.Pan
        xAxisDragModifier.clipModeX = ClipMode.StretchAtExtents
        xAxisDragModifier.clipModeTargetX = ClipModeTarget.MaximumRange

        // Add the modifier to the surface
        surface.chartModifiers.add(xAxisDragModifier)
        // </AddXAxisDragModifier>
    }
}

