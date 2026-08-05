package com.scichart.docsandbox.examples.javaBuilder.annotationsAPIs;

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
        // Create an XabcdAnnotation using the SciChartBuilder
        final XabcdAnnotation xabcdAnnotation = sciChartBuilder.newXabcdAnnotation()
                .withStroke(new SolidPenStyle(Color.YELLOW, true, 2f, null))
                .withFill(new SolidBrushStyle(Color.BLUE))
                .withBasePoint(10, 30.6)
                .withBasePoint(30, 31.5)
                .withBasePoint(50, 30.3)
                .withBasePoint(70, 31.5)
                .withBasePoint(90, 30.6)
                .withIsEditable(true)
                .build();

        // Add the annotation to the AnnotationsCollection of a surface
        surface.getAnnotations().add(xabcdAnnotation);
        // </AddXabcdAnnotation>
    }
}
