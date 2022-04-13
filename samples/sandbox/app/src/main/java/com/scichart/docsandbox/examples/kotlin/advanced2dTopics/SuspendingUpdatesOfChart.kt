package com.scichart.docsandbox.examples.kotlin.advanced2dTopics

import com.scichart.charting.model.dataSeries.IXyDataSeries
import com.scichart.charting.model.dataSeries.XyDataSeries
import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.axes.NumericAxis
import com.scichart.charting.visuals.renderableSeries.FastLineRenderableSeries
import com.scichart.core.framework.UpdateSuspender
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment
import java.util.*

@ExampleDefinition
class SuspendingUpdatesOfChart : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {}

    fun suspendingUpdates(surface: SciChartSurface) {
        val dataSeries: IXyDataSeries<Double, Double> = XyDataSeries(Double::class.java, Double::class.java)
        val x1 = 0.0; val y1 = 0.0
        val x2 = 1.0; val y2 = 1.0
        val x3 = 2.0; val y4 = 2.0

        val xAxis = NumericAxis(requireContext())
        val yAxis = NumericAxis(requireContext())

        val rSeries = FastLineRenderableSeries()

        // <SuspendingUpdates>
        // use try-with-resources statement
        try {
            surface.suspendUpdates().use { suspender ->
                dataSeries.append(x1, y1)
                dataSeries.append(x2, y2)
                dataSeries.append(x3, y4)
                Collections.addAll(surface.xAxes, xAxis)
                Collections.addAll(surface.yAxes, yAxis)
                Collections.addAll(surface.renderableSeries, rSeries)
            }
        } catch (e: Exception) {
        }

        //or use UpdateSuspender.using() which does the same thing
        UpdateSuspender.using(surface) {
            dataSeries.append(x1, y1)
            dataSeries.append(x2, y2)
            dataSeries.append(x3, y4)
            Collections.addAll(surface.xAxes, xAxis)
            Collections.addAll(surface.yAxes, yAxis)
            Collections.addAll(surface.renderableSeries, rSeries)
        }
        // </SuspendingUpdates>
    }
}