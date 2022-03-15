package com.scichart.docsandbox.examples.javaBuilder.chartModifier3D;

import androidx.annotation.NonNull;

import com.scichart.charting.modifiers.ExecuteOn;
import com.scichart.charting3d.common.math.Vector3;
import com.scichart.charting3d.modifiers.ZoomExtentsModifier3D;
import com.scichart.charting3d.visuals.SciChartSurface3D;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart3DFragment;

@ExampleDefinition()
public class ZoomAndPanZoomExtentsModifier3D extends SingleChart3DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface3D surface) {}

    void addZoomExtentsModifier(@NonNull SciChartSurface3D surface) {
        // <AddZoomExtentsModifier>
        // Assume a surface has been created and configured somewhere
        // Create a Modifier
        final ZoomExtentsModifier3D zoomExtentsModifier = new ZoomExtentsModifier3D();
        zoomExtentsModifier.setExecuteOn(ExecuteOn.DoubleTap);
        zoomExtentsModifier.setAutoFitRadius(false);
        zoomExtentsModifier.setResetPosition(new Vector3(200, 200, 200));
        zoomExtentsModifier.setResetTarget(new Vector3(0, 0, 0));

        // Add the modifier to the surface
        surface.getChartModifiers().add(zoomExtentsModifier);
        // </AddZoomExtentsModifier>
    }
}
