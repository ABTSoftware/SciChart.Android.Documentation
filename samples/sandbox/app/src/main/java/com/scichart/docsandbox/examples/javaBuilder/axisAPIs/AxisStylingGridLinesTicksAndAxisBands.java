package com.scichart.docsandbox.examples.javaBuilder.axisAPIs;

import androidx.annotation.NonNull;

import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.axes.NumericAxis;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;
import com.scichart.drawing.common.SolidPenStyle;

@ExampleDefinition()
public class AxisStylingGridLinesTicksAndAxisBands extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) { }

    void setTickLineStyle() {
        // <SetTickLineStyle>
        final NumericAxis axis = sciChartBuilder.newNumericAxis()
                .withMinorTickLineStyle(0xFF279B27, 2f)
                .withMajorTickLineStyle(0xFF279B27, 4f)
                .build();
        // </SetTickLineStyle>
    }

    void setGridLineStyle() {
        // <SetGridLineStyle>
        final NumericAxis axis = sciChartBuilder.newNumericAxis()
                .withMinorGridLineStyle(new SolidPenStyle(0x33279B27, true, 1f, null))
                .withMajorGridLineStyle(new SolidPenStyle(0xFF279B27, true, 3f, new float[]{5f, 15f}))
                .build();
        // </SetGridLineStyle>
    }

    void setAxisBandsStyle() {
        // <SetAxisBandsStyle>
        final NumericAxis axis = sciChartBuilder.newNumericAxis()
                .withAxisBandsFill(0x22279B27)
                .build();
        // </SetAxisBandsStyle>
    }
}
