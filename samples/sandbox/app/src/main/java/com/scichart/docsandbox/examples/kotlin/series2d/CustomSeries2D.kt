package com.scichart.docsandbox.examples.kotlin.series2d

import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.renderableSeries.FastColumnRenderableSeries
import com.scichart.charting.visuals.renderableSeries.data.ColumnRenderPassData
import com.scichart.charting.visuals.renderableSeries.data.ISeriesRenderPassData
import com.scichart.charting.visuals.renderableSeries.hitTest.ColumnHitProvider
import com.scichart.charting.visuals.renderableSeries.hitTest.NearestColumnPointProvider
import com.scichart.core.model.FloatValues
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment
import com.scichart.drawing.common.IAssetManager2D
import com.scichart.drawing.common.IRenderContext2D

@ExampleDefinition()
class CustomSeries2D : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {}

    // <CreateCustomSeries>
    class RoundedColumnsRenderableSeries : FastColumnRenderableSeries(ColumnRenderPassData(), ColumnHitProvider(), NearestColumnPointProvider()) {
        private val topEllipseBuffer = FloatValues()
        private val rectsBuffer = FloatValues()
        private val bottomEllipseBuffer = FloatValues()

        override fun disposeCachedData() {
            super.disposeCachedData()

            topEllipseBuffer.disposeItems()
            rectsBuffer.disposeItems()
            bottomEllipseBuffer.disposeItems()
        }

        override fun internalDraw(renderContext: IRenderContext2D, assetManager: IAssetManager2D, renderPassData: ISeriesRenderPassData) {
            // Don't draw transparent series
            if (opacity == 0f) return

            val fillBrush = fillBrushStyle
            if (fillBrush == null || !fillBrush.isVisible) return

            val rpd = renderPassData as ColumnRenderPassData
            val diameter = rpd.columnPixelWidth
            updateDrawingBuffers(rpd, diameter, rpd.zeroLineCoord)

            val brush = assetManager.createBrush(fillBrush)
            renderContext.fillRects(rectsBuffer.itemsArray, 0, rectsBuffer.size(), brush)
            renderContext.drawEllipses(topEllipseBuffer.itemsArray, 0, topEllipseBuffer.size(), diameter, diameter, brush)
            renderContext.drawEllipses(bottomEllipseBuffer.itemsArray, 0, bottomEllipseBuffer.size(), diameter, diameter, brush)
        }

        private fun updateDrawingBuffers(renderPassData: ColumnRenderPassData, columnPixelWidth: Float, zeroLine: Float) {
            val halfWidth = columnPixelWidth / 2

            topEllipseBuffer.setSize(renderPassData.pointsCount() * 2)
            rectsBuffer.setSize(renderPassData.pointsCount() * 4)
            bottomEllipseBuffer.setSize(renderPassData.pointsCount() * 2)

            val topArray = topEllipseBuffer.itemsArray
            val rectsArray = rectsBuffer.itemsArray
            val bottomArray = bottomEllipseBuffer.itemsArray

            val xCoordsArray = renderPassData.xCoords.itemsArray
            val yCoordsArray = renderPassData.yCoords.itemsArray
            for (i in 0 until renderPassData.pointsCount()) {
                val x = xCoordsArray[i]
                val y = yCoordsArray[i]

                topArray[i * 2] = x
                topArray[i * 2 + 1] = y - halfWidth

                rectsArray[i * 4] = x - halfWidth
                rectsArray[i * 4 + 1] = y - halfWidth
                rectsArray[i * 4 + 2] = x + halfWidth
                rectsArray[i * 4 + 3] = zeroLine + halfWidth

                bottomArray[i * 2] = x
                bottomArray[i * 2 + 1] = zeroLine + halfWidth
            }
        }
    }
    // </CreateCustomSeries>
}
