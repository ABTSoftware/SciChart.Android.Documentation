package com.scichart.tutorial

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.scichart.charting.model.dataSeries.XyDataSeries
import com.scichart.charting.modifiers.*
import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.annotations.HorizontalAnchorPoint
import com.scichart.charting.visuals.annotations.TextAnnotation
import com.scichart.charting.visuals.annotations.VerticalAnchorPoint
import com.scichart.charting.visuals.axes.IAxis
import com.scichart.charting.visuals.axes.NumericAxis
import com.scichart.charting.visuals.pointmarkers.EllipsePointMarker
import com.scichart.charting.visuals.renderableSeries.FastLineRenderableSeries
import com.scichart.charting.visuals.renderableSeries.IRenderableSeries
import com.scichart.charting.visuals.renderableSeries.XyScatterRenderableSeries
import com.scichart.core.annotations.Orientation
import com.scichart.core.framework.UpdateSuspender
import com.scichart.core.model.DoubleValues
import com.scichart.core.model.IntegerValues
import com.scichart.drawing.common.FontStyle
import com.scichart.drawing.common.SolidBrushStyle
import java.util.*
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledFuture
import java.util.concurrent.TimeUnit
import kotlin.math.cos
import kotlin.math.sin

class MainActivity : AppCompatActivity() {
    private val fifoCapacity = 300
    private val pointsCount = 200

    private val scheduledExecutorService = Executors.newSingleThreadScheduledExecutor()
    private lateinit var schedule: ScheduledFuture<*>

    private lateinit var surface: SciChartSurface

    private val lineData = DoubleValues()
    private val lineDataSeries = XyDataSeries(Int::class.javaObjectType, Double::class.javaObjectType).apply {
        seriesName = "Line Series"
        this.fifoCapacity = this@MainActivity.fifoCapacity
    }

    private val scatterData = DoubleValues()
    private val scatterDataSeries = XyDataSeries(Int::class.javaObjectType, Double::class.javaObjectType).apply {
        seriesName = "Scatter Series"
        this.fifoCapacity = this@MainActivity.fifoCapacity
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        SciChartSurface.setRuntimeLicenseKey("")

        val chartLayout = findViewById<ViewGroup>(R.id.chart_layout)
        surface = SciChartSurface(this)
        chartLayout.addView(surface)

        val xAxis: IAxis = NumericAxis(this)
        val yAxis: IAxis = NumericAxis(this)

        UpdateSuspender.using(surface) {
            Collections.addAll(surface.xAxes, xAxis)
            Collections.addAll(surface.yAxes, yAxis)
        }

        val xValues = IntegerValues()
        for (i in 0 until pointsCount) {
            xValues.add(i)
            lineData.add(sin(i * 0.1))
            scatterData.add(cos(i * 0.1))
            count += 1
        }
        lineDataSeries.append(xValues, lineData)
        scatterDataSeries.append(xValues, scatterData)

        val lineSeries: IRenderableSeries = FastLineRenderableSeries()
        lineSeries.dataSeries = lineDataSeries

        val pointMarker = EllipsePointMarker()
        pointMarker.fillStyle = SolidBrushStyle(-0xcd32ce)
        pointMarker.setSize(10, 10)

        val scatterSeries: IRenderableSeries = XyScatterRenderableSeries()
        scatterSeries.dataSeries = scatterDataSeries
        scatterSeries.pointMarker = pointMarker

        val legendModifier = LegendModifier(this)
        legendModifier.setOrientation(Orientation.HORIZONTAL)
        legendModifier.setLegendPosition(Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL, 0, 0, 0, 10)

        UpdateSuspender.using(surface) {
            Collections.addAll(surface.renderableSeries, lineSeries, scatterSeries)
            Collections.addAll(surface.chartModifiers, PinchZoomModifier(), ZoomPanModifier(), ZoomExtentsModifier())
            Collections.addAll(surface.chartModifiers, legendModifier)
            Collections.addAll(surface.chartModifiers, RolloverModifier())
        }

        schedule = scheduledExecutorService.scheduleWithFixedDelay(updateData, 0, 10, TimeUnit.MILLISECONDS)
    }

    private var count: Int = 0

    // <AddAnnotations>
    private val updateData = Runnable {
        val x = count
        UpdateSuspender.using(surface) {
            lineDataSeries.append(x, sin(x* 0.1))
            scatterDataSeries.append(x, cos(x * 0.1))

            tryAddAnnotationAt(x)

            // zoom series to fit viewport size into X-Axis direction
            surface.zoomExtentsX()
            count += 1
        }
    }

    private fun tryAddAnnotationAt(x: Int) {
        // add label every 100 data points
        if (x % 100 == 0) {
            val label = TextAnnotation(this)
            label.text = "N"
            label.x1 = x
            label.y1 = 0
            label.horizontalAnchorPoint = HorizontalAnchorPoint.Center
            label.verticalAnchorPoint = VerticalAnchorPoint.Center
            label.fontStyle = FontStyle(30f, Color.WHITE)

            // add label into annotation collection
            surface.annotations.add(label)

            // if we add annotation and x > fifoCapacity
            // then we need to remove annotation which goes out of the screen
            if (x > fifoCapacity) {
                surface.annotations.removeAt(0)
            }
        }
    }
    // </AddAnnotations>
}
