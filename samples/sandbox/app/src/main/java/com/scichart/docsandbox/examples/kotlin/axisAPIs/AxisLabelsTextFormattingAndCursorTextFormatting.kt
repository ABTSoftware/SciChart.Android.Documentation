package com.scichart.docsandbox.examples.kotlin.axisAPIs

import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.axes.DateAxis
import com.scichart.charting.visuals.axes.LogarithmicNumericAxis
import com.scichart.charting.visuals.axes.NumericAxis
import com.scichart.charting.visuals.axes.ScientificNotation
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment

@ExampleDefinition()
class AxisLabelsTextFormattingAndCursorTextFormatting : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {}

    fun addTextFormatting() {
        // <AddTextFormatting>
        val xAxis = DateAxis(context)
        xAxis.textFormatting = "dd.MMM"

        val yAxis = NumericAxis(context)
        yAxis.textFormatting = "$0.0"
        // </AddTextFormatting>
    }

    fun addCursorTextFormatting() {
        // <AddCursorTextFormatting>
        val xAxis = DateAxis(context)
        xAxis.cursorTextFormatting = "'X Value:'dd.MM.yyyy"

        val yAxis = NumericAxis(context)
        yAxis.cursorTextFormatting = "'Price:'###.##' $'"
        // </AddCursorTextFormatting>
    }

    fun addScientificNotation() {
        // <AddScientificNotation>
        val xAxis = LogarithmicNumericAxis(context)
        xAxis.logarithmicBase = 10.0
        xAxis.scientificNotation = ScientificNotation.LogarithmicBase
        xAxis.textFormatting = "#.#E+0"
        xAxis.cursorTextFormatting = "#.#E+0"
        // </AddScientificNotation>
    }
}
