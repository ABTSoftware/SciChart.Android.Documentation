package com.scichart.docsandbox.examples.javaBuilder.axisAPIs;

import androidx.annotation.NonNull;

import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.model.dataSeries.OhlcDataSeries;
import com.scichart.charting.numerics.indexDataProvider.DataSeriesIndexDataProvider;
import com.scichart.charting.numerics.indexDataProvider.IIndexDataProvider;
import com.scichart.charting.visuals.axes.IndexDateAxis;
import com.scichart.charting.visuals.axes.ScientificNotation;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;

import java.util.Calendar;
import java.util.Date;

@ExampleDefinition()
public class AxisAPIsIndexDateAxis extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) { }

    void addIndexDateAxis() {
        // <IndexDateAxis>
        OhlcDataSeries dataSeries = new OhlcDataSeries(Date.class, Double.class);
        IIndexDataProvider indexDataProvider = new DataSeriesIndexDataProvider(dataSeries);


        IndexDateAxis indexDateAxis = sciChartBuilder
                .newIndexDateAxis()
                .withIndexDataProvider(indexDataProvider)
                .build();
        // </IndexDateAxis>
    }

    
}
