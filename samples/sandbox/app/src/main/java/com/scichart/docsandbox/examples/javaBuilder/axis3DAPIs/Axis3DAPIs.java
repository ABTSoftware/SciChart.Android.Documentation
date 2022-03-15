package com.scichart.docsandbox.examples.javaBuilder.axis3DAPIs;

import androidx.annotation.NonNull;

import com.scichart.charting.visuals.axes.AutoRange;
import com.scichart.charting.visuals.axes.ScientificNotation;
import com.scichart.charting3d.visuals.SciChartSurface3D;
import com.scichart.charting3d.visuals.axes.DateAxis3D;
import com.scichart.charting3d.visuals.axes.LogarithmicNumericAxis3D;
import com.scichart.charting3d.visuals.axes.NumericAxis3D;
import com.scichart.data.model.DoubleRange;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart3DFragment;

import java.util.Calendar;
import java.util.Date;

@ExampleDefinition()
public class Axis3DAPIs extends SingleChart3DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface3D surface) {}

    void addNumericAxis3D(@NonNull SciChartSurface3D surface) {
        // <AddNumericAxis3D>
        final NumericAxis3D axis = sciChart3DBuilder.newNumericAxis3D()
                .withGrowBy(new DoubleRange(0.1, 0.1))
                .withVisibleRange(new DoubleRange(-7.0, 7.0))
                .build();
        // </AddNumericAxis3D>
    }

    void addLogarithmicNumericAxis3D(@NonNull SciChartSurface3D surface) {
        // <AddLogarithmicNumericAxis3D>
        final LogarithmicNumericAxis3D axis = sciChart3DBuilder.newLogarithmicNumericAxis3D()
                .withGrowBy(new DoubleRange(0.1, 0.1))
                .withVisibleRange(new DoubleRange(0.1, 1000.0))
                // Specifies how labels appear on the axis
                .withScientificNotation(ScientificNotation.LogarithmicBase)
                .withTextFormatting("#.#E+0")
                // Specifies the logarithm base for the logarithmic scale of the axis
                .withLogarithmicBase(10.0)
                .build();
        // </AddLogarithmicNumericAxis3D>
    }

    void addDateAxis3D(@NonNull SciChartSurface3D surface) {
        final Calendar calendarDateMin = Calendar.getInstance();
        calendarDateMin.clear();
        calendarDateMin.set(2020, Calendar.MAY, 1);
        final Date dateMin = calendarDateMin.getTime();

        final Calendar calendarDateMax = Calendar.getInstance();
        calendarDateMax.clear();
        calendarDateMax.set(2021, Calendar.MAY, 1);
        final Date dateMax = calendarDateMax.getTime();

        // <AddDateAxis3D>
        final DateAxis3D axis = sciChart3DBuilder.newDateAxis3D()
                .withAutoRangeMode(AutoRange.Always)
                .withGrowBy(new DoubleRange(0.1, 0.1))
                .withVisibleRange(dateMin, dateMax)
                .build();
        // </AddDateAxis3D>
    }
}
