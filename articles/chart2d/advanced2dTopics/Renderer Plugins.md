---
uid: "chart2d.advanced2dTopics.RendererPlugins"
---

# Renderer Plugins

SciChart ships with three swappable renderer plugins which perform the final draw for RenderableSeries and Axes on the [renderSurface](xref:com.scichart.charting.visuals.SciChartSurface.getRenderSurface()). These plugins are detailed below. To use them you can [set renderSurface](xref:com.scichart.charting.visuals.SciChartSurface.setRenderSurface(com.scichart.drawing.common.IRenderSurface)) or extend <xref:com.scichart.charting.visuals.SciChartSurface> and overide <xref:com.scichart.charting.visuals.SciChartSurface.getDefaultRenderSurface(android.content.Context)> to return alternaitive implementation:

# [Java](#tab/java)
[!code-java[SetRenderSurface](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/advanced2dTopics/RendererPlugins.java#SetRenderSurface)]
[!code-java[CreateCanvasSciChartSurface](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/advanced2dTopics/RendererPlugins.java#CreateCanvasSciChartSurface)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[SetRenderSurface](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/advanced2dTopics/RendererPlugins.java#SetRenderSurface)]
[!code-java[CreateCanvasSciChartSurface](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/advanced2dTopics/RendererPlugins.java#CreateCanvasSciChartSurface)]
# [Kotlin](#tab/kotlin)
[!code-swift[SetRenderSurface](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/advanced2dTopics/RendererPlugins.kt#SetRenderSurface)]
[!code-swift[CreateCanvasSciChartSurface](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/advanced2dTopics/RendererPlugins.kt#CreateCanvasSciChartSurface)]
***

## GLTextureView

Since v3.0 <xref:com.scichart.drawing.opengl.GLTextureView> is a default <xref:com.scichart.drawing.common.IRenderSurface> implementation which is used by <xref:com.scichart.charting.visuals.SciChartSurface> for drawing of its RenderableSeries and Axes. It uses OpenGL for rendering ( it's based on [TextureView](https://developer.android.com/reference/android/view/TextureView) class provided by Android SDK) and creates a separate Thread for rendering which makes is suitable for the most cases. Unlike <xref:com.scichart.drawing.opengl.RenderSurfaceGL> it doesn't have a problem with Z-order and transparency but is abit slower because it requires GPU to blitt its content onto the View layer. The GPU can do this quickly, but in case of <xref:com.scichart.drawing.opengl.RenderSurfaceGL> which creates a separate layer for this it isn't required at all.

## RenderSurfaceGL
The <xref:com.scichart.drawing.opengl.RenderSurfaceGL> was default RenderSurface used by SciChart Android prior to v3.0. It uses OpenGL for rendering and based on [GLSurfaceView](https://developer.android.com/reference/android/opengl/GLSurfaceView) class provided by Android SDK. This is the fastest implementation in terms of performance because its surface which is used for rendering gets passed directly to the surface compositor, so when you draw on it with OpenGL there's relatively little overhead. Also it uses separate Thread for rendering. This makes it fast, but it also makes it not play quite right with the View hierarchy, because the surface is rendered on one layer and the View-based UI is on a different layer. This means that if you use this type of surface you can get a problem with Z-order and problem with transparency ( you can't place Android View below surface )

## RenderSurface
<xref:com.scichart.drawing.canvas.RenderSurface> uses [Canvas API](https://developer.android.com/reference/android/graphics/Canvas) isntead of OpenGL for rendering and doesn't use separate Thread for rendering which makes it slower than other OpenGL based <xref:com.scichart.drawing.common.IRenderSurface> implementations, but because of this it doesn't introduce overhead on startup ( it doesn't require additional time to initialize OpenGL and start render Thread ) which may lead to seing a black screen on startup when surface isn't fully initialized. This makes it ideal for cases when you need to attach/detach <xref:com.scichart.charting.visuals.SciChartSurface> from View hierarchy many times (e.g. when you place chart into RecycleView which recycles its items)
