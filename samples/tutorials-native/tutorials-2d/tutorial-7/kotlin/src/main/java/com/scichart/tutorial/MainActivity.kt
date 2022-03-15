package com.scichart.tutorial

import android.graphics.Color
import android.os.Bundle
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.scichart.charting.model.dataSeries.XyDataSeries
import com.scichart.charting.modifiers.*
import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.annotations.HorizontalAnchorPoint
import com.scichart.charting.visuals.annotations.TextAnnotation
import com.scichart.charting.visuals.annotations.VerticalAnchorPoint
import com.scichart.charting.visuals.axes.AxisAlignment
import com.scichart.charting.visuals.axes.NumericAxis
import com.scichart.charting.visuals.pointmarkers.EllipsePointMarker
import com.scichart.charting.visuals.renderableSeries.FastLineRenderableSeries
import com.scichart.charting.visuals.renderableSeries.FastMountainRenderableSeries
import com.scichart.charting.visuals.renderableSeries.XyScatterRenderableSeries
import com.scichart.core.framework.UpdateSuspender
import com.scichart.data.model.DoubleRange
import com.scichart.drawing.common.FontStyle
import com.scichart.drawing.common.SolidBrushStyle
import com.scichart.drawing.common.SolidPenStyle
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

    private val lineDataSeries = XyDataSeries(Int::class.javaObjectType, Double::class.javaObjectType).apply {
        seriesName = "Line Series"
        this.fifoCapacity = this@MainActivity.fifoCapacity
    }

    private val scatterDataSeries = XyDataSeries(Int::class.javaObjectType, Double::class.javaObjectType).apply {
        seriesName = "Scatter Series"
        this.fifoCapacity = this@MainActivity.fifoCapacity
    }

    private val mountainDataSeries = XyDataSeries(Int::class.javaObjectType, Double::class.javaObjectType).apply {
        seriesName = "Mountain Series"
        this.fifoCapacity = this@MainActivity.fifoCapacity
    }

    private lateinit var surface: SciChartSurface
    private lateinit var surface2: SciChartSurface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        SciChartSurface.setRuntimeLicenseKey("")

        val chartLayout = findViewById<ViewGroup>(R.id.chart_layout)

        // <AddTwoSurfaces>
        surface = SciChartSurface(this)
        surface2 = SciChartSurface(this)
        chartLayout.addView(surface)
        chartLayout.addView(surface2)

        // Set layout parameters for both surfaces
        val layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT,
            1.0f
        )
        surface.layoutParams = layoutParams
        surface2.layoutParams = layoutParams
        // </AddTwoSurfaces>

        for (i in 0 until pointsCount) {
            lineDataSeries.append(i, sin(i * 0.1))
            scatterDataSeries.append(i, cos(i * 0.1))
            mountainDataSeries.append(i, cos(i * 0.1))
            count += 1
        }

        val lineSeries = FastLineRenderableSeries()
        lineSeries.yAxisId = "Primary Y-Axis"
        lineSeries.dataSeries = lineDataSeries

        val pointMarker = EllipsePointMarker()
        pointMarker.fillStyle = SolidBrushStyle(-0xcd32ce)
        pointMarker.setSize(10, 10)

        val scatterSeries = XyScatterRenderableSeries()
        scatterSeries.yAxisId = "Secondary Y-Axis"
        scatterSeries.dataSeries = scatterDataSeries
        scatterSeries.pointMarker = pointMarker

        UpdateSuspender.using(surface) {
            Collections.addAll(surface.renderableSeries, lineSeries, scatterSeries)
        }

        // <AddMountainSeries>
        val mountainSeries = FastMountainRenderableSeries()
        mountainSeries.yAxisId = "Primary Y-Axis"
        mountainSeries.dataSeries = mountainDataSeries
        mountainSeries.strokeStyle = SolidPenStyle(0xFF0271B1.toInt(), false, 1.0f, null)
        mountainSeries.areaStyle = SolidBrushStyle(0xAAFF8D42.toInt())

        UpdateSuspender.using(surface2) {
            Collections.addAll(surface2.renderableSeries, mountainSeries)
        }
        // </AddMountainSeries>

        // <SetupSurfaces2>
        setupSurface(surface)
        setupSurface(surface2)
        // </SetupSurfaces2>

        schedule = scheduledExecutorService.scheduleWithFixedDelay(updateData, 0, 10, TimeUnit.MILLISECONDS)
    }

    private var count: Int = 0

    private val updateData = Runnable {
        val x = count
        UpdateSuspender.using(surface) {
            lineDataSeries.append(x, sin(x* 0.1))
            scatterDataSeries.append(x, cos(x * 0.1))
            mountainDataSeries.append(x, cos(x * 0.1))

            tryAddAnnotationAt(x)

            // zoom series to fit viewport size into X-Axis direction
            surface.zoomExtentsX()
            surface2.zoomExtentsX()
            count += 1
        }
    }

    // <SetupSurfaces1>
    private fun setupSurface(surface: SciChartSurface) {
        // Create another numeric axis, right-aligned
        val yAxisRight = NumericAxis(this)
        yAxisRight.axisTitle = "Primary Y-Axis"
        yAxisRight.axisId = "Primary Y-Axis"
        yAxisRight.axisAlignment = AxisAlignment.Right

        // Create another numeric axis, left-aligned
        val yAxisLeft = NumericAxis(this)
        yAxisLeft.axisTitle = "Secondary Y-Axis"
        yAxisLeft.axisId = "Secondary Y-Axis"
        yAxisLeft.axisAlignment = AxisAlignment.Left
        yAxisLeft.growBy = DoubleRange(0.2, 0.2)

        val rolloverModifier = RolloverModifier()
        rolloverModifier.receiveHandledEvents = true
        rolloverModifier.eventsGroupTag = "SharedEventGroup"

        UpdateSuspender.using(surface) {
            Collections.addAll(surface.xAxes, NumericAxis(this))
            Collections.addAll(surface.yAxes, yAxisLeft, yAxisRight)
            Collections.addAll(
                surface.chartModifiers,
                ZoomExtentsModifier(),
                PinchZoomModifier(),
                rolloverModifier,
                XAxisDragModifier(),
                YAxisDragModifier()
            )
        }
    }
    // </SetupSurfaces1>

    /*
        // <SynchronizeVisibleRanges>
        // Create an IRange instance that will be shared across multiple charts
        val sharedXRange = DoubleRange()

        // Create an X axis and apply sharedXRange
        val xAxis = NumericAxis(this)
        xAxis.visibleRange = sharedXRange

        // Create another X axis and apply sharedXRange
        val xAxis2 = NumericAxis(this)
        xAxis2.visibleRange = sharedXRange
        // </SynchronizeVisibleRanges>
     */

    /*
        // <AddVerticalGroup>
        val verticalGroup = SciChartVerticalGroup()
        verticalGroup.addSurfaceToGroup(surface)
        verticalGroup.addSurfaceToGroup(surface2)
        // </AddVerticalGroup>
    */

    /*
        // <SetModifierGroup>
        val modifierGroup = ModifierGroup()
        modifierGroup.motionEventGroup = "SharedEventGroup"
        modifierGroup.receiveHandledEvents = true
        Collections.addAll(
            modifierGroup.childModifiers,
            ZoomExtentsModifier(),
            PinchZoomModifier(),
            rolloverModifier,
            XAxisDragModifier(),
            YAxisDragModifier()
        )
        // </SetModifierGroup>
     */

    private fun tryAddAnnotationAt(x: Int) {
        // add label every 100 data points
        if (x % 100 == 0) {
            val label = TextAnnotation(this)
            label.yAxisId = if (x % 200 == 0) "Primary Y-Axis" else "Secondary Y-Axis"
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
}
