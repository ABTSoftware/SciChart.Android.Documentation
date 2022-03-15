package com.scichart.docsandbox.examples.kotlin.axisAPIs

import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.axes.AxisAlignment
import com.scichart.charting.visuals.axes.NumericAxis
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment

@ExampleDefinition()
class AxisAlignmentCreateAVerticalChart : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {}

    fun addAxisAlignment() {
        // <AddAxisAlignment>
        // Create X axis and position it to the left
        val xAxis = NumericAxis(context)
        xAxis.axisAlignment = AxisAlignment.Left

        // Create Y axis and position it to the top
        val yAxis = NumericAxis(context)
        yAxis.axisAlignment = AxisAlignment.Top
        // </AddAxisAlignment>
    }

    fun addMultipleAxes() {
        // <AddMultipleAxes>
        val xAxis = NumericAxis(context)
        xAxis.axisId = "xAxis"
        xAxis.axisTitle = "Horizontal-X"

        val xLeftAxis = NumericAxis(context)
        xLeftAxis.axisId = "xLeftAxis"
        xLeftAxis.axisAlignment = AxisAlignment.Left
        xLeftAxis.axisTitle = "Vertical-X"

        val yAxis = NumericAxis(context)
        yAxis.axisId = "yAxis"
        yAxis.axisTitle = "Vertical-Y"

        val yTopAxis = NumericAxis(context)
        yTopAxis.axisId = "yTopAxis"
        yTopAxis.axisAlignment = AxisAlignment.Top
        yTopAxis.axisTitle = "Horizontal-Y"
        // </AddMultipleAxes>
    }
}
