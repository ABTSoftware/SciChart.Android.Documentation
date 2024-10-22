---
uid: "annotationsAPIs.ImageAnnotation"
---

# The ImageAnnotation
The <xref:com.scichart.charting.visuals.annotations.ImageAnnotation> draws a rectangle at specific `X1, X2, Y1, Y2` coordinates:

<img src="images/image_annotation.png" width="40%">

<!-- > [!NOTE]
> Examples of the **Annotations** usage can be found in the [SciChart Android Examples Suite](https://www.scichart.com/examples/Android-chart/) as well as on [GitHub](https://github.com/ABTSoftware/SciChart.Android.Examples):
> - [Native Android Chart Annotations Example](https://www.scichart.com/example/android-chart/android-chart-annotations-example/)
> - [Native Android Chart Interactive Annotations Example](https://www.scichart.com/example/android-chart/android-chart-interaction-with-annotations-example/)
>
> - [Xamarin Android Chart Annotations Example](https://www.scichart.com/example/xamarin-chart/xamarin-chart-annotations-example/)
> - [Xamarin Android Chart Interactive Annotations Example](https://www.scichart.com/example/xamarin-chart/xamarin-chart-interaction-with-annotations-example/) -->

A <xref:com.scichart.charting.visuals.annotations.ImageAnnotation> is placed on a chart at the position determined by its `[X1, Y1]` and `[X2, Y2]` coordinates, which correspond to the **top-left** and **bottom-right** corners of the drawn rectangle. 
Those can be accessed via the following properties: [x1](xref:com.scichart.charting.visuals.annotations.IAnnotation.setX1(java.lang.Comparable)), [y1](xref:com.scichart.charting.visuals.annotations.IAnnotation.setY1(java.lang.Comparable)), [x2](xref:com.scichart.charting.visuals.annotations.IAnnotation.setX2(java.lang.Comparable)), [y2](xref:com.scichart.charting.visuals.annotations.IAnnotation.setY2(java.lang.Comparable))

A <xref:com.scichart.charting.visuals.annotations.ImageAnnotation> can also be placed on a chart at the position determined by its `[X1, Y1]` coordinates, which correspond to the **top-left** corners, here <xref:com.scichart.charting.visuals.annotations.ImageAnnotation> will take the size of the image provided and will maintain its size and aspect ration on zoom and pan.

Image aspect ratio can be changed by setting [setContentMode(contentMode)](xref:com.scichart.charting.visuals.annotations.ImageAnnotation.setContentMode(com.scichart.charting.visuals.annotations.ContentModeEnum)) which accepts `AspectFit` and `FitXY`

> [!NOTE]
> The **xAxisId** and **yAxisId** must be supplied if you have axis with **non-default** Axis Ids, e.g. in **multi-axis** scenario.

## Create a ImageAnnotation
A <xref:com.scichart.charting.visuals.annotations.ImageAnnotation> can be added onto a chart using the following code:

# [Java](#tab/java)
[!code-java[AddBoxAnnotation](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/annotationsAPIs/ImageAnnotationFragment.java#AddImageAnnotation)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[AddBoxAnnotation](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/annotationsAPIs/ImageAnnotationFragment.java#AddImageAnnotation)]
# [Kotlin](#tab/kotlin)
[!code-swift[AddBoxAnnotation](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/annotationsAPIs/ImageAnnotationFragment.kt#AddImageAnnotation)]
***

> [!NOTE]
> To learn more about other **Annotation Types**, available out of the box in SciChart, please find the comprehensive list in the [Annotation APIs](xref:annotationsAPIs.AnnotationsAPIs) article.
