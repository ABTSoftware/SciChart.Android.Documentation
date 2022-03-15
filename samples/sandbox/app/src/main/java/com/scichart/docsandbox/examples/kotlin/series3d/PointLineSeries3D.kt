package com.scichart.docsandbox.examples.kotlin.series3d

import android.graphics.Color
import com.scichart.charting3d.model.dataSeries.xyz.XyzDataSeries3D
import com.scichart.charting3d.visuals.SciChartSurface3D
import com.scichart.charting3d.visuals.axes.NumericAxis3D
import com.scichart.charting3d.visuals.pointMarkers.SpherePointMarker3D
import com.scichart.charting3d.visuals.renderableSeries.metadataProviders.PointMetadataProvider3D
import com.scichart.charting3d.visuals.renderableSeries.metadataProviders.PointMetadataProvider3D.PointMetadata3D
import com.scichart.charting3d.visuals.renderableSeries.pointLine.PointLineRenderableSeries3D
import com.scichart.core.framework.UpdateSuspender
import com.scichart.data.model.DoubleRange
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.DataManager
import com.scichart.docsandbox.examples.base.SingleChart3DFragment

@ExampleDefinition()
class PointLineSeries3D : SingleChart3DFragment() {
    private val dataManager = DataManager()

    override fun initExample(surface: SciChartSurface3D) {
        createLineSeries(surface)
    }

    fun createLineSeries(surface: SciChartSurface3D) {
        // <CreateLineSeries>
        val xAxis = NumericAxis3D()
        xAxis.growBy = DoubleRange(.1, .1)
        val yAxis = NumericAxis3D()
        yAxis.growBy = DoubleRange(.1, .1)
        val zAxis = NumericAxis3D()
        zAxis.growBy = DoubleRange(.1, .1)

        val ds = XyzDataSeries3D(Double::class.java, Double::class.java, Double::class.java)
        val pointMetaDataProvider = PointMetadataProvider3D()

        for (i in 0..99) {
            val x = 5 * Math.sin(i.toDouble())
            val y = i.toDouble()
            val z = 5 * Math.cos(i.toDouble())
            ds.append(x, y, z)

            val metadata = PointMetadata3D(dataManager.randomColor)
            pointMetaDataProvider.metadata.add(metadata)
        }

        val pointMarker = SpherePointMarker3D()
        pointMarker.fill = Color.RED
        pointMarker.size = 10f

        val rs = PointLineRenderableSeries3D()
        rs.dataSeries = ds
        rs.strokeThickness = convertValueToDp(3f)
        rs.pointMarker = pointMarker
        rs.isLineStrips = true
        rs.metadataProvider = pointMetaDataProvider

        UpdateSuspender.using(surface) {
            surface.xAxis = xAxis
            surface.yAxis = yAxis
            surface.zAxis = zAxis
            surface.renderableSeries.add(rs)
            surface.chartModifiers.add(createDefaultModifiers3D())
        }
        // </CreateLineSeries>
    }

    fun addPointMarkers() {
        // <AddPointMarkers>
        val pointMarker = SpherePointMarker3D()
        pointMarker.size = 5f

        val rs = PointLineRenderableSeries3D()
        rs.pointMarker = pointMarker
        // </AddPointMarkers>
    }
}
