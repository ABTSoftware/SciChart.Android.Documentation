---
uid: "chartModifierAPIs.ZoomAndPanPinchZoomModifier"
---

# The PinchZoomModifier
SciChart Android provides **pinch zooming** via the <xref:com.scichart.charting.modifiers.PinchZoomModifier>, available out of the box.

<video autoplay loop muted playsinline src="../images/pinch-zoom-modifier.mp4"></video>

Besides [common features](xref:chartModifierAPIs.ChartModifierAPIs#common-chart-modifier-features) which are inherited from the <xref:com.scichart.charting.modifiers.ChartModifierBase> class, the <xref:com.scichart.charting.modifiers.PinchZoomModifier> allows to control its specific features via the following properties:
- <xref:com.scichart.charting.modifiers.PinchZoomModifier.setScaleFactor(float)> - allows to set **ScaleFactor** to change zooming speed.
- <xref:com.scichart.charting.modifiers.PinchZoomModifier.setDirection(com.scichart.charting.Direction2D)> - allows to **restrict zooming** to the horizontal or vertical **direction** only if needed.

## Adding a PinchZoomModifier to a Chart
Any [Chart Modifier](xref:chartModifierAPIs.ChartModifierAPIs) can be [added to a <xref:com.scichart.charting.visuals.SciChartSurface>](xref:chartModifierAPIs.ChartModifierAPIs#adding-a-chart-modifier) via the [chartModifiers](xref:com.scichart.charting.visuals.ISciChartSurface.getChartModifiers()) property and <xref:com.scichart.charting.modifiers.PinchZoomModifier> is no difference:

# [Java](#tab/java)
[!code-java[AddPinchZoomModifier2](../../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/chartModifier2D/ZoomAndPanPinchZoomModifier.java#AddPinchZoomModifier2)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[AddPinchZoomModifier2](../../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/chartModifier2D/ZoomAndPanPinchZoomModifier.java#AddPinchZoomModifier2)]
# [Kotlin](#tab/kotlin)
[!code-swift[AddPinchZoomModifier2](../../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/chartModifier2D/ZoomAndPanPinchZoomModifier.kt#AddPinchZoomModifier2)]
***

> [!NOTE]
> To learn more about features available, please visit the [Chart Modifier APIs](xref:chartModifierAPIs.ChartModifierAPIs#common-chart-modifier-features) article.
