package com.scichart.docsandbox.examples.javaBuilder.annotationsAPIs;

import androidx.annotation.NonNull;

import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.annotations.AnnotationCoordinateMode;
import com.scichart.charting.visuals.annotations.LineAnnotation;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;

@ExampleDefinition()
public class LineAnnotationFragment extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) { }

    void addLineAnnotation(@NonNull SciChartSurface surface) {
        // <AddLineAnnotation>
        // Assume a surface has been created and configured somewhere
        // Create a Line Annotation
        final LineAnnotation lineAnnotation = sciChartBuilder.newLineAnnotation()
                // Allow to interact with the annotation in run-time
                .withIsEditable(true)
                // In a multi-axis scenario, specify the XAxisId and YAxisId
                .withXAxisId("TopAxisId")
                .withYAxisId("LeftAxisId")
                // Specify a desired position by setting coordinates
                .withCoordinateMode(AnnotationCoordinateMode.RelativeY)
                .withPosition(20, 0.2, 60, 0.8)
                // Specify the thickness and the stroke color for the annotation
                .withStroke(4f, 0x9942AD42)
                .build();

        // Add the annotation to the Annotations collection of the surface
        surface.getAnnotations().add(lineAnnotation);
        // </AddLineAnnotation>
    }
}
