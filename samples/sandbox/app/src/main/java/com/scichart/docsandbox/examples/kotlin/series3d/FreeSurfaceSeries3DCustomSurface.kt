package com.scichart.docsandbox.examples.kotlin.series3d

import com.scichart.charting3d.common.math.Vector3
import com.scichart.charting3d.model.dataSeries.freeSurface.CustomSurfaceDataSeries3D
import com.scichart.charting3d.model.dataSeries.freeSurface.CustomSurfaceDataSeries3D.UVFunc
import com.scichart.charting3d.model.dataSeries.freeSurface.CustomSurfaceDataSeries3D.ValueFunc
import com.scichart.charting3d.visuals.SciChartSurface3D
import com.scichart.charting3d.visuals.renderableSeries.data.DrawMeshAs
import com.scichart.charting3d.visuals.renderableSeries.data.GradientColorPalette
import com.scichart.charting3d.visuals.renderableSeries.freeSurface.FreeSurfacePaletteMinMaxMode
import com.scichart.charting3d.visuals.renderableSeries.freeSurface.FreeSurfaceRenderableSeries3D
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart3DFragment
import com.scichart.drawing.utility.ColorUtil

@ExampleDefinition()
class FreeSurfaceSeries3DCustomSurface : SingleChart3DFragment() {
    override fun initExample(surface: SciChartSurface3D) {
        createCustomFreeSurface()
    }

    fun createCustomFreeSurface() {
        // <CreateCustomFreeSurface>
        val radialDistanceFunc = UVFunc { u: Double, v: Double -> 5.0 + Math.sin(5 * (u + v)) }
        val azimuthalAngleFunc = UVFunc { u: Double, v: Double -> u }
        val polarAngleFunc = UVFunc { u: Double, v: Double -> v }

        val xFunc = ValueFunc { r: Double, theta: Double, phi: Double -> r * Math.sin(theta) * Math.cos(phi) }
        val yFunc = ValueFunc { r: Double, theta: Double, phi: Double -> r * Math.cos(theta) }
        val zFunc = ValueFunc { r: Double, theta: Double, phi: Double -> r * Math.sin(theta) * Math.sin(phi) }

        val ds = CustomSurfaceDataSeries3D(
            Double::class.java, Double::class.java, Double::class.java,
            30, 30,
            radialDistanceFunc, azimuthalAngleFunc, polarAngleFunc,
            xFunc, yFunc, zFunc,
            0.0, Math.PI * 2, 0.0, Math.PI
        )

        val colors = intArrayOf(0xFF1D2C6B.toInt(), ColorUtil.Blue, ColorUtil.Cyan, ColorUtil.GreenYellow, ColorUtil.Yellow, ColorUtil.Red, ColorUtil.DarkRed)
        val stops = floatArrayOf(0f, .1f, .3f, .5f, .7f, .9f, 1f)
        val palette = GradientColorPalette(colors, stops)

        val rs = FreeSurfaceRenderableSeries3D()
        rs.dataSeries = ds
        rs.drawMeshAs = DrawMeshAs.SolidWireframe
        rs.stroke = 0x77228B22
        rs.contourInterval = 0.1f
        rs.contourStroke = 0x77228B22
        rs.strokeThickness = convertValueToDp(2f)
        rs.lightingFactor = 0.8f
        rs.meshColorPalette = palette
        rs.paletteMinMaxMode = FreeSurfacePaletteMinMaxMode.Relative
        rs.paletteMinimum = Vector3(0f, 5f, 0f)
        rs.paletteMaximum = Vector3(0f, 7f, 0f)
        // </CreateCustomFreeSurface>
    }

    fun createSimpleSphere() {
        // <CreateSimpleSphere>
        val radialDistanceFunc = UVFunc { u: Double, v: Double -> 5.0 + Math.sin(5 * (u + v)) }
        val azimuthalAngleFunc = UVFunc { u: Double, v: Double -> u }
        val polarAngleFunc = UVFunc { u: Double, v: Double -> v }

        val xFunc = ValueFunc { r: Double, theta: Double, phi: Double -> r * Math.sin(theta) * Math.cos(phi) }
        val yFunc = ValueFunc { r: Double, theta: Double, phi: Double -> r * Math.cos(theta) }
        val zFunc = ValueFunc { r: Double, theta: Double, phi: Double -> r * Math.sin(theta) * Math.sin(phi) }

        val ds = CustomSurfaceDataSeries3D(
            Double::class.java, Double::class.java, Double::class.java,
            30, 30,
            radialDistanceFunc, azimuthalAngleFunc, polarAngleFunc,
            xFunc, yFunc, zFunc,
            0.0, Math.PI * 2, 0.0, Math.PI
        )
        // </CreateSimpleSphere>
    }

    fun createSimpleCylinder() {
        // <CreateSimpleCylinder>
        val radialDistanceFunc = UVFunc { u: Double, v: Double -> 0.0 }
        val azimuthalAngleFunc = UVFunc { u: Double, v: Double -> u }
        val polarAngleFunc = UVFunc { u: Double, v: Double -> v }

        val xFunc = ValueFunc { r: Double, theta: Double, phi: Double -> 10 * Math.sin(Math.PI / 2) * Math.cos(phi) }
        val yFunc = ValueFunc { r: Double, theta: Double, phi: Double -> 40 * Math.cos(theta) }
        val zFunc = ValueFunc { r: Double, theta: Double, phi: Double -> 10 * Math.sin(Math.PI / 2) * Math.sin(phi) }

        val ds = CustomSurfaceDataSeries3D(
            Double::class.java, Double::class.java, Double::class.java,
            30, 30,
            radialDistanceFunc, azimuthalAngleFunc, polarAngleFunc,
            xFunc, yFunc, zFunc,
            0.0, Math.PI * 2, 0.0, Math.PI
        )
        // </CreateSimpleCylinder>
    }
}
