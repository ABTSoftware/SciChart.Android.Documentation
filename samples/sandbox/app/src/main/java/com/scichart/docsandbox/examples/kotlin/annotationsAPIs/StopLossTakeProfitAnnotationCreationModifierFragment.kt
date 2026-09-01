package com.scichart.docsandbox.examples.kotlin.annotationsAPIs

import android.graphics.Color
import com.scichart.charting.modifiers.StopLossTakeProfitAnnotationCreationModifier
import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.annotations.IAnnotation
import com.scichart.charting.visuals.annotations.LineAnnotation
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment
import com.scichart.drawing.common.SolidPenStyle

@ExampleDefinition()
class StopLossTakeProfitAnnotationCreationModifierFragment : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {}

    fun addStopLossTakeProfitAnnotationCreationModifier(surface: SciChartSurface) {
        // <AddStopLossTakeProfitAnnotationCreationModifier>
        // Create a StopLossTakeProfitAnnotationCreationModifier
        val stopLossTakeProfitCreationModifier = StopLossTakeProfitAnnotationCreationModifier().apply {
            // Optional: Customize the rubber-band preview line shown while placing the points
            rubberBandStroke = SolidPenStyle(Color.WHITE, true, 1.5f, floatArrayOf(5f, 5f))

            // Optional: Set a listener to be notified when an annotation is created
            setAnnotationCreationListener { newAnnotation ->
                // Configure the newly created annotation if needed
                newAnnotation.setIsEditable(true)
            }
        }

        // Add the modifier to the surface
        surface.chartModifiers.add(stopLossTakeProfitCreationModifier)
        // </AddStopLossTakeProfitAnnotationCreationModifier>
    }

    // <CustomStopLossTakeProfitAnnotationCreationModifier>
    // Define a custom StopLossTakeProfitAnnotationCreationModifier
    private class CustomStopLossTakeProfitAnnotationCreationModifier : StopLossTakeProfitAnnotationCreationModifier() {
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

    fun useCustomStopLossTakeProfitAnnotationCreationModifier(surface: SciChartSurface) {
        // Use the custom modifier
        val customModifier = CustomStopLossTakeProfitAnnotationCreationModifier()

        surface.chartModifiers.add(customModifier)
    }
    // </CustomStopLossTakeProfitAnnotationCreationModifier>
}
