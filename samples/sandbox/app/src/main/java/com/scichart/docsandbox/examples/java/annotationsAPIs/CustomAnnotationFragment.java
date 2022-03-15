package com.scichart.docsandbox.examples.java.annotationsAPIs;

import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.annotations.CustomAnnotation;
import com.scichart.docsandbox.R;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;

@ExampleDefinition()
public class CustomAnnotationFragment extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) { }

    void addCustomAnnotation(@NonNull SciChartSurface surface) {
        // <AddCustomAnnotation>
        // assume the surface has been created and configured before
        // create a CustomAnnotation
        final CustomAnnotation customAnnotation = new CustomAnnotation(getActivity());

        // prepare an ImageView for the CustomAnnotation
        ImageView image = new ImageView(getActivity());
        image.setImageResource(R.drawable.my_custom_view);

        // supply it with ImageView
        customAnnotation.setContentView(image);

        // specify a desired position
        customAnnotation.setX1(4.2d);
        customAnnotation.setY1(2d);

        // Allow to interact with the annotation in run-time
        customAnnotation.setIsEditable(true);

        // in a multi-axis scenario, specify the XAxisId and YAxisId
        customAnnotation.setXAxisId("BottomAxisId");
        customAnnotation.setYAxisId("LeftAxisId");

        // add the annotation to the Annotations collection of the surface
        surface.getAnnotations().add(customAnnotation);
        // </AddCustomAnnotation>
    }
}
