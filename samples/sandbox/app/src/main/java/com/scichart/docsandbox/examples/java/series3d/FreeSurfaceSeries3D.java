package com.scichart.docsandbox.examples.java.series3d;

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

        final FreeSurfaceRenderableSeries3D rs = new FreeSurfaceRenderableSeries3D();
        rs.setMeshColorPalette(palette);
        rs.setPaletteMinMaxMode(FreeSurfacePaletteMinMaxMode.Absolute);
        rs.setPaletteMinimum(new Vector3(0f, -4f, 0f));
        rs.setPaletteMaximum(new Vector3(0f, 4f, 0f));
        rs.setPaletteAxialFactor(new Vector3(0f, 1f, 0f));
        // </CreateAxialPaletteComponent>
    }

    void createRadialPaletteComponent() {
        // <CreateRadialPaletteComponent>
        final int[] colors = new int[]{0xFF00008B, 0xFF0000FF, 0xFF00FFFF, 0xFFADFF2F, 0xFFFFFF00, 0xFFFF0000, 0xFF8B0000};
        final float[] stops = new float[]{0, .1f, .3f, .5f, .7f, .9f, 1};
        final GradientColorPalette palette = new GradientColorPalette(colors, stops);

        final FreeSurfaceRenderableSeries3D rs = new FreeSurfaceRenderableSeries3D();
        rs.setMeshColorPalette(palette);
        rs.setPaletteMinMaxMode(FreeSurfacePaletteMinMaxMode.Relative);
        rs.setPaletteMinimum(new Vector3(0f, 6f, 0f));
        rs.setPaletteMaximum(new Vector3(0f, 7f, 0f));
        rs.setPaletteRadialFactor(1);
        // </CreateRadialPaletteComponent>
    }

    void createAzimuthalPaletteComponent() {
        // <CreateAzimuthalPaletteComponent>
        final int[] colors = new int[]{0xFF00008B, 0xFF0000FF, 0xFF00FFFF, 0xFFADFF2F, 0xFFFFFF00, 0xFFFF0000, 0xFF8B0000};
        final float[] stops = new float[]{0, .1f, .3f, .5f, .7f, .9f, 1};
        final GradientColorPalette palette = new GradientColorPalette(colors, stops);

        final FreeSurfaceRenderableSeries3D rs = new FreeSurfaceRenderableSeries3D();
        rs.setMeshColorPalette(palette);
        rs.setPaletteMinMaxMode(FreeSurfacePaletteMinMaxMode.Relative);
        rs.setPaletteMinimum(new Vector3(0f, 6f, 0f));
        rs.setPaletteMaximum(new Vector3(0f, 7f, 0f));
        rs.setPaletteAzimuthalFactor(1);
        // </CreateAzimuthalPaletteComponent>
    }

    void createPolarPaletteComponent() {
        // <CreatePolarPaletteComponent>
        final int[] colors = new int[]{0xFF00008B, 0xFF0000FF, 0xFF00FFFF, 0xFFADFF2F, 0xFFFFFF00, 0xFFFF0000, 0xFF8B0000};
        final float[] stops = new float[]{0, .1f, .3f, .5f, .7f, .9f, 1};
        final GradientColorPalette palette = new GradientColorPalette(colors, stops);

        final FreeSurfaceRenderableSeries3D rs = new FreeSurfaceRenderableSeries3D();
        rs.setMeshColorPalette(palette);
        rs.setPaletteMinMaxMode(FreeSurfacePaletteMinMaxMode.Relative);
        rs.setPaletteMinimum(new Vector3(0f, 6f, 0f));
        rs.setPaletteMaximum(new Vector3(0f, 7f, 0f));
        rs.setPalettePolarFactor(1);
        // </CreatePolarPaletteComponent>
    }
}
