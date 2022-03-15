package com.scichart.docsandbox.examples.javaBuilder.axisAPIs;

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
        final NumericAxis xTopAxis = sciChartBuilder.newNumericAxis()
                .withAxisId("TopAxisId")
                .withAxisAlignment(AxisAlignment.Top)
                .withAxisTitle("Top Axis")
                .withAxisTitleStyle(new FontStyle(18, 0xFF279B27))
                .withTickLabelStyle(new FontStyle(12, 0xFF279B27))
                .build();
        xTopAxis.setAxisTitleGravity(Gravity.BOTTOM);

        final NumericAxis xBottomAxis = sciChartBuilder.newNumericAxis()
                .withAxisId("BottomAxisId")
                .withAxisAlignment(AxisAlignment.Bottom)
                .withAxisTitle("Bottom Axis")
                .withAxisTitleStyle(new FontStyle(18, 0xFFFF1919))
                .withTickLabelStyle(new FontStyle(12, 0xFFFF1919))
                .build();

        final NumericAxis yLeftAxis = sciChartBuilder.newNumericAxis()
                .withAxisId("LeftAxisId")
                .withGrowBy(new DoubleRange(0.1, 0.1))
                .withAxisAlignment(AxisAlignment.Left)
                .withAxisTitle("Left Axis")
                .withAxisTitlePlacement(AxisTitlePlacement.Inside)
                .withAxisTitleMargin(20, 5, 0, 0)
                .withAxisTitleStyle(new FontStyle(18, 0xFFFC9C29))
                .withTickLabelStyle(new FontStyle(12, 0xFFFC9C29))
                .build();
        yLeftAxis.setAxisTitleGravity(Gravity.TOP);
        yLeftAxis.setAxisTickLabelStyle(new AxisTickLabelStyle(Gravity.CENTER, 5, 0, 5, 0));

        final NumericAxis yRightAxis = sciChartBuilder.newNumericAxis()
                .withAxisId("RightAxisId")
                .withGrowBy(new DoubleRange(0.1, 0.1))
                .withAxisAlignment(AxisAlignment.Right)
                .withIsCenterAxis(true)
                .withAxisTitle("Right Axis")
                .withAxisTitlePlacement(AxisTitlePlacement.Left)
                .withAxisTitleStyle(new FontStyle(18, 0xFF4083B7))
                .withTickLabelStyle(new FontStyle(12, 0xFF4083B7))
                .build();
        yRightAxis.setAxisTitleGravity(Gravity.BOTTOM);
        // </SetAxisLabels>
    }
}
