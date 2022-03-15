package com.scichart.docsandbox.examples.javaBuilder.axisAPIs;

import androidx.annotation.NonNull;

import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.axes.NumericAxis;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;

@ExampleDefinition()
public class AxisRangingGetOrSetVisibleRange extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) { }

    void setGrowBy() {
        // <SetGrowBy>
        final NumericAxis axis = sciChartBuilder.newNumericAxis()
                .withGrowBy(0.1, 0.1)
                .withVisibleRange(0.0, 10.0)
                .build();
        // </SetGrowBy>
    }
}
