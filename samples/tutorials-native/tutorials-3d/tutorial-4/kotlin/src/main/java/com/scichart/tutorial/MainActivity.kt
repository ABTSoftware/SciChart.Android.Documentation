package com.scichart.tutorial

import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting3d.model.dataSeries.xyz.XyzDataSeries3D
import com.scichart.charting3d.modifiers.*
import com.scichart.charting3d.visuals.SciChartSurface3D
import com.scichart.charting3d.visuals.axes.NumericAxis3D
import com.scichart.charting3d.visuals.pointMarkers.SpherePointMarker3D
import com.scichart.charting3d.visuals.renderableSeries.scatter.ScatterRenderableSeries3D
import com.scichart.core.framework.UpdateSuspender
import com.scichart.core.model.DoubleValues
import java.util.*
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledFuture
import java.util.concurrent.TimeUnit
import kotlin.math.ln
import kotlin.math.sin
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    // <DataSeriesSetup>
    private val pointsCount = 200

    private val scheduledExecutorService = Executors.newSingleThreadScheduledExecutor()
    private lateinit var schedule: ScheduledFuture<*>

    private lateinit var surface: SciChartSurface3D

    private val xValues = DoubleValues()
    private val yValues = DoubleValues()
    private val zValues = DoubleValues()

    private val dataSeries = XyzDataSeries3D(Double::class.javaObjectType, Double::class.javaObjectType, Double::class.javaObjectType)
    // </DataSeriesSetup>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        SciChartSurface.setRuntimeLicenseKey("")

        val chartLayout = findViewById<ViewGroup>(R.id.chart_layout)

        surface = SciChartSurface3D(this)
        chartLayout.addView(surface)

        // <AppendDataSeries>
        for (i in 0 until pointsCount) {
            xValues.add(getGaussianRandomNumber(5.0, 1.5))
            yValues.add(getGaussianRandomNumber(5.0, 1.5))
            zValues.add(getGaussianRandomNumber(5.0, 1.5))
        }
        dataSeries.append(xValues, yValues, zValues)
        // </AppendDataSeries>

        val pointMarker = SpherePointMarker3D()
        pointMarker.fill = 0xFF32CD32.toInt()
        pointMarker.size = 10.0f

        val rSeries = ScatterRenderableSeries3D()
        rSeries.dataSeries = dataSeries
        rSeries.pointMarker = pointMarker

        val tooltipModifier = TooltipModifier3D()
        tooltipModifier.crosshairMode = CrosshairMode.Lines

        UpdateSuspender.using(surface) {
            surface.xAxis = NumericAxis3D()
            surface.yAxis = NumericAxis3D()
            surface.zAxis = NumericAxis3D()
            Collections.addAll(surface.renderableSeries, rSeries)
            Collections.addAll(
                surface.chartModifiers,
                OrbitModifier3D().apply {
                    executeOnPointerCount = 2
                },
                ZoomExtentsModifier3D(),
                PinchZoomModifier3D(),
                tooltipModifier
            )
        }

        // <CreateTimer>
        schedule = scheduledExecutorService.scheduleWithFixedDelay(updateData, 0, 10, TimeUnit.MILLISECONDS)
        // </CreateTimer>
    }

    // <UpdateData>
    private val random = Random()

    private val updateData = Runnable {
        for (i in 0 until pointsCount) {
            val xValue = xValues.get(i) + random.nextDouble() - 0.5
            val yValue = yValues.get(i) + random.nextDouble() - 0.5
            val zValue = zValues.get(i) + random.nextDouble() - 0.5

            xValues.set(i, xValue)
            yValues.set(i, yValue)
            zValues.set(i, zValue)
        }

        UpdateSuspender.using(surface) {
            dataSeries.updateRangeXyzAt(0, xValues, yValues, zValues)
        }
    }
    // </UpdateData>

    private fun getGaussianRandomNumber(mean: Double, stdDev: Double) : Double {
        val random = Random()

        val u1: Double = random.nextDouble()
        val u2: Double = random.nextDouble()

        val randStdNormal = sqrt(-2.0 * ln(u1)) * sin(2.0 * Math.PI * u2)
        return mean * stdDev * randStdNormal
    }
}
