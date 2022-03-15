package com.scichart.docsandbox.examples.java.series3d;

import static com.scichart.drawing.utility.ColorUtil.Blue;
import static com.scichart.drawing.utility.ColorUtil.Cyan;
import static com.scichart.drawing.utility.ColorUtil.DarkRed;
import static com.scichart.drawing.utility.ColorUtil.GreenYellow;
import static com.scichart.drawing.utility.ColorUtil.Red;
import static com.scichart.drawing.utility.ColorUtil.Yellow;

import androidx.annotation.NonNull;

import com.scichart.charting3d.common.math.Vector3;
import com.scichart.charting3d.model.dataSeries.freeSurface.CustomSurfaceDataSeries3D;
import com.scichart.charting3d.visuals.SciChartSurface3D;
import com.scichart.charting3d.visuals.renderableSeries.data.DrawMeshAs;
import com.scichart.charting3d.visuals.renderableSeries.data.GradientColorPalette;
import com.scichart.charting3d.visuals.renderableSeries.freeSurface.FreeSurfacePaletteMinMaxMode;
import com.scichart.charting3d.visuals.renderableSeries.freeSurface.FreeSurfaceRenderableSeries3D;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart3DFragment;

@ExampleDefinition()
public class FreeSurfaceSeries3DCustomSurface extends SingleChart3DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface3D surface) {
        createCustomFreeSurface();
    }

    void createCustomFreeSurface() {
        // <CreateCustomFreeSurface>
        final CustomSurfaceDataSeries3D.UVFunc radialDistanceFunc = (u, v) -> 5d + Math.sin(5 * (u + v));
        final CustomSurfaceDataSeries3D.UVFunc azimuthalAngleFunc = (u, v) -> u;
        final CustomSurfaceDataSeries3D.UVFunc polarAngleFunc = (u, v) -> v;

        final CustomSurfaceDataSeries3D.ValueFunc<Double> xFunc = (r, theta, phi) -> r * Math.sin(theta) * Math.cos(phi);
        final CustomSurfaceDataSeries3D.ValueFunc<Double> yFunc = (r, theta, phi) -> r * Math.cos(theta);
        final CustomSurfaceDataSeries3D.ValueFunc<Double> zFunc = (r, theta, phi) -> r * Math.sin(theta) * Math.sin(phi);

        final CustomSurfaceDataSeries3D<Double, Double, Double> ds = new CustomSurfaceDataSeries3D<>(Double.class, Double.class, Double.class,
                30, 30,
                radialDistanceFunc, azimuthalAngleFunc, polarAngleFunc,
                xFunc, yFunc, zFunc,
                0d, Math.PI * 2, 0, Math.PI
        );

        int[] colors = new int[]{0xFF1D2C6B, Blue, Cyan, GreenYellow, Yellow, Red, DarkRed};
        float[] stops = new float[]{0, .1f, .3f, .5f, .7f, .9f, 1};
        final GradientColorPalette palette = new GradientColorPalette(colors, stops);

        final FreeSurfaceRenderableSeries3D rs = new FreeSurfaceRenderableSeries3D();
        rs.setDataSeries(ds);
        rs.setDrawMeshAs(DrawMeshAs.SolidWireframe);
        rs.setStroke(0x77228B22);
        rs.setContourInterval(0.1f);
        rs.setContourStroke(0x77228B22);
        rs.setStrokeThickness(convertValueToDp(2f));
        rs.setLightingFactor(0.8f);
        rs.setMeshColorPalette(palette);
        rs.setPaletteMinMaxMode(FreeSurfacePaletteMinMaxMode.Relative);
        rs.setPaletteMinimum(new Vector3(0f, 5f, 0f));
        rs.setPaletteMaximum(new Vector3(0f, 7f, 0f));
        // </CreateCustomFreeSurface>
    }

    void createSimpleSphere() {
        // <CreateSimpleSphere>
        final CustomSurfaceDataSeries3D.UVFunc radialDistanceFunc = (u, v) -> 10;
        final CustomSurfaceDataSeries3D.UVFunc azimuthalAngleFunc = (u, v) -> u;
        final CustomSurfaceDataSeries3D.UVFunc polarAngleFunc = (u, v) -> v;

        final CustomSurfaceDataSeries3D.ValueFunc<Double> xFunc = (r, theta, phi) -> r * Math.sin(theta) * Math.cos(phi);
        final CustomSurfaceDataSeries3D.ValueFunc<Double> yFunc = (r, theta, phi) -> r * Math.cos(theta);
        final CustomSurfaceDataSeries3D.ValueFunc<Double> zFunc = (r, theta, phi) -> r * Math.sin(theta) * Math.sin(phi);

        final CustomSurfaceDataSeries3D<Double, Double, Double> ds = new CustomSurfaceDataSeries3D<>(Double.class, Double.class, Double.class,
                30, 30,
                radialDistanceFunc, azimuthalAngleFunc, polarAngleFunc,
                xFunc, yFunc, zFunc,
                0d, Math.PI * 2, 0, Math.PI
        );
        // </CreateSimpleSphere>
    }

    void createSimpleCylinder() {
        // <CreateSimpleCylinder>
        final CustomSurfaceDataSeries3D.UVFunc radialDistanceFunc = (u, v) -> 0.0;
        final CustomSurfaceDataSeries3D.UVFunc azimuthalAngleFunc = (u, v) -> u;
        final CustomSurfaceDataSeries3D.UVFunc polarAngleFunc = (u, v) -> v;

        final CustomSurfaceDataSeries3D.ValueFunc<Double> xFunc = (r, theta, phi) -> 10 * Math.sin(Math.PI / 2) * Math.cos(phi);
        final CustomSurfaceDataSeries3D.ValueFunc<Double> yFunc = (r, theta, phi) -> 40 * Math.cos(theta);
        final CustomSurfaceDataSeries3D.ValueFunc<Double> zFunc = (r, theta, phi) -> 10 * Math.sin(Math.PI / 2) * Math.sin(phi);

        final CustomSurfaceDataSeries3D<Double, Double, Double> ds = new CustomSurfaceDataSeries3D<>(Double.class, Double.class, Double.class,
                30, 30,
                radialDistanceFunc, azimuthalAngleFunc, polarAngleFunc,
                xFunc, yFunc, zFunc,
                0d, Math.PI * 2, 0, Math.PI
        );
        // </CreateSimpleCylinder>
    }
}
