package com.scichart.docsandbox.examples.javaBuilder.axisAPIs;

import androidx.annotation.NonNull;

import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.axes.CategoryDateAxis;
import com.scichart.charting.visuals.axes.DateAxis;
import com.scichart.charting.visuals.axes.IAxisCore;
import com.scichart.charting.visuals.axes.NumericAxis;
import com.scichart.charting.visuals.axes.VisibleRangeChangeListener;
import com.scichart.core.utility.DateIntervalUtil;
import com.scichart.data.model.DoubleRange;
import com.scichart.data.model.IRange;
import com.scichart.data.model.RangeClipMode;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;

@ExampleDefinition()
public class AxisRangingRestrictingVisibleRange extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) { }

    void setVisibleRangeLimit() {
        // <SetVisibleRangeLimit>
        final NumericAxis axis = sciChartBuilder.newNumericAxis()
                .withVisibleRangeLimit(new DoubleRange(4.5, 5.5))
                .build();
        // </SetVisibleRangeLimit>
    }

    void setVisibleRangeLimitMode() {
        // <SetVisibleRangeLimitMode>
        final NumericAxis axis = sciChartBuilder.newNumericAxis()
                .withVisibleRangeLimit(new DoubleRange(0.0, 0.0))
                .build();

        axis.setVisibleRangeLimitMode(RangeClipMode.Min);
        // </SetVisibleRangeLimitMode>
    }

    void advancedVisibleRangeClipping() {
        // <AdvancedVisibleRangeClipping>
        final NumericAxis axis = sciChartBuilder.newNumericAxis().build();
        axis.setVisibleRangeChangeListener(new VisibleRangeChangeListener() {
            @Override
            public void onVisibleRangeChanged(IAxisCore axis, IRange oldRange, IRange newRange, boolean isAnimating) {
                // Set the old range back on the axis if the new Min is less than 0
                if (newRange.getMinAsDouble() < 0.0) {
                    axis.setVisibleRange(oldRange);
                }
            }
        });
        // </AdvancedVisibleRangeClipping>
    }

    void zoomConstrainsForNumericAxis() {
        // <ZoomConstrainsForNumericAxis>
        final NumericAxis axis = sciChartBuilder.newNumericAxis().build();
        axis.setMinimalZoomConstrain(10);
        axis.setMaximumZoomConstrain(100);
        // </ZoomConstrainsForNumericAxis>
    }

    void zoomConstrainsForCategoryDateAxis() {
        // <ZoomConstrainsForCategoryDateAxis>
        final CategoryDateAxis axis = sciChartBuilder.newCategoryDateAxis().build();
        axis.setMinimalZoomConstrain(10);
        axis.setMaximumZoomConstrain(100);
        // </ZoomConstrainsForCategoryDateAxis>
    }

    void zoomConstrainsForDateAxis() {
        // <ZoomConstrainsForDateAxis>
        DateAxis axis = sciChartBuilder.newDateAxis().build();
        long min = DateIntervalUtil.fromMonths(2);
        long max = DateIntervalUtil.fromMonths(10);
        axis.setMinimalZoomConstrain(min);
        axis.setMaximumZoomConstrain(max);
        // </ZoomConstrainsForDateAxis>
    }
}
