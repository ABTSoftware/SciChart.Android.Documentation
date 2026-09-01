package com.scichart.docsandbox.examples.java.annotationsAPIs;

import androidx.annotation.NonNull;

import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.annotations.tradingAnnotations.FibonacciRetracementAnnotation;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;
import com.scichart.drawing.common.SolidPenStyle;

import java.util.Arrays;

import android.graphics.Color;

@ExampleDefinition()
public class FibonacciRetracementAnnotationFragment extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) { }

    void addFibonacciRetracementAnnotation(@NonNull SciChartSurface surface) {
        // <AddFibonacciRetracementAnnotation>
        // Assume a surface has been created and configured somewhere
        // Create a FibonacciRetracementAnnotation
        final FibonacciRetracementAnnotation fibonacciRetracementAnnotation = new FibonacciRetracementAnnotation(getContext());

        // Allow to interact with the annotation in run-time
        fibonacciRetracementAnnotation.setIsEditable(true);

        // Specify the Fibonacci ratios to draw and the color of each level
        fibonacciRetracementAnnotation.setLevels(Arrays.asList(0d, 0.236, 0.382, 0.5, 0.618, 0.786, 1d));
        fibonacciRetracementAnnotation.setLevelColors(Arrays.asList(
                Color.parseColor("#787B86"),
                Color.parseColor("#F23645"),
                Color.parseColor("#FF9800"),
                Color.parseColor("#4CAF50"),
                Color.parseColor("#089981"),
                Color.parseColor("#2962FF"),
                Color.parseColor("#9C27B0")));

        // Specify the appearance of the level lines and of the fill bands between them
        fibonacciRetracementAnnotation.setStrokeThickness(1.5f);
        fibonacciRetracementAnnotation.setFillOpacity(0.35f);

        // The stroke provides the color of the dashed connector line between the two anchor points
        fibonacciRetracementAnnotation.setStroke(new SolidPenStyle(Color.WHITE, true, 1f, null));
        fibonacciRetracementAnnotation.setShowConnectorLine(true);

        // Configure how each level's label is placed and formatted
        fibonacciRetracementAnnotation.setLabelPlacement(FibonacciRetracementAnnotation.LabelPlacement.CENTER);
        fibonacciRetracementAnnotation.setLabelFormat(FibonacciRetracementAnnotation.LabelFormat.RATIO);
        fibonacciRetracementAnnotation.setLabelVerticalPosition(FibonacciRetracementAnnotation.LabelVerticalPosition.ABOVE);
        fibonacciRetracementAnnotation.setLabelFontSize(15f);

        // Add 2 points which define the price move being retraced
        fibonacciRetracementAnnotation.setBasePoint(10, 30.4); // Point 0 - the 0.0 ratio
        fibonacciRetracementAnnotation.setBasePoint(30, 32.2); // Point 1 - the 1.0 ratio

        // Add the annotation to the AnnotationsCollection of a surface
        surface.getAnnotations().add(fibonacciRetracementAnnotation);
        // </AddFibonacciRetracementAnnotation>
    }
}
