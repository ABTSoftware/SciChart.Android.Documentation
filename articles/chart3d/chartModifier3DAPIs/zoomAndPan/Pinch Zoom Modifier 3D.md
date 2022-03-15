---
uid: "chartModifier3DAPIs.ZoomAndPanPinchZoomModifier3D"
---

# Pinch Zoom Modifier 3D
SciChart Android 3D provides **pinch zooming** via the <xref:com.scichart.charting3d.modifiers.PinchZoomModifier3D>, which is available out of the box.

The <xref:com.scichart.charting3d.modifiers.PinchZoomModifier3D> performs movement of the <xref:com.scichart.charting3d.visuals.camera.Camera3D> ***forwards/backwards*** when the user pinches a touch screen giving the appearance of zooming the 3D world.

<video autoplay loop muted playsinline src="../images/pinch-zoom-modifier-3d.mp4"></video>

Besides [common features](xref:chartModifier3DAPIs.ChartModifier3DAPIs#common-chart-modifier-3d-features) which are inherited from the <xref:com.scichart.charting3d.modifiers.ChartModifierBase3D> class, the <xref:com.scichart.charting3d.modifiers.PinchZoomModifier3D> also allows you to change **ScaleFactor** which allows you to change zooming speed. It is accessible via the <xref:com.scichart.charting3d.modifiers.PinchZoomModifier3D.setScaleFactor(float)> method.

## Adding a PinchZoomModifier3D to a Chart
Any [Chart Modifier 3D](xref:chartModifier3DAPIs.ChartModifier3DAPIs) can be [added to a <xref:com.scichart.charting3d.visuals.SciChartSurface3D>](xref:chartModifier3DAPIs.ChartModifier3DAPIs#adding-a-chart-modifier-3d) via the [chartModifiers](xref:com.scichart.charting3d.visuals.ISciChartSurface3D.getChartModifiers()) property and <xref:com.scichart.charting3d.modifiers.PinchZoomModifier3D> is no difference:

# [Java](#tab/java)
[!code-java[AddPinchZoomModifier3D](../../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/chartModifier3D/ZoomAndPanPinchZoomModifier3D.java#AddPinchZoomModifier3D)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[AddPinchZoomModifier3D](../../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/chartModifier3D/ZoomAndPanPinchZoomModifier3D.java#AddPinchZoomModifier3D)]
# [Kotlin](#tab/kotlin)
[!code-swift[AddPinchZoomModifier3D](../../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/chartModifier3D/ZoomAndPanPinchZoomModifier3D.kt#AddPinchZoomModifier3D)]
***

> [!NOTE]
> To learn more about features available, please visit the [Chart Modifier 3D APIs](xref:chartModifier3DAPIs.ChartModifier3DAPIs#common-chart-modifier-3d-features) article.