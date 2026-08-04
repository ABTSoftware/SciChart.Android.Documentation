package com.scichart.docsandbox.examples.java.annotationsAPIs;

import androidx.annotation.NonNull;

import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.annotations.tradingAnnotations.FreehandDrawingAnnotation;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;
import android.graphics.Color;

@ExampleDefinition()
public class FreehandDrawingAnnotationFragment extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) { }

    void addFreehandDrawingAnnotation(@NonNull SciChartSurface surface) {
        // <AddFreehandDrawingAnnotation>
        // Assume a surface has been created and configured somewhere
        // Create a FreehandDrawingAnnotation
        final FreehandDrawingAnnotation freehandAnnotation = new FreehandDrawingAnnotation(getContext());

        // Allow to interact with the annotation in run-time
        freehandAnnotation.setIsEditable(true);

        // Specify the brush color and thickness
        freehandAnnotation.setBrushColor(Color.WHITE);
        freehandAnnotation.setBrushThickness(4f);

        // Add points to the FreehandDrawingAnnotation
        freehandAnnotation.setBasePoint(10, 30.6);
        freehandAnnotation.setBasePoint(30, 31.5);
        freehandAnnotation.setBasePoint(50, 30.3);

        // Add the annotation to the AnnotationsCollection of a surface
        surface.getAnnotations().add(freehandAnnotation);
        // </AddFreehandDrawingAnnotation>
    }
}
