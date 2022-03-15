package com.scichart.docsandbox.examples.java.series2d;

import androidx.annotation.NonNull;

import com.scichart.charting.model.dataSeries.IXyDataSeries;
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
        final IXyDataSeries<Double, Double> unsortedDataSeries = new XyDataSeries<>(Double.class, Double.class);
        unsortedDataSeries.setAcceptsUnsortedData(true);

        final FastLineRenderableSeries rSeries = new FastLineRenderableSeries();
        // Set a DataSeries with unsorted data
        rSeries.setDataSeries(unsortedDataSeries);

        // Switch off Resampling because the DataSeries is unsorted
        rSeries.setResamplingMode(ResamplingMode.None);
        // </SettingResamplingMode>
    }
}
