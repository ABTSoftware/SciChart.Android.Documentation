package com.scichart.docsandbox.examples.kotlin.stylingAndTheming

import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.Typeface
import com.scichart.charting.visuals.SciChartSurface
import com.scichart.docsandbox.R
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment
import com.scichart.drawing.common.*
import com.scichart.drawing.utility.ColorUtil

@ExampleDefinition()
class PenStyle_BrushStyle_FontStyle : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {
        createPen()
        createBrush()
        createFontStyle()
    }

    fun createPen() {
        val linearGradientBrush = LinearGradientBrushStyle(0f, 0f, 0f, 1f, Color.RED, Color.BLUE)
        val radialGradientBrush =
            RadialGradientBrushStyle(0.5f, 0.5f, 0.25f, 0.5f, Color.RED, Color.BLUE)
        val texture = BitmapFactory.decodeResource(resources, R.drawable.example_scichartlogo)
        val textureBrush = TextureBrushStyle(texture)

        // <CreatePen>
        // Solid Pen
        val solidPenStyle = SolidPenStyle(-0x661167, true, 1f, floatArrayOf(10f, 3f, 10f, 3f))

        // Linear Gradient Pen requires LinearGradientBrushStyle
        val linearGradientPenStyle = LinearGradientPenStyle(linearGradientBrush, true, 1f, null)

        // Radial Gradient Pen requires RadialGradientBrushStyle
        val radialGradientPenStyle = RadialGradientPenStyle(radialGradientBrush, true, 1f, null)

        // Texture Pen requires TextureBrushStyle
        val texturedPenStyle = TexturePenStyle(textureBrush, true, 1f, null)
        // </CreatePen>
    }

    fun createBrush() {
        val texture = BitmapFactory.decodeResource(resources, R.drawable.example_scichartlogo)

        // <CreateBrush>
        // Solid Brush
        val solidBrushStyle = SolidBrushStyle(Color.RED)

        // Linear Gradient Brush
        val linearGradientBrush = LinearGradientBrushStyle(0f, 0f, 0f, 1f, Color.RED, Color.BLUE)

        // Radial Gradient Brush
        val radialGradientBrush = RadialGradientBrushStyle(0.5f, 0.5f, 0.25f, 0.5f, Color.RED, Color.BLUE)

        // Texture Brush - Bitmap with Texture should be provided
        val textureBrush = TextureBrushStyle(texture)
        // </CreateBrush>
    }

    fun createFontStyle() {
        // <CreateFontStyle>
        val typeface = Typeface.createFromAsset(requireActivity().assets, "font/font.ttf")
        val fontStyle = FontStyle(typeface, 14f, ColorUtil.Red, true)
        // </CreateFontStyle>
    }
}
