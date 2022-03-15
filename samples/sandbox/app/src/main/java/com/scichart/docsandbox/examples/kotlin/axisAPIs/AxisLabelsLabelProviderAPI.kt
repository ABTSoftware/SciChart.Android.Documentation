package com.scichart.docsandbox.examples.kotlin.axisAPIs

import com.scichart.charting.numerics.labelProviders.LabelFormatterBase
import com.scichart.charting.numerics.labelProviders.LabelProviderBase
import com.scichart.charting.numerics.labelProviders.NumericLabelProvider
import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.axes.IDateAxis
import com.scichart.charting.visuals.axes.INumericAxis
import com.scichart.charting.visuals.axes.NumericAxis
import com.scichart.core.utility.ComparableUtil
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment
import java.text.SimpleDateFormat

@ExampleDefinition()
class AxisLabelsLabelProviderAPI : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {}

    fun numericLabelFormatter() {
        // <NumericLabelFormatter>
        class NumericLabelFormatter() : LabelFormatterBase<INumericAxis>() {
            override fun update(iAxisCore: INumericAxis?) {}
            override fun formatLabel(dataValue: Double): CharSequence {
                // return a formatting string for tick labels
                return String.format("%.3f", dataValue)
            }

            override fun formatCursorLabel(dataValue: Double): CharSequence {
                // return a formatting string for modifiers' axis labels
                return formatLabel(dataValue)
            }
        }

        val axis = NumericAxis(context)
        // create a NumericLabelProvider with custom ILabelFormatter and assign it to the axis
        axis.labelProvider = NumericLabelProvider(NumericLabelFormatter())
        // </NumericLabelFormatter>
    }

    fun dateLabelProvider() {
        // <DateLabelProvider>
        class DateLabelProvider : LabelProviderBase<IDateAxis>(IDateAxis::class.java) {
            val dateFormatter = SimpleDateFormat("yyyy MMM dd")
            override fun formatLabel(dataValue: Comparable<*>?): CharSequence {
                val doubleValue = ComparableUtil.toDouble(dataValue)
                return formatLabel(doubleValue)
            }

            override fun formatCursorLabel(dataValue: Comparable<*>?): CharSequence {
                val doubleValue = ComparableUtil.toDouble(dataValue)
                return formatCursorLabel(doubleValue)
            }

            override fun formatLabel(dataValue: Double): CharSequence {
                return dateFormatter.format(dataValue)
            }

            override fun formatCursorLabel(dataValue: Double): CharSequence {
                return formatLabel(dataValue)
            }
        }

        val axis = NumericAxis(context)
        // create a custom DateLabelProvider and assign it to the axis
        axis.labelProvider = DateLabelProvider()
        // </DateLabelProvider>
    }
}
