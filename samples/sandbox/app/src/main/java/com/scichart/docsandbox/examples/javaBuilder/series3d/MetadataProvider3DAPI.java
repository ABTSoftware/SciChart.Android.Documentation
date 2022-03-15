package com.scichart.docsandbox.examples.javaBuilder.series3d;

import androidx.annotation.NonNull;

import com.scichart.charting3d.model.dataSeries.xyz.XyzDataSeries3D;
import com.scichart.charting3d.visuals.SciChartSurface3D;
import com.scichart.charting3d.visuals.axes.NumericAxis3D;
import com.scichart.charting3d.visuals.pointMarkers.SpherePointMarker3D;
import com.scichart.charting3d.visuals.renderableSeries.XyzRenderPassData3D;
import com.scichart.charting3d.visuals.renderableSeries.metadataProviders.IPointMetadataProvider3D;
import com.scichart.charting3d.visuals.renderableSeries.metadataProviders.IStrokeMetadataProvider3D;
import com.scichart.charting3d.visuals.renderableSeries.metadataProviders.MetadataProvider3DBase;
import com.scichart.charting3d.visuals.renderableSeries.pointLine.PointLineRenderableSeries3D;
import com.scichart.core.framework.UpdateSuspender;
import com.scichart.core.model.DoubleValues;
import com.scichart.core.model.FloatValues;
import com.scichart.core.model.IntegerValues;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart3DFragment;

@ExampleDefinition()
public class MetadataProvider3DAPI extends SingleChart3DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface3D surface) {
        createCustomMetadataProvider(surface);
    }

    void createCustomMetadataProvider(@NonNull SciChartSurface3D surface) {
        // <CreateCustomMetadataProvider>
        class CustomMetadataProvider extends MetadataProvider3DBase<PointLineRenderableSeries3D> implements IPointMetadataProvider3D, IStrokeMetadataProvider3D {
            CustomMetadataProvider() {
                super(PointLineRenderableSeries3D.class);
            }

            @Override
            public void updateStrokeColors(IntegerValues integerValues, int i) {
                updateColors(integerValues);
            }

            @Override
            public void updatePointMetadata(IntegerValues integerValues, FloatValues floatValues, int i, float v) {
                updateColors(integerValues);

                final int pointsCount = renderableSeries.getCurrentRenderPassData().getPointsCount();
                floatValues.setSize(pointsCount);

                for (int x = 0; x < pointsCount; x++) {
                    floatValues.set(i, 1);
                }
            }

            void updateColors(IntegerValues colors) {
                PointLineRenderableSeries3D rSeries = renderableSeries;
                XyzRenderPassData3D renderPassData = (XyzRenderPassData3D)rSeries.getCurrentRenderPassData();

                double upperThreshold = rSeries.getParentSurface().getCamera().getOrbitalYaw() % 90;
                double lowerThreshold = rSeries.getParentSurface().getCamera().getOrbitalPitch() % 90;

                int pointsCount = renderPassData.getPointsCount();
                colors.setSize(pointsCount);

                final DoubleValues yValues = renderPassData.yValues;

                for (int i = 0; i < pointsCount; i++) {
                    double value = yValues.get(i);
                    if (value > upperThreshold) {
                        colors.set(i, 0xffff0000);
                    } else if (value < lowerThreshold) {
                        colors.set(i, 0xff00ff00);
                    } else {
                        colors.set(i, 0xffffff00);
                    }
                }
            }
        }
        // </CreateCustomMetadataProvider>

        // <SetCustomMetadataProvider>
        final NumericAxis3D xAxis = sciChart3DBuilder.newNumericAxis3D().withGrowBy(.1, .1).build();
        final NumericAxis3D yAxis = sciChart3DBuilder.newNumericAxis3D().withGrowBy(.1, .1).build();
        final NumericAxis3D zAxis = sciChart3DBuilder.newNumericAxis3D().withGrowBy(.1, .1).build();

        final XyzDataSeries3D<Double, Double, Double> ds = new XyzDataSeries3D<>(Double.class, Double.class, Double.class);
        for (int i = 0; i < 100; i++) {
            final double x = 5 * Math.sin(i);
            final double y = i;
            final double z = 5 * Math.cos(i);
            ds.append(x, y, z);
        }

        final SpherePointMarker3D pointMarker = sciChart3DBuilder.newSpherePointMarker3D()
                .withSize(5f)
                .build();

        final PointLineRenderableSeries3D rs = sciChart3DBuilder.newPointLinesSeries3D()
                .withDataSeries(ds)
                .withStrokeThicknes(2f)
                .withPointMarker(pointMarker)
                .withMetadataProvider(new CustomMetadataProvider())
                .build();

        UpdateSuspender.using(surface, () -> {
            surface.setXAxis(xAxis);
            surface.setYAxis(yAxis);
            surface.setZAxis(zAxis);
            surface.getRenderableSeries().add(rs);
            surface.getChartModifiers().add(createDefaultModifiers3D());
        });
        // </SetCustomMetadataProvider>
    }
}
