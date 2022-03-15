package com.scichart.docsandbox.examples.kotlin.series3d

import com.scichart.charting3d.common.math.Vector3
import com.scichart.charting3d.model.dataSeries.freeSurface.CylindroidDataSeries3D
import com.scichart.charting3d.visuals.SciChartSurface3D
import com.scichart.charting3d.visuals.renderableSeries.data.DrawMeshAs
import com.scichart.charting3d.visuals.renderableSeries.data.GradientColorPalette
import com.scichart.charting3d.visuals.renderableSeries.freeSurface.FreeSurfacePaletteMinMaxMode
import com.scichart.charting3d.visuals.renderableSeries.freeSurface.FreeSurfaceRenderableSeries3D
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart3DFragment
import java.util.*

@ExampleDefinition()
class FreeSurfaceSeries3DCylindroid : SingleChart3DFragment() {
    override fun initExample(surface: SciChartSurface3D) {
        createCylindroid3DChart()
    }

    fun createCylindroid3DChart() {
        // <CreateCylindroid3DChart>
        val sizeU = 40
        val sizeV = 20

        val meshDataSeries = CylindroidDataSeries3D(Double::class.java, Double::class.java, sizeU, sizeV)
        meshDataSeries.a = 3.0
        meshDataSeries.b = 3.0
        meshDataSeries.h = 7.0

        val random = Random()
        for (u in 0 until sizeU) {
            for (v in 0 until sizeV) {
                val weight = 1.0 - Math.abs(2.0 * v / sizeV - 1.0)
                val offset = random.nextDouble()
                meshDataSeries.setDisplacement(u, v, offset * weight)
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
        rs.paletteMinimum = Vector3(3f, 0f, 0f)
        rs.paletteMaximum = Vector3(4f, 0f, 0f)
        // </CreateCylindroid3DChart>
    }
}
