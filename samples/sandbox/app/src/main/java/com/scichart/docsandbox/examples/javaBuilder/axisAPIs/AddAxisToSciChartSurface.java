package com.scichart.docsandbox.examples.javaBuilder.axisAPIs;

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
        final NumericAxis xAxis = sciChartBuilder.newNumericAxis()
                .build();
        // Create numeric Y axis
        final NumericAxis yAxis = sciChartBuilder.newNumericAxis()
                .build();

        // Add the Y and X axes to the axis collections of the ChartSurface
        surface.getXAxes().add(xAxis);
        surface.getYAxes().add(yAxis);
        // </AddingAxes>
    }

    void addAxisAlignment() {
        // <AddAxisAlignment>
        final NumericAxis xAxis = sciChartBuilder.newNumericAxis()
                .withAxisAlignment(AxisAlignment.Bottom)
                .build();
        final NumericAxis yAxis = sciChartBuilder.newNumericAxis()
                .withAxisAlignment(AxisAlignment.Left)
                .build();
        // </AddAxisAlignment>
    }
}
