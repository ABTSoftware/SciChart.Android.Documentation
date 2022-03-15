package com.scichart.docsandbox.examples.javaBuilder.chartModifier3D;

import androidx.annotation.NonNull;

import com.scichart.charting3d.modifiers.OrbitModifier3D;
import com.scichart.charting3d.visuals.SciChartSurface3D;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart3DFragment;

@ExampleDefinition()
public class ZoomAndPanOrbitModifier3D extends SingleChart3DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface3D surface) {}

    void addOrbitModifier3D(@NonNull SciChartSurface3D surface) {
        // <AddOrbitModifier3D>
        // Assume a surface has been created and configured somewhere
        // Create a Modifier
        final OrbitModifier3D orbitModifier3D = new OrbitModifier3D();
        orbitModifier3D.setDegreesPerPixelSensitivity(0.4f);

        // Add the modifier to the surface
        surface.getChartModifiers().add(orbitModifier3D);
        // </AddOrbitModifier3D>
    }
}
