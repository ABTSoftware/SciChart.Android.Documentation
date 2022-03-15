package com.scichart.docsandbox.examples.kotlin.series3d

import com.scichart.charting3d.common.math.Vector3
import com.scichart.charting3d.model.dataSeries.freeSurface.PolarDataSeries3D
import com.scichart.charting3d.visuals.SciChartSurface3D
import com.scichart.charting3d.visuals.renderableSeries.data.DrawMeshAs
import com.scichart.charting3d.visuals.renderableSeries.data.GradientColorPalette
import com.scichart.charting3d.visuals.renderableSeries.freeSurface.FreeSurfacePaletteMinMaxMode
import com.scichart.charting3d.visuals.renderableSeries.freeSurface.FreeSurfaceRenderableSeries3D
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart3DFragment
import java.util.*

@ExampleDefinition()
class FreeSurfaceSeries3DPolar : SingleChart3DFragment() {
    override fun initExample(surface: SciChartSurface3D) {
        createPolar3DChart()
    }

    fun createPolar3DChart() {
        // <CreatePolar3DChart>
        val sizeU = 30
        val sizeV = 10

        val meshDataSeries = PolarDataSeries3D(Double::class.java, Double::class.java, sizeU, sizeV, 0.0, Math.PI * 1.75)

        meshDataSeries.a = 1.0
        meshDataSeries.b = 5.0

        val random = Random()
        for (u in 0 until sizeU) {
            val weightU = 1.0 - Math.abs(2.0 * u / sizeU - 1.0)
            for (v in 0 until sizeV) {
                val weightV = 1.0 - Math.abs(2.0 * v / sizeV - 1.0)
                val offset = random.nextDouble()
                meshDataSeries.setDisplacement(u, v, offset * weightU * weightV)
            }
        }

        val colors = intArrayOf(0xFF00008B.toInt(), 0xFF0000FF.toInt(), 0xFF00FFFF.toInt(), 0xFFADFF2F.toInt(), 0xFFFFFF00.toInt(), 0xFFFF0000.toInt(), 0xFF8B0000.toInt())
        val stops = floatArrayOf(0f, .1f, .3f, .5f, .7f, .9f, 1f)
        val palette = GradientColorPalette(colors, stops)

        val rs = FreeSurfaceRenderableSeries3D()
        rs.dataSeries = meshDataSeries
        rs.drawMeshAs = DrawMeshAs.SolidWireframe
        rs.stroke = 0x77228B22
        rs.contourInterval = 0.1f
        rs.contourStroke = 0x77228B22
        rs.strokeThickness = convertValueToDp(2f)
        rs.lightingFactor = 0.8f
        rs.meshColorPalette = palette
        rs.paletteMinMaxMode = FreeSurfacePaletteMinMaxMode.Relative
        rs.paletteMinimum = Vector3(0f, 0f, 0f)
        rs.paletteMaximum = Vector3(0f, 0.5f, 0f)
        // </CreatePolar3DChart>
    }
}
