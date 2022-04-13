package com.scichart.docsandbox.examples.java.advanced2dTopics;

import android.graphics.Bitmap;
import android.graphics.RectF;
import android.graphics.Typeface;

import androidx.annotation.NonNull;

import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;
import com.scichart.docsandbox.examples.base.TestRenderSurfaceRendererFragment;
import com.scichart.drawing.common.BrushStyle;
import com.scichart.drawing.common.FontStyle;
import com.scichart.drawing.common.IAssetManager2D;
import com.scichart.drawing.common.IBrush2D;
import com.scichart.drawing.common.IFont;
import com.scichart.drawing.common.IPen2D;
import com.scichart.drawing.common.IRenderContext2D;
import com.scichart.drawing.common.IRenderSurface;
import com.scichart.drawing.common.IRenderSurfaceRenderer;
import com.scichart.drawing.common.ITexture2D;
import com.scichart.drawing.common.LinearGradientBrushStyle;
import com.scichart.drawing.common.PenStyle;
import com.scichart.drawing.common.RadialGradientBrushStyle;
import com.scichart.drawing.common.SolidBrushStyle;
import com.scichart.drawing.common.SolidPenStyle;
import com.scichart.drawing.common.TextureBrushStyle;
import com.scichart.drawing.common.TextureMappingMode;
import com.scichart.drawing.common.TexturePenStyle;
import com.scichart.drawing.utility.ColorUtil;
import com.scichart.extensions.builders.base.FontStyleBuilder;
import com.scichart.extensions.builders.base.PenStyleBuilder;

@ExampleDefinition()
public class RenderContextAPI extends TestRenderSurfaceRendererFragment {
    @Override
    protected void initExample() { }

