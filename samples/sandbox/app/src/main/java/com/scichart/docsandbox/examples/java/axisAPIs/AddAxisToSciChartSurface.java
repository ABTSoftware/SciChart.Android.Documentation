package com.scichart.docsandbox.examples.java.axisAPIs;

import androidx.annotation.NonNull;

import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.axes.AxisAlignment;
import com.scichart.charting.visuals.axes.NumericAxis;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;

@ExampleDefinition()
public class AddAxisToSciChartSurface extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) { }

    void addingAxes(@NonNull SciChartSurface surface) {
        // <AddingAxes>
        // Create numeric X axis
        final NumericAxis xAxis = new NumericAxis(getContext());
        // Create numeric Y axis
        final NumericAxis yAxis = new NumericAxis(getContext());

        // Add the Y and X axes to the axis collections of the ChartSurface
        surface.getXAxes().add(xAxis);
        surface.getYAxes().add(yAxis);
        // </AddingAxes>
    }

    void addAxisAlignment() {
        final NumericAxis xAxis = new NumericAxis(getContext());
        final NumericAxis yAxis = new NumericAxis(getContext());

        // <AddAxisAlignment>
        xAxis.setAxisAlignment(AxisAlignment.Bottom);
        yAxis.setAxisAlignment(AxisAlignment.Left);
        // </AddAxisAlignment>
    }
}
