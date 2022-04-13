package com.scichart.docsandbox.examples.kotlin.advanced2dTopics

import android.graphics.Bitmap
import android.graphics.RectF
import android.graphics.Typeface
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.TestRenderSurfaceRendererFragment
import com.scichart.drawing.common.*
import com.scichart.drawing.utility.ColorUtil

@ExampleDefinition
class RenderContextAPI : TestRenderSurfaceRendererFragment() {

    override fun initExample() {}

    fun createRenderSurfaceRenderer() {
        // <CreateRenderSurfaceRenderer>
        class TestRenderSurfaceRenderer(texture: Bitmap) :
            IRenderSurfaceRenderer {
            private val sprite2Rect = RectF(0f, 0f, 0.5f, 0.5f)
            private val sprite3Rect = RectF(0.25f, 0.25f, 0.75f, 0.75f)

            private val solidStyle: BrushStyle
            private val linearGradient: BrushStyle
            private val radialGradient: BrushStyle
            private val textureStyle: TextureBrushStyle

            private val simpleLine: PenStyle
            private val aaLine: PenStyle
            private val texturedLine: PenStyle
            private val texturedAaLine: PenStyle

            private val dashedSimpleLine: PenStyle
            private val dashedAaLine: PenStyle
            private val dashedTexturedLine: PenStyle
            private val dashedTexturedAaLine: PenStyle

            private val thickSimpleLine: PenStyle
            private val thickAaLine: PenStyle
            private val thickTexturedLine: PenStyle
            private val thickTexturedAaLine: PenStyle

            private val dashedThickSimpleLine: PenStyle
            private val dashedThickAaLine: PenStyle
            private val dashedThickTexturedLine: PenStyle
            private val dashedThickTexturedAaLine: PenStyle

            private val fontStyle: FontStyle
            private val customFontStyle: FontStyle

            private val texture: Bitmap

            private val xAxisArrow = floatArrayOf(0f, 0f, 50f, 0f, 30f, -10f, 50f, 0f, 30f, 10f, 50f, 0f)
            private val yAxisArrow = floatArrayOf(0f, 0f, 0f, 50f, -10f, 30f, 0f, 50f, 10f, 30f, 0f, 50f)

            private var degrees = 0f
            private var dx = 0f
            private var dy = 0f
            private var opacity = 0f

            init {
                solidStyle = SolidBrushStyle(ColorUtil.argb(0xEE, 0xFF, 0xC9, 0xA8))
                linearGradient = LinearGradientBrushStyle(0f, 0f, 1f, 1f, ColorUtil.argb(0xEE, 0xFF, 0xC9, 0xA8), ColorUtil.argb(0xEE, 0x13, 0x24, 0xA5))
                radialGradient = RadialGradientBrushStyle(0.5f, 0.5f, 0.5f, 0.5f, ColorUtil.argb(0xEE, 0xFF, 0xC9, 0xA8), ColorUtil.argb(0xEE, 0x13, 0x24, 0xA5))
                textureStyle = TextureBrushStyle(texture)

                fontStyle = FontStyle(32f, ColorUtil.Red)
                customFontStyle = FontStyle(Typeface.create(Typeface.SANS_SERIF, Typeface.BOLD_ITALIC), 23f, ColorUtil.Yellow, false)

                simpleLine = SolidPenStyle(ColorUtil.Red, false, 1f, null)
                aaLine = SolidPenStyle(ColorUtil.Green, true, 1f, null)
                texturedLine = TexturePenStyle(textureStyle, false, 1f, null)
                texturedAaLine = TexturePenStyle(textureStyle, true, 1f, null)

                dashedSimpleLine = SolidPenStyle(ColorUtil.Blue, false, 1f, floatArrayOf(5f, 10f, 5f, 10f))
                dashedAaLine = SolidPenStyle(ColorUtil.Magenta, true, 1f, floatArrayOf(10f, 5f, 10f, 5f))
                dashedTexturedLine = TexturePenStyle(textureStyle, false, 1f, floatArrayOf(5f, 10f, 5f, 10f))
                dashedTexturedAaLine = TexturePenStyle(textureStyle, true, 1f, floatArrayOf(10f, 5f, 10f, 5f))

                thickSimpleLine = SolidPenStyle(ColorUtil.Red, false, 10f, null)
                thickAaLine = SolidPenStyle(ColorUtil.Green, true, 10f, null)
                thickTexturedLine = TexturePenStyle(textureStyle, false, 10f, null)
                thickTexturedAaLine = TexturePenStyle(textureStyle, true, 10f, null)

                dashedThickSimpleLine = SolidPenStyle(ColorUtil.Blue, false, 20f, floatArrayOf(5f, 10f, 5f, 10f))
                dashedThickAaLine = SolidPenStyle(ColorUtil.Magenta, true, 20f, floatArrayOf(0f, 20f, 10f, 5f))
                dashedThickTexturedLine = TexturePenStyle(textureStyle, false, 20f, floatArrayOf(5f, 10f, 5f, 10f))
                dashedThickTexturedAaLine = TexturePenStyle(textureStyle, true, 20f, floatArrayOf(0f, 20f, 10f, 5f))

                this.texture = texture
            }

            override fun onSurfaceAttached(surface: IRenderSurface) {}
            override fun onSurfaceDetached(surface: IRenderSurface) {}
            override fun onSurfaceSizeChanged(width: Int, height: Int, oldWidth: Int, oldHeight: Int) {}

            fun setTransform(degrees: Float, dx: Float, dy: Float, opacity: Float) {
                this.degrees = degrees
                this.dx = dx - binding.translateX.max / 2f
                this.dy = dy - binding.translateY.max / 2f
                this.opacity = opacity
            }

            override fun onDraw(renderContext: IRenderContext2D, assetManager: IAssetManager2D) {
                renderContext.translate(dx, dy)
                renderContext.rotate(degrees)

                val solidBrushPerScreen = assetManager.createBrush(solidStyle, TextureMappingMode.PerScreen, opacity)
                val radialGradientBrushPerScreen = assetManager.createBrush(radialGradient, TextureMappingMode.PerScreen, opacity)
                val linearGradientBrushPerScreen = assetManager.createBrush(linearGradient, TextureMappingMode.PerScreen, opacity)
                val textureBrushPerScreen = assetManager.createBrush(textureStyle, TextureMappingMode.PerScreen, opacity)

                val solidBrushPerPrimitive = assetManager.createBrush(solidStyle, TextureMappingMode.PerPrimitive, opacity)
                val radialGradientBrushPerPrimitive = assetManager.createBrush(radialGradient, TextureMappingMode.PerPrimitive, opacity)
                val linearGradientBrushPerPrimitive = assetManager.createBrush(linearGradient, TextureMappingMode.PerPrimitive, opacity)
                val textureBrushPerPrimitive = assetManager.createBrush(textureStyle, TextureMappingMode.PerPrimitive, opacity)

                val simpleLine = assetManager.createPen(simpleLine, opacity)
                val aaLine = assetManager.createPen(aaLine, opacity)
                val dashedSimpleLine = assetManager.createPen(dashedSimpleLine, opacity)
                val dashedAaLine = assetManager.createPen(dashedAaLine, opacity)
                val thickSimpleLine = assetManager.createPen(thickSimpleLine, opacity)
                val thickAaLine = assetManager.createPen(thickAaLine, opacity)
                val dashedThickSimpleLine = assetManager.createPen(dashedThickSimpleLine, opacity)
                val dashedThickAaLine = assetManager.createPen(dashedThickAaLine, opacity)

                val texturedLine = assetManager.createPen(texturedLine, opacity)
                val texturedAaLine = assetManager.createPen(texturedAaLine, opacity)
                val dashedTexturedLine = assetManager.createPen(dashedTexturedLine, opacity)
                val dashedTexturedAaLine = assetManager.createPen(dashedTexturedAaLine, opacity)
                val thickTexturedLine = assetManager.createPen(thickTexturedLine, opacity)
                val thickTexturedAaLine = assetManager.createPen(thickTexturedAaLine, opacity)
                val dashedThickTexturedLine = assetManager.createPen(dashedThickTexturedLine, opacity)
                val dashedThickTexturedAaLine = assetManager.createPen(dashedThickTexturedAaLine, opacity)

                val font = assetManager.createFont(fontStyle)
                val customFont = assetManager.createFont(customFontStyle)

                val sprite1: ITexture2D = assetManager.createTexture(texture)
                val sprite2: ITexture2D = assetManager.createTexture(texture, sprite2Rect)
                val sprite3: ITexture2D = assetManager.createTexture(texture, sprite3Rect)

                renderContext.drawLines(xAxisArrow, 0, xAxisArrow.size, simpleLine)
                renderContext.drawLines(yAxisArrow, 0, yAxisArrow.size, aaLine)

                renderContext.save()
                renderContext.translate(10f, 10f)

                renderContext.drawLine(0f, 0f, 80f, 80f, simpleLine)
                renderContext.drawLine(100f, 0f, 180f, 80f, aaLine)
                renderContext.drawLine(200f, 0f, 280f, 80f, dashedSimpleLine)
                renderContext.drawLine(300f, 0f, 380f, 80f, dashedAaLine)

                renderContext.drawLine(0f, 100f, 80f, 180f, thickSimpleLine)
                renderContext.drawLine(100f, 100f, 180f, 180f, thickAaLine)
                renderContext.drawLine(200f, 100f, 280f, 180f, dashedThickSimpleLine)
                renderContext.drawLine(300f, 100f, 380f, 180f, dashedThickAaLine)

                renderContext.translate(0f, 200f)

                renderContext.drawLine(0f, 0f, 80f, 80f, texturedLine)
                renderContext.drawLine(100f, 0f, 180f, 80f, texturedAaLine)
                renderContext.drawLine(200f, 0f, 280f, 80f, dashedTexturedLine)
                renderContext.drawLine(300f, 0f, 380f, 80f, dashedTexturedAaLine)

                renderContext.drawLine(0f, 100f, 80f, 180f, thickTexturedLine)
                renderContext.drawLine(100f, 100f, 180f, 180f, thickTexturedAaLine)
                renderContext.drawLine(200f, 100f, 280f, 180f, dashedThickTexturedLine)
                renderContext.drawLine(300f, 100f, 380f, 180f, dashedThickTexturedAaLine)

                renderContext.translate(0f, 200f)

                renderContext.drawRect(0f, 0f, 80f, 80f, simpleLine)
                renderContext.drawRect(100f, 0f, 180f, 80f, aaLine)
                renderContext.drawRect(200f, 0f, 280f, 80f, dashedSimpleLine)
                renderContext.drawRect(300f, 0f, 380f, 80f, dashedAaLine)

                renderContext.drawRect(0f, 100f, 80f, 180f, thickSimpleLine)
                renderContext.drawRect(100f, 100f, 180f, 180f, thickAaLine)
                renderContext.drawRect(200f, 100f, 280f, 180f, dashedThickSimpleLine)
                renderContext.drawRect(300f, 100f, 380f, 180f, dashedThickAaLine)

                renderContext.translate(0f, 200f)

                renderContext.fillRect(0f, 0f, 80f, 80f, solidBrushPerScreen)
                renderContext.fillRect(100f, 0f, 180f, 80f, linearGradientBrushPerScreen)
                renderContext.fillRect(200f, 0f, 280f, 80f, radialGradientBrushPerScreen)
                renderContext.fillRect(300f, 0f, 380f, 80f, textureBrushPerScreen)

                renderContext.fillRect(0f, 100f, 80f, 180f, solidBrushPerPrimitive)
                renderContext.fillRect(100f, 100f, 180f, 180f, linearGradientBrushPerPrimitive)
                renderContext.fillRect(200f, 100f, 280f, 180f, radialGradientBrushPerPrimitive)
                renderContext.fillRect(300f, 100f, 380f, 180f, textureBrushPerPrimitive)

                renderContext.translate(0f, 200f)

                renderContext.drawEllipse(50f, 50f, 80f, 80f, simpleLine, solidBrushPerScreen)
                renderContext.drawEllipse(150f, 50f, 80f, 80f, aaLine, linearGradientBrushPerScreen)
                renderContext.drawEllipse(250f, 50f, 80f, 80f, dashedSimpleLine, radialGradientBrushPerScreen)
                renderContext.drawEllipse(350f, 50f, 80f, 80f, dashedAaLine, textureBrushPerScreen)

                renderContext.drawEllipse(50f, 150f, 80f, 80f, thickSimpleLine, solidBrushPerPrimitive)
                renderContext.drawEllipse(150f, 150f, 80f, 80f, thickAaLine, linearGradientBrushPerPrimitive)
                renderContext.drawEllipse(250f, 150f, 80f, 80f, dashedThickSimpleLine, radialGradientBrushPerPrimitive)
                renderContext.drawEllipse(350f, 150f, 80f, 80f, dashedThickAaLine, textureBrushPerPrimitive)

                renderContext.restore()
                renderContext.save()
                renderContext.translate(500f, 0f)

                renderContext.drawText(font, 0f, 0f, fontStyle.textColor, "ABCDEFGHIJKLMNOPQRSTUVWXYZ")
                renderContext.drawText(font, 0f, 50f, fontStyle.textColor, "abcdefghijklmnopqrstuvwxyz")
                renderContext.drawText(font, 0f, 100f, fontStyle.textColor, "1234567890~!@#$%^&*()-+=/|\\'\"")

                renderContext.drawText(customFont, 0f, 150f, customFontStyle.textColor, "ABCDEFGHIJKLMNOPQRSTUVWXYZ")
                renderContext.drawText(customFont, 0f, 200f, customFontStyle.textColor, "abcdefghijklmnopqrstuvwxyz")
                renderContext.drawText(customFont, 0f, 250f, customFontStyle.textColor, "1234567890~!@#$%^&*()-+=/|\\'\"")

                renderContext.translate(0f, 300f)

                renderContext.drawSprite(sprite1, 0f, 0f, opacity)
                renderContext.translate(0f, (sprite1.height + 10).toFloat())

                renderContext.drawSprite(sprite2, 0f, 0f, opacity)
                renderContext.translate(0f, (sprite2.height + 10).toFloat())

                renderContext.drawSprite(sprite3, 0f, 0f, opacity)
                renderContext.translate(0f, (sprite3.height + 10).toFloat())

                val triangles = FloatArray(8)
                triangles[0] = 0f; triangles[1] = 0f
                triangles[2] = 100f; triangles[3] = 0f
                triangles[4] = 100f; triangles[5] = 200f
                triangles[6] = 200f; triangles[7] = 200f

                renderContext.save()

                renderContext.drawTrianglesStrip(triangles, 0, 8, solidBrushPerScreen)
                renderContext.translate(210f, 0f)

                renderContext.drawTrianglesStrip(triangles, 0, 8, linearGradientBrushPerScreen)
                renderContext.translate(210f, 0f)

                renderContext.drawTrianglesStrip(triangles, 0, 8, radialGradientBrushPerScreen)
                renderContext.translate(210f, 0f)

                renderContext.drawTrianglesStrip(triangles, 0, 8, textureBrushPerScreen)
                renderContext.translate(210f, 0f)

                renderContext.restore()
                renderContext.save()
                renderContext.translate(0f, 210f)

                renderContext.drawTrianglesStrip(triangles, 0, 8, solidBrushPerPrimitive)
                renderContext.translate(210f, 0f)

                renderContext.drawTrianglesStrip(triangles, 0, 8, linearGradientBrushPerPrimitive)
                renderContext.translate(210f, 0f)

                renderContext.drawTrianglesStrip(triangles, 0, 8, radialGradientBrushPerPrimitive)
                renderContext.translate(210f, 0f)

                renderContext.drawTrianglesStrip(triangles, 0, 8, textureBrushPerPrimitive)
                renderContext.translate(210f, 0f)

                sprite1.dispose()
                sprite2.dispose()
                sprite3.dispose()
            }
        }
        // </CreateRenderSurfaceRenderer>
    }
}