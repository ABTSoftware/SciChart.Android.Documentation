package com.scichart.docsandbox.examples.java.chartModifier3D;

import androidx.annotation.NonNull;

import com.scichart.charting3d.modifiers.FreeLookModifier3D;
import com.scichart.charting3d.visuals.SciChartSurface3D;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart3DFragment;

@ExampleDefinition()
public class ZoomAndPanFreeLookModifier3D extends SingleChart3DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface3D surface) {}

    void addFreeLookModifier3D(@NonNull SciChartSurface3D surface) {
        // <AddFreeLookModifier3D>
        // Assume a surface has been created and configured somewhere
        // Create a Modifier
        final FreeLookModifier3D freeLookModifier3D = new FreeLookModifier3D();
        freeLookModifier3D.setExecuteOnPointerCount(2);
        freeLookModifier3D.setDegreesPerPixelSensitivity(0.4f);

        // Add the modifier to the surface
        surface.getChartModifiers().add(freeLookModifier3D);
        // </AddFreeLookModifier3D>
    }
}
