package com.scichart.docsandbox.examples.javaBuilder.annotationsAPIs;

import androidx.annotation.NonNull;

import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.annotations.ImageAnnotation;
import com.scichart.docsandbox.R;
import android.widget.ImageView;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;

@ExampleDefinition()
public class ImageAnnotationFragment extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) { }

    void addBoxAnnotation(@NonNull SciChartSurface surface) {
        // <AddImageAnnotation>
        // Assume a surface has been created and configured somewhere
        // Create a ImageAnnotation
        ImageAnnotation boxAnnotation = sciChartBuilder.newImageAnnotation()
                // in a multi-axis scenario, specify the XAxisId and YAxisId
                .withXAxisId("TopAxisId")
                .withYAxisId("LeftAxisId")
                // Specify a desired position by setting coordinates
                .withPosition(20.0f, 10.0f, 90.0f, 4.0f)
                // Specify the image resource
                .withImage(R.drawable.example_weather_storm)
                // Specify the image aspect ratio
                .withContentMode(ImageView.ScaleType.FIT_XY)
                .build();

        // Add the annotation to the AnnotationsCollection of a surface
        surface.getAnnotations().add(boxAnnotation);
        // </AddImageAnnotation>
    }
}
