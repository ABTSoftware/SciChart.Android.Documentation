package com.scichart.docsandbox.examples.javaBuilder.series2d;

import androidx.annotation.NonNull;

import com.scichart.charting.model.dataSeries.IXyDataSeries;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.renderableSeries.HorizontallyStackedColumnsCollection;
import com.scichart.charting.visuals.renderableSeries.StackedColumnRenderableSeries;
import com.scichart.charting.visuals.renderableSeries.VerticallyStackedColumnsCollection;
import com.scichart.core.framework.UpdateSuspender;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;

import java.util.Collections;

@ExampleDefinition()
public class StackedColumnSeries2D extends SingleChart2DFragment {
    // <Example>
    @Override
    protected void initExample(@NonNull SciChartSurface surface) {
        // declare arrays with data to append
        final double[] porkData = new double[]{10, 13, 7, 16, 4, 6, 20, 14, 16, 10, 24, 11};
        final double[] vealData = new double[]{12, 17, 21, 15, 19, 18, 13, 21, 22, 20, 5, 10};
        final double[] tomatoesData = new double[]{7, 30, 27, 24, 21, 15, 17, 26, 22, 28, 21, 22};
        final double[] cucumberData = new double[]{16, 10, 9, 8, 22, 14, 12, 27, 25, 23, 17, 17};
        final double[] pepperData = new double[]{7, 24, 21, 11, 19, 17, 14, 27, 26, 22, 28, 16};

        // declare and append data into data series
        final IXyDataSeries<Double, Double> ds1 = sciChartBuilder.newXyDataSeries(Double.class, Double.class).build();
        final IXyDataSeries<Double, Double> ds2 = sciChartBuilder.newXyDataSeries(Double.class, Double.class).build();
        final IXyDataSeries<Double, Double> ds3 = sciChartBuilder.newXyDataSeries(Double.class, Double.class).build();
        final IXyDataSeries<Double, Double> ds4 = sciChartBuilder.newXyDataSeries(Double.class, Double.class).build();
        final IXyDataSeries<Double, Double> ds5 = sciChartBuilder.newXyDataSeries(Double.class, Double.class).build();
        final int data = 1992;
        for (int i = 0; i < porkData.length; i++) {
            double xValue = data + i;
            ds1.append(xValue, porkData[i]);
            ds2.append(xValue, vealData[i]);
            ds3.append(xValue, tomatoesData[i]);
            ds4.append(xValue, cucumberData[i]);
            ds5.append(xValue, pepperData[i]);
        }

        // declare few StackedColumnRenderableSeries and assign data series to draw
        final StackedColumnRenderableSeries porkSeries = sciChartBuilder.newStackedColumn().withDataSeries(ds1).withFillColor(0xff226fb7).withStrokeStyle(0xff22579D, 0f).build();
        final StackedColumnRenderableSeries vealSeries = sciChartBuilder.newStackedColumn().withDataSeries(ds2).withFillColor(0xffff9a2e).withStrokeStyle(0xffBE642D, 0f).build();
        final StackedColumnRenderableSeries tomatoSeries = sciChartBuilder.newStackedColumn().withDataSeries(ds3).withFillColor(0xffdc443f).withStrokeStyle(0xffA33631, 0f).build();
        final StackedColumnRenderableSeries cucumberSeries = sciChartBuilder.newStackedColumn().withDataSeries(ds4).withFillColor(0xffaad34f).withStrokeStyle(0xff73953D, 0f).build();
        final StackedColumnRenderableSeries pepperSeries = sciChartBuilder.newStackedColumn().withDataSeries(ds5).withFillColor(0xff8562b4).withStrokeStyle(0xff64458A, 0f).build();

        // wrap porkSeries and vealSeries into VerticallyStackedColumnCollection to stack them vertically
        final VerticallyStackedColumnsCollection verticalCollection1 = new VerticallyStackedColumnsCollection();
        verticalCollection1.add(porkSeries);
        verticalCollection1.add(vealSeries);

        // wrap cucumberSeries, cucumberSeries and pepperSeriesinto VerticallyStackedColumnCollection to stack them vertically
        final VerticallyStackedColumnsCollection verticalCollection2 = new VerticallyStackedColumnsCollection();
        verticalCollection2.add(tomatoSeries);
        verticalCollection2.add(cucumberSeries);
        verticalCollection2.add(pepperSeries);

        // wrap previously created VerticallyStackedColumnCollection into HorizontallyStackedColumnsCollection to stack resulting series horizontally
        final HorizontallyStackedColumnsCollection columnsCollection = new HorizontallyStackedColumnsCollection();
        columnsCollection.setSpacing(0f);
        columnsCollection.add(verticalCollection1);
        columnsCollection.add(verticalCollection2);

        UpdateSuspender.using(surface, () -> {
            Collections.addAll(surface.getXAxes(), sciChartBuilder.newNumericAxis().build());
            Collections.addAll(surface.getYAxes(), sciChartBuilder.newNumericAxis().build());

            Collections.addAll(surface.getRenderableSeries(), columnsCollection);
        });
    }
    // </Example>
}
