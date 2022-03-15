package com.scichart.docsandbox.examples.javaBuilder.annotationsAPIs;

import androidx.annotation.NonNull;

import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.annotations.AnnotationSurfaceEnum;
import com.scichart.charting.visuals.annotations.AxisLabelAnnotation;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;
import com.scichart.drawing.common.FontStyle;

@ExampleDefinition()
public class AxisLabelAnnotationFragment extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) { }

    void addAxisLabelAnnotation(@NonNull SciChartSurface surface) {
        // <AddAxisLabelAnnotation>
        // Assume a surface has been created and configured somewhere
        // Create CustomAnnotation instance
        AxisLabelAnnotation axisLabelAnnotation = new AxisLabelAnnotation(getContext());

        // Set the text
        axisLabelAnnotation.setText("Axis Label can be Rotated");

        // Specify a FontStyle for the text
        axisLabelAnnotation.setFontStyle(new FontStyle(20, 0xFFFF1919));

        // Specify rotation Angle in Degrees if needed
        axisLabelAnnotation.setRotationAngle(-30);

        // Specify a desired position by setting the X1 coordinate, since the marker is going to be located on an X axis
        axisLabelAnnotation.setX1(60);

        // Specify the desired Axis to place annotation on via AnnotationSurface
        axisLabelAnnotation.setAnnotationSurface(AnnotationSurfaceEnum.XAxis);

        // Allow to interact with the annotation in run-time
        axisLabelAnnotation.setIsEditable(true);

        // In a multi-axis scenario, specify the XAxisId and YAxisId
        axisLabelAnnotation.setXAxisId("BottomAxisId");
        axisLabelAnnotation.setYAxisId("LeftAxisId");

        // Add the annotation to the Annotations collection of the surface
        surface.getAnnotations().add(axisLabelAnnotation);
        // </AddAxisLabelAnnotation>
    }
}
