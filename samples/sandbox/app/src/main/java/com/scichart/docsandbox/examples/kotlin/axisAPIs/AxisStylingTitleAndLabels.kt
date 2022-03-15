package com.scichart.docsandbox.examples.kotlin.axisAPIs

import android.view.Gravity
import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.axes.AxisAlignment
import com.scichart.charting.visuals.axes.AxisTickLabelStyle
import com.scichart.charting.visuals.axes.AxisTitlePlacement
import com.scichart.charting.visuals.axes.NumericAxis
import com.scichart.data.model.DoubleRange
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment
import com.scichart.drawing.common.FontStyle

@ExampleDefinition()
class AxisStylingTitleAndLabels : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {}

    fun setAxisLabels() {
        // <SetAxisLabels>
        val xTopAxis = NumericAxis(context)
        xTopAxis.axisId = "TopAxisId"
        xTopAxis.axisAlignment = AxisAlignment.Top
        xTopAxis.axisTitle = "Top Axis"
        xTopAxis.axisTitleGravity = Gravity.BOTTOM
        xTopAxis.titleStyle = FontStyle(18f, -0xd864d9)
        xTopAxis.tickLabelStyle = FontStyle(12f, -0xd864d9)

        val xBottomAxis = NumericAxis(context)
        xBottomAxis.axisId = "BottomAxisId"
        xBottomAxis.axisAlignment = AxisAlignment.Bottom
        xBottomAxis.axisTitle = "Bottom Axis"
        xBottomAxis.titleStyle = FontStyle(18f, -0xe6e7)
        xBottomAxis.tickLabelStyle = FontStyle(12f, -0xe6e7)

        val yLeftAxis = NumericAxis(context)
        yLeftAxis.axisId = "LeftAxisId"
        yLeftAxis.growBy = DoubleRange(0.1, 0.1)
        yLeftAxis.axisAlignment = AxisAlignment.Left
        yLeftAxis.axisTitle = "Left Axis"
        yLeftAxis.axisTitleGravity = Gravity.TOP
        yLeftAxis.axisTitlePlacement = AxisTitlePlacement.Inside
        yLeftAxis.setAxisTitleMargins(20, 5, 0, 0)
        yLeftAxis.titleStyle = FontStyle(18f, -0x363d7)
        yLeftAxis.tickLabelStyle = FontStyle(12f, -0x363d7)
        yLeftAxis.axisTickLabelStyle = AxisTickLabelStyle(Gravity.CENTER, 5, 0, 5, 0)

        val yRightAxis = NumericAxis(context)
        yRightAxis.axisId = "RightAxisId"
        yRightAxis.growBy = DoubleRange(0.1, 0.1)
        yRightAxis.axisAlignment = AxisAlignment.Right
        yRightAxis.setIsCenterAxis(true)
        yRightAxis.axisTitle = "Right Axis"
        yRightAxis.axisTitleGravity = Gravity.BOTTOM
        yRightAxis.axisTitlePlacement = AxisTitlePlacement.Left
        yRightAxis.titleStyle = FontStyle(18f, -0xbf7c49)
        yRightAxis.tickLabelStyle = FontStyle(12f, -0xbf7c49)
        // </SetAxisLabels>
    }
}
