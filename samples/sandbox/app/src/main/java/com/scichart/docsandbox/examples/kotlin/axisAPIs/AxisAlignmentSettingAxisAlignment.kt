package com.scichart.docsandbox.examples.kotlin.axisAPIs

import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.axes.AxisAlignment
import com.scichart.charting.visuals.axes.NumericAxis
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment

@ExampleDefinition()
class AxisAlignmentSettingAxisAlignment : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {}

    fun addAxisAlignment() {
        // <AddAxisAlignment>
        val xTopAxis = NumericAxis(context)
        xTopAxis.axisId = "TopAxisId"
        xTopAxis.axisAlignment = AxisAlignment.Top

        val xBottomAxis = NumericAxis(context)
        xBottomAxis.axisId = "BottomAxisId"
        xBottomAxis.axisAlignment = AxisAlignment.Bottom

        val yLeftAxis = NumericAxis(context)
        yLeftAxis.axisId = "LeftAxisId"
        yLeftAxis.axisAlignment = AxisAlignment.Left

        val yRightAxis = NumericAxis(context)
        yRightAxis.axisId = "RightAxisId"
        yRightAxis.axisAlignment = AxisAlignment.Right
        // </AddAxisAlignment>
    }
}
