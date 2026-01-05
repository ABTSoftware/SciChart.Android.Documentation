package com.scichart.docsandbox.examples.java.chartModifier2D;

import androidx.annotation.NonNull;

import com.scichart.charting.Direction2D;
import com.scichart.charting.modifiers.PinchZoomModifier;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.axes.IAxis;
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
        PinchZoomModifier pinchZoomModifier = new PinchZoomModifier();
        pinchZoomModifier.setDirection(Direction2D.XDirection);
        pinchZoomModifier.setScaleFactor(1.5f);

        // Add the modifier to the surface
        surface.getChartModifiers().add(pinchZoomModifier);
        // </AddPinchZoomModifier2>
    }

    void includeExcludeAxis(PinchZoomModifier pinchZoomModifier, IAxis xAxis, IAxis yAxis) {
        // <IncludeExcludeAxes>
        // Assume a pinchZoomModifier has been created and configured somewhere

        // To include/exclude an X axis in the pinchZoomModifier (true = include, false = exclude)
        pinchZoomModifier.includeXAxis(xAxis, true);
        pinchZoomModifier.includeXAxis(xAxis, false);

        // To include/exclude an Y axis from the pinchZoomModifier (true = include, false = exclude)
        pinchZoomModifier.includeYAxis(yAxis, true);
        pinchZoomModifier.includeYAxis(yAxis, false);

        // To include all X and Y axes to the pinchZoomModifier
        pinchZoomModifier.includeAllAxes();
        // </IncludeExcludeAxes>
    }
}
