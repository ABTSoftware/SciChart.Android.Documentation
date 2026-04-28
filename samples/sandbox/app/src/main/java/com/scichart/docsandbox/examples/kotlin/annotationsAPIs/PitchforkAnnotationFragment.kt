package com.scichart.docsandbox.examples.kotlin.annotationsAPIs

import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.annotations.tradingAnnotations.PitchforkAnnotation
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment
import android.graphics.Color
import com.scichart.drawing.common.SolidBrushStyle
import com.scichart.drawing.common.SolidPenStyle

@ExampleDefinition()
class PitchforkAnnotationFragment : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {}

    fun addPitchforkAnnotation(surface: SciChartSurface) {
        // <AddPitchforkAnnotation>
        // Assume a surface has been created and configured somewhere
        // Create a PitchforkAnnotation
        val pitchforkAnnotation = PitchforkAnnotation(context)

        // Specify the stroke and fill styles
        pitchforkAnnotation.stroke = SolidPenStyle(Color.RED, true, 2f, null)
        pitchforkAnnotation.sidesFill = SolidBrushStyle(Color.GREEN)
        pitchforkAnnotation.middleFill = SolidBrushStyle(Color.BLUE)

        // Add 3 points to define the pitchfork
        pitchforkAnnotation.setBasePoint(10, 30.6) // Handle (Point 0)
        pitchforkAnnotation.setBasePoint(30, 31.5) // High (Point 1)
        pitchforkAnnotation.setBasePoint(50, 30.3) // Low (Point 2)

        // Allow to interact with the annotation in run-time
        pitchforkAnnotation.setIsEditable(true)

        // Add the annotation to the AnnotationsCollection of a surface
        surface.annotations.add(pitchforkAnnotation)
        // </AddPitchforkAnnotation>
    }
}
