package com.scichart.docsandbox.examples.kotlin.axisAPIs

import com.scichart.charting.numerics.tickCoordinatesProviders.DefaultTickCoordinatesProvider
import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.axes.NumericAxis
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment

@ExampleDefinition()
class AxisTicksTickCoordinatesProviderAPI : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {}

    fun createCustomTickCoordinatesProvider() {
        // <CreateCustomTickCoordinatesProvider>
        class CustomTickCoordinatesProvider : DefaultTickCoordinatesProvider() {
            override fun update() {
                super.update()
                val tickCoordinates = tickCoordinates
                // majorTickCoords contains coordinates of major ticks on screen
                val majorTickCoords = tickCoordinates.majorTickCoordinates
                // minorTickCoords contains coordinates of minor ticks on screen
                val minorTickCoords = tickCoordinates.minorTickCoordinates

                // TODO: Provide minor and major Tick Coordinates
            }
        }
        // </CreateCustomTickCoordinatesProvider>

        // <UseCustomTickCoordinatesProvider>
        val axis = NumericAxis(context)
        axis.tickCoordinatesProvider = CustomTickCoordinatesProvider()
        // </UseCustomTickCoordinatesProvider>
    }
}
