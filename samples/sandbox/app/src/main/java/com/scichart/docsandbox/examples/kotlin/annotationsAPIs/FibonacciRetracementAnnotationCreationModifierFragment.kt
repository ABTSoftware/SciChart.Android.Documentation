package com.scichart.docsandbox.examples.kotlin.annotationsAPIs

import android.content.Context
import android.graphics.Color
import com.scichart.charting.modifiers.FibonacciRetracementAnnotationCreationModifier
import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.annotations.IAnnotation
import com.scichart.charting.visuals.annotations.LineAnnotation
import com.scichart.charting.visuals.annotations.tradingAnnotations.FibonacciRetracementAnnotation
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment
import com.scichart.drawing.common.SolidPenStyle

@ExampleDefinition()
class FibonacciRetracementAnnotationCreationModifierFragment : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {}

    fun addFibonacciRetracementAnnotationCreationModifier(surface: SciChartSurface) {
        // <AddFibonacciRetracementAnnotationCreationModifier>
        // Create a FibonacciRetracementAnnotationCreationModifier
        val fibonacciCreationModifier = FibonacciRetracementAnnotationCreationModifier().apply {
            // Optional: Configure how the labels of every created annotation are placed and formatted
            labelPlacement = FibonacciRetracementAnnotation.LabelPlacement.CENTER
            labelFormat = FibonacciRetracementAnnotation.LabelFormat.RATIO
            labelVerticalPosition = FibonacciRetracementAnnotation.LabelVerticalPosition.ABOVE

            // Optional: Customize the rubber-band preview line shown while placing the points
            rubberBandStroke = SolidPenStyle(Color.WHITE, true, 1.5f, floatArrayOf(5f, 5f))

            // Optional: Set a listener to be notified when an annotation is created
            setAnnotationCreationListener { newAnnotation ->
                // Configure the newly created annotation if needed
                newAnnotation.setIsEditable(true)
            }
        }

        // Add the modifier to the surface
        surface.chartModifiers.add(fibonacciCreationModifier)
        // </AddFibonacciRetracementAnnotationCreationModifier>
    }

    // <CustomFibonacciRetracementAnnotationCreationModifier>
    // Define a custom FibonacciRetracementAnnotationCreationModifier
    private class CustomFibonacciRetracementAnnotationCreationModifier : FibonacciRetracementAnnotationCreationModifier() {
        override fun createAnnotation(context: Context): FibonacciRetracementAnnotation {
            val annotation = super.createAnnotation(context)

            // Apply a custom set of Fibonacci levels to every annotation created by this modifier.
            // Note the label properties of the modifier have already been applied by super
            annotation.levels = listOf(0.0, 0.382, 0.618, 1.0)
            annotation.fillOpacity = 0.2f

            return annotation
        }

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

    fun useCustomFibonacciRetracementAnnotationCreationModifier(surface: SciChartSurface) {
        // Use the custom modifier
        val customModifier = CustomFibonacciRetracementAnnotationCreationModifier()

        surface.chartModifiers.add(customModifier)
    }
    // </CustomFibonacciRetracementAnnotationCreationModifier>
}
