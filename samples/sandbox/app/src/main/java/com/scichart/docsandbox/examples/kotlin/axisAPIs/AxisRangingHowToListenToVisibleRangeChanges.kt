package com.scichart.docsandbox.examples.kotlin.axisAPIs

import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.axes.NumericAxis
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment

@ExampleDefinition()
class AxisRangingHowToListenToVisibleRangeChanges : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {}

    fun setVisibleRangeChangeListener() {
        // <SetVisibleRangeChangeListener>
        val axis = NumericAxis(context)
        axis.setVisibleRangeChangeListener { axis, oldRange, newRange, isAnimating ->
            // TODO handle range changes here
        }
        // </SetVisibleRangeChangeListener>
    }
}
