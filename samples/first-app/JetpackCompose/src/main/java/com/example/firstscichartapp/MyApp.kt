package com.example.firstscichartapp

import android.app.Application
import com.scichart.charting.visuals.SciChartSurface

class MyApp: Application() {

    override fun onCreate() {
        super.onCreate()

        SciChartSurface.setRuntimeLicenseKey("")
    }
}