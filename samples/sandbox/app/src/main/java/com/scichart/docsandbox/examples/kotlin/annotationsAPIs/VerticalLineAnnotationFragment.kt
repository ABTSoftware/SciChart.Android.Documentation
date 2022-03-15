package com.scichart.docsandbox.examples.kotlin.annotationsAPIs

import android.view.Gravity
import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.annotations.*
import com.scichart.charting.visuals.axes.AxisInfo
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment
import com.scichart.drawing.common.SolidPenStyle
import java.util.*

@ExampleDefinition()
class VerticalLineAnnotationFragment : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {}

    fun addVerticalLineAnnotation(surface: SciChartSurface) {
        // <AddVerticalLineAnnotation>
        // Assume a surface has been created and configured somewhere
        // Create a VerticalLine Annotation
        val verticalLine = VerticalLineAnnotation(context)

        // Allow to interact with the annotation in run-time
        verticalLine.setIsEditable(true)

        // In a multi-axis scenario, specify the XAxisId and YAxisId
        verticalLine.xAxisId = "BottomAxisId"
        verticalLine.yAxisId = "RightAxisId"

        // Specify a desired position by setting coordinates and mode
        verticalLine.coordinateMode = AnnotationCoordinateMode.RelativeY
        verticalLine.y1 = 0.1

        // Specify the border color for the annotation
        verticalLine.stroke = SolidPenStyle(-0xe6e7, true, 2f, null)

        // Add the annotation to the Annotations collection of the surface
        surface.annotations.add(verticalLine)
        // </AddVerticalLineAnnotation>

        // <AddVerticalLineAnnotationLabel>
        val annotationLabel = AnnotationLabel(context)
        annotationLabel.text = "Label text"
        annotationLabel.labelPlacement = LabelPlacement.Axis
        verticalLine.annotationLabels.add(annotationLabel)
        // </AddVerticalLineAnnotationLabel>
    }

    fun addAnnotationLabelsToVerticalLineAnnotation() {
        // <AddAnnotationLabelsToVerticalLineAnnotation>
        val axisAnnotationLabel = AnnotationLabel(context)
        axisAnnotationLabel.labelPlacement = LabelPlacement.Axis
        axisAnnotationLabel.setPadding(0, 10, 0, 0)

        val annotationLabel = AnnotationLabel(context)
        annotationLabel.labelPlacement = LabelPlacement.TopRight
        annotationLabel.text = "Rotated Label"
        annotationLabel.rotationAngle = -90f

        val verticalLine = VerticalLineAnnotation(context)
        verticalLine.y1 = 8
        verticalLine.verticalGravity = Gravity.BOTTOM

        Collections.addAll(verticalLine.annotationLabels, annotationLabel, axisAnnotationLabel)
        // </AddAnnotationLabelsToVerticalLineAnnotation>
    }

    fun createAnnotationValueProviderForVerticalLineAnnotation() {
        // <CreateAnnotationValueProviderForVerticalLineAnnotation>
        class AnnotationValueProvider : IFormattedValueProvider {
            override fun formatValue(axisInfo: AxisInfo): CharSequence? {
                return if (axisInfo != null) String.format(
                    "[ --- %s --- ]",
                    axisInfo.axisFormattedDataValue
                ) else null
            }
        }
        // </CreateAnnotationValueProviderForVerticalLineAnnotation>

        // <UseAnnotationValueProviderForVerticalLineAnnotation>
        val verticalLine = VerticalLineAnnotation(context)
        verticalLine.xAxisId = "BottomAxisId"
        verticalLine.yAxisId = "RightAxisId"
        verticalLine.x1 = 65
        verticalLine.stroke = SolidPenStyle(-0xe6e7, true, 4f, null)

        // Provide custom IFormattedValueProvider for the annotation
        verticalLine.formattedLabelValueProvider = AnnotationValueProvider()

        val axisAnnotationLabel = AnnotationLabel(context)
        axisAnnotationLabel.labelPlacement = LabelPlacement.Axis

        verticalLine.annotationLabels.add(axisAnnotationLabel)
        // </UseAnnotationValueProviderForVerticalLineAnnotation>
    }
}
