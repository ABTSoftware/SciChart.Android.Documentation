---
uid: "chart2d.renderableSeries.SplineLineSeries"
---

# The Spline Line Series Type
**Spline Line Series** can be created using the <xref:com.scichart.charting.visuals.renderableSeries.SplineLineRenderableSeries> type.

![Spline Line Series Type](images/spline-line-chart.png)

> [!NOTE] 
> Examples of the **Spline Line Series** can be found in the [SciChart Android Examples Suite](https://www.scichart.com/examples/android-chart/) as well as on [GitHub](https://github.com/ABTSoftware/SciChart.Android.Examples):
> - [Native Example](https://www.scichart.com/example/android-chart/android-spline-line-chart-example/)
> - [Xamarin Example](https://www.scichart.com/example/xamarin-chart/xamarin-spline-line-chart-example/)

## Create a Spline Line Series
To create a <xref:com.scichart.charting.visuals.renderableSeries.SplineLineRenderableSeries>, use the following code:

# [Java](#tab/java)
[!code-java[SplineLine](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/series2d/SplineLineSeries2D.java#Example)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[SplineLine](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/series2d/SplineLineSeries2D.java#Example)]
# [Kotlin](#tab/kotlin)
[!code-swift[SplineLine](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/series2d/SplineLineSeries2D.kt#Example)]
***

In the code above, a **Spline Line Series** instance is created. It is assigned to draw the data that is provided by the <xref:com.scichart.charting.model.dataSeries.IDataSeries> assigned to it. The line is drawn with a **Pen** provided by the <xref:com.scichart.drawing.common.PenStyle> instance. Finally, the **Spline Line Series** is added to the [renderableSeries](xref:com.scichart.charting.visuals.ISciChartSurface.getRenderableSeries()) property.

## Spline Line Series Features
Spline Line Series also has some features similar to other series, such as:
- [Render a Gap](#render-a-gap-in-a-spline-line-series)
- [Draw Point Markers](#add-point-markers-onto-a-spline-line-series)
- [Draw Series With Different Colors](#paint-spline-line-segments-with-different-colors)

#### Render a Gap in a Spline Line Series
It is possible to show a gap in a **Spline Line Series** by passing a data point with a `NaN` as the Y value. Please refer to the [RenderableSeries APIs](xref:chart2d.2DChartTypes#adding-a-gap-onto-a-renderableseries) article for more details. The <xref:com.scichart.charting.visuals.renderableSeries.SplineLineRenderableSeries>, however, allows to specify how a gap should appear. You can treat `NAN` values as **gaps** or close the line. That's defined by the [drawNaNAs](xref:com.scichart.charting.visuals.renderableSeries.BaseRenderableSeries.setDrawNaNAs(com.scichart.charting.visuals.renderableSeries.LineDrawMode)) property (Please see <xref:com.scichart.charting.visuals.renderableSeries.LineDrawMode> enumeration).

> [!NOTE] 
> Please note, even though Gaps via NaN values in spline series is supported, ClosedGaps feature, which is available in [regular (non-spline)](xref:chart2d.renderableSeries.LineSeries) series, aren't supported with splines.

#### Add Point Markers onto a Spline Line Series
Every data point of a **Spline Line Series** can be marked with a <xref:com.scichart.charting.visuals.pointmarkers.IPointMarker>. To add Point Markers to the Spline Line Series, use the following code:

![Point Markers](images/spline-point-markers-example.png)

# [Java](#tab/java)
[!code-java[SplineLineWithPointMarkers](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/series2d/SplineLineSeriesWithPointMarkers2D.java#Example)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[SplineLineWithPointMarkers](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/series2d/SplineLineSeriesWithPointMarkers2D.java#Example)]
# [Kotlin](#tab/kotlin)
[!code-swift[SplineLineWithPointMarkers](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/series2d/SplineLineSeriesWithPointMarkers2D.kt#Example)]
***

To learn more about **Point Markers**, please refer to the [PointMarkers API](xref:chart2d.PointMarkerAPI) article.

> [!NOTE] 
> This feature can be used to create a [Scatter Series](xref:chart2d.renderableSeries.ScatterSeries), if [strokeStyle](xref:com.scichart.charting.visuals.renderableSeries.BaseRenderableSeries.setStrokeStyle(com.scichart.drawing.common.PenStyle)) contains a **transparent Pen**.

#### Paint Spline Line Segments With Different Colors
In SciChart, you can draw line segments with different colors using the [PaletteProvider API](xref:chart2d.PaletteProviderAPI). 
To Use palette provider for **Spline Line Series** - a custom <xref:com.scichart.charting.visuals.renderableSeries.paletteProviders.IStrokePaletteProvider> has to be provided to the [paletteProvider](xref:com.scichart.charting.visuals.renderableSeries.IRenderableSeries.setPaletteProvider(com.scichart.charting.visuals.renderableSeries.paletteProviders.IPaletteProvider)) property. For more information - please refer to the [PaletteProvider API](xref:chart2d.PaletteProviderAPI) article.
