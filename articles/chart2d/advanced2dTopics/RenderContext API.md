---
uid: "chart2d.advanced2dTopics.RenderContextAPI"
---

# RenderContext API

The secret to SciChart’s speed is a bespoke, immediate-mode raster drawing engine. This means that all drawing in SciChart is done ‘immediately’ to the screen, and is cleared and redrawn each time the chart is updated.

Now in SciChart you can take advantage of our immediate-mode drawing API, to create custom RenderableSeries, custom Point-Markers, Draw on top of the chart, or even create your own immediate-mode drawing applications.

## The IRenderContext2D Interface
All the drawing to the separate layer is achieved with the <xref:com.scichart.drawing.common.IRenderContext2D> interface. All drawing is done to the <xref:com.scichart.drawing.common.IRenderSurface>, using either a [Canvas API](xref:com.scichart.drawing.canvas.RenderSurface), or [OpenGL](xref:com.scichart.drawing.opengl.RenderSurfaceGL) depending on your RenderSurface.

Using this interface, you can:

- [draw line](xref:com.scichart.drawing.common.IRenderContext2D.drawLine(float,float,float,float,com.scichart.drawing.common.IPen2D)) of variable stroke width
- [draw a rectangle](xref:com.scichart.drawing.common.IRenderContext2D.drawRect(float,float,float,float,com.scichart.drawing.common.IPen2D))
- [draw an ellipse](xref:com.scichart.drawing.common.IRenderContext2D.drawEllipse(float,float,float,float,com.scichart.drawing.common.IBrush2D)) shape
- [draw triangles Strip](xref:com.scichart.drawing.common.IRenderContext2D.drawTrianglesStrip(float[],int,int,com.scichart.drawing.common.IBrush2D)) with a brush
- [fill an area with a brush](xref:com.scichart.drawing.common.IRenderContext2D.fillRect(float,float,float,float,com.scichart.drawing.common.IBrush2D)) area
- [draw some text](xref:com.scichart.drawing.common.IRenderContext2D.drawText(com.scichart.drawing.common.IFont,float,float,int,java.lang.String)) to the render surface
- [draw sprite](xref:com.scichart.drawing.common.IRenderContext2D.drawSprite(com.scichart.drawing.common.ITexture2D,float,float))
- [set clip rect](xref:com.scichart.drawing.common.IRenderContext2D.setClipRect(float,float,float,float)) which prevents drawing outside specified bounds
- [rotate](xref:com.scichart.drawing.common.IRenderContext2D.rotate(float)), [scale](xref:com.scichart.drawing.common.IRenderContext2D.scale(float,float)) and [translate](xref:com.scichart.drawing.common.IRenderContext2D.translate(float,float)) RenderContext 
Believe it or not, you can achieve a lot with just those!

## The IAssetManager2D interface
The second part RenderContext API is IAssetManager2D interface which is responsible for creation and storing of RenderSurface specific resources from Style classes.

Using this interface, you can

- [create pens](xref:com.scichart.drawing.common.IAssetManager2D.createPen(com.scichart.drawing.common.PenStyle)) to draw stroke with
- [create brushes](xref:com.scichart.drawing.common.IAssetManager2D.createBrush(com.scichart.drawing.common.BrushStyle)) to fill rects, ellipses with
- [create textures](xref:com.scichart.drawing.common.IAssetManager2D.createTexture(android.graphics.Bitmap)) from Bitmap
- [store](xref:com.scichart.drawing.common.IAssetManager2D.storeResource(com.scichart.drawing.common.ResourceId,com.scichart.core.framework.IDisposable)) and [get](xref:com.scichart.drawing.common.IAssetManager2D.getResource(com.scichart.drawing.common.ResourceId)) some heavy resources which should be reused during drawing (e.g. textures, sprites)

## Example of using RenderContext API
For example we'll create a simple example of <xref:com.scichart.drawing.common.IRenderSurfaceRenderer> which can be [set as renderer for RenderSurface](xref:com.scichart.drawing.common.IRenderSurface.setRenderer(com.scichart.drawing.common.IRenderSurfaceRenderer)):

# [Java](#tab/java)
[!code-java[CreateRenderSurfaceRenderer](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/advanced2dTopics/RenderContextAPI.java#CreateRenderSurfaceRenderer)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[CreateRenderSurfaceRenderer](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/advanced2dTopics/RenderContextAPI.java#CreateRenderSurfaceRenderer)]
# [Kotlin](#tab/kotlin)
[!code-swift[CreateRenderSurfaceRenderer](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/advanced2dTopics/RenderContextAPI.kt#CreateRenderSurfaceRenderer)]
***
