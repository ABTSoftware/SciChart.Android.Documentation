package com.scichart.docsandbox.examples.javaBuilder.series3d;

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

        WaterfallRenderableSeries3D rSeries = sciChart3DBuilder.newWaterfallSeries3D()
                .withDataSeries(ds)
                .withStroke(0xFF0000FF)
                .withStrokeThicknes(1.0f)
                .withSliceThickness(0.0f)
                .withYColorMapping(fillColorPalette)
                .withYStrokeColorMapping(strokeColorPalette)
                .withOpacity(0.8f)
                .build();
        // </CreateSurfaceMeshSeries3D>

        // <ApplyingSolidPalettes>
        rSeries = sciChart3DBuilder.newWaterfallSeries3D()
                .withYColorMapping(new SolidColorBrushPalette(0xFF6495ED))
                .withYStrokeColorMapping(new SolidColorBrushPalette(0xFF6495ED))
                .build();
        // </ApplyingSolidPalettes>

        // <ApplyingLinearGradientPalettes>
        final int[] colors = new int[]{0xFFFF0000, 0xFFFFA500, 0xFFFFFF00, 0xFFADFF2F, 0xFF006400};
        final float[] stops = new float[]{0, .25f, .5f, .75f, 0};
        final GradientColorPalette colorPalette = new GradientColorPalette(colors, stops);
        // </ApplyingLinearGradientPalettes>

        // <ApplyingColorPaletteOntoSliceFill>
        // Z-Direction
        rSeries = sciChart3DBuilder.newWaterfallSeries3D()
                .withZColorMapping(colorPalette)
                .withZStrokeColorMapping(new SolidColorBrushPalette(0x00FFFFFF))
                .build();

        // or Y-Direction
        rSeries = sciChart3DBuilder.newWaterfallSeries3D()
                .withYColorMapping(colorPalette)
                .withYStrokeColorMapping(new SolidColorBrushPalette(0x00FFFFFF))
                .build();
        // </ApplyingColorPaletteOntoSliceFill>

        // <ApplyingColorPaletteOntoSliceStroke>
        // Z-Direction
        rSeries = sciChart3DBuilder.newWaterfallSeries3D()
                .withZColorMapping(new SolidColorBrushPalette(0x00FFFFFF))
                .withZStrokeColorMapping(colorPalette)
                .build();

        // or Y-Direction
        rSeries = sciChart3DBuilder.newWaterfallSeries3D()
                .withYColorMapping(new SolidColorBrushPalette(0x00FFFFFF))
                .withYStrokeColorMapping(colorPalette)
                .build();
        // </ApplyingColorPaletteOntoSliceStroke>
    }

    private void fillDataSeries(WaterfallDataSeries3D<Double, Double, Double> ds) { }

    void applySliceThickness() {
        // <ApplySliceThickness>
        final WaterfallRenderableSeries3D rSeries = sciChart3DBuilder.newWaterfallSeries3D()
                .withSliceThickness(10.0f)
                .build();
        // </ApplySliceThickness>
    }

    void pointMarkersOnWaterfall3D() {
        // <PointMarkersOnWaterfall3D>
        final SpherePointMarker3D pointMarker = sciChart3DBuilder.newSpherePointMarker3D()
                .withFill(0xFFFFA500)
                .withSize(10.0f)
                .build();

        final WaterfallRenderableSeries3D rSeries = sciChart3DBuilder.newWaterfallSeries3D()
                .withPointMarker(pointMarker)
                .build();
        // </PointMarkersOnWaterfall3D>
    }
}
