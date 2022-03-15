package com.scichart.docsandbox.examples.kotlin.series2d

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.core.content.res.ResourcesCompat
import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.pointmarkers.DrawablePointMarker
import com.scichart.charting.visuals.pointmarkers.EllipsePointMarker
import com.scichart.charting.visuals.pointmarkers.IPointMarker
import com.scichart.charting.visuals.pointmarkers.SpritePointMarker
import com.scichart.charting.visuals.pointmarkers.SpritePointMarker.ISpritePointMarkerDrawer
import com.scichart.charting.visuals.renderableSeries.FastLineRenderableSeries
import com.scichart.docsandbox.R
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment
import com.scichart.drawing.common.*

@ExampleDefinition()
class PointMarkerAPI : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {

    }

    fun createPointMarker() {
        // <CreatePointMarker>
        // Create an Ellipse PointMarker instance
        val pointMarker = EllipsePointMarker()
        pointMarker.setSize(40, 40)
        pointMarker.strokeStyle = SolidPenStyle(Color.GREEN, false, 2.0f, null)
        pointMarker.fillStyle = SolidBrushStyle(Color.RED)

        // Apply the PointMarker to a LineSeries
        val lineSeries = FastLineRenderableSeries()
        lineSeries.pointMarker = pointMarker
        // </CreatePointMarker>
    }

    fun extendDrawablePointMarker() {
        // <ExtendDrawablePointMarker>
        class EllipsePointMarker : DrawablePointMarker() {
            override fun internalDraw(renderContext: IRenderContext2D, x: Float, y: Float, strokePen: IPen2D, fillBrush: IBrush2D) {
                renderContext.drawEllipse(x, y, width.toFloat(), height.toFloat(), strokePen, fillBrush)
            }
        }
        // </ExtendDrawablePointMarker>
    }

    fun createCustomPointMarkerDrawer() {
        // <CreateCustomPointMarkerDrawer>
        class CustomPointMarkerDrawer(context: Context, @DrawableRes drawableId: Int) :
            ISpritePointMarkerDrawer {
            private val drawable: Drawable? = ResourcesCompat.getDrawable(context.resources, drawableId, null)

            override fun onDraw(canvas: Canvas, stroke: Paint, fill: Paint) {
                drawable!!.setBounds(0, 0, canvas.width, canvas.height)
                drawable.draw(canvas)
            }
        }
        // </CreateCustomPointMarkerDrawer>

        // <UseCustomPointMarkerDrawer>
        val pointMarker: IPointMarker = SpritePointMarker(
            CustomPointMarkerDrawer(requireContext(), R.drawable.example_weather_storm)
        )
        pointMarker.setSize(40, 40)

        // Apply the PointMarker to a LineSeries
        val lineSeries = FastLineRenderableSeries()
        lineSeries.pointMarker = pointMarker
        // </UseCustomPointMarkerDrawer>
    }
}
