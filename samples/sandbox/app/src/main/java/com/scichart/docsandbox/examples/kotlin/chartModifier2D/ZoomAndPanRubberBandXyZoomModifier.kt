package com.scichart.docsandbox.examples.kotlin.chartModifier2D

import com.scichart.charting.modifiers.RubberBandXyZoomModifier
import com.scichart.charting.visuals.SciChartSurface
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment
import com.scichart.drawing.common.BrushStyle
import com.scichart.drawing.common.PenStyle
import com.scichart.drawing.common.SolidBrushStyle
import com.scichart.drawing.common.SolidPenStyle

@ExampleDefinition()
class ZoomAndPanRubberBandXyZoomModifier : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {}

    fun addRubberBandXyZoomModifier(surface: SciChartSurface) {
        // <AddRubberBandXyZoomModifier>
        // Assume a surface has been created and configured somewhere
        // Create a RubberBandXyZoomModifier
        val rubberBandZoomModifier = RubberBandXyZoomModifier()
        rubberBandZoomModifier.isXAxisOnly = true
        rubberBandZoomModifier.zoomExtentsY = true
        rubberBandZoomModifier.isAnimated = true

        // Apply a BrushStyle for fill
        val brushStyle: BrushStyle = SolidBrushStyle(0x33999999)
        rubberBandZoomModifier.rubberBandFillStyle = brushStyle

        // Apply a PenStyle for stroke
        val strokeStyle: PenStyle = SolidPenStyle(0x77999999, true, 1f, null)
        rubberBandZoomModifier.rubberBandStrokeStyle = strokeStyle

        // Add the modifier to the surface
        surface.chartModifiers.add(rubberBandZoomModifier)
        // </AddRubberBandXyZoomModifier>
    }
}
