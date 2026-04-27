package com.scichart.docsandbox.examples.java.annotationsAPIs;

import androidx.annotation.NonNull;

import com.scichart.charting.modifiers.XabcdAnnotationCreationModifier;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.annotations.IAnnotation;
import com.scichart.charting.visuals.annotations.LineAnnotation;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;
import com.scichart.drawing.common.SolidPenStyle;
import android.graphics.Color;

@ExampleDefinition()
public class XabcdAnnotationCreationModifierFragment extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) { }

    void addXabcdAnnotationCreationModifier(@NonNull SciChartSurface surface) {
        // <AddXabcdAnnotationCreationModifier>
        // Create an XabcdAnnotationCreationModifier
        final XabcdAnnotationCreationModifier xabcdCreationModifier = new XabcdAnnotationCreationModifier();

        // Optional: Set a listener to be notified when an annotation is created
        xabcdCreationModifier.setAnnotationCreationListener(newAnnotation -> {
            // Configure the newly created annotation if needed
            newAnnotation.setIsEditable(true);
        });

        // Add the modifier to the surface
        surface.getChartModifiers().add(xabcdCreationModifier);
        // </AddXabcdAnnotationCreationModifier>
    }

    // <CustomXabcdAnnotationCreationModifier>
    // Define a custom XabcdAnnotationCreationModifier
    private static class CustomXabcdAnnotationCreationModifier extends XabcdAnnotationCreationModifier {
        @Override
        protected void configureRubberBandAnnotation(IAnnotation annotation) {
            super.configureRubberBandAnnotation(annotation);
            
            // Customize the rubber-band styling
            if (annotation instanceof LineAnnotation) {
                ((LineAnnotation) annotation).setStroke(new SolidPenStyle(Color.YELLOW, true, 2f, new float[]{10, 5}));
            }
        }

        @Override
        protected void onAnnotationCreated(IAnnotation newAnnotation) {
            super.onAnnotationCreated(newAnnotation);
            
            // Custom logic after annotation is fully created
            newAnnotation.setIsEditable(true);
        }
    }

    void useCustomXabcdAnnotationCreationModifier(@NonNull SciChartSurface surface) {
        // Use the custom modifier
        final CustomXabcdAnnotationCreationModifier customModifier = new CustomXabcdAnnotationCreationModifier();
        
        surface.getChartModifiers().add(customModifier);
    }
    // </CustomXabcdAnnotationCreationModifier>
}
