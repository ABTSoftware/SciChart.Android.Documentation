package com.scichart.docsandbox.examples.kotlin.axis3DAPIs

import com.scichart.charting3d.visuals.SciChartSurface3D
import com.scichart.charting3d.visuals.axes.NumericAxis3D
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart3DFragment
import com.scichart.drawing.common.SolidBrushStyle
import com.scichart.drawing.common.SolidPenStyle

@ExampleDefinition()
class Axis3DStylingLabelsAndGridLines : SingleChart3DFragment() {
    override fun initExample(surface: SciChartSurface3D) {}

    fun styleNumericAxis3D() {
        // <StyleNumericAxis3D>
        val xAxis = NumericAxis3D()
        xAxis.minorsPerMajor = 5
        xAxis.maxAutoTicks = 7
        xAxis.textSize = 13f
        xAxis.textColor = -0xff0100
        xAxis.textFont = "RobotoCondensed-BoldItalic"
        xAxis.axisBandsStyle = SolidBrushStyle(-0xaa94d1)
        xAxis.majorTickLineStyle = SolidPenStyle(-0xff0100, true, 1.0f, null)
        xAxis.majorTickLineLength = 8.0f
        xAxis.minorTickLineStyle = SolidPenStyle(-0x38ea7b, true, 1.0f, null)
        xAxis.minorTickLineLength = 4.0f
        xAxis.majorGridLineStyle = SolidPenStyle(-0xff0100, true, 1.0f, null)
        xAxis.minorGridLineStyle = SolidPenStyle(-0x6bff2d, true, 1.0f, null)

        val yAxis = NumericAxis3D()
        yAxis.minorsPerMajor = 5
        yAxis.maxAutoTicks = 7
        yAxis.textSize = 13f
        yAxis.textColor = -0x4dddde
        yAxis.textFont = "RobotoCondensed-BoldItalic"
        yAxis.axisBandsStyle = SolidBrushStyle(-0x9cb9)
        yAxis.majorTickLineStyle = SolidPenStyle(-0x4dddde, true, 1.0f, null)
        yAxis.majorTickLineLength = 8.0f
        yAxis.minorTickLineStyle = SolidPenStyle(-0x32a3a4, true, 1.0f, null)
        yAxis.minorTickLineLength = 4.0f
        yAxis.majorGridLineStyle = SolidPenStyle(-0xff9c00, true, 1.0f, null)
        yAxis.minorGridLineStyle = SolidPenStyle(-0x73412a, true, 1.0f, null)

        val zAxis = NumericAxis3D()
        zAxis.minorsPerMajor = 5
        zAxis.maxAutoTicks = 7
        zAxis.textSize = 13f
        zAxis.textColor = -0x248f6d
        zAxis.textFont = "RobotoCondensed-BoldItalic"
        zAxis.axisBandsStyle = SolidBrushStyle(-0x5200d1)
        zAxis.majorTickLineStyle = SolidPenStyle(-0x248f6d, true, 1.0f, null)
        zAxis.majorTickLineLength = 8.0f
        zAxis.minorTickLineStyle = SolidPenStyle(-0x800100, true, 1.0f, null)
        zAxis.minorTickLineLength = 4.0f
        zAxis.majorGridLineStyle = SolidPenStyle(-0xa0a24, true, 1.0f, null)
        zAxis.minorGridLineStyle = SolidPenStyle(-0x5ad5d6, true, 1.0f, null)
        // </StyleNumericAxis3D>
    }
}
