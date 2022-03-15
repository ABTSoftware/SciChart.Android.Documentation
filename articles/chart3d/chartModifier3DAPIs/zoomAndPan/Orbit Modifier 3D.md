---
uid: "chartModifier3DAPIs.ZoomAndPanOrbitModifier3D"
---

# Orbit Modifier 3D
SciChart Android 3D provides a **panning** behavior via the <xref:com.scichart.charting3d.modifiers.OrbitModifier3D>, available out of the box.

The <xref:com.scichart.charting3d.modifiers.OrbitModifier3D> performs ***orbital motion*** of the camera giving the appearance of rotating the 3D world.

<video autoplay loop muted playsinline src="../images/orbit-modifier-3d.mp4"></video>

Besides [common features](xref:chartModifier3DAPIs.ChartModifier3DAPIs#common-chart-modifier-3d-features) which are inherited from the <xref:com.scichart.charting3d.modifiers.ChartModifierBase3D> class, the <xref:com.scichart.charting3d.modifiers.OrbitModifier3D> also allows you to control **panning sensitivity** which allows you to change the orbit speed. 
It's accessible via the <xref:com.scichart.charting3d.modifiers.OrbitModifier3D.setDegreesPerPixelSensitivity(float)> method.

## Adding a OrbitModifier3D to a Chart
Any [Chart Modifier 3D](xref:chartModifier3DAPIs.ChartModifier3DAPIs) can be [added to a <xref:com.scichart.charting3d.visuals.SciChartSurface3D>](xref:chartModifier3DAPIs.ChartModifier3DAPIs#adding-a-chart-modifier-3d) via the [chartModifiers](xref:com.scichart.charting3d.visuals.ISciChartSurface3D.getChartModifiers()) property and <xref:com.scichart.charting3d.modifiers.OrbitModifier3D> is no difference:

# [Java](#tab/java)
[!code-java[AddOrbitModifier3D](../../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/chartModifier3D/ZoomAndPanOrbitModifier3D.java#AddOrbitModifier3D)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[AddOrbitModifier3D](../../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/chartModifier3D/ZoomAndPanOrbitModifier3D.java#AddOrbitModifier3D)]
# [Kotlin](#tab/kotlin)
[!code-swift[AddOrbitModifier3D](../../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/chartModifier3D/ZoomAndPanOrbitModifier3D.kt#AddOrbitModifier3D)]
***

> [!NOTE]
> To learn more about features available, please visit the [Chart Modifier 3D APIs](xref:chartModifier3DAPIs.ChartModifier3DAPIs#common-chart-modifier-3d-features) article.