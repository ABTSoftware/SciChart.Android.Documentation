package com.scichart.docsandbox.examples.kotlin.series2d

import android.graphics.PointF
import android.view.MotionEvent
import android.view.View
import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.renderableSeries.hitTest.HitTestInfo
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment

@ExampleDefinition()
class HitTestAPI : SingleChart2DFragment() {
    private val touchPoint = PointF()
    private val hitTestInfo = HitTestInfo()
    
    override fun initExample(surface: SciChartSurface) {}

    // <PerformHitTest>
    fun onTouch(v: View, event: MotionEvent): Boolean {
        val surface = v as SciChartSurface

        // The touch point relative to the ChartSurface
        touchPoint.set(event.x, event.y)
        // Translate the touch point relative to RenderableSeriesArea (or ModifierSurface)
        surface.translatePoint(touchPoint, surface.renderableSeriesArea)
        for (renderableSeries in surface.renderableSeries) {
            // Perform `Hit-Test` which will be stored in the `_hitTestInfo`
            renderableSeries.hitTest(hitTestInfo, touchPoint.x, touchPoint.y)
        }
        return true
    }
    // </PerformHitTest>
}
