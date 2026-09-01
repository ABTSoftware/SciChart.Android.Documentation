package com.scichart.docsandbox.examples.java.annotationsAPIs;

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
        // Create a StopLossTakeProfitAnnotation
        final StopLossTakeProfitAnnotation stopLossTakeProfitAnnotation = new StopLossTakeProfitAnnotation(getContext());

        // Allow to interact with the annotation in run-time
        stopLossTakeProfitAnnotation.setIsEditable(true);

        // Specify the colors used for the upwards (take-profit) and the downwards (stop-loss) zone
        stopLossTakeProfitAnnotation.setTakeProfitColor(Color.GREEN);
        stopLossTakeProfitAnnotation.setStopLossColor(Color.RED);

        // Specify the zone appearance
        stopLossTakeProfitAnnotation.setFillOpacity(0.2f);
        stopLossTakeProfitAnnotation.setStrokeThickness(2f);
        stopLossTakeProfitAnnotation.setStrokeDashArray(new float[]{6f, 3f});

        // Show the price change label in the center of the zone
        stopLossTakeProfitAnnotation.setShowDistanceLabel(true);

        // Add 2 points which define the opposite corners of the zone.
        // Here the second point is above the first one, so this is a take-profit zone
        stopLossTakeProfitAnnotation.setBasePoint(10, 33.0); // Point 0 - the reference price
        stopLossTakeProfitAnnotation.setBasePoint(30, 34.2); // Point 1 - the target price

        // Add the annotation to the AnnotationsCollection of a surface
        surface.getAnnotations().add(stopLossTakeProfitAnnotation);
        // </AddStopLossTakeProfitAnnotation>
    }
}
