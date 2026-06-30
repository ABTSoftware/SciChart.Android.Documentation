package com.scichart.docsandbox.examples.kotlin.annotationsAPIs

import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.annotations.tradingAnnotations.FreehandDrawingAnnotation
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment
import android.graphics.Color

@ExampleDefinition()
class FreehandDrawingAnnotationFragment : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {}

    fun addFreehandDrawingAnnotation(surface: SciChartSurface) {
        // <AddFreehandDrawingAnnotation>
        // Assume a surface has been created and configured somewhere
        // Create a FreehandDrawingAnnotation
        val freehandAnnotation = FreehandDrawingAnnotation(context)

        // Configure the annotation
        freehandAnnotation.brushColor = Color.WHITE
        freehandAnnotation.brushThickness = 4f

        // Add some points
        freehandAnnotation.setBasePoint(10, 30.6)
        freehandAnnotation.setBasePoint(30, 31.5)
        freehandAnnotation.setBasePoint(50, 30.3)

        // Allow to interact with the annotation in run-time
        freehandAnnotation.setIsEditable(true)

        // Add the annotation to the AnnotationsCollection of a surface
        surface.annotations.add(freehandAnnotation)
        // </AddFreehandDrawingAnnotation>
    }
}
