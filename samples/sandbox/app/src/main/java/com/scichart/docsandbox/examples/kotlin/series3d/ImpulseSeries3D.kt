package com.scichart.docsandbox.examples.kotlin.series3d

import com.scichart.charting3d.model.dataSeries.grid.UniformGridDataSeries3D
import com.scichart.charting3d.model.dataSeries.xyz.XyzDataSeries3D
import com.scichart.charting3d.visuals.SciChartSurface3D
import com.scichart.charting3d.visuals.axes.NumericAxis3D
import com.scichart.charting3d.visuals.pointMarkers.SpherePointMarker3D
import com.scichart.charting3d.visuals.renderableSeries.impulse.ImpulseRenderableSeries3D
import com.scichart.charting3d.visuals.renderableSeries.metadataProviders.PointMetadataProvider3D
import com.scichart.charting3d.visuals.renderableSeries.metadataProviders.PointMetadataProvider3D.PointMetadata3D
import com.scichart.core.framework.UpdateSuspender
import com.scichart.data.model.DoubleRange
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.DataManager
import com.scichart.docsandbox.examples.base.SingleChart3DFragment

@ExampleDefinition()
class ImpulseSeries3D : SingleChart3DFragment() {
    private val COUNT = 15
    private val dataManager = DataManager()

    override fun initExample(surface: SciChartSurface3D) {
        createUniformImpulseSeries3D(surface)
    }

    fun createUniformImpulseSeries3D(surface: SciChartSurface3D) {
        // <CreateUniformImpulseSeries3D>
        val xAxis = NumericAxis3D()
        xAxis.growBy = DoubleRange(.1, .1)

        val yAxis = NumericAxis3D()
        yAxis.setVisibleRange(DoubleRange(0.0, .5))
        yAxis.growBy = DoubleRange(.1, .1)

        val zAxis = NumericAxis3D()
        zAxis.growBy = DoubleRange(.1, .1)

        val ds = UniformGridDataSeries3D(Double::class.java, Double::class.java, Double::class.java, COUNT, COUNT)

        for (x in 0 until COUNT) {
            for (z in 0 until COUNT) {
                val y = Math.sin(x * .25) / ((z + 1) * 2)
                ds.updateYAt(x, z, y)
            }
        }
        val pointMarker = SpherePointMarker3D()
        pointMarker.size = 5f
        pointMarker.fill = 0xFF1E90FF.toInt()

        val rs = ImpulseRenderableSeries3D()
        rs.dataSeries = ds
        rs.stroke = 0xFF1E90FF.toInt()
        rs.strokeThickness = convertValueToDp(2f)
        rs.pointMarker = pointMarker

        UpdateSuspender.using(surface) {
            surface.xAxis = xAxis
            surface.yAxis = yAxis
            surface.zAxis = zAxis
            surface.renderableSeries.add(rs)
            surface.chartModifiers.add(createDefaultModifiers3D())
        }
        // </CreateUniformImpulseSeries3D>
    }

    fun createSingleRowImpulse(surface: SciChartSurface3D) {
        // <CreateSingleRowImpulse>
        val ds = UniformGridDataSeries3D(
            Double::class.java,
            Double::class.java,
            Double::class.java, COUNT, COUNT
        )
        for (x in 0 until COUNT) {
            for (z in 0 until COUNT) {
                val y = Math.sin(x * .25) / ((z + 1) * 2)
                ds.updateYAt(x, z, y)
            }
        }
        // </CreateSingleRowImpulse>

        // <SetSingleRowImpulse>
        surface.worldDimensions.assign(200f, 100f, 20f)
        // </SetSingleRowImpulse>
    }

    fun createNonUniformImpulseSeries3D() {
        // <CreateNonUniformImpulseSeries3D>
        val ds = XyzDataSeries3D(
            Double::class.java,
            Double::class.java,
            Double::class.java
        )

        val metadataProvider = PointMetadataProvider3D()

        for (i in 1 until COUNT) {
            for (j in 1..COUNT) {
                if (i != j && i % 2.0 == 0.0 && j % 2.0 == 0.0) {
                    val y = dataManager.getGaussianRandomNumber(15.0, 1.5)
                    ds.append(i.toDouble(), y, j.toDouble())
                    val metadata = PointMetadata3D(dataManager.randomColor)
                    metadataProvider.metadata.add(metadata)
                }
            }
        }
        
        val rs = ImpulseRenderableSeries3D()
        rs.dataSeries = ds
        rs.metadataProvider = metadataProvider
        // </CreateNonUniformImpulseSeries3D>
    }
}
