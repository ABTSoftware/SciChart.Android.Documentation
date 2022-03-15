package com.scichart.docsandbox.examples.javaBuilder.chartModifier3D;

import androidx.annotation.NonNull;

import com.scichart.charting3d.modifiers.PinchZoomModifier3D;
import com.scichart.charting3d.visuals.SciChartSurface3D;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart3DFragment;

@ExampleDefinition()
public class ZoomAndPanPinchZoomModifier3D extends SingleChart3DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface3D surface) {}

    void addPinchZoomModifier3D(@NonNull SciChartSurface3D surface) {
        // <AddPinchZoomModifier3D>
        // Assume a surface has been created and configured somewhere
        // Create a Modifier
        final PinchZoomModifier3D pinchZoomModifier3D = new PinchZoomModifier3D();
        pinchZoomModifier3D.setScaleFactor(1.5f);

        // Add the modifier to the surface
        surface.getChartModifiers().add(pinchZoomModifier3D);
        // </AddPinchZoomModifier3D>
    }
}
