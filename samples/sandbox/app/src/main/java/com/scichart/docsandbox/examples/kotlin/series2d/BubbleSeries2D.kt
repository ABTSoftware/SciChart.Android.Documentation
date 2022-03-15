package com.scichart.docsandbox.examples.kotlin.series2d

import com.scichart.charting.model.dataSeries.XyzDataSeries
import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.axes.NumericAxis
import com.scichart.charting.visuals.renderableSeries.FastBubbleRenderableSeries
import com.scichart.core.framework.UpdateSuspender
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment
import com.scichart.drawing.common.SolidBrushStyle
import com.scichart.drawing.common.SolidPenStyle
import java.util.*

@ExampleDefinition()
class BubbleSeries2D : SingleChart2DFragment() {
    // <Example>
    override fun initExample(surface: SciChartSurface) {
        val bubbleSeries = FastBubbleRenderableSeries().apply {
            val doubleType = Double::class.javaObjectType

            dataSeries = XyzDataSeries(doubleType, doubleType, doubleType).apply {
                append(0.0, 0.0, 1.0)
                append(1.0, 1.0, 0.0)
                append(2.0, 4.0, 0.0)
            }

            strokeStyle = SolidPenStyle(-0x333334, true, 2f, null)
            bubbleBrushStyle = SolidBrushStyle(0x77CCCCCC)
        }

        UpdateSuspender.using(surface) {
            Collections.addAll(surface.xAxes, NumericAxis(context))
            Collections.addAll(surface.yAxes, NumericAxis(context))

            Collections.addAll(surface.renderableSeries, bubbleSeries)
        }
    }
    // </Example>
}
