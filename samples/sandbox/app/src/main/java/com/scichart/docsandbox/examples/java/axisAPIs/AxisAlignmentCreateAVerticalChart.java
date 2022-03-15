package com.scichart.docsandbox.examples.java.axisAPIs;

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
        final NumericAxis xAxis = new NumericAxis(getContext());
        xAxis.setAxisAlignment(AxisAlignment.Left);

        // Create Y axis and position it to the top
        final NumericAxis yAxis = new NumericAxis(getContext());
        yAxis.setAxisAlignment(AxisAlignment.Top);
        // </AddAxisAlignment>
    }

    void addMultipleAxes() {
        // <AddMultipleAxes>
        final NumericAxis xAxis = new NumericAxis(getContext());
        xAxis.setAxisId("xAxis");
        xAxis.setAxisTitle("Horizontal-X");

        final NumericAxis xLeftAxis = new NumericAxis(getContext());
        xLeftAxis.setAxisId("xLeftAxis");
        xLeftAxis.setAxisAlignment(AxisAlignment.Left);
        xLeftAxis.setAxisTitle("Vertical-X");

        final NumericAxis yAxis = new NumericAxis(getContext());
        yAxis.setAxisId("yAxis");
        yAxis.setAxisTitle("Vertical-Y");

        final NumericAxis yTopAxis = new NumericAxis(getContext());
        yTopAxis.setAxisId("yTopAxis");
        yTopAxis.setAxisAlignment(AxisAlignment.Top);
        yTopAxis.setAxisTitle("Horizontal-Y");
        // </AddMultipleAxes>
    }
}
