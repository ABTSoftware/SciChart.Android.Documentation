package com.scichart.docsandbox.examples.kotlin.axisAPIs

import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.axes.DateAxis
import com.scichart.charting.visuals.axes.LogarithmicNumericAxis
import com.scichart.charting.visuals.axes.NumericAxis
import com.scichart.charting.visuals.axes.ScientificNotation
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment

@ExampleDefinition()
class AxisLabelsTextRotationAndAxisSize : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {}

    fun addAxisRotation(){
        // <AddAxisLabelRotation>
        val xAxis = NumericAxis(context)
        xAxis.axisLabelRotation = 30 // Rotate 30 degrees

        val yAxis = NumericAxis(context)
        yAxis.axisLabelRotation = -30 // You can also rotate in other direction
        // </AddAxisLabelRotation>
    }

    fun changeAxisSize(){
        // <AddAxisSize>
        val xAxis = NumericAxis(context)
        xAxis.fixedSize = 200 // Set height of the horizontal axis to 200

        val yAxis = NumericAxis(context)
        yAxis.fixedSize = 200 // Set width of the vertical axis to 200
        // </AddAxisSize>
    }
}