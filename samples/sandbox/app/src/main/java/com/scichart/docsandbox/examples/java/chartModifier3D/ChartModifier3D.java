package com.scichart.docsandbox.examples.java.chartModifier3D;

import androidx.annotation.NonNull;

import com.scichart.charting3d.modifiers.PinchZoomModifier3D;
import com.scichart.charting3d.visuals.SciChartSurface3D;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart3DFragment;

@ExampleDefinition()
public class ChartModifier3D extends SingleChart3DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface3D surface) {}

    void addPinchZoom(@NonNull SciChartSurface3D surface) {
        // <AddPinchZoom>
        // Assume a surface has been created and configured somewhere
        surface.getChartModifiers().add(new PinchZoomModifier3D());
        // </AddPinchZoom>
    }
}
