package com.scichart.docsandbox.examples.kotlin.axisAPIs

import com.scichart.charting.Direction2D
import com.scichart.charting.modifiers.CursorModifier
import com.scichart.charting.modifiers.PinchZoomModifier
import com.scichart.charting.numerics.labelProviders.*
import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.axes.CategoryDateAxis
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment
import java.util.*

@ExampleDefinition()
class AxisLabelsFormattingForTradingCharts : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {}

    fun customCalendarUnitDateFormatter(surface: SciChartSurface) {
        // <CustomCalendarUnitDateFormatter>
        class CustomCalendarUnitDateFormatter : CalendarUnitDateFormatter() {
            override fun createFormatterForCalendarUnit(calendarUnit: Int): SynchronizedSimpleDataFormatWrapper {
                var dateFormat = ""
                if (calendarUnit and CalendarUnit.YEAR != 0) {
                    dateFormat = "$dateFormat yyyy"
                }
                if (calendarUnit and CalendarUnit.MONTH != 0) {
                    dateFormat = "$dateFormat MMM"
                }
                if (calendarUnit and CalendarUnit.DAY != 0) {
                    dateFormat = "$dateFormat dd"
                }
                return SimpleDateFormatUtil.initWrapperFromFormatString(
                    dateFormat,
                    locale, timeZone
                )
            }
        }
        // </CustomCalendarUnitDateFormatter>

        // <CustomCursorCalendarUnitDateFormatter>
        class CustomCursorCalendarUnitDateFormatter :
            CursorCalendarUnitDateFormatter() {
            val cursorDefaultFormatter = SimpleDateFormatUtil.initWrapperFromFormatString(
                "yyyy MMM dd",
                locale, timeZone
            )
            val dayCursorFormatter = SimpleDateFormatUtil.initWrapperFromFormatString(
                "EEEE, dd MMMM",
                locale, timeZone
            )

            override fun format(date: Date, calendarUnit: Int): CharSequence {
                val formatter =
                    if (calendarUnit < CalendarUnit.DAY) cursorDefaultFormatter else dayCursorFormatter
                return formatter.format(date)
            }
        }
        // </CustomCursorCalendarUnitDateFormatter>

        // <CustomTradeChartLabelFormatter>
        class CustomTradeChartLabelFormatter :
            TradeChartAxisLabelFormatter<CategoryDateAxis>(
                CustomCalendarUnitDateFormatter(),
                CustomCursorCalendarUnitDateFormatter()
            )
        // </CustomTradeChartLabelFormatter>

        // <CustomTradeChartLabelProvider>
        class CustomTradeChartLabelProvider :
            TradeChartAxisLabelProvider(CustomTradeChartLabelFormatter())

        val xAxis = CategoryDateAxis(context)
        xAxis.labelProvider = CustomTradeChartLabelProvider()

        val pinchZoomModifier = PinchZoomModifier()
        pinchZoomModifier.direction = Direction2D.XDirection

        val cursorModifier = CursorModifier()
        cursorModifier.receiveHandledEvents = true

        Collections.addAll(surface.chartModifiers, pinchZoomModifier, cursorModifier)
        // </CustomTradeChartLabelProvider>
    }
}
