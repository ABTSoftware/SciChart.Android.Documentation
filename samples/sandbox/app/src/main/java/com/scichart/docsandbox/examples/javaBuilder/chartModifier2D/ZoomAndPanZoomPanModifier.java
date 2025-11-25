package com.scichart.docsandbox.examples.javaBuilder.chartModifier2D;

import androidx.annotation.NonNull;

import com.scichart.charting.ClipMode;
import com.scichart.charting.Direction2D;
import com.scichart.charting.modifiers.ModifierGroup;
import com.scichart.charting.modifiers.ZoomPanModifier;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.axes.IAxis;
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
        ModifierGroup zoomPanModifierGroup = sciChartBuilder.newModifierGroup()
                .withZoomPanModifier()
                .withXyDirection(Direction2D.XDirection)
                .withClipModeX(ClipMode.StretchAtExtents)
                .withClipModeY(ClipMode.None)
                .withZoomExtentsY(true)
                .build()
                .build();

        // Add the modifier to the surface
        surface.getChartModifiers().add(zoomPanModifierGroup);
        // </AddZoomPanModifier>
    }

    void includeExcludeAxis(ZoomPanModifier zoomPanModifier, IAxis xAxis, IAxis yAxis) {
        // <IncludeExcludeAxes>
        // Assume a zoomPanModifier has been created and configured somewhere

        // To include/exclude an X axis in the zoomPanModifier (true = include, false = exclude)
        zoomPanModifier.includeXAxis(xAxis, true);
        zoomPanModifier.includeXAxis(xAxis, false);

        // To include/exclude an Y axis from the zoomPanModifier (true = include, false = exclude)
        zoomPanModifier.includeYAxis(yAxis, true);
        zoomPanModifier.includeYAxis(yAxis, false);

        // To include all X and Y axes to the zoomPanModifier
        zoomPanModifier.includeAllXAxes();
        // </IncludeExcludeAxes>
    }
}
