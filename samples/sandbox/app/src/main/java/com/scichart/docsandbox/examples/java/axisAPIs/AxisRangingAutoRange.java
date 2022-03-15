package com.scichart.docsandbox.examples.java.axisAPIs;

import androidx.annotation.NonNull;

import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.axes.AutoRange;
import com.scichart.charting.visuals.axes.NumericAxis;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;

@ExampleDefinition()
public class AxisRangingAutoRange extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) { }

    void setAutoRangeOnce() {
        // <SetAutoRangeOnce>
        final NumericAxis axis = new NumericAxis(getContext());
        axis.setAutoRange(AutoRange.Once);
        // </SetAutoRangeOnce>
    }

    void setAutoRangeAlways() {
        // <SetAutoRangeAlways>
        final NumericAxis axis = new NumericAxis(getContext());
        axis.setAutoRange(AutoRange.Always);
        // </SetAutoRangeAlways>
    }

    void setAutoRangeNever() {
        // <SetAutoRangeNever>
        final NumericAxis axis = new NumericAxis(getContext());
        axis.setAutoRange(AutoRange.Never);
        // </SetAutoRangeNever>
    }
}
