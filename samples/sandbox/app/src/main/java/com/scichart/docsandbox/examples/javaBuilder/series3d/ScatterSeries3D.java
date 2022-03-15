package com.scichart.docsandbox.examples.javaBuilder.series3d;

import androidx.annotation.NonNull;

import com.scichart.charting3d.model.dataSeries.xyz.XyzDataSeries3D;
import com.scichart.charting3d.visuals.SciChartSurface3D;
import com.scichart.charting3d.visuals.axes.NumericAxis3D;
import com.scichart.charting3d.visuals.pointMarkers.SpherePointMarker3D;
import com.scichart.charting3d.visuals.renderableSeries.scatter.ScatterRenderableSeries3D;
import com.scichart.core.framework.UpdateSuspender;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.DataManager;
import com.scichart.docsandbox.examples.base.SingleChart3DFragment;

@ExampleDefinition()
public class ScatterSeries3D extends SingleChart3DFragment {
    private DataManager dataManager = new DataManager();

    @Override
    protected void initExample(@NonNull SciChartSurface3D surface) {
        createScatterSeries3D(surface);
    }

    void createScatterSeries3D(@NonNull SciChartSurface3D surface) {
        // <CreateScatterSeries3D>
        final NumericAxis3D xAxis = sciChart3DBuilder.newNumericAxis3D().withGrowBy(.1, .1).build();
        final NumericAxis3D yAxis = sciChart3DBuilder.newNumericAxis3D().withGrowBy(.1, .1).build();
        final NumericAxis3D zAxis = sciChart3DBuilder.newNumericAxis3D().withGrowBy(.1, .1).build();

        final XyzDataSeries3D<Double, Double, Double> ds = new XyzDataSeries3D<>(Double.class, Double.class, Double.class);
        for (int i = 0; i < 250; i++) {
            final double x = dataManager.getGaussianRandomNumber(15, 1.5);
            final double y = dataManager.getGaussianRandomNumber(15, 1.5);
            final double z = dataManager.getGaussianRandomNumber(15, 1.5);
            ds.append(x, y, z);
        }

        final SpherePointMarker3D pointMarker = sciChart3DBuilder.newSpherePointMarker3D()
                .withFill(0xFF32CD32)
                .withSize(10)
                .build();

        final ScatterRenderableSeries3D rs = sciChart3DBuilder.newScatterSeries3D()
                .withDataSeries(ds)
                .withPointMarker(pointMarker)
                .build();

        UpdateSuspender.using(surface, () -> {
            surface.setXAxis(xAxis);
            surface.setYAxis(yAxis);
            surface.setZAxis(zAxis);
            surface.getRenderableSeries().add(rs);
            surface.getChartModifiers().add(createDefaultModifiers3D());
        });
        //</CreateScatterSeries3D>
    }
}
