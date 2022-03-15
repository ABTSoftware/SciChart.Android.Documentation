package com.scichart.docsandbox.examples.javaBuilder.stylingAndTheming;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;

import androidx.annotation.NonNull;

import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.docsandbox.R;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;
import com.scichart.drawing.common.FontStyle;
import com.scichart.drawing.common.LinearGradientBrushStyle;
import com.scichart.drawing.common.LinearGradientPenStyle;
import com.scichart.drawing.common.PenStyle;
import com.scichart.drawing.common.RadialGradientBrushStyle;
import com.scichart.drawing.common.RadialGradientPenStyle;
import com.scichart.drawing.common.SolidBrushStyle;
import com.scichart.drawing.common.TextureBrushStyle;
import com.scichart.drawing.common.TexturePenStyle;

@ExampleDefinition()
public class PenStyle_BrushStyle_FontStyle extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) {
        createPen();
        createBrush();
        createFontStyle();
    }

    void createPen() {
        final LinearGradientBrushStyle linearGradientBrush = new LinearGradientBrushStyle(0, 0, 0, 1, Color.RED, Color.BLUE);
        final RadialGradientBrushStyle radialGradientBrush = new RadialGradientBrushStyle(0.5f, 0.5f, 0.25f, 0.5f, Color.RED, Color.BLUE);

        final Bitmap texture = BitmapFactory.decodeResource(getResources(), R.drawable.example_scichartlogo);
        final TextureBrushStyle textureBrush = new TextureBrushStyle(texture);

        // <CreatePen>
        // Solid Pen
        PenStyle solidPenStyle = sciChartBuilder.newPen()
                .withColor(0xFF99EE99)
                .withAntiAliasing(true)
                .withThickness(1f)
                .withStrokeDashArray(new float[]{10, 3, 10, 3})
                .build();

        // Linear Gradient Pen requires LinearGradientBrushStyle
        final LinearGradientPenStyle linearGradientPenStyle = new LinearGradientPenStyle(linearGradientBrush, true, 1f, null);

        // Radial Gradient Pen requires RadialGradientBrushStyle
        final RadialGradientPenStyle radialGradientPenStyle = new RadialGradientPenStyle(radialGradientBrush, true, 1f, null);

        // Texture Pen requires TextureBrushStyle
        final TexturePenStyle texturedPenStyle = new TexturePenStyle(textureBrush, true, 1f, null);
        // </CreatePen>
    }

    void createBrush() {
        final Bitmap texture = BitmapFactory.decodeResource(getResources(), R.drawable.example_scichartlogo);

        // <CreateBrush>
        // Solid Brush
        final SolidBrushStyle solidBrushStyle = new SolidBrushStyle(Color.RED);

        // Linear Gradient Brush
        final LinearGradientBrushStyle linearGradientBrush = new LinearGradientBrushStyle(0, 0, 0, 1, Color.RED, Color.BLUE);

        // Radial Gradient Brush
        final RadialGradientBrushStyle radialGradientBrush = new RadialGradientBrushStyle(0.5f, 0.5f, 0.25f, 0.5f, Color.RED, Color.BLUE);

        // Texture Brush - Bitmap with Texture should be provided
        final TextureBrushStyle textureBrush = new TextureBrushStyle(texture);
        // </CreateBrush>
    }

    void createFontStyle() {
        // <CreateFontStyle>
        Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(), "font/font.ttf");
        FontStyle fontStyle = sciChartBuilder.newFont()
                .withTypeface(typeface)
                .withTextSize(14)
                .withTextColor(Color.RED)
                .withAntiAliasing(true)
                .build();
        // </CreateFontStyle>
    }
}
