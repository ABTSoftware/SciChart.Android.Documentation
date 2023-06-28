package com.scichart.docsandbox

import android.app.Application
import com.scichart.charting.visuals.SciChartSurface

class DocSandboxApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        SciChartSurface.setRuntimeLicenseKey("");
    }
}

/*
// <SetRuntimeLicenseKey>
class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        // Set your license code here to license the SciChart app
        // You can get a trial license key from https://www.scichart.com/licensing-scichart-android/
        // Purchased license keys can be viewed at https://www.scichart.com/profile
        //

        SciChartSurface.setRuntimeLicenseKey("");
    }

}
// </SetRuntimeLicenseKey>
*/

/*
// <SetRuntimeLicenseKeyManifest>

...
<application
        android:name=".MyApp"
...

// </SetRuntimeLicenseKeyManifest>
*/