package com.scichart.docsandbox.examples.kotlin.axis3DAPIs

import com.scichart.charting.visuals.axes.AutoRange
import com.scichart.charting.visuals.axes.ScientificNotation
import com.scichart.charting3d.visuals.SciChartSurface3D
import com.scichart.charting3d.visuals.axes.DateAxis3D
import com.scichart.charting3d.visuals.axes.LogarithmicNumericAxis3D
import com.scichart.charting3d.visuals.axes.NumericAxis3D
import com.scichart.data.model.DateRange
import com.scichart.data.model.DoubleRange
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart3DFragment
import java.util.*

@ExampleDefinition()
class Axis3DAPIs : SingleChart3DFragment() {
    override fun initExample(surface: SciChartSurface3D) {}

    fun addNumericAxis3D(surface: SciChartSurface3D) {
        // <AddNumericAxis3D>
        val axis = NumericAxis3D()
        axis.growBy = DoubleRange(0.1, 0.1)
        axis.visibleRange = DoubleRange(-7.0, 7.0)
        // </AddNumericAxis3D>
    }

    fun addLogarithmicNumericAxis3D(surface: SciChartSurface3D) {
        // <AddLogarithmicNumericAxis3D>
        val axis = LogarithmicNumericAxis3D()
        axis.growBy = DoubleRange(0.1, 0.1)
        axis.visibleRange = DoubleRange(0.1, 1000.0)

        // Specifies how labels appear on the axis
        axis.scientificNotation = ScientificNotation.LogarithmicBase
        axis.cursorTextFormatting = "#.#E+0"

        // Specifies the logarithm base for the logarithmic scale of the axis
        axis.logarithmicBase = 10.0
        // </AddLogarithmicNumericAxis3D>
    }

    fun addDateAxis3D(surface: SciChartSurface3D) {
        val calendarDateMin = Calendar.getInstance()
        calendarDateMin.clear()
        calendarDateMin[2020, Calendar.MAY] = 1
        val dateMin = calendarDateMin.time
        val calendarDateMax = Calendar.getInstance()
        calendarDateMax.clear()
        calendarDateMax[2021, Calendar.MAY] = 1
        val dateMax = calendarDateMax.time

        // <AddDateAxis3D>
        val axis = DateAxis3D()
        axis.autoRange = AutoRange.Always
        axis.growBy = DoubleRange(0.1, 0.1)
        axis.visibleRange = DateRange(dateMin, dateMax)
        // </AddDateAxis3D>
    }
}
