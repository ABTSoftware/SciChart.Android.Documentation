package com.scichart.docsandbox.examples.java.series3d;

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
        final SpherePointMarker3D pointMarker = new SpherePointMarker3D();
        pointMarker.setSize(25);
        pointMarker.setFill(0xFFFF0000);

        // Apply the PointMarker to a PointLine Series 3D
        final PointLineRenderableSeries3D rs = new PointLineRenderableSeries3D();
        rs.setPointMarker(pointMarker);
        // </CreatePointMarker3D>
    }

    void createCustomPointMarker3D() {
        // <CreateCustomPointMarker3D>
        // Create custom PointMarker 3D
        final Bitmap bitmap = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.example_weather_storm);
        CustomPointMarker3D pointMarker = new CustomPointMarker3D(bitmap);
        pointMarker.setSize(10);

        // Apply the PointMarker to a PointLine Series 3D
        final ScatterRenderableSeries3D rs = new ScatterRenderableSeries3D();
        rs.setPointMarker(pointMarker);
        // </CreateCustomPointMarker3D>
    }
}
