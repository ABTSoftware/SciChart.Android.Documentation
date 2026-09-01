package com.scichart.docsandbox.examples.kotlin.annotationsAPIs

import android.graphics.Color
import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.annotations.tradingAnnotations.FibonacciRetracementAnnotation
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment
import com.scichart.drawing.common.SolidPenStyle

@ExampleDefinition()
class FibonacciRetracementAnnotationFragment : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {}

    fun addFibonacciRetracementAnnotation(surface: SciChartSurface) {
        // <AddFibonacciRetracementAnnotation>
        // Assume a surface has been created and configured somewhere
        // Create a FibonacciRetracementAnnotation
        val fibonacciRetracementAnnotation = FibonacciRetracementAnnotation(context)

        // Specify the Fibonacci ratios to draw and the color of each level
        fibonacciRetracementAnnotation.levels = listOf(0.0, 0.236, 0.382, 0.5, 0.618, 0.786, 1.0)
        fibonacciRetracementAnnotation.levelColors = listOf(
            Color.parseColor("#787B86"),
            Color.parseColor("#F23645"),
            Color.parseColor("#FF9800"),
            Color.parseColor("#4CAF50"),
            Color.parseColor("#089981"),
            Color.parseColor("#2962FF"),
            Color.parseColor("#9C27B0")
        )

        // Specify the appearance of the level lines and of the fill bands between them
        fibonacciRetracementAnnotation.strokeThickness = 1.5f
        fibonacciRetracementAnnotation.fillOpacity = 0.35f

        // The stroke provides the color of the dashed connector line between the two anchor points
        fibonacciRetracementAnnotation.stroke = SolidPenStyle(Color.WHITE, true, 1f, null)
        fibonacciRetracementAnnotation.showConnectorLine = true

        // Configure how each level's label is placed and formatted
        fibonacciRetracementAnnotation.labelPlacement = FibonacciRetracementAnnotation.LabelPlacement.CENTER
        fibonacciRetracementAnnotation.labelFormat = FibonacciRetracementAnnotation.LabelFormat.RATIO
        fibonacciRetracementAnnotation.labelVerticalPosition = FibonacciRetracementAnnotation.LabelVerticalPosition.ABOVE
        fibonacciRetracementAnnotation.labelFontSize = 15f

        // Add 2 points which define the price move being retraced
        fibonacciRetracementAnnotation.setBasePoint(10, 30.4) // Point 0 - the 0.0 ratio
        fibonacciRetracementAnnotation.setBasePoint(30, 32.2) // Point 1 - the 1.0 ratio

        // Allow to interact with the annotation in run-time
        fibonacciRetracementAnnotation.setIsEditable(true)

        // Add the annotation to the AnnotationsCollection of a surface
        surface.annotations.add(fibonacciRetracementAnnotation)
        // </AddFibonacciRetracementAnnotation>
    }
}
