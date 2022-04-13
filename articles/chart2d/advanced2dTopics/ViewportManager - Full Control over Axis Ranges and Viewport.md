---
uid: "chart2d.advanced2dTopics.ViewportManager"
---

# ViewportManager - Full Control over Axis Ranges and Viewport

The **ViewportManager API** provides fine-grained control over the <xref:com.scichart.charting.visuals.SciChartSurface> viewport, allowing you to configure the result of VisibleRange calculations on a per-axis basis, change zoom level or invalidate a chart.

You can declare a viewport manager and [assign to a SciChartSurface](xref:com.scichart.charting.visuals.SciChartSurface.setViewportManager(com.scichart.charting.viewportManagers.IViewportManager)) using the following code. By default SciChart has a <xref:com.scichart.charting.viewportManagers.DefaultViewportManager> assigned. You can also inherit this type and provide your own Viewport Managers.

# [Java](#tab/java)
[!code-java[SetViewportManager](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/advanced2dTopics/ViewportManager.java#SetViewportManager)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[SetViewportManager](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/advanced2dTopics/ViewportManager.java#SetViewportManager)]
# [Kotlin](#tab/kotlin)
[!code-swift[SetViewportManager](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/advanced2dTopics/ViewportManager.kt#SetViewportManager)]
***

## Overriding Axis VisibleRanges

The most powerful feature of the ViewportManager is the abilty to intercept the Axis [VisibleRange](xref:com.scichart.charting.visuals.axes.IAxisCore.getVisibleRange()) calculations and return your own custom range. Use this if you want to have full control over the axis, not just set a new VisibleRange.

Define your own ViewportManager as follows:

# [Java](#tab/java)
[!code-java[CreateCustomViewportManager](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/advanced2dTopics/ViewportManager.java#CreateCustomViewportManager)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[CreateCustomViewportManager](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/advanced2dTopics/ViewportManager.java#CreateCustomViewportManager)]
# [Kotlin](#tab/kotlin)
[!code-swift[CreateCustomViewportManager](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/advanced2dTopics/ViewportManager.kt#CreateCustomViewportManager)]
***

Then attach it to a chart. If you put a breakpoint in your <xref:com.scichart.charting.viewportManagers.IViewportManagerBase.updateXAxis(com.scichart.charting.visuals.axes.IAxisCore)> / <xref:com.scichart.charting.viewportManagers.IViewportManagerBase.updateYAxis(com.scichart.charting.visuals.axes.IAxisCore)> methods you will see these being hit when the chart resizes or redraws and you can manipulate the calculated visible range passed to SciChart as you wish.
