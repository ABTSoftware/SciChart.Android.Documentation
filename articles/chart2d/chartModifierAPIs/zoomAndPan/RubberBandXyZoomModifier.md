---
uid: "chartModifierAPIs.ZoomAndPanRubberBandXyZoomModifier"
---

# RubberBandXyZoomModifier

SciChart for Android provides zooming via drag rectangle on a chart with the <xref:com.scichart.charting.modifiers.RubberBandXyZoomModifier>. 

<video autoplay loop muted playsinline src="../images/rubber-band-zoom-modifier.mp4"></video>

Besides [common features](xref:chartModifierAPIs.ChartModifierAPIs#common-chart-modifier-features) which are inherited from the <xref:com.scichart.charting.modifiers.ChartModifierBase> class, the <xref:com.scichart.charting.modifiers.RubberBandXyZoomModifier> defines a bunch of behavioral traits itself. Please find these in the table below:  

| **Feature** | **Description** |
| ----------- | --------------- |
| [isXAxisOnly](xref:com.scichart.charting.modifiers.RubberBandXyZoomModifier.setIsXAxisOnly(boolean)) | Allows to **restrict zooming behavior** to the X Axis only. |
| [isAnimated](xref:com.scichart.charting.modifiers.RubberBandXyZoomModifier.setIsAnimated(boolean)) | Allows to **switch on / off the animation** on zoom. |
| [minDragSensitivity](xref:com.scichart.charting.modifiers.RubberBandXyZoomModifier.setMinDragSensitivity(double)) | Allows to specify the **drag rectangle's minimal possible size**. Rectangles smaller than this size in the diagonal will be ignored when zooming. |
| [zoomExtentsY](xref:com.scichart.charting.modifiers.RubberBandXyZoomModifier.setZoomExtentsY(boolean)) | Determines whether to perform **zoom to extents on the Y Axis** on the each zoom operation or not. |
| [rubberBandStrokeStyle](xref:com.scichart.charting.modifiers.RubberBandXyZoomModifier.setRubberBandStrokeStyle(com.scichart.drawing.common.PenStyle)) | Allows to assign an <xref:com.scichart.drawing.common.PenStyle> object to the **outline of the drag rectangle**. Please refer to the [PenStyle, BrushStyle and FontStyle](xref:stylingAndTheming.PenStyleBrushStyleAndFontStyle) article for more details. |
| [rubberBandFillStyle](xref:com.scichart.charting.modifiers.RubberBandXyZoomModifier.setRubberBandFillStyle(com.scichart.drawing.common.BrushStyle)) | Allows to assign an <xref:com.scichart.drawing.common.BrushStyle> object to **fill the drag rectangle**. Please refer to the [PenStyle, BrushStyle and FontStyle](xref:stylingAndTheming.PenStyleBrushStyleAndFontStyle) article for more details. |

## Adding a RubberBandXyZoomModifier to a Chart

Any [Chart Modifier](xref:chartModifierAPIs.ChartModifierAPIs) can be [added to a <xref:com.scichart.charting.visuals.SciChartSurface>](xref:chartModifierAPIs.ChartModifierAPIs#adding-a-chart-modifier) via the [chartModifiers](xref:com.scichart.charting.visuals.ISciChartSurface.getChartModifiers()) property and <xref:com.scichart.charting.modifiers.RubberBandXyZoomModifier> is no difference:

# [Java](#tab/java)
[!code-java[AddRubberBandXyZoomModifier](../../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/chartModifier2D/ZoomAndPanRubberBandXyZoomModifier.java#AddRubberBandXyZoomModifier)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[AddRubberBandXyZoomModifier](../../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/chartModifier2D/ZoomAndPanRubberBandXyZoomModifier.java#AddRubberBandXyZoomModifier)]
# [Kotlin](#tab/kotlin)
[!code-swift[AddRubberBandXyZoomModifier](../../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/chartModifier2D/ZoomAndPanRubberBandXyZoomModifier.kt#AddRubberBandXyZoomModifier)]
***

> [!NOTE]
> To learn more about features available, please visit the [Chart Modifier APIs](xref:chartModifierAPIs.ChartModifierAPIs#common-chart-modifier-features) article.
