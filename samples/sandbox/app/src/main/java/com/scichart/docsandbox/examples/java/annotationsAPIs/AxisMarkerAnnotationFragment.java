package com.scichart.docsandbox.examples.java.annotationsAPIs;

import androidx.annotation.NonNull;

import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.annotations.AxisMarkerAnnotation;
import com.scichart.charting.visuals.annotations.IFormattedValueProvider;
import com.scichart.charting.visuals.axes.AxisInfo;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;

@ExampleDefinition()
public class AxisMarkerAnnotationFragment extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) { }

    void addAxisMarkerAnnotation(@NonNull SciChartSurface surface) {
        // <AddAxisMarkerAnnotation>
        // Assume a surface has been created and configured somewhere
        // Create an AxisMarkerAnnotation
        final AxisMarkerAnnotation rightMarker = new AxisMarkerAnnotation(getContext());

        // Specify a desired position by setting the Y1 coordinate, since the marker is going to be located on an Y axis
        rightMarker.setY1(8);

        // Allow to interact with the annotation in run-time
        rightMarker.setIsEditable(true);

        // In a multi-axis scenario, specify the XAxisId and YAxisId
        rightMarker.setXAxisId("BottomAxisId");
        rightMarker.setYAxisId("RightAxisId");

        // Specify the background color for the marker
        rightMarker.setBackgroundColor(0xAA4083B7);

        // Add the annotation to the Annotations collection of the surface
        surface.getAnnotations().add(rightMarker);
        // </AddAxisMarkerAnnotation>

        // <SetAnnotationValueProvider>
        // Provide custom IFormattedValueProvider for the annotation
        rightMarker.setFormattedValueProvider(new AnnotationValueProvider());
        // </SetAnnotationValueProvider>
    }

    // <CreateAnnotationValueProviderForAxisMarkerAnnotation>
    // Declare custom IFormattedValueProvider
    class AnnotationValueProvider implements IFormattedValueProvider {
        @Override
        public CharSequence formatValue(AxisInfo axisInfo) {
            return axisInfo != null ? String.format("[ --- %s --- ]", axisInfo.axisFormattedDataValue) : null;
        }
    }
    // </CreateAnnotationValueProviderForAxisMarkerAnnotation>
}
