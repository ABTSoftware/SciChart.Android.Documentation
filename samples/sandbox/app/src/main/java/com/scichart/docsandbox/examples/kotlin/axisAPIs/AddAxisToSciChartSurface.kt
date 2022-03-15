package com.scichart.docsandbox.examples.kotlin.axisAPIs

import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.axes.AxisAlignment
import com.scichart.charting.visuals.axes.NumericAxis
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment

@ExampleDefinition()
class AddAxisToSciChartSurface : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {}

    fun addingAxes(surface: SciChartSurface) {
        // <AddingAxes>
        // Create numeric X axis
        val xAxis = NumericAxis(context)
        // Create numeric Y axis
        val yAxis = NumericAxis(context)

        // Add the Y and X axes to the axis collections of the ChartSurface
        surface.xAxes.add(xAxis)
        surface.yAxes.add(yAxis)
        // </AddingAxes>
    }

    fun addAxisAlignment() {
        val xAxis = NumericAxis(context)
        val yAxis = NumericAxis(context)

        // <AddAxisAlignment>
        xAxis.axisAlignment = AxisAlignment.Bottom
        yAxis.axisAlignment = AxisAlignment.Left
        // </AddAxisAlignment>
    }
}
