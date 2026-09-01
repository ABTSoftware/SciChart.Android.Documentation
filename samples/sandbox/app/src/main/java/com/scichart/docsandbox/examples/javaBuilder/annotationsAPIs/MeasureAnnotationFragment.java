package com.scichart.docsandbox.examples.javaBuilder.annotationsAPIs;

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
        // Create a MeasureAnnotation using the SciChartBuilder
        final MeasureAnnotation measureAnnotation = sciChartBuilder.newMeasureAnnotation()
                .withGrowingColor(Color.BLUE)
                .withDecliningColor(Color.RED)
                .withFillOpacity(0.2f)
                .withStroke(1.5f, Color.BLUE)
                .withShowArrows(true)
                // Optionally snap both anchor points to the closest data point of an OHLC series.
                // The series is also used to resolve the bar count reported by the label
                // .withSnapSeries(candlestickSeries)
                // .withSnapToDataPointRadius(15f)
                .withBasePoint(10, 30.6)
                .withBasePoint(30, 32.1)
                .withIsEditable(true)
                .build();

        // Add the annotation to the AnnotationsCollection of a surface
        surface.getAnnotations().add(measureAnnotation);
        // </AddMeasureAnnotation>
    }
}
