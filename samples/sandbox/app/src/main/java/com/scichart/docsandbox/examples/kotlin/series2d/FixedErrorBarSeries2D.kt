package com.scichart.docsandbox.examples.kotlin.series2d

import com.scichart.charting.model.dataSeries.XyDataSeries
import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.axes.NumericAxis
import com.scichart.charting.visuals.renderableSeries.ErrorDirection
import com.scichart.charting.visuals.renderableSeries.ErrorMode
import com.scichart.charting.visuals.renderableSeries.FastFixedErrorBarsRenderableSeries
import com.scichart.core.framework.UpdateSuspender
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment
import com.scichart.drawing.common.SolidPenStyle
import java.util.*

@ExampleDefinition()
class FixedErrorBarSeries2D : SingleChart2DFragment() {
    // <Example>
    override fun initExample(surface: SciChartSurface) {
        val errorBarSeries = FastFixedErrorBarsRenderableSeries().apply {
            dataSeries = XyDataSeries(
                Double::class.javaObjectType,
                Double::class.javaObjectType
            ).apply {
                append(0.0, 0.0)
                append(1.0, 1.0)
                append(2.0, 4.0)
            }

            strokeStyle = SolidPenStyle(-0xe6e7, true, 2f, null)
            errorMode = ErrorMode.Both
            errorDirection = ErrorDirection.Vertical

            errorHigh = 0.3
            errorLow = 0.1
        }

        UpdateSuspender.using(surface) {
            Collections.addAll(surface.xAxes, NumericAxis(context))
            Collections.addAll(surface.yAxes, NumericAxis(context))

            Collections.addAll(surface.renderableSeries, errorBarSeries)
        }
    }
    // </Example>
}
