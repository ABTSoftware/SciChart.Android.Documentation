package com.scichart.docsandbox.examples.kotlin.axisAPIs

import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.axes.AutoRange
import com.scichart.charting.visuals.axes.NumericAxis
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment

@ExampleDefinition()
class AxisRangingAutoRange : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {}

    fun setAutoRangeOnce() {
        // <SetAutoRangeOnce>
        val axis = NumericAxis(context)
        axis.autoRange = AutoRange.Once
        // </SetAutoRangeOnce>
    }

    fun setAutoRangeAlways() {
        // <SetAutoRangeAlways>
        val axis = NumericAxis(context)
        axis.autoRange = AutoRange.Always
        // </SetAutoRangeAlways>
    }

    fun setAutoRangeNever() {
        // <SetAutoRangeNever>
        val axis = NumericAxis(context)
        axis.autoRange = AutoRange.Never
        // </SetAutoRangeNever>
    }
}
