package com.scichart.docsandbox.examples.kotlin.annotationsAPIs

import android.graphics.Color
import android.view.Gravity
import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.annotations.*
import com.scichart.charting.visuals.axes.AxisInfo
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment
import com.scichart.drawing.common.FontStyle
import com.scichart.drawing.common.SolidPenStyle
import java.util.*

@ExampleDefinition()
class HorizontalLineAnnotationFragment : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {}

    fun addHorizontalLineAnnotation(surface: SciChartSurface) {
        // <AddHorizontalLineAnnotation>
        // Assume a surface has been created and configured somewhere
        // Create a HorizontalLine Annotation
        val horizontalLine = HorizontalLineAnnotation(context)

        // Allow to interact with the annotation in run-time
        horizontalLine.setIsEditable(true)

        // In a multi-axis scenario, specify the XAxisId and YAxisId
        horizontalLine.xAxisId = "TopAxisId"
        horizontalLine.yAxisId = "RightAxisId"

        // Specify a desired position by setting coordinates and mode
        horizontalLine.coordinateMode = AnnotationCoordinateMode.RelativeY
        horizontalLine.y1 = 0.1

        // Specify the border color for the annotation
        horizontalLine.stroke = SolidPenStyle(-0x363d7, true, 2f, null)

        // Add the annotation to the Annotations collection of the surface
        surface.annotations.add(horizontalLine)
        // </AddHorizontalLineAnnotation>

        // <AddHorizontalLineAnnotationLabel>
        val annotationLabel = AnnotationLabel(context)
        annotationLabel.text = "Label text"
        annotationLabel.labelPlacement = LabelPlacement.Axis
        horizontalLine.annotationLabels.add(annotationLabel)
        // </AddHorizontalLineAnnotationLabel>
    }

    fun addAnnotationLabelsToHorizontalLineAnnotation() {
        // <AddAnnotationLabelsToHorizontalLineAnnotation>
        val horizontalLine = HorizontalLineAnnotation(context)
        horizontalLine.x1 = 10.0
        horizontalLine.y1 = 34.512
        horizontalLine.setIsEditable(true)
        horizontalLine.horizontalGravity = Gravity.END
        horizontalLine.stroke = SolidPenStyle(Color.RED, true, 2f, null)

        val axisAnnotationLabel = AnnotationLabel(context)
        axisAnnotationLabel.labelPlacement = LabelPlacement.Axis
        axisAnnotationLabel.rotationAngle = -10f
        axisAnnotationLabel.setPadding(10, 0, 0, 0)

        val annotationLabel = AnnotationLabel(context)
        annotationLabel.labelPlacement = LabelPlacement.TopLeft
        annotationLabel.text = "Whatever Label"
        annotationLabel.fontStyle = FontStyle(25.0f, Color.YELLOW)

        Collections.addAll(horizontalLine.annotationLabels, annotationLabel, axisAnnotationLabel)
        // </AddAnnotationLabelsToHorizontalLineAnnotation>
    }

    fun createAnnotationValueProviderForHorizontalLineAnnotation() {
        // <CreateAnnotationValueProviderForHorizontalLineAnnotation>
        class AnnotationValueProvider: IFormattedValueProvider {
            override fun formatValue(axisInfo: AxisInfo): CharSequence? {
                return if (axisInfo != null) String.format(
                    " $ %s $",
                    axisInfo.axisFormattedDataValue
                ) else null
            }
        }
        // </CreateAnnotationValueProviderForHorizontalLineAnnotation>

        // <UseAnnotationValueProviderForHorizontalLineAnnotation>
        val horizontalLine = HorizontalLineAnnotation(context)
        horizontalLine.x1 = 10.0
        horizontalLine.y1 = 34.512
        horizontalLine.setIsEditable(true)
        horizontalLine.horizontalGravity = Gravity.END
        // Provide custom IFormattedValueProvider for the annotation
        horizontalLine.formattedLabelValueProvider = AnnotationValueProvider()

        val axisAnnotationLabel = AnnotationLabel(context)
        axisAnnotationLabel.labelPlacement = LabelPlacement.Axis

        horizontalLine.annotationLabels.add(axisAnnotationLabel)
        // </UseAnnotationValueProviderForHorizontalLineAnnotation>
    }
}
