package com.scichart.docsandbox.examples.kotlin.annotationsAPIs

import android.graphics.Color
import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.annotations.TextAnnotation
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment
import com.scichart.drawing.common.FontStyle

@ExampleDefinition()
class TextAnnotationFragment : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {}

    fun addTextAnnotation(surface: SciChartSurface) {
        // <AddTextAnnotation>
        // Assume a surface has been created and configured somewhere
        // Create CustomAnnotation instance
        val textAnnotation = TextAnnotation(context)

        // Set the text
        textAnnotation.text = "Text can be Rotated"

        // Specify a FontStyle for the text
        textAnnotation.fontStyle = FontStyle(20f, -0x440363d7)

        // Specify rotation Angle in Degrees if needed
        textAnnotation.rotationAngle = -30f

        // Specify a desired position
        textAnnotation.x1 = 20
        textAnnotation.y1 = 14

        // Allow to interact with the annotation in run-time
        textAnnotation.setIsEditable(true)

        // In a multi-axis scenario, specify the XAxisId and YAxisId
        textAnnotation.xAxisId = "BottomAxisId"
        textAnnotation.yAxisId = "LeftAxisId"

        // Add the annotation to the Annotations collection of the surface
        surface.annotations.add(textAnnotation)
        // </AddTextAnnotation>
    }

    fun editTextAnnotation() {
        // <EditTextAnnotation>
        val editTextAnnotation = TextAnnotation(context)
        editTextAnnotation.setIsEditable(true)
        editTextAnnotation.canEditText = true
        editTextAnnotation.xAxisId = "BottomAxisId"
        editTextAnnotation.yAxisId = "LeftAxisId"
        editTextAnnotation.x1 = 80
        editTextAnnotation.y1 = 14
        editTextAnnotation.text = "and edited ..."
        editTextAnnotation.fontStyle = FontStyle(20f, Color.YELLOW)
        // </EditTextAnnotation>
    }
}
