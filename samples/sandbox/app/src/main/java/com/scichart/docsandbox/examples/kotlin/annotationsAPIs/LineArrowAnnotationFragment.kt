package com.scichart.docsandbox.examples.kotlin.annotationsAPIs

import android.graphics.Color
import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.annotations.AnnotationCoordinateMode
import com.scichart.charting.visuals.annotations.LineArrowAnnotation
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment
import com.scichart.drawing.common.SolidPenStyle

@ExampleDefinition()
class LineArrowAnnotationFragment : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {}

    fun addLineArrowAnnotation(surface: SciChartSurface) {
        // <AddLineArrowAnnotation>
        // Assume a surface has been created and configured somewhere
        // Create a LineArrow Annotation
        val lineArrowAnnotation = LineArrowAnnotation(context)

        // Allow to interact with the annotation in run-time
        lineArrowAnnotation.setIsEditable(true)

        // in a multi-axis scenario, specify the XAxisId and YAxisId
        lineArrowAnnotation.xAxisId = "TopAxisId"
        lineArrowAnnotation.yAxisId = "LeftAxisId"

        // Specify size for the arrow's head
        lineArrowAnnotation.headLength = 4f
        lineArrowAnnotation.headWidth = 8f

        // Specify a desired position by setting coordinates
        lineArrowAnnotation.coordinateMode = AnnotationCoordinateMode.RelativeY
        lineArrowAnnotation.x1 = 40
        lineArrowAnnotation.y1 = 0.8
        lineArrowAnnotation.x2 = 100
        lineArrowAnnotation.y2 = 0.2

        // Specify the stroke color for the annotation
        lineArrowAnnotation.stroke =
            SolidPenStyle(Color.YELLOW, true, 2f, null)

        // Add the annotation to the Annotations collection of the surface
        surface.annotations.add(lineArrowAnnotation)
        // </AddLineArrowAnnotation>
    }
}
