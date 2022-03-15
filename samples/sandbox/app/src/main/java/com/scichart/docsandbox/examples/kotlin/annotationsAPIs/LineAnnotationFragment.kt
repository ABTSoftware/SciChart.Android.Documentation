package com.scichart.docsandbox.examples.kotlin.annotationsAPIs

import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.annotations.AnnotationCoordinateMode
import com.scichart.charting.visuals.annotations.LineAnnotation
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment
import com.scichart.drawing.common.SolidPenStyle

@ExampleDefinition()
class LineAnnotationFragment : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {}

    fun addLineAnnotation(surface: SciChartSurface) {
        // <AddLineAnnotation>
        // Assume a surface has been created and configured somewhere
        // Create a Line Annotation
        val lineAnnotation = LineAnnotation(context)

        // Allow to interact with the annotation in run-time
        lineAnnotation.setIsEditable(true)

        // In a multi-axis scenario, specify the XAxisId and YAxisId
        lineAnnotation.xAxisId = "TopAxisId"
        lineAnnotation.yAxisId = "LeftAxisId"

        // Specify a desired position by setting coordinates
        lineAnnotation.coordinateMode = AnnotationCoordinateMode.RelativeY
        lineAnnotation.x1 = 20
        lineAnnotation.y1 = 0.2
        lineAnnotation.x2 = 60
        lineAnnotation.y2 = 0.8

        // Specify the stroke color for the annotation
        lineAnnotation.stroke = SolidPenStyle(-0x66bd52be, true, 4f, null)

        // Add the annotation to the Annotations collection of the surface
        surface.annotations.add(lineAnnotation)
        // </AddLineAnnotation>
    }
}
