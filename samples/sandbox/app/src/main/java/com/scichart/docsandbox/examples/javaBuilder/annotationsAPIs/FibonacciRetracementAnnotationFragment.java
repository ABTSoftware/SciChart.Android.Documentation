package com.scichart.docsandbox.examples.javaBuilder.annotationsAPIs;

import androidx.annotation.NonNull;

import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.annotations.tradingAnnotations.FibonacciRetracementAnnotation;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;

import java.util.Arrays;

import android.graphics.Color;

@ExampleDefinition()
public class FibonacciRetracementAnnotationFragment extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) { }

    void addFibonacciRetracementAnnotation(@NonNull SciChartSurface surface) {
        // <AddFibonacciRetracementAnnotation>
        // Assume a surface has been created and configured somewhere
        // Create a FibonacciRetracementAnnotation using the SciChartBuilder
        final FibonacciRetracementAnnotation fibonacciRetracementAnnotation = sciChartBuilder.newFibonacciRetracementAnnotation()
                .withLevels(Arrays.asList(0d, 0.236, 0.382, 0.5, 0.618, 0.786, 1d))
                .withLevelColors(Arrays.asList(
                        Color.parseColor("#787B86"),
                        Color.parseColor("#F23645"),
                        Color.parseColor("#FF9800"),
                        Color.parseColor("#4CAF50"),
                        Color.parseColor("#089981"),
                        Color.parseColor("#2962FF"),
                        Color.parseColor("#9C27B0")))
                .withFillOpacity(0.35f)
                // The stroke provides the color of the dashed connector line between the two anchor points
                .withStroke(1.5f, Color.WHITE)
                .withShowConnectorLine(true)
                .withLabelPlacement(FibonacciRetracementAnnotation.LabelPlacement.CENTER)
                .withLabelFormat(FibonacciRetracementAnnotation.LabelFormat.RATIO)
                .withLabelVerticalPosition(FibonacciRetracementAnnotation.LabelVerticalPosition.ABOVE)
                .withLabelFontSize(15f)
                .withBasePoint(10, 30.4)
                .withBasePoint(30, 32.2)
                .withIsEditable(true)
                .build();

        // Add the annotation to the AnnotationsCollection of a surface
        surface.getAnnotations().add(fibonacciRetracementAnnotation);
        // </AddFibonacciRetracementAnnotation>
    }
}
