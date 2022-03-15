package com.scichart.docsandbox.examples.kotlin.series2d

import android.view.Gravity
import com.scichart.charting.modifiers.PieChartLegendModifier
import com.scichart.charting.modifiers.PieChartTooltipModifier
import com.scichart.charting.modifiers.PieSegmentSelectionModifier
import com.scichart.charting.visuals.SciPieChartSurface
import com.scichart.charting.visuals.renderableSeries.*
import com.scichart.core.framework.UpdateSuspender
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SinglePieChart2DFragment
import com.scichart.drawing.common.RadialGradientBrushStyle
import java.util.*

@ExampleDefinition()
class PieChart2D : SinglePieChart2DFragment() {
    // <CreatePieChart>
    override fun initExample(surface: SciPieChartSurface) {
        val pieSeries = PieRenderableSeries().apply {
            with(segmentsCollection) {
                add(createSegment(40.0, "Green", -0x7b43c3, -0xa477d7))
                add(createSegment(10.0, "Red", -0x1fb5d1, -0x48e9e5))
                add(createSegment(20.0, "Blue", -0xb5493f, -0xde7d53))
                add(createSegment(15.0, "Yellow", -0x7b43c3, -0xa477d7))
            }
        }

        UpdateSuspender.using(surface) {
            Collections.addAll(surface.renderableSeries, pieSeries)
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
    // </CreatePieChart>

    // <CreateCustomPieSegmentLabelFormatter>
    internal class CustomPieSegmentLabelFormatter : PieSegmentLabelFormatterBase() {
        override fun formatLabel(pieSegment: IPieSegment): CharSequence {
            return String.format("%.1f", pieSegment.value)
        }
    }
    // </CreateCustomPieSegmentLabelFormatter>

    fun createPieChartLegend(pieSeries: PieRenderableSeries?, pieChartSurface: SciPieChartSurface) {
        // <CreatePieChartLegend>
        val legendModifier = PieChartLegendModifier(context).apply {
            setSourceSeries(pieSeries)
            setLegendPosition(Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL, 17)
        }
        pieChartSurface.chartModifiers.add(legendModifier)
        // </CreatePieChartLegend>

        // <AddPieChartSelection>
        val selectionModifier = PieSegmentSelectionModifier()
        pieChartSurface.chartModifiers.add(selectionModifier)
        // </AddPieChartSelection>

        // <AddPieChartTooltip>
        pieChartSurface.chartModifiers.add(PieChartTooltipModifier())
        // </AddPieChartTooltip>

        // <UseCustomPieSegmentLabelFormatter>
        // Assume a donutSeries has been created somewhere
        val donutSeries = DonutRenderableSeries()
        donutSeries.pieSegmentLabelFormatter = CustomPieSegmentLabelFormatter()
        // </UseCustomPieSegmentLabelFormatter>
    }
}
