---
uid: "annotationsAPIs.FreehandDrawingAnnotation"
---

# The FreehandDrawingAnnotation
The <xref:com.scichart.charting.visuals.annotations.tradingAnnotations.FreehandDrawingAnnotation> allows for freehand drawing on the chart:

![Freehand Drawing Annotation](images/brush-annotation.png)

> [!NOTE]
> Examples of the **Annotations** usage can be found in the [SciChart Android Examples Suite](https://www.scichart.com/examples/Android-chart/) as well as on [GitHub](https://github.com/ABTSoftware/SciChart.Android.Examples):
> - [Native Android Chart Annotations Example](https://www.scichart.com/example/android-chart/android-chart-annotations-example/)
> - [Native Android Chart Interactive Annotations Example](https://www.scichart.com/example/android-chart/android-chart-interaction-with-annotations-example/)
>
> - [Xamarin Android Chart Annotations Example](https://www.scichart.com/example/xamarin-chart/xamarin-chart-annotations-example/)
> - [Xamarin Android Chart Interactive Annotations Example](https://www.scichart.com/example/xamarin-chart/xamarin-chart-interaction-with-annotations-example/)

A <xref:com.scichart.charting.visuals.annotations.tradingAnnotations.FreehandDrawingAnnotation> is a multi-point annotation that stores a collection of points to form a freehand stroke. 
It provides properties to customize its appearance:
- [brushColor](xref:com.scichart.charting.visuals.annotations.tradingAnnotations.FreehandDrawingAnnotation.setBrushColor(int)): Sets the color of the brush stroke.
- [brushThickness](xref:com.scichart.charting.visuals.annotations.tradingAnnotations.FreehandDrawingAnnotation.setBrushThickness(float)): Sets the thickness of the brush stroke.

Points can be added or updated using the following methods:
- [setBasePoint(Comparable<?> x, Comparable<?> y)](xref:com.scichart.charting.visuals.annotations.tradingAnnotations.FreehandDrawingAnnotation.setBasePoint(java.lang.Comparable, java.lang.Comparable)): Adds a new point to the annotation.
- [updateBasePoint(int index, Comparable<?> x, Comparable<?> y)](xref:com.scichart.charting.visuals.annotations.tradingAnnotations.FreehandDrawingAnnotation.updateBasePoint(int, java.lang.Comparable, java.lang.Comparable)): Updates an existing point at the specified index.

> [!NOTE]
> The **xAxisId** and **yAxisId** must be supplied if you have axis with **non-default** Axis Ids, e.g. in **multi-axis** scenario.

## Create a FreehandDrawingAnnotation
A <xref:com.scichart.charting.visuals.annotations.tradingAnnotations.FreehandDrawingAnnotation> can be added onto a chart using the following code:

# [Java](#tab/java)
[!code-java[AddFreehandDrawingAnnotation](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/annotationsAPIs/FreehandDrawingAnnotationFragment.java#AddFreehandDrawingAnnotation)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[AddFreehandDrawingAnnotation](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/annotationsAPIs/FreehandDrawingAnnotationFragment.java#AddFreehandDrawingAnnotation)]
# [Kotlin](#tab/kotlin)
[!code-swift[AddFreehandDrawingAnnotation](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/annotationsAPIs/FreehandDrawingAnnotationFragment.kt#AddFreehandDrawingAnnotation)]
***

> [!NOTE]
> For interactive creation of the `FreehandDrawingAnnotation`, use the [FreehandDrawingAnnotationCreationModifier](xref:annotationsAPIs.FreehandDrawingAnnotationCreationModifier).

> [!NOTE]
> To learn more about other **Annotation Types**, available out of the box in SciChart, please find the comprehensive list in the [Annotation APIs](xref:annotationsAPIs.AnnotationsAPIs) article.
