package com.scichart.docsandbox.examples.java.annotationsAPIs;

import androidx.annotation.NonNull;

import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.annotations.tradingAnnotations.PitchforkAnnotation;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;
import com.scichart.drawing.common.SolidBrushStyle;
import com.scichart.drawing.common.SolidPenStyle;
import android.graphics.Color;

@ExampleDefinition()
public class PitchforkAnnotationFragment extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) { }

    void addPitchforkAnnotation(@NonNull SciChartSurface surface) {
        // <AddPitchforkAnnotation>
        // Assume a surface has been created and configured somewhere
        // Create a PitchforkAnnotation
        final PitchforkAnnotation pitchforkAnnotation = new PitchforkAnnotation(getContext());

        // Allow to interact with the annotation in run-time
        pitchforkAnnotation.setIsEditable(true);

        // Specify the stroke and fill styles
        pitchforkAnnotation.setStroke(new SolidPenStyle(Color.RED, true, 2f, null));
        pitchforkAnnotation.setSidesFill(new SolidBrushStyle(Color.GREEN));
        pitchforkAnnotation.setMiddleFill(new SolidBrushStyle(Color.BLUE));

        // Add 3 points to define the pitchfork
        pitchforkAnnotation.setBasePoint(10, 30.6); // Handle (Point 0)
        pitchforkAnnotation.setBasePoint(30, 31.5); // High (Point 1)
        pitchforkAnnotation.setBasePoint(50, 30.3); // Low (Point 2)

        // Add the annotation to the AnnotationsCollection of a surface
        surface.getAnnotations().add(pitchforkAnnotation);
        // </AddPitchforkAnnotation>
    }
}
