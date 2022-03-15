package com.example.firstscichartapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.example.firstscichartapp.databinding.ActivityMainBinding
import com.scichart.charting.model.dataSeries.XyDataSeries
import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.axes.IAxis
import com.scichart.charting.visuals.axes.NumericAxis
import com.scichart.charting.visuals.renderableSeries.FastLineRenderableSeries
import com.scichart.charting3d.model.dataSeries.xyz.XyzDataSeries3D
import com.scichart.charting3d.visuals.SciChartSurface3D
import com.scichart.charting3d.visuals.axes.NumericAxis3D
import com.scichart.charting3d.visuals.renderableSeries.pointLine.PointLineRenderableSeries3D
import com.scichart.core.framework.UpdateSuspender
import com.scichart.core.model.DoubleValues
import kotlin.math.cos
import kotlin.math.sin

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    init {
        SciChartSurface.setRuntimeLicenseKey("")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val surface = findViewById<SciChartSurface3D>(R.id.surface)

        // <AddingAxesToTheSciChartSurface3D>
        UpdateSuspender.using(surface) {
            surface.xAxis = NumericAxis3D()
            surface.yAxis = NumericAxis3D()
            surface.zAxis = NumericAxis3D()
        }
        // </AddingAxesToTheSciChartSurface3D>

        //<Adding3DRenderableSeries>
        val dataSeries = XyzDataSeries3D(Double::class.javaObjectType, Double::class.javaObjectType, Double::class.javaObjectType)

        for (i in 0 until 100) {
            val x = 5 * sin(i.toDouble())
            val y = i.toDouble()
            val z = 5 * cos(i.toDouble())
            dataSeries.append(x, y, z)
        }

        val rSeries = PointLineRenderableSeries3D().apply {
            this.dataSeries = dataSeries
            strokeThickness = 3.0f
        }

        surface.renderableSeries.add(rSeries)
        //</Adding3DRenderableSeries>
    }
}

/*
// <FinalExampleCode>
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    init {
        SciChartSurface.setRuntimeLicenseKey("")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val surface = findViewById<SciChartSurface3D>(R.id.surface)

        // <AddingAxesToTheSciChartSurface3D>
        UpdateSuspender.using(surface) {
            surface.xAxis = NumericAxis3D()
            surface.yAxis = NumericAxis3D()
            surface.zAxis = NumericAxis3D()
        }
        // </AddingAxesToTheSciChartSurface3D>

        //<Adding3DRenderableSeries>
        val dataSeries = XyzDataSeries3D(Double::class.javaObjectType, Double::class.javaObjectType, Double::class.javaObjectType)

        for (i in 0 until 100) {
            val x = 5 * sin(i.toDouble())
            val y = i.toDouble()
            val z = 5 * cos(i.toDouble())
            dataSeries.append(x, y, z)
        }

        val rSeries = PointLineRenderableSeries3D().apply {
            this.dataSeries = dataSeries
            strokeThickness = 3.0f
        }

        surface.renderableSeries.add(rSeries)
        //</Adding3DRenderableSeries>
    }
}
// </FinalExampleCode>
 */