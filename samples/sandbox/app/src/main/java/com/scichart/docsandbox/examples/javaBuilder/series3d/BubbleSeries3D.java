package com.scichart.docsandbox.examples.javaBuilder.series3d;

import androidx.annotation.NonNull;

import com.scichart.charting3d.model.dataSeries.xyz.XyzDataSeries3D;
import com.scichart.charting3d.visuals.SciChartSurface3D;
import com.scichart.charting3d.visuals.renderableSeries.metadataProviders.PointMetadataProvider3D;
import com.scichart.charting3d.visuals.renderableSeries.scatter.ScatterRenderableSeries3D;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.DataManager;
import com.scichart.docsandbox.examples.base.SingleChart3DFragment;

@ExampleDefinition()
public class BubbleSeries3D extends SingleChart3DFragment {
    private DataManager dataManager = new DataManager();

    @Override
    protected void initExample(@NonNull SciChartSurface3D surface) {
        // <CreatePointMetaDataProvider>
        final XyzDataSeries3D<Double, Double, Double> dataSeries = new XyzDataSeries3D<>(Double.class, Double.class, Double.class);
        final PointMetadataProvider3D pointMetaDataProvider = new PointMetadataProvider3D();

        for (int i = 0; i < 250; i++) {
            final double x = dataManager.getGaussianRandomNumber(5, 1.5);
            final double y = dataManager.getGaussianRandomNumber(5, 1.5);
            final double z = dataManager.getGaussianRandomNumber(5, 1.5);
            dataSeries.append(x, y, z);

            // Provide metadata for each point in DataSeries
            final PointMetadataProvider3D.PointMetadata3D metadata = new PointMetadataProvider3D.PointMetadata3D(dataManager.getRandomColor(), dataManager.getRandomScale());
            pointMetaDataProvider.metadata.add(metadata);
        }
        // </CreatePointMetaDataProvider>

        // <ApplyPointMetaDataProvider>
        // Apply the MetadataProvider onto the Scatter Series 3D
        final ScatterRenderableSeries3D rs = sciChart3DBuilder.newScatterSeries3D()
                .withMetadataProvider(pointMetaDataProvider)
                .build();
        // </ApplyPointMetaDataProvider>
    }
}
