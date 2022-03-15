package com.scichart.docsandbox.examples.java.series3d;

import androidx.annotation.NonNull;

import com.scichart.charting3d.model.dataSeries.grid.UniformGridDataSeries3D;
import com.scichart.charting3d.model.dataSeries.xyz.XyzDataSeries3D;
import com.scichart.charting3d.modifiers.OrbitModifier3D;
import com.scichart.charting3d.modifiers.PinchZoomModifier3D;
import com.scichart.charting3d.modifiers.ZoomExtentsModifier3D;
import com.scichart.charting3d.visuals.SciChartSurface3D;
import com.scichart.charting3d.visuals.axes.NumericAxis3D;
import com.scichart.charting3d.visuals.camera.Camera3D;
import com.scichart.charting3d.visuals.renderableSeries.columns.ColumnRenderableSeries3D;
import com.scichart.charting3d.visuals.renderableSeries.metadataProviders.PointMetadataProvider3D;
import com.scichart.core.framework.UpdateSuspender;
import com.scichart.data.model.DoubleRange;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.DataManager;
import com.scichart.docsandbox.examples.base.SingleChart3DFragment;
import com.scichart.drawing.utility.ColorUtil;

import java.util.Collections;

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
        final Camera3D camera = new Camera3D();
        final NumericAxis3D xAxis = new NumericAxis3D();
        xAxis.setGrowBy(new DoubleRange(.1, .1));

        final NumericAxis3D yAxis = new NumericAxis3D();
        yAxis.setGrowBy(new DoubleRange(.1, .1));

        final NumericAxis3D zAxis = new NumericAxis3D();
        zAxis.setGrowBy(new DoubleRange(.1, .1));

        final ColumnRenderableSeries3D rs = new ColumnRenderableSeries3D();
        rs.setFill(ColorUtil.DodgerBlue);
        rs.setDataSeries(ds);

        OrbitModifier3D orbitModifier3D = new OrbitModifier3D();
        orbitModifier3D.setReceiveHandledEvents(true);
        orbitModifier3D.setExecuteOnPointerCount(1);

        UpdateSuspender.using(surface, new Runnable() {
            @Override
            public void run() {
                surface.setCamera(camera);
                surface.setXAxis(xAxis);
                surface.setYAxis(yAxis);
                surface.setZAxis(zAxis);
                surface.getRenderableSeries().add(rs);
                Collections.addAll(surface.getChartModifiers(), new PinchZoomModifier3D(), orbitModifier3D, new ZoomExtentsModifier3D());
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

        final ColumnRenderableSeries3D rs = new ColumnRenderableSeries3D();
        rs.setDataSeries(dataSeries);
        rs.setMetadataProvider(pointMetaDataProvider);
        // </CreateNonUniformColumnSeries3D>
    }
}
