---
uid: "tutorials2d.SciChartAndroidTutorial-Annotations"
---

# SciChart Android Tutorial - Annotations
In the [prior tutorials](xref:tutorials2d.SciChartAndroidTutorial-AddingRealtimeUpdates) we have familiarized with a great and powerful SciChart functionality.
In this one we are going to lean about another powerful SciChart API - [Annotations API](xref:chart2d.animationsAPI) which allows placing different elements to the Chart.

Annotation available out of the box in SciChart are listed below:
- [BoxAnnotation](xref:annotationsAPIs.BoxAnnotation)
- [LineAnnotation](xref:annotationsAPIs.LineAnnotation)
- [LineArrowAnnotation](xref:annotationsAPIs.LineArrowAnnotation)
- [HorizontalLineAnnotation](xref:annotationsAPIs.HorizontalLineAnnotation)
- [VerticalLineAnnotation](xref:annotationsAPIs.VerticalLineAnnotation)
- [TextAnnotation](xref:annotationsAPIs.TextAnnotation)
- [AxisLabelAnnotation](xref:annotationsAPIs.AxisLabelAnnotation)
- [AxisMarkerAnnotation](xref:annotationsAPIs.AxisMarkerAnnotation)
- [CustomAnnotation](xref:annotationsAPIs.CustomAnnotation)

## Getting Started
This tutorial is suitable for **Java** and **Kotlin**.

> [!NOTE]
> Source code for this tutorial can be found at our Github Repository: [!include[Java and Kotlin Tutorials Repository](JavaKotlinTutorialsLink.md)]

In this tutorial, we are going to build on top of the [FIFO scrolling chart](xref:tutorials2d.SciChartAndroidTutorial-AddingRealtimeUpdates#discarding-data-when-scrolling-using-fifocapacity) that was implemented in the previous [Adding Realtime Updates](xref:tutorials2d.SciChartAndroidTutorial-AddingRealtimeUpdates) tutorial.

Please make corresponding amendments to your code if required.

## Adding Annotations to the Chart
Lets add a kind of news bulletin markers to the chart, one per 100 data points.
To achieve this, we are going to modify our `updateData` handler.
We want to create a <xref:com.scichart.charting.visuals.annotations.TextAnnotation> with some **text** and **background** and add it to the [annotations](xref:com.scichart.charting.visuals.ISciChartSurface.getAnnotations()) collection.

See the modified code below:

# [Java](#tab/java)
[!code-java[AddAnnotations](../../../samples/tutorials-native/tutorials-2d/tutorial-5/java/src/main/java/com/scichart/tutorial/MainActivity.java#AddAnnotations)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[AddAnnotations](../../../samples/tutorials-native/tutorials-2d/tutorial-5/javaBuilder/src/main/java/com/scichart/tutorial/MainActivity.java#AddAnnotations)]
# [Kotlin](#tab/kotlin)
[!code-swift[AddAnnotations](../../../samples/tutorials-native/tutorials-2d/tutorial-5/kotlin/src/main/java/com/scichart/tutorial/MainActivity.kt#AddAnnotations)]
# [Xamarin.Android](#tab/xamarin)
[!code-cs[AddAnnotations](../../../samples/tutorials-xamarin/tutorials-2d/tutorial-05/MainActivity.cs#AddAnnotations)]
***

> [!NOTE]
> After appending new data we call `zoomExtents` to make series to fit the viewport.

Which will result in the following:

<video autoplay loop muted playsinline src="images/tutorials-2d-annotations.mp4"></video>

## Where to Go From Here?
You can download the final project from our [!include[Java and Kotlin Tutorials Repository](JavaKotlinTutorialsLink.md)].

Also, you can found **next tutorial** from this series here - [SciChart Android Tutorial - Multiple Axis](xref:tutorials2d.SciChartAndroidTutorial-MultipleAxis)

Of course, this is not the limit of what you can achieve with the SciChart Android. You might want to read the article about **annotations**:
- [Annotations API](xref:chart2d.animationsAPI)

as well as some other general articles listed below:
- [Axis Types](xref:axis.AxisAPIs)
- [2D Chart Types](xref:chart2d.2DChartTypes)
- [Chart Modifiers](xref:chartModifierAPIs.ChartModifierAPIs)

Finally, start exploring. The SciChart Android library and functionality is quite extensive. 
You can look into our [SciChart Android Examples Suite](https://www.scichart.com/examples/android-chart/) which are full of 2D and 3D examples, which are also available on our [GitHub](https://github.com/ABTSoftware/SciChart.Android.Examples)
