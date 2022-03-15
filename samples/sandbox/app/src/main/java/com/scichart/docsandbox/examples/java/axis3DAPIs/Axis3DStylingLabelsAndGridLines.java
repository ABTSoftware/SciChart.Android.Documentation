package com.scichart.docsandbox.examples.java.axis3DAPIs;

import androidx.annotation.NonNull;

import com.scichart.charting3d.visuals.SciChartSurface3D;
import com.scichart.charting3d.visuals.axes.NumericAxis3D;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart3DFragment;
import com.scichart.drawing.common.SolidBrushStyle;
import com.scichart.drawing.common.SolidPenStyle;

@ExampleDefinition()
public class Axis3DStylingLabelsAndGridLines extends SingleChart3DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface3D surface) { }

    void styleNumericAxis3D() {
        // <StyleNumericAxis3D>
        final NumericAxis3D xAxis = new NumericAxis3D();
        xAxis.setMinorsPerMajor(5);
        xAxis.setMaxAutoTicks(7);
        xAxis.setTextSize(13);
        xAxis.setTextColor(0xFF00FF00);
        xAxis.setTextFont("RobotoCondensed-BoldItalic");
        xAxis.setAxisBandsStyle(new SolidBrushStyle(0xFF556B2F));
        xAxis.setMajorTickLineStyle(new SolidPenStyle(0xFF00FF00, true, 1.0f, null));
        xAxis.setMajorTickLineLength(8.0f);
        xAxis.setMinorTickLineStyle(new SolidPenStyle(0xFFC71585, true, 1.0f, null));
        xAxis.setMinorTickLineLength(4.0f);
        xAxis.setMajorGridLineStyle(new SolidPenStyle(0xFF00FF00, true, 1.0f, null));
        xAxis.setMinorGridLineStyle(new SolidPenStyle(0xFF9400D3, true, 1.0f, null));

        final NumericAxis3D yAxis = new NumericAxis3D();
        yAxis.setMinorsPerMajor(5);
        yAxis.setMaxAutoTicks(7);
        yAxis.setTextSize(13);
        yAxis.setTextColor(0xFFB22222);
        yAxis.setTextFont("RobotoCondensed-BoldItalic");
        yAxis.setAxisBandsStyle(new SolidBrushStyle(0xFFFF6347));
        yAxis.setMajorTickLineStyle(new SolidPenStyle(0xFFB22222, true, 1.0f, null));
        yAxis.setMajorTickLineLength(8.0f);
        yAxis.setMinorTickLineStyle(new SolidPenStyle(0xFFCD5C5C, true, 1.0f, null));
        yAxis.setMinorTickLineLength(4.0f);
        yAxis.setMajorGridLineStyle(new SolidPenStyle(0xFF006400, true, 1.0f, null));
        yAxis.setMinorGridLineStyle(new SolidPenStyle(0xFF8CBED6, true, 1.0f, null));

        final NumericAxis3D zAxis = new NumericAxis3D();
        zAxis.setMinorsPerMajor(5);
        zAxis.setMaxAutoTicks(7);
        zAxis.setTextSize(13);
        zAxis.setTextColor(0xFFDB7093);
        zAxis.setTextFont("RobotoCondensed-BoldItalic");
        zAxis.setAxisBandsStyle(new SolidBrushStyle(0xFFADFF2F));
        zAxis.setMajorTickLineStyle(new SolidPenStyle(0xFFDB7093, true, 1.0f, null));
        zAxis.setMajorTickLineLength(8.0f);
        zAxis.setMinorTickLineStyle(new SolidPenStyle(0xFF7FFF00, true, 1.0f, null));
        zAxis.setMinorTickLineLength(4.0f);
        zAxis.setMajorGridLineStyle(new SolidPenStyle(0xFFF5F5DC, true, 1.0f, null));
        zAxis.setMinorGridLineStyle(new SolidPenStyle(0xFFA52A2A, true, 1.0f, null));
        // </StyleNumericAxis3D>
    }
}
