package com.scichart.docsandbox.examples.kotlin.annotationsAPIs

import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.annotations.tradingAnnotations.XabcdAnnotation
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment
import android.graphics.Color
import com.scichart.drawing.common.SolidBrushStyle
import com.scichart.drawing.common.SolidPenStyle

@ExampleDefinition()
class XabcdAnnotationFragment : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {}

    fun addXabcdAnnotation(surface: SciChartSurface) {
        // <AddXabcdAnnotation>
        // Assume a surface has been created and configured somewhere
        // Create an XabcdAnnotation
        val xabcdAnnotation = XabcdAnnotation(context)

        // Specify the stroke and fill
        xabcdAnnotation.stroke = SolidPenStyle(Color.YELLOW, true, 2f, null)
        xabcdAnnotation.fill = SolidBrushStyle(Color.BLUE)

        // Add 5 points (X, A, B, C, D)
        xabcdAnnotation.setBasePoint(10, 30.6)
        xabcdAnnotation.setBasePoint(30, 31.5)
        xabcdAnnotation.setBasePoint(50, 30.3)
        xabcdAnnotation.setBasePoint(70, 31.5)
        xabcdAnnotation.setBasePoint(90, 30.6)

        // Allow to interact with the annotation in run-time
        xabcdAnnotation.setIsEditable(true)

        // Add the annotation to the AnnotationsCollection of a surface
        surface.annotations.add(xabcdAnnotation)
        // </AddXabcdAnnotation>
    }
}
