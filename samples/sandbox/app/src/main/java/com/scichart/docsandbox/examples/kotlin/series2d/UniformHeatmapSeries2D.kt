package com.scichart.docsandbox.examples.kotlin.series2d

import com.scichart.charting.model.dataSeries.UniformHeatmapDataSeries
import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.axes.NumericAxis
import com.scichart.charting.visuals.renderableSeries.ColorMap
import com.scichart.charting.visuals.renderableSeries.FastUniformHeatmapRenderableSeries
import com.scichart.core.framework.UpdateSuspender
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment
import com.scichart.drawing.utility.ColorUtil.*
import java.util.*

@ExampleDefinition()
class UniformHeatmapSeries2D : SingleChart2DFragment() {
    // <Example>
    override fun initExample(surface: SciChartSurface) {
        val colors = intArrayOf(DarkBlue, CornflowerBlue, DarkGreen, Chartreuse, Yellow, Red )
        val stops = floatArrayOf(0f, 0.2f, 0.4f, 0.6f, 0.8f, 1f)

        val heatmapSeries = FastUniformHeatmapRenderableSeries().apply {
            dataSeries = UniformHeatmapDataSeries(
                Int::class.javaObjectType,
                Int::class.javaObjectType,
                Int::class.javaObjectType, 5, 5
            ).apply {
                for (i in 0..4) {
                    for (j in 0..4) {
                        updateZAt(i, j, i * i + j * j)
                    }
                }
            }

            colorMap = ColorMap(colors, stops)
            minimum = 0.0
            maximum = 50.0
        }

        UpdateSuspender.using(surface) {
            Collections.addAll(surface.xAxes, NumericAxis(context))
            Collections.addAll(surface.yAxes, NumericAxis(context))

            Collections.addAll(surface.renderableSeries, heatmapSeries)
        }
    }
    // </Example>
}
