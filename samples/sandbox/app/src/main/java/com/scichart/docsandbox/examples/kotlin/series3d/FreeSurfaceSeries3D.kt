package com.scichart.docsandbox.examples.kotlin.series3d

import com.scichart.charting3d.common.math.Vector3
import com.scichart.charting3d.visuals.SciChartSurface3D
import com.scichart.charting3d.visuals.renderableSeries.data.GradientColorPalette
import com.scichart.charting3d.visuals.renderableSeries.freeSurface.FreeSurfacePaletteMinMaxMode
import com.scichart.charting3d.visuals.renderableSeries.freeSurface.FreeSurfaceRenderableSeries3D
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart3DFragment

@ExampleDefinition()
class FreeSurfaceSeries3D : SingleChart3DFragment() {
    override fun initExample(surface: SciChartSurface3D) {
        createAxialPaletteComponent()
    }

    fun createAxialPaletteComponent() {
        // <CreateAxialPaletteComponent>
        val colors =
            intArrayOf(0xFF00008B.toInt(), 0xFF0000FF.toInt(), 0xFF00FFFF.toInt(), 0xFFADFF2F.toInt(), 0xFFFFFF00.toInt(), 0xFFFF0000.toInt(), 0xFF8B0000.toInt())
        val stops = floatArrayOf(0f, .1f, .3f, .5f, .7f, .9f, 1f)
        val palette = GradientColorPalette(colors, stops)

        val rs = FreeSurfaceRenderableSeries3D()
        rs.meshColorPalette = palette
        rs.paletteMinMaxMode = FreeSurfacePaletteMinMaxMode.Absolute
        rs.paletteMinimum = Vector3(0f, -4f, 0f)
        rs.paletteMaximum = Vector3(0f, 4f, 0f)
        rs.paletteAxialFactor = Vector3(0f, 1f, 0f)
        // </CreateAxialPaletteComponent>
    }

    fun createRadialPaletteComponent() {
        // <CreateRadialPaletteComponent>
        val colors =
            intArrayOf(0xFF00008B.toInt(), 0xFF0000FF.toInt(), 0xFF00FFFF.toInt(), 0xFFADFF2F.toInt(), 0xFFFFFF00.toInt(), 0xFFFF0000.toInt(), 0xFF8B0000.toInt())
        val stops = floatArrayOf(0f, .1f, .3f, .5f, .7f, .9f, 1f)
        val palette = GradientColorPalette(colors, stops)

        val rs = FreeSurfaceRenderableSeries3D()
        rs.meshColorPalette = palette
        rs.paletteMinMaxMode = FreeSurfacePaletteMinMaxMode.Relative
        rs.paletteMinimum = Vector3(0f, 6f, 0f)
        rs.paletteMaximum = Vector3(0f, 7f, 0f)
        rs.paletteRadialFactor = 1f
        // </CreateRadialPaletteComponent>
    }

    fun createAzimuthalPaletteComponent() {
        // <CreateAzimuthalPaletteComponent>
        val colors =
            intArrayOf(0xFF00008B.toInt(), 0xFF0000FF.toInt(), 0xFF00FFFF.toInt(), 0xFFADFF2F.toInt(), 0xFFFFFF00.toInt(), 0xFFFF0000.toInt(), 0xFF8B0000.toInt())
        val stops = floatArrayOf(0f, .1f, .3f, .5f, .7f, .9f, 1f)
        val palette = GradientColorPalette(colors, stops)

        val rs = FreeSurfaceRenderableSeries3D()
        rs.meshColorPalette = palette
        rs.paletteMinMaxMode = FreeSurfacePaletteMinMaxMode.Relative
        rs.paletteMinimum = Vector3(0f, 6f, 0f)
        rs.paletteMaximum = Vector3(0f, 7f, 0f)
        rs.paletteAzimuthalFactor = 1f
        // </CreateAzimuthalPaletteComponent>
    }

    fun createPolarPaletteComponent() {
        // <CreatePolarPaletteComponent>
        val colors =
            intArrayOf(0xFF00008B.toInt(), 0xFF0000FF.toInt(), 0xFF00FFFF.toInt(), 0xFFADFF2F.toInt(), 0xFFFFFF00.toInt(), 0xFFFF0000.toInt(), 0xFF8B0000.toInt())
        val stops = floatArrayOf(0f, .1f, .3f, .5f, .7f, .9f, 1f)
        val palette = GradientColorPalette(colors, stops)

        val rs = FreeSurfaceRenderableSeries3D()
        rs.meshColorPalette = palette
        rs.paletteMinMaxMode = FreeSurfacePaletteMinMaxMode.Relative
        rs.paletteMinimum = Vector3(0f, 6f, 0f)
        rs.paletteMaximum = Vector3(0f, 7f, 0f)
        rs.palettePolarFactor = 1f
        // </CreatePolarPaletteComponent>
    }
}
