package com.scichart.docsandbox.examples.kotlin.series3d

import com.scichart.charting3d.model.dataSeries.waterfall.WaterfallDataSeries3D
import com.scichart.charting3d.visuals.SciChartSurface3D
import com.scichart.charting3d.visuals.pointMarkers.SpherePointMarker3D
import com.scichart.charting3d.visuals.renderableSeries.data.GradientColorPalette
import com.scichart.charting3d.visuals.renderableSeries.data.SolidColorBrushPalette
import com.scichart.charting3d.visuals.renderableSeries.waterfall.WaterfallRenderableSeries3D
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart3DFragment

@ExampleDefinition()
class WaterfallSeries3D : SingleChart3DFragment() {
    private val POINTS_PER_SLICE = 128
    private val SLICE_COUNT = 20

    override fun initExample(surface: SciChartSurface3D) {
        createSurfaceMeshSeries3D()
    }

    fun createSurfaceMeshSeries3D() {
        // <CreateSurfaceMeshSeries3D>
        val fillColorPalette = GradientColorPalette(
            intArrayOf(0xFFFF0000.toInt(), 0xFFFFA500.toInt(), 0xFFFFFF00.toInt(), 0xFFADFF2F.toInt(), 0xFF006400.toInt()),
            floatArrayOf(0.0f, 0.25f, 0.5f, 0.75f, 1.0f)
        )
        val strokeColorPalette = GradientColorPalette(
            intArrayOf(0xFFDC143C.toInt(), 0xFFFF8C00.toInt(), 0xFF32CD32.toInt(), 0xFF32CD32.toInt()),
            floatArrayOf(0.0f, 0.33f, 0.67f, 1.0f)
        )
        val ds = WaterfallDataSeries3D(
            Double::class.java,
            Double::class.java,
            Double::class.java, POINTS_PER_SLICE, SLICE_COUNT
        )
        ds.setStartX(10.0)
        ds.setStartZ(1.0)

        fillDataSeries(ds)

        val rSeries = WaterfallRenderableSeries3D()
        rSeries.dataSeries = ds
        rSeries.stroke = -0xffff01
        rSeries.strokeThickness = convertValueToDp(1.0f)
        rSeries.sliceThickness = 0.0f
        rSeries.yColorMapping = fillColorPalette
        rSeries.yStrokeColorMapping = strokeColorPalette
        rSeries.opacity = 0.8f
        // </CreateSurfaceMeshSeries3D>

        // <ApplyingSolidPalettes>
        rSeries.yColorMapping = SolidColorBrushPalette(0xFF6495ED.toInt())
        rSeries.yStrokeColorMapping = SolidColorBrushPalette(0xFF6495ED.toInt())
        // </ApplyingSolidPalettes>

        // <ApplyingLinearGradientPalettes>
        val colors = intArrayOf(0xFFFF0000.toInt(), 0xFFFFA500.toInt(), 0xFFFFFF00.toInt(), 0xFFADFF2F.toInt(), 0xFF006400.toInt())
        val stops = floatArrayOf(0f, .25f, .5f, .75f, 0f)
        val colorPalette = GradientColorPalette(colors, stops)
        // </ApplyingLinearGradientPalettes>

        // <ApplyingColorPaletteOntoSliceFill>
        // Z-Direction
        rSeries.zColorMapping = colorPalette
        rSeries.zStrokeColorMapping = SolidColorBrushPalette(0x00FFFFFF)

        // or Y-Direction
        rSeries.yColorMapping = colorPalette
        rSeries.yStrokeColorMapping = SolidColorBrushPalette(0x00FFFFFF)
        // </ApplyingColorPaletteOntoSliceFill>

        // <ApplyingColorPaletteOntoSliceStroke>
        // Z-Direction
        rSeries.zColorMapping = SolidColorBrushPalette(0x00FFFFFF)
        rSeries.zStrokeColorMapping = colorPalette

        // or Y-Direction
        rSeries.yColorMapping = SolidColorBrushPalette(0x00FFFFFF)
        rSeries.yStrokeColorMapping = colorPalette
        // </ApplyingColorPaletteOntoSliceStroke>
    }

    private fun fillDataSeries(ds: WaterfallDataSeries3D<Double, Double, Double>) {}

    fun applySliceThickness() {
        // <ApplySliceThickness>
        val rSeries = WaterfallRenderableSeries3D()
        rSeries.sliceThickness = 10.0f
        // </ApplySliceThickness>
    }

    fun pointMarkersOnWaterfall3D() {
        // <PointMarkersOnWaterfall3D>
        val pointMarker = SpherePointMarker3D()
        pointMarker.fill = 0xFFFFA500.toInt()
        pointMarker.size = convertValueToDp(10.0f)

        val rSeries = WaterfallRenderableSeries3D()
        rSeries.pointMarker = pointMarker
        // </PointMarkersOnWaterfall3D>
    }
}
