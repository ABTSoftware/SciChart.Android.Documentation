package com.scichart.docsandbox.examples.java.axisAPIs;

import androidx.annotation.NonNull;

import com.scichart.charting.Direction2D;
import com.scichart.charting.modifiers.CursorModifier;
import com.scichart.charting.modifiers.PinchZoomModifier;
import com.scichart.charting.numerics.labelProviders.CalendarUnit;
import com.scichart.charting.numerics.labelProviders.CalendarUnitDateFormatter;
import com.scichart.charting.numerics.labelProviders.CursorCalendarUnitDateFormatter;
import com.scichart.charting.numerics.labelProviders.SimpleDateFormatUtil;
import com.scichart.charting.numerics.labelProviders.SynchronizedSimpleDataFormatWrapper;
import com.scichart.charting.numerics.labelProviders.TradeChartAxisLabelFormatter;
import com.scichart.charting.numerics.labelProviders.TradeChartAxisLabelProvider;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.axes.CategoryDateAxis;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;

import java.util.Collections;
import java.util.Date;

@ExampleDefinition()
public class AxisLabelsFormattingForTradingCharts extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) { }

    void customCalendarUnitDateFormatter(@NonNull SciChartSurface surface) {
        // <CustomCalendarUnitDateFormatter>
        class CustomCalendarUnitDateFormatter extends CalendarUnitDateFormatter {
            @Override
            protected SynchronizedSimpleDataFormatWrapper createFormatterForCalendarUnit(int calendarUnit) {
                String dateFormat = "";

                if ((calendarUnit & CalendarUnit.YEAR) != 0) {
                    dateFormat = dateFormat.concat(" yyyy");
                }
                if ((calendarUnit & CalendarUnit.MONTH) != 0) {
                    dateFormat = dateFormat.concat(" MMM");
                }
                if ((calendarUnit & CalendarUnit.DAY) != 0) {
                    dateFormat = dateFormat.concat(" dd");
                }

                final SynchronizedSimpleDataFormatWrapper formatter = SimpleDateFormatUtil.initWrapperFromFormatString(
                        dateFormat,
                        getLocale(),
                        getTimeZone()
                );

                return formatter;
            }
        }
        // </CustomCalendarUnitDateFormatter>

        // <CustomCursorCalendarUnitDateFormatter>
        class CustomCursorCalendarUnitDateFormatter extends CursorCalendarUnitDateFormatter {
            final SynchronizedSimpleDataFormatWrapper cursorDefaultFormatter = SimpleDateFormatUtil.initWrapperFromFormatString(
                    "yyyy MMM dd",
                    getLocale(),
                    getTimeZone()
            );

            final SynchronizedSimpleDataFormatWrapper dayCursorFormatter = SimpleDateFormatUtil.initWrapperFromFormatString(
                    "EEEE, dd MMMM",
                    getLocale(),
                    getTimeZone()
            );

            @Override
            public CharSequence format(Date date, int calendarUnit) {
                SynchronizedSimpleDataFormatWrapper formatter = calendarUnit < CalendarUnit.DAY ? cursorDefaultFormatter : dayCursorFormatter;

                return formatter.format(date);
            }
        }
        // </CustomCursorCalendarUnitDateFormatter>

        // <CustomTradeChartLabelFormatter>
        class CustomTradeChartLabelFormatter extends TradeChartAxisLabelFormatter {
            CustomTradeChartLabelFormatter() {
                super(new CustomCalendarUnitDateFormatter(), new CustomCursorCalendarUnitDateFormatter());
            }
        }
        // </CustomTradeChartLabelFormatter>

        // <CustomTradeChartLabelProvider>
        class CustomTradeChartLabelProvider extends TradeChartAxisLabelProvider {
            CustomTradeChartLabelProvider() {
                super(new CustomTradeChartLabelFormatter());
            }
        }

        CategoryDateAxis xAxis = new CategoryDateAxis(getContext());
        xAxis.setLabelProvider(new CustomTradeChartLabelProvider());

        PinchZoomModifier pinchZoomModifier = new PinchZoomModifier();
        pinchZoomModifier.setDirection(Direction2D.XDirection);

        CursorModifier cursorModifier = new CursorModifier();
        cursorModifier.setReceiveHandledEvents(true);

        Collections.addAll(surface.getChartModifiers(), pinchZoomModifier, cursorModifier);
        // </CustomTradeChartLabelProvider>
    }
}
