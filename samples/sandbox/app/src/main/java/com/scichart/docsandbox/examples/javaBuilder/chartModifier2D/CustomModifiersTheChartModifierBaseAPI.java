package com.scichart.docsandbox.examples.javaBuilder.chartModifier2D;

import androidx.annotation.NonNull;

import com.scichart.charting.model.AxisCollection;
import com.scichart.charting.modifiers.ChartModifierBase;
import com.scichart.charting.visuals.ISciChartSurface;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.axes.AxisAlignment;
import com.scichart.charting.visuals.axes.IAxis;
import com.scichart.core.framework.IUpdateSuspender;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;

@ExampleDefinition()
public class CustomModifiersTheChartModifierBaseAPI extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) {}

    void createCustomRotateChartModifier(@NonNull SciChartSurface surface) {
        // <CreateCustomRotateChartModifier>
        class CustomRotateChartModifier extends ChartModifierBase {
            public void rotateChart() {
                if (isAttached()) {
                    final ISciChartSurface parentSurface = getParentSurface();

                    IUpdateSuspender updateSuspender = parentSurface.suspendUpdates();
                    try {
                        rotateAxes(parentSurface.getXAxes());
                        rotateAxes(parentSurface.getYAxes());
                    } finally {
                        updateSuspender.dispose();
                    }
                }
            }

            private void rotateAxes(AxisCollection axes) {
                for (int i = 0, size = axes.size(); i < size; i++) {
                    final IAxis axis = axes.get(i);
                    final AxisAlignment axisAlignment = axis.getAxisAlignment();

                    switch (axisAlignment) {
                        case Right:
                            axis.setAxisAlignment(AxisAlignment.Bottom);
                            break;
                        case Left:
                            axis.setAxisAlignment(AxisAlignment.Top);
                            break;
                        case Top:
                            axis.setAxisAlignment(AxisAlignment.Right);
                            break;
                        case Bottom:
                            axis.setAxisAlignment(AxisAlignment.Left);
                            break;
                        case Auto:
                            if(axis.isXAxis()) {
                                // Bottom
                                axis.setAxisAlignment(AxisAlignment.Left);
                            } else {
                                // Right
                                axis.setAxisAlignment(AxisAlignment.Bottom);
                            }
                    }
                }
            }
        }
        // </CreateCustomRotateChartModifier>
    }
}
