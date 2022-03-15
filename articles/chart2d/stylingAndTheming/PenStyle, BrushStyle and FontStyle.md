---
uid: "stylingAndTheming.PenStyleBrushStyleAndFontStyle"
---

# PenStyle, BrushStyle and FontStyle

In SciChart, almost all **styling** methods expect an instance of either [PenStyle](#penstyle) or [BrushStyle](#brushstyle) to be passed in. 
Those that deals with text styling, expect an instance of a [FontStyle](#fontstyle). 
All these classes are designed to hold a relevant information related to drawing.

SciChart also provides a <xref:com.scichart.charting3d.common.utils.ColorUtil> helper class with some color constants and helper methods to work with colors. It can be used for some common conversions and retrieving partial color information.

## PenStyle
There are several available <xref:com.scichart.drawing.common.PenStyle> implementations which allow us to specify how lines should be drawn in SciChart:
- <xref:com.scichart.drawing.common.SolidPenStyle> - allows to draw 2D lines with **solid** color.
- <xref:com.scichart.drawing.common.LinearGradientPenStyle> - allows to draw 2D lines with **linear gradient**.
- <xref:com.scichart.drawing.common.RadialGradientPenStyle> - allows to draw 2D lines with **radial gradient**.
- <xref:com.scichart.drawing.common.TexturePenStyle> - allows to draw **textured** 2D lines.

Also, all <xref:com.scichart.drawing.common.PenStyle> implementations allows to specify the following parameters for a pen:
- [color](xref:com.scichart.drawing.common.PenStyle.getColor()) - the pen color.
- [antiAliasing](xref:com.scichart.drawing.common.PenStyle.antiAliasing) - is pen **anti-aliased** or not.
- [thickness](xref:com.scichart.drawing.common.PenStyle.thickness) - it's **thickness**.
- [strokeDashArray](xref:com.scichart.drawing.common.PenStyle.strokeDashArray) - used to create **dashed** pens.

To create one of the <xref:com.scichart.drawing.common.PenStyle> instance, call an appropriate type constructor, for example:

# [Java](#tab/java)
[!code-java[CreatePen](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/stylingAndTheming/PenStyle_BrushStyle_FontStyle.java#CreatePen)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[CreatePen](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/stylingAndTheming/PenStyle_BrushStyle_FontStyle.java#CreatePen)]
# [Kotlin](#tab/kotlin)
[!code-swift[CreatePen](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/stylingAndTheming/PenStyle_BrushStyle_FontStyle.kt#CreatePen)]
***

## BrushStyle
As to the <xref:com.scichart.drawing.common.BrushStyle> class, it has similar implementations as the [PenStyle](#penstyle) like the following:
- <xref:com.scichart.drawing.common.SolidBrushStyle> - allows to draw 2D fills with **solid** color.
- <xref:com.scichart.drawing.common.LinearGradientBrushStyle> - allows to draw 2D fills with **linear gradient**.
- <xref:com.scichart.drawing.common.RadialGradientBrushStyle> - allows to draw 2D fills with **radial gradient**.
- <xref:com.scichart.drawing.common.TextureBrushStyle> - allows to draw 2D fills with **textures**.

# [Java](#tab/java)
[!code-java[CreateBrush](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/stylingAndTheming/PenStyle_BrushStyle_FontStyle.java#CreateBrush)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[CreateBrush](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/stylingAndTheming/PenStyle_BrushStyle_FontStyle.java#CreateBrush)]
# [Kotlin](#tab/kotlin)
[!code-swift[CreateBrush](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/stylingAndTheming/PenStyle_BrushStyle_FontStyle.kt#CreateBrush)]
***

## FontStyle
The <xref:com.scichart.drawing.common.FontStyle> type is designed to hold a relevant information related to text, such as:
- Font style - a [Typeface](https://developer.android.com/reference/android/graphics/Typeface.html) object
- Text size
- Text color

The <xref:com.scichart.drawing.common.FontStyle> type instances can be created in this way:

# [Java](#tab/java)
[!code-java[CreateFontStyle](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/stylingAndTheming/PenStyle_BrushStyle_FontStyle.java#CreateFontStyle)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[CreateFontStyle](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/stylingAndTheming/PenStyle_BrushStyle_FontStyle.java#CreateFontStyle)]
# [Kotlin](#tab/kotlin)
[!code-swift[CreateFontStyle](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/stylingAndTheming/PenStyle_BrushStyle_FontStyle.kt#CreateFontStyle)]
***