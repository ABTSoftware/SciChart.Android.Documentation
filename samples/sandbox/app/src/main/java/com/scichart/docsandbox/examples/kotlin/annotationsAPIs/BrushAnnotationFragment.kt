package com.scichart.docsandbox.examples.kotlin.annotationsAPIs

import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.annotations.tradingAnnotations.BrushAnnotation
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment
import android.graphics.Color

@ExampleDefinition()
class BrushAnnotationFragment : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {}

    fun addBrushAnnotation(surface: SciChartSurface) {
        // <AddBrushAnnotation>
        // Assume a surface has been created and configured somewhere
        // Create a BrushAnnotation
        val brushAnnotation = BrushAnnotation(context)

        // Configure the annotation
        brushAnnotation.brushColor = Color.WHITE
        brushAnnotation.brushThickness = 4f

        // Add some points
        brushAnnotation.setBasePoint(10, 30.6)
        brushAnnotation.setBasePoint(30, 31.5)
        brushAnnotation.setBasePoint(50, 30.3)

        // Allow to interact with the annotation in run-time
        brushAnnotation.setIsEditable(true)

        // Add the annotation to the AnnotationsCollection of a surface
        surface.annotations.add(brushAnnotation)
        // </AddBrushAnnotation>
    }
}
