package com.scichart.docsandbox.examples.java.annotationsAPIs;

import androidx.annotation.NonNull;

import com.scichart.charting.modifiers.StopLossTakeProfitAnnotationCreationModifier;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.annotations.IAnnotation;
import com.scichart.charting.visuals.annotations.LineAnnotation;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;
import com.scichart.drawing.common.SolidPenStyle;
import android.graphics.Color;

@ExampleDefinition()
public class StopLossTakeProfitAnnotationCreationModifierFragment extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) { }

    void addStopLossTakeProfitAnnotationCreationModifier(@NonNull SciChartSurface surface) {
        // <AddStopLossTakeProfitAnnotationCreationModifier>
        // Create a StopLossTakeProfitAnnotationCreationModifier
        final StopLossTakeProfitAnnotationCreationModifier stopLossTakeProfitCreationModifier = new StopLossTakeProfitAnnotationCreationModifier();

        // Optional: Customize the rubber-band preview line shown while placing the points
        stopLossTakeProfitCreationModifier.setRubberBandStroke(new SolidPenStyle(Color.WHITE, true, 1.5f, new float[]{5, 5}));

        // Optional: Set a listener to be notified when an annotation is created
        stopLossTakeProfitCreationModifier.setAnnotationCreationListener(newAnnotation -> {
            // Configure the newly created annotation if needed
            newAnnotation.setIsEditable(true);
        });

        // Add the modifier to the surface
        surface.getChartModifiers().add(stopLossTakeProfitCreationModifier);
        // </AddStopLossTakeProfitAnnotationCreationModifier>
    }

    // <CustomStopLossTakeProfitAnnotationCreationModifier>
    // Define a custom StopLossTakeProfitAnnotationCreationModifier
    private static class CustomStopLossTakeProfitAnnotationCreationModifier extends StopLossTakeProfitAnnotationCreationModifier {
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

    void useCustomStopLossTakeProfitAnnotationCreationModifier(@NonNull SciChartSurface surface) {
        // Use the custom modifier
        final CustomStopLossTakeProfitAnnotationCreationModifier customModifier = new CustomStopLossTakeProfitAnnotationCreationModifier();

        surface.getChartModifiers().add(customModifier);
    }
    // </CustomStopLossTakeProfitAnnotationCreationModifier>
}
