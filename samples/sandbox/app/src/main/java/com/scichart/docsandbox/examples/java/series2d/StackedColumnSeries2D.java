package com.scichart.docsandbox.examples.java.series2d;

import android.graphics.Color;

import androidx.annotation.NonNull;

import com.scichart.charting.model.dataSeries.IXyDataSeries;
import com.scichart.charting.model.dataSeries.XyDataSeries;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.axes.NumericAxis;
import com.scichart.charting.visuals.renderableSeries.HorizontallyStackedColumnsCollection;
import com.scichart.charting.visuals.renderableSeries.StackedColumnRenderableSeries;
import com.scichart.charting.visuals.renderableSeries.VerticallyStackedColumnsCollection;
import com.scichart.core.framework.UpdateSuspender;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;
import com.scichart.drawing.common.SolidBrushStyle;
import com.scichart.drawing.common.SolidPenStyle;

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
        final IXyDataSeries<Double, Double> ds1 = new XyDataSeries<>(Double.class, Double.class);
        final IXyDataSeries<Double, Double> ds2 = new XyDataSeries<>(Double.class, Double.class);
        final IXyDataSeries<Double, Double> ds3 = new XyDataSeries<>(Double.class, Double.class);
        final IXyDataSeries<Double, Double> ds4 = new XyDataSeries<>(Double.class, Double.class);
        final IXyDataSeries<Double, Double> ds5 = new XyDataSeries<>(Double.class, Double.class);
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
        final StackedColumnRenderableSeries porkSeries = createStackedColumn(ds1, 0xff226fb7);
        final StackedColumnRenderableSeries vealSeries = createStackedColumn(ds2, 0xffff9a2e);
        final StackedColumnRenderableSeries tomatoSeries = createStackedColumn(ds3, 0xffdc443f);
        final StackedColumnRenderableSeries cucumberSeries = createStackedColumn(ds4, 0xffaad34f);
        final StackedColumnRenderableSeries pepperSeries = createStackedColumn(ds5, 0xff8562b4);

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
            Collections.addAll(surface.getXAxes(), new NumericAxis(requireContext()));
            Collections.addAll(surface.getYAxes(), new NumericAxis(requireContext()));

            Collections.addAll(surface.getRenderableSeries(), columnsCollection);
        });
    }

    private StackedColumnRenderableSeries createStackedColumn(IXyDataSeries<Double, Double> dataSeries, int fill) {
        final StackedColumnRenderableSeries stackedColumnSeries = new StackedColumnRenderableSeries();

        stackedColumnSeries.setDataSeries(dataSeries);
        stackedColumnSeries.setFillBrushStyle(new SolidBrushStyle(fill));
        stackedColumnSeries.setStrokeStyle(new SolidPenStyle(Color.TRANSPARENT, true, 0f, null));

        return stackedColumnSeries;
    }
    // </Example>
}
