package com.scichart.docsandbox.examples.java.chartModifier2D;

import androidx.annotation.NonNull;

import com.scichart.charting.modifiers.TooltipModifier;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;

@ExampleDefinition()
public class InteractivityTooltipModifier extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) {}

    void addTooltipModifier(@NonNull SciChartSurface surface) {
        // <AddTooltipModifier>
        // Assume a surface has been created and configured somewhere
        surface.getChartModifiers().add(new TooltipModifier());
        // </AddTooltipModifier>
    }
}
