package com.scichart.docsandbox.examples.javaBuilder.series2d;

import androidx.annotation.NonNull;

import com.scichart.charting.model.dataSeries.IXyDataSeries;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.renderableSeries.StackedMountainRenderableSeries;
import com.scichart.charting.visuals.renderableSeries.VerticallyStackedMountainsCollection;
import com.scichart.core.framework.UpdateSuspender;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;

import java.util.Collections;

@ExampleDefinition()
public class StackedMountainSeries2D extends SingleChart2DFragment {
    // <Example>
    @Override
    protected void initExample(@NonNull SciChartSurface surface) {
        // declare arrays with data to append
        final double[] yValues1 = new double[] { 4.0,  7,    5.2,  9.4,  3.8,  5.1, 7.5,  12.4, 14.6, 8.1, 11.7, 14.4, 16.0, 3.7, 5.1, 6.4, 3.5, 2.5, 12.4, 16.4, 7.1, 8.0, 9.0 };
        final double[] yValues2 = new double[] { 15.0, 10.1, 10.2, 10.4, 10.8, 1.1, 11.5, 3.4,  4.6,  0.1, 1.7, 14.4, 6.0, 13.7, 10.1, 8.4, 8.5, 12.5, 1.4, 0.4, 10.1, 5.0, 1.0 };

        // declare and append data into data series
        final IXyDataSeries<Double, Double> ds1 = sciChartBuilder.newXyDataSeries(Double.class, Double.class).build();
        final IXyDataSeries<Double, Double> ds2 = sciChartBuilder.newXyDataSeries(Double.class, Double.class).build();

        for (int i = 0; i < yValues1.length; i++) ds1.append((double) i, yValues1[i]);
        for (int i = 0; i < yValues2.length; i++) ds2.append((double) i, yValues2[i]);

        // create few StackedMountainRenderable instances and assign data series to draw
        final StackedMountainRenderableSeries s1 = sciChartBuilder.newStackedMountain().withDataSeries(ds1).withLinearGradientColors(0xDDDBE0E1, 0x88B6C1C3).build();
        final StackedMountainRenderableSeries s2 = sciChartBuilder.newStackedMountain().withDataSeries(ds2).withLinearGradientColors(0xDDACBCCA, 0x88439AAF).build();

        // wrap declared renderable series into VerticallyStackedMountainCollection to stack them vertically
        final VerticallyStackedMountainsCollection seriesCollection = new VerticallyStackedMountainsCollection();
        seriesCollection.add(s1);
        seriesCollection.add(s2);

        UpdateSuspender.using(surface, () -> {
            Collections.addAll(surface.getXAxes(), sciChartBuilder.newNumericAxis().build());
            Collections.addAll(surface.getYAxes(), sciChartBuilder.newNumericAxis().build());

            Collections.addAll(surface.getRenderableSeries(), seriesCollection);
        });
    }
    // </Example>
}
