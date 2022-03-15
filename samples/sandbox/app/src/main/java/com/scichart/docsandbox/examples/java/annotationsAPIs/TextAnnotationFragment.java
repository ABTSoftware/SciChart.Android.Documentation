package com.scichart.docsandbox.examples.java.annotationsAPIs;

import android.graphics.Color;

import androidx.annotation.NonNull;

import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.annotations.TextAnnotation;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;
import com.scichart.drawing.common.FontStyle;

@ExampleDefinition()
public class TextAnnotationFragment extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) { }

    void addTextAnnotation(@NonNull SciChartSurface surface) {
        // <AddTextAnnotation>
        // Assume a surface has been created and configured somewhere
        // Create CustomAnnotation instance
        final TextAnnotation textAnnotation = new TextAnnotation(getContext());

        // Set the text
        textAnnotation.setText("Text can be Rotated");

        // Specify a FontStyle for the text
        textAnnotation.setFontStyle(new FontStyle(20, 0xBBFC9C29));

        // Specify rotation Angle in Degrees if needed
        textAnnotation.setRotationAngle(-30);

        // Specify a desired position
        textAnnotation.setX1(20);
        textAnnotation.setY1(14);

        // Allow to interact with the annotation in run-time
        textAnnotation.setIsEditable(true);

        // In a multi-axis scenario, specify the XAxisId and YAxisId
        textAnnotation.setXAxisId("BottomAxisId");
        textAnnotation.setYAxisId("LeftAxisId");

        // Add the annotation to the Annotations collection of the surface
        surface.getAnnotations().add(textAnnotation);
        // </AddTextAnnotation>
    }

    void editTextAnnotation() {
        // <EditTextAnnotation>
        final TextAnnotation editTextAnnotation = new TextAnnotation(getContext());
        editTextAnnotation.setIsEditable(true);
        editTextAnnotation.setCanEditText(true);
        editTextAnnotation.setXAxisId("BottomAxisId");
        editTextAnnotation.setYAxisId("LeftAxisId");
        editTextAnnotation.setX1(80);
        editTextAnnotation.setY1(14);
        editTextAnnotation.setText("and edited ...");
        editTextAnnotation.setFontStyle(new FontStyle(20, Color.YELLOW));
        // </EditTextAnnotation>
    }
}
