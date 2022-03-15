package com.scichart.docsandbox.examples.javaBuilder.chartModifier3D;

import androidx.annotation.NonNull;

import com.scichart.charting3d.modifiers.VertexSelectionModifier3D;
import com.scichart.charting3d.visuals.SciChartSurface3D;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart3DFragment;

@ExampleDefinition()
public class InteractivityVertexSelectionModifier3D extends SingleChart3DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface3D surface) {}

    void addVertexSelectionModifier3D(@NonNull SciChartSurface3D surface) {
        // <AddVertexSelectionModifier3D>
        // Assume a surface has been created and configured somewhere
        surface.getChartModifiers().add(new VertexSelectionModifier3D());
        // </AddVertexSelectionModifier3D>
    }
}
