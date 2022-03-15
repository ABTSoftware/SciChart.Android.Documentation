---
uid: "chartModifierAPIs.ZoomAndPanZoomExtentsModifier"
---

# The ZoomExtentsModifier
SciChart Android provides the ability to **zoom-to-fit** the entire chart double-tapping it via the <xref:com.scichart.charting.modifiers.ZoomExtentsModifier>, available out of the box.

<video autoplay loop muted playsinline src="../images/zoom-extents-modifier.mp4"></video>

Besides [common features](xref:chartModifierAPIs.ChartModifierAPIs#common-chart-modifier-features) which are inherited from the <xref:com.scichart.charting.modifiers.ChartModifierBase> class, the <xref:com.scichart.charting.modifiers.ZoomExtentsModifier> allows to control its specific features via the following properties:
- <xref:com.scichart.charting.modifiers.ZoomExtentsModifier.setDirection(com.scichart.charting.Direction2D)> - allows to **restrict zooming** to the horizontal or vertical **direction** only if needed.
- <xref:com.scichart.charting.modifiers.ZoomExtentsModifier.setIsAnimated(boolean)> - allows to switch **on/off** the animation on zoom out.
- <xref:com.scichart.charting.modifiers.ZoomExtentsModifier.setExecuteOn(com.scichart.charting.modifiers.ExecuteOn)> - allows to specify the trigger action for the modifier via the <xref:com.scichart.charting.modifiers.ExecuteOn> enumeration.

> [!NOTE]
> There are several modes defined by the <xref:com.scichart.charting.modifiers.ExecuteOn> enumeration, such as **Single Tap, Double Tap, Long Press**, and **Fling**.

## Adding a ZoomExtentsModifier to a Chart
Any [Chart Modifier](xref:chartModifierAPIs.ChartModifierAPIs) can be [added to a <xref:com.scichart.charting.visuals.SciChartSurface>](xref:chartModifierAPIs.ChartModifierAPIs#adding-a-chart-modifier) via the [chartModifiers](xref:com.scichart.charting.visuals.ISciChartSurface.getChartModifiers()) property and  <xref:com.scichart.charting.modifiers.ZoomExtentsModifier> is no difference:

# [Java](#tab/java)
[!code-java[AddZoomExtentsModifier](../../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/chartModifier2D/ZoomAndPanZoomExtentsModifier.java#AddZoomExtentsModifier)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[AddZoomExtentsModifier](../../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/chartModifier2D/ZoomAndPanZoomExtentsModifier.java#AddZoomExtentsModifier)]
# [Kotlin](#tab/kotlin)
[!code-swift[AddZoomExtentsModifier](../../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/chartModifier2D/ZoomAndPanZoomExtentsModifier.kt#AddZoomExtentsModifier)]
***

> [!NOTE]
> To learn more about features available, please visit the [Chart Modifier APIs](xref:chartModifierAPIs.ChartModifierAPIs#common-chart-modifier-features) article.

## Programmatically Zoom to Extents
You can also run **Zoom to Extents** functionality programmatically without adding <xref:com.scichart.charting.modifiers.ZoomExtentsModifier>. 
<xref:com.scichart.charting.visuals.SciChartSurface> supports the following methods which you can call whenever you need to zoom the chart to fit:
- <xref:com.scichart.charting.visuals.ISciChartController.zoomExtents()>
- <xref:com.scichart.charting.visuals.ISciChartController.animateZoomExtents(long)>
- <xref:com.scichart.charting.visuals.ISciChartController.zoomExtentsY()>
- <xref:com.scichart.charting.visuals.ISciChartController.animateZoomExtentsY(long)>
- <xref:com.scichart.charting.visuals.ISciChartController.zoomExtentsX()>
- <xref:com.scichart.charting.visuals.ISciChartController.animateZoomExtentsX(long)>