package com.scichart.docsandbox.examples.kotlin.series3d

import com.scichart.charting3d.model.dataSeries.xyz.XyzDataSeries3D
import com.scichart.charting3d.visuals.SciChartSurface3D
import com.scichart.charting3d.visuals.axes.NumericAxis3D
import com.scichart.charting3d.visuals.pointMarkers.SpherePointMarker3D
import com.scichart.charting3d.visuals.renderableSeries.XyzRenderPassData3D
import com.scichart.charting3d.visuals.renderableSeries.impulse.ImpulseRenderableSeries3D
import com.scichart.charting3d.visuals.renderableSeries.metadataProviders.IPointMetadataProvider3D
import com.scichart.charting3d.visuals.renderableSeries.metadataProviders.IStrokeMetadataProvider3D
import com.scichart.charting3d.visuals.renderableSeries.metadataProviders.MetadataProvider3DBase
import com.scichart.charting3d.visuals.renderableSeries.pointLine.PointLineRenderableSeries3D
import com.scichart.core.framework.UpdateSuspender
import com.scichart.core.model.FloatValues
import com.scichart.core.model.IntegerValues
import com.scichart.data.model.DoubleRange
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart3DFragment

@ExampleDefinition()
class MetadataProvider3DAPI : SingleChart3DFragment() {
    override fun initExample(surface: SciChartSurface3D) {
        createCustomMetadataProvider(surface)
    }

    fun createCustomMetadataProvider(surface: SciChartSurface3D) {
        // <CreateCustomMetadataProvider>
        class CustomMetadataProvider :
            MetadataProvider3DBase<PointLineRenderableSeries3D>(PointLineRenderableSeries3D::class.java),
            IPointMetadataProvider3D, IStrokeMetadataProvider3D {
            override fun updateStrokeColors(integerValues: IntegerValues, i: Int) {
                updateColors(integerValues)
            }

            override fun updatePointMetadata(integerValues: IntegerValues, floatValues: FloatValues, i: Int, v: Float) {
                updateColors(integerValues)
                val pointsCount = renderableSeries!!.currentRenderPassData.pointsCount
                floatValues.setSize(pointsCount)
                for (x in 0 until pointsCount) {
                    floatValues[i] = 1f
                }
            }

            fun updateColors(colors: IntegerValues) {
                val rSeries = renderableSeries!!
                val renderPassData = rSeries.currentRenderPassData as XyzRenderPassData3D

                val upperThreshold = (rSeries.parentSurface.camera.orbitalYaw % 90).toDouble()
                val lowerThreshold = (rSeries.parentSurface.camera.orbitalPitch % 90).toDouble()

                val pointsCount = renderPassData.pointsCount
                colors.setSize(pointsCount)

                val yValues = renderPassData.yValues

                for (i in 0 until pointsCount) {
                    val value = yValues[i]
                    if (value > upperThreshold) {
                        colors[i] = -0x10000
                    } else if (value < lowerThreshold) {
                        colors[i] = -0xff0100
                    } else {
                        colors[i] = -0x100
                    }
                }
            }
        }
        // </CreateCustomMetadataProvider>

        // <SetCustomMetadataProvider>
        val xAxis = NumericAxis3D()
        xAxis.growBy = DoubleRange(.1, .1)

        val yAxis = NumericAxis3D()
        yAxis.growBy = DoubleRange(.1, .1)

        val zAxis = NumericAxis3D()
        zAxis.growBy = DoubleRange(.1, .1)

        val ds = XyzDataSeries3D(Double::class.java, Double::class.java, Double::class.java)
        for (i in 0..99) {
            val x = 5 * Math.sin(i.toDouble())
            val y = i.toDouble()
            val z = 5 * Math.cos(i.toDouble())
            ds.append(x, y, z)
        }

        val pointMarker = SpherePointMarker3D()
        pointMarker.size = 5f

        val rs = ImpulseRenderableSeries3D()
        rs.dataSeries = ds
        rs.strokeThickness = convertValueToDp(2f)
        rs.pointMarker = pointMarker
        rs.metadataProvider = CustomMetadataProvider()

        UpdateSuspender.using(surface) {
            surface.xAxis = xAxis
            surface.yAxis = yAxis
            surface.zAxis = zAxis
            surface.renderableSeries.add(rs)
            surface.chartModifiers.add(createDefaultModifiers3D())
        }
        // </SetCustomMetadataProvider>
    }
}
