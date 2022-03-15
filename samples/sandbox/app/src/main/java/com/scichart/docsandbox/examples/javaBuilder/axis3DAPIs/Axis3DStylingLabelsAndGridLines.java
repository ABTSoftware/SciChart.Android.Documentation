package com.scichart.docsandbox.examples.javaBuilder.axis3DAPIs;

import androidx.annotation.NonNull;

import com.scichart.charting3d.visuals.SciChartSurface3D;
import com.scichart.charting3d.visuals.axes.NumericAxis3D;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart3DFragment;

@ExampleDefinition()
public class Axis3DStylingLabelsAndGridLines extends SingleChart3DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface3D surface) { }

    void styleNumericAxis3D() {
        // <StyleNumericAxis3D>
        final NumericAxis3D xAxis = sciChart3DBuilder.newNumericAxis3D()
                .withMinorsPerMajor(5)
                .withMaxAutoTicks(7)
                .withTextSize(13)
                .withTextColor(0xFF00FF00)
                .withTextFont("RobotoCondensed-BoldItalic")
                .withAxisBandsFill(0xFF556B2F)
                .withMajorTickLineStyle(0xFF00FF00)
                .withMajorTickLineLength(8.0f)
                .withMinorTickLineStyle(0xFFC71585)
                .withMinorTickLineLength(4.0f)
                .withMajorGridLineStyle(0xFF00FF00)
                .withMinorGridLineStyle(0xFF9400D3)
                .build();

        final NumericAxis3D yAxis = sciChart3DBuilder.newNumericAxis3D()
                .withMinorsPerMajor(5)
                .withMaxAutoTicks(7)
                .withTextSize(13)
                .withTextColor(0xFFB22222)
                .withTextFont("RobotoCondensed-BoldItalic")
                .withAxisBandsFill(0xFFFF6347)
                .withMajorTickLineStyle(0xFFB22222)
                .withMajorTickLineLength(8.0f)
                .withMinorTickLineStyle(0xFFCD5C5C)
                .withMinorTickLineLength(4.0f)
                .withMajorGridLineStyle(0xFF006400)
                .withMinorGridLineStyle(0xFF8CBED6)
                .build();

        final NumericAxis3D zAxis = sciChart3DBuilder.newNumericAxis3D()
                .withMinorsPerMajor(5)
                .withMaxAutoTicks(7)
                .withTextSize(13)
                .withTextColor(0xFFDB7093)
                .withTextFont("RobotoCondensed-BoldItalic")
                .withAxisBandsFill(0xFFADFF2F)
                .withMajorTickLineStyle(0xFFDB7093)
                .withMajorTickLineLength(8.0f)
                .withMinorTickLineStyle(0xFF7FFF00)
                .withMinorTickLineLength(4.0f)
                .withMajorGridLineStyle(0xFFF5F5DC)
                .withMinorGridLineStyle(0xFFA52A2A)
                .build();
        // </StyleNumericAxis3D>
    }
}
