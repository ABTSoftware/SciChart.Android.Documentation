package com.scichart.docsandbox.examples.javaBuilder.axisAPIs;

import androidx.annotation.NonNull;

import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.axes.IAxisCore;
import com.scichart.charting.visuals.axes.NumericAxis;
import com.scichart.charting.visuals.axes.VisibleRangeChangeListener;
import com.scichart.data.model.IRange;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;

@ExampleDefinition()
public class AxisRangingHowToListenToVisibleRangeChanges extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) { }

    void setVisibleRangeChangeListener() {
        // <SetVisibleRangeChangeListener>
        final NumericAxis axis = sciChartBuilder.newNumericAxis().build();
        axis.setVisibleRangeChangeListener(new VisibleRangeChangeListener() {
            @Override
            public void onVisibleRangeChanged(IAxisCore axis, IRange oldRange, IRange newRange, boolean isAnimating) {
                // TODO handle range changes here
            }
        });
        // </SetVisibleRangeChangeListener>
    }
}
