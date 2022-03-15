package com.scichart.docsandbox.examples.kotlin.series2d

import android.graphics.Color
import com.scichart.charting.model.dataSeries.IXyDataSeries
import com.scichart.charting.model.dataSeries.XyDataSeries
import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.axes.NumericAxis
import com.scichart.charting.visuals.renderableSeries.HorizontallyStackedColumnsCollection
import com.scichart.charting.visuals.renderableSeries.StackedColumnRenderableSeries
import com.scichart.charting.visuals.renderableSeries.VerticallyStackedColumnsCollection
import com.scichart.core.framework.UpdateSuspender
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment
import com.scichart.drawing.common.SolidBrushStyle
import com.scichart.drawing.common.SolidPenStyle
import java.util.*

@ExampleDefinition()
class StackedColumnSeries2D : SingleChart2DFragment() {
    // <Example>
    override fun initExample(surface: SciChartSurface) {
        // declare arrays with data to append
        val porkData = doubleArrayOf(10.0, 13.0, 7.0, 16.0, 4.0, 6.0, 20.0, 14.0, 16.0, 10.0, 24.0, 11.0)
        val vealData = doubleArrayOf(12.0, 17.0, 21.0, 15.0, 19.0, 18.0, 13.0, 21.0, 22.0, 20.0, 5.0, 10.0)
        val tomatoesData = doubleArrayOf(7.0, 30.0, 27.0, 24.0, 21.0, 15.0, 17.0, 26.0, 22.0, 28.0, 21.0, 22.0)
        val cucumberData = doubleArrayOf(16.0, 10.0, 9.0, 8.0, 22.0, 14.0, 12.0, 27.0, 25.0, 23.0, 17.0, 17.0)
        val pepperData = doubleArrayOf(7.0, 24.0, 21.0, 11.0, 19.0, 17.0, 14.0, 27.0, 26.0, 22.0, 28.0, 16.0)

        val data = 1992.0
        // declare and append data into data series
        val ds1: IXyDataSeries<Double, Double> = XyDataSeries(
            Double::class.javaObjectType,
            Double::class.javaObjectType
        ).apply {
            porkData.forEachIndexed {i, value -> append(data + i, value)}
        }
        val ds2: IXyDataSeries<Double, Double> = XyDataSeries(
            Double::class.javaObjectType,
            Double::class.javaObjectType
        ).apply {
            vealData.forEachIndexed {i, value -> append(data + i, value)}
        }
        val ds3: IXyDataSeries<Double, Double> = XyDataSeries(
            Double::class.javaObjectType,
            Double::class.javaObjectType
        ).apply {
            tomatoesData.forEachIndexed {i, value -> append(data + i, value)}
        }
        val ds4: IXyDataSeries<Double, Double> = XyDataSeries(
            Double::class.javaObjectType,
            Double::class.javaObjectType
        ).apply {
            cucumberData.forEachIndexed {i, value -> append(data + i, value)}
        }
        val ds5: IXyDataSeries<Double, Double> = XyDataSeries(
            Double::class.javaObjectType,
            Double::class.javaObjectType
        ).apply {
            pepperData.forEachIndexed {i, value -> append(data + i, value)}
        }

        // declare few StackedColumnRenderableSeries and assign data series to draw
        val porkSeries = createStackedColumn(ds1, -0xdd9049)
        val vealSeries = createStackedColumn(ds2, -0x65d2)
        val tomatoSeries = createStackedColumn(ds3, -0x23bbc1)
        val cucumberSeries = createStackedColumn(ds4, -0x552cb1)
        val pepperSeries = createStackedColumn(ds5, -0x7a9d4c)

        // wrap porkSeries and vealSeries into VerticallyStackedColumnCollection to stack them vertically
        val verticalCollection1 = VerticallyStackedColumnsCollection().apply {
            add(porkSeries)
            add(vealSeries)
        }

        // wrap cucumberSeries, cucumberSeries and pepperSeriesinto VerticallyStackedColumnCollection to stack them vertically
        val verticalCollection2 = VerticallyStackedColumnsCollection().apply {
            add(tomatoSeries)
            add(cucumberSeries)
            add(pepperSeries)
        }

        // wrap previously created VerticallyStackedColumnCollection into HorizontallyStackedColumnsCollection to stack resulting series horizontally
        val columnsCollection = HorizontallyStackedColumnsCollection().apply {
            add(verticalCollection1)
            add(verticalCollection2)

            spacing = 0.0
        }

        UpdateSuspender.using(surface) {
            Collections.addAll(surface.xAxes, NumericAxis(context))
            Collections.addAll(surface.yAxes, NumericAxis(context))

            Collections.addAll(surface.renderableSeries, columnsCollection)
        }
    }

    private fun createStackedColumn(
        ds: IXyDataSeries<Double, Double>,
        fill: Int
    ): StackedColumnRenderableSeries? {
        return StackedColumnRenderableSeries().apply {
            dataSeries = ds
            fillBrushStyle = SolidBrushStyle(fill)
            strokeStyle = SolidPenStyle(Color.TRANSPARENT, true, 0f, null)
        }
    }
    // </Example>
}
