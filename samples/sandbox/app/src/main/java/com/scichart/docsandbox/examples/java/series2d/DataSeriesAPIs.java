package com.scichart.docsandbox.examples.java.series2d;

import androidx.annotation.NonNull;

import com.scichart.charting.model.dataSeries.IXyDataSeries;
import com.scichart.charting.model.dataSeries.XyDataSeries;
import com.scichart.charting.model.datadistributioncalculator.UserDefinedDistributionCalculator;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.data.model.IRange;
import com.scichart.data.model.ISciList;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;

@ExampleDefinition()
public class DataSeriesAPIs extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) {
        xYRanges();
    }

    void xYRanges() {
        // <XYRanges>
        final IXyDataSeries<Double, Double> dataSeries = new XyDataSeries<>(Double.class, Double.class);
        // Append some data here
        IRange xRange = dataSeries.getXRange();
        IRange yRange = dataSeries.getYRange();
        // You can access Min/Max directly as Double
        double min = xRange.getMinAsDouble();
        double max = xRange.getMaxAsDouble();
        // </XYRanges>
    }

    void accessingValues() {
        // <AccessingValues>
        final IXyDataSeries<Double, Double> dataSeries = new XyDataSeries<>(Double.class, Double.class);
        ISciList<Double> xValues = dataSeries.getXValues();

        // You can cast each value separately
        double value = xValues.getDoubleValue(0);
        // </AccessingValues>
    }

    void setFifoCapacity() {
        // <SetFifoCapacity>
        final IXyDataSeries<Double, Double> dataSeries = new XyDataSeries<>(Double.class, Double.class);
        dataSeries.setFifoCapacity(1000);
        // </SetFifoCapacity>
    }

    void setDataDistribution() {
        // <SetDataDistribution>
        final UserDefinedDistributionCalculator dataDistributionCalculator = new UserDefinedDistributionCalculator();
        dataDistributionCalculator.setDataSortedAscending(true);
        dataDistributionCalculator.setDataEvenlySpaced(true);

        final IXyDataSeries<Double, Double> dataSeries = new XyDataSeries<>(Double.class, Double.class, dataDistributionCalculator);
        // </SetDataDistribution>
    }

    void setAcceptsUnsortedData() {
        // <SetAcceptsUnsortedData>
        final IXyDataSeries<Double, Double> dataSeries = new XyDataSeries<>(Double.class, Double.class);
        dataSeries.setAcceptsUnsortedData(true);
        // </SetAcceptsUnsortedData>
    }
}
