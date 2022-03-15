package com.scichart.docsandbox.examples.kotlin.series3d

import com.scichart.charting3d.model.dataSeries.xyz.XyzDataSeries3D
import com.scichart.charting3d.visuals.SciChartSurface3D
import com.scichart.charting3d.visuals.renderableSeries.metadataProviders.PointMetadataProvider3D
import com.scichart.charting3d.visuals.renderableSeries.metadataProviders.PointMetadataProvider3D.PointMetadata3D
import com.scichart.charting3d.visuals.renderableSeries.scatter.ScatterRenderableSeries3D
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.DataManager
import com.scichart.docsandbox.examples.base.SingleChart3DFragment

@ExampleDefinition()
class BubbleSeries3D : SingleChart3DFragment() {
    private val dataManager = DataManager()

    override fun initExample(surface: SciChartSurface3D) {
        // <CreatePointMetaDataProvider>
        val dataSeries = XyzDataSeries3D(
            Double::class.java,
            Double::class.java,
            Double::class.java
        )
        val pointMetaDataProvider = PointMetadataProvider3D()

        for (i in 0..249) {
            val x = dataManager.getGaussianRandomNumber(5.0, 1.5)
            val y = dataManager.getGaussianRandomNumber(5.0, 1.5)
            val z = dataManager.getGaussianRandomNumber(5.0, 1.5)
            dataSeries.append(x, y, z)

            // Provide metadata for each point in DataSeries
            val metadata = PointMetadata3D(dataManager.getRandomColor(), dataManager.getRandomScale())
            pointMetaDataProvider.metadata.add(metadata)
        }
        // </CreatePointMetaDataProvider>

        // <ApplyPointMetaDataProvider>
        // Apply the MetadataProvider onto the Scatter Series 3D
        val rs = ScatterRenderableSeries3D()
        rs.metadataProvider = pointMetaDataProvider
        // </ApplyPointMetaDataProvider>
    }
}
