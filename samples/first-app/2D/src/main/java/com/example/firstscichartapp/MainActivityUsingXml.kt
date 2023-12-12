package com.example.firstscichartapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.firstscichartapp.databinding.ActivityMainUsingXmlBinding
import com.scichart.charting.model.dataSeries.XyDataSeries
import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.axes.IAxis
import com.scichart.charting.visuals.axes.NumericAxis
import com.scichart.charting.visuals.renderableSeries.FastLineRenderableSeries
import com.scichart.core.framework.UpdateSuspender
import com.scichart.core.model.DoubleValues
import kotlin.math.sin

class MainActivityUsingXml : AppCompatActivity() {
    private lateinit var binding: ActivityMainUsingXmlBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainUsingXmlBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val surface = findViewById<SciChartSurface>(R.id.surface)

        // <AddingAxesToTheSciChartSurface>
        val xAxis: IAxis = NumericAxis(this)
        val yAxis: IAxis = NumericAxis(this)

        UpdateSuspender.using(surface) {
            surface.xAxes.add(xAxis)
            surface.yAxes.add(yAxis)
        }
        // </AddingAxesToTheSciChartSurface>

        //<AddingRenderableSeries>
        val count = 1000
        val xValues = DoubleValues(count)
        val yValues = DoubleValues(count)

        for (i in 0 until count) {
            val x = 10.0 * i.toDouble() / count.toDouble()
            val y = sin(2 * x)
            xValues.add(x)
            yValues.add(y)
        }

        val dataSeries = XyDataSeries(Double::class.javaObjectType, Double::class.javaObjectType).apply {
            append(xValues, yValues)
        }

        val renderableSeries = FastLineRenderableSeries().apply {
            this.dataSeries = dataSeries
        }

        surface.renderableSeries.add(renderableSeries)
        //</AddingRenderableSeries>
    }
}

/*
// <FinalExampleCode>
class MainActivityUsingXml : AppCompatActivity() {

    private lateinit var binding: ActivityMainUsingXmlBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainUsingXmlBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val surface = findViewById<SciChartSurface>(R.id.surface)

        val xAxis: IAxis = NumericAxis(this)
        val yAxis: IAxis = NumericAxis(this)

        UpdateSuspender.using(surface) {
            surface.xAxes.add(xAxis)
            surface.yAxes.add(yAxis)
        }

        val count = 1000
        val xValues = DoubleValues(count)
        val yValues = DoubleValues(count)

        for (i in 0 until count) {
            val x = 10.0 * i.toDouble() / count.toDouble()
            val y = sin(2 * x)
            xValues.add(x)
            yValues.add(y)
        }

        val dataSeries = XyDataSeries(Double::class.javaObjectType, Double::class.javaObjectType).apply {
            append(xValues, yValues)
        }

        val renderableSeries = FastLineRenderableSeries().apply {
            this.dataSeries = dataSeries
        }

        surface.renderableSeries.add(renderableSeries)
    }
}
// </FinalExampleCode>
 */