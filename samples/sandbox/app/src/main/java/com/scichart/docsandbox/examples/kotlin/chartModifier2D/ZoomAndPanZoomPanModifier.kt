package com.scichart.docsandbox.examples.kotlin.chartModifier2D

import com.scichart.charting.ClipMode
import com.scichart.charting.Direction2D
import com.scichart.charting.modifiers.ZoomPanModifier
import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.axes.IAxis
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment

@ExampleDefinition()
class ZoomAndPanZoomPanModifier : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {}

    fun addZoomPanModifier(surface: SciChartSurface) {
        // <AddZoomPanModifier>
        // Assume a surface has been created and configured somewhere
        // Create a Modifier
        val zoomPanModifier = ZoomPanModifier()
        zoomPanModifier.direction = Direction2D.XDirection
        zoomPanModifier.clipModeX = ClipMode.StretchAtExtents
        zoomPanModifier.clipModeY = ClipMode.None
        zoomPanModifier.zoomExtentsY = true

        // Add the modifier to the surface
        surface.chartModifiers.add(zoomPanModifier)
        // </AddZoomPanModifier>
    }

    fun includeExcludeAxis(zoomPanModifier: ZoomPanModifier, xAxis: IAxis, yAxis: IAxis) {
        // <IncludeExcludeAxis>
        // Assume a zoomPanModifier has been created and configured somewhere

        // To include/exclude an X axis in the zoomPanModifier (true = include, false = exclude)
        zoomPanModifier.includeXAxis(xAxis, true)
        zoomPanModifier.includeXAxis(xAxis, false)

        // To include/exclude an Y axis from the zoomPanModifier (true = include, false = exclude)
        zoomPanModifier.includeYAxis(yAxis, true)
        zoomPanModifier.includeYAxis(yAxis, false)

        // To include all X and Y axes to the zoomPanModifier
        zoomPanModifier.includeAllAxes()
        // </IncludeExcludeAxis>
    }
}
