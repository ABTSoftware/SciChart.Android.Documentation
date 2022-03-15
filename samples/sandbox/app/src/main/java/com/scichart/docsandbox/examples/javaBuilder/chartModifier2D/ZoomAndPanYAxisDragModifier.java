package com.scichart.docsandbox.examples.javaBuilder.chartModifier2D;

import androidx.annotation.NonNull;

import com.scichart.charting.modifiers.AxisDragModifierBase;
import com.scichart.charting.modifiers.ModifierGroup;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;

@ExampleDefinition()
public class ZoomAndPanYAxisDragModifier extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) {}

    void addYAxisDragModifier(@NonNull SciChartSurface surface) {
        // <AddYAxisDragModifier>
        // Assume a surface has been created and configured somewhere
        // Create a Modifier
        final ModifierGroup yAxisDragModifierGroup = sciChartBuilder
                .newModifierGroup()
                .withYAxisDragModifier()
                .withDragMode(AxisDragModifierBase.AxisDragMode.Pan)
                .build()
                .build();

        // Add the modifier to the surface
        surface.getChartModifiers().add(yAxisDragModifierGroup);
        // </AddYAxisDragModifier>
    }
}
