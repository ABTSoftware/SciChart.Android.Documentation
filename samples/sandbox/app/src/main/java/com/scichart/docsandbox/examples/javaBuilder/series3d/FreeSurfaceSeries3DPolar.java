package com.scichart.docsandbox.examples.javaBuilder.series3d;

import androidx.annotation.NonNull;

import com.scichart.charting3d.common.math.Vector3;
import com.scichart.charting3d.model.dataSeries.freeSurface.PolarDataSeries3D;
import com.scichart.charting3d.visuals.SciChartSurface3D;
import com.scichart.charting3d.visuals.renderableSeries.data.DrawMeshAs;
import com.scichart.charting3d.visuals.renderableSeries.data.GradientColorPalette;
import com.scichart.charting3d.visuals.renderableSeries.freeSurface.FreeSurfacePaletteMinMaxMode;
import com.scichart.charting3d.visuals.renderableSeries.freeSurface.FreeSurfaceRenderableSeries3D;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart3DFragment;

import java.util.Random;

@ExampleDefinition()
public class FreeSurfaceSeries3DPolar extends SingleChart3DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface3D surface) {
        createPolar3DChart();
    }

    void createPolar3DChart() {
        // <CreatePolar3DChart>
        final int sizeU = 30, sizeV = 10;

        final PolarDataSeries3D<Double, Double> meshDataSeries = new PolarDataSeries3D<>(Double.class, Double.class, sizeU, sizeV, 0d, Math.PI * 1.75);
        meshDataSeries.setA(1d);
        meshDataSeries.setB(5d);

        final Random random = new Random();
        for (int u = 0; u < sizeU; u++) {
            final double weightU = 1d - Math.abs(2d * u / sizeU - 1d);
            for (int v = 0; v < sizeV; v++) {
                final double weightV = 1d - Math.abs(2d * v / sizeV - 1d);
                final double offset = random.nextDouble();

                meshDataSeries.setDisplacement(u, v, offset * weightU * weightV);
            }
        }

        final int[] colors = new int[]{0xFF00008B, 0xFF0000FF, 0xFF00FFFF, 0xFFADFF2F, 0xFFFFFF00, 0xFFFF0000, 0xFF8B0000};
        final float[] stops = new float[]{0, .1f, .3f, .5f, .7f, .9f, 1};
        final GradientColorPalette palette = new GradientColorPalette(colors, stops);

        final FreeSurfaceRenderableSeries3D rs = sciChart3DBuilder.newFreeSurfaceSeries3D()
                .withDataSeries(meshDataSeries)
                .withDrawMeshAs(DrawMeshAs.SolidWireframe)
                .withStroke(0x77228B22)
                .withContourInterval(0.1f)
                .withContourStroke(0x77228B22)
                .withStrokeThicknes(2f)
                .withLightingFactor(0.8f)
                .withMeshColorPalette(palette)
                .withPaletteMinMaxMode(FreeSurfacePaletteMinMaxMode.Relative)
                .withPaletteMinimum(new Vector3(0f, 0f, 0f))
                .withPaletteMaximum(new Vector3(0f, 0.5f, 0f))
                .build();
        // </CreatePolar3DChart>
    }
}
