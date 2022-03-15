package com.scichart.docsandbox.examples.kotlin.series3d

import android.graphics.BitmapFactory
import com.scichart.charting3d.visuals.SciChartSurface3D
import com.scichart.charting3d.visuals.pointMarkers.CustomPointMarker3D
import com.scichart.charting3d.visuals.pointMarkers.SpherePointMarker3D
import com.scichart.charting3d.visuals.renderableSeries.pointLine.PointLineRenderableSeries3D
import com.scichart.charting3d.visuals.renderableSeries.scatter.ScatterRenderableSeries3D
import com.scichart.docsandbox.R
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart3DFragment

@ExampleDefinition()
class PointMarker3DAPI : SingleChart3DFragment() {
    override fun initExample(surface: SciChartSurface3D) {
        createPointMarker3D()
    }

    fun createPointMarker3D() {
        // <CreatePointMarker3D>
        // Create a Sphere PointMarker 3D instance
        val pointMarker = SpherePointMarker3D()
        pointMarker.size = 25f
        pointMarker.fill = -0x10000

        // Apply the PointMarker to a PointLine Series 3D
        val rs = PointLineRenderableSeries3D()
        rs.pointMarker = pointMarker
        // </CreatePointMarker3D>
    }

    fun createCustomPointMarker3D() {
        // <CreateCustomPointMarker3D>
        // Create custom PointMarker 3D
        val bitmap = BitmapFactory.decodeResource(requireContext().resources, R.drawable.example_weather_storm)
        val pointMarker = CustomPointMarker3D(bitmap)
        pointMarker.size = 10f

        // Apply the PointMarker to a PointLine Series 3D
        val rs = ScatterRenderableSeries3D()
        rs.pointMarker = pointMarker
        // </CreateCustomPointMarker3D>
    }
}
