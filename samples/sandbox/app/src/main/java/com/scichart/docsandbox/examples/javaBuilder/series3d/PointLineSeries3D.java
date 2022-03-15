package com.scichart.docsandbox.examples.javaBuilder.series3d;

import android.graphics.Color;

import androidx.annotation.NonNull;

import com.scichart.charting3d.model.dataSeries.xyz.XyzDataSeries3D;
import com.scichart.charting3d.visuals.SciChartSurface3D;
import com.scichart.charting3d.visuals.axes.NumericAxis3D;
import com.scichart.charting3d.visuals.pointMarkers.SpherePointMarker3D;
import com.scichart.charting3d.visuals.renderableSeries.metadataProviders.PointMetadataProvider3D;
import com.scichart.charting3d.visuals.renderableSeries.pointLine.PointLineRenderableSeries3D;
import com.scichart.core.framework.UpdateSuspender;
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
        final NumericAxis3D xAxis = sciChart3DBuilder.newNumericAxis3D().withGrowBy(.1, .1).build();
        final NumericAxis3D yAxis = sciChart3DBuilder.newNumericAxis3D().withGrowBy(.1, .1).build();
        final NumericAxis3D zAxis = sciChart3DBuilder.newNumericAxis3D().withGrowBy(.1, .1).build();

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

        final SpherePointMarker3D pointMarker = sciChart3DBuilder.newSpherePointMarker3D()
                .withFill(Color.RED)
                .withSize(10)
                .build();

        final PointLineRenderableSeries3D rs = sciChart3DBuilder.newPointLinesSeries3D()
                .withDataSeries(ds)
                .withStrokeThicknes(3f)
                .withPointMarker(pointMarker)
                .withIsLineStrips(true)
                .withMetadataProvider(pointMetaDataProvider)
                .build();

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
        final SpherePointMarker3D pointMarker = sciChart3DBuilder.newSpherePointMarker3D()
                .withSize(5)
                .build();

        final PointLineRenderableSeries3D rs = sciChart3DBuilder.newPointLinesSeries3D()
                .withPointMarker(pointMarker)
                .build();
        // </AddPointMarkers>
    }
}
