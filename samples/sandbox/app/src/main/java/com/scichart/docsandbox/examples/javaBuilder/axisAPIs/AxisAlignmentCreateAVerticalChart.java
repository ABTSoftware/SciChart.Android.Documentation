package com.scichart.docsandbox.examples.javaBuilder.axisAPIs;

import androidx.annotation.NonNull;

import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.axes.AxisAlignment;
import com.scichart.charting.visuals.axes.NumericAxis;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;

@ExampleDefinition()
public class AxisAlignmentCreateAVerticalChart extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) { }

    void addAxisAlignment() {
        // <AddAxisAlignment>
        // Create X axis and position it to the left
        final NumericAxis xAxis = sciChartBuilder.newNumericAxis()
                .withAxisAlignment(AxisAlignment.Left)
                .build();

        // Create Y axis and position it to the top
        final NumericAxis yAxis = sciChartBuilder.newNumericAxis()
                .withAxisAlignment(AxisAlignment.Top)
                .build();
        // </AddAxisAlignment>
    }

    void addMultipleAxes() {
        // <AddMultipleAxes>
        final NumericAxis xAxis = sciChartBuilder.newNumericAxis()
                .withAxisId("xAxis")
                .withAxisTitle("Horizontal-X")
                .build();

        final NumericAxis xLeftAxis = sciChartBuilder.newNumericAxis()
                .withAxisId("xLeftAxis")
                .withAxisAlignment(AxisAlignment.Left)
                .withAxisTitle("Vertical-X")
                .build();

        final NumericAxis yAxis = sciChartBuilder.newNumericAxis()
                .withAxisId("yAxis")
                .withAxisTitle("Vertical-Y")
                .build();

        final NumericAxis yTopAxis = sciChartBuilder.newNumericAxis()
                .withAxisId("yTopAxis")
                .withAxisAlignment(AxisAlignment.Top)
                .withAxisTitle("Horizontal-Y")
                .build();
        // </AddMultipleAxes>
    }
}
