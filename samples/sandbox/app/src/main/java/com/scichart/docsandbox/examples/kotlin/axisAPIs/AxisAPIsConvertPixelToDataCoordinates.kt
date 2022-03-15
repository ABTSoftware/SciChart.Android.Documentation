package com.scichart.docsandbox.examples.kotlin.axisAPIs

import android.graphics.PointF
import com.scichart.charting.numerics.labelProviders.ICategoryLabelProvider
import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.axes.CategoryDateAxis
import com.scichart.charting.visuals.axes.DateAxis
import com.scichart.charting.visuals.axes.NumericAxis
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment
import java.util.*

@ExampleDefinition()
class AxisAPIsConvertPixelToDataCoordinates : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {}

    fun numericAxisConversions() {
        val xAxis = NumericAxis(context)
        // <NumericAxisConversions>
        val coordinate = xAxis.getCoordinate(1.2)

        // Convert back:
        val dataValue = xAxis.getDataValue(coordinate)
        // </NumericAxisConversions>
    }

    fun dateAxisConversions() {
        // <DateAxisConversions>
        val xAxis = DateAxis(context)

        val calendarDate = Calendar.getInstance()
        calendarDate[2011, Calendar.MAY] = 1
        val date = calendarDate.time

        val coordinate = xAxis.getCoordinate(date)

        // Convert back:
        val dataValue = xAxis.getDataValue(coordinate)
        // </DateAxisConversions>
    }

    fun categoryDateAxisConversions() {
        // <CategoryDateAxisConversions>
        val xAxis = CategoryDateAxis(context)

        val calendarDate = Calendar.getInstance()
        calendarDate[2011, Calendar.OCTOBER] = 5

        val date = calendarDate.time

        val coordinate = xAxis.getCoordinate(date)

        // Convert back:
        val dataValue = xAxis.getDataValue(coordinate)
        // </CategoryDateAxisConversions>
    }

    fun numericAxisCoordinateCalculator() {
        // <NumericAxisCoordinateCalculator>
        val xAxis = NumericAxis(context)

        val calculator = xAxis.currentCoordinateCalculator
        val coordinate = calculator.getCoordinate(1.2)

        // Convert back:
        val dataValue = calculator.getDataValue(coordinate)
        // </NumericAxisCoordinateCalculator>
    }

    fun dateAxisCoordinateCalculator() {
        // <DateAxisCoordinateCalculator>
        val xAxis = DateAxis(context)
        val calculator = xAxis.currentCoordinateCalculator

        val calendarDate = Calendar.getInstance()
        calendarDate[2011, Calendar.MAY] = 5
        val date = calendarDate.time

        val coordinate = calculator.getCoordinate(date.time.toDouble())

        // Convert back:
        val dateInMillis = calculator.getDataValue(coordinate)
        val dateValue = Date(dateInMillis.toLong())
        // </DateAxisCoordinateCalculator>
    }

    fun categoryDateAxisCoordinateCalculator() {
        // <CategoryDateAxisCoordinateCalculator>
        val xAxis = CategoryDateAxis(context)
        val calculator = xAxis.currentCoordinateCalculator

        // get ICategoryLabelProvider to convert Date value to Index
        val labelProvider = xAxis.labelProvider as ICategoryLabelProvider

        val calendarDate = Calendar.getInstance()
        calendarDate[2011, Calendar.OCTOBER] = 5
        var date = calendarDate.time

        var index = labelProvider.transformDataToIndex(date.time.toDouble())
        val coordinate = calculator.getCoordinate(index.toDouble()).toDouble()

        // Convert back:
        index = calculator.getDataValue(coordinate.toFloat()).toInt()
        // use the ICategoryLabelProvider instance to convert index to Date value
        date = Date(labelProvider.transformIndexToData(index).toLong())
        // </CategoryDateAxisCoordinateCalculator>
    }

    fun transformingPixels() {
        val xAxis = NumericAxis(context)

        // <TransformingPixels>
        val surface = SciChartSurface(activity)
        surface.setOnTouchListener { v, event -> // the touch point relative to the SciChartSurface
            val touchPoint = PointF(event.x, event.y)

            // translate the touch point relative to RenderableSeriesArea or ModifierSurface
            surface.translatePoint(touchPoint, surface.renderableSeriesArea)

            //OR surface.translatePoint(touchPoint, surface.getModifierSurface());
            // the translated point can be used for looking for data values
            val dataValue = xAxis.getDataValue(touchPoint.x) as Double

            true
        }
        // </TransformingPixels>
    }
}
