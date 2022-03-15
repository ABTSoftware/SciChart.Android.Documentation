package com.scichart.docsandbox.examples.javaBuilder.series2d;

import android.graphics.Color;

import androidx.annotation.NonNull;

import com.scichart.charting.model.dataSeries.XyDataSeries;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.annotations.HorizontalLineAnnotation;
import com.scichart.charting.visuals.annotations.IAnnotation;
import com.scichart.charting.visuals.axes.NumericAxis;
import com.scichart.charting.visuals.pointmarkers.EllipsePointMarker;
import com.scichart.charting.visuals.renderableSeries.FastLineRenderableSeries;
import com.scichart.charting.visuals.renderableSeries.FastMountainRenderableSeries;
import com.scichart.charting.visuals.renderableSeries.XyRenderableSeriesBase;
import com.scichart.charting.visuals.renderableSeries.XyScatterRenderableSeries;
import com.scichart.charting.visuals.renderableSeries.data.XyRenderPassData;
import com.scichart.charting.visuals.renderableSeries.paletteProviders.IFillPaletteProvider;
import com.scichart.charting.visuals.renderableSeries.paletteProviders.IPointMarkerPaletteProvider;
import com.scichart.charting.visuals.renderableSeries.paletteProviders.IStrokePaletteProvider;
import com.scichart.charting.visuals.renderableSeries.paletteProviders.PaletteProviderBase;
import com.scichart.core.framework.UpdateSuspender;
import com.scichart.core.model.DoubleValues;
import com.scichart.core.model.IntegerValues;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.DataManager;
import com.scichart.docsandbox.examples.base.DoubleSeries;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;

import java.util.Collections;

@ExampleDefinition()
public class PaletteProviderAPI extends SingleChart2DFragment {
    final DataManager dataManager = new DataManager();

    @Override
    protected void initExample(@NonNull SciChartSurface surface) {
        usePaletteProvider(surface);
    }

    // <CreatePaletteProvider>
    final class SharedPaletteProvider extends PaletteProviderBase<XyRenderableSeriesBase> implements IFillPaletteProvider, IStrokePaletteProvider, IPointMarkerPaletteProvider {
        private final IntegerValues strokeColors = new IntegerValues();
        private final IntegerValues fillColors = new IntegerValues();

        private IAnnotation lowerLimit;
        private IAnnotation upperLimit;

        public SharedPaletteProvider(IAnnotation lowerLimit, IAnnotation upperLimit) {
            super(XyRenderableSeriesBase.class);

            this.lowerLimit = lowerLimit;
            this.upperLimit = upperLimit;
        }

        @Override
        public void update() {
            final double y1 = (Double) lowerLimit.getY1();
            final double y2 = (Double) upperLimit.getY2();

            final double minimum = Math.min(y1, y2);
            final double maximum = Math.max(y1, y2);

            final XyRenderPassData renderPassData = (XyRenderPassData) renderableSeries.getCurrentRenderPassData();
            final int size = renderPassData.pointsCount();
            strokeColors.setSize(size);
            fillColors.setSize(size);

            DoubleValues yValues = renderPassData.yValues;
            for (int i = 0; i < size; i++) {
                final double value = yValues.get(i);
                if (value > maximum) {
                    strokeColors.set(i, 0xffff0000);
                    fillColors.set(i, 0xffff0000);
                } else if (value < minimum) {
                    strokeColors.set(i, 0xff00ff00);
                    fillColors.set(i, 0x9900ff00);
                } else {
                    strokeColors.set(i, 0xffffff00);
                    fillColors.set(i, 0x99ffff00);
                }
            }
        }

        @Override
        public IntegerValues getStrokeColors() { return strokeColors; }

        @Override
        public IntegerValues getFillColors() { return fillColors; }

        @Override
        public IntegerValues getPointMarkerColors() { return fillColors; }

    }
    // </CreatePaletteProvider>

    void usePaletteProvider(@NonNull SciChartSurface surface) {
        // <UsePaletteProvider>
        final NumericAxis xAxis = sciChartBuilder.newNumericAxis()
                .withGrowBy(0.1, 0.1)
                .build();

        final NumericAxis yAxis = sciChartBuilder.newNumericAxis()
                .withGrowBy(0.1, 0.1)
                .build();

        final HorizontalLineAnnotation upperLimit = sciChartBuilder.newHorizontalLineAnnotation()
                .withIsEditable(true)
                .withStroke(2f, Color.RED)
                .withY1(2.7)
                .build();

        final HorizontalLineAnnotation lowerLimit = sciChartBuilder.newHorizontalLineAnnotation()
                .withIsEditable(true)
                .withStroke(2f, Color.GREEN)
                .withY1(2.5)
                .build();

        DoubleSeries data1 = dataManager.getFourierSeries(1.0, 0.1, 5.02, 5.4, 5000);
        DoubleSeries data2 = dataManager.getFourierSeries(1.0, 0.1, 6.02, 6.4, 5000);
        DoubleSeries data3 = dataManager.getFourierSeries(1.0, 0.1, 7.02, 7.4, 5000);

        final XyDataSeries dataSeries1 = new XyDataSeries(Double.class, Double.class);
        final XyDataSeries dataSeries2 = new XyDataSeries(Double.class, Double.class);
        final XyDataSeries dataSeries3 = new XyDataSeries(Double.class, Double.class);

        dataSeries1.append(data1.xValues, data1.yValues);
        dataSeries2.append(data2.xValues, data2.yValues);
        dataSeries3.append(data3.xValues, data3.yValues);

        final SharedPaletteProvider sharedPaletteProvider = new SharedPaletteProvider(lowerLimit, upperLimit);

        final FastLineRenderableSeries lineSeries = sciChartBuilder.newLineSeries()
                .withPaletteProvider(sharedPaletteProvider)
                .withDataSeries(dataSeries1)
                .withStrokeStyle(0xFF279B27, 1.0f)
                .build();

        final EllipsePointMarker marker = sciChartBuilder.newPointMarker(new EllipsePointMarker())
                .withSize(20)
                .withStroke(Color.BLUE, 3f)
                .withFill(Color.BLUE)
                .build();

        final XyScatterRenderableSeries scatterSeries = sciChartBuilder.newScatterSeries()
                .withPointMarker(marker)
                .withPaletteProvider(sharedPaletteProvider)
                .withDataSeries(dataSeries2)
                .withStrokeStyle(0xFF279B27, 1.0f)
                .build();

        final FastMountainRenderableSeries mountainSeries = sciChartBuilder.newMountainSeries()
                .withPaletteProvider(sharedPaletteProvider)
                .withDataSeries(dataSeries3)
                .withStrokeStyle(0xFF279B27, 1.0f)
                .build();

        UpdateSuspender.using(surface, () -> {
            surface.getXAxes().add(xAxis);
            surface.getYAxes().add(yAxis);
            Collections.addAll(surface.getRenderableSeries(), lineSeries, scatterSeries, mountainSeries);
            Collections.addAll(surface.getAnnotations(), lowerLimit, upperLimit);
            surface.getChartModifiers().add(createDefaultModifiers());
        });
        // </UsePaletteProvider>
    }
}
