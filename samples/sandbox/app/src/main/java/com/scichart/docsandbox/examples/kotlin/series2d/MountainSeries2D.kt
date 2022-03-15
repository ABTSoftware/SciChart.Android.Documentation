package com.scichart.docsandbox.examples.kotlin.series2d

import android.graphics.Color
import com.scichart.charting.model.dataSeries.XyDataSeries
import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.axes.NumericAxis
import com.scichart.charting.visuals.renderableSeries.FastMountainRenderableSeries
import com.scichart.core.framework.UpdateSuspender
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment
import com.scichart.drawing.common.SolidBrushStyle
import com.scichart.drawing.common.SolidPenStyle
import java.util.*

@ExampleDefinition()
class MountainSeries2D : SingleChart2DFragment() {
    // <Example>
    override fun initExample(surface: SciChartSurface) {
        val mountainSeries = FastMountainRenderableSeries().apply {
            dataSeries = XyDataSeries(Double::class.javaObjectType, Double::class.javaObjectType).apply {
                append(0.0, 0.0)
                append(1.0, 1.0)
                append(2.0, 4.0)
            }

            areaStyle = SolidBrushStyle(Color.CYAN)
            strokeStyle = SolidPenStyle(Color.RED, true, 1f, null)
        }

        UpdateSuspender.using(surface) {
            Collections.addAll(surface.xAxes, NumericAxis(context))
            Collections.addAll(surface.yAxes, NumericAxis(context))

            Collections.addAll(surface.renderableSeries, mountainSeries)
        }
    }
    // </Example>
}
