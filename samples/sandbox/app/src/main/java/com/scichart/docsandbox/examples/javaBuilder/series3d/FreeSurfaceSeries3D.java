package com.scichart.docsandbox.examples.javaBuilder.series3d;

import androidx.annotation.NonNull;

import com.scichart.charting3d.common.math.Vector3;
import com.scichart.charting3d.visuals.SciChartSurface3D;
import com.scichart.charting3d.visuals.renderableSeries.data.GradientColorPalette;
import com.scichart.charting3d.visuals.renderableSeries.freeSurface.FreeSurfacePaletteMinMaxMode;
import com.scichart.charting3d.visuals.renderableSeries.freeSurface.FreeSurfaceRenderableSeries3D;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart3DFragment;

@ExampleDefinition()
public class FreeSurfaceSeries3D extends SingleChart3DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface3D surface) {
        createAxialPaletteComponent();
    }

    void createAxialPaletteComponent() {
        // <CreateAxialPaletteComponent>
        final int[] colors = new int[]{0xFF00008B, 0xFF0000FF, 0xFF00FFFF, 0xFFADFF2F, 0xFFFFFF00, 0xFFFF0000, 0xFF8B0000};
        final float[] stops = new float[]{0, .1f, .3f, .5f, .7f, .9f, 1};
        final GradientColorPalette palette = new GradientColorPalette(colors, stops);

        final FreeSurfaceRenderableSeries3D rs = sciChart3DBuilder.newFreeSurfaceSeries3D()
                .withPaletteMinMaxMode(FreeSurfacePaletteMinMaxMode.Absolute)
                .withPaletteMinimum(new Vector3(0f, -4f, 0f))
                .withPaletteMaximum(new Vector3(0f, 4f, 0f))
                .withPaleteeAxialFactor(new Vector3(0f, 1f, 0f))
                .build();
        // </CreateAxialPaletteComponent>
    }

    void createRadialPaletteComponent() {
        // <CreateRadialPaletteComponent>
        final int[] colors = new int[]{0xFF00008B, 0xFF0000FF, 0xFF00FFFF, 0xFFADFF2F, 0xFFFFFF00, 0xFFFF0000, 0xFF8B0000};
        final float[] stops = new float[]{0, .1f, .3f, .5f, .7f, .9f, 1};
        final GradientColorPalette palette = new GradientColorPalette(colors, stops);

        final FreeSurfaceRenderableSeries3D rs = sciChart3DBuilder.newFreeSurfaceSeries3D()
                .withPaletteMinMaxMode(FreeSurfacePaletteMinMaxMode.Relative)
                .withPaletteMinimum(new Vector3(0f, 6f, 0f))
                .withPaletteMaximum(new Vector3(0f, 7f, 0f))
                .withPaletteRadialFactor(1)
                .build();
        // </CreateRadialPaletteComponent>
    }

    void createAzimuthalPaletteComponent() {
        // <CreateAzimuthalPaletteComponent>
        final int[] colors = new int[]{0xFF00008B, 0xFF0000FF, 0xFF00FFFF, 0xFFADFF2F, 0xFFFFFF00, 0xFFFF0000, 0xFF8B0000};
        final float[] stops = new float[]{0, .1f, .3f, .5f, .7f, .9f, 1};
        final GradientColorPalette palette = new GradientColorPalette(colors, stops);

        final FreeSurfaceRenderableSeries3D rs = sciChart3DBuilder.newFreeSurfaceSeries3D()
                .withPaletteMinMaxMode(FreeSurfacePaletteMinMaxMode.Relative)
                .withPaletteMinimum(new Vector3(0f, 6f, 0f))
                .withPaletteMaximum(new Vector3(0f, 7f, 0f))
                .withPaletteAzimuthalFactor(1)
                .build();
        // </CreateAzimuthalPaletteComponent>
    }

    void createPolarPaletteComponent() {
        // <CreatePolarPaletteComponent>
        final int[] colors = new int[]{0xFF00008B, 0xFF0000FF, 0xFF00FFFF, 0xFFADFF2F, 0xFFFFFF00, 0xFFFF0000, 0xFF8B0000};
        final float[] stops = new float[]{0, .1f, .3f, .5f, .7f, .9f, 1};
        final GradientColorPalette palette = new GradientColorPalette(colors, stops);

        final FreeSurfaceRenderableSeries3D rs = sciChart3DBuilder.newFreeSurfaceSeries3D()
                .withPaletteMinMaxMode(FreeSurfacePaletteMinMaxMode.Relative)
                .withPaletteMinimum(new Vector3(0f, 6f, 0f))
                .withPaletteMaximum(new Vector3(0f, 7f, 0f))
                .withPalettePolarFactor(1)
                .build();
        // </CreatePolarPaletteComponent>
    }
}
