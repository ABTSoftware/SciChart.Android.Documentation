package com.scichart.docsandbox.examples.kotlin.annotationsAPIs

import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.annotations.ImageAnnotation;
import com.scichart.charting.visuals.annotations.AnnotationSurfaceEnum;
import com.scichart.charting.visuals.annotations.ContentModeEnum;
import com.scichart.docsandbox.R
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment

@ExampleDefinition()
class ImageAnnotationFragment : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {}

    fun addBoxAnnotation(surface: SciChartSurface) {
        // <AddImageAnnotation>
        // Assume a surface has been created and configured somewhere
        // Create a ImageAnnotation
        val imageAnnotation = ImageAnnotation(context)

        // in a multi-axis scenario, specify the XAxisId and YAxisId
        imageAnnotation.xAxisId = "TopAxisId"
        imageAnnotation.yAxisId = "LeftAxisId"

        // Specify a desired position by setting coordinates
        imageAnnotation.x = 20.0f
        imageAnnotation.y1 = 10.0f
        imageAnnotation.x2 = 90.0f
        imageAnnotation.y2 = 4.0f

        // Specify the image resource
        imageAnnotation.image = R.drawable.example_image_annotation
        
        // Specify the image aspect ratio
        imageAnnotation.setContentMode(ContentModeEnum.FitXY)

        // Add the annotation to the AnnotationsCollection of a surface
        surface.annotations.add(imageAnnotation)
        // </AddImageAnnotation>
    }
}
