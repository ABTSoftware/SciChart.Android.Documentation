package com.example.firstscichartapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
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

// <FinalExampleCodeUsingCompose3D>
class MainActivity3D : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.composeView.setContent {
            SciChartView3D()
        }
    }
}

@Composable
fun SciChartView3D() {
    AndroidView(factory = {context ->
        SciChartSurface3D(context)
    }, update = { surface ->
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
    })
}
// </FinalExampleCodeUsingCompose3D>

/*
// <AddingChartSurfaceUsingCompose>
AndroidView(factory = { ctx ->
    SciChartSurface(ctx).apply {
        // configure your surface with axes, dataSeries, renderableSeries, etc.
    }
}, update = {
    // update your surface if needed
})
// </AddingChartSurfaceUsingCompose>
 */