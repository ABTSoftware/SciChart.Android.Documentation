package com.scichart.docsandbox.examples.java.axisAPIs;

import android.view.Gravity;

import androidx.annotation.NonNull;

import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.axes.AxisAlignment;
import com.scichart.charting.visuals.axes.AxisTickLabelStyle;
import com.scichart.charting.visuals.axes.AxisTitlePlacement;
import com.scichart.charting.visuals.axes.NumericAxis;
import com.scichart.data.model.DoubleRange;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;
import com.scichart.drawing.common.FontStyle;

@ExampleDefinition()
public class AxisStylingTitleAndLabels extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) { }

    void setAxisLabels() {
        // <SetAxisLabels>
        final NumericAxis xTopAxis = new NumericAxis(getContext());
        xTopAxis.setAxisId("TopAxisId");
        xTopAxis.setAxisAlignment(AxisAlignment.Top);
        xTopAxis.setAxisTitle("Top Axis");
        xTopAxis.setAxisTitleGravity(Gravity.BOTTOM);
        xTopAxis.setTitleStyle(new FontStyle(18, 0xFF279B27));
        xTopAxis.setTickLabelStyle(new FontStyle(12, 0xFF279B27));

        final NumericAxis xBottomAxis = new NumericAxis(getContext());
        xBottomAxis.setAxisId("BottomAxisId");
        xBottomAxis.setAxisAlignment(AxisAlignment.Bottom);
        xBottomAxis.setAxisTitle("Bottom Axis");
        xBottomAxis.setTitleStyle(new FontStyle(18, 0xFFFF1919));
        xBottomAxis.setTickLabelStyle(new FontStyle(12, 0xFFFF1919));

        final NumericAxis yLeftAxis = new NumericAxis(getContext());
        yLeftAxis.setAxisId("LeftAxisId");
        yLeftAxis.setGrowBy(new DoubleRange(0.1, 0.1));
        yLeftAxis.setAxisAlignment(AxisAlignment.Left);
        yLeftAxis.setAxisTitle("Left Axis");
        yLeftAxis.setAxisTitleGravity(Gravity.TOP);
        yLeftAxis.setAxisTitlePlacement(AxisTitlePlacement.Inside);
        yLeftAxis.setAxisTitleMargins(20, 5, 0, 0);
        yLeftAxis.setTitleStyle(new FontStyle(18, 0xFFFC9C29));
        yLeftAxis.setTickLabelStyle(new FontStyle(12, 0xFFFC9C29));
        yLeftAxis.setAxisTickLabelStyle(new AxisTickLabelStyle(Gravity.CENTER, 5, 0, 5, 0));

        final NumericAxis yRightAxis = new NumericAxis(getContext());
        yRightAxis.setAxisId("RightAxisId");
        yRightAxis.setGrowBy(new DoubleRange(0.1, 0.1));
        yRightAxis.setAxisAlignment(AxisAlignment.Right);
        yRightAxis.setIsCenterAxis(true);
        yRightAxis.setAxisTitle("Right Axis");
        yRightAxis.setAxisTitleGravity(Gravity.BOTTOM);
        yRightAxis.setAxisTitlePlacement(AxisTitlePlacement.Left);
        yRightAxis.setTitleStyle(new FontStyle(18, 0xFF4083B7));
        yRightAxis.setTickLabelStyle(new FontStyle(12, 0xFF4083B7));
        // </SetAxisLabels>
    }
}
