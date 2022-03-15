package com.scichart.docsandbox.examples.kotlin.annotationsAPIs

import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.annotations.BoxAnnotation
import com.scichart.docsandbox.R
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment

@ExampleDefinition()
class BoxAnnotationFragment : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {}

    fun addBoxAnnotation(surface: SciChartSurface) {
        // <AddBoxAnnotation>
        // Assume a surface has been created and configured somewhere
        // Create a BoxAnnotation
        val boxAnnotation = BoxAnnotation(context)

        // Allow to interact with the annotation in run-time
        boxAnnotation.setIsEditable(true)

        // in a multi-axis scenario, specify the XAxisId and YAxisId
        boxAnnotation.xAxisId = "TopAxisId"
        boxAnnotation.yAxisId = "LeftAxisId"

        // Specify a desired position by setting coordinates
        boxAnnotation.x = 20.0f
        boxAnnotation.y1 = 10.0f
        boxAnnotation.x2 = 90.0f
        boxAnnotation.y2 = 4.0f

        // Specify the background resource
        boxAnnotation.setBackgroundResource(R.drawable.example_box_annotation_background)

        // Add the annotation to the AnnotationsCollection of a surface
        surface.annotations.add(boxAnnotation)
        // </AddBoxAnnotation>
    }
}
