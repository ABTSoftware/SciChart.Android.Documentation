package com.scichart.docsandbox.examples.kotlin.axisAPIs

import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.axes.*
import com.scichart.data.model.DateRange
import com.scichart.data.model.DoubleRange
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment
import java.util.*

@ExampleDefinition()
class AxisAPIs : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {}

    fun addNumericAxis() {
        // <AddNumericAxis>
        val axis = NumericAxis(context)
        axis.axisAlignment = AxisAlignment.Right
        axis.autoRange = AutoRange.Once
        axis.growBy = DoubleRange(0.1, 0.1)
        axis.visibleRange = DoubleRange(-45.0, 300.0)
        // </AddNumericAxis>
    }

    fun addLogarithmicNumericAxis() {
        // <AddLogarithmicNumericAxis>
        val axis = LogarithmicNumericAxis(context)
        axis.axisAlignment = AxisAlignment.Right
        axis.autoRange = AutoRange.Once
        axis.growBy = DoubleRange(0.1, 0.1)

        // Specifies how labels appear on the axis
        axis.scientificNotation = ScientificNotation.LogarithmicBase
        axis.textFormatting = "#.#E+0"

        // Specifies the logarithm base for the logarithmic scale of the axis
        axis.logarithmicBase = 10.0
        axis.visibleRange = DoubleRange(0.1, 1000.0)
        // </AddLogarithmicNumericAxis>
    }

    fun addDateAxis() {
        val calendarDateMin = Calendar.getInstance()
        calendarDateMin[2020, Calendar.MAY] = 1
        val dateMin = calendarDateMin.time
        val calendarDateMax = Calendar.getInstance()
        calendarDateMax[2021, Calendar.MAY] = 1
        val dateMax = calendarDateMax.time

        // <AddDateAxis>
        val axis = DateAxis(context)
        axis.axisAlignment = AxisAlignment.Bottom
        axis.autoRange = AutoRange.Once
        axis.growBy = DoubleRange(0.1, 0.1)
        axis.visibleRange = DateRange(dateMin, dateMax)
        // </AddDateAxis>
    }

    fun addCategoryDateAxis() {
        // <AddCategoryDateAxis>
        val axis = CategoryDateAxis(context)
        axis.axisAlignment = AxisAlignment.Top
        axis.autoRange = AutoRange.Once
        axis.growBy = DoubleRange(0.1, 0.1)
        // Set visibleRange to [min data index, max data index]
        axis.visibleRange = DoubleRange(10.0, 50.0)
        // </AddCategoryDateAxis>
    }





































}
