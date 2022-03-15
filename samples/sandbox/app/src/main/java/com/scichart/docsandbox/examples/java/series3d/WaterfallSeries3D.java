package com.scichart.docsandbox.examples.java.series3d;

import androidx.annotation.NonNull;

import com.scichart.charting3d.model.dataSeries.waterfall.WaterfallDataSeries3D;
import com.scichart.charting3d.visuals.SciChartSurface3D;
import com.scichart.charting3d.visuals.pointMarkers.SpherePointMarker3D;
import com.scichart.charting3d.visuals.renderableSeries.data.GradientColorPalette;
import com.scichart.charting3d.visuals.renderableSeries.data.SolidColorBrushPalette;
import com.scichart.charting3d.visuals.renderableSeries.waterfall.WaterfallRenderableSeries3D;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart3DFragment;

@ExampleDefinition()
public class WaterfallSeries3D extends SingleChart3DFragment {
    private static final int POINTS_PER_SLICE = 128;
    private static final int SLICE_COUNT = 20;

    @Override
    protected void initExample(@NonNull SciChartSurface3D surface) {
        createSurfaceMeshSeries3D();
    }

    void createSurfaceMeshSeries3D() {
        // <CreateSurfaceMeshSeries3D>
        final GradientColorPalette fillColorPalette = new GradientColorPalette(new int[]{0xFFFF0000, 0xFFFFA500, 0xFFFFFF00, 0xFFADFF2F, 0xFF006400}, new float[]{0.0f, 0.25f, 0.5f, 0.75f, 1.0f});
        final GradientColorPalette strokeColorPalette = new GradientColorPalette(new int[]{0xFFDC143C, 0xFFFF8C00, 0xFF32CD32, 0xFF32CD32}, new float[]{0.0f, 0.33f, 0.67f, 1.0f});

        final WaterfallDataSeries3D<Double, Double, Double> ds = new WaterfallDataSeries3D<>(Double.class, Double.class, Double.class, POINTS_PER_SLICE, SLICE_COUNT);
        ds.setStartX(10.0);
        ds.setStartZ(1.0);

        fillDataSeries(ds);

        final WaterfallRenderableSeries3D rSeries = new WaterfallRenderableSeries3D();
        rSeries.setDataSeries(ds);
        rSeries.setStroke(0xFF0000FF);
        rSeries.setStrokeThickness(convertValueToDp(1.0f));
        rSeries.setSliceThickness(0.0f);
        rSeries.setYColorMapping(fillColorPalette);
        rSeries.setYStrokeColorMapping(strokeColorPalette);
        rSeries.setOpacity(0.8f);
        // </CreateSurfaceMeshSeries3D>

        // <ApplyingSolidPalettes>
        rSeries.setYColorMapping(new SolidColorBrushPalette(0xFF6495ED));
        rSeries.setYStrokeColorMapping(new SolidColorBrushPalette(0xFF6495ED));
        // </ApplyingSolidPalettes>

        // <ApplyingLinearGradientPalettes>
        final int[] colors = new int[]{0xFFFF0000, 0xFFFFA500, 0xFFFFFF00, 0xFFADFF2F, 0xFF006400};
        final float[] stops = new float[]{0, .25f, .5f, .75f, 0};
        final GradientColorPalette colorPalette = new GradientColorPalette(colors, stops);
        // </ApplyingLinearGradientPalettes>

        // <ApplyingColorPaletteOntoSliceFill>
        // Z-Direction
        rSeries.setZColorMapping(colorPalette);
        rSeries.setZStrokeColorMapping(new SolidColorBrushPalette(0x00FFFFFF));

        // or Y-Direction
        rSeries.setYColorMapping(colorPalette);
        rSeries.setYStrokeColorMapping(new SolidColorBrushPalette(0x00FFFFFF));
        // </ApplyingColorPaletteOntoSliceFill>

        // <ApplyingColorPaletteOntoSliceStroke>
        // Z-Direction
        rSeries.setZColorMapping(new SolidColorBrushPalette(0x00FFFFFF));
        rSeries.setZStrokeColorMapping(colorPalette);

        // or Y-Direction
        rSeries.setYColorMapping(new SolidColorBrushPalette(0x00FFFFFF));
        rSeries.setYStrokeColorMapping(colorPalette);
        // </ApplyingColorPaletteOntoSliceStroke>
    }

    private void fillDataSeries(WaterfallDataSeries3D<Double, Double, Double> ds) { }

    void applySliceThickness() {
        // <ApplySliceThickness>
        final WaterfallRenderableSeries3D rSeries = new WaterfallRenderableSeries3D();
        rSeries.setSliceThickness(10.0f);
        // </ApplySliceThickness>
    }

    void pointMarkersOnWaterfall3D() {
        // <PointMarkersOnWaterfall3D>
        final SpherePointMarker3D pointMarker = new SpherePointMarker3D();
        pointMarker.setFill(0xFFFFA500);
        pointMarker.setSize(convertValueToDp(10.0f));

        final WaterfallRenderableSeries3D rSeries = new WaterfallRenderableSeries3D();
        rSeries.setPointMarker(pointMarker);
        // </PointMarkersOnWaterfall3D>
    }
}
