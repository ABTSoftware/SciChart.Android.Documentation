package com.scichart.docsandbox.examples.kotlin.series2d

import com.scichart.charting.model.dataSeries.IXyDataSeries
import com.scichart.charting.model.dataSeries.XyDataSeries
import com.scichart.charting.model.datadistributioncalculator.UserDefinedDistributionCalculator
import com.scichart.charting.visuals.SciChartSurface
import com.scichart.data.model.IRange
import com.scichart.data.model.ISciList
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment

@ExampleDefinition()
class DataSeriesAPIs : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {
        xYRanges()
    }

    fun xYRanges() {
        // <XYRanges>
        val dataSeries: IXyDataSeries<Double, Double> = XyDataSeries(Double::class.java, Double::class.java)
        // Append some data here
        val xRange: IRange<*> = dataSeries.xRange
        val yRange: IRange<*> = dataSeries.yRange
        // You can access Min/Max directly as Double
        val min = xRange.minAsDouble
        val max = xRange.maxAsDouble
        // </XYRanges>
    }

    fun accessingValues() {
        // <AccessingValues>
        val dataSeries: IXyDataSeries<Double, Double> = XyDataSeries(Double::class.java, Double::class.java)
        val xValues: ISciList<Double> = dataSeries.xValues
        // You can cast each value separately
        val value = xValues.getDoubleValue(0)
        // </AccessingValues>
    }

    fun setFifoCapacity() {
        // <SetFifoCapacity>
        val dataSeries: IXyDataSeries<Double, Double> = XyDataSeries(Double::class.java, Double::class.java)
        dataSeries.fifoCapacity = 1000
        // </SetFifoCapacity>
    }

    fun setDataDistribution() {
        // <SetDataDistribution>
        val dataDistributionCalculator = UserDefinedDistributionCalculator<Double>()
        dataDistributionCalculator.isDataSortedAscending = true
        dataDistributionCalculator.isDataEvenlySpaced = true

        val dataSeries: IXyDataSeries<Double, Double> = XyDataSeries(Double::class.java, Double::class.java)
        // </SetDataDistribution>
    }

    fun setAcceptsUnsortedData() {
        // <SetAcceptsUnsortedData>
        val dataSeries: IXyDataSeries<Double, Double> = XyDataSeries(Double::class.java, Double::class.java)
        dataSeries.acceptsUnsortedData = true
        // </SetAcceptsUnsortedData>
    }
}
