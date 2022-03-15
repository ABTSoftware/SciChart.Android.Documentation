package com.scichart.docsandbox.examples.kotlin.axis3DAPIs

import com.scichart.charting3d.visuals.SciChartSurface3D
import com.scichart.charting3d.visuals.axes.DateAxis3D
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart3DFragment
import java.util.*

@ExampleDefinition()
class Axis3DAPIsConvertWorldToDataCoordinates : SingleChart3DFragment() {
    override fun initExample(surface: SciChartSurface3D) {}

    fun numericAxis3DConversions() {
        val yAxis = DateAxis3D()
        // <NumericAxis3DConversions>
        val calculator = yAxis.currentCoordinateCalculator
        val coordinate = calculator.getCoordinate(50.0)

        // Convert back:
        val dataValue = calculator.getDataValue(coordinate)
        // </NumericAxis3DConversions>
    }

    fun dateAxis3DConversions() {
        val zAxis = DateAxis3D()
        // <DateAxis3DConversions>
        val calculator = zAxis.currentCoordinateCalculator
        val calendarDate = Calendar.getInstance()
        calendarDate[2011, Calendar.MAY] = 5
        val date = calendarDate.time
        val coordinate = calculator.getCoordinate(date.time.toDouble())

        // Convert back:
        val dateInMillis = calculator.getDataValue(coordinate)
        val dateValue = Date(dateInMillis.toLong())
        // </DateAxis3DConversions>
    }
}
