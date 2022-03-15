package com.scichart.docsandbox.examples.kotlin.axisAPIs

import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.axes.CategoryDateAxis
import com.scichart.charting.visuals.axes.DateAxis
import com.scichart.charting.visuals.axes.NumericAxis
import com.scichart.core.utility.DateIntervalUtil
import com.scichart.data.model.DoubleRange
import com.scichart.data.model.RangeClipMode
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment

@ExampleDefinition()
class AxisRangingRestrictingVisibleRange : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {}

    fun setVisibleRangeLimit() {
        // <SetVisibleRangeLimit>
        val axis = NumericAxis(context)
        axis.visibleRangeLimit = DoubleRange(4.5, 5.5)
        // </SetVisibleRangeLimit>
    }

    fun setVisibleRangeLimitMode() {
        // <SetVisibleRangeLimitMode>
        val axis = NumericAxis(context)
        axis.visibleRangeLimit = DoubleRange(0.0, 0.0)
        axis.visibleRangeLimitMode = RangeClipMode.Min
        // </SetVisibleRangeLimitMode>
    }

    fun advancedVisibleRangeClipping() {
        // <AdvancedVisibleRangeClipping>
        val axis = NumericAxis(context)
        axis.setVisibleRangeChangeListener { axis, oldRange, newRange, isAnimating ->
            // Set the old range back on the axis if the new Min is less than 0
            if (newRange.minAsDouble < 0.0) {
                axis.visibleRange = oldRange
            }
        }
        // </AdvancedVisibleRangeClipping>
    }

    fun zoomConstrainsForNumericAxis() {
        // <ZoomConstrainsForNumericAxis>
        val axis = NumericAxis(context)
        axis.minimalZoomConstrain = 10
        axis.maximumZoomConstrain = 100
        // </ZoomConstrainsForNumericAxis>
    }

    fun zoomConstrainsForCategoryDateAxis() {
        // <ZoomConstrainsForCategoryDateAxis>
        val axis = CategoryDateAxis(context)
        axis.minimalZoomConstrain = 10
        axis.maximumZoomConstrain = 100
        // </ZoomConstrainsForCategoryDateAxis>
    }

    fun zoomConstrainsForDateAxis() {
        // <ZoomConstrainsForDateAxis>
        val axis = DateAxis(activity)
        val min = DateIntervalUtil.fromMonths(2.0)
        val max = DateIntervalUtil.fromMonths(10.0)
        axis.minimalZoomConstrain = min
        axis.maximumZoomConstrain = max
        // </ZoomConstrainsForDateAxis>
    }
}
