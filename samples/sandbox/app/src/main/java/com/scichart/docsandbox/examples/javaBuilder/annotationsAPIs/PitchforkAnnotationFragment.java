package com.scichart.docsandbox.examples.javaBuilder.annotationsAPIs;

import androidx.annotation.NonNull;

import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.annotations.tradingAnnotations.PitchforkAnnotation;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;
import com.scichart.drawing.common.BrushStyle;
import com.scichart.drawing.common.SolidBrushStyle;

import android.graphics.Color;

@ExampleDefinition()
public class PitchforkAnnotationFragment extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) { }

    void addPitchforkAnnotation(@NonNull SciChartSurface surface) {
        // <AddPitchforkAnnotation>
        // Assume a surface has been created and configured somewhere
        // Create a PitchforkAnnotation using the SciChartBuilder
        final PitchforkAnnotation pitchforkAnnotation = sciChartBuilder.newPitchforkAnnotation()
                .withStroke(2f, Color.RED)
                .withFullWidthZoneFill(new SolidBrushStyle(Color.GREEN))
                .withHalfWidthZoneFill(new SolidBrushStyle(Color.BLUE))
                .withBasePoint(10, 30.6)
                .withBasePoint(30, 31.5)
                .withBasePoint(50, 30.3)
                .withIsEditable(true)
                .build();

        // Add the annotation to the AnnotationsCollection of a surface
        surface.getAnnotations().add(pitchforkAnnotation);
        // </AddPitchforkAnnotation>
    }
}
