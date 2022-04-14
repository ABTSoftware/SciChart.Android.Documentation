package com.example.firstscichartapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.viewinterop.AndroidView
import com.example.firstscichartapp.databinding.ActivityMainBinding
import com.scichart.charting.visuals.SciChartSurface

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    init {
        SciChartSurface.setRuntimeLicenseKey("")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.composeView.setContent {
            // <AddingChartSurfaceUsingCompose>
            AndroidView(factory = { ctx ->
                SciChartSurface(ctx).apply {
                    // configure your surface with axes, dataSeries, renderableSeries, etc.
                }
            }, update = {
                // update your surface if needed
            })
            // </AddingChartSurfaceUsingCompose>
        }
    }
}
