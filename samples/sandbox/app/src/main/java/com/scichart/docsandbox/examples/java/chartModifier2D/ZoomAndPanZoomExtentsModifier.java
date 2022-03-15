package com.scichart.docsandbox.examples.java.chartModifier2D;

import androidx.annotation.NonNull;

import com.scichart.charting.Direction2D;
import com.scichart.charting.modifiers.ExecuteOn;
import com.scichart.charting.modifiers.ZoomExtentsModifier;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;

@ExampleDefinition()
public class ZoomAndPanZoomExtentsModifier extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) {}

    void addZoomExtentsModifier(@NonNull SciChartSurface surface) {
        // <AddZoomExtentsModifier>
        // Assume a surface has been created and configured somewhere
        // Create a Modifier
        final ZoomExtentsModifier zoomExtentsModifier = new ZoomExtentsModifier();
        zoomExtentsModifier.setDirection(Direction2D.XDirection);
        zoomExtentsModifier.setExecuteOn(ExecuteOn.DoubleTap);
        zoomExtentsModifier.setIsAnimated(true);

        // Add the modifier to the surface
        surface.getChartModifiers().add(zoomExtentsModifier);
        // </AddZoomExtentsModifier>
    }
}
