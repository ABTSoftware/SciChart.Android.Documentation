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
public class AxisLabelsTextFormattingAndCursorTextFormatting extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) { }

    void addTextFormatting() {
        // <AddTextFormatting>
        final DateAxis xAxis = new DateAxis(getContext());
        xAxis.setTextFormatting("dd.MMM");

        final NumericAxis yAxis = new NumericAxis(getContext());
        yAxis.setTextFormatting("$0.0");
        // </AddTextFormatting>
    }

    void addCursorTextFormatting() {
        // <AddCursorTextFormatting>
        final DateAxis xAxis = new DateAxis(getContext());
        xAxis.setCursorTextFormatting("'X Value:'dd.MM.yyyy");

        final NumericAxis yAxis = new NumericAxis(getContext());
        yAxis.setCursorTextFormatting("'Price:'###.##' $'");
        // </AddCursorTextFormatting>
    }

    void addScientificNotation() {
        // <AddScientificNotation>
        LogarithmicNumericAxis xAxis = new LogarithmicNumericAxis(getContext());
        xAxis.setLogarithmicBase(10.0);
        xAxis.setScientificNotation(ScientificNotation.LogarithmicBase);
        xAxis.setTextFormatting("#.#E+0");
        xAxis.setCursorTextFormatting("#.#E+0");
        // </AddScientificNotation>
    }
}
