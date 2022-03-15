package com.scichart.docsandbox.examples.kotlin.series2d

import com.scichart.charting.visuals.SciPieChartSurface
import com.scichart.charting.visuals.renderableSeries.DonutRenderableSeries
import com.scichart.charting.visuals.renderableSeries.PieSegment
import com.scichart.core.framework.UpdateSuspender
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SinglePieChart2DFragment
import com.scichart.drawing.common.RadialGradientBrushStyle
import java.util.*

@ExampleDefinition()
class DonutChart2D : SinglePieChart2DFragment() {
    // <CreateDonutChart>
    override fun initExample(surface: SciPieChartSurface) {
        val donutSeries = DonutRenderableSeries().apply {
            with(segmentsCollection) {
                add(createSegment(40.0, "Green", -0x7b43c3, -0xa477d7))
                add(createSegment(10.0, "Red", -0x1fb5d1, -0x48e9e5))
                add(createSegment(20.0, "Blue", -0xb5493f, -0xde7d53))
                add(createSegment(15.0, "Yellow", -0x7b43c3, -0xa477d7))
            }
        }

        UpdateSuspender.using(surface) {
            Collections.addAll(surface.renderableSeries, donutSeries)
        }
    }

    private fun createSegment(segmentValue: Double, segmentTitle: String, gradientStart: Int, gradientEnd: Int): PieSegment {
        return PieSegment().apply {
            value = segmentValue
            title = segmentTitle
            fillStyle = RadialGradientBrushStyle(
                0.5f, 0.5f,
                0.5f, 0.5f,
                gradientStart, gradientEnd
            )
        }
    }
    // </CreateDonutChart>
}