    void createRenderSurfaceRenderer() {
        // <CreateRenderSurfaceRenderer>
        class TestRenderSurfaceRenderer implements IRenderSurfaceRenderer{
            private final RectF sprite2Rect = new RectF(0,0, 0.5f, 0.5f);
            private final RectF sprite3Rect = new RectF(0.25f,0.25f, 0.75f, 0.75f);

            private final BrushStyle solidStyle;
            private final BrushStyle linearGradient;
            private final BrushStyle radialGradient;
            private final TextureBrushStyle textureStyle;

            private final PenStyle simpleLine;
            private final PenStyle aaLine;
            private final PenStyle texturedLine;
            private final PenStyle texturedAaLine;

            private final PenStyle dashedSimpleLine;
            private final PenStyle dashedAaLine;
            private final PenStyle dashedTexturedLine;
            private final PenStyle dashedTexturedAaLine;

            private final PenStyle thickSimpleLine;
            private final PenStyle thickAaLine;
            private final PenStyle thickTexturedLine;
            private final PenStyle thickTexturedAaLine;

            private final PenStyle dashedThickSimpleLine;
            private final PenStyle dashedThickAaLine;
            private final PenStyle dashedThickTexturedLine;
            private final PenStyle dashedThickTexturedAaLine;

            private final FontStyle fontStyle;
            private final FontStyle customFontStyle;

            private final Bitmap texture;

            private final float[] xAxisArrow = {0,0, 50, 0, 30, -10, 50, 0, 30, 10, 50, 0};
            private final float[] yAxisArrow = {0,0, 0, 50, -10, 30, 0, 50, 10, 30, 0, 50};

            private float degrees, dx, dy, opacity;

            public TestRenderSurfaceRenderer(Bitmap texture) {
                solidStyle = new SolidBrushStyle(ColorUtil.argb(0xEE, 0xFF, 0xC9, 0xA8));
                linearGradient = new LinearGradientBrushStyle(0, 0, 1, 1, ColorUtil.argb(0xEE, 0xFF, 0xC9, 0xA8), ColorUtil.argb(0xEE, 0x13, 0x24, 0xA5));
                radialGradient = new RadialGradientBrushStyle(0.5f, 0.5f, 0.5f, 0.5f, ColorUtil.argb(0xEE, 0xFF, 0xC9, 0xA8), ColorUtil.argb(0xEE, 0x13, 0x24, 0xA5));
                textureStyle = new TextureBrushStyle(texture);

                fontStyle = new FontStyle(32, ColorUtil.Red);
                customFontStyle = new FontStyle(Typeface.create(Typeface.SANS_SERIF, Typeface.BOLD_ITALIC), 23, ColorUtil.Yellow, false);

                simpleLine = new SolidPenStyle(ColorUtil.Red, false, 1f, null);
                aaLine = new SolidPenStyle(ColorUtil.Green, true, 1f, null);
                texturedLine = new TexturePenStyle(textureStyle, false, 1f, null);
                texturedAaLine = new TexturePenStyle(textureStyle, true, 1f, null);

                dashedSimpleLine = new SolidPenStyle(ColorUtil.Blue, false, 1f, new float[]{5, 10, 5, 10});
                dashedAaLine = new SolidPenStyle(ColorUtil.Magenta, true, 1f, new float[]{10, 5, 10, 5});
                dashedTexturedLine = new TexturePenStyle(textureStyle, false, 1f, new float[]{5, 10, 5, 10});
                dashedTexturedAaLine = new TexturePenStyle(textureStyle, true, 1f, new float[]{10, 5, 10, 5});

                thickSimpleLine = new SolidPenStyle(ColorUtil.Red, false, 10f, null);
                thickAaLine = new SolidPenStyle(ColorUtil.Green, true, 10f, null);
                thickTexturedLine = new TexturePenStyle(textureStyle, false, 10f, null);
                thickTexturedAaLine = new TexturePenStyle(textureStyle, true, 10f, null);

                dashedThickSimpleLine = new SolidPenStyle(ColorUtil.Blue, false, 20f, new float[]{5, 10, 5, 10});
                dashedThickAaLine = new SolidPenStyle(ColorUtil.Magenta, true, 20f, new float[]{0, 20, 10, 5});
                dashedThickTexturedLine = new TexturePenStyle(textureStyle, false, 20f, new float[]{5, 10, 5, 10});
                dashedThickTexturedAaLine = new TexturePenStyle(textureStyle, true, 20f, new float[]{0, 20, 10, 5});

                this.texture = texture;
            }

            @Override
            public void onSurfaceAttached(IRenderSurface surface) { }

            @Override
            public void onSurfaceDetached(IRenderSurface surface) { }

            @Override
            public void onSurfaceSizeChanged(int width, int height, int oldWidth, int oldHeight) { }

            public void setTransform(float degrees, float dx, float dy, float opacity){
                this.degrees = degrees;
                this.dx = dx  - binding.translateX.getMax() / 2f;
                this.dy = dy - binding.translateY.getMax() / 2f;
                this.opacity = opacity;
            }

            @Override
            public void onDraw(IRenderContext2D renderContext, IAssetManager2D assetManager) {
                renderContext.translate(dx, dy);
                renderContext.rotate(degrees);

                final IBrush2D solidBrushPerScreen = assetManager.createBrush(solidStyle, TextureMappingMode.PerScreen, opacity);
                final IBrush2D radialGradientBrushPerScreen = assetManager.createBrush(radialGradient, TextureMappingMode.PerScreen, opacity);
                final IBrush2D linearGradientBrushPerScreen = assetManager.createBrush(linearGradient, TextureMappingMode.PerScreen, opacity);
                final IBrush2D textureBrushPerScreen = assetManager.createBrush(textureStyle, TextureMappingMode.PerScreen, opacity);

                final IBrush2D solidBrushPerPrimitive = assetManager.createBrush(solidStyle, TextureMappingMode.PerPrimitive, opacity);
                final IBrush2D radialGradientBrushPerPrimitive = assetManager.createBrush(radialGradient, TextureMappingMode.PerPrimitive, opacity);
                final IBrush2D linearGradientBrushPerPrimitive = assetManager.createBrush(linearGradient, TextureMappingMode.PerPrimitive, opacity);
                final IBrush2D textureBrushPerPrimitive = assetManager.createBrush(textureStyle, TextureMappingMode.PerPrimitive, opacity);

                final IPen2D simpleLine = assetManager.createPen(this.simpleLine, opacity);
                final IPen2D aaLine = assetManager.createPen(this.aaLine, opacity);
                final IPen2D dashedSimpleLine = assetManager.createPen(this.dashedSimpleLine, opacity);
                final IPen2D dashedAaLine = assetManager.createPen(this.dashedAaLine, opacity);
                final IPen2D thickSimpleLine = assetManager.createPen(this.thickSimpleLine, opacity);
                final IPen2D thickAaLine = assetManager.createPen(this.thickAaLine, opacity);
                final IPen2D dashedThickSimpleLine = assetManager.createPen(this.dashedThickSimpleLine, opacity);
                final IPen2D dashedThickAaLine = assetManager.createPen(this.dashedThickAaLine, opacity);

                final IPen2D texturedLine = assetManager.createPen(this.texturedLine, opacity);
                final IPen2D texturedAaLine = assetManager.createPen(this.texturedAaLine, opacity);
                final IPen2D dashedTexturedLine = assetManager.createPen(this.dashedTexturedLine, opacity);
                final IPen2D dashedTexturedAaLine = assetManager.createPen(this.dashedTexturedAaLine, opacity);
                final IPen2D thickTexturedLine = assetManager.createPen(this.thickTexturedLine, opacity);
                final IPen2D thickTexturedAaLine = assetManager.createPen(this.thickTexturedAaLine, opacity);
                final IPen2D dashedThickTexturedLine = assetManager.createPen(this.dashedThickTexturedLine, opacity);
                final IPen2D dashedThickTexturedAaLine = assetManager.createPen(this.dashedThickTexturedAaLine, opacity);

                final IFont font = assetManager.createFont(this.fontStyle);
                final IFont customFont = assetManager.createFont(this.customFontStyle);

                final ITexture2D sprite1 = assetManager.createTexture(texture);
                final ITexture2D sprite2 = assetManager.createTexture(texture, sprite2Rect);
                final ITexture2D sprite3 = assetManager.createTexture(texture, sprite3Rect);

                renderContext.drawLines(xAxisArrow, 0, xAxisArrow.length, simpleLine);
                renderContext.drawLines(yAxisArrow, 0, yAxisArrow.length, aaLine);

                renderContext.save();
                renderContext.translate(10, 10);

                renderContext.drawLine(0, 0, 80, 80, simpleLine);
                renderContext.drawLine(100, 0, 180, 80, aaLine);
                renderContext.drawLine(200, 0, 280, 80, dashedSimpleLine);
                renderContext.drawLine(300, 0, 380, 80, dashedAaLine);

                renderContext.drawLine(0, 100, 80, 180, thickSimpleLine);
                renderContext.drawLine(100, 100, 180, 180, thickAaLine);
                renderContext.drawLine(200, 100, 280, 180, dashedThickSimpleLine);
                renderContext.drawLine(300, 100, 380, 180, dashedThickAaLine);

                renderContext.translate(0, 200);

                renderContext.drawLine(0, 0, 80, 80, texturedLine);
                renderContext.drawLine(100, 0, 180, 80, texturedAaLine);
                renderContext.drawLine(200, 0, 280, 80, dashedTexturedLine);
                renderContext.drawLine(300, 0, 380, 80, dashedTexturedAaLine);

                renderContext.drawLine(0, 100, 80, 180, thickTexturedLine);
                renderContext.drawLine(100, 100, 180, 180, thickTexturedAaLine);
                renderContext.drawLine(200, 100, 280, 180, dashedThickTexturedLine);
                renderContext.drawLine(300, 100, 380, 180, dashedThickTexturedAaLine);

                renderContext.translate(0, 200);

                renderContext.drawRect(0, 0, 80, 80, simpleLine);
                renderContext.drawRect(100, 0, 180, 80, aaLine);
                renderContext.drawRect(200, 0, 280, 80, dashedSimpleLine);
                renderContext.drawRect(300, 0, 380, 80, dashedAaLine);

                renderContext.drawRect(0, 100, 80, 180, thickSimpleLine);
                renderContext.drawRect(100, 100, 180, 180, thickAaLine);
                renderContext.drawRect(200, 100, 280, 180, dashedThickSimpleLine);
                renderContext.drawRect(300, 100, 380, 180, dashedThickAaLine);

                renderContext.translate(0, 200);

                renderContext.fillRect(0, 0, 80, 80, solidBrushPerScreen);
                renderContext.fillRect(100, 0, 180, 80, linearGradientBrushPerScreen);
                renderContext.fillRect(200, 0, 280, 80, radialGradientBrushPerScreen);
                renderContext.fillRect(300, 0, 380, 80, textureBrushPerScreen);

                renderContext.fillRect(0, 100, 80, 180, solidBrushPerPrimitive);
                renderContext.fillRect(100, 100, 180, 180, linearGradientBrushPerPrimitive);
                renderContext.fillRect(200, 100, 280, 180, radialGradientBrushPerPrimitive);
                renderContext.fillRect(300, 100, 380, 180, textureBrushPerPrimitive);

                renderContext.translate(0, 200);

                renderContext.drawEllipse(50, 50, 80, 80, simpleLine, solidBrushPerScreen);
                renderContext.drawEllipse(150, 50, 80, 80, aaLine, linearGradientBrushPerScreen);
                renderContext.drawEllipse(250, 50, 80, 80, dashedSimpleLine, radialGradientBrushPerScreen);
                renderContext.drawEllipse(350, 50, 80, 80, dashedAaLine, textureBrushPerScreen);

                renderContext.drawEllipse(50, 150, 80, 80, thickSimpleLine, solidBrushPerPrimitive);
                renderContext.drawEllipse(150, 150, 80, 80, thickAaLine, linearGradientBrushPerPrimitive);
                renderContext.drawEllipse(250, 150, 80, 80, dashedThickSimpleLine, radialGradientBrushPerPrimitive);
                renderContext.drawEllipse(350, 150, 80, 80, dashedThickAaLine, textureBrushPerPrimitive);

                renderContext.restore();
                renderContext.save();
                renderContext.translate(500, 0);

                renderContext.drawText(font, 0, 0, fontStyle.textColor, "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
                renderContext.drawText(font, 0, 50, fontStyle.textColor, "abcdefghijklmnopqrstuvwxyz");
                renderContext.drawText(font, 0, 100, fontStyle.textColor, "1234567890~!@#$%^&*()-+=/|\\'\"");

                renderContext.drawText(customFont, 0, 150, customFontStyle.textColor, "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
                renderContext.drawText(customFont, 0, 200, customFontStyle.textColor, "abcdefghijklmnopqrstuvwxyz");
                renderContext.drawText(customFont, 0, 250, customFontStyle.textColor, "1234567890~!@#$%^&*()-+=/|\\'\"");

                renderContext.translate(0, 300);

                renderContext.drawSprite(sprite1, 0, 0, opacity);
                renderContext.translate(0, sprite1.getHeight() + 10);

                renderContext.drawSprite(sprite2, 0, 0, opacity);
                renderContext.translate(0, sprite2.getHeight() + 10);

                renderContext.drawSprite(sprite3, 0, 0, opacity);
                renderContext.translate(0, sprite3.getHeight() + 10);

                final float[] triangles = new float[8];
                triangles[0] = 0; triangles[1] = 0;
                triangles[2] = 100; triangles[3] = 0;
                triangles[4] = 100; triangles[5] = 200;
                triangles[6] = 200; triangles[7] = 200;

                renderContext.save();

                renderContext.drawTrianglesStrip(triangles, 0, 8, solidBrushPerScreen);
                renderContext.translate(210, 0);

                renderContext.drawTrianglesStrip(triangles, 0, 8, linearGradientBrushPerScreen);
                renderContext.translate(210, 0);

                renderContext.drawTrianglesStrip(triangles, 0, 8, radialGradientBrushPerScreen);
                renderContext.translate(210, 0);

                renderContext.drawTrianglesStrip(triangles, 0, 8, textureBrushPerScreen);
                renderContext.translate(210, 0);

                renderContext.restore();
                renderContext.save();
                renderContext.translate(0, 210);

                renderContext.drawTrianglesStrip(triangles, 0, 8, solidBrushPerPrimitive);
                renderContext.translate(210, 0);

                renderContext.drawTrianglesStrip(triangles, 0, 8, linearGradientBrushPerPrimitive);
                renderContext.translate(210, 0);

                renderContext.drawTrianglesStrip(triangles, 0, 8, radialGradientBrushPerPrimitive);
                renderContext.translate(210, 0);

                renderContext.drawTrianglesStrip(triangles, 0, 8, textureBrushPerPrimitive);
                renderContext.translate(210, 0);

                sprite1.dispose();
                sprite2.dispose();
                sprite3.dispose();
            }
        }
        // </CreateRenderSurfaceRenderer>
    }
}
