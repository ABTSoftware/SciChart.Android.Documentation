package com.scichart.docsandbox.examples.kotlin.chartModifier2D

import android.graphics.PointF
import android.view.MotionEvent
import android.view.ViewConfiguration
import com.scichart.charting.modifiers.GestureModifierBase
import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.axes.IAxis
import com.scichart.core.IServiceContainer
import com.scichart.core.utility.touch.ModifierTouchEventArgs
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment
import kotlin.math.abs

@ExampleDefinition()
class CustomModifiersTheGestureModifierBaseAPI : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {}

    fun createCustomZoomGestureModifier(surface: SciChartSurface) {
        // <CreateCustomZoomGestureModifier>
        class CustomZoomGestureModifier : GestureModifierBase() {
            private var isScrolling = false
            private var isZoomEnabled = false

            private var touchSlop = 0f
            private val start = PointF()
            private var lastY = 0f

            override fun attachTo(services: IServiceContainer) {
                super.attachTo(services)

                val context = context ?: return
                touchSlop = (ViewConfiguration.get(context).scaledTouchSlop * 2).toFloat()
            }

            // These methods fire on each gesture event
            override fun onDoubleTap(e: MotionEvent): Boolean {
                start.set(e.x, e.y)
                lastY = e.y
                isZoomEnabled = true

                return true
            }

            override fun onTouch(args: ModifierTouchEventArgs) {
                super.onTouch(args)

                val motionEvent = args.e
                if (isZoomEnabled && motionEvent.action == MotionEvent.ACTION_MOVE) {
                    onScrollInYDirection(motionEvent.y)
                }
            }

            // Here, we put all our logic of calculation zoom in and out
            private fun onScrollInYDirection(y: Float) {
                val distance = abs(y - start.y)
                if (distance < touchSlop || abs(y - lastY) < 1f) return

                isScrolling = true

                val prevDistance = abs(lastY - start.y)
                val diff = if (prevDistance > 0) (distance / prevDistance - 1).toDouble() else 0.toDouble()
                growBy(start, xAxis, diff)

                lastY = y
            }

            // zoom axis relative to the start point using fraction
            private fun growBy(point: PointF, axis: IAxis, fraction: Double) {
                val size = axis.axisViewportDimension
                val coord = size - point.y

                val minFraction = coord / size * fraction
                val maxFraction = (1 - coord / size) * fraction

                axis.zoomBy(minFraction, maxFraction)
            }

            override fun onUp(e: MotionEvent) {
                // need to disable zoom after finishing scrolling
                if (isScrolling) {
                    isZoomEnabled = false
                    isScrolling = isZoomEnabled
                    start[Float.NaN] = Float.NaN
                    lastY = Float.NaN
                }
            }
        }
        // </CreateCustomZoomGestureModifier>
    }
}

