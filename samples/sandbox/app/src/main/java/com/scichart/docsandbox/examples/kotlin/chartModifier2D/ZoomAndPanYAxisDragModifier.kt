package com.scichart.docsandbox.examples.kotlin.chartModifier2D

import com.scichart.charting.modifiers.AxisDragModifierBase
import com.scichart.charting.modifiers.YAxisDragModifier
import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.axes.IAxis
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment

@ExampleDefinition()
class ZoomAndPanYAxisDragModifier : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {}

    fun addYAxisDragModifier(surface: SciChartSurface) {
        // <AddYAxisDragModifier>
        // Assume a surface has been created and configured somewhere
        // Create a Modifier
        val yAxisDragModifier = YAxisDragModifier()
        yAxisDragModifier.dragMode = AxisDragModifierBase.AxisDragMode.Pan

        // Add the modifier to the surface
        surface.chartModifiers.add(yAxisDragModifier)
        // </AddYAxisDragModifier>
    }

    fun includeExcludeAxis(yAxisDragModifier: YAxisDragModifier, xAxis: IAxis, yAxis: IAxis) {
        // <IncludeExcludeAxis>
        // Assume a yAxisDragModifier has been created and configured somewhere

        // To include/exclude an X axis in the yAxisDragModifier (true = include, false = exclude)
        yAxisDragModifier.includeXAxis(xAxis, true)
        yAxisDragModifier.includeXAxis(xAxis, false)

        // To include/exclude an Y axis from the yAxisDragModifier (true = include, false = exclude)
        yAxisDragModifier.includeYAxis(yAxis, true)
        yAxisDragModifier.includeYAxis(yAxis, false)

        // To include all X and Y axes to the yAxisDragModifier
        yAxisDragModifier.includeAllAxes()
        // </IncludeExcludeAxis>
    }
}

