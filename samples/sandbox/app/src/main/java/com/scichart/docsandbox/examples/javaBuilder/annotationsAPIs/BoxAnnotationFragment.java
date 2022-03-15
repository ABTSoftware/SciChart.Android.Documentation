package com.scichart.docsandbox.examples.javaBuilder.annotationsAPIs;

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
        BoxAnnotation boxAnnotation = sciChartBuilder.newBoxAnnotation()
                // Allow to interact with the annotation in run-time
                .withIsEditable(true)
                // in a multi-axis scenario, specify the XAxisId and YAxisId
                .withXAxisId("TopAxisId")
                .withYAxisId("LeftAxisId")
                // Specify a desired position by setting coordinates
                .withPosition(20.0f, 10.0f, 90.0f, 4.0f)
                // Specify the background resource
                .withBackgroundDrawableId(R.drawable.example_box_annotation_background)
                .build();

        // Add the annotation to the AnnotationsCollection of a surface
        surface.getAnnotations().add(boxAnnotation);
        // </AddBoxAnnotation>
    }
}
