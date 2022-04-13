---
uid: "chart2d.advanced2dTopics.SuspendingUpdatesOfChart"
---

# Suspending Updates of Chart

When performing multiple updates, such as VisibleRange changes, DataSeries changes and RenderableSeries or Axis property changes, each change can potentially trigger a redraw in SciChart. To prevent this and combine several updates into one, use the methods from the <xref:com.scichart.core.framework.ISuspendable> implementation on <xref:com.scichart.charting.visuals.SciChartSurface> or use [UpdateSuspender.using()](xref:com.scichart.core.framework.UpdateSuspender.using(com.scichart.core.framework.ISuspendable,java.lang.Runnable)) helper method which accepts <xref:com.scichart.core.framework.ISuspendable> which should be suspended and [Runnable](https://developer.android.com/reference/java/lang/Runnable) which should be executed while <xref:com.scichart.core.framework.ISuspendable> is suspended.

# [Java](#tab/java)
[!code-java[SuspendingUpdates](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/advanced2dTopics/SuspendingUpdatesOfChart.java#SuspendingUpdates)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[SuspendingUpdates](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/advanced2dTopics/SuspendingUpdatesOfChart.java#SuspendingUpdates)]
# [Kotlin](#tab/kotlin)
[!code-swift[SuspendingUpdates](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/advanced2dTopics/SuspendingUpdatesOfChart.kt#SuspendingUpdates)]
***

## Using UpdateSuspender API to avoid problems because of multithreading

By default <xref:com.scichart.charting.visuals.SciChartSurface> can be used with different <xref:com.scichart.drawing.common.IRenderSurface> [implementations](xref:chart2d.advanced2dTopics.RendererPlugins). Some of them create a separate Java Thread for rendering (e.g. <xref:com.scichart.drawing.opengl.RenderSurfaceGL> and <xref:com.scichart.drawing.opengl.GLTextureView>). This means that chart can be updated from one Thread ( usually from UI Thread ) and rendered on other thread. Potentially this could lead to different problems ( race conditions, deadlocks etc ) when different Threads try to get access to some shared resource ( in our case <xref:com.scichart.charting.visuals.SciChartSurface> or its part). In this case <xref:com.scichart.core.framework.UpdateSuspender> API which allows to avoid these kind of problems by telling <xref:com.scichart.charting.visuals.SciChartSurface> or its part that you want to update it.
