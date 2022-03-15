---
uid: "chartModifierAPIs.ZoomAndPanYAxisDragModifier"
---

# The YAxisDragModifier
SciChart Android provides **scale or pan** an X Axis via the <xref:com.scichart.charting.modifiers.YAxisDragModifier>, available out of the box.

<video autoplay loop muted playsinline src="../images/y-axis-drag-modifier.mp4"></video>

Besides [common features](xref:chartModifierAPIs.ChartModifierAPIs#common-chart-modifier-features) which are inherited from the <xref:com.scichart.charting.modifiers.ChartModifierBase> class, the <xref:com.scichart.charting.modifiers.YAxisDragModifier> allows to control its specific features via the following properties:
- <xref:com.scichart.charting.modifiers.AxisDragModifierBase.setDragMode(com.scichart.charting.modifiers.AxisDragModifierBase.AxisDragMode)> - allows to change the default axis **scaling** behavior to axis **panning** behavior - similarly to [ZoomPanModifier](xref:chartModifierAPIs.ZoomAndPanZoomPanModifier) via the <xref:com.scichart.charting.modifiers.AxisDragModifierBase.AxisDragMode> enumeration.
- <xref:com.scichart.charting.modifiers.AxisDragModifierBase.setMinTouchArea(float)> - configures the **sensitivity** of the modifier.

## Adding a YAxisDragModifier to a Chart
Any [Chart Modifier](xref:chartModifierAPIs.ChartModifierAPIs) can be [added to a <xref:com.scichart.charting.visuals.SciChartSurface>](xref:chartModifierAPIs.ChartModifierAPIs#adding-a-chart-modifier) via the [chartModifiers](xref:com.scichart.charting.visuals.ISciChartSurface.getChartModifiers()) property and <xref:com.scichart.charting.modifiers.YAxisDragModifier> is no difference:

# [Java](#tab/java)
[!code-java[AddYAxisDragModifier](../../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/chartModifier2D/ZoomAndPanYAxisDragModifier.java#AddYAxisDragModifier)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[AddYAxisDragModifier](../../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/chartModifier2D/ZoomAndPanYAxisDragModifier.java#AddYAxisDragModifier)]
# [Kotlin](#tab/kotlin)
[!code-swift[AddYAxisDragModifier](../../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/chartModifier2D/ZoomAndPanYAxisDragModifier.kt#AddYAxisDragModifier)]
***

> [!NOTE]
> To learn more about features available, please visit the [Chart Modifier APIs](xref:chartModifierAPIs.ChartModifierAPIs#common-chart-modifier-features) article.
