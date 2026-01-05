package com.scichart.docsandbox.examples.java.axisAPIs;

import androidx.annotation.NonNull;

import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.axes.IAxis;
import com.scichart.charting.visuals.axes.NumericAxis;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;
import com.scichart.drawing.common.AxisBorderStyle;
import com.scichart.drawing.common.SolidBrushStyle;
import com.scichart.drawing.common.SolidPenStyle;

@ExampleDefinition()
public class AxisStylingGridLinesTicksAndAxisBands extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) { }

    void setTickLineStyle() {
        // <SetTickLineStyle>
        final NumericAxis axis = new NumericAxis(getContext());
        axis.setMinorTickLineStyle(new SolidPenStyle(0xFF279B27, true, 2f, null));
        axis.setMajorTickLineStyle(new SolidPenStyle(0xFF279B27, true, 4f, null));
        // </SetTickLineStyle>
    }

    void setGridLineStyle() {
        // <SetGridLineStyle>
        final NumericAxis axis = new NumericAxis(getContext());
        axis.setMinorGridLineStyle(new SolidPenStyle(0x33279B27, true, 1f, null));
        axis.setMajorGridLineStyle(new SolidPenStyle(0xFF279B27, true, 3f, new float[]{5f, 15f}));
        // </SetGridLineStyle>
    }

    void setAxisBandsStyle() {
        // <SetAxisBandsStyle>
        final NumericAxis axis = new NumericAxis(getContext());
        axis.setAxisBandsStyle(new SolidBrushStyle(0x22279B27));
        // </SetAxisBandsStyle>
    }

    void setAxisBorderStyle(IAxis xAxis) {
        // <SetAxisBorderStyle>
        // Assume xAxis has been created and configured somewhere
        xAxis.setAxisBorderStyle(new AxisBorderStyle(0xFF4FBEE6, true, 3));

        // Alternatively, set individual thickness for each side, you can set 0 thickness for sides you don't want to style
        xAxis.setAxisBorderStyle(new AxisBorderStyle(0xFF4FBEE6, true, 3f, 0f, 3f, 0f));
        // </SetAxisBorderStyle>
    }
}
