---
uid: "annotationsAPIs.LineArrowAnnotation"
---

# The LineArrowAnnotation
The <xref:com.scichart.charting.visuals.annotations.LineArrowAnnotation> draws an **arrow** from `[X1, X2]` to `[Y1, Y2]` coordinates:

![Line Arrow Annotation](images/line-arrow-annotation.png)

> [!NOTE]
> Examples of the **Annotations** usage can be found in the [SciChart Android Examples Suite](https://www.scichart.com/examples/Android-chart/) as well as on [GitHub](https://github.com/ABTSoftware/SciChart.Android.Examples):
> - [Native Android Chart Annotations Example](https://www.scichart.com/example/android-chart/android-chart-annotations-example/)
> - [Native Android Chart Interactive Annotations Example](https://www.scichart.com/example/android-chart/android-chart-interaction-with-annotations-example/)
>
> - [Xamarin Android Chart Annotations Example](https://www.scichart.com/example/xamarin-chart/xamarin-chart-annotations-example/)
> - [Xamarin Android Chart Interactive Annotations Example](https://www.scichart.com/example/xamarin-chart/xamarin-chart-interaction-with-annotations-example/)

The <xref:com.scichart.charting.visuals.annotations.LineArrowAnnotation> class provides the [stroke](xref:com.scichart.charting.visuals.annotations.LineAnnotationBase.setStroke(com.scichart.drawing.common.PenStyle)) property which is used to define the line annotation color. It expects a <xref:com.scichart.drawing.common.PenStyle> object.
To learn more about **Pens** and **Brushes** and how to utilize them, please refer to the [PenStyle, BrushStyle and FontStyle](xref:stylingAndTheming.PenStyleBrushStyleAndFontStyle) article.

> [!NOTE]
> To learn more about **Annotations** in general - please see the [Common Annotation Features](xref:annotationsAPIs.AnnotationsAPIs#common-annotations-features) article.

A <xref:com.scichart.charting.visuals.annotations.LineArrowAnnotation> is placed on a chart at the position determined by its `[X1, Y1]` and `[X2, Y2]` coordinates, which specifies the start and end of the **arrow**.
Those can be accessed via the following properties: [x1](xref:com.scichart.charting.visuals.annotations.IAnnotation.setX1(java.lang.Comparable)), [y1](xref:com.scichart.charting.visuals.annotations.IAnnotation.setY1(java.lang.Comparable)), [x2](xref:com.scichart.charting.visuals.annotations.IAnnotation.setX2(java.lang.Comparable)), [y2](xref:com.scichart.charting.visuals.annotations.IAnnotation.setY2(java.lang.Comparable))

The arrow's head is placed at `[X2, Y2]` coordinates, its size is determined by the following properties:
- <xref:com.scichart.charting.visuals.annotations.LineArrowAnnotation.setHeadLength(float)>
- <xref:com.scichart.charting.visuals.annotations.LineArrowAnnotation.setHeadWidth(float)>

> [!NOTE]
> The **xAxisId** and **yAxisId** must be supplied if you have an axis with **non-default** Axis Ids, e.g. in **multi-axis** scenario.

## Create a LineArrow Annotation
A <xref:com.scichart.charting.visuals.annotations.LineArrowAnnotation> can be added onto a chart using the following code:

# [Java](#tab/java)
[!code-java[AddLineArrowAnnotation](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/annotationsAPIs/LineArrowAnnotationFragment.java#AddLineArrowAnnotation)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[AddLineArrowAnnotation](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/annotationsAPIs/LineArrowAnnotationFragment.java#AddLineArrowAnnotation)]
# [Kotlin](#tab/kotlin)
[!code-swift[AddLineArrowAnnotation](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/annotationsAPIs/LineArrowAnnotationFragment.kt#AddLineArrowAnnotation)]
***

> [!NOTE]
> To learn more about other **Annotation Types**, available out of the box in SciChart, please find the comprehensive list in the [Annotation APIs](xref:annotationsAPIs.AnnotationsAPIs) article.
