package com.scichart.docsandbox.examples.javaBuilder.chartModifier2D;

import androidx.annotation.NonNull;

import com.scichart.charting.modifiers.SeriesSelectionModifier;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.pointmarkers.EllipsePointMarker;
import com.scichart.charting.visuals.pointmarkers.IPointMarker;
import com.scichart.charting.visuals.renderableSeries.IRenderableSeries;
import com.scichart.charting.visuals.renderableSeries.StyleBase;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;
import com.scichart.drawing.common.PenStyle;
import com.scichart.drawing.utility.ColorUtil;

@ExampleDefinition()
public class InteractivitySeriesSelectionModifier extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) {}

    void addSeriesSelectionModifier(@NonNull SciChartSurface surface) {
        // <CreateSelectedSeriesStyle>
        class SelectedSeriesStyle extends StyleBase<IRenderableSeries> {
            private final PenStyle selectedStrokeStyle = sciChartBuilder.newPen()
                    .withColor(ColorUtil.White)
                    .withThickness(4f)
                    .build();

            private final IPointMarker selectedPointMarker = sciChartBuilder.newPointMarker(new EllipsePointMarker())
                    .withSize(10, 10)
                    .withFill(0xFFFF00DC)
                    .withStroke(ColorUtil.White, 1f)
                    .build();

            private static final String STROKE = "Stroke";
            private static final String POINT_MARKER = "PointMarker";

            protected SelectedSeriesStyle() {
                super(IRenderableSeries.class);
            }

            protected SelectedSeriesStyle(Class<IRenderableSeries> styleableObjectType) {
                super(styleableObjectType);
            }

            @Override
            protected void applyStyleInternal(IRenderableSeries renderableSeriesToStyle) {
                putPropertyValue(renderableSeriesToStyle, STROKE, renderableSeriesToStyle.getStrokeStyle());
                putPropertyValue(renderableSeriesToStyle, POINT_MARKER, renderableSeriesToStyle.getPointMarker());

                renderableSeriesToStyle.setStrokeStyle(selectedStrokeStyle);
                renderableSeriesToStyle.setPointMarker(selectedPointMarker);
            }

            @Override
            protected void discardStyleInternal(IRenderableSeries renderableSeriesToStyle) {
                renderableSeriesToStyle.setStrokeStyle(getPropertyValue(renderableSeriesToStyle, STROKE, PenStyle.class));
                renderableSeriesToStyle.setPointMarker(getPropertyValue(renderableSeriesToStyle, POINT_MARKER, IPointMarker.class));
            }
        }
        // </CreateSelectedSeriesStyle>

        // <AddSeriesSelectionModifier>
        // Assume a surface has been created and configured somewhere
        // Create a SeriesSelectionModifier
        final SeriesSelectionModifier seriesSelectionModifier = new SeriesSelectionModifier();

        // Set a style which will be applied to a RenderableSeries when selected
        seriesSelectionModifier.setSelectedSeriesStyle(new SelectedSeriesStyle());

        // Add the modifier to the surface
        surface.getChartModifiers().add(seriesSelectionModifier);
        // </AddSeriesSelectionModifier>
    }
}
