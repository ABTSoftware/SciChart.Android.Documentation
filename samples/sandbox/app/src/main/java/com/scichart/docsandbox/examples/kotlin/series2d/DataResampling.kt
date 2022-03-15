package com.scichart.docsandbox.examples.kotlin.series2d

import com.scichart.charting.model.dataSeries.IXyDataSeries
import com.scichart.charting.model.dataSeries.XyDataSeries
import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.renderableSeries.FastLineRenderableSeries
import com.scichart.data.numerics.ResamplingMode
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment

@ExampleDefinition()
class DataResampling : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {
        settingResamplingMode()
    }

    fun settingResamplingMode() {
        // <SettingResamplingMode>
        // Create a DataSeries with unsorted data
        val unsortedDataSeries: IXyDataSeries<Double, Double> = XyDataSeries(Double::class.java, Double::class.java).apply {
            acceptsUnsortedData = true
        }

        val rSeries = FastLineRenderableSeries().apply {
            // Set a DataSeries with unsorted data
            dataSeries = unsortedDataSeries

            // Switch off Resampling because the DataSeries is unsorted
            resamplingMode = ResamplingMode.None
        }
        // </SettingResamplingMode>
    }
}
