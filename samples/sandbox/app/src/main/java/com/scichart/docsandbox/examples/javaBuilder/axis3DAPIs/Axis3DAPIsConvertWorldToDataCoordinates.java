package com.scichart.docsandbox.examples.javaBuilder.axis3DAPIs;

import androidx.annotation.NonNull;

import com.scichart.charting.numerics.coordinateCalculators.ICoordinateCalculator;
import com.scichart.charting3d.visuals.SciChartSurface3D;
import com.scichart.charting3d.visuals.axes.DateAxis3D;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart3DFragment;

import java.util.Calendar;
import java.util.Date;

@ExampleDefinition()
public class Axis3DAPIsConvertWorldToDataCoordinates extends SingleChart3DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface3D surface) { }

    void numericAxis3DConversions() {
        // <NumericAxis3DConversions>
        final DateAxis3D yAxis = sciChart3DBuilder.newDateAxis3D().build();

        final ICoordinateCalculator calculator = yAxis.getCurrentCoordinateCalculator();
        float coordinate = calculator.getCoordinate(50);

        // Convert back:
        double dataValue = calculator.getDataValue(coordinate);
        // </NumericAxis3DConversions>
    }

    void dateAxis3DConversions() {
        // <DateAxis3DConversions>
        final DateAxis3D zAxis = sciChart3DBuilder.newDateAxis3D().build();
        final ICoordinateCalculator calculator = zAxis.getCurrentCoordinateCalculator();

        final Calendar calendarDate = Calendar.getInstance();
        calendarDate.set(2011, Calendar.MAY, 5);
        final Date date = calendarDate.getTime();
        float coordinate = calculator.getCoordinate(date.getTime());

        // Convert back:
        double dateInMillis = calculator.getDataValue(coordinate);
        Date dateValue = new Date((long) dateInMillis);
        // </DateAxis3DConversions>
    }
}
