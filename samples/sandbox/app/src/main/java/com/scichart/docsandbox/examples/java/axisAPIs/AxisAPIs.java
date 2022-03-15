package com.scichart.docsandbox.examples.java.axisAPIs;

import androidx.annotation.NonNull;

import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.axes.AutoRange;
import com.scichart.charting.visuals.axes.AxisAlignment;
import com.scichart.charting.visuals.axes.CategoryDateAxis;
import com.scichart.charting.visuals.axes.DateAxis;
import com.scichart.charting.visuals.axes.LogarithmicNumericAxis;
import com.scichart.charting.visuals.axes.NumericAxis;
import com.scichart.charting.visuals.axes.ScientificNotation;
import com.scichart.data.model.DateRange;
import com.scichart.data.model.DoubleRange;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;

import java.util.Calendar;
import java.util.Date;

@ExampleDefinition()
public class AxisAPIs extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) {}

    void addNumericAxis() {
        // <AddNumericAxis>
        final NumericAxis axis = new NumericAxis(getContext());
        axis.setAxisAlignment(AxisAlignment.Right);
        axis.setAutoRange(AutoRange.Once);
        axis.setGrowBy(new DoubleRange(0.1, 0.1));
        axis.setVisibleRange(new DoubleRange(-45.0, 300.0));
        // </AddNumericAxis>
    }

    void addLogarithmicNumericAxis() {
        // <AddLogarithmicNumericAxis>
        final LogarithmicNumericAxis axis = new LogarithmicNumericAxis(getContext());
        axis.setAxisAlignment(AxisAlignment.Right);
        axis.setAutoRange(AutoRange.Once);
        axis.setGrowBy(new DoubleRange(0.1, 0.1));

        // Specifies how labels appear on the axis
        axis.setScientificNotation(ScientificNotation.LogarithmicBase);
        axis.setTextFormatting("#.#E+0");

        // Specifies the logarithm base for the logarithmic scale of the axis
        axis.setLogarithmicBase(10.0);
        axis.setVisibleRange(new DoubleRange(0.1, 1000.0));
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
        final DateAxis axis = new DateAxis(getContext());
        axis.setAxisAlignment(AxisAlignment.Bottom);
        axis.setAutoRange(AutoRange.Once);
        axis.setGrowBy(new DoubleRange(0.1, 0.1));
        axis.setVisibleRange(new DateRange(dateMin, dateMax));
        // </AddDateAxis>
    }

    void addCategoryDateAxis() {
        // <AddCategoryDateAxis>
        final CategoryDateAxis axis = new CategoryDateAxis(getContext());
        axis.setAxisAlignment(AxisAlignment.Top);
        axis.setAutoRange(AutoRange.Once);
        axis.setGrowBy(new DoubleRange(0.1, 0.1));
        // Set visibleRange to [min data index, max data index]
        axis.setVisibleRange(new DoubleRange(10.0, 50.0));
        // </AddCategoryDateAxis>
    }
}
