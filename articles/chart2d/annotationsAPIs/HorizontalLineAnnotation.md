---
uid: "annotationsAPIs.HorizontalLineAnnotation"
---

# The HorizontalLineAnnotation
The <xref:com.scichart.charting.visuals.annotations.HorizontalLineAnnotation> draws the **horizontal line** between `X1` and `X2` coordinates at `Y1`:

> [!NOTE]
> You might find it useful to learn about the [VerticalLineAnnotation](xref:annotationsAPIs.VerticalLineAnnotation) as well since it's very similar with the **Horizontal** one.

![Horizontal Line Annotation](images/horizontal-line-annotation.png)

> [!NOTE]
> Examples of the **Annotations** usage can be found in the [SciChart Android Examples Suite](https://www.scichart.com/examples/Android-chart/) as well as on [GitHub](https://github.com/ABTSoftware/SciChart.Android.Examples):
> - [Native Android Chart Annotations Example](https://www.scichart.com/example/android-chart/android-chart-annotations-example/)
> - [Native Android Chart Interactive Annotations Example](https://www.scichart.com/example/android-chart/android-chart-interaction-with-annotations-example/)
>
> - [Xamarin Android Chart Annotations Example](https://www.scichart.com/example/xamarin-chart/xamarin-chart-annotations-example/)
> - [Xamarin Android Chart Interactive Annotations Example](https://www.scichart.com/example/xamarin-chart/xamarin-chart-interaction-with-annotations-example/)

The <xref:com.scichart.charting.visuals.annotations.HorizontalLineAnnotation> class is inherited from [LineAnnotation](xref:annotationsAPIs.LineAnnotation), and hence, provides the [stroke](xref:com.scichart.charting.visuals.annotations.LineAnnotationBase.setStroke(com.scichart.drawing.common.PenStyle)) property which is used to define the line annotation color. It expects a <xref:com.scichart.drawing.common.PenStyle> object.
To learn more about **Pens** and **Brushes** and how to utilize them, please refer to the [PenStyle, BrushStyle and FontStyle](xref:stylingAndTheming.PenStyleBrushStyleAndFontStyle) article.

> [!NOTE]
> To learn more about **Annotations** in general - please see the [Common Annotation Features](xref:annotationsAPIs.AnnotationsAPIs#common-annotations-features) article.

In **general** case, the position of an <xref:com.scichart.charting.visuals.annotations.HorizontalLineAnnotation> can be defined by the [y1](xref:com.scichart.charting.visuals.annotations.IAnnotation.setY1(java.lang.Comparable)) value only, which will lead to full-width horizontal line at `Y1` coordinate.

Despite the above, it is possible to specify `X1` and `X2` coordinates for the line ends, but it will work differently while combined with different [Gravity](https://developer.android.com/reference/android/view/Gravity). 
[horizontalGravity](xref:com.scichart.charting.visuals.annotations.HorizontalLineAnnotation.setHorizontalGravity(int)) property can consume the following values:
- [Gravity.LEFT](https://developer.android.com/reference/android/view/Gravity.html#LEFT) - the `X1` coordinate will be applied to the **right** end of a line. The line appears pinned to the **left** side.
- [Gravity.RIGHT](https://developer.android.com/reference/android/view/Gravity.html#RIGHT) - the `X1` coordinate will be applied to the **left** end of a line. The line appears pinned to the **right** side.
- [Gravity.CENTER_HORIZONTAL](https://developer.android.com/reference/android/view/Gravity.html#CENTER_HORIZONTAL) - both `X1` and `X2` coordinates **will be applied**.
- [Gravity.FILL_HORIZONTAL](https://developer.android.com/reference/android/view/Gravity.html#FILL_HORIZONTAL) - both `X1` and `X2` coordinates **are ignored**. The line appears horizontally stretched. This is the **default value**.

The `X1` and `X2` values can be accessed via the [x1](xref:com.scichart.charting.visuals.annotations.IAnnotation.setX1(java.lang.Comparable)) and [x2](xref:com.scichart.charting.visuals.annotations.IAnnotation.setX2(java.lang.Comparable)) properties

> [!NOTE]
> The **xAxisId** and **yAxisId** must be supplied if you have an axis with **non-default** Axis Ids, e.g. in **multi-axis** scenario.

## Create a HorizontalLine Annotation
A <xref:com.scichart.charting.visuals.annotations.HorizontalLineAnnotation> can be added onto a chart using the following code:

# [Java](#tab/java)
[!code-java[AddHorizontalLineAnnotation](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/annotationsAPIs/HorizontalLineAnnotationFragment.java#AddHorizontalLineAnnotation)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[AddHorizontalLineAnnotation](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/annotationsAPIs/HorizontalLineAnnotationFragment.java#AddHorizontalLineAnnotation)]
# [Kotlin](#tab/kotlin)
[!code-swift[AddHorizontalLineAnnotation](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/annotationsAPIs/HorizontalLineAnnotationFragment.kt#AddHorizontalLineAnnotation)]
***

> [!NOTE]
> To learn more about other **Annotation Types**, available out of the box in SciChart, please find the comprehensive list in the [Annotation APIs](xref:annotationsAPIs.AnnotationsAPIs) article.

## The AnnotationLabels collection
By default, the <xref:com.scichart.charting.visuals.annotations.HorizontalLineAnnotation> does not show any labels. You can show a label by adding a <xref:com.scichart.charting.visuals.annotations.AnnotationLabel> to the <xref:com.scichart.charting.visuals.annotations.LineAnnotationWithLabelsBase.annotationLabels> collection, like below:

# [Java](#tab/java)
[!code-java[AddHorizontalLineAnnotationLabel](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/annotationsAPIs/HorizontalLineAnnotationFragment.java#AddHorizontalLineAnnotationLabel)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[AddHorizontalLineAnnotationLabel](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/annotationsAPIs/HorizontalLineAnnotationFragment.java#AddHorizontalLineAnnotationLabel)]
# [Kotlin](#tab/kotlin)
[!code-swift[AddHorizontalLineAnnotationLabel](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/annotationsAPIs/HorizontalLineAnnotationFragment.kt#AddHorizontalLineAnnotationLabel)]
***

The Label position can be changed by setting the [labelPlacement](xref:com.scichart.charting.visuals.annotations.AnnotationLabel.setLabelPlacement(com.scichart.charting.visuals.annotations.LabelPlacement)) property which expects one of the <xref:com.scichart.charting.visuals.annotations.LabelPlacement> enumeration.

> [!NOTE]
> Everything about **AnnotationLabels collection** and <xref:com.scichart.charting.visuals.annotations.AnnotationLabel> can be also applied to the [VerticalLineAnnotation](xref:annotationsAPIs.VerticalLineAnnotation)

#### The AnnotationLabel Type
You can change appearance, position, custom value, etcetera for any annotation label which are listed below:
- [setLabelStyle](xref:com.scichart.charting.visuals.annotations.AnnotationLabel.setLabelStyle(com.scichart.core.common.Action1<com.scichart.charting.visuals.annotations.AnnotationLabel>)) - applies style for AnnotationLabel.
- [rotationAngle](xref:com.scichart.charting.visuals.layout.RotationLayout.setRotationAngle(float)) - allows to rotate annotation label text, expects ***degrees***
- [text](xref:com.scichart.charting.visuals.annotations.TextLabelContainer.setText(java.lang.CharSequence)) - you can set custom **text** for your label.
- [fontStyle](xref:com.scichart.charting.visuals.annotations.TextLabelContainer.setFontStyle(com.scichart.drawing.common.FontStyle)) - applies the <xref:com.scichart.drawing.common.FontStyle> object onto the text.

> [!NOTE]
> By default, <xref:com.scichart.charting.visuals.annotations.AnnotationLabel> uses its associated axis `Y-value` to display a label.
> To learn more about **Pens** and **Brushes** and how to utilize them, please refer to the [PenStyle, BrushStyle and FontStyle](xref:stylingAndTheming.PenStyleBrushStyleAndFontStyle) article.

Also, you can have more than one **AnnotationLabel** associated with <xref:com.scichart.charting.visuals.annotations.HorizontalLineAnnotation> by adding more than one to the <xref:com.scichart.charting.visuals.annotations.LineAnnotationWithLabelsBase.annotationLabels> collection.

Please see the code below, which showcases the utilization of the above settings:

# [Java](#tab/java)
[!code-java[AddAnnotationLabelsToHorizontalLineAnnotation](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/annotationsAPIs/HorizontalLineAnnotationFragment.java#AddAnnotationLabelsToHorizontalLineAnnotation)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[AddAnnotationLabelsToHorizontalLineAnnotation](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/annotationsAPIs/HorizontalLineAnnotationFragment.java#AddAnnotationLabelsToHorizontalLineAnnotation)]
# [Kotlin](#tab/kotlin)
[!code-swift[AddAnnotationLabelsToHorizontalLineAnnotation](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/annotationsAPIs/HorizontalLineAnnotationFragment.kt#AddAnnotationLabelsToHorizontalLineAnnotation)]
***

The result will be the following:

![Horizontal Line Annotation With Labels](images/horizontal-line-annotation-with-labels.png)

#### Annotation Label Value and TextFormatting
By default, the label text is formatted by the [textFormatting](xref:com.scichart.charting.visuals.axes.IAxisCore.setTextFormatting(java.lang.String)) property. For more information, refer to the [Axis Labels - TextFormatting and CursorTextFormatting](xref:axisAPIs.AxisLabelsTextFormattingAndCursorTextFormatting) article.

But you can also override the default behaviour by providing a custom <xref:com.scichart.charting.visuals.annotations.IFormattedValueProvider> for your <xref:com.scichart.charting.visuals.annotations.HorizontalLineAnnotation> corresponding property.

Let's see a short example which shows how to use the above:

# [Java](#tab/java)
[!code-java[CreateAnnotationValueProviderForHorizontalLineAnnotation](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/annotationsAPIs/HorizontalLineAnnotationFragment.java#CreateAnnotationValueProviderForHorizontalLineAnnotation)]
[!code-java[UseAnnotationValueProviderForHorizontalLineAnnotation](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/annotationsAPIs/HorizontalLineAnnotationFragment.java#UseAnnotationValueProviderForHorizontalLineAnnotation)]

# [Java with Builders API](#tab/javaBuilder)
[!code-java[CreateAnnotationValueProviderForHorizontalLineAnnotation](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/annotationsAPIs/HorizontalLineAnnotationFragment.java#CreateAnnotationValueProviderForHorizontalLineAnnotation)]
[!code-java[UseAnnotationValueProviderForHorizontalLineAnnotation](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/annotationsAPIs/HorizontalLineAnnotationFragment.java#UseAnnotationValueProviderForHorizontalLineAnnotation)]

# [Kotlin](#tab/kotlin)
[!code-swift[CreateAnnotationValueProviderForHorizontalLineAnnotation](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/annotationsAPIs/HorizontalLineAnnotationFragment.kt#CreateAnnotationValueProviderForHorizontalLineAnnotation)]
[!code-swift[UseAnnotationValueProviderForHorizontalLineAnnotation](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/annotationsAPIs/HorizontalLineAnnotationFragment.kt#UseAnnotationValueProviderForHorizontalLineAnnotation)]
***

The result will be the following:

![Horizontal Line Annotation Label Formatting](images/horizontal-line-annotation-label-formatting.png)

> [!NOTE]
> To learn more about other **Annotation Types**, available out of the box in SciChart, please find the comprehensive list in the [Annotation APIs](xref:annotationsAPIs.AnnotationsAPIs) article.