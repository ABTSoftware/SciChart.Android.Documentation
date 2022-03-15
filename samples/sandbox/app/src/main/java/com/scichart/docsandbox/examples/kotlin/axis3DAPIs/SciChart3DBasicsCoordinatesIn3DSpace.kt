package com.scichart.docsandbox.examples.kotlin.axis3DAPIs

import com.scichart.charting3d.visuals.SciChartSurface3D
import com.scichart.charting3d.visuals.axes.NumericAxis3D
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart3DFragment

@ExampleDefinition()
class SciChart3DBasicsCoordinatesIn3DSpace : SingleChart3DFragment() {
    override fun initExample(surface: SciChartSurface3D) {}

    fun setIsLeftHandedCoordinateSystem(surface: SciChartSurface3D) {
        // <SetIsLeftHandedCoordinateSystem>
        surface.viewport3D.isLeftHandedCoordinateSystem = false
        // </SetIsLeftHandedCoordinateSystem>
    }

    fun setWorldCoordinates(surface: SciChartSurface3D) {
        // <SetWorldCoordinates>
        surface.worldDimensions.assign(200f, 200f, 200f)
        // </SetWorldCoordinates>
    }

    fun convertingFromWorldToDataCoordinates() {
        // <ConvertingFromWorldToDataCoordinates>
        val xAxis = NumericAxis3D()
        val calculator = xAxis.currentCoordinateCalculator
        val coordinate = calculator.getCoordinate(1.2)

        // Convert back:
        val dataValue = calculator.getDataValue(coordinate)
        // </ConvertingFromWorldToDataCoordinates>
    }
}