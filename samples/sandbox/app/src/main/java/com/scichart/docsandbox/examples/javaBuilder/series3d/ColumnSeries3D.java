package com.scichart.docsandbox.examples.javaBuilder.series3d;

import androidx.annotation.NonNull;

import com.scichart.charting3d.model.dataSeries.grid.UniformGridDataSeries3D;
import com.scichart.charting3d.model.dataSeries.xyz.XyzDataSeries3D;
import com.scichart.charting3d.visuals.SciChartSurface3D;
import com.scichart.charting3d.visuals.axes.NumericAxis3D;
import com.scichart.charting3d.visuals.camera.Camera3D;
import com.scichart.charting3d.visuals.renderableSeries.columns.ColumnRenderableSeries3D;
import com.scichart.charting3d.visuals.renderableSeries.metadataProviders.PointMetadataProvider3D;
import com.scichart.core.framework.UpdateSuspender;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.DataManager;
import com.scichart.docsandbox.examples.base.SingleChart3DFragment;
import com.scichart.drawing.utility.ColorUtil;

@ExampleDefinition()
public class ColumnSeries3D extends SingleChart3DFragment {
    private DataManager dataManager = new DataManager();
    private static final int COUNT = 15;

    @Override
    protected void initExample(@NonNull SciChartSurface3D surface) {
        createUniformColumnSeries3D(surface);
    }

    void createUniformColumnSeries3D(@NonNull SciChartSurface3D surface) {
        // <CreateUniformColumnSeries3D>
        final UniformGridDataSeries3D<Double, Double, Double> ds = new UniformGridDataSeries3D<>(Double.class, Double.class, Double.class, COUNT, COUNT);
        for (int x = 0; x < COUNT; x++) {
            for (int z = 0; z < COUNT; z++) {
                final double y = Math.sin(x * .25) / ((z + 1) * 2);
                ds.updateYAt(x, z, y);
            }
        }
        final Camera3D camera = sciChart3DBuilder.newCamera3D().build();
        final NumericAxis3D xAxis = sciChart3DBuilder.newNumericAxis3D().withGrowBy(.1, .1).build();
        final NumericAxis3D yAxis = sciChart3DBuilder.newNumericAxis3D().withVisibleRange(0, 0.5).build();
        final NumericAxis3D zAxis = sciChart3DBuilder.newNumericAxis3D().withGrowBy(.1, .1).build();

        final ColumnRenderableSeries3D rs = sciChart3DBuilder.newColumnSeries3D()
                .withFill(ColorUtil.DodgerBlue)
                .withDataSeries(ds)
                .build();

        UpdateSuspender.using(surface, new Runnable() {
            @Override
            public void run() {
                surface.setCamera(camera);
                surface.setXAxis(xAxis);
                surface.setYAxis(yAxis);
                surface.setZAxis(zAxis);
                surface.getRenderableSeries().add(rs);
                surface.getChartModifiers().add(sciChart3DBuilder.newModifierGroupWithDefaultModifiers().build());
            }
        });
        // </CreateUniformColumnSeries3D>
    }

    void createSingleRowColumn3DCharts(@NonNull SciChartSurface3D surface) {
        // <CreateSingleRowColumn3DCharts>
        final UniformGridDataSeries3D<Double, Double, Double> ds = new UniformGridDataSeries3D<>(Double.class, Double.class, Double.class, COUNT, COUNT);
        for (int x = 0; x < COUNT; x++) {
            for (int z = 0; z < 1; z++) {
                final double y = Math.sin(x * .25) / ((z + 1) * 2);
                ds.updateYAt(x, z, y);
            }
        }
        // </CreateSingleRowColumn3DCharts>

        // <UpdateSurfaceWorldDimensions>
        surface.getWorldDimensions().assign(200, 100, 20);
        // </UpdateSurfaceWorldDimensions>
    }

    void createNonUniformColumnSeries3D() {
        // <CreateNonUniformColumnSeries3D>
        final XyzDataSeries3D<Double, Double, Double> dataSeries = new XyzDataSeries3D<>(Double.class, Double.class, Double.class);
        final PointMetadataProvider3D pointMetaDataProvider = new PointMetadataProvider3D();

        for (double i = 1; i < COUNT; i++) {
            for (double j = 1; j <= COUNT; j++) {
                if (i != j && i % 2 == 0 && j % 2 == 0) {
                    final double y = dataManager.getGaussianRandomNumber(5, 1.5);
                    dataSeries.append(i, y, j);

                    final PointMetadataProvider3D.PointMetadata3D metadata = new PointMetadataProvider3D.PointMetadata3D(dataManager.getRandomColor(), dataManager.getRandomScale());
                    pointMetaDataProvider.metadata.add(metadata);
                }
            }
        }

        final ColumnRenderableSeries3D rs = sciChart3DBuilder.newColumnSeries3D()
                .withDataSeries(dataSeries)
                .withMetadataProvider(pointMetaDataProvider)
                .build();
        // </CreateNonUniformColumnSeries3D>
    }
}
