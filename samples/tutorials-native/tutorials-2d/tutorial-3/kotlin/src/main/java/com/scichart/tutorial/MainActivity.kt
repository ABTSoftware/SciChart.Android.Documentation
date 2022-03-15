package com.scichart.tutorial

import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.scichart.charting.model.dataSeries.XyDataSeries
import com.scichart.charting.modifiers.*
import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.axes.IAxis
import com.scichart.charting.visuals.axes.NumericAxis
import com.scichart.charting.visuals.pointmarkers.EllipsePointMarker
import com.scichart.charting.visuals.renderableSeries.FastLineRenderableSeries
import com.scichart.charting.visuals.renderableSeries.IRenderableSeries
import com.scichart.charting.visuals.renderableSeries.XyScatterRenderableSeries
import com.scichart.core.annotations.Orientation
import com.scichart.core.framework.UpdateSuspender
import com.scichart.drawing.common.SolidBrushStyle
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        SciChartSurface.setRuntimeLicenseKey("")

        val surface = SciChartSurface(this)
        val chartLayout = findViewById<ViewGroup>(R.id.chart_layout)
        chartLayout.addView(surface)

        val xAxis: IAxis = NumericAxis(this)
        val yAxis: IAxis = NumericAxis(this)

        UpdateSuspender.using(surface) {
            Collections.addAll(surface.xAxes, xAxis)
            Collections.addAll(surface.yAxes, yAxis)
        }

        val lineDataSeries = XyDataSeries(Int::class.javaObjectType, Double::class.javaObjectType)
        val scatterDataSeries = XyDataSeries(Int::class.javaObjectType, Double::class.javaObjectType)

        // <AddSeriesName>
        lineDataSeries.seriesName = "Line Series"
        scatterDataSeries.seriesName = "Scatter Series"
        // </AddSeriesName>

        for (i in 0..999) {
            lineDataSeries.append(i, Math.sin(i * 0.1))
            scatterDataSeries.append(i, Math.cos(i * 0.1))
        }

        val lineSeries: IRenderableSeries = FastLineRenderableSeries()
        lineSeries.dataSeries = lineDataSeries

        val pointMarker = EllipsePointMarker()
        pointMarker.fillStyle = SolidBrushStyle(-0xcd32ce)
        pointMarker.setSize(10, 10)

        val scatterSeries: IRenderableSeries = XyScatterRenderableSeries()
        scatterSeries.dataSeries = scatterDataSeries
        scatterSeries.pointMarker = pointMarker

        // <CreateLegend>
        val legendModifier = LegendModifier(this)
        legendModifier.setOrientation(Orientation.HORIZONTAL)
        legendModifier.setLegendPosition(Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL, 0, 0, 0, 10)
        // </CreateLegend>

        UpdateSuspender.using(surface) {
            Collections.addAll(surface.renderableSeries, lineSeries, scatterSeries)
            Collections.addAll(surface.chartModifiers, PinchZoomModifier(), ZoomPanModifier(), ZoomExtentsModifier())

            // <AddLegend>
            Collections.addAll(surface.chartModifiers, legendModifier)
            // </AddLegend>

            // <AddRollover>
            Collections.addAll(surface.chartModifiers, RolloverModifier())
            // </AddRollover>
        }
    }
}
