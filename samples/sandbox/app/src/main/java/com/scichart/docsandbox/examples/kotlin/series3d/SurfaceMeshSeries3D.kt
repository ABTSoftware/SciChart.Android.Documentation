package com.scichart.docsandbox.examples.kotlin.series3d

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.scichart.charting3d.model.dataSeries.grid.UniformGridDataSeries3D
import com.scichart.charting3d.visuals.SciChartSurface3D
import com.scichart.charting3d.visuals.axes.NumericAxis3D
import com.scichart.charting3d.visuals.pointMarkers.CustomPointMarker3D
import com.scichart.charting3d.visuals.renderableSeries.data.*
import com.scichart.charting3d.visuals.renderableSeries.metadataProviders.ISurfaceMeshMetadataProvider3D
import com.scichart.charting3d.visuals.renderableSeries.metadataProviders.MetadataProvider3DBase
import com.scichart.charting3d.visuals.renderableSeries.surfaceMesh.SurfaceMeshRenderPassData3D
import com.scichart.charting3d.visuals.renderableSeries.surfaceMesh.SurfaceMeshRenderableSeries3D
import com.scichart.charting3d.visuals.rendering.Texture2D
import com.scichart.core.common.Size
import com.scichart.core.framework.UpdateSuspender
import com.scichart.core.model.IntegerValues
import com.scichart.data.model.DoubleRange
import com.scichart.docsandbox.R
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.DataManager
import com.scichart.docsandbox.examples.base.SingleChart3DFragment
import com.scichart.drawing.common.TextureBrushStyle
import kotlin.math.sin

@ExampleDefinition()
class SurfaceMeshSeries3D : SingleChart3DFragment() {
    private val COUNT = 25
    private val dataManager = DataManager()
    
    override fun initExample(surface: SciChartSurface3D) {
        surfaceMeshSeries3D(surface)
    }

    fun surfaceMeshSeries3D(surface: SciChartSurface3D) {
        // <CreateSurfaceMeshSeries3D>
        val xAxis = NumericAxis3D()
        xAxis.growBy = DoubleRange(.1, .1)

        val yAxis = NumericAxis3D()
        yAxis.setVisibleRange(DoubleRange(0.0, .3))
        yAxis.growBy = DoubleRange(.1, .1)

        val zAxis = NumericAxis3D()
        zAxis.growBy = DoubleRange(.1, .1)
        
        val ds = UniformGridDataSeries3D(Double::class.java, Double::class.java, Double::class.java, COUNT, COUNT
        )
        for (x in 0 until COUNT) {
            for (z in 0 until COUNT) {
                val xVal = (25 * x / COUNT).toDouble()
                val zVal = (25 * z / COUNT).toDouble()
                val y = sin(xVal * 0.2) / ((zVal + 1.0) * 2.0)
                ds.updateYAt(x, z, y)
            }
        }
        val colors = intArrayOf(0xFF00008B.toInt(), 0xFF0000FF.toInt(), 0xFF00FFFF.toInt(), 0xFFADFF2F.toInt(), 0xFFFFFF00.toInt(), 0xFFFF0000.toInt(), 0xFF8B0000.toInt())
        val stops = floatArrayOf(0f, .1f, .3f, .5f, .7f, .9f, 1f)
        val palette = GradientColorPalette(colors, stops)

        val rs = SurfaceMeshRenderableSeries3D()
        rs.dataSeries = ds
        rs.drawMeshAs = DrawMeshAs.SolidWireframe
        rs.stroke = 0x77228B22
        rs.contourStroke = 0x77228B22
        rs.strokeThickness = convertValueToDp(2f)
        rs.drawSkirt = false
        rs.meshColorPalette = palette

        UpdateSuspender.using(surface) {
            surface.xAxis = xAxis
            surface.yAxis = yAxis
            surface.zAxis = zAxis
            surface.renderableSeries.add(rs)
            surface.chartModifiers.add(createDefaultModifiers3D())
        }
        // </CreateSurfaceMeshSeries3D>
    }

    fun createSolidColorPalette() {
        // <CreateSolidColorPalette>
        val rSeries = SurfaceMeshRenderableSeries3D()
        rSeries.meshColorPalette = SolidColorBrushPalette(-0xff9c00)
        // </CreateSolidColorPalette>
    }

    fun createGradientColorPalette() {
        // <CreateGradientColorPalette>
        val colors = intArrayOf(0xFF00008B.toInt(), 0xFF0000FF.toInt(), 0xFF00FFFF.toInt(), 0xFFADFF2F.toInt(), 0xFFFFFF00.toInt(), 0xFFFF0000.toInt(), 0xFF8B0000.toInt())
        val stops = floatArrayOf(0f, .1f, .3f, .5f, .7f, .9f, 1f)
        val palette = GradientColorPalette(colors, stops)
        // </CreateGradientColorPalette>
    }

    fun setIsStepped() {
        val colors = intArrayOf(0xFF00008B.toInt(), 0xFF0000FF.toInt(), 0xFF00FFFF.toInt(), 0xFFADFF2F.toInt(), 0xFFFFFF00.toInt(), 0xFFFF0000.toInt(), 0xFF8B0000.toInt())
        val stops = floatArrayOf(0f, .1f, .3f, .5f, .7f, .9f, 1f)

        // <SetIsStepped>
        val palette = GradientColorPalette(colors, stops, true)
        // </SetIsStepped>
    }

    fun setBrushColorPalette() {
        // <SetBrushColorPalette>
        val bitmap = BitmapFactory.decodeResource(requireContext().resources, R.drawable.example_weather_storm)
        val pointMarker = CustomPointMarker3D(bitmap)
        pointMarker.size = 10f

        val brushStyle = TextureBrushStyle(bitmap)
        val palette = BrushColorPalette(brushStyle)

        val rSeries = SurfaceMeshRenderableSeries3D()
        rSeries.meshColorPalette = palette
        rSeries.meshPaletteMode = MeshPaletteMode.Textured
        rSeries.meshColorPaletteSize = Size(bitmap.width, bitmap.height)
        // </SetBrushColorPalette>
    }

    fun setCustomPalette() {
        // <SetCustomPalette>
        class CustomPalette : MeshColorPalette() {
            override fun getTexture(width: Int, height: Int): Texture2D {
                val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
                return try {
                    Texture2D.fromBitmap(bitmap)
                } finally {
                    bitmap.recycle()
                }
            }
        }
        // </SetCustomPalette>
    }

    fun createSurfaceMeshMetaDataProvider3D() {
        // <CreateSurfaceMeshMetaDataProvider3D>
        class SurfaceMeshMetadataProvider3D :
            MetadataProvider3DBase<SurfaceMeshRenderableSeries3D>(SurfaceMeshRenderableSeries3D::class.java),
            ISurfaceMeshMetadataProvider3D {
            override fun updateMeshColors(cellColors: IntegerValues) {
                val currentRenderPassData =
                    renderableSeries!!.currentRenderPassData as SurfaceMeshRenderPassData3D
                val countX = currentRenderPassData.countX - 1
                val countZ = currentRenderPassData.countZ - 1
                cellColors.setSize(currentRenderPassData.pointsCount)
                val items = cellColors.itemsArray
                for (x in 0 until countX) {
                    for (z in 0 until countZ) {
                        val index = x * countZ + z
                        val color: Int
                        color =
                            if (x >= 20 && x <= 26 && z > 0 && z < 47 || z >= 20 && z <= 26 && x > 0 && x < 47) {
                                TRANSPARENT
                            } else {
                                dataManager.getRandomColor()
                            }
                        items[index] = color
                    }
                }
            }
        }
        // </CreateSurfaceMeshMetaDataProvider3D>
    }
}
