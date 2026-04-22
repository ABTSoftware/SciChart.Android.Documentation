package com.scichart.docsandbox.examples.kotlin.annotationsAPIs

import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.annotations.tradingAnnotations.BrushAnnotation
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment
import android.graphics.Color
import com.scichart.examples.utils.scichartExtensions.brushAnnotation

@ExampleDefinition()
class BrushAnnotationFragment : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {}

    fun addBrushAnnotation(surface: SciChartSurface) {
        // <AddBrushAnnotation>
        // Assume a surface has been created and configured somewhere
        // Create a BrushAnnotation using the Kotlin DSL
        surface.annotations.add(BrushAnnotation(context).apply {
            brushColor = Color.WHITE
            brushThickness = 4f
            
            setBasePoint(10, 30.6)
            setBasePoint(30, 31.5)
            setBasePoint(50, 30.3)
            
            isEditable = true
        })
        // </AddBrushAnnotation>
    }
}
