package com.scichart.docsandbox.examples.kotlin.axisAPIs

import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.axes.NumericAxis
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment

@ExampleDefinition()
class AxisTicksMajorDeltaMinorDeltaAndAutoTicks : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {}

    fun automaticTickSpacing() {
        // <AutomaticTickSpacing>
        val axis = NumericAxis(context)
        // change max possible auto ticks amount (the default is 10)
        axis.maxAutoTicks = 20
        // specify that there should be 10 Minor Ticks between two Major Ticks (the default is 5)
        axis.minorsPerMajor = 10
        // </AutomaticTickSpacing>
    }

    fun alteringTickSpacing() {
        // <AlteringTickSpacing>
        val axis = NumericAxis(context)
        axis.autoTicks = false
        axis.minorDelta = 2
        axis.majorDelta = 10
        // </AlteringTickSpacing>
    }
}
