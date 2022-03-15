package com.scichart.docsandbox.examples.kotlin.axisAPIs

import com.scichart.charting.numerics.deltaCalculators.AxisDelta
import com.scichart.charting.numerics.deltaCalculators.IAxisDelta
import com.scichart.charting.numerics.deltaCalculators.NumericDeltaCalculator
import com.scichart.charting.numerics.tickProviders.NumericTickProvider
import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.axes.NumericAxis
import com.scichart.core.model.DoubleValues
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment

@ExampleDefinition()
class AxisTicksTickProviderAndDeltaCalculatorAPI : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {}

    fun createCustomNumericDeltaCalculator() {
        // <CreateCustomNumericDeltaCalculator>
        class CustomNumericDeltaCalculator : NumericDeltaCalculator() {
            override fun getDeltaFromRange(min: Comparable<*>?, max: Comparable<*>?, minorsPerMajor: Int, maxTicks: Int): IAxisDelta<Double> {
                // For the sake of simplicity, we will use simple constants.
                // But you might want to have some complex calculations here.
                val minorDelta = 0.07
                val majorDelta = 0.1
                return AxisDelta(minorDelta, majorDelta)
            }
        }
        // </CreateCustomNumericDeltaCalculator>

        // <UseCustomNumericDeltaCalculator>
        // create a NumericTickProvider with CustomNumericDeltaCalculator and assign it to the axis
        val axis = NumericAxis(context)
        axis.tickProvider = NumericTickProvider(CustomNumericDeltaCalculator())
        // </UseCustomNumericDeltaCalculator>
    }

    fun createCustomNumericTickProvider() {
        // <CreateCustomNumericTickProvider>
        class CustomNumericTickProvider : NumericTickProvider() {
            override fun updateTicks(minorTicks: DoubleValues, majorTicks: DoubleValues) {
                val min = axis.visibleRange.minAsDouble
                val max = axis.visibleRange.maxAsDouble
                majorTicks.add(min)
                majorTicks.add((min + max) / 2)
                majorTicks.add(max)
            }
        }
        // </CreateCustomNumericTickProvider>

        // <UseCustomNumericTickProvider>
        val axis = NumericAxis(context)
        // create a CustomNumericTickProvider and assign it to the axis
        axis.tickProvider = CustomNumericTickProvider()
        // </UseCustomNumericTickProvider>
    }
}
