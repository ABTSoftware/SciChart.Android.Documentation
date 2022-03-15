package com.scichart.docsandbox.examples.javaBuilder.chartModifier2D;

import androidx.annotation.NonNull;

import com.scichart.charting.ClipMode;
import com.scichart.charting.ClipModeTarget;
import com.scichart.charting.modifiers.AxisDragModifierBase;
import com.scichart.charting.modifiers.ModifierGroup;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;

@ExampleDefinition()
public class ZoomAndPanXAxisDragModifier extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) {}

    void addXAxisDragModifier(@NonNull SciChartSurface surface) {
        // <AddXAxisDragModifier>
        // Assume a surface has been created and configured somewhere
        // Create a Modifier
        final ModifierGroup xAxisDragModifierGroup = sciChartBuilder
                .newModifierGroup()
                .withXAxisDragModifier()
                .withDragMode(AxisDragModifierBase.AxisDragMode.Pan)
                .withClipModeX(ClipMode.StretchAtExtents)
                .withClipModeTargetX(ClipModeTarget.MaximumRange)
                .build()
                .build();

        // Add the modifier to the surface
        surface.getChartModifiers().add(xAxisDragModifierGroup);
        // </AddXAxisDragModifier>
    }
}
