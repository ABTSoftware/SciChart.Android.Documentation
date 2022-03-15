package com.scichart.docsandbox.examples.javaBuilder.chartModifier2D;

import androidx.annotation.NonNull;

import com.scichart.charting.modifiers.ModifierGroup;
import com.scichart.charting.modifiers.RubberBandXyZoomModifier;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;
import com.scichart.drawing.common.BrushStyle;
import com.scichart.drawing.common.PenStyle;
import com.scichart.drawing.common.SolidBrushStyle;
import com.scichart.drawing.common.SolidPenStyle;

@ExampleDefinition()
public class ZoomAndPanRubberBandXyZoomModifier extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) {}

    void addRubberBandXyZoomModifier(@NonNull SciChartSurface surface) {
        // <AddRubberBandXyZoomModifier>
        // Assume a surface has been created and configured somewhere
        // Create a RubberBandXyZoomModifier
        ModifierGroup modifierGroup = sciChartBuilder.newModifierGroup().withRubberBandXyZoomModifier()
                .withIsXAxisOnly(true)
                .withZoomExtentsY(true)
                .withIsAnimated(true)
                .build()
                .build();

        RubberBandXyZoomModifier rubberBandZoomModifier = (RubberBandXyZoomModifier) modifierGroup.getChildModifiers().get(0);

        // Apply a BrushStyle for fill
        BrushStyle brushStyle = new SolidBrushStyle(0x33999999);
        rubberBandZoomModifier.setRubberBandFillStyle(brushStyle);

        // Apply a PenStyle for stroke
        PenStyle strokeStyle = new SolidPenStyle(0x77999999, true, 1f, null);
        rubberBandZoomModifier.setRubberBandStrokeStyle(strokeStyle);

        // Add the modifier to the surface
        surface.getChartModifiers().add(rubberBandZoomModifier);
        // </AddRubberBandXyZoomModifier>
    }
}
