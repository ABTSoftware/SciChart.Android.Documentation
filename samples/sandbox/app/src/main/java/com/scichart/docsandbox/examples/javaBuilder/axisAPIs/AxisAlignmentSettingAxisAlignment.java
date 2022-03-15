package com.scichart.docsandbox.examples.javaBuilder.axisAPIs;

import androidx.annotation.NonNull;

import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.axes.AxisAlignment;
import com.scichart.charting.visuals.axes.NumericAxis;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;

@ExampleDefinition()
public class AxisAlignmentSettingAxisAlignment extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) { }

    void addAxisAlignment() {
        // <AddAxisAlignment>
        final NumericAxis xTopAxis = sciChartBuilder.newNumericAxis()
                .withAxisId("TopAxisId")
                .withAxisAlignment(AxisAlignment.Top)
                .build();

        final NumericAxis xBottomAxis = sciChartBuilder.newNumericAxis()
                .withAxisId("BottomAxisId")
                .withAxisAlignment(AxisAlignment.Bottom)
                .build();

        final NumericAxis yLeftAxis = sciChartBuilder.newNumericAxis()
                .withAxisId("LeftAxisId")
                .withAxisAlignment(AxisAlignment.Left)
                .build();

        final NumericAxis yRightAxis = sciChartBuilder.newNumericAxis()
                .withAxisId("RightAxisId")
                .withAxisAlignment(AxisAlignment.Right)
                .build();
        // </AddAxisAlignment>
    }
}
