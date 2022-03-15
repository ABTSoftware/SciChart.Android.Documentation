package com.scichart.docsandbox.examples.kotlin.axisAPIs

import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.axes.NumericAxis
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment
import com.scichart.drawing.common.SolidBrushStyle
import com.scichart.drawing.common.SolidPenStyle

@ExampleDefinition()
class AxisStylingGridLinesTicksAndAxisBands : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {}

    fun setTickLineStyle() {
        // <SetTickLineStyle>
        val axis = NumericAxis(context)
        axis.minorTickLineStyle = SolidPenStyle(-0xd864d9, true, 2f, null)
        axis.majorTickLineStyle = SolidPenStyle(-0xd864d9, true, 4f, null)
        // </SetTickLineStyle>
    }

    fun setGridLineStyle() {
        // <SetGridLineStyle>
        val axis = NumericAxis(context)
        axis.minorGridLineStyle = SolidPenStyle(0x33279B27, true, 1f, null)
        axis.majorGridLineStyle = SolidPenStyle(-0xd864d9, true, 3f, floatArrayOf(5f, 15f))
        // </SetGridLineStyle>
    }

    fun setAxisBandsStyle() {
        // <SetAxisBandsStyle>
        val axis = NumericAxis(context)
        axis.axisBandsStyle = SolidBrushStyle(0x22279B27)
        // </SetAxisBandsStyle>
    }
}
