package com.scichart.docsandbox.examples.kotlin.annotationsAPIs

import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.annotations.AnnotationSurfaceEnum
import com.scichart.charting.visuals.annotations.AxisLabelAnnotation
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment
import com.scichart.drawing.common.FontStyle

@ExampleDefinition()
class AxisLabelAnnotationFragment : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {}

    fun addAxisLabelAnnotation(surface: SciChartSurface) {
        // <AddAxisLabelAnnotation>
        // Assume a surface has been created and configured somewhere
        // Create CustomAnnotation instance
        val axisLabelAnnotation = AxisLabelAnnotation(context)

        // Set the text
        axisLabelAnnotation.text = "Axis Label can be Rotated"

        // Specify a FontStyle for the text
        axisLabelAnnotation.fontStyle = FontStyle(20.0f, -0xe6e7)

        // Specify rotation Angle in Degrees if needed
        axisLabelAnnotation.rotationAngle = -30f

        // Specify a desired position by setting the X1 coordinate, since the marker is going to be located on an X axis
        axisLabelAnnotation.x1 = 60

        // Specify the desired Axis to place annotation on via AnnotationSurface
        axisLabelAnnotation.annotationSurface = AnnotationSurfaceEnum.XAxis

        // Allow to interact with the annotation in run-time
        axisLabelAnnotation.setIsEditable(true)

        // In a multi-axis scenario, specify the XAxisId and YAxisId
        axisLabelAnnotation.xAxisId = "BottomAxisId"
        axisLabelAnnotation.yAxisId = "LeftAxisId"

        // Add the annotation to the Annotations collection of the surface
        surface.annotations.add(axisLabelAnnotation)
        // </AddAxisLabelAnnotation>
    }
}
