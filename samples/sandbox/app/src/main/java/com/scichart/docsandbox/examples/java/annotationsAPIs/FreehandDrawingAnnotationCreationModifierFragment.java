package com.scichart.docsandbox.examples.java.annotationsAPIs;

import androidx.annotation.NonNull;

import com.scichart.charting.modifiers.FreehandDrawingModifier;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.annotations.IAnnotation;
import com.scichart.core.utility.touch.ModifierTouchEventArgs;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;
import android.graphics.Color;

@ExampleDefinition()
public class FreehandDrawingAnnotationCreationModifierFragment extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) { }

    void addFreehandDrawingAnnotationCreationModifier(@NonNull SciChartSurface surface) {
        // <AddFreehandDrawingAnnotationCreationModifier>
        // Create a FreehandDrawingModifier
        final FreehandDrawingModifier freehandModifier = new FreehandDrawingModifier();

        // Configure the modifier
        freehandModifier.setBrushColor(Color.WHITE);
        freehandModifier.setBrushThickness(4f);

        // Optional: Set a listener to be notified when an annotation is created
        freehandModifier.setAnnotationCreationListener(newAnnotation -> {
            // Configure the newly created annotation if needed
            newAnnotation.setIsEditable(true);
        });

        // Add the modifier to the surface
        surface.getChartModifiers().add(freehandModifier);
        // </AddFreehandDrawingAnnotationCreationModifier>
    }

    // <CustomFreehandDrawingAnnotationCreationModifier>
    // Define a custom FreehandDrawingModifier
    private static class CustomFreehandDrawingModifier extends FreehandDrawingModifier {
        @Override
        protected boolean onTouchDown(ModifierTouchEventArgs args) {
            // Custom logic before creation
            return super.onTouchDown(args);
        }

        @Override
        protected boolean onTouchMove(ModifierTouchEventArgs args) {
            // Custom logic during creation
            return super.onTouchMove(args);
        }

        @Override
        protected boolean onTouchUp(ModifierTouchEventArgs args) {
            // Custom logic after creation
            return super.onTouchUp(args);
        }
    }

    void useCustomFreehandDrawingModifier(@NonNull SciChartSurface surface) {
        // Use the custom modifier
        final CustomFreehandDrawingModifier customModifier = new CustomFreehandDrawingModifier();
        customModifier.setBrushColor(Color.YELLOW);
        
        surface.getChartModifiers().add(customModifier);
    }
    // </CustomFreehandDrawingAnnotationCreationModifier>
}
