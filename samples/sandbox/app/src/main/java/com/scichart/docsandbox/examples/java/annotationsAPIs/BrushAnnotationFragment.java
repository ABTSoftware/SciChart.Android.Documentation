package com.scichart.docsandbox.examples.java.annotationsAPIs;

import androidx.annotation.NonNull;

import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.annotations.tradingAnnotations.BrushAnnotation;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;
import android.graphics.Color;

@ExampleDefinition()
public class BrushAnnotationFragment extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) { }

    void addBrushAnnotation(@NonNull SciChartSurface surface) {
        // <AddBrushAnnotation>
        // Assume a surface has been created and configured somewhere
        // Create a BrushAnnotation
        final BrushAnnotation brushAnnotation = new BrushAnnotation(getContext());

        // Allow to interact with the annotation in run-time
        brushAnnotation.setIsEditable(true);

        // Specify the brush color and thickness
        brushAnnotation.setBrushColor(Color.WHITE);
        brushAnnotation.setBrushThickness(4f);

        // Add points to the BrushAnnotation
        brushAnnotation.setBasePoint(10, 30.6);
        brushAnnotation.setBasePoint(30, 31.5);
        brushAnnotation.setBasePoint(50, 30.3);

        // Add the annotation to the AnnotationsCollection of a surface
        surface.getAnnotations().add(brushAnnotation);
        // </AddBrushAnnotation>
    }
}
