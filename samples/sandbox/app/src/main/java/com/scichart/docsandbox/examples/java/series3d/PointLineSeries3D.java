package com.scichart.docsandbox.examples.java.series3d;

import android.graphics.Color;

import androidx.annotation.NonNull;

import com.scichart.charting3d.model.dataSeries.xyz.XyzDataSeries3D;
import com.scichart.charting3d.visuals.SciChartSurface3D;
import com.scichart.charting3d.visuals.axes.NumericAxis3D;
import com.scichart.charting3d.visuals.pointMarkers.SpherePointMarker3D;
import com.scichart.charting3d.visuals.renderableSeries.metadataProviders.PointMetadataProvider3D;
import com.scichart.charting3d.visuals.renderableSeries.pointLine.PointLineRenderableSeries3D;
import com.scichart.core.framework.UpdateSuspender;
import com.scichart.data.model.DoubleRange;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.DataManager;
import com.scichart.docsandbox.examples.base.SingleChart3DFragment;

@ExampleDefinition()
public class PointLineSeries3D extends SingleChart3DFragment {
    private DataManager dataManager = new DataManager();

    @Override
    protected void initExample(@NonNull SciChartSurface3D surface) {
        createLineSeries(surface);
    }

    void createLineSeries(@NonNull SciChartSurface3D surface) {
        // <CreateLineSeries>
        final NumericAxis3D xAxis = new NumericAxis3D();
        xAxis.setGrowBy(new DoubleRange(.1, .1));

        final NumericAxis3D yAxis = new NumericAxis3D();
        yAxis.setGrowBy(new DoubleRange(.1, .1));

        final NumericAxis3D zAxis = new NumericAxis3D();
        zAxis.setGrowBy(new DoubleRange(.1, .1));

        final XyzDataSeries3D<Double, Double, Double> ds = new XyzDataSeries3D<>(Double.class, Double.class, Double.class);
        final PointMetadataProvider3D pointMetaDataProvider = new PointMetadataProvider3D();

        for (int i = 0; i < 100; i++) {
            final double x = 5 * Math.sin(i);
            final double y = i;
            final double z = 5 * Math.cos(i);
            ds.append(x, y, z);

            final PointMetadataProvider3D.PointMetadata3D metadata = new PointMetadataProvider3D.PointMetadata3D(dataManager.getRandomColor());
            pointMetaDataProvider.metadata.add(metadata);
        }

        final SpherePointMarker3D pointMarker = new SpherePointMarker3D();
        pointMarker.setFill(Color.RED);
        pointMarker.setSize(10);

        final PointLineRenderableSeries3D rs = new PointLineRenderableSeries3D();
        rs.setDataSeries(ds);
        rs.setStrokeThickness(convertValueToDp(3f));
        rs.setPointMarker(pointMarker);
        rs.setIsLineStrips(true);
        rs.setMetadataProvider(pointMetaDataProvider);

        UpdateSuspender.using(surface, () -> {
            surface.setXAxis(xAxis);
            surface.setYAxis(yAxis);
            surface.setZAxis(zAxis);
            surface.getRenderableSeries().add(rs);
            surface.getChartModifiers().add(createDefaultModifiers3D());
        });
        // </CreateLineSeries>
    }

    void addPointMarkers() {
        // <AddPointMarkers>
        final SpherePointMarker3D pointMarker = new SpherePointMarker3D();
        pointMarker.setSize(5);

        final PointLineRenderableSeries3D rs = new PointLineRenderableSeries3D();
        rs.setPointMarker(pointMarker);
        // </AddPointMarkers>
    }
}
