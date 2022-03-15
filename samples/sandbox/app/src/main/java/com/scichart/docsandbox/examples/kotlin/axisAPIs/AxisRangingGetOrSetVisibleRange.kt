package com.scichart.docsandbox.examples.kotlin.axisAPIs

import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.axes.NumericAxis
import com.scichart.data.model.DoubleRange
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment

@ExampleDefinition()
class AxisRangingGetOrSetVisibleRange : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {}

    fun setGrowBy() {
        // <SetGrowBy>
        val axis = NumericAxis(context)
        axis.growBy = DoubleRange(0.1, 0.1)
        axis.visibleRange = DoubleRange(0.0, 10.0)
        // </SetGrowBy>
    }
}
