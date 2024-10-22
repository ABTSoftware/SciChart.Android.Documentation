package com.scichart.docsandbox.examples.java.annotationsAPIs;

import androidx.annotation.NonNull;

import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.annotations.ImageAnnotation;
import com.scichart.charting.visuals.annotations.AnnotationSurfaceEnum;
import com.scichart.charting.visuals.annotations.ContentModeEnum;
import com.scichart.docsandbox.R;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;

@ExampleDefinition()
public class ImageAnnotationFragment extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) { }

    void addImageAnnotation(@NonNull SciChartSurface surface) {
        // <AddImageAnnotation>
        // Assume a surface has been created and configured somewhere
        // Create a ImageAnnotation
        final ImageAnnotation imageAnnotation = new ImageAnnotation(getContext());

        // in a multi-axis scenario, specify the XAxisId and YAxisId
        imageAnnotation.setXAxisId("TopAxisId");
        imageAnnotation.setYAxisId("LeftAxisId");

        // Specify a desired position by setting coordinates
        imageAnnotation.setX(20.0f);
        imageAnnotation.setY1(10.0f);
        imageAnnotation.setX2(90.0f);
        imageAnnotation.setY2(4.0f);

        // Specify the image resource
        imageAnnotation.setImage(R.drawable.example_image_annotation);
        
        // Specify image aspect ratio
        imageAnnotation.setContentMode(ContentModeEnum.FitXY);
        
        // Add the annotation to the AnnotationsCollection of a surface
        surface.getAnnotations().add(imageAnnotation);
        // </AddImageAnnotation>
    }
}
