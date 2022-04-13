package com.scichart.docsandbox.examples.kotlin.advanced2dTopics

import android.content.Context
import android.util.AttributeSet
import com.scichart.charting.visuals.SciChartSurface
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment
import com.scichart.drawing.canvas.RenderSurface
import com.scichart.drawing.common.IRenderSurface
import com.scichart.drawing.opengl.RenderSurfaceGL

@ExampleDefinition
class RendererPlugins : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {}

    fun setRenderSurface(surface: SciChartSurface) {
        // <SetRenderSurface>
        // Assume a surface has been created and configured somewhere
        surface.renderSurface = RenderSurfaceGL(context)
        // </SetRenderSurface>
    }

    fun createCanvasSciChartSurface() {
        // <CreateCanvasSciChartSurface>
        class CanvasSciChartSurface : SciChartSurface {
            constructor(context: Context?) : super(context) {}
            constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {}
            constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
                context,
                attrs,
                defStyleAttr
            ) {
            }

            override fun getDefaultRenderSurface(context: Context): IRenderSurface {
                return RenderSurface(context) // return Canvas based IRenderSurface
            }
        }
        // </CreateCanvasSciChartSurface>
    }
}