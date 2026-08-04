package com.scichart.docsandbox.examples.kotlin.annotationsAPIs

import com.scichart.charting.modifiers.FreehandDrawingModifier
import com.scichart.charting.visuals.SciChartSurface
import com.scichart.core.utility.touch.ModifierTouchEventArgs
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment
import android.graphics.Color

@ExampleDefinition()
class FreehandDrawingAnnotationCreationModifierFragment : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {}

    fun addFreehandDrawingAnnotationCreationModifier(surface: SciChartSurface) {
        // <AddFreehandDrawingAnnotationCreationModifier>
        // Create a FreehandDrawingModifier
        val freehandModifier = FreehandDrawingModifier().apply {
            // Configure the modifier
            brushColor = Color.WHITE
            brushThickness = 4f

            // Optional: Set a listener to be notified when an annotation is created
            setAnnotationCreationListener { newAnnotation ->
                // Configure the newly created annotation if needed
                newAnnotation.setIsEditable(true)
            }
        }

        // Add the modifier to the surface
        surface.chartModifiers.add(freehandModifier)
        // </AddFreehandDrawingAnnotationCreationModifier>
    }

    // <CustomFreehandDrawingAnnotationCreationModifier>
    // Define a custom FreehandDrawingModifier
    private class CustomFreehandDrawingModifier : FreehandDrawingModifier() {
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

    fun useCustomFreehandDrawingModifier(surface: SciChartSurface) {
        // Use the custom modifier
        val customModifier = CustomFreehandDrawingModifier()
        customModifier.brushColor = Color.YELLOW
        
        surface.chartModifiers.add(customModifier)
    }
    // </CustomFreehandDrawingAnnotationCreationModifier>
}
