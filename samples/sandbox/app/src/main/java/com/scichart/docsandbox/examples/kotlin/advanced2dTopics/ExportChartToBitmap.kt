package com.scichart.docsandbox.examples.kotlin.advanced2dTopics

import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.rendering.SciChartSurfaceExportUtil
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment
import com.scichart.drawing.canvas.RenderSurface

@ExampleDefinition
class ExportChartToBitmap : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {}

    fun exportToBitmap(surface: SciChartSurface) {
        // <ExportToBitmap>
        // Assume a surface has been created and configured somewhere
        val screenshot = surface.exportToBitmap()
        // </ExportToBitmap>
    }

    fun exportToBitmapInMemoryAtSize() {
        // <ExportToBitmapInMemoryAtSize>
        // create new SciChartSurface
        val sciChartSurface = SciChartSurface(activity)

        // init it with axes, series etc
        initSurface(sciChartSurface)

        // prepare it for export at specified size
        SciChartSurfaceExportUtil.prepareSurfaceForExport(sciChartSurface, 800, 600)

        // export it to Bitmap
        val screenshot = sciChartSurface.exportToBitmap()
        // </ExportToBitmapInMemoryAtSize>
    }

    fun setRenderSurface(surface: SciChartSurface) {
        // <SetRenderSurface>
        // Assume a surface has been created and configured somewhere
        surface.renderSurface = RenderSurface(context)
        // </SetRenderSurface>
    }

    private fun initSurface(surface: SciChartSurface) {}
}