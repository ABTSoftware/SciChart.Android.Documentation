package com.scichart.docsandbox.examples.kotlin.axisAPIs

import com.scichart.charting.layoutManagers.ChartLayoutState
import com.scichart.charting.layoutManagers.DefaultLayoutManager
import com.scichart.charting.layoutManagers.TopAlignmentInnerAxisLayoutStrategy
import com.scichart.charting.layoutManagers.TopAlignmentOuterAxisLayoutStrategy
import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.axes.AxisAlignment
import com.scichart.charting.visuals.axes.IAxis
import com.scichart.charting.visuals.axes.NumericAxis
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment

@ExampleDefinition()
class AxisLayoutCentralAxis : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {}

    fun createCenteredAxisLayoutStrategy(surface: SciChartSurface) {
        // <CreateCenteredAxisLayoutStrategy>
        class CenteredAxisLayoutStrategy : TopAlignmentInnerAxisLayoutStrategy() {
            private var chartAreaWidth = 0
            private var chartAreaHeight = 0
            override fun measureAxes(
                availableWidth: Int,
                availableHeight: Int,
                chartLayoutState: ChartLayoutState
            ) {
                super.measureAxes(availableWidth, availableHeight, chartLayoutState)
                chartAreaWidth = availableWidth
                chartAreaHeight = availableHeight
            }

            override fun layoutAxes(left: Int, top: Int, right: Int, bottom: Int) {

                // pin the stack of the top-aligned X Axes to the center of a chart
                val topCoord = chartAreaHeight / 2
                layoutFromTopToBottom(left, topCoord, right, axes)
            }
        }
        // </CreateCenteredAxisLayoutStrategy>

        // <UseCenteredAxisLayoutStrategy>
        val xAxis = NumericAxis(context)
        // Set place axis appropriately for "Top-Inner" Axis Strategy
        xAxis.setIsCenterAxis(true)
        xAxis.axisAlignment = AxisAlignment.Top

        // Create and set new Layout Strategy
        val layoutManager = DefaultLayoutManager.Builder()
            .setTopInnerAxesLayoutStrategy(CenteredAxisLayoutStrategy())
            .build()
        surface.layoutManager = layoutManager
        // </UseCenteredAxisLayoutStrategy>
    }

    fun createCenteredTopAlignmentInnerAxisLayoutStrategy() {
        // <CreateCenteredTopAlignmentInnerAxisLayoutStrategy>
        class CenteredTopAlignmentAxisLayoutStrategy private constructor(private val yAxis: IAxis) :
            TopAlignmentOuterAxisLayoutStrategy() {
            override fun layoutAxes(left: Int, top: Int, right: Int, bottom: Int) {

                // find the coordinate of 0 on the Y Axis in pixels
                // place the stack of the top-aligned X Axes at this coordinate
                val topCoord = yAxis.currentCoordinateCalculator.getCoordinate(0.0)
                layoutFromTopToBottom(left, topCoord.toInt(), right, axes)
            }
        }
        // </CreateCenteredTopAlignmentInnerAxisLayoutStrategy>
    }
}
