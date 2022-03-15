package com.scichart.docsandbox.examples.javaBuilder.annotationsAPIs;

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
        // prepare an ImageView for the CustomAnnotation
        ImageView image = new ImageView(getActivity());
        image.setImageResource(R.drawable.my_custom_view);

        // create a CustomAnnotation
        CustomAnnotation customAnnotation = sciChartBuilder.newCustomAnnotation()
                // supply it with ImageView
                .withContent(image)
                // specify a desired position
                .withPosition(4.2d, 2d)
                // allow to interact with the annotation in run-time
                .withIsEditable(true)
                // in a multi-axis scenario, specify the XAxisId and YAxisId
                .withXAxisId("BottomAxisId")
                .withYAxisId("LeftAxisId")
                .build();

        // add the annotation to the Annotations collection of the surface
        surface.getAnnotations().add(customAnnotation);
        // </AddCustomAnnotation>
    }
}
