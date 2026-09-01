package com.scichart.docsandbox.examples.java.annotationsAPIs;

import androidx.annotation.NonNull;

import com.scichart.charting.modifiers.FibonacciRetracementAnnotationCreationModifier;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.annotations.IAnnotation;
import com.scichart.charting.visuals.annotations.LineAnnotation;
import com.scichart.charting.visuals.annotations.tradingAnnotations.FibonacciRetracementAnnotation;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;
import com.scichart.drawing.common.SolidPenStyle;

import java.util.Arrays;

import android.content.Context;
import android.graphics.Color;

@ExampleDefinition()
public class FibonacciRetracementAnnotationCreationModifierFragment extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) { }

    void addFibonacciRetracementAnnotationCreationModifier(@NonNull SciChartSurface surface) {
        // <AddFibonacciRetracementAnnotationCreationModifier>
        // Create a FibonacciRetracementAnnotationCreationModifier
        final FibonacciRetracementAnnotationCreationModifier fibonacciCreationModifier = new FibonacciRetracementAnnotationCreationModifier();

        // Optional: Configure how the labels of every created annotation are placed and formatted
        fibonacciCreationModifier.setLabelPlacement(FibonacciRetracementAnnotation.LabelPlacement.CENTER);
        fibonacciCreationModifier.setLabelFormat(FibonacciRetracementAnnotation.LabelFormat.RATIO);
        fibonacciCreationModifier.setLabelVerticalPosition(FibonacciRetracementAnnotation.LabelVerticalPosition.ABOVE);

        // Optional: Customize the rubber-band preview line shown while placing the points
        fibonacciCreationModifier.setRubberBandStroke(new SolidPenStyle(Color.WHITE, true, 1.5f, new float[]{5, 5}));

        // Optional: Set a listener to be notified when an annotation is created
        fibonacciCreationModifier.setAnnotationCreationListener(newAnnotation -> {
            // Configure the newly created annotation if needed
            newAnnotation.setIsEditable(true);
        });

        // Add the modifier to the surface
        surface.getChartModifiers().add(fibonacciCreationModifier);
        // </AddFibonacciRetracementAnnotationCreationModifier>
    }

    // <CustomFibonacciRetracementAnnotationCreationModifier>
    // Define a custom FibonacciRetracementAnnotationCreationModifier
    private static class CustomFibonacciRetracementAnnotationCreationModifier extends FibonacciRetracementAnnotationCreationModifier {
        @Override
        protected FibonacciRetracementAnnotation createAnnotation(Context context) {
            final FibonacciRetracementAnnotation annotation = super.createAnnotation(context);

            // Apply a custom set of Fibonacci levels to every annotation created by this modifier.
            // Note the label properties of the modifier have already been applied by super
            annotation.setLevels(Arrays.asList(0d, 0.382, 0.618, 1d));
            annotation.setFillOpacity(0.2f);

            return annotation;
        }

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

    void useCustomFibonacciRetracementAnnotationCreationModifier(@NonNull SciChartSurface surface) {
        // Use the custom modifier
        final CustomFibonacciRetracementAnnotationCreationModifier customModifier = new CustomFibonacciRetracementAnnotationCreationModifier();

        surface.getChartModifiers().add(customModifier);
    }
    // </CustomFibonacciRetracementAnnotationCreationModifier>
}
