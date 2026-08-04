package com.scichart.docsandbox.examples.java.annotationsAPIs;

import androidx.annotation.NonNull;

import com.scichart.charting.modifiers.PitchforkAnnotationCreationModifier;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.annotations.IAnnotation;
import com.scichart.charting.visuals.annotations.LineAnnotation;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;
import com.scichart.drawing.common.SolidPenStyle;
import android.graphics.Color;

@ExampleDefinition()
public class PitchforkAnnotationCreationModifierFragment extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) { }

    void addPitchforkAnnotationCreationModifier(@NonNull SciChartSurface surface) {
        // <AddPitchforkAnnotationCreationModifier>
        // Create a PitchforkAnnotationCreationModifier
        final PitchforkAnnotationCreationModifier pitchforkCreationModifier = new PitchforkAnnotationCreationModifier();

        // Optional: Set a listener to be notified when an annotation is created
        pitchforkCreationModifier.setAnnotationCreationListener(newAnnotation -> {
            // Configure the newly created annotation if needed
            newAnnotation.setIsEditable(true);
        });

        // Add the modifier to the surface
        surface.getChartModifiers().add(pitchforkCreationModifier);
        // </AddPitchforkAnnotationCreationModifier>
    }

    // <CustomPitchforkAnnotationCreationModifier>
    // Define a custom PitchforkAnnotationCreationModifier
    private static class CustomPitchforkAnnotationCreationModifier extends PitchforkAnnotationCreationModifier {
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

    void useCustomPitchforkAnnotationCreationModifier(@NonNull SciChartSurface surface) {
        // Use the custom modifier
        final CustomPitchforkAnnotationCreationModifier customModifier = new CustomPitchforkAnnotationCreationModifier();
        
        surface.getChartModifiers().add(customModifier);
    }
    // </CustomPitchforkAnnotationCreationModifier>
}
