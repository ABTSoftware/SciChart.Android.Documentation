package com.scichart.docsandbox.examples.kotlin.annotationsAPIs

import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.annotations.AxisMarkerAnnotation
import com.scichart.charting.visuals.annotations.IFormattedValueProvider
import com.scichart.charting.visuals.axes.AxisInfo
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment

@ExampleDefinition()
class AxisMarkerAnnotationFragment : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {}

    fun addAxisMarkerAnnotation(surface: SciChartSurface) {
        // <AddAxisMarkerAnnotation>
        // Assume a surface has been created and configured somewhere
        // Create an AxisMarkerAnnotation
        val rightMarker = AxisMarkerAnnotation(context)

        // Specify a desired position by setting the Y1 coordinate, since the marker is going to be located on an Y axis
        rightMarker.y1 = 8

        // Allow to interact with the annotation in run-time
        rightMarker.setIsEditable(true)

        // In a multi-axis scenario, specify the XAxisId and YAxisId
        rightMarker.xAxisId = "BottomAxisId"
        rightMarker.yAxisId = "RightAxisId"

        // Specify the background color for the marker
        rightMarker.setBackgroundColor(-0x55bf7c49)

        // Add the annotation to the Annotations collection of the surface
        surface.annotations.add(rightMarker)
        // </AddAxisMarkerAnnotation>

        // <SetAnnotationValueProvider>
        // Provide custom IFormattedValueProvider for the annotation
        rightMarker.formattedValueProvider = AnnotationValueProvider()
        // </SetAnnotationValueProvider>
    }

    // <CreateAnnotationValueProviderForAxisMarkerAnnotation>
    // Declare custom IFormattedValueProvider
    internal class AnnotationValueProvider : IFormattedValueProvider {
        override fun formatValue(axisInfo: AxisInfo?): CharSequence? {
            return if (axisInfo != null) String.format(
                "[ --- %s --- ]",
                axisInfo.axisFormattedDataValue
            ) else null
        }
    }
    // </CreateAnnotationValueProviderForAxisMarkerAnnotation>
}
