package com.scichart.docsandbox.examples.java.axisAPIs;

import androidx.annotation.NonNull;

import com.scichart.charting.layoutManagers.ChartLayoutState;
import com.scichart.charting.layoutManagers.DefaultLayoutManager;
import com.scichart.charting.layoutManagers.VerticalAxisLayoutStrategy;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.axes.AxisLayoutState;
import com.scichart.charting.visuals.axes.IAxis;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;

@ExampleDefinition()
public class AxisLayoutStackAxesVerticallyOrHorizontally extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) { }

    void createLeftAlignedOuterVerticallyStackedYAxisLayoutStrategy(@NonNull SciChartSurface surface) {
        // <CreateLeftAlignedOuterVerticallyStackedYAxisLayoutStrategy>
        class LeftAlignedOuterVerticallyStackedYAxisLayoutStrategy extends VerticalAxisLayoutStrategy {
            @Override
            public void measureAxes(int availableWidth, int availableHeight, ChartLayoutState chartLayoutState) {
                for (int i = 0, size = axes.size(); i < size; i++) {
                    final IAxis axis = axes.get(i);
                    axis.updateAxisMeasurements();

                    final AxisLayoutState axisLayoutState = axis.getAxisLayoutState();
                    chartLayoutState.leftOuterAreaSize = Math.max(getRequiredAxisSize(axisLayoutState), chartLayoutState.leftOuterAreaSize);
                }
            }

            @Override
            public void layoutAxes(int left, int top, int right, int bottom) {
                final int size = axes.size();
                final int height = bottom - top;
                final int axisSize = height / size;

                int topPlacement = top;
                for (int i = 0; i < size; i++) {
                    final IAxis axis = axes.get(i);
                    final AxisLayoutState axisLayoutState = axis.getAxisLayoutState();

                    final int bottomPlacement = topPlacement + axisSize;
                    axis.layoutArea(right - getRequiredAxisSize(axisLayoutState), topPlacement, right, bottomPlacement);
                    topPlacement = bottomPlacement;
                }
            }
        }
        // </CreateLeftAlignedOuterVerticallyStackedYAxisLayoutStrategy>

        // <UseLeftAlignedOuterVerticallyStackedYAxisLayoutStrategy>
        // Create and set new Layout Strategy
        DefaultLayoutManager layoutManager = new DefaultLayoutManager.Builder()
                .setLeftOuterAxesLayoutStrategy(new LeftAlignedOuterVerticallyStackedYAxisLayoutStrategy())
                .build();
        surface.setLayoutManager(layoutManager);
        // </UseLeftAlignedOuterVerticallyStackedYAxisLayoutStrategy>
    }
}
