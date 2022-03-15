package com.scichart.docsandbox.examples.java.axis3DAPIs;

import androidx.annotation.NonNull;

import com.scichart.charting3d.visuals.SciChartSurface3D;
import com.scichart.charting3d.visuals.axes.AxisPlaneDrawLabelsMode;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart3DFragment;

@ExampleDefinition()
public class Axis3DLabelsLabelsConfiguration extends SingleChart3DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface3D surface) { }

    void axisCubeLabelsConfiguration(@NonNull SciChartSurface3D surface) {
        // <AxisCubeLabelsConfiguration>
        surface.setXyAxisPlaneDrawLabelsMode(AxisPlaneDrawLabelsMode.AxisPlaneDrawLabelsBoth);
        surface.setZyAxisPlaneDrawLabelsMode(AxisPlaneDrawLabelsMode.AxisPlaneDrawLabelsLocalX);
        surface.setZxAxisPlaneDrawLabelsMode(AxisPlaneDrawLabelsMode.AxisPlaneDrawLabelsHidden);
        // </AxisCubeLabelsConfiguration>
    }
}
