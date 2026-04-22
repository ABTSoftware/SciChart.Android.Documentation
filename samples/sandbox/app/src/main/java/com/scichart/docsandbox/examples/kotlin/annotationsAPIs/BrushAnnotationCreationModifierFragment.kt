package com.scichart.docsandbox.examples.kotlin.annotationsAPIs

import com.scichart.charting.modifiers.BrushAnnotationCreationModifier
import com.scichart.charting.visuals.SciChartSurface
import com.scichart.core.utility.touch.ModifierTouchEventArgs
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment
import android.graphics.Color

@ExampleDefinition()
class BrushAnnotationCreationModifierFragment : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {}

    fun addBrushAnnotationCreationModifier(surface: SciChartSurface) {
        // <AddBrushAnnotationCreationModifier>
        // Create a BrushAnnotationCreationModifier
        val brushCreationModifier = BrushAnnotationCreationModifier().apply {
            // Configure the modifier
            brushColor = Color.WHITE
            brushThickness = 4f

            // Optional: Set a listener to be notified when an annotation is created
            setAnnotationCreationListener { newAnnotation ->
                // Configure the newly created annotation if needed
                newAnnotation.isEditable = true
            }
        }

        // Add the modifier to the surface
        surface.chartModifiers.add(brushCreationModifier)
        // </AddBrushAnnotationCreationModifier>
    }

    // <CustomBrushAnnotationCreationModifier>
    // Define a custom BrushAnnotationCreationModifier
    private class CustomBrushAnnotationCreationModifier : BrushAnnotationCreationModifier() {
        override fun onTouchDown(args: ModifierTouchEventArgs): Boolean {
            // Custom logic before creation
            return super.onTouchDown(args)
        }

        override fun onTouchMove(args: ModifierTouchEventArgs): Boolean {
            // Custom logic during creation
            return super.onTouchMove(args)
        }

        override fun onTouchUp(args: ModifierTouchEventArgs): Boolean {
            // Custom logic after creation
            return super.onTouchUp(args)
        }
    }

    fun useCustomBrushAnnotationCreationModifier(surface: SciChartSurface) {
        // Use the custom modifier
        val customModifier = CustomBrushAnnotationCreationModifier()
        customModifier.brushColor = Color.YELLOW
        
        surface.chartModifiers.add(customModifier)
    }
    // </CustomBrushAnnotationCreationModifier>
}
