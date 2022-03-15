package com.scichart.docsandbox.examples.java.chartModifier2D;

import androidx.annotation.NonNull;

import com.scichart.charting.modifiers.AxisDragModifierBase;
import com.scichart.charting.modifiers.YAxisDragModifier;
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
        final YAxisDragModifier yAxisDragModifier = new YAxisDragModifier();
        yAxisDragModifier.setDragMode(AxisDragModifierBase.AxisDragMode.Pan);

        // Add the modifier to the surface
        surface.getChartModifiers().add(yAxisDragModifier);
        // </AddYAxisDragModifier>
    }
}
