package com.scichart.docsandbox.examples.kotlin.chartModifier2D

import com.scichart.charting.model.AxisCollection
import com.scichart.charting.modifiers.ChartModifierBase
import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.axes.AxisAlignment
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment

@ExampleDefinition()
class CustomModifiersTheChartModifierBaseAPI : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {}

    fun createCustomRotateChartModifier(surface: SciChartSurface) {
        // <CreateCustomRotateChartModifier>
        class CustomRotateChartModifier : ChartModifierBase() {
            fun rotateChart() {
                if (isAttached) {
                    val parentSurface = parentSurface
                    val updateSuspender = parentSurface.suspendUpdates()
                    try {
                        rotateAxes(parentSurface.xAxes)
                        rotateAxes(parentSurface.yAxes)
                    } finally {
                        updateSuspender.dispose()
                    }
                }
            }

            private fun rotateAxes(axes: AxisCollection) {
                var i = 0
                val size = axes.size
                while (i < size) {
                    val axis = axes[i]
                    val axisAlignment = axis.axisAlignment
                    when (axisAlignment) {
                        AxisAlignment.Right -> axis.axisAlignment = AxisAlignment.Bottom
                        AxisAlignment.Left -> axis.axisAlignment = AxisAlignment.Top
                        AxisAlignment.Top -> axis.axisAlignment = AxisAlignment.Right
                        AxisAlignment.Bottom -> axis.axisAlignment = AxisAlignment.Left
                        AxisAlignment.Auto -> if (axis.isXAxis) {
                            // Bottom
                            axis.axisAlignment = AxisAlignment.Left
                        } else {
                            // Right
                            axis.axisAlignment = AxisAlignment.Bottom
                        }
                    }
                    i++
                }
            }
        }
        // </CreateCustomRotateChartModifier>
    }
}

