package com.scichart.docsandbox.examples.javaBuilder.axisAPIs;

import androidx.annotation.NonNull;

import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.axes.DateAxis;
import com.scichart.charting.visuals.axes.LogarithmicNumericAxis;
import com.scichart.charting.visuals.axes.NumericAxis;
import com.scichart.charting.visuals.axes.ScientificNotation;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;

@ExampleDefinition()
public class AxisLabelsTextFormattingAndCursorTextFormatting extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) { }

    void addTextFormatting() {
        // <AddTextFormatting>
        final DateAxis xAxis = sciChartBuilder.newDateAxis()
                .withTextFormatting("dd.MMM")
                .build();

        final NumericAxis yAxis = sciChartBuilder.newNumericAxis()
                .withTextFormatting("$0.0")
                .build();
        // </AddTextFormatting>
    }

    void addCursorTextFormatting() {
        // <AddCursorTextFormatting>
        final DateAxis xAxis = sciChartBuilder.newDateAxis()
                .withCursorTextFormating("'X Value:'dd.MM.yyyy")
                .build();

        final NumericAxis yAxis = sciChartBuilder.newNumericAxis()
                .withCursorTextFormating("'Price:'###.##' $'")
                .build();
        // </AddCursorTextFormatting>
    }

    void addScientificNotation() {
        // <AddScientificNotation>
        LogarithmicNumericAxis xAxis = sciChartBuilder.newLogarithmicNumericAxis()
                .withLogarithmicBase(10.0)
                .withScientificNotation(ScientificNotation.LogarithmicBase)
                .withTextFormatting("#.#E+0")
                .withCursorTextFormating("#.#E+0")
                .build();
        // </AddScientificNotation>
    }
}
