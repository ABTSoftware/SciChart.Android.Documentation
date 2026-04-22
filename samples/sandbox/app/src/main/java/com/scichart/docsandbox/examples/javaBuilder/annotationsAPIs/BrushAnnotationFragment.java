package com.scichart.docsandbox.examples.javaBuilder.annotationsAPIs;

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
        // Create a BrushAnnotation using the SciChartBuilder
        final BrushAnnotation brushAnnotation = sciChartBuilder.newBrushAnnotation()
                .withBrushColor(Color.WHITE)
                .withBrushThickness(4f)
                .withBasePoint(10, 30.6)
                .withBasePoint(30, 31.5)
                .withBasePoint(50, 30.3)
                .withIsEditable(true)
                .build();

        // Add the annotation to the AnnotationsCollection of a surface
        surface.getAnnotations().add(brushAnnotation);
        // </AddBrushAnnotation>
    }
}
