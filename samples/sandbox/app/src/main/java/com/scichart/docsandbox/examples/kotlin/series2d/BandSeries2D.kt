package com.scichart.docsandbox.examples.kotlin.series2d

import android.graphics.Color
import com.scichart.charting.model.dataSeries.XyyDataSeries
import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.axes.NumericAxis
import com.scichart.charting.visuals.renderableSeries.FastBandRenderableSeries
import com.scichart.core.framework.UpdateSuspender
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment
import com.scichart.drawing.common.SolidBrushStyle
import com.scichart.drawing.common.SolidPenStyle
import java.util.*

@ExampleDefinition()
class BandSeries2D : SingleChart2DFragment() {
    // <Example>
    override fun initExample(surface: SciChartSurface) {
        val bandSeries = FastBandRenderableSeries().apply {
            dataSeries = XyyDataSeries(Double::class.javaObjectType, Double::class.javaObjectType).apply {
                append(0.0, 0.0, 1.0)
                append(1.0, 1.0, 0.0)
                append(2.0, 4.0, 0.0)
            }

            strokeStyle = SolidPenStyle(Color.RED, true, 1f, null)
            strokeY1Style = SolidPenStyle(Color.BLUE, true, 1f, null)

            fillBrushStyle = SolidBrushStyle(Color.CYAN)
            fillY1BrushStyle = SolidBrushStyle(Color.YELLOW)
        }

        UpdateSuspender.using(surface) {
            Collections.addAll(surface.xAxes, NumericAxis(context))
            Collections.addAll(surface.yAxes, NumericAxis(context))

            Collections.addAll(surface.renderableSeries, bandSeries)
        }
    }
    // </Example>
}
