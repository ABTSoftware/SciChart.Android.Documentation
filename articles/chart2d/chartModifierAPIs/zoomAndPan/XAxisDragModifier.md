---
uid: "chartModifierAPIs.ZoomAndPanXAxisDragModifier"
---

# The XAxisDragModifier
SciChart Android provides **scale or pan** an X Axis via the <xref:com.scichart.charting.modifiers.XAxisDragModifier>, available out of the box.

<video autoplay loop muted playsinline src="../images/x-axis-drag-modifier.mp4"></video>

Besides [common features](xref:chartModifierAPIs.ChartModifierAPIs#common-chart-modifier-features) which are inherited from the <xref:com.scichart.charting.modifiers.ChartModifierBase> class, the <xref:com.scichart.charting.modifiers.XAxisDragModifier> allows to control its specific features via the following properties:
- <xref:com.scichart.charting.modifiers.AxisDragModifierBase.setDragMode(com.scichart.charting.modifiers.AxisDragModifierBase.AxisDragMode)> - allows to change the default axis **scaling** behavior to axis **panning** behavior - similarly to [ZoomPanModifier](xref:chartModifierAPIs.ZoomAndPanZoomPanModifier) via the <xref:com.scichart.charting.modifiers.AxisDragModifierBase.AxisDragMode> enumeration.
- <xref:com.scichart.charting.modifiers.AxisDragModifierBase.setMinTouchArea(float)> - configures the **sensitivity** of the modifier.
- <xref:com.scichart.charting.modifiers.XAxisDragModifier.setClipModeX(com.scichart.charting.ClipMode)> - allows to specify the **behavior** when scrolling **reaches data extents** in X direction via the <xref:com.scichart.charting.ClipMode> enumeration.
- <xref:com.scichart.charting.modifiers.XAxisDragModifier.setClipModeTargetX(com.scichart.charting.ClipModeTarget)> - allows to specify which target is used as limit by `clipModeX` when you reach the edge of the `X-Axis` extents.

## Adding a XAxisDragModifier to a Chart
Any [Chart Modifier](xref:chartModifierAPIs.ChartModifierAPIs) can be [added to a <xref:com.scichart.charting.visuals.SciChartSurface>](xref:chartModifierAPIs.ChartModifierAPIs#adding-a-chart-modifier) via the [chartModifiers](xref:com.scichart.charting.visuals.ISciChartSurface.getChartModifiers()) property and <xref:com.scichart.charting.modifiers.XAxisDragModifier> is no difference:

# [Java](#tab/java)
[!code-java[AddXAxisDragModifier](../../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/chartModifier2D/ZoomAndPanXAxisDragModifier.java#AddXAxisDragModifier)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[AddXAxisDragModifier](../../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/chartModifier2D/ZoomAndPanXAxisDragModifier.java#AddXAxisDragModifier)]
# [Kotlin](#tab/kotlin)
[!code-swift[AddXAxisDragModifier](../../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/chartModifier2D/ZoomAndPanXAxisDragModifier.kt#AddXAxisDragModifier)]
***

> [!NOTE]
> To learn more about features available, please visit the [Chart Modifier APIs](xref:chartModifierAPIs.ChartModifierAPIs#common-chart-modifier-features) article.
