package com.scichart.docsandbox.examples.java.series3d;

import androidx.annotation.NonNull;

import com.scichart.charting3d.model.dataSeries.grid.UniformGridDataSeries3D;
import com.scichart.charting3d.model.dataSeries.xyz.XyzDataSeries3D;
import com.scichart.charting3d.visuals.SciChartSurface3D;
import com.scichart.charting3d.visuals.axes.NumericAxis3D;
import com.scichart.charting3d.visuals.pointMarkers.SpherePointMarker3D;
import com.scichart.charting3d.visuals.renderableSeries.impulse.ImpulseRenderableSeries3D;
import com.scichart.charting3d.visuals.renderableSeries.metadataProviders.PointMetadataProvider3D;
import com.scichart.core.framework.UpdateSuspender;
import com.scichart.data.model.DoubleRange;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.DataManager;
import com.scichart.docsandbox.examples.base.SingleChart3DFragment;

@ExampleDefinition()
public class ImpulseSeries3D extends SingleChart3DFragment {
    private static final int COUNT = 15;
    private DataManager dataManager = new DataManager();

    @Override
    protected void initExample(@NonNull SciChartSurface3D surface) {
        createUniformImpulseSeries3D(surface);
    }

    void createUniformImpulseSeries3D(@NonNull SciChartSurface3D surface) {
        // <CreateUniformImpulseSeries3D>
        final NumericAxis3D xAxis = new NumericAxis3D();
        xAxis.setGrowBy(new DoubleRange(.1, .1));

        final NumericAxis3D yAxis = new NumericAxis3D();
        yAxis.setVisibleRange(new DoubleRange(0.0, .5));
        yAxis.setGrowBy(new DoubleRange(.1, .1));

        final NumericAxis3D zAxis = new NumericAxis3D();
        zAxis.setGrowBy(new DoubleRange(.1, .1));

        final UniformGridDataSeries3D<Double, Double, Double> ds = new UniformGridDataSeries3D<>(Double.class, Double.class, Double.class, COUNT, COUNT);

        for (int x = 0; x < COUNT; x++) {
            for (int z = 0; z < COUNT; z++) {
                final double y = Math.sin(x * .25) / ((z + 1) * 2);

                ds.updateYAt(x, z, y);
            }
        }

        final SpherePointMarker3D pointMarker = new SpherePointMarker3D();
        pointMarker.setSize(5);
        pointMarker.setFill(0xFF1E90FF);

        final ImpulseRenderableSeries3D rs = new ImpulseRenderableSeries3D();
        rs.setDataSeries(ds);
        rs.setStroke(0xFF1E90FF);
        rs.setStrokeThickness(convertValueToDp(2f));
        rs.setPointMarker(pointMarker);

        UpdateSuspender.using(surface, () -> {
            surface.setXAxis(xAxis);
            surface.setYAxis(yAxis);
            surface.setZAxis(zAxis);
            surface.getRenderableSeries().add(rs);
            surface.getChartModifiers().add(createDefaultModifiers3D());
        });
        // </CreateUniformImpulseSeries3D>
    }

    void createSingleRowImpulse(@NonNull SciChartSurface3D surface) {
        // <CreateSingleRowImpulse>
        final UniformGridDataSeries3D<Double, Double, Double> ds = new UniformGridDataSeries3D<>(Double.class, Double.class, Double.class, COUNT, COUNT);

        for (int x = 0; x < COUNT; x++) {
            for (int z = 0; z < COUNT; z++) {
                final double y = Math.sin(x * .25) / ((z + 1) * 2);

                ds.updateYAt(x, z, y);
            }
        }
        // </CreateSingleRowImpulse>

        // <SetSingleRowImpulse>
        surface.getWorldDimensions().assign(200, 100, 20);
        // </SetSingleRowImpulse>
    }

    void createNonUniformImpulseSeries3D() {
        // <CreateNonUniformImpulseSeries3D>
        final XyzDataSeries3D<Double, Double, Double> ds = new XyzDataSeries3D<>(Double.class, Double.class, Double.class);
        final PointMetadataProvider3D metadataProvider = new PointMetadataProvider3D();

        for (double i = 1; i < COUNT; i++) {
            for (double j = 1; j <= COUNT; j++) {
                if (i != j && i % 2 == 0 && j % 2 == 0) {
                    final double y = dataManager.getGaussianRandomNumber(15, 1.5);
                    ds.append(i, y, j);

                    final PointMetadataProvider3D.PointMetadata3D metadata = new PointMetadataProvider3D.PointMetadata3D(dataManager.getRandomColor());
                    metadataProvider.metadata.add(metadata);
                }
            }
        }

        final ImpulseRenderableSeries3D rs = new ImpulseRenderableSeries3D();
        rs.setDataSeries(ds);
        rs.setMetadataProvider(metadataProvider);
        // </CreateNonUniformImpulseSeries3D>
    }
}
