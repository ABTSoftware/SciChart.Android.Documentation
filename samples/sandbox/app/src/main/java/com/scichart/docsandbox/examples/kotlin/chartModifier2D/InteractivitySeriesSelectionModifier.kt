package com.scichart.docsandbox.examples.kotlin.chartModifier2D

import com.scichart.charting.modifiers.SeriesSelectionModifier
import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.pointmarkers.EllipsePointMarker
import com.scichart.charting.visuals.pointmarkers.IPointMarker
import com.scichart.charting.visuals.renderableSeries.IRenderableSeries
import com.scichart.charting.visuals.renderableSeries.StyleBase
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment
import com.scichart.drawing.common.PenStyle
import com.scichart.drawing.common.SolidBrushStyle
import com.scichart.drawing.common.SolidPenStyle
import com.scichart.drawing.utility.ColorUtil

@ExampleDefinition()
class InteractivitySeriesSelectionModifier : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {}

    fun addSeriesSelectionModifier(surface: SciChartSurface) {
        // <CreateSelectedSeriesStyle>
        class SelectedSeriesStyle: StyleBase<IRenderableSeries>(IRenderableSeries::class.java) {
            private val STROKE = "Stroke"
            private val POINT_MARKER = "PointMarker"

            private val selectedStrokeStyle = SolidPenStyle(ColorUtil.White, true, 4f, null)
            private val selectedPointMarker: IPointMarker = EllipsePointMarker().apply {
                setSize(10, 10)
                fillStyle = SolidBrushStyle(0xFFFF00DC.toInt())
                strokeStyle = SolidPenStyle(ColorUtil.White, true, 1f, null)
            }

            override fun applyStyleInternal(renderableSeriesToStyle: IRenderableSeries) {
                putPropertyValue(renderableSeriesToStyle, STROKE, renderableSeriesToStyle.strokeStyle);
                putPropertyValue(renderableSeriesToStyle, POINT_MARKER, renderableSeriesToStyle.pointMarker);

                renderableSeriesToStyle.strokeStyle = selectedStrokeStyle
                renderableSeriesToStyle.pointMarker = selectedPointMarker
            }

            override fun discardStyleInternal(renderableSeriesToStyle: IRenderableSeries) {
                renderableSeriesToStyle.strokeStyle = getPropertyValue(renderableSeriesToStyle, STROKE, PenStyle::class.java)
                renderableSeriesToStyle.pointMarker = getPropertyValue(renderableSeriesToStyle, POINT_MARKER, IPointMarker::class.java)
            }
        }
        // </CreateSelectedSeriesStyle>

        // <AddSeriesSelectionModifier>
        // Assume a surface has been created and configured somewhere
        // Create a SeriesSelectionModifier
        val seriesSelectionModifier = SeriesSelectionModifier()

        // Set a style which will be applied to a RenderableSeries when selected
        seriesSelectionModifier.selectedSeriesStyle = SelectedSeriesStyle()

        // Add the modifier to the surface
        surface.chartModifiers.add(seriesSelectionModifier)
        // </AddSeriesSelectionModifier>
    }
}

