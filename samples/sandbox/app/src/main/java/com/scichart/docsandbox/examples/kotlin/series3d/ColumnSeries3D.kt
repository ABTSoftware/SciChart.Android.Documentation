package com.scichart.docsandbox.examples.kotlin.series3d

import com.scichart.charting3d.model.dataSeries.grid.UniformGridDataSeries3D
import com.scichart.charting3d.model.dataSeries.xyz.XyzDataSeries3D
import com.scichart.charting3d.modifiers.OrbitModifier3D
import com.scichart.charting3d.modifiers.PinchZoomModifier3D
import com.scichart.charting3d.modifiers.ZoomExtentsModifier3D
import com.scichart.charting3d.visuals.SciChartSurface3D
import com.scichart.charting3d.visuals.axes.NumericAxis3D
import com.scichart.charting3d.visuals.camera.Camera3D
import com.scichart.charting3d.visuals.renderableSeries.columns.ColumnRenderableSeries3D
import com.scichart.charting3d.visuals.renderableSeries.metadataProviders.PointMetadataProvider3D
import com.scichart.charting3d.visuals.renderableSeries.metadataProviders.PointMetadataProvider3D.PointMetadata3D
import com.scichart.core.framework.UpdateSuspender
import com.scichart.data.model.DoubleRange
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.DataManager
import com.scichart.docsandbox.examples.base.SingleChart3DFragment
import com.scichart.drawing.utility.ColorUtil
import java.util.*

@ExampleDefinition()
class ColumnSeries3D : SingleChart3DFragment() {
    private val dataManager = DataManager()
    private val COUNT = 15

    override fun initExample(surface: SciChartSurface3D) {
        createUniformColumnSeries3D(surface)
    }

    fun createUniformColumnSeries3D(surface: SciChartSurface3D) {
        // <CreateUniformColumnSeries3D>
        val ds = UniformGridDataSeries3D(Double::class.java, Double::class.java, Double::class.java, COUNT, COUNT)
        for (x in 0 until COUNT) {
            for (z in 0 until COUNT) {
                val y = Math.sin(x * .25) / ((z + 1) * 2)
                ds.updateYAt(x, z, y)
            }
        }
        val camera = Camera3D()
        val xAxis = NumericAxis3D()
        xAxis.growBy = DoubleRange(.1, .1)

        val yAxis = NumericAxis3D()
        yAxis.growBy = DoubleRange(.1, .1)

        val zAxis = NumericAxis3D()
        zAxis.growBy = DoubleRange(.1, .1)

        val rs = ColumnRenderableSeries3D()
        rs.fill = ColorUtil.DodgerBlue
        rs.dataSeries = ds

        val orbitModifier3D = OrbitModifier3D()
        orbitModifier3D.receiveHandledEvents = true
        orbitModifier3D.executeOnPointerCount = 1

        UpdateSuspender.using(surface) {
            surface.camera = camera
            surface.xAxis = xAxis
            surface.yAxis = yAxis
            surface.zAxis = zAxis
            surface.renderableSeries.add(rs)
            Collections.addAll(surface.chartModifiers, PinchZoomModifier3D(), orbitModifier3D, ZoomExtentsModifier3D())
        }
        // </CreateUniformColumnSeries3D>
    }

    fun createSingleRowColumn3DCharts(surface: SciChartSurface3D) {
        // <CreateSingleRowColumn3DCharts>
        val ds = UniformGridDataSeries3D(Double::class.java, Double::class.java, Double::class.java, COUNT, COUNT)
        for (x in 0 until COUNT) {
            for (z in 0..0) {
                val y = Math.sin(x * .25) / ((z + 1) * 2)
                ds.updateYAt(x, z, y)
            }
        }
        // </CreateSingleRowColumn3DCharts>

        // <UpdateSurfaceWorldDimensions>
        surface.worldDimensions.assign(200f, 100f, 20f)
        // </UpdateSurfaceWorldDimensions>
    }

    fun createNonUniformColumnSeries3D() {
        // <CreateNonUniformColumnSeries3D>
        val dataSeries = XyzDataSeries3D(Double::class.java, Double::class.java, Double::class.java)
        val pointMetaDataProvider = PointMetadataProvider3D()

        for (i in 1 until COUNT) {
            for (j in 1..COUNT) {
                if (i != j && i % 2 == 0 && j % 2 == 0) {
                    val y: Double = dataManager.getGaussianRandomNumber(5.0, 1.5)
                    dataSeries.append(i.toDouble(), y, j.toDouble())
                    val metadata = PointMetadata3D(dataManager.getRandomColor(), dataManager.getRandomScale())
                    pointMetaDataProvider.metadata.add(metadata)
                }
            }
        }

        val rs = ColumnRenderableSeries3D()
        rs.dataSeries = dataSeries
        rs.metadataProvider = pointMetaDataProvider
        // </CreateNonUniformColumnSeries3D>
    }
}
