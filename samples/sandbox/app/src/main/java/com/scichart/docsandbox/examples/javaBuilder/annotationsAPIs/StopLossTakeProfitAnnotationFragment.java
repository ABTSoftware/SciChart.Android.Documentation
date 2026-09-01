package com.scichart.docsandbox.examples.javaBuilder.annotationsAPIs;

import androidx.annotation.NonNull;

import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.annotations.tradingAnnotations.StopLossTakeProfitAnnotation;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;

import android.graphics.Color;

@ExampleDefinition()
public class StopLossTakeProfitAnnotationFragment extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) { }

    void addStopLossTakeProfitAnnotation(@NonNull SciChartSurface surface) {
        // <AddStopLossTakeProfitAnnotation>
        // Assume a surface has been created and configured somewhere
        // Create a StopLossTakeProfitAnnotation using the SciChartBuilder
        final StopLossTakeProfitAnnotation stopLossTakeProfitAnnotation = sciChartBuilder.newStopLossTakeProfitAnnotation()
                .withTakeProfitColor(Color.GREEN)
                .withStopLossColor(Color.RED)
                .withFillOpacity(0.2f)
                .withStrokeThickness(2f)
                .withStrokeDashArray(new float[]{6f, 3f})
                .withShowDistanceLabel(true)
                .withBasePoint(10, 33.0)
                .withBasePoint(30, 34.2)
                .withIsEditable(true)
                .build();

        // Add the annotation to the AnnotationsCollection of a surface
        surface.getAnnotations().add(stopLossTakeProfitAnnotation);
        // </AddStopLossTakeProfitAnnotation>
    }
}
