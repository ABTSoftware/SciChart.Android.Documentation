package com.scichart.docsandbox.examples.kotlin.axis3DAPIs

import com.scichart.charting3d.visuals.SciChartSurface3D
import com.scichart.charting3d.visuals.axes.AxisPlaneDrawLabelsMode
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart3DFragment

@ExampleDefinition()
class Axis3DLabelsLabelsConfiguration : SingleChart3DFragment() {
    override fun initExample(surface: SciChartSurface3D) {}

    fun axisCubeLabelsConfiguration(surface: SciChartSurface3D) {
        // <AxisCubeLabelsConfiguration>
        surface.xyAxisPlaneDrawLabelsMode = AxisPlaneDrawLabelsMode.AxisPlaneDrawLabelsBoth
        surface.zyAxisPlaneDrawLabelsMode = AxisPlaneDrawLabelsMode.AxisPlaneDrawLabelsLocalX
        surface.zxAxisPlaneDrawLabelsMode = AxisPlaneDrawLabelsMode.AxisPlaneDrawLabelsHidden
        // </AxisCubeLabelsConfiguration>
    }
}
