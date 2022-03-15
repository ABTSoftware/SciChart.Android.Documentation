---
uid: "chart2d.animationsAPI"
---

# Animations API
In SciChart you can use Animations API to animate **RenderableSeries**. The Animations API is based on our [Transformation API](#transformation-api), which allows to define different <xref:com.scichart.charting.visuals.renderableSeries.transformation.IRenderPassDataTransformation> to your <xref:com.scichart.charting.visuals.renderableSeries.data.ISeriesRenderPassData> during the render pass.

We provide helper <xref:com.scichart.charting.visuals.animations.AnimationsHelper> class, which provides set of methods to create animations for <xref:com.scichart.charting.visuals.renderableSeries.IRenderableSeries>.

Let's see a simple example of using `sweep` animation on our [Line Series](xref:chart2d.renderableSeries.LineSeries):

# [Java](#tab/java)
[!code-java[AnimateLineSeries](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/series2d/AnimationsAPI.java#AnimateLineSeries)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[AnimateLineSeries](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/series2d/AnimationsAPI.java#AnimateLineSeries)]
# [Kotlin](#tab/kotlin)
[!code-swift[AnimateLineSeries](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/series2d/AnimationsAPI.kt#AnimateLineSeries)]
***

<video autoplay loop muted playsinline src="../2dChartTypes/images/sweep-line-animation.mp4"></video>

Under the hood <xref:com.scichart.charting.visuals.animations.AnimationsHelper> methods creates [Android Animator](https://developer.android.com/reference/android/animation/Animator) to animate specified series. After creation of animator you can combine them using [AnimatorSet](https://developer.android.com/reference/android/animation/AnimatorSet) to animate several series at the same time or to create more complex animations.

There are several default implementations of Tranformation API which allow to animate different series:

### Animation Types
There are several animation types provided out of the box in SciChart:
- [Fade-In](#fade-in-animation)
- [Scale](#scale-animation)
- [Sweep](#sweep-animation)
- [Wave](#wave-animation)
- [Translate-X](#translate-x-animation)
- [Translate-Y](#translate-y-animation)

# [Java](#tab/java)
[!code-java[AnimateLineSeries](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/series2d/AnimationsAPI.java#AnimateLineSeries)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[AnimateLineSeries](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/series2d/AnimationsAPI.java#AnimateLineSeries)]
# [Kotlin](#tab/kotlin)
[!code-swift[AnimateLineSeries](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/series2d/AnimationsAPI.kt#AnimateLineSeries)]
***

#### Fade-In Animation

# [Java](#tab/java)
[!code-java[FadeInAnimation](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/series2d/AnimationsAPI.java#FadeInAnimation)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[FadeInAnimation](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/series2d/AnimationsAPI.java#FadeInAnimation)]
# [Kotlin](#tab/kotlin)
[!code-swift[FadeInAnimation](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/series2d/AnimationsAPI.kt#FadeInAnimation)]
***

> [!NOTE]
> The **Fade-In** animation is implemented utilizing the [opacity](xref:com.scichart.charting.visuals.renderableSeries.IRenderableSeriesCore.setOpacity(float)) property under the hood.

<video autoplay loop muted playsinline src="../2dChartTypes/images/fade-in-animation.mp4"></video>

> [!NOTE]
> Examples which uses **Fade-In** animation can be found in the [SciChart Android Examples Suite](https://www.scichart.com/examples/android-chart/) as well as on [GitHub](https://github.com/ABTSoftware/SciChart.Android.Examples):
> - [Native Example](https://www.scichart.com/example/android-chart-example-using-pointmarkers/)

#### Scale Animation
# [Java](#tab/java)
[!code-java[ScaleAnimation](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/series2d/AnimationsAPI.java#ScaleAnimation)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[ScaleAnimation](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/series2d/AnimationsAPI.java#ScaleAnimation)]
# [Kotlin](#tab/kotlin)
[!code-swift[ScaleAnimation](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/series2d/AnimationsAPI.kt#ScaleAnimation)]
***

> [!NOTE]
> The **Scale** animation is implemented utilizing the [Scale Transformation](#scale-transformation) under the hood.

<video autoplay loop muted playsinline src="../2dChartTypes/images/scale-animation.mp4"></video>

> [!NOTE]
> Examples which uses **Scale** animation can be found in the [SciChart Android Examples Suite](https://www.scichart.com/examples/android-chart/) as well as on [GitHub](https://github.com/ABTSoftware/SciChart.Android.Examples):
> - [Native Example](https://www.scichart.com/example/android-chart-example-band-series-chart/)
> - [Xamarin Example](https://www.scichart.com/example/xamarin-chart-band-chart-example/)

#### Sweep Animation
# [Java](#tab/java)
[!code-java[SweepAnimation](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/series2d/AnimationsAPI.java#SweepAnimation)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[SweepAnimation](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/series2d/AnimationsAPI.java#SweepAnimation)]
# [Kotlin](#tab/kotlin)
[!code-swift[SweepAnimation](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/series2d/AnimationsAPI.kt#SweepAnimation)]
***

> [!NOTE]
> The **Sweep** animation is implemented utilizing the [Sweep Transformation](#sweep-transformation) under the hood and available only for continuous series (e.g. [Line](xref:chart2d.renderableSeries.LineSeries), [Mountain](xref:chart2d.renderableSeries.MountainSeries), [Band](xref:chart2d.renderableSeries.BandSeries) etc...), where it's possible to interpolate points to have smooth animation.

<video autoplay loop muted playsinline src="../2dChartTypes/images/sweep-animation.mp4"></video>

> [!NOTE]
> Examples which uses **Sweep** animation can be found in the [SciChart Android Examples Suite](https://www.scichart.com/examples/android-chart/) as well as on [GitHub](https://github.com/ABTSoftware/SciChart.Android.Examples):
> - [Native Example](https://www.scichart.com/example/android-mountain-chart-example/)
> - [Xamarin Example](https://www.scichart.com/example/xamarin-chart-mountain-chart-example/)

#### Wave Animation

# [Java](#tab/java)
[!code-java[WaveAnimation](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/series2d/AnimationsAPI.java#WaveAnimation)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[WaveAnimation](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/series2d/AnimationsAPI.java#WaveAnimation)]
# [Kotlin](#tab/kotlin)
[!code-swift[WaveAnimation](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/series2d/AnimationsAPI.kt#WaveAnimation)]
***

> [!NOTE]
> The **Wave** animation is implemented utilizing the [Wave Transformation](#wave-transformation) under the hood.

<video autoplay loop muted playsinline src="../2dChartTypes/images/wave-animation.mp4"></video>

> [!NOTE]
> Examples which uses **Wave** animation can be found in the [SciChart Android Examples Suite](https://www.scichart.com/examples/android-chart/) as well as on [GitHub](https://github.com/ABTSoftware/SciChart.Android.Examples):
> - [Native Example](https://www.scichart.com/example/android-column-chart-example/)

#### Translate-X Animation
# [Java](#tab/java)
[!code-java[TranslateXAnimation](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/series2d/AnimationsAPI.java#TranslateXAnimation)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[TranslateXAnimation](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/series2d/AnimationsAPI.java#TranslateXAnimation)]
# [Kotlin](#tab/kotlin)
[!code-swift[TranslateXAnimation](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/series2d/AnimationsAPI.kt#TranslateXAnimation)]
***

> [!NOTE]
> The **Translate-X** animation is implemented utilizing the [Translate Transformation](#translate-transformation) under the hood.

<video autoplay loop muted playsinline src="../2dChartTypes/images/translate-x-animation.mp4"></video>

#### Translate-Y Animation
# [Java](#tab/java)
[!code-java[TranslateYAnimation](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/series2d/AnimationsAPI.java#TranslateYAnimation)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[TranslateYAnimation](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/series2d/AnimationsAPI.java#TranslateYAnimation)]
# [Kotlin](#tab/kotlin)
[!code-swift[TranslateYAnimation](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/series2d/AnimationsAPI.kt#TranslateYAnimation)]
***

> [!NOTE]
> The **Translate-Y** animation is implemented utilizing the [Translate Transformation](#translate-transformation) under the hood.

<video autoplay loop muted playsinline src="../2dChartTypes/images/translate-y-animation.mp4"></video>

## Transformation API
The Animations API is based on Tranformation API which allows to define different tranformations for <xref:com.scichart.charting.visuals.renderableSeries.IRenderableSeries> which we apply during animation. When we start Animator created by Builders API or using AnimationsHelper directly it animates Progress of tranformation from 0 ( begining of animation ) to 1 ( end of animation ).

There are several transformations provided out of the box which allow to animate different types of series:
- [Scale](#scale-transformation)
- [Sweep](#sweep-transformation)
- [Wave](#wave-transformation)
- [Translate-X](#translate-transformation)
- [Translate-Y](#translate-transformation)
- [Composite](#composite-transformation)

#### Scale Transformation
Scale transformation is represented by the <xref:com.scichart.charting.visuals.animations.ScaleTransformationBase> and its implementors:

| **Transformation Type**           | **Applicable to:**                               |
| --------------------------------- | ------------------------------------------------ |
| <xref:com.scichart.charting.visuals.animations.ScaleXyTransformation>        | <xref:com.scichart.charting.visuals.renderableSeries.data.XyRenderPassData> and inheritors.            |
| <xref:com.scichart.charting.visuals.animations.ScaleXyyTransformation>       | <xref:com.scichart.charting.visuals.renderableSeries.data.XyyRenderPassData> and inheritors.           |
| <xref:com.scichart.charting.visuals.animations.ScaleXyzTransformation>       | <xref:com.scichart.charting.visuals.renderableSeries.data.XyzRenderPassData> and inheritors.           |
| <xref:com.scichart.charting.visuals.animations.ScaleHlTransformation>        | <xref:com.scichart.charting.visuals.renderableSeries.data.HlRenderPassData> and inheritors.            |
| <xref:com.scichart.charting.visuals.animations.ScaleOhlcTransformation>      | <xref:com.scichart.charting.visuals.renderableSeries.data.OhlcRenderPassData> and inheritors.          |
| <xref:com.scichart.charting.visuals.animations.ScaleStackedXyTransformation> | <xref:com.scichart.charting.visuals.renderableSeries.data.StackedSeriesRenderPassData> and inheritors. |

> [!NOTE]
> The [Scale Animation](#scale-animation) is implemented based on this transformation.

#### Sweep Transformation
Sweep transformation is represented by the <xref:com.scichart.charting.visuals.animations.SweepXyTransformation> and <xref:com.scichart.charting.visuals.animations.SweepXyyTransformation> which allows to transform <xref:com.scichart.charting.visuals.renderableSeries.data.XyRenderPassData> and <xref:com.scichart.charting.visuals.renderableSeries.data.XyyRenderPassData> respectively.

> [!NOTE]
> The [Sweep Animation](#sweep-animation) is implemented base on this transformation.

#### Wave Transformation
Wave transformation is represented by the <xref:com.scichart.charting.visuals.animations.WaveTransformationBase> and its implementors:

| **Transformation Type**          | **Applicable to:**                               |
| -------------------------------- | ------------------------------------------------ |
| <xref:com.scichart.charting.visuals.animations.WaveXyTransformation>        | <xref:com.scichart.charting.visuals.renderableSeries.data.XyRenderPassData> and inheritors.            |
| <xref:com.scichart.charting.visuals.animations.WaveXyyTransformation>       | <xref:com.scichart.charting.visuals.renderableSeries.data.XyyRenderPassData> and inheritors.           |
| <xref:com.scichart.charting.visuals.animations.WaveHlTransformation>        | <xref:com.scichart.charting.visuals.renderableSeries.data.HlRenderPassData> and inheritors.            |
| <xref:com.scichart.charting.visuals.animations.WaveOhlcTransformation>      | <xref:com.scichart.charting.visuals.renderableSeries.data.OhlcRenderPassData> and inheritors.          |
| <xref:com.scichart.charting.visuals.animations.WaveStackedXyTransformation> | <xref:com.scichart.charting.visuals.renderableSeries.data.StackedSeriesRenderPassData> and inheritors. |

> [!NOTE]
> The [Wave Animation](#wave-animation) is implemented based on this transformation.

#### Translate Transformation
Wave transformation is represented by the <xref:com.scichart.charting.visuals.animations.TranslateXTransformation> as well as <xref:com.scichart.charting.visuals.animations.TranslateXyTransformationBase> and its implementors:

| **Transformation Type**               | **Applicable to:**                               |
| ------------------------------------- | ------------------------------------------------ |
| <xref:com.scichart.charting.visuals.animations.TranslateXTransformation>         | <xref:com.scichart.charting.visuals.renderableSeries.data.XSeriesRenderPassData> and inheritors.       |
| <xref:com.scichart.charting.visuals.animations.TranslateXyTransformation>        | <xref:com.scichart.charting.visuals.renderableSeries.data.XyRenderPassData> and inheritors.            |
| <xref:com.scichart.charting.visuals.animations.TranslateXyyTransformation>       | <xref:com.scichart.charting.visuals.renderableSeries.data.XyyRenderPassData> and inheritors.           |
| <xref:com.scichart.charting.visuals.animations.TranslateHlTransformation>        | <xref:com.scichart.charting.visuals.renderableSeries.data.HlRenderPassData> and inheritors.            |
| <xref:com.scichart.charting.visuals.animations.TranslateOhlcTransformation>      | <xref:com.scichart.charting.visuals.renderableSeries.data.OhlcRenderPassData> and inheritors.          |
| <xref:com.scichart.charting.visuals.animations.TranslateStackedXyTransformation> | <xref:com.scichart.charting.visuals.renderableSeries.data.StackedSeriesRenderPassData> and inheritors. |

> [!NOTE]
> [Translate-X](#translate-x-animation) and [Translate-Y](#translate-y-animation) animations are implemented based on this transformation.

#### Composite Transformation
You might want to combine effects of several transformations at the same time without rewriting those into complex transformation. The <xref:com.scichart.charting.visuals.animations.CompositeTransformation> is in SciChart to do just that. It allows to aggregate effects into one transformation (e.g. wave and translate-x)

Let's try to use [Wave](#wave-transformation) and [Translate-X](#translate-transformation) at the same time, to animate [Candlestick Series](xref:chart2d.renderableSeries.CandlestickSeries) based on the **Candlestick Chart** example which can be found in the [SciChart Android Examples Suite](https://www.scichart.com/examples/android-chart/) as well as on [GitHub](https://github.com/ABTSoftware/SciChart.Android.Examples):
- [Native Example](https://www.scichart.com/example/android-candlestick-chart-example/)
- [Xamarin Example](https://www.scichart.com/example/xamarin-chart-candlestick-chart-example/)

# [Java](#tab/java)
[!code-java[CompositeTransformation](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/series2d/AnimationsAPI.java#CompositeTransformation)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[CompositeTransformation](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/series2d/AnimationsAPI.java#CompositeTransformation)]
# [Kotlin](#tab/kotlin)
[!code-swift[CompositeTransformation](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/series2d/AnimationsAPI.kt#CompositeTransformation)]
***

which results in the following:

<video autoplay loop muted playsinline src="../2dChartTypes/images/composite-transformation-candlestick-example.mp4"></video>

## Custom Animation
To create **custom animation** we need to create a class which implements <xref:com.scichart.charting.visuals.renderableSeries.transformation.IRenderPassDataTransformation> protocol. Inside we need to add code which modifies the render pass data of the **RenderableSeries** which we need **to animate**. For example, we'll try to animate line series and create **_expand_** effect which moves points from some predefined origin point.

First we need to create a transformation for our <xref:com.scichart.charting.visuals.renderableSeries.data.XyRenderPassData>:

# [Java](#tab/java)
[!code-java[CreateCustomAnimation](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/series2d/AnimationsAPI.java#CreateCustomAnimation)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[CreateCustomAnimation](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/series2d/AnimationsAPI.java#CreateCustomAnimation)]
# [Kotlin](#tab/kotlin)
[!code-swift[CreateCustomAnimation](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/series2d/AnimationsAPI.kt#CreateCustomAnimation)]
***

Then we use this **custom transformation** to animate series using <xref:com.scichart.charting.visuals.animations.AnimationsHelper> APIs:

# [Java](#tab/java)
[!code-java[UseCustomAnimation](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/series2d/AnimationsAPI.java#UseCustomAnimation)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[UseCustomAnimation](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/series2d/AnimationsAPI.java#UseCustomAnimation)]
# [Kotlin](#tab/kotlin)
[!code-swift[UseCustomAnimation](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/series2d/AnimationsAPI.kt#UseCustomAnimation)]
***

The result is the following:

<video autoplay loop muted playsinline src="../2dChartTypes/images/custom-animation-example.mp4"></video>
