package com.scichart.docsandbox.examples.java.annotationsAPIs;

import androidx.annotation.NonNull;

import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.annotations.tradingAnnotations.MeasureAnnotation;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;

import android.graphics.Color;

@ExampleDefinition()
public class MeasureAnnotationFragment extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) { }

    void addMeasureAnnotation(@NonNull SciChartSurface surface) {
        // <AddMeasureAnnotation>
        // Assume a surface has been created and configured somewhere
        // Create a MeasureAnnotation
        final MeasureAnnotation measureAnnotation = new MeasureAnnotation(getContext());

        // Allow to interact with the annotation in run-time
        measureAnnotation.setIsEditable(true);

        // Specify the colors used for the upwards (growing) and the downwards (declining) move
        measureAnnotation.setGrowingColor(Color.BLUE);
        measureAnnotation.setDecliningColor(Color.RED);

        // Specify the box appearance and show the measuring arrows
        measureAnnotation.setFillOpacity(0.2f);
        measureAnnotation.setStrokeThickness(1.5f);
        measureAnnotation.setShowArrows(true);

        // Optionally snap both anchor points to the closest data point of an OHLC series.
        // The series is also used to resolve the bar count reported by the label
        // measureAnnotation.setSnapSeries(candlestickSeries);
        // measureAnnotation.setSnapToDataPointRadius(15f);

        // Add 2 points which define the opposite corners of the measured region
        measureAnnotation.setBasePoint(10, 30.6); // Point 0 - the start of the move
        measureAnnotation.setBasePoint(30, 32.1); // Point 1 - the end of the move

        // Add the annotation to the AnnotationsCollection of a surface
        surface.getAnnotations().add(measureAnnotation);
        // </AddMeasureAnnotation>
    }
}
