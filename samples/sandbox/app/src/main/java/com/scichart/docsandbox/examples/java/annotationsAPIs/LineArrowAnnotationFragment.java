package com.scichart.docsandbox.examples.java.annotationsAPIs;

import android.graphics.Color;

import androidx.annotation.NonNull;

import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.annotations.AnnotationCoordinateMode;
import com.scichart.charting.visuals.annotations.LineArrowAnnotation;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;
import com.scichart.drawing.common.SolidPenStyle;

@ExampleDefinition()
public class LineArrowAnnotationFragment extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) { }

    void addLineArrowAnnotation(@NonNull SciChartSurface surface) {
        // <AddLineArrowAnnotation>
        // Assume a surface has been created and configured somewhere
        // Create a LineArrow Annotation
        final LineArrowAnnotation lineArrowAnnotation = new LineArrowAnnotation(getContext());

        // Allow to interact with the annotation in run-time
        lineArrowAnnotation.setIsEditable(true);

        // in a multi-axis scenario, specify the XAxisId and YAxisId
        lineArrowAnnotation.setXAxisId("TopAxisId");
        lineArrowAnnotation.setYAxisId("LeftAxisId");

        // Specify size for the arrow's head
        lineArrowAnnotation.setHeadLength(4);
        lineArrowAnnotation.setHeadWidth(8);

        // Specify a desired position by setting coordinates
        lineArrowAnnotation.setCoordinateMode(AnnotationCoordinateMode.RelativeY);
        lineArrowAnnotation.setX1(40);
        lineArrowAnnotation.setY1(0.8);
        lineArrowAnnotation.setX2(100);
        lineArrowAnnotation.setY2(0.2);

        // Specify the stroke color for the annotation
        lineArrowAnnotation.setStroke(new SolidPenStyle(Color.YELLOW, true, 2f, null));

        // Add the annotation to the Annotations collection of the surface
        surface.getAnnotations().add(lineArrowAnnotation);
        // </AddLineArrowAnnotation>
    }
}
