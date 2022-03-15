package com.scichart.docsandbox.examples.javaBuilder.chartModifier2D;

import androidx.annotation.NonNull;

import com.scichart.charting.Direction2D;
import com.scichart.charting.modifiers.ModifierGroup;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;

@ExampleDefinition()
public class ZoomAndPanPinchZoomModifier extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) {}

    void addPinchZoomModifier2(@NonNull SciChartSurface surface) {
        // <AddPinchZoomModifier2>
        // Assume a surface has been created and configured somewhere
        // Create a Modifier
        final ModifierGroup pinchZoomModifierGroup = sciChartBuilder
                .newModifierGroup()
                .withPinchZoomModifier()
                .withXyDirection(Direction2D.XDirection)
                .withScaleFactor(1.5f)
                .build()
                .build();

        // Add the modifier to the surface
        surface.getChartModifiers().add(pinchZoomModifierGroup);
        // </AddPinchZoomModifier2>
    }
}
