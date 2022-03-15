package com.scichart.docsandbox.examples.java.axisAPIs;

import androidx.annotation.NonNull;

import com.scichart.charting.numerics.labelProviders.LabelFormatterBase;
import com.scichart.charting.numerics.labelProviders.LabelProviderBase;
import com.scichart.charting.numerics.labelProviders.NumericLabelProvider;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.axes.IDateAxis;
import com.scichart.charting.visuals.axes.INumericAxis;
import com.scichart.charting.visuals.axes.NumericAxis;
import com.scichart.core.utility.ComparableUtil;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;

import java.text.SimpleDateFormat;

@ExampleDefinition()
public class AxisLabelsLabelProviderAPI extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) { }

    void numericLabelFormatter() {
        // <NumericLabelFormatter>
        class NumericLabelFormatter extends LabelFormatterBase<INumericAxis> {
            @Override
            public void update(INumericAxis iAxisCore) {}

            @Override
            public CharSequence formatLabel(double dataValue) {
                // return a formatting string for tick labels
                return String.format("%.3f", dataValue);
            }

            @Override
            public CharSequence formatCursorLabel(double dataValue) {
                // return a formatting string for modifiers' axis labels
                return formatLabel(dataValue);
            }
        }

        NumericAxis axis = new NumericAxis(getContext());
        // create a NumericLabelProvider with custom ILabelFormatter and assign it to the axis
        axis.setLabelProvider(new NumericLabelProvider(new NumericLabelFormatter()));
        // </NumericLabelFormatter>
    }

    void dateLabelProvider() {
        // <DateLabelProvider>
        class DateLabelProvider extends LabelProviderBase<IDateAxis> {
            final SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy MMM dd");

            DateLabelProvider() {
                super(IDateAxis.class);
            }

            @Override
            public CharSequence formatLabel(Comparable dataValue) {
                final double doubleValue = ComparableUtil.toDouble(dataValue);

                return formatLabel(doubleValue);
            }

            @Override
            public CharSequence formatCursorLabel(Comparable dataValue) {
                final double doubleValue = ComparableUtil.toDouble(dataValue);

                return formatCursorLabel(doubleValue);
            }

            @Override
            public CharSequence formatLabel(double dataValue) {
                return dateFormatter.format(dataValue);
            }

            @Override
            public CharSequence formatCursorLabel(double dataValue) {
                return formatLabel(dataValue);
            }
        }

        NumericAxis axis = new NumericAxis(getContext());
        // create a custom DateLabelProvider and assign it to the axis
        axis.setLabelProvider(new DateLabelProvider());
        // </DateLabelProvider>
    }
}
