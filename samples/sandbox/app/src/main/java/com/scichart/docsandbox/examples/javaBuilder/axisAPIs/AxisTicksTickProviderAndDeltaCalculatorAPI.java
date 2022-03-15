package com.scichart.docsandbox.examples.javaBuilder.axisAPIs;

import androidx.annotation.NonNull;

import com.scichart.charting.numerics.deltaCalculators.AxisDelta;
import com.scichart.charting.numerics.deltaCalculators.IAxisDelta;
import com.scichart.charting.numerics.deltaCalculators.NumericDeltaCalculator;
import com.scichart.charting.numerics.tickProviders.NumericTickProvider;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.axes.NumericAxis;
import com.scichart.core.model.DoubleValues;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;

@ExampleDefinition()
public class AxisTicksTickProviderAndDeltaCalculatorAPI extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) { }

    void createCustomNumericDeltaCalculator() {
        // <CreateCustomNumericDeltaCalculator>
        class CustomNumericDeltaCalculator extends NumericDeltaCalculator {
            @Override
            public IAxisDelta<Double> getDeltaFromRange(Comparable min, Comparable max, int minorsPerMajor, int maxTicks) {
                // For the sake of simplicity, we will use simple constants.
                // But you might want to have some complex calculations here.
                double minorDelta = 0.07;
                double majorDelta = 0.1;
                return new AxisDelta<>(minorDelta, majorDelta);
            }
        }
        // </CreateCustomNumericDeltaCalculator>

        // <UseCustomNumericDeltaCalculator>
        // create a NumericTickProvider with CustomNumericDeltaCalculator and assign it to the axis
        final NumericAxis axis = sciChartBuilder.newNumericAxis().build();
        axis.setTickProvider(new NumericTickProvider(new CustomNumericDeltaCalculator()));
        // </UseCustomNumericDeltaCalculator>
    }

    void createCustomNumericTickProvider() {
        // <CreateCustomNumericTickProvider>
        class CustomNumericTickProvider extends NumericTickProvider {
            @Override
            protected void updateTicks(DoubleValues minorTicks, DoubleValues majorTicks) {
                double min = axis.getVisibleRange().getMinAsDouble();
                double max = axis.getVisibleRange().getMaxAsDouble();
                majorTicks.add(min);
                majorTicks.add((min + max) / 2);
                majorTicks.add(max);
            }
        }
        // </CreateCustomNumericTickProvider>

        // <UseCustomNumericTickProvider>
        final NumericAxis axis = sciChartBuilder.newNumericAxis().build();
        // create a CustomNumericTickProvider and assign it to the axis
        axis.setTickProvider(new CustomNumericTickProvider());
        // </UseCustomNumericTickProvider>
    }
}
