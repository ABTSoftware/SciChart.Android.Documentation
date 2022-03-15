package com.scichart.docsandbox.examples.kotlin.annotationsAPIs

import android.widget.ImageView
import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.annotations.CustomAnnotation
import com.scichart.docsandbox.R
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment

@ExampleDefinition()
class CustomAnnotationFragment : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {}

    fun addCustomAnnotation(surface: SciChartSurface) {
        // <AddCustomAnnotation>
        // assume the surface has been created and configured before
        // create a CustomAnnotation
        val customAnnotation = CustomAnnotation(activity)

        // prepare an ImageView for the CustomAnnotation
        val image = ImageView(activity)
        image.setImageResource(R.drawable.my_custom_view)

        // supply it with ImageView
        customAnnotation.setContentView(image)

        // specify a desired position
        customAnnotation.x1 = 4.2
        customAnnotation.y1 = 2.0

        // Allow to interact with the annotation in run-time
        customAnnotation.setIsEditable(true)

        // in a multi-axis scenario, specify the XAxisId and YAxisId
        customAnnotation.xAxisId = "BottomAxisId"
        customAnnotation.yAxisId = "LeftAxisId"

        // add the annotation to the Annotations collection of the surface
        surface.annotations.add(customAnnotation)
        // </AddCustomAnnotation>
    }
}
