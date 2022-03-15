package com.scichart.docsandbox.examples.java.annotationsAPIs;

import android.graphics.Color;
import android.view.Gravity;

import androidx.annotation.NonNull;

import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.annotations.AnnotationCoordinateMode;
import com.scichart.charting.visuals.annotations.AnnotationLabel;
import com.scichart.charting.visuals.annotations.HorizontalLineAnnotation;
import com.scichart.charting.visuals.annotations.IFormattedValueProvider;
import com.scichart.charting.visuals.annotations.LabelPlacement;
import com.scichart.charting.visuals.axes.AxisInfo;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;
import com.scichart.drawing.common.FontStyle;
import com.scichart.drawing.common.SolidPenStyle;

import java.util.Collections;

@ExampleDefinition()
public class HorizontalLineAnnotationFragment extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) { }

    void addHorizontalLineAnnotation(@NonNull SciChartSurface surface) {
        // <AddHorizontalLineAnnotation>
        // Assume a surface has been created and configured somewhere
        // Create a HorizontalLine Annotation
        final HorizontalLineAnnotation horizontalLine = new HorizontalLineAnnotation(getContext());

        // Allow to interact with the annotation in run-time
        horizontalLine.setIsEditable(true);

        // In a multi-axis scenario, specify the XAxisId and YAxisId
        horizontalLine.setXAxisId("TopAxisId");
        horizontalLine.setYAxisId("RightAxisId");

        // Specify a desired position by setting coordinates and mode
        horizontalLine.setCoordinateMode(AnnotationCoordinateMode.RelativeY);
        horizontalLine.setY1(0.1);

        // Specify the border color for the annotation
        horizontalLine.setStroke(new SolidPenStyle(0xFFFC9C29, true, 2f, null));

        // Add the annotation to the Annotations collection of the surface
        surface.getAnnotations().add(horizontalLine);
        // </AddHorizontalLineAnnotation>

        // <AddHorizontalLineAnnotationLabel>
        final AnnotationLabel annotationLabel = new AnnotationLabel(getContext());
        annotationLabel.setText("Label text");
        annotationLabel.setLabelPlacement(LabelPlacement.Axis);
        horizontalLine.annotationLabels.add(annotationLabel);
        // </AddHorizontalLineAnnotationLabel>
    }

    void addAnnotationLabelsToHorizontalLineAnnotation() {
        // <AddAnnotationLabelsToHorizontalLineAnnotation>
        final HorizontalLineAnnotation horizontalLine = new HorizontalLineAnnotation(getContext());
        horizontalLine.setX1(10.0d);
        horizontalLine.setY1(34.512d);
        horizontalLine.setIsEditable(true);
        horizontalLine.setHorizontalGravity(Gravity.END);
        horizontalLine.setStroke(new SolidPenStyle(Color.RED, true, 2f, null));

        AnnotationLabel axisAnnotationLabel = new AnnotationLabel(getContext());
        axisAnnotationLabel.setLabelPlacement(LabelPlacement.Axis);
        axisAnnotationLabel.setRotationAngle(-10);
        axisAnnotationLabel.setPadding(10, 0, 0, 0);

        AnnotationLabel annotationLabel = new AnnotationLabel(getContext());
        annotationLabel.setLabelPlacement(LabelPlacement.TopLeft);
        annotationLabel.setText("Whatever Label");
        annotationLabel.setFontStyle(new FontStyle(25, Color.YELLOW));

        Collections.addAll(horizontalLine.annotationLabels, annotationLabel, axisAnnotationLabel);
        // </AddAnnotationLabelsToHorizontalLineAnnotation>
    }

    void createAnnotationValueProviderForHorizontalLineAnnotation() {
        // <CreateAnnotationValueProviderForHorizontalLineAnnotation>
        class AnnotationValueProvider implements IFormattedValueProvider {
            @Override
            public CharSequence formatValue(AxisInfo axisInfo) {
                return axisInfo != null ? String.format(" $ %s $", axisInfo.axisFormattedDataValue) : null;
            }
        }
        // </CreateAnnotationValueProviderForHorizontalLineAnnotation>

        // <UseAnnotationValueProviderForHorizontalLineAnnotation>
        final HorizontalLineAnnotation horizontalLine = new HorizontalLineAnnotation(getContext());
        horizontalLine.setX1(10.0d);
        horizontalLine.setY1(34.512d);
        horizontalLine.setIsEditable(true);
        horizontalLine.setHorizontalGravity(Gravity.END);
        // Provide custom IFormattedValueProvider for the annotation
        horizontalLine.setFormattedLabelValueProvider(new AnnotationValueProvider());

        AnnotationLabel axisAnnotationLabel = new AnnotationLabel(getContext());
        axisAnnotationLabel.setLabelPlacement(LabelPlacement.Axis);

        horizontalLine.annotationLabels.add(axisAnnotationLabel);
        // </UseAnnotationValueProviderForHorizontalLineAnnotation>
    }
}
