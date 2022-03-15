package com.scichart.docsandbox.examples.java.chartModifier2D;

import androidx.annotation.NonNull;

import com.scichart.charting.modifiers.RolloverModifier;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;

@ExampleDefinition()
public class InteractivityRolloverModifier extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) {}

    void addRolloverModifier(@NonNull SciChartSurface surface) {
        // <AddRolloverModifier>
        // Assume a surface has been created and configured somewhere
        surface.getChartModifiers().add(new RolloverModifier());
        // </AddRolloverModifier>
    }
}
