package com.scichart.docsandbox.examples.kotlin.annotationsAPIs

import android.graphics.Color
import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.annotations.tradingAnnotations.MeasureAnnotation
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment

@ExampleDefinition()
class MeasureAnnotationFragment : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {}

    fun addMeasureAnnotation(surface: SciChartSurface) {
        // <AddMeasureAnnotation>
        // Assume a surface has been created and configured somewhere
        // Create a MeasureAnnotation
        val measureAnnotation = MeasureAnnotation(context)

        // Specify the colors used for the upwards (growing) and the downwards (declining) move
        measureAnnotation.growingColor = Color.BLUE
        measureAnnotation.decliningColor = Color.RED

        // Specify the box appearance and show the measuring arrows
        measureAnnotation.fillOpacity = 0.2f
        measureAnnotation.strokeThickness = 1.5f
        measureAnnotation.showArrows = true

        // Optionally snap both anchor points to the closest data point of an OHLC series.
        // The series is also used to resolve the bar count reported by the label
        // measureAnnotation.snapSeries = candlestickSeries
        // measureAnnotation.snapToDataPointRadius = 15f

        // Add 2 points which define the opposite corners of the measured region
        measureAnnotation.setBasePoint(10, 30.6) // Point 0 - the start of the move
        measureAnnotation.setBasePoint(30, 32.1) // Point 1 - the end of the move

        // Allow to interact with the annotation in run-time
        measureAnnotation.setIsEditable(true)

        // Add the annotation to the AnnotationsCollection of a surface
        surface.annotations.add(measureAnnotation)
        // </AddMeasureAnnotation>
    }
}
