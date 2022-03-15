---
uid: "chart2d.DataResampling"
---

# What is Data Resampling and how does it work?
By default, SciChart uses **resampling (culling)** of data to ensure the minimum viable data-set is displayed on the screen. Resampling is intended to be **lossless, and automatic**. It occurs for every [RenderableSeries](xref:chart2d.2DChartTypes) before the series is rendered, if required.

Resampling methods make assumptions about the data in order to produce a valid output. SciChart provides variety of the <xref:com.scichart.data.numerics.ResamplingMode>, and auto detects the most suitable one. 

However, there are cases when data input **cannot be resampled accurately**. Good examples could be plotting unsorted data or using logarithmic scale on an axis. We recommend using <xref:com.scichart.data.numerics.ResamplingMode.None> in such situations, which in other word means **switching Resampling off**.

> [!NOTE]
> Please be aware that if you disable resampling you will experience a degradation in performance.

## Resampling Modes
There are several <xref:com.scichart.data.numerics.ResamplingMode> available in SciChart:

| **Resampling Modes**                                                     | **Description**                                                                                                                                       |
| ------------------------------------------------------------------------ | ----------------------------------------------------------------------------------------------------------------------------------------------------- |
| <xref:com.scichart.data.numerics.ResamplingMode.None>                    | **switches off** Resampling on a <xref:com.scichart.charting.visuals.renderableSeries.IRenderableSeries>.                                             |
| <xref:com.scichart.data.numerics.ResamplingMode.MinMax>                  | suitable for evenly-spaced data. Resamples by taking **the min-max** of oversampled data.                                                             |
| <xref:com.scichart.data.numerics.ResamplingMode.Min>                     | suitable for evenly-spaced data. Resamples by taking the **minimum point** of oversampled data.                                                       |
| <xref:com.scichart.data.numerics.ResamplingMode.Max>                     | suitable for evenly-spaced data. Resamples by taking the **maximum point** of oversampled data.                                                       |
| <xref:com.scichart.data.numerics.ResamplingMode.Mid>                     | suitable for evenly-spaced data. Resamples by taking the **median point** of oversampled data.                                                        |
| <xref:com.scichart.data.numerics.ResamplingMode.Auto>                    | This is the **default** mode. It auto-detects the most suitable resampling algorithm - **fastest and most accurate** - for the type of data appended. |
| <xref:com.scichart.data.numerics.ResamplingMode.Cluster2D>               | Groups close points in 2D space                                                                                                                       | 
| <xref:com.scichart.data.numerics.ResamplingMode.MinMaxWithUnevenSpacing> | not suitable for evenly-spaced data. Resamples by taking **the min-max** of oversampled data.                                                         | 

## Setting Resampling Mode
Most of the time, you don't need to set <xref:com.scichart.data.numerics.ResamplingMode> manually. SciChart auto detects the best one for a given data and uses it internally. However, when it is necessary, the **ResamplingMode** can be set explicitly via the [resamplingMode](xref:com.scichart.charting.visuals.renderableSeries.IRenderableSeries.setResamplingMode(com.scichart.data.numerics.ResamplingMode)) property:

# [Java](#tab/java)
[!code-java[SettingResamplingMode](../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/series2d/DataResampling.java#SettingResamplingMode)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[SettingResamplingMode](../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/series2d/DataResampling.java#SettingResamplingMode)]
# [Kotlin](#tab/kotlin)
[!code-swift[SettingResamplingMode](../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/series2d/DataResampling.kt#SettingResamplingMode)]
***

## Resampling Performance
Resampling makes drawing many millions of points possible with SciChart. For instance, in the [Performance Demo](https://www.scichart.com/example/android-chart-realtime-performance-demo/) example, we push 1000 points every 10ms to three series on a chart. The point count quickly rises to the millions of points, and SciChart is still rendering at interactive rates. Also, the example allows to play around with different <xref:com.scichart.data.numerics.ResamplingMode> and see their impact on performance.

In addition, we compared performance of the most popular Android charting packages with SciChart. The results can be found in the [Performance Comparison](https://www.scichart.com/android-chart-performance-comparison/) article.
