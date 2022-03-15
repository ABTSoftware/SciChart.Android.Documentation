package com.scichart.docsandbox.examples.javaBuilder.series3d;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import androidx.annotation.NonNull;

import com.scichart.charting3d.model.dataSeries.grid.UniformGridDataSeries3D;
import com.scichart.charting3d.visuals.SciChartSurface3D;
import com.scichart.charting3d.visuals.axes.NumericAxis3D;
import com.scichart.charting3d.visuals.pointMarkers.CustomPointMarker3D;
import com.scichart.charting3d.visuals.renderableSeries.data.BrushColorPalette;
import com.scichart.charting3d.visuals.renderableSeries.data.DrawMeshAs;
import com.scichart.charting3d.visuals.renderableSeries.data.GradientColorPalette;
import com.scichart.charting3d.visuals.renderableSeries.data.MeshColorPalette;
import com.scichart.charting3d.visuals.renderableSeries.data.MeshPaletteMode;
import com.scichart.charting3d.visuals.renderableSeries.data.SolidColorBrushPalette;
import com.scichart.charting3d.visuals.renderableSeries.metadataProviders.ISurfaceMeshMetadataProvider3D;
import com.scichart.charting3d.visuals.renderableSeries.metadataProviders.MetadataProvider3DBase;
import com.scichart.charting3d.visuals.renderableSeries.surfaceMesh.SurfaceMeshRenderPassData3D;
import com.scichart.charting3d.visuals.renderableSeries.surfaceMesh.SurfaceMeshRenderableSeries3D;
import com.scichart.charting3d.visuals.rendering.Texture2D;
import com.scichart.core.common.Size;
import com.scichart.core.framework.UpdateSuspender;
import com.scichart.core.model.IntegerValues;
import com.scichart.docsandbox.R;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.DataManager;
import com.scichart.docsandbox.examples.base.SingleChart3DFragment;
import com.scichart.drawing.common.TextureBrushStyle;

@ExampleDefinition()
public class SurfaceMeshSeries3D extends SingleChart3DFragment {
    private static final int COUNT = 25;
    private DataManager dataManager = new DataManager();

    @Override
    protected void initExample(@NonNull SciChartSurface3D surface) {
        surfaceMeshSeries3D(surface);
    }

    void surfaceMeshSeries3D(@NonNull SciChartSurface3D surface) {
        // <CreateSurfaceMeshSeries3D>
        final NumericAxis3D xAxis = sciChart3DBuilder.newNumericAxis3D().withGrowBy(.1, .1).build();
        final NumericAxis3D yAxis = sciChart3DBuilder.newNumericAxis3D().withGrowBy(.1, .1).withVisibleRange(0.0, .3).build();
        final NumericAxis3D zAxis = sciChart3DBuilder.newNumericAxis3D().withGrowBy(.1, .1).build();

        final UniformGridDataSeries3D<Double, Double, Double> ds = new UniformGridDataSeries3D<>(Double.class, Double.class, Double.class, COUNT, COUNT);

        for (int x = 0; x < COUNT; x++) {
            for (int z = 0; z < COUNT; z++) {
                final double xVal = 25 * x / COUNT;
                final double zVal = 25 * z / COUNT;
                final double y = Math.sin(xVal * 0.2) / ((zVal + 1.0) * 2.0);
                ds.updateYAt(x, z, y);
            }
        }

        final int[] colors = new int[]{0xFF1D2C6B, 0xFF0000FF, 0xFF00FFFF, 0xFFADFF2F, 0xFFFFFF00, 0xFFFF0000, 0xFF8B0000};
        final float[] stops = new float[]{0, .1f, .3f, .5f, .7f, .9f, 1};
        final GradientColorPalette palette = new GradientColorPalette(colors, stops);

        final SurfaceMeshRenderableSeries3D rs = sciChart3DBuilder.newSurfaceMeshSeries3D()
                .withDataSeries(ds)
                .withDrawMeshAs(DrawMeshAs.SolidWireframe)
                .withStroke(0x77228B22)
                .withContourStroke(0x77228B22)
                .withStrokeThicknes(2f)
                .withDrawSkirt(false)
                .withMeshColorPalette(palette)
                .build();

        UpdateSuspender.using(surface, () -> {
            surface.setXAxis(xAxis);
            surface.setYAxis(yAxis);
            surface.setZAxis(zAxis);
            surface.getRenderableSeries().add(rs);
            surface.getChartModifiers().add(createDefaultModifiers3D());
        });
        // </CreateSurfaceMeshSeries3D>
    }

