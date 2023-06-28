package com.example.firstscichartapp

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.scichart.charting3d.model.dataSeries.xyz.XyzDataSeries3D
import com.scichart.charting3d.visuals.SciChartSurface3D
import com.scichart.charting3d.visuals.axes.NumericAxis3D
import com.scichart.charting3d.visuals.renderableSeries.pointLine.PointLineRenderableSeries3D
import com.scichart.core.framework.UpdateSuspender
import kotlin.math.cos
import kotlin.math.sin

// <FinalExampleCodeUsingCode>
class MainActivityUsingCode : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main_using_code)

        val surface = SciChartSurface3D(this)
        val chartLayout = findViewById<FrameLayout>(R.id.chart_layout)
        chartLayout.addView(surface)

        UpdateSuspender.using(surface) {
            surface.xAxis = NumericAxis3D()
            surface.yAxis = NumericAxis3D()
            surface.zAxis = NumericAxis3D()
        }

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

    }
}
// </FinalExampleCodeUsingCode>



