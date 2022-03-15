package com.scichart.docsandbox.examples.kotlin.series2d

import com.scichart.charting.model.dataSeries.HlDataSeries
import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.axes.NumericAxis
import com.scichart.charting.visuals.renderableSeries.ErrorDirection
import com.scichart.charting.visuals.renderableSeries.ErrorMode
import com.scichart.charting.visuals.renderableSeries.FastErrorBarsRenderableSeries
import com.scichart.core.framework.UpdateSuspender
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment
import com.scichart.drawing.common.SolidPenStyle
import java.util.*

@ExampleDefinition()
class ErrorBarSeries2D : SingleChart2DFragment() {
    // <Example>
    override fun initExample(surface: SciChartSurface) {
        val errorBarSeries = FastErrorBarsRenderableSeries().apply {
            dataSeries = HlDataSeries(
                Double::class.javaObjectType,
                Double::class.javaObjectType
            ).apply {
                append(0.0, 0.0, 0.1, 0.3)
                append(1.0, 1.0, 0.2, 0.2)
                append(2.0, 3.0, 0.3, 0.1)
            }

            strokeStyle = SolidPenStyle(-0xe6e7, true, 2f, null)
            errorMode = ErrorMode.Both
            errorDirection = ErrorDirection.Vertical
        }

        UpdateSuspender.using(surface) {
            Collections.addAll(surface.xAxes, NumericAxis(context))
            Collections.addAll(surface.yAxes, NumericAxis(context))

            Collections.addAll(surface.renderableSeries, errorBarSeries)
        }
    }
    // </Example>
}
