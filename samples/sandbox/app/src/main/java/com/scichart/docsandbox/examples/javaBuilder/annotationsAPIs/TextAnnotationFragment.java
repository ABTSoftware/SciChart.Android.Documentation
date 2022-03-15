package com.scichart.docsandbox.examples.javaBuilder.annotationsAPIs;

import android.graphics.Color;

import androidx.annotation.NonNull;

import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.annotations.TextAnnotation;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;

@ExampleDefinition()
public class TextAnnotationFragment extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) { }

    void addTextAnnotation(@NonNull SciChartSurface surface) {
        // <AddTextAnnotation>
        // Assume a surface has been created and configured somewhere
        // Create CustomAnnotation instance
        final TextAnnotation textAnnotation = sciChartBuilder.newTextAnnotation()
                // Set the text
                .withText("Text can be Rotated")
                // Specify a FontStyle for the text
                .withFontStyle(20, 0xBBFC9C29)
                // Specify rotation Angle in Degrees if needed
                .withRotationAngle(-30)
                // Specify a desired position
                .withPosition(20, 14)
                // Allow to interact with the annotation in run-time
                .withIsEditable(true)
                // In a multi-axis scenario, specify the XAxisId and YAxisId
                .withXAxisId("BottomAxisId")
                .withYAxisId("LeftAxisId")
                .build();

        // Add the annotation to the Annotations collection of the surface
        surface.getAnnotations().add(textAnnotation);
        // </AddTextAnnotation>
    }

    void editTextAnnotation() {
        // <EditTextAnnotation>
        final TextAnnotation editTextAnnotation = sciChartBuilder.newTextAnnotation()
                .withIsEditable(true)
                .withCanEditText(true)
                .withXAxisId("BottomAxisId")
                .withYAxisId("LeftAxisId")
                .withPosition(80, 14)
                .withText("and edited ...")
                .withFontStyle(20, Color.YELLOW)
                .build();
        // </EditTextAnnotation>
    }
}
