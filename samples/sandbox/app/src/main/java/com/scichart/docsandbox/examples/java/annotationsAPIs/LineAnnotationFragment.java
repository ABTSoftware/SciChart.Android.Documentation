package com.scichart.docsandbox.examples.java.annotationsAPIs;

import androidx.annotation.NonNull;

import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.annotations.AnnotationCoordinateMode;
import com.scichart.charting.visuals.annotations.LineAnnotation;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;
import com.scichart.drawing.common.SolidPenStyle;

@ExampleDefinition()
public class LineAnnotationFragment extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) { }

    void addLineAnnotation(@NonNull SciChartSurface surface) {
        // <AddLineAnnotation>
        // Assume a surface has been created and configured somewhere
        // Create a Line Annotation
        final LineAnnotation lineAnnotation = new LineAnnotation(getContext());

        // Allow to interact with the annotation in run-time
        lineAnnotation.setIsEditable(true);

        // In a multi-axis scenario, specify the XAxisId and YAxisId
        lineAnnotation.setXAxisId("TopAxisId");
        lineAnnotation.setYAxisId("LeftAxisId");

        // Specify a desired position by setting coordinates
        lineAnnotation.setCoordinateMode(AnnotationCoordinateMode.RelativeY);
        lineAnnotation.setX1(20);
        lineAnnotation.setY1(0.2);
        lineAnnotation.setX2(60);
        lineAnnotation.setY2(0.8);

        // Specify the stroke color for the annotation
        lineAnnotation.setStroke(new SolidPenStyle(0x9942AD42, true, 4f, null));

        // Add the annotation to the Annotations collection of the surface
        surface.getAnnotations().add(lineAnnotation);
        // </AddLineAnnotation>
    }
}
