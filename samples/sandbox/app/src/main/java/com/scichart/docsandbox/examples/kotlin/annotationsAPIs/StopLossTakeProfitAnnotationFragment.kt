package com.scichart.docsandbox.examples.kotlin.annotationsAPIs

import android.graphics.Color
import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.annotations.tradingAnnotations.StopLossTakeProfitAnnotation
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment

@ExampleDefinition()
class StopLossTakeProfitAnnotationFragment : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {}

    fun addStopLossTakeProfitAnnotation(surface: SciChartSurface) {
        // <AddStopLossTakeProfitAnnotation>
        // Assume a surface has been created and configured somewhere
        // Create a StopLossTakeProfitAnnotation
        val stopLossTakeProfitAnnotation = StopLossTakeProfitAnnotation(context)

        // Specify the colors used for the upwards (take-profit) and the downwards (stop-loss) zone
        stopLossTakeProfitAnnotation.takeProfitColor = Color.GREEN
        stopLossTakeProfitAnnotation.stopLossColor = Color.RED

        // Specify the zone appearance
        stopLossTakeProfitAnnotation.fillOpacity = 0.2f
        stopLossTakeProfitAnnotation.strokeThickness = 2f
        stopLossTakeProfitAnnotation.strokeDashArray = floatArrayOf(6f, 3f)

        // Show the price change label in the center of the zone
        stopLossTakeProfitAnnotation.showDistanceLabel = true

        // Add 2 points which define the opposite corners of the zone.
        // Here the second point is above the first one, so this is a take-profit zone
        stopLossTakeProfitAnnotation.setBasePoint(10, 33.0) // Point 0 - the reference price
        stopLossTakeProfitAnnotation.setBasePoint(30, 34.2) // Point 1 - the target price

        // Allow to interact with the annotation in run-time
        stopLossTakeProfitAnnotation.setIsEditable(true)

        // Add the annotation to the AnnotationsCollection of a surface
        surface.annotations.add(stopLossTakeProfitAnnotation)
        // </AddStopLossTakeProfitAnnotation>
    }
}
