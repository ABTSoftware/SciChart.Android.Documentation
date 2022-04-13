---
uid: "chart2d.advanced2dTopics.ExportChartToBitmap"
---

# Export Chart to Bitmap

SciChart features a number of ways to export the chart to Bitmap.

## Export Chart from Screen to Bitmap

SciChart supports export to Bitmap. To take screenshot the current chart on screen and get a Bitmap in memory, call the following code:

# [Java](#tab/java)
[!code-java[ExportToBitmap](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/advanced2dTopics/ExportChartToBitmap.java#ExportToBitmap)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[ExportToBitmap](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/advanced2dTopics/ExportChartToBitmap.java#ExportToBitmap)]
# [Kotlin](#tab/kotlin)
[!code-swift[ExportToBitmap](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/advanced2dTopics/ExportChartToBitmap.kt#ExportToBitmap)]
***

## Export Chart to Bitmap in Memory at specific Size
SciChart supports exporting to Bitmap at a specific size without showing chart on screen ( in-memory export ). This method can be used to create a larger or higher resolution image than the chart currently on screen.

To do this, please use the following code:

# [Java](#tab/java)
[!code-java[ExportToBitmapInMemoryAtSize](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/advanced2dTopics/ExportChartToBitmap.java#ExportToBitmapInMemoryAtSize)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[ExportToBitmapInMemoryAtSize](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/advanced2dTopics/ExportChartToBitmap.java#ExportToBitmapInMemoryAtSize)]
# [Kotlin](#tab/kotlin)
[!code-swift[ExportToBitmapInMemoryAtSize](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/advanced2dTopics/ExportChartToBitmap.kt#ExportToBitmapInMemoryAtSize)]
***

## Export ViewGroup which contains ScichartSurface
By default <xref:com.scichart.charting.visuals.SciChartSurface> can be used with different <xref:com.scichart.drawing.common.IRenderSurface> [implementations](xref:chart2d.advanced2dTopics.RendererPlugins). Some of them (e.g. <xref:com.scichart.drawing.opengl.RenderSurfaceGL> which uses OpenGL for rendering of its content) won't be visible when you call [draw()](https://developer.android.com/reference/android/view/View.html#draw(android.graphics.Canvas)) on parent ViewGroup. So if you need to export ViewGroup which contains <xref:com.scichart.charting.visuals.SciChartSurface> then you need to switch to Canvas based <xref:com.scichart.drawing.canvas.RenderSurface> before export:

# [Java](#tab/java)
[!code-java[SetRenderSurface](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/advanced2dTopics/ExportChartToBitmap.java#SetRenderSurface)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[SetRenderSurface](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/advanced2dTopics/ExportChartToBitmap.java#SetRenderSurface)]
# [Kotlin](#tab/kotlin)
[!code-swift[SetRenderSurface](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/advanced2dTopics/ExportChartToBitmap.kt#SetRenderSurface)]
***
