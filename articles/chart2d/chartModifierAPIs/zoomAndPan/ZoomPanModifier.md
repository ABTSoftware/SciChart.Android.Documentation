---
uid: "chartModifierAPIs.ZoomAndPanZoomPanModifier"
---

# The ZoomPanModifier
Chart Android provides an inertial **scrolling / panning** behavior via the <xref:com.scichart.charting.modifiers.ZoomPanModifier>, available out of the box.

<video autoplay loop muted playsinline src="../images/zoom-pan-modifier.mp4"></video>

Besides [common features](xref:chartModifierAPIs.ChartModifierAPIs#common-chart-modifier-features) which are inherited from the <xref:com.scichart.charting.modifiers.ChartModifierBase> class, the <xref:com.scichart.charting.modifiers.ZoomPanModifier> allows to control its specific features via the following properties:
- <xref:com.scichart.charting.modifiers.ZoomPanModifier.setDirection(com.scichart.charting.Direction2D)> - allows to **restrict zooming** to the horizontal or vertical **direction** only if needed.
- <xref:com.scichart.charting.modifiers.ZoomPanModifier.setZoomExtentsY(boolean)> - allows to to keep **series' peeks** always in viewport.
- <xref:com.scichart.charting.modifiers.ZoomPanModifier.setClipModeX(com.scichart.charting.ClipMode)> - allows to specify the **behavior** when scrolling **reaches data extents** in X direction via the <xref:com.scichart.charting.ClipMode> enumeration.

There are several modes defined by the <xref:com.scichart.charting.ClipMode> enumeration:
- <xref:com.scichart.charting.ClipMode.None> - Means you can pan right off the edge of the data into uncharted space.
- <xref:com.scichart.charting.ClipMode.StretchAtExtents> - Causes a zooming (stretch) action when you reach the edge of the data.
- <xref:com.scichart.charting.ClipMode.ClipAtMin> - Forces the panning operation to stop suddenly at the minimum of the data, but expand at the maximum.
- <xref:com.scichart.charting.ClipMode.ClipAtMax> - Forces the panning operation to stop suddenly at the maximum of the data, but expand at the minimum.
- <xref:com.scichart.charting.ClipMode.ClipAtExtents> - Forces the panning operation to stop suddenly at the extents of the data.

## Adding a ZoomPanModifier to a Chart
Any [Chart Modifier](xref:chartModifierAPIs.ChartModifierAPIs) can be [added to a <xref:com.scichart.charting.visuals.SciChartSurface>](xref:chartModifierAPIs.ChartModifierAPIs#adding-a-chart-modifier) via the [chartModifiers](xref:com.scichart.charting.visuals.ISciChartSurface.getChartModifiers()) property and <xref:com.scichart.charting.modifiers.ZoomPanModifier> is no difference:

# [Java](#tab/java)
[!code-java[AddZoomPanModifier](../../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/chartModifier2D/ZoomAndPanZoomPanModifier.java#AddZoomPanModifier)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[AddZoomPanModifier](../../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/chartModifier2D/ZoomAndPanZoomPanModifier.java#AddZoomPanModifier)]
# [Kotlin](#tab/kotlin)
[!code-swift[AddZoomPanModifier](../../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/chartModifier2D/ZoomAndPanZoomPanModifier.kt#AddZoomPanModifier)]
***

> [!NOTE]
> To learn more about features available, please visit the [Chart Modifier APIs](xref:chartModifierAPIs.ChartModifierAPIs#common-chart-modifier-features) article.
