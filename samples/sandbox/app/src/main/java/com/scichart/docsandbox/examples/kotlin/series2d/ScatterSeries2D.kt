package com.scichart.docsandbox.examples.kotlin.series2d

import android.graphics.Color
import com.scichart.charting.model.dataSeries.XyDataSeries
import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.axes.NumericAxis
import com.scichart.charting.visuals.pointmarkers.EllipsePointMarker
import com.scichart.charting.visuals.renderableSeries.XyScatterRenderableSeries
import com.scichart.core.framework.UpdateSuspender
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment
import com.scichart.drawing.common.SolidBrushStyle
import java.util.*

@ExampleDefinition()
class ScatterSeries2D : SingleChart2DFragment() {
    // <Example>
    override fun initExample(surface: SciChartSurface) {
        val scatterSeries = XyScatterRenderableSeries().apply {
            dataSeries = XyDataSeries(Double::class.javaObjectType, Double::class.javaObjectType).apply {
                append(0.0, 0.0)
                append(1.0, 1.0)
                append(2.0, 4.0)
            }

            pointMarker = EllipsePointMarker().apply {
                fillStyle = SolidBrushStyle(Color.CYAN)
                width = 20
                height = 20
            }
        }

        UpdateSuspender.using(surface) {
            Collections.addAll(surface.xAxes, NumericAxis(context))
            Collections.addAll(surface.yAxes, NumericAxis(context))

            Collections.addAll(surface.renderableSeries, scatterSeries)
        }

    }
    // </Example>
}
