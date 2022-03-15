package com.scichart.docsandbox.examples.java.axisAPIs;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;

import com.scichart.charting.numerics.coordinateCalculators.ICoordinateCalculator;
import com.scichart.charting.numerics.labelProviders.ICategoryLabelProvider;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.axes.CategoryDateAxis;
import com.scichart.charting.visuals.axes.DateAxis;
import com.scichart.charting.visuals.axes.NumericAxis;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;

import java.util.Calendar;
import java.util.Date;

@ExampleDefinition()
public class AxisAPIsConvertPixelToDataCoordinates extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) { }

    void numericAxisConversions() {
        final NumericAxis xAxis = new NumericAxis(getContext());
        // <NumericAxisConversions>
        float coordinate = xAxis.getCoordinate(1.2);

        // Convert back:
        Comparable dataValue = xAxis.getDataValue(coordinate);
        // </NumericAxisConversions>
    }

    void dateAxisConversions() {
        // <DateAxisConversions>
        final DateAxis xAxis = new DateAxis(getContext());

        final Calendar calendarDate = Calendar.getInstance();
        calendarDate.set(2011, Calendar.MAY, 1);
        final Date date = calendarDate.getTime();

        float coordinate = xAxis.getCoordinate(date);
        // Convert back:
        Comparable dataValue = xAxis.getDataValue(coordinate);
        // </DateAxisConversions>
    }

    void categoryDateAxisConversions() {
        // <CategoryDateAxisConversions>
        final CategoryDateAxis xAxis = new CategoryDateAxis(getContext());

        final Calendar calendarDate = Calendar.getInstance();
        calendarDate.set(2011, Calendar.OCTOBER, 5);
        final Date date = calendarDate.getTime();

        float coordinate = xAxis.getCoordinate(date);

        // Convert back:
        Comparable dataValue = xAxis.getDataValue(coordinate);
        // </CategoryDateAxisConversions>
    }

    void numericAxisCoordinateCalculator() {
        // <NumericAxisCoordinateCalculator>
        final NumericAxis xAxis = new NumericAxis(getContext());

        final ICoordinateCalculator calculator = xAxis.getCurrentCoordinateCalculator();
        float coordinate = calculator.getCoordinate(1.2);

        // Convert back:
        double dataValue = calculator.getDataValue(coordinate);
        // </NumericAxisCoordinateCalculator>
    }

    void dateAxisCoordinateCalculator() {
        // <DateAxisCoordinateCalculator>
        final DateAxis xAxis = new DateAxis(getContext());

        final ICoordinateCalculator calculator = xAxis.getCurrentCoordinateCalculator();

        final Calendar calendarDate = Calendar.getInstance();
        calendarDate.set(2011, Calendar.MAY, 5);
        final Date date = calendarDate.getTime();

        float coordinate = calculator.getCoordinate(date.getTime());

        // Convert back:
        double dateInMillis = calculator.getDataValue(coordinate);
        Date dateValue = new Date((long) dateInMillis);
        // </DateAxisCoordinateCalculator>
    }

    void categoryDateAxisCoordinateCalculator() {
        // <CategoryDateAxisCoordinateCalculator>
        final CategoryDateAxis xAxis = new CategoryDateAxis(getContext());
        final ICoordinateCalculator calculator = xAxis.getCurrentCoordinateCalculator();

        // get ICategoryLabelProvider to convert Date value to Index
        final ICategoryLabelProvider labelProvider = (ICategoryLabelProvider) xAxis.getLabelProvider();

        final Calendar calendarDate = Calendar.getInstance();
        calendarDate.set(2011, Calendar.OCTOBER, 5);
        Date date = calendarDate.getTime();

        double index = (double) labelProvider.transformDataToIndex(date.getTime());
        double coordinate = calculator.getCoordinate(index);

        // Convert back:
        index = (int) calculator.getDataValue((float) coordinate);
        // use the ICategoryLabelProvider instance to convert index to Date value
        date = new Date((long) labelProvider.transformIndexToData((int)index));
        // </CategoryDateAxisCoordinateCalculator>
    }

    void transformingPixels() {
        final NumericAxis xAxis = new NumericAxis(getContext());

        // <TransformingPixels>
        SciChartSurface surface = new SciChartSurface(getActivity());
        surface.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // the touch point relative to the SciChartSurface
                PointF touchPoint = new PointF(event.getX(), event.getY());

                // translate the touch point relative to RenderableSeriesArea or ModifierSurface
                surface.translatePoint(touchPoint, surface.getRenderableSeriesArea());

                //OR surface.translatePoint(touchPoint, surface.getModifierSurface());
                // the translated point can be used for looking for data values
                double dataValue = (Double)xAxis.getDataValue(touchPoint.x);

                return true;
            }
        });
        // </TransformingPixels>
    }
}
