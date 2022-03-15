package com.scichart.docsandbox.examples.javaBuilder.axisAPIs;

import androidx.annotation.NonNull;

import com.scichart.charting.numerics.tickCoordinatesProviders.DefaultTickCoordinatesProvider;
import com.scichart.charting.numerics.tickCoordinatesProviders.TickCoordinates;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.axes.NumericAxis;
import com.scichart.core.model.FloatValues;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;

@ExampleDefinition()
public class AxisTicksTickCoordinatesProviderAPI extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) { }

    void createCustomTickCoordinatesProvider() {
        // <CreateCustomTickCoordinatesProvider>
        class CustomTickCoordinatesProvider extends DefaultTickCoordinatesProvider {
            @Override
            public void update() {
                super.update();

                final TickCoordinates tickCoordinates = getTickCoordinates();
                // majorTickCoords contains coordinates of major ticks on screen
                final FloatValues majorTickCoords = tickCoordinates.getMajorTickCoordinates();
                // minorTickCoords contains coordinates of minor ticks on screen
                final FloatValues minorTickCoords = tickCoordinates.getMinorTickCoordinates();

                // TODO: Provide minor and major Tick Coordinates
            }
        }
        // </CreateCustomTickCoordinatesProvider>

        // <UseCustomTickCoordinatesProvider>
        final NumericAxis axis = sciChartBuilder.newNumericAxis().build();
        axis.setTickCoordinatesProvider(new CustomTickCoordinatesProvider());
        // </UseCustomTickCoordinatesProvider>
    }
}
