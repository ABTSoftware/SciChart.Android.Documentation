---
uid: "chartModifier3DAPIs.InteractivityVertexSelectionModifier3D"
---

# Vertex Selection Modifier 3D
The <xref:com.scichart.charting3d.modifiers.VertexSelectionModifier3D> allows you to perform ***selection of points*** on a 3D chart.

<video autoplay loop muted playsinline src="../images/vertex-selection-modifier-3d.mp4"></video>

## Adding a VertexSelectionModifier3D to a Chart
Any [Chart Modifier 3D](xref:chartModifier3DAPIs.ChartModifier3DAPIs) can be [added to a <xref:com.scichart.charting3d.visuals.SciChartSurface3D>](xref:chartModifier3DAPIs.ChartModifier3DAPIs#adding-a-chart-modifier-3d) via the [chartModifiers](xref:com.scichart.charting3d.visuals.ISciChartSurface3D.getChartModifiers()) property and <xref:com.scichart.charting3d.modifiers.VertexSelectionModifier3D> is no difference:

# [Java](#tab/java)
[!code-java[AddVertexSelectionModifier3D](../../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/chartModifier3D/InteractivityVertexSelectionModifier3D.java#AddVertexSelectionModifier3D)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[AddVertexSelectionModifier3D](../../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/chartModifier3D/InteractivityVertexSelectionModifier3D.java#AddVertexSelectionModifier3D)]
# [Kotlin](#tab/kotlin)
[!code-swift[AddVertexSelectionModifier3D](../../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/chartModifier3D/InteractivityVertexSelectionModifier3D.kt#AddVertexSelectionModifier3D)]
***

> [!NOTE]
> To learn more about features available, please visit the [Chart Modifier 3D APIs](xref:chartModifier3DAPIs.ChartModifier3DAPIs#common-chart-modifier-3d-features) article.
