---
uid: "chart2d.animationsAPI.AnimateAppendedPoint"
---

# Animations API - Animate Appended Point
SciChart library has several built-in animations which you can use to animate your Renderable Series.
> [!NOTE]
> Please refer to the [Animations API](xref:chart2d.animationsAPI) article for more details.

Also, you can create a custom animation and have complete control over data appearing on the screen. This tutorial shows how to animate the last appended point to a <xref:com.scichart.charting.visuals.renderableSeries.FastLineRenderableSeries> in real-time.

To achieve that we'd need to perform 2 steps:
- [Create a new transformation](#create-transformation) - a class that implements a <xref:com.scichart.charting.visuals.renderableSeries.transformation.IRenderPassDataTransformation> protocol.
- [Animate your series](#animate-series) using previously created transformation

<video autoplay loop muted playsinline src="../2dChartTypes/images/animating-line-chart-example.mp4"></video>

> [!NOTE]
> A complete project of the **Animated Line Series** example you can find in the [SciChart Android Examples Suite](https://www.scichart.com/examples/Android-chart/) as well as on [GitHub](https://github.com/ABTSoftware/SciChart.Android.Examples):
> - [Native Example](https://www.scichart.com/example/android-chart/android-chart-animating-line-chart-example/)

## Create transformation
Creating transformation is fairly simple. We have to create a class that implements an <xref:com.scichart.charting.visuals.renderableSeries.transformation.IRenderPassDataTransformation> protocol and pass an <xref:com.scichart.charting.visuals.renderableSeries.data.ISeriesRenderPassData> type suitable for your Renderable Series. In our case we will subclass an abstract class <xref:com.scichart.charting.visuals.animations.BaseRenderPassDataTransformation>, pass <xref:com.scichart.charting.visuals.renderableSeries.data.LineRenderPassData> type and implement few required methods.
The code would look like follows:

# [Java](#tab/java)
[!code-java[CreateAppendedPointTransformation](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/series2d/AnimateAppendedPoint.java#CreateAppendedPointTransformation)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[CreateAppendedPointTransformation](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/series2d/AnimateAppendedPoint.java#CreateAppendedPointTransformation)]
# [Kotlin](#tab/kotlin)
[!code-swift[CreateAppendedPointTransformation](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/series2d/AnimateAppendedPoint.kt#CreateAppendedPointTransformation)]
***

## Animate series
With the transformation created above, all we need to do is just animate our series.
It's easily achievable with <xref:com.scichart.charting.visuals.animations.AnimationsHelper> APIs like below:

# [Java](#tab/java)
[!code-java[UseAppendedPointTransformation](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/series2d/AnimateAppendedPoint.java#UseAppendedPointTransformation)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[UseAppendedPointTransformation](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/series2d/AnimateAppendedPoint.java#UseAppendedPointTransformation)]
# [Kotlin](#tab/kotlin)
[!code-swift[UseAppendedPointTransformation](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/series2d/AnimateAppendedPoint.kt#UseAppendedPointTransformation)]
***

> [!NOTE]
> You may also take a look at the [Animations API - Animate Updated Point](xref:chart2d.animationsAPI.AnimateUpdatedPoint) article to find out how to animate Series after updating existing data points.
