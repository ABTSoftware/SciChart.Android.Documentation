package com.scichart.docsandbox.examples.kotlin.advanced2dTopics

import com.scichart.charting.viewportManagers.DefaultViewportManager
import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.axes.IAxisCore
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment

@ExampleDefinition
class ViewportManager : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {}

    fun setViewportManager(surface: SciChartSurface) {
        // <SetViewportManager>
        // Assume a surface has been created and configured somewhere
        surface.viewportManager = DefaultViewportManager()
        // </SetViewportManager>
    }

    fun createCustomViewportManager() {
        // <CreateCustomViewportManager>
        class CustomViewportManager : DefaultViewportManager() {
            override fun onUpdateXAxis(xAxis: IAxisCore) {
                super.onUpdateXAxis(xAxis)
                // called before drawing of xAxis
                // here you can update visible range
                val visibleRange = xAxis.visibleRange
            }

            override fun onUpdateYAxis(yAxis: IAxisCore) {
                super.onUpdateYAxis(yAxis)
                // called before drawing of yAxis
                // here you can update visible range
                val visibleRange = yAxis.visibleRange
            }

            override fun onApplyAutoRange(axis: IAxisCore) {
                super.onApplyAutoRange(axis)
                // called when axis uses AutoRange.Always or AutoRange.Once
                // here you can update visible range when need to perform auto range
                val visibleRange = axis.visibleRange
            }
        }
        // </CreateCustomViewportManager>
    }
}
