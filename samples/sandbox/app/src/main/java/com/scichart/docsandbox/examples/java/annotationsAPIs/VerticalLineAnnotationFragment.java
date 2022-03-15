package com.scichart.docsandbox.examples.java.annotationsAPIs;

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
import com.scichart.drawing.common.SolidPenStyle;

import java.util.Collections;

@ExampleDefinition()
public class VerticalLineAnnotationFragment extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) { }

    void addVerticalLineAnnotation(@NonNull SciChartSurface surface) {
        // <AddVerticalLineAnnotation>
        // Assume a surface has been created and configured somewhere
        // Create a VerticalLine Annotation
        final VerticalLineAnnotation verticalLine = new VerticalLineAnnotation(getContext());

        // Allow to interact with the annotation in run-time
        verticalLine.setIsEditable(true);

        // In a multi-axis scenario, specify the XAxisId and YAxisId
        verticalLine.setXAxisId("BottomAxisId");
        verticalLine.setYAxisId("RightAxisId");

        // Specify a desired position by setting coordinates and mode
        verticalLine.setCoordinateMode(AnnotationCoordinateMode.RelativeX);
        verticalLine.setY1(0.1);

        // Specify the border color for the annotation
        verticalLine.setStroke(new SolidPenStyle(0xFFFF1919, true, 2f, null));

        // Add the annotation to the Annotations collection of the surface
        surface.getAnnotations().add(verticalLine);
        // </AddVerticalLineAnnotation>

        // <AddVerticalLineAnnotationLabel>
        final AnnotationLabel annotationLabel = new AnnotationLabel(getContext());
        annotationLabel.setText("Label text");
        annotationLabel.setLabelPlacement(LabelPlacement.Axis);
        verticalLine.annotationLabels.add(annotationLabel);
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

        final VerticalLineAnnotation verticalLine = new VerticalLineAnnotation(getContext());
        verticalLine.setY1(8);
        verticalLine.setVerticalGravity(Gravity.BOTTOM);

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
        final VerticalLineAnnotation verticalLine = new VerticalLineAnnotation(getContext());
        verticalLine.setXAxisId("BottomAxisId");
        verticalLine.setYAxisId("RightAxisId");
        verticalLine.setX1(65);
        verticalLine.setStroke(new SolidPenStyle(0xFFFF1919, true, 4f, null));
        // Provide custom IFormattedValueProvider for the annotation
        verticalLine.setFormattedLabelValueProvider(new AnnotationValueProvider());

        AnnotationLabel axisAnnotationLabel = new AnnotationLabel(getContext());
        axisAnnotationLabel.setLabelPlacement(LabelPlacement.Axis);

        verticalLine.annotationLabels.add(axisAnnotationLabel);
        // </UseAnnotationValueProviderForVerticalLineAnnotation>
    }
}
