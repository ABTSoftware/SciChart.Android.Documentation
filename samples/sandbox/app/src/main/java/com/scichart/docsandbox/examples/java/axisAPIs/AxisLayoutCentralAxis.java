package com.scichart.docsandbox.examples.java.axisAPIs;

import androidx.annotation.NonNull;

import com.scichart.charting.layoutManagers.ChartLayoutState;
import com.scichart.charting.layoutManagers.DefaultLayoutManager;
import com.scichart.charting.layoutManagers.TopAlignmentInnerAxisLayoutStrategy;
import com.scichart.charting.layoutManagers.TopAlignmentOuterAxisLayoutStrategy;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.axes.AxisAlignment;
import com.scichart.charting.visuals.axes.IAxis;
import com.scichart.charting.visuals.axes.NumericAxis;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;

@ExampleDefinition()
public class AxisLayoutCentralAxis extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) { }

    void createCenteredAxisLayoutStrategy(@NonNull SciChartSurface surface) {
        // <CreateCenteredAxisLayoutStrategy>
        class CenteredAxisLayoutStrategy extends TopAlignmentInnerAxisLayoutStrategy {
            private int chartAreaWidth, chartAreaHeight;
            @Override
            public void measureAxes(int availableWidth, int availableHeight, ChartLayoutState chartLayoutState) {
                super.measureAxes(availableWidth, availableHeight, chartLayoutState);

                chartAreaWidth = availableWidth;
                chartAreaHeight = availableHeight;
            }

            @Override
            public void layoutAxes(int left, int top, int right, int bottom) {

                // pin the stack of the top-aligned X Axes to the center of a chart
                final int topCoord = chartAreaHeight/2;

                layoutFromTopToBottom(left, topCoord, right, axes);
            }
        }
        // </CreateCenteredAxisLayoutStrategy>

        // <UseCenteredAxisLayoutStrategy>
        final NumericAxis xAxis = new NumericAxis(getContext());
        // Set place axis appropriately for "Top-Inner" Axis Strategy
        xAxis.setIsCenterAxis(true);
        xAxis.setAxisAlignment(AxisAlignment.Top);

        // Create and set new Layout Strategy
        final DefaultLayoutManager layoutManager = new DefaultLayoutManager.Builder()
                .setTopInnerAxesLayoutStrategy(new CenteredAxisLayoutStrategy())
                .build();
        surface.setLayoutManager(layoutManager);
        // </UseCenteredAxisLayoutStrategy>
    }

    void createCenteredTopAlignmentInnerAxisLayoutStrategy() {
        // <CreateCenteredTopAlignmentInnerAxisLayoutStrategy>
        class CenteredTopAlignmentAxisLayoutStrategy extends TopAlignmentOuterAxisLayoutStrategy {
            private final IAxis yAxis;
            private CenteredTopAlignmentAxisLayoutStrategy(IAxis yAxis) {
                this.yAxis = yAxis;
            }

            @Override
            public void layoutAxes(int left, int top, int right, int bottom) {

                // find the coordinate of 0 on the Y Axis in pixels
                // place the stack of the top-aligned X Axes at this coordinate
                final float topCoord = yAxis.getCurrentCoordinateCalculator().getCoordinate(0);
                layoutFromTopToBottom(left, (int) topCoord, right, axes);
            }
        }
        // </CreateCenteredTopAlignmentInnerAxisLayoutStrategy>
    }
}
