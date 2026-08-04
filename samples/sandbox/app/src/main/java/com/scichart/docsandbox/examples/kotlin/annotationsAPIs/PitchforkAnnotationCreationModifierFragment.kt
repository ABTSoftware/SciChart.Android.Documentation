package com.scichart.docsandbox.examples.kotlin.annotationsAPIs

import com.scichart.charting.modifiers.PitchforkAnnotationCreationModifier
import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.annotations.IAnnotation
import com.scichart.charting.visuals.annotations.LineAnnotation
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment
import com.scichart.drawing.common.SolidPenStyle
import android.graphics.Color

@ExampleDefinition()
class PitchforkAnnotationCreationModifierFragment : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {}

    fun addPitchforkAnnotationCreationModifier(surface: SciChartSurface) {
        // <AddPitchforkAnnotationCreationModifier>
        // Create a PitchforkAnnotationCreationModifier
        val pitchforkCreationModifier = PitchforkAnnotationCreationModifier().apply {
            // Optional: Set a listener to be notified when an annotation is created
            setAnnotationCreationListener { newAnnotation ->
                // Configure the newly created annotation if needed
                newAnnotation.setIsEditable(true)
            }
        }

        // Add the modifier to the surface
        surface.chartModifiers.add(pitchforkCreationModifier)
        // </AddPitchforkAnnotationCreationModifier>
    }

    // <CustomPitchforkAnnotationCreationModifier>
    // Define a custom PitchforkAnnotationCreationModifier
    private class CustomPitchforkAnnotationCreationModifier : PitchforkAnnotationCreationModifier() {
        override fun configureRubberBandAnnotation(annotation: IAnnotation) {
            super.configureRubberBandAnnotation(annotation)
            
            // Customize the rubber-band styling
            if (annotation is LineAnnotation) {
                annotation.stroke = SolidPenStyle(Color.YELLOW, true, 2f, floatArrayOf(10f, 5f))
            }
        }

        override fun onAnnotationCreated(newAnnotation: IAnnotation) {
            super.onAnnotationCreated(newAnnotation)
            
            // Custom logic after annotation is fully created
            newAnnotation.setIsEditable(true)
        }
    }

    fun useCustomPitchforkAnnotationCreationModifier(surface: SciChartSurface) {
        // Use the custom modifier
        val customModifier = CustomPitchforkAnnotationCreationModifier()
        
        surface.chartModifiers.add(customModifier)
    }
    // </CustomPitchforkAnnotationCreationModifier>
}
