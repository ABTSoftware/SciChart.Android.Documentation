package com.scichart.docsandbox.examples.kotlin.series2d

import com.scichart.charting.model.dataSeries.IXyDataSeries
import com.scichart.charting.model.dataSeries.XyDataSeries
import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.axes.NumericAxis
import com.scichart.charting.visuals.renderableSeries.StackedMountainRenderableSeries
import com.scichart.charting.visuals.renderableSeries.VerticallyStackedMountainsCollection
import com.scichart.core.framework.UpdateSuspender
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment
import com.scichart.drawing.common.LinearGradientBrushStyle
import java.util.*

@ExampleDefinition()
class StackedMountainSeries2D : SingleChart2DFragment() {
    // <Example>
    override fun initExample(surface: SciChartSurface) {
        // declare arrays with data to append
        val yValues1 = doubleArrayOf(4.0, 7.0, 5.2, 9.4, 3.8, 5.1, 7.5, 12.4, 14.6, 8.1, 11.7, 14.4, 16.0, 3.7, 5.1, 6.4, 3.5, 2.5, 12.4, 16.4, 7.1, 8.0, 9.0)
        val yValues2 = doubleArrayOf(15.0, 10.1, 10.2, 10.4, 10.8, 1.1, 11.5, 3.4, 4.6, 0.1, 1.7, 14.4, 6.0, 13.7, 10.1, 8.4, 8.5, 12.5, 1.4, 0.4, 10.1, 5.0, 1.0)

        // declare and append data into data series
        val ds1: IXyDataSeries<Double, Double> = XyDataSeries(
            Double::class.javaObjectType,
            Double::class.javaObjectType
        ).apply {
            yValues1.forEachIndexed { i, value ->
                append(i.toDouble(), value)
            }
        }
        val ds2: IXyDataSeries<Double, Double> = XyDataSeries(
            Double::class.javaObjectType,
            Double::class.javaObjectType
        ).apply {
            yValues2.forEachIndexed { i, value ->
                append(i.toDouble(), value)
            }
        }

        // wrap declared renderable series into VerticallyStackedMountainCollection to stack them vertically
        val seriesCollection = VerticallyStackedMountainsCollection().apply {
            add(createStackedMountain(ds1, -0x22241f1f, -0x77493e3d))
            add(createStackedMountain(ds2, -0x22534336, -0x77bc6551))
        }

        UpdateSuspender.using(surface) {
            Collections.addAll(surface.xAxes, NumericAxis(context))
            Collections.addAll(surface.yAxes, NumericAxis(context))

            Collections.addAll(surface.renderableSeries, seriesCollection)
        }
    }

    private fun createStackedMountain(
        ds: IXyDataSeries<Double, Double>,
        gradientStart: Int,
        gradientEnd: Int
    ): StackedMountainRenderableSeries? {
        return StackedMountainRenderableSeries().apply {
            dataSeries = ds
            areaStyle = LinearGradientBrushStyle(
                0f, 0f,
                0f, 1f,
                gradientStart, gradientEnd
            )
        }
    }
    // </Example>
}
