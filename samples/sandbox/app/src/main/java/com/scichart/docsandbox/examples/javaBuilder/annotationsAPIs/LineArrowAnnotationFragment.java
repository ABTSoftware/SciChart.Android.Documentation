package com.scichart.docsandbox.examples.javaBuilder.annotationsAPIs;

import android.graphics.Color;

import androidx.annotation.NonNull;

import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.annotations.AnnotationCoordinateMode;
import com.scichart.charting.visuals.annotations.LineArrowAnnotation;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;

@ExampleDefinition()
public class LineArrowAnnotationFragment extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) { }

    void addLineArrowAnnotation(@NonNull SciChartSurface surface) {
        // <AddLineArrowAnnotation>
        // Assume a surface has been created and configured somewhere
        // Create a Line Annotation
        final LineArrowAnnotation lineArrowAnnotation = sciChartBuilder.newLineArrowAnnotation()
                // Allow to interact with the annotation in run-time
                .withIsEditable(true)
                // In a multi-axis scenario, specify the XAxisId and YAxisId
                .withXAxisId("TopAxisId")
                .withYAxisId("LeftAxisId")
                // Specify size for the arrow's head
                .withArrowHeadLength(4)
                .withArrowHeadWidth(8)
                // Specify a desired position by setting coordinates
                .withCoordinateMode(AnnotationCoordinateMode.RelativeY)
                .withPosition(40, 0.8, 100, 0.2)
                // Specify the thickness and the stroke color for the annotation
                .withStroke(2f, Color.YELLOW)
                .build();

        // Add the annotation to the Annotations collection of the surface
        surface.getAnnotations().add(lineArrowAnnotation);
        // </AddLineArrowAnnotation>
    }
}
