package com.scichart.docsandbox.examples.javaBuilder.series2d;

import androidx.annotation.NonNull;

import com.scichart.charting.model.dataSeries.XyDataSeries;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.renderableSeries.FastLineRenderableSeries;
import com.scichart.data.numerics.ResamplingMode;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;

@ExampleDefinition()
public class DataResampling extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) {
        settingResamplingMode();
    }

    void settingResamplingMode() {
        // <SettingResamplingMode>
        // Create a DataSeries with unsorted data
        final XyDataSeries unsortedDataSeries = sciChartBuilder.newXyDataSeries(Double.class, Double.class)
                .withAcceptsUnsortedData()
                .build();

        final FastLineRenderableSeries rSeries = sciChartBuilder.newLineSeries()
                // Set a DataSeries with unsorted data
                .withDataSeries(unsortedDataSeries)
                // Switch off Resampling because the DataSeries is unsorted
                .withResamplingMode(ResamplingMode.None)
                .build();
        // </SettingResamplingMode>
    }
}
