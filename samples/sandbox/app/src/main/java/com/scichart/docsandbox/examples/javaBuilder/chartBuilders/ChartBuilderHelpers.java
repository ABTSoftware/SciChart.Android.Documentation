package com.scichart.docsandbox.examples.javaBuilder.chartBuilders;

import androidx.annotation.NonNull;

import com.scichart.charting.modifiers.ModifierGroup;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.annotations.TextAnnotation;
import com.scichart.charting.visuals.axes.IAxis;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;
import com.scichart.drawing.utility.ColorUtil;
import com.scichart.extensions.builders.SciChartBuilder;

import java.util.Collections;

@ExampleDefinition()
public class ChartBuilderHelpers extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) { }

    void useChartBuilders() {
        // <UseChartBuilders>
        // get our surface from the binding
        SciChartSurface surface = binding.surface;

        // need to init SciChartBuilder class with application context before using
        SciChartBuilder.init(requireContext());
        // obtain the SciChartBuilder instance
        final SciChartBuilder sciChartBuilder = SciChartBuilder.instance();

        // create numeric X axis
        final IAxis xAxis = sciChartBuilder.newNumericAxis()
                .withAxisTitle("X Axis Title")
                .withVisibleRange(-5, 15)
                .build();

        // create a numeric Y axis
        final IAxis yAxis = sciChartBuilder.newNumericAxis()
                .withAxisTitle("Y Axis Title").withVisibleRange(0, 100).build();

        // create a TextAnnotation and specify the inscription and position for it
        TextAnnotation textAnnotation = sciChartBuilder.newTextAnnotation()
                .withX1(5.0)
                .withY1(2.5)
                .withText("Hello World!")
                .withFontStyle(10, ColorUtil.White)
                .build();

        // create interactivity modifiers
        ModifierGroup chartModifiers = sciChartBuilder.newModifierGroupWithDefaultModifiers().build();

        // add the Y axis to the YAxes collection of the surface
        Collections.addAll(surface.getYAxes(), yAxis);

        // add the X axis to the XAxes collection of the surface
        Collections.addAll(surface.getXAxes(), xAxis);

        // add the annotation to the Annotations collection of the surface
        Collections.addAll(surface.getAnnotations(), textAnnotation);

        // add the interactions to the ChartModifiers collection of the surface
        Collections.addAll(surface.getChartModifiers(), chartModifiers);
        // </UseChartBuilders>
    }
}
