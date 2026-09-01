package com.scichart.docsandbox.examples.kotlin.annotationsAPIs

import android.content.Context
import android.graphics.Color
import com.scichart.charting.modifiers.MeasureAnnotationCreationModifier
import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.annotations.IAnnotation
import com.scichart.charting.visuals.annotations.LineAnnotation
import com.scichart.charting.visuals.annotations.tradingAnnotations.MeasureAnnotation
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment
import com.scichart.drawing.common.SolidPenStyle

@ExampleDefinition()
class MeasureAnnotationCreationModifierFragment : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {}

    fun addMeasureAnnotationCreationModifier(surface: SciChartSurface) {
        // <AddMeasureAnnotationCreationModifier>
        // Create a MeasureAnnotationCreationModifier
        val measureCreationModifier = MeasureAnnotationCreationModifier().apply {
            // Optional: Snap the anchor points of every created annotation to the closest data point
            // of an OHLC series. The series is also used to resolve the bar count reported by the label
            // snapSeries = candlestickSeries

            // Optional: Customize the rubber-band preview line shown while placing the points
            rubberBandStroke = SolidPenStyle(Color.WHITE, true, 1.5f, floatArrayOf(5f, 5f))

            // Optional: Set a listener to be notified when an annotation is created
            setAnnotationCreationListener { newAnnotation ->
                // Configure the newly created annotation if needed
                newAnnotation.setIsEditable(true)
            }
        }

        // Add the modifier to the surface
        surface.chartModifiers.add(measureCreationModifier)
        // </AddMeasureAnnotationCreationModifier>
    }

    // <CustomMeasureAnnotationCreationModifier>
    // Define a custom MeasureAnnotationCreationModifier
    private class CustomMeasureAnnotationCreationModifier : MeasureAnnotationCreationModifier() {
        override fun createAnnotation(context: Context): MeasureAnnotation {
            val annotation = super.createAnnotation(context)

            // Apply custom default styling to every annotation created by this modifier
            annotation.growingColor = Color.CYAN
            annotation.decliningColor = Color.MAGENTA
            annotation.yValueScaleFactor = 10000.0

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

    fun useCustomMeasureAnnotationCreationModifier(surface: SciChartSurface) {
        // Use the custom modifier
        val customModifier = CustomMeasureAnnotationCreationModifier()

        surface.chartModifiers.add(customModifier)
    }
    // </CustomMeasureAnnotationCreationModifier>
}
