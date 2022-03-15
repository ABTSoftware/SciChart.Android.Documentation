package com.scichart.docsandbox.examples.javaBuilder.axis3DAPIs;

import androidx.annotation.NonNull;

import com.scichart.charting.numerics.coordinateCalculators.ICoordinateCalculator;
import com.scichart.charting3d.visuals.SciChartSurface3D;
import com.scichart.charting3d.visuals.axes.NumericAxis3D;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart3DFragment;

@ExampleDefinition()
public class SciChart3DBasicsCoordinatesIn3DSpace extends SingleChart3DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface3D surface) { }

    void setIsLeftHandedCoordinateSystem(@NonNull SciChartSurface3D surface) {
        // <SetIsLeftHandedCoordinateSystem>
        surface.getViewport3D().setIsLeftHandedCoordinateSystem(false);
        // </SetIsLeftHandedCoordinateSystem>
    }

    void setWorldCoordinates(@NonNull SciChartSurface3D surface) {
        // <SetWorldCoordinates>
        surface.getWorldDimensions().assign(200, 200, 200);
        // </SetWorldCoordinates>
    }

    void convertingFromWorldToDataCoordinates() {
        // <ConvertingFromWorldToDataCoordinates>
        final NumericAxis3D xAxis = new NumericAxis3D();

        ICoordinateCalculator calculator = xAxis.getCurrentCoordinateCalculator();
        float coordinate = calculator.getCoordinate(1.2);

        // Convert back:
        double dataValue = calculator.getDataValue(coordinate);
        // </ConvertingFromWorldToDataCoordinates>
    }
}
