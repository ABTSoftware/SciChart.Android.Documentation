package com.scichart.docsandbox.examples.java.axisAPIs;

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
        final NumericAxis xTopAxis = new NumericAxis(getContext());
        xTopAxis.setAxisId("TopAxisId");
        xTopAxis.setAxisAlignment(AxisAlignment.Top);

        final NumericAxis xBottomAxis = new NumericAxis(getContext());
        xBottomAxis.setAxisId("BottomAxisId");
        xBottomAxis.setAxisAlignment(AxisAlignment.Bottom);

        final NumericAxis yLeftAxis = new NumericAxis(getContext());
        yLeftAxis.setAxisId("LeftAxisId");
        yLeftAxis.setAxisAlignment(AxisAlignment.Left);

        final NumericAxis yRightAxis = new NumericAxis(getContext());
        yRightAxis.setAxisId("RightAxisId");
        yRightAxis.setAxisAlignment(AxisAlignment.Right);
        // </AddAxisAlignment>
    }
}
