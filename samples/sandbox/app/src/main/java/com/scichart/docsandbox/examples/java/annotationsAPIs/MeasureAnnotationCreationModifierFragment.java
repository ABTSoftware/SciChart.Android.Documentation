package com.scichart.docsandbox.examples.java.annotationsAPIs;

import androidx.annotation.NonNull;

import com.scichart.charting.modifiers.MeasureAnnotationCreationModifier;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.annotations.IAnnotation;
import com.scichart.charting.visuals.annotations.LineAnnotation;
import com.scichart.charting.visuals.annotations.tradingAnnotations.MeasureAnnotation;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;
import com.scichart.drawing.common.SolidPenStyle;

import android.content.Context;
import android.graphics.Color;

@ExampleDefinition()
public class MeasureAnnotationCreationModifierFragment extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) { }

    void addMeasureAnnotationCreationModifier(@NonNull SciChartSurface surface) {
        // <AddMeasureAnnotationCreationModifier>
        // Create a MeasureAnnotationCreationModifier
        final MeasureAnnotationCreationModifier measureCreationModifier = new MeasureAnnotationCreationModifier();

        // Optional: Snap the anchor points of every created annotation to the closest data point
        // of an OHLC series. The series is also used to resolve the bar count reported by the label
        // measureCreationModifier.setSnapSeries(candlestickSeries);

        // Optional: Customize the rubber-band preview line shown while placing the points
        measureCreationModifier.setRubberBandStroke(new SolidPenStyle(Color.WHITE, true, 1.5f, new float[]{5, 5}));

        // Optional: Set a listener to be notified when an annotation is created
        measureCreationModifier.setAnnotationCreationListener(newAnnotation -> {
            // Configure the newly created annotation if needed
            newAnnotation.setIsEditable(true);
        });

        // Add the modifier to the surface
        surface.getChartModifiers().add(measureCreationModifier);
        // </AddMeasureAnnotationCreationModifier>
    }

    // <CustomMeasureAnnotationCreationModifier>
    // Define a custom MeasureAnnotationCreationModifier
    private static class CustomMeasureAnnotationCreationModifier extends MeasureAnnotationCreationModifier {
        @Override
        protected MeasureAnnotation createAnnotation(Context context) {
            final MeasureAnnotation annotation = super.createAnnotation(context);

            // Apply custom default styling to every annotation created by this modifier
            annotation.setGrowingColor(Color.CYAN);
            annotation.setDecliningColor(Color.MAGENTA);
            annotation.setYValueScaleFactor(10000d);

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

    void useCustomMeasureAnnotationCreationModifier(@NonNull SciChartSurface surface) {
        // Use the custom modifier
        final CustomMeasureAnnotationCreationModifier customModifier = new CustomMeasureAnnotationCreationModifier();

        surface.getChartModifiers().add(customModifier);
    }
    // </CustomMeasureAnnotationCreationModifier>
}
