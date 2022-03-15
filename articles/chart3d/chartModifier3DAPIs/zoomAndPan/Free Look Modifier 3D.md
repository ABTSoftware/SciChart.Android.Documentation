---
uid: "chartModifier3DAPIs.ZoomAndPanFreeLookModifier3D"
---

# Free Look Modifier 3D
If you want to add simple movement of the camera (imagine ***free-look*** in a computer game) then you can do so using our [Chart Modifier 3D API](xref:chartModifier3DAPIs.ChartModifier3DAPIs). 
The <xref:com.scichart.charting3d.modifiers.FreeLookModifier3D> performs <xref:com.scichart.charting3d.visuals.camera.Camera3D> movement in the Left/Right/Up/Down direction giving the appearance of moving through the 3D World

<video autoplay loop muted playsinline src="../images/free-look-modifier-3d.mp4"></video>

Besides [common features](xref:chartModifier3DAPIs.ChartModifier3DAPIs#common-chart-modifier-3d-features) which are inherited from the <xref:com.scichart.charting3d.modifiers.ChartModifierBase3D> class, the <xref:com.scichart.charting3d.modifiers.FreeLookModifier3D> also allows you to control movement **sensitivity** via the <xref:com.scichart.charting3d.modifiers.FreeLookModifier3D.setDegreesPerPixelSensitivity(float)> property.

## Adding a FreeLookModifier3D to a Chart
Any [Chart Modifier 3D](xref:chartModifier3DAPIs.ChartModifier3DAPIs) can be [added to a <xref:com.scichart.charting3d.visuals.SciChartSurface3D>](xref:chartModifier3DAPIs.ChartModifier3DAPIs#adding-a-chart-modifier-3d) via the [chartModifiers](xref:com.scichart.charting3d.visuals.ISciChartSurface3D.getChartModifiers()) property and <xref:com.scichart.charting3d.modifiers.FreeLookModifier3D> is no difference:

# [Java](#tab/java)
[!code-java[AddFreeLookModifier3D](../../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/chartModifier3D/ZoomAndPanFreeLookModifier3D.java#AddFreeLookModifier3D)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[AddFreeLookModifier3D](../../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/chartModifier3D/ZoomAndPanFreeLookModifier3D.java#AddFreeLookModifier3D)]
# [Kotlin](#tab/kotlin)
[!code-swift[AddFreeLookModifier3D](../../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/chartModifier3D/ZoomAndPanFreeLookModifier3D.kt#AddFreeLookModifier3D)]
***

> [!NOTE]
> To learn more about features available, please visit the [Chart Modifier 3D APIs](xref:chartModifier3DAPIs.ChartModifier3DAPIs#common-chart-modifier-3d-features) article.