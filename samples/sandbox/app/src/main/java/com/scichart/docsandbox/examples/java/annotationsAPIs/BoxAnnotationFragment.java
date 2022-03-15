package com.scichart.docsandbox.examples.java.annotationsAPIs;

import androidx.annotation.NonNull;

import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.annotations.BoxAnnotation;
import com.scichart.docsandbox.R;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;

@ExampleDefinition()
public class BoxAnnotationFragment extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) { }

    void addBoxAnnotation(@NonNull SciChartSurface surface) {
        // <AddBoxAnnotation>
        // Assume a surface has been created and configured somewhere
        // Create a BoxAnnotation
        final BoxAnnotation boxAnnotation = new BoxAnnotation(getContext());

        // Allow to interact with the annotation in run-time
        boxAnnotation.setIsEditable(true);

        // in a multi-axis scenario, specify the XAxisId and YAxisId
        boxAnnotation.setXAxisId("TopAxisId");
        boxAnnotation.setYAxisId("LeftAxisId");

        // Specify a desired position by setting coordinates
        boxAnnotation.setX(20.0f);
        boxAnnotation.setY1(10.0f);
        boxAnnotation.setX2(90.0f);
        boxAnnotation.setY2(4.0f);

        // Specify the background resource
        boxAnnotation.setBackgroundResource(R.drawable.example_box_annotation_background);

        // Add the annotation to the AnnotationsCollection of a surface
        surface.getAnnotations().add(boxAnnotation);
        // </AddBoxAnnotation>
    }
}
