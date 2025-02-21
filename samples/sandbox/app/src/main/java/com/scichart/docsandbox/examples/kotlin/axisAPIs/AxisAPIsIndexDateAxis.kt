package com.scichart.docsandbox.examples.kotlin.axisAPIs

import com.scichart.charting.model.dataSeries.OhlcDataSeries
import com.scichart.charting.numerics.indexDataProvider.DataSeriesIndexDataProvider
import com.scichart.charting.numerics.indexDataProvider.IIndexDataProvider
import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.axes.*
import com.scichart.data.model.DateRange
import com.scichart.data.model.DoubleRange
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment
import java.util.*

@ExampleDefinition()
class AxisAPIsIndexDateAxis : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {}

    fun addIndexDateAxis() {
        // <IndexDateAxis>
        val indexDateAxis = IndexDateAxis(context)

        val dataSeries = OhlcDataSeries(Date::class.javaObjectType, Double::class.javaObjectType)
        val indexDataProvider: IIndexDataProvider = DataSeriesIndexDataProvider(dataSeries)

        indexDateAxis.setIndexDataProvider(indexDataProvider)
        // </IndexDateAxis>
    }
}
