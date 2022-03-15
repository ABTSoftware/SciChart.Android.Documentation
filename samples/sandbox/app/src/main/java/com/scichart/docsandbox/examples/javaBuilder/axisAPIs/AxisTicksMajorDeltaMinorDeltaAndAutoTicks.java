package com.scichart.docsandbox.examples.javaBuilder.axisAPIs;

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
        final NumericAxis axis = sciChartBuilder.newNumericAxis()
                // change max possible auto ticks amount (the default is 10)
                .withMaxAutoTicks(20)
                // specify that there should be 10 Minor Ticks between two Major Ticks (the default is 5)
                .withMinorsPerMajor(10)
                .build();
        // </AutomaticTickSpacing>
    }

    void alteringTickSpacing() {
        // <AlteringTickSpacing>
        final NumericAxis axis = sciChartBuilder.newNumericAxis()
                .withAutoTicks(false)
                .withMinorDelta(2)
                .withMajorDelta(10)
                .build();
        // </AlteringTickSpacing>
    }
}
