package com.scichart.docsandbox.examples.java.chartModifier2D;

import androidx.annotation.NonNull;

import com.scichart.charting.ClipMode;
import com.scichart.charting.Direction2D;
import com.scichart.charting.modifiers.ZoomPanModifier;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;

@ExampleDefinition()
public class ZoomAndPanZoomPanModifier extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) {}

    void addZoomPanModifier(@NonNull SciChartSurface surface) {
        // <AddZoomPanModifier>
        // Assume a surface has been created and configured somewhere
        // Create a Modifier
        final ZoomPanModifier zoomPanModifier = new ZoomPanModifier();
        zoomPanModifier.setDirection(Direction2D.XDirection);
        zoomPanModifier.setClipModeX(ClipMode.StretchAtExtents);
        zoomPanModifier.setClipModeY(ClipMode.None);
        zoomPanModifier.setZoomExtentsY(true);

        // Add the modifier to the surface
        surface.getChartModifiers().add(zoomPanModifier);
        // </AddZoomPanModifier>
    }
}
