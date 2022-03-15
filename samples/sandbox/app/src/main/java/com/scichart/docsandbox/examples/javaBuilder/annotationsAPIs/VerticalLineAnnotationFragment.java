package com.scichart.docsandbox.examples.javaBuilder.annotationsAPIs;

import android.view.Gravity;

import androidx.annotation.NonNull;

import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.annotations.AnnotationCoordinateMode;
import com.scichart.charting.visuals.annotations.AnnotationLabel;
import com.scichart.charting.visuals.annotations.IFormattedValueProvider;
import com.scichart.charting.visuals.annotations.LabelPlacement;
import com.scichart.charting.visuals.annotations.VerticalLineAnnotation;
import com.scichart.charting.visuals.axes.AxisInfo;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;

import java.util.Collections;

@ExampleDefinition()
public class VerticalLineAnnotationFragment extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) { }

    void addVerticalLineAnnotation(@NonNull SciChartSurface surface) {
        // <AddVerticalLineAnnotation>
        // Assume a surface has been created and configured somewhere
        // Create a VerticalLine Annotation
        final VerticalLineAnnotation verticalLine1 = sciChartBuilder.newVerticalLineAnnotation()
                // Allow to interact with the annotation in run-time
                .withIsEditable(true)
                // In a multi-axis scenario, specify the XAxisId and YAxisId
                .withXAxisId("BottomAxisId")
                .withYAxisId("RightAxisId")
                // Specify a desired position by setting coordinates and mode
                .withCoordinateMode(AnnotationCoordinateMode.RelativeY)
                .withX1(0.1)
                // Specify the border color for the annotation
                .withStroke(2f, 0xFFFF1919)
                .build();

        final VerticalLineAnnotation verticalLine2 = sciChartBuilder.newVerticalLineAnnotation()
                .withIsEditable(true)
                .withXAxisId("BottomAxisId")
                .withYAxisId("RightAxisId")
                .withCoordinateMode(AnnotationCoordinateMode.RelativeY)
                .withX1(0.9)
                .withStroke(2f, 0xFF279B27)
                .build();

        // Add the annotation to the Annotations collection of the surface
        Collections.addAll(surface.getAnnotations(), verticalLine1, verticalLine2);
        // </AddVerticalLineAnnotation>

        // <AddVerticalLineAnnotationLabel>
        final VerticalLineAnnotation horizontalLineWithLabel = sciChartBuilder.newVerticalLineAnnotation()
                .withAnnotationLabel(LabelPlacement.Axis, "Label text")
                .build();
        // </AddVerticalLineAnnotationLabel>
    }

    void addAnnotationLabelsToVerticalLineAnnotation() {
        // <AddAnnotationLabelsToVerticalLineAnnotation>
        AnnotationLabel axisAnnotationLabel = new AnnotationLabel(getContext());
        axisAnnotationLabel.setLabelPlacement(LabelPlacement.Axis);
        axisAnnotationLabel.setPadding(0, 10, 0, 0);

        AnnotationLabel annotationLabel = new AnnotationLabel(getContext());
        annotationLabel.setLabelPlacement(LabelPlacement.TopRight);
        annotationLabel.setText("Rotated Label");
        annotationLabel.setRotationAngle(-90);

        final VerticalLineAnnotation verticalLine = sciChartBuilder.newVerticalLineAnnotation()
                .withY1(8)
                .withVerticalGravity(Gravity.BOTTOM)
                .build();

        Collections.addAll(verticalLine.annotationLabels, annotationLabel, axisAnnotationLabel);
        // </AddAnnotationLabelsToVerticalLineAnnotation>
    }

    void createAnnotationValueProviderForVerticalLineAnnotation() {
        // <CreateAnnotationValueProviderForVerticalLineAnnotation>
        class AnnotationValueProvider implements IFormattedValueProvider {
            @Override
            public CharSequence formatValue(AxisInfo axisInfo) {
                return axisInfo != null ? String.format("[ --- %s --- ]", axisInfo.axisFormattedDataValue) : null;
            }
        }
        // </CreateAnnotationValueProviderForVerticalLineAnnotation>

        // <UseAnnotationValueProviderForVerticalLineAnnotation>
        final VerticalLineAnnotation verticalLine = sciChartBuilder.newVerticalLineAnnotation()
                .withXAxisId("BottomAxisId")
                .withYAxisId("RightAxisId")
                .withX1(65)
                .withStroke(4f, 0xFFFF1919)
                .build();

        // Provide custom IFormattedValueProvider for the annotation
        verticalLine.setFormattedLabelValueProvider(new AnnotationValueProvider());

        AnnotationLabel axisAnnotationLabel = new AnnotationLabel(getContext());
        axisAnnotationLabel.setLabelPlacement(LabelPlacement.Axis);

        verticalLine.annotationLabels.add(axisAnnotationLabel);
        // </UseAnnotationValueProviderForVerticalLineAnnotation>
    }
}
