package com.scichart.docsandbox.examples.javaBuilder.axisAPIs;

import androidx.annotation.NonNull;

import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.axes.AutoRange;
import com.scichart.charting.visuals.axes.AxisAlignment;
import com.scichart.charting.visuals.axes.CategoryDateAxis;
import com.scichart.charting.visuals.axes.DateAxis;
import com.scichart.charting.visuals.axes.LogarithmicNumericAxis;
import com.scichart.charting.visuals.axes.NumericAxis;
import com.scichart.charting.visuals.axes.ScientificNotation;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;

import java.util.Calendar;
import java.util.Date;

@ExampleDefinition()
public class AxisAPIs extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) { }

    void addNumericAxis() {
        // <AddNumericAxis>
        final NumericAxis axis = sciChartBuilder.newNumericAxis()
                .withAxisAlignment(AxisAlignment.Right)
                .withAutoRangeMode(AutoRange.Once)
                .withGrowBy(0.1, 0.1)
                .withVisibleRange(-45.0, 300.0)
                .build();
        // </AddNumericAxis>
    }

    void addLogarithmicNumericAxis() {
        // <AddLogarithmicNumericAxis>
        final LogarithmicNumericAxis axis = sciChartBuilder.newLogarithmicNumericAxis()
                .withAxisAlignment(AxisAlignment.Right)
                .withAutoRangeMode(AutoRange.Once)
                .withGrowBy(0.1, 0.1)
                // Specifies how labels appear on the axis
                .withScientificNotation(ScientificNotation.LogarithmicBase)
                .withTextFormatting("#.#E+0")
                // Specifies the logarithm base for the logarithmic scale of the axis
                .withLogarithmicBase(10.0)
                .withVisibleRange(0.1, 1000.0)
                .build();
        // </AddLogarithmicNumericAxis>
    }

    void addDateAxis() {
        final Calendar calendarDateMin = Calendar.getInstance();
        calendarDateMin.set(2020, Calendar.MAY, 1);
        final Date dateMin = calendarDateMin.getTime();

        final Calendar calendarDateMax = Calendar.getInstance();
        calendarDateMax.set(2021, Calendar.MAY, 1);
        final Date dateMax = calendarDateMax.getTime();

        // <AddDateAxis>
        final DateAxis axis = sciChartBuilder.newDateAxis()
                .withAxisAlignment(AxisAlignment.Bottom)
                .withAutoRangeMode(AutoRange.Once)
                .withGrowBy(0.1, 0.1)
                .withVisibleRange(dateMin, dateMax)
                .build();
        // </AddDateAxis>
    }

    void addCategoryDateAxis() {
        // <AddCategoryDateAxis>
        final CategoryDateAxis axis = sciChartBuilder.newCategoryDateAxis()
                .withAxisAlignment(AxisAlignment.Top)
                .withAutoRangeMode(AutoRange.Once)
                .withGrowBy(0.1, 0.1)
                // Set visibleRange to [min data index, max data index]
                .withVisibleRange(10.0, 50.0)
                .build();
        // </AddCategoryDateAxis>
    }
}
