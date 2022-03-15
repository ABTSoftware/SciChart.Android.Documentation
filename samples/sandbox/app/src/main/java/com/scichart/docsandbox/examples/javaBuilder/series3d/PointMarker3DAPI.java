package com.scichart.docsandbox.examples.javaBuilder.series3d;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import androidx.annotation.NonNull;

import com.scichart.charting3d.visuals.SciChartSurface3D;
import com.scichart.charting3d.visuals.pointMarkers.CustomPointMarker3D;
import com.scichart.charting3d.visuals.pointMarkers.SpherePointMarker3D;
import com.scichart.charting3d.visuals.renderableSeries.pointLine.PointLineRenderableSeries3D;
import com.scichart.charting3d.visuals.renderableSeries.scatter.ScatterRenderableSeries3D;
import com.scichart.docsandbox.R;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart3DFragment;

@ExampleDefinition()
public class PointMarker3DAPI extends SingleChart3DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface3D surface) {
        createPointMarker3D();
    }

    void createPointMarker3D() {
        // <CreatePointMarker3D>
        // Create a Sphere PointMarker 3D instance
        final SpherePointMarker3D pointMarker = sciChart3DBuilder.newSpherePointMarker3D()
                .withFill(0xFFFF0000)
                .withSize(25)
                .build();

        // Apply the PointMarker to a PointLine Series 3D
        final PointLineRenderableSeries3D rs = sciChart3DBuilder.newPointLinesSeries3D()
                .withPointMarker(pointMarker)
                .build();
        // </CreatePointMarker3D>
    }

    void createCustomPointMarker3D() {
        // <CreateCustomPointMarker3D>
        // Create custom PointMarker 3D
        final Bitmap bitmap = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.example_weather_storm);
        CustomPointMarker3D pointMarker = sciChart3DBuilder.newCustomPointMarker3D(bitmap)
                .withSize(10)
                .build();

        // Apply the PointMarker to a PointLine Series 3D
        final ScatterRenderableSeries3D rs = sciChart3DBuilder.newScatterSeries3D()
                .withPointMarker(pointMarker)
                .build();
        // </CreateCustomPointMarker3D>
    }
}
