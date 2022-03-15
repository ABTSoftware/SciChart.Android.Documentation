package com.scichart.docsandbox.examples.java.axisAPIs;

import androidx.annotation.NonNull;

import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.axes.NumericAxis;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;

@ExampleDefinition()
public class AxisTicksMajorDeltaMinorDeltaAndAutoTicks extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) { }

    void automaticTickSpacing() {
        // <AutomaticTickSpacing>
        final NumericAxis axis = new NumericAxis(getContext());
        // change max possible auto ticks amount (the default is 10)
        axis.setMaxAutoTicks(20);
        // specify that there should be 10 Minor Ticks between two Major Ticks (the default is 5)
        axis.setMinorsPerMajor(10);
        // </AutomaticTickSpacing>
    }

    void alteringTickSpacing() {
        // <AlteringTickSpacing>
        final NumericAxis axis = new NumericAxis(getContext());
        axis.setAutoTicks(false);
        axis.setMinorDelta(2);
        axis.setMajorDelta(10);
        // </AlteringTickSpacing>
    }
}