    void createSolidColorPalette() {
        // <CreateSolidColorPalette>
        final SurfaceMeshRenderableSeries3D rSeries = sciChart3DBuilder.newSurfaceMeshSeries3D()
                .withMeshColorPalette(new SolidColorBrushPalette(0xFF006400))
                .build();
        // </CreateSolidColorPalette>
    }

    void createGradientColorPalette() {
        // <CreateGradientColorPalette>
        final int[] colors = new int[]{0xFF1D2C6B, 0xFF0000FF, 0xFF00FFFF, 0xFFADFF2F, 0xFFFFFF00, 0xFFFF0000, 0xFF8B0000};
        final float[] stops = new float[]{0, .1f, .3f, .5f, .7f, .9f, 1};
        final GradientColorPalette palette = new GradientColorPalette(colors, stops);
        // </CreateGradientColorPalette>
    }

    void setIsStepped() {
        final int[] colors = new int[]{0xFF1D2C6B, 0xFF0000FF, 0xFF00FFFF, 0xFFADFF2F, 0xFFFFFF00, 0xFFFF0000, 0xFF8B0000};
        final float[] stops = new float[]{0, .1f, .3f, .5f, .7f, .9f, 1};

        // <SetIsStepped>
        final GradientColorPalette palette = new GradientColorPalette(colors, stops, true);
        // </SetIsStepped>
    }

    void setBrushColorPalette() {
        // <SetBrushColorPalette>
        final Bitmap bitmap = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.example_weather_storm);
        CustomPointMarker3D pointMarker = new CustomPointMarker3D(bitmap);
        pointMarker.setSize(10);

        final TextureBrushStyle brushStyle = new TextureBrushStyle(bitmap);
        final BrushColorPalette palette = new BrushColorPalette(brushStyle);

        final SurfaceMeshRenderableSeries3D rSeries = sciChart3DBuilder.newSurfaceMeshSeries3D()
                .withMeshColorPalette(palette)
                .withMeshPaletteMode(MeshPaletteMode.Textured)
                .withMeshColorPaletteSize(new Size(bitmap.getWidth(), bitmap.getHeight()))
                .build();
        // </SetBrushColorPalette>
    }

    void setCustomPalette() {
        // <SetCustomPalette>
        class CustomPalette extends MeshColorPalette {
            @Override
            public Texture2D getTexture(int width, int height) {
                final Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                try {
                    return Texture2D.fromBitmap(bitmap);
                } finally {
                    bitmap.recycle();
                }
            }
        }
        // </SetCustomPalette>
    }

    void createSurfaceMeshMetaDataProvider3D() {
        // <CreateSurfaceMeshMetaDataProvider3D>
        class SurfaceMeshMetadataProvider3D extends MetadataProvider3DBase<SurfaceMeshRenderableSeries3D> implements ISurfaceMeshMetadataProvider3D {
            SurfaceMeshMetadataProvider3D() {
                super(SurfaceMeshRenderableSeries3D.class);
            }

            @Override
            public void updateMeshColors(IntegerValues cellColors) {
                final SurfaceMeshRenderPassData3D currentRenderPassData = (SurfaceMeshRenderPassData3D) renderableSeries.getCurrentRenderPassData();

                final int countX = currentRenderPassData.countX - 1;
                final int countZ = currentRenderPassData.countZ - 1;
                cellColors.setSize(currentRenderPassData.getPointsCount());

                final int[] items = cellColors.getItemsArray();
                for (int x = 0; x < countX; x++) {
                    for (int z = 0; z < countZ; z++) {
                        final int index = x * countZ + z;

                        final int color;
                        if ((x >= 20 && x <= 26 && z > 0 && z < 47) || (z >= 20 && z <= 26 && x > 0 && x < 47)) {
                            color = TRANSPARENT;
                        } else {
                            color = dataManager.getRandomColor();
                        }

                        items[index] = color;
                    }
                }
            }
        }
        // </CreateSurfaceMeshMetaDataProvider3D>
    }
}
