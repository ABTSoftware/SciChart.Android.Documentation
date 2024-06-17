package com.scichart.docsandbox.examples.java.axisAPIs;

import androidx.annotation.NonNull;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.axes.DateAxis;
import com.scichart.charting.visuals.axes.LogarithmicNumericAxis;
import com.scichart.charting.visuals.axes.NumericAxis;
import com.scichart.charting.visuals.axes.ScientificNotation;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;

@ExampleDefinition()
public class AxisLabelsTextRotationAndAxisSize extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) { }

    void addAxisRotation(){
        // <AddAxisLabelRotation>
        final NumericAxis xAxis = new NumericAxis(getContext());
        xAxis.setAxisLabelRotation(30); // Rotate 30 degrees

        final NumericAxis yAxis = new NumericAxis(getContext());
        yAxis.setAxisLabelRotation(-30); // You can also rotate in other direction
        // </AddAxisLabelRotation>
    }

    void changeAxisSize(){
        // <AddAxisSize>
        final NumericAxis xAxis = new NumericAxis(getContext());
        xAxis.setFixedSize(200); // Set height of the horizontal axis to 200

        final NumericAxis yAxis = new NumericAxis(getContext());
        yAxis.setFixedSize(200); // Set width of the vertical axis to 200
        // </AddAxisSize>
    }
}