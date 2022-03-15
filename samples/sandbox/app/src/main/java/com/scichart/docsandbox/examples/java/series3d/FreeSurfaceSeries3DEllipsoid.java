package com.scichart.docsandbox.examples.java.series3d;

import androidx.annotation.NonNull;

import com.scichart.charting3d.common.math.Vector3;
import com.scichart.charting3d.model.dataSeries.freeSurface.EllipsoidDataSeries3D;
import com.scichart.charting3d.visuals.SciChartSurface3D;
import com.scichart.charting3d.visuals.renderableSeries.data.DrawMeshAs;
import com.scichart.charting3d.visuals.renderableSeries.data.GradientColorPalette;
import com.scichart.charting3d.visuals.renderableSeries.freeSurface.FreeSurfacePaletteMinMaxMode;
import com.scichart.charting3d.visuals.renderableSeries.freeSurface.FreeSurfaceRenderableSeries3D;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart3DFragment;

import java.util.Random;

@ExampleDefinition()
public class FreeSurfaceSeries3DEllipsoid extends SingleChart3DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface3D surface) {
        createEllipsoid3DChart();
    }

    void createEllipsoid3DChart() {
        // <CreateEllipsoid3DChart>
        final int sizeU = 40, sizeV = 20;

        final EllipsoidDataSeries3D<Double> meshDataSeries = new EllipsoidDataSeries3D<>(Double.class, sizeU, sizeV);
        meshDataSeries.setA(6d);
        meshDataSeries.setB(6d);
        meshDataSeries.setC(6d);

        final Random random = new Random();
        for (int u = 0; u < sizeU; u++) {
            for (int v = 0; v < sizeV; v++) {
                final double weight = 1d - Math.abs(2d * v / sizeV - 1d);
                final double offset = random.nextDouble();

                meshDataSeries.setDisplacement(u, v, offset * weight);
            }
        }

        final int[] colors = new int[]{0xFF00008B, 0xFF0000FF, 0xFF00FFFF, 0xFFADFF2F, 0xFFFFFF00, 0xFFFF0000, 0xFF8B0000};
        final float[] stops = new float[]{0, .1f, .3f, .5f, .7f, .9f, 1};
        final GradientColorPalette palette = new GradientColorPalette(colors, stops);

        final FreeSurfaceRenderableSeries3D rs = new FreeSurfaceRenderableSeries3D();
        rs.setDataSeries(meshDataSeries);
        rs.setDrawMeshAs(DrawMeshAs.SolidWireframe);
        rs.setStroke(0x77228B22);
        rs.setContourInterval(0.1f);
        rs.setContourStroke(0x77228B22);
        rs.setStrokeThickness(convertValueToDp(2f));
        rs.setLightingFactor(0.8f);
        rs.setMeshColorPalette(palette);
        rs.setPaletteMinMaxMode(FreeSurfacePaletteMinMaxMode.Relative);
        rs.setPaletteMinimum(new Vector3(0f, 6f, 0f));
        rs.setPaletteMaximum(new Vector3(0f, 7f, 0f));
        // </CreateEllipsoid3DChart>
    }
}
