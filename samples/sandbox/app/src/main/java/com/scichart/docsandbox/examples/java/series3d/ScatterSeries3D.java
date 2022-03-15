package com.scichart.docsandbox.examples.java.series3d;

import androidx.annotation.NonNull;

import com.scichart.charting3d.model.dataSeries.xyz.XyzDataSeries3D;
import com.scichart.charting3d.visuals.SciChartSurface3D;
import com.scichart.charting3d.visuals.axes.NumericAxis3D;
import com.scichart.charting3d.visuals.pointMarkers.SpherePointMarker3D;
import com.scichart.charting3d.visuals.renderableSeries.scatter.ScatterRenderableSeries3D;
import com.scichart.core.framework.UpdateSuspender;
import com.scichart.data.model.DoubleRange;
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
        final NumericAxis3D xAxis = new NumericAxis3D();
        xAxis.setGrowBy(new DoubleRange(.1, .1));

        final NumericAxis3D yAxis = new NumericAxis3D();
        yAxis.setGrowBy(new DoubleRange(.1, .1));

        final NumericAxis3D zAxis = new NumericAxis3D();
        zAxis.setGrowBy(new DoubleRange(.1, .1));

        final XyzDataSeries3D<Double, Double, Double> ds = new XyzDataSeries3D<>(Double.class, Double.class, Double.class);
        for (int i = 0; i < 250; i++) {
            final double x = dataManager.getGaussianRandomNumber(15, 1.5);
            final double y = dataManager.getGaussianRandomNumber(15, 1.5);
            final double z = dataManager.getGaussianRandomNumber(15, 1.5);
            ds.append(x, y, z);
        }

        final SpherePointMarker3D pointMarker = new SpherePointMarker3D();
        pointMarker.setSize(10);
        pointMarker.setFill(0xFF32CD32);

        final ScatterRenderableSeries3D rs = new ScatterRenderableSeries3D();
        rs.setDataSeries(ds);
        rs.setPointMarker(pointMarker);

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
