package com.scichart.docsandbox.examples.java.annotationsAPIs;

import androidx.annotation.NonNull;

import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.annotations.tradingAnnotations.XabcdAnnotation;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;
import com.scichart.drawing.common.SolidBrushStyle;
import com.scichart.drawing.common.SolidPenStyle;
import android.graphics.Color;

@ExampleDefinition()
public class XabcdAnnotationFragment extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) { }

    void addXabcdAnnotation(@NonNull SciChartSurface surface) {
        // <AddXabcdAnnotation>
        // Assume a surface has been created and configured somewhere
        // Create an XabcdAnnotation
        final XabcdAnnotation xabcdAnnotation = new XabcdAnnotation(getContext());

        // Allow to interact with the annotation in run-time
        xabcdAnnotation.setIsEditable(true);

        // Specify the stroke and fill
        xabcdAnnotation.setStroke(new SolidPenStyle(Color.YELLOW, true, 2f, null));
        xabcdAnnotation.setFill(new SolidBrushStyle(Color.BLUE));

        // Add 5 points (X, A, B, C, D)
        xabcdAnnotation.setBasePoint(10, 30.6); // X
        xabcdAnnotation.setBasePoint(30, 31.5); // A
        xabcdAnnotation.setBasePoint(50, 30.3); // B
        xabcdAnnotation.setBasePoint(70, 31.5); // C
        xabcdAnnotation.setBasePoint(90, 30.6); // D

        // Add the annotation to the AnnotationsCollection of a surface
        surface.getAnnotations().add(xabcdAnnotation);
        // </AddXabcdAnnotation>
    }
}
