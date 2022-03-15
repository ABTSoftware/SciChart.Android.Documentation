package com.scichart.docsandbox.examples.kotlin.axisAPIs

import com.scichart.charting.layoutManagers.ChartLayoutState
import com.scichart.charting.layoutManagers.DefaultLayoutManager
import com.scichart.charting.layoutManagers.VerticalAxisLayoutStrategy
import com.scichart.charting.visuals.SciChartSurface
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment

@ExampleDefinition()
class AxisLayoutStackAxesVerticallyOrHorizontally : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {}

    fun createLeftAlignedOuterVerticallyStackedYAxisLayoutStrategy(surface: SciChartSurface) {
        // <CreateLeftAlignedOuterVerticallyStackedYAxisLayoutStrategy>
        class LeftAlignedOuterVerticallyStackedYAxisLayoutStrategy :
            VerticalAxisLayoutStrategy() {
            override fun measureAxes(
                availableWidth: Int,
                availableHeight: Int,
                chartLayoutState: ChartLayoutState
            ) {
                var i = 0
                val size = axes.size
                while (i < size) {
                    val axis = axes[i]
                    axis.updateAxisMeasurements()
                    val axisLayoutState = axis.axisLayoutState
                    chartLayoutState.leftOuterAreaSize = Math.max(
                        getRequiredAxisSize(axisLayoutState),
                        chartLayoutState.leftOuterAreaSize
                    )
                    i++
                }
            }

            override fun layoutAxes(left: Int, top: Int, right: Int, bottom: Int) {
                val size = axes.size
                val height = bottom - top
                val axisSize = height / size
                var topPlacement = top
                for (i in 0 until size) {
                    val axis = axes[i]
                    val axisLayoutState = axis.axisLayoutState
                    val bottomPlacement = topPlacement + axisSize
                    axis.layoutArea(
                        right - getRequiredAxisSize(axisLayoutState),
                        topPlacement,
                        right,
                        bottomPlacement
                    )
                    topPlacement = bottomPlacement
                }
            }
        }
        // </CreateLeftAlignedOuterVerticallyStackedYAxisLayoutStrategy>

        // <UseLeftAlignedOuterVerticallyStackedYAxisLayoutStrategy>
        // Create and set new Layout Strategy
        val layoutManager = DefaultLayoutManager.Builder()
            .setLeftOuterAxesLayoutStrategy(LeftAlignedOuterVerticallyStackedYAxisLayoutStrategy())
            .build()
        surface.layoutManager = layoutManager
        // </UseLeftAlignedOuterVerticallyStackedYAxisLayoutStrategy>
    }
}
