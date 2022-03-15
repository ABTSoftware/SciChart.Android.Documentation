package com.scichart.docsandbox.examples.kotlin.series3d

import com.scichart.charting3d.model.dataSeries.xyz.XyzDataSeries3D
import com.scichart.charting3d.visuals.SciChartSurface3D
import com.scichart.charting3d.visuals.axes.NumericAxis3D
import com.scichart.charting3d.visuals.pointMarkers.SpherePointMarker3D
import com.scichart.charting3d.visuals.renderableSeries.scatter.ScatterRenderableSeries3D
import com.scichart.core.framework.UpdateSuspender
import com.scichart.data.model.DoubleRange
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.DataManager
import com.scichart.docsandbox.examples.base.SingleChart3DFragment

@ExampleDefinition()
class ScatterSeries3D : SingleChart3DFragment() {
    private val dataManager = DataManager()

    override fun initExample(surface: SciChartSurface3D) {
        createScatterSeries3D(surface)
    }

    fun createScatterSeries3D(surface: SciChartSurface3D) {
        // <CreateScatterSeries3D>
        val xAxis = NumericAxis3D()
        xAxis.growBy = DoubleRange(.1, .1)
        val yAxis = NumericAxis3D()
        yAxis.growBy = DoubleRange(.1, .1)
        val zAxis = NumericAxis3D()
        zAxis.growBy = DoubleRange(.1, .1)

        val ds = XyzDataSeries3D(
            Double::class.java,
            Double::class.java,
            Double::class.java
        )

        for (i in 0..249) {
            val x: Double = dataManager.getGaussianRandomNumber(15.0, 1.5)
            val y: Double = dataManager.getGaussianRandomNumber(15.0, 1.5)
            val z: Double = dataManager.getGaussianRandomNumber(15.0, 1.5)
            ds.append(x, y, z)
        }

        val pointMarker = SpherePointMarker3D()
        pointMarker.size = 10f
        pointMarker.fill = 0xFF32CD32.toInt()

        val rs = ScatterRenderableSeries3D()
        rs.dataSeries = ds
        rs.pointMarker = pointMarker

        UpdateSuspender.using(surface) {
            surface.xAxis = xAxis
            surface.yAxis = yAxis
            surface.zAxis = zAxis
            surface.renderableSeries.add(rs)
            surface.chartModifiers.add(createDefaultModifiers3D())
        }
        //</CreateScatterSeries3D>
    }
}
