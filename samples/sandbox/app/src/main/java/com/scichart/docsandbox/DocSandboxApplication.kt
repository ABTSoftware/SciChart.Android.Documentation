package com.scichart.docsandbox

import android.app.Application
import com.scichart.charting.visuals.SciChartSurface

class DocSandboxApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        SciChartSurface.setRuntimeLicenseKey("");
    }
}
