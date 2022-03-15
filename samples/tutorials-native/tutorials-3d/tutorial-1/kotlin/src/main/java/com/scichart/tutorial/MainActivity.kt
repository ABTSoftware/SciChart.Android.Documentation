package com.scichart.tutorial

import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting3d.model.dataSeries.xyz.XyzDataSeries3D
import com.scichart.charting3d.visuals.SciChartSurface3D
import com.scichart.charting3d.visuals.axes.NumericAxis3D
import com.scichart.charting3d.visuals.pointMarkers.SpherePointMarker3D
import com.scichart.charting3d.visuals.renderableSeries.scatter.ScatterRenderableSeries3D
import com.scichart.core.framework.UpdateSuspender
import java.util.*
import kotlin.math.ln
import kotlin.math.sin
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {

    private lateinit var surface: SciChartSurface3D

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        SciChartSurface.setRuntimeLicenseKey("")

        val chartLayout = findViewById<ViewGroup>(R.id.chart_layout)

        surface = SciChartSurface3D(this)
        chartLayout.addView(surface)

        // <CreateDataSeries>
        val dataSeries = XyzDataSeries3D(Double::class.javaObjectType, Double::class.javaObjectType, Double::class.javaObjectType)
        for (i in 0..200) {
            val x = getGaussianRandomNumber(5.0, 1.5)
            val y = getGaussianRandomNumber(5.0, 1.5)
            val z = getGaussianRandomNumber(5.0, 1.5)
            dataSeries.append(x, y, z)
        }
        // </CreateDataSeries>

        // <CreateRenderableSeries>
        val pointMarker = SpherePointMarker3D()
        pointMarker.fill = 0xFF32CD32.toInt()
        pointMarker.size = 10.0f

        val rSeries = ScatterRenderableSeries3D()
        rSeries.dataSeries = dataSeries
        rSeries.pointMarker = pointMarker
        // </CreateRenderableSeries>

        UpdateSuspender.using(surface) {
            // <AddAxes>
            surface.xAxis = NumericAxis3D()
            surface.yAxis = NumericAxis3D()
            surface.zAxis = NumericAxis3D()
            // </AddAxes>

            // <AddRenderableSeries>
            Collections.addAll(surface.renderableSeries, rSeries)
            // </AddRenderableSeries>
        }
    }

    private fun getGaussianRandomNumber(mean: Double, stdDev: Double) : Double {
        val random = Random()

        val u1: Double = random.nextDouble()
        val u2: Double = random.nextDouble()

        val randStdNormal = sqrt(-2.0 * ln(u1)) * sin(2.0 * Math.PI * u2)
        return mean * stdDev * randStdNormal
    }
}
