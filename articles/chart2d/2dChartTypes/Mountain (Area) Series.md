---
uid: "chart2d.renderableSeries.MountainSeries"
---

# The Mountain (Area) Series Type
**Mountain (Area) Series** can be created using the <xref:com.scichart.charting.visuals.renderableSeries.FastMountainRenderableSeries> type.

![Mountain Series Type](images/mountain-chart-example.png)

> [!NOTE] 
> Examples of the **Mountain Series** can be found in the [SciChart Android Examples Suite](https://www.scichart.com/examples/android-chart/) as well as on [GitHub](https://github.com/ABTSoftware/SciChart.Android.Examples):
> - [Native Example](https://www.scichart.com/example/android-mountain-chart-example/)
> - [Xamarin Example](https://www.scichart.com/example/xamarin-chart-mountain-chart-example/)

The <xref:com.scichart.charting.visuals.renderableSeries.FastMountainRenderableSeries> class allows to specify **Stroke** pen and **Area** brush. Those values can be assigned through the corresponding properties - [strokeStyle](xref:com.scichart.charting.visuals.renderableSeries.BaseRenderableSeries.setStrokeStyle(com.scichart.drawing.common.PenStyle)) and [areaStyle](xref:com.scichart.charting.visuals.renderableSeries.BaseMountainRenderableSeries.setAreaStyle(com.scichart.drawing.common.BrushStyle)) accordingly.

> [!NOTE] 
> To learn more about **Pens** and **Brushes** and how to utilize them, please refer to the [PenStyle, BrushStyle and FontStyle](xref:stylingAndTheming.PenStyleBrushStyleAndFontStyle) article.

It is possible to define the **ZeroLineY** baseline position for a Mountain Series via the [zeroLineY](xref:com.scichart.charting.visuals.renderableSeries.BaseRenderableSeries.setZeroLineY(double)) property. All data points that have Y value less than **ZeroLineY** will appear downward, else - upward.

> [!NOTE] 
> In multi axis scenarios, a series has to be assigned to a **particular X and Y axes**. This can be done by passing the axes IDs to the [xAxisId](xref:com.scichart.charting.visuals.renderableSeries.IRenderableSeries.setXAxisId(java.lang.String)), [yAxisId](xref:com.scichart.charting.visuals.renderableSeries.IRenderableSeries.setYAxisId(java.lang.String)) properties.

### Digital (Step) Mountain Series
In addition to the above, <xref:com.scichart.charting.visuals.renderableSeries.FastMountainRenderableSeries> can be configured to draw as **Digital (Step) Mountain**. It is achieved via the 
[isDigitalLine](xref:com.scichart.charting.visuals.renderableSeries.FastMountainRenderableSeries.setIsDigitalLine(boolean)) property.

![Digital Mountain Series Type](images/digital-mountain-chart-example.png)

## Create a Mountain Series
To create a **Mountain Series**, use the following code:

# [Java](#tab/java)
[!code-java[MountainSeries](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/series2d/MountainSeries2D.java#Example)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[MountainSeries](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/series2d/MountainSeries2D.java#Example)]
# [Kotlin](#tab/kotlin)
[!code-swift[MountainSeries](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/series2d/BandSeries2D.kt#Example)]
***

## Mountain Series Features
Mountain Series also has some features similar to other series, such as:
- [Render a Gap](#render-a-gap-in-a-mountain-series)
- [Draw Point Markers](#add-point-markers-onto-a-mountain-series)
- [Draw Series with Different Colors](#paint-area-parts-with-different-colors)

#### Render a Gap in a Mountain Series
It's possible to render a Gap in **Mountain series**, by passing a data point with a `NaN` as the Y value. Please refer to the [RenderableSeries APIs](xref:chart2d.2DChartTypes#adding-a-gap-onto-a-renderableseries) article for more details. The <xref:com.scichart.charting.visuals.renderableSeries.FastMountainRenderableSeries>, itself, allows to specify how a gap would appear. You can treat `NAN` values as a **gap** or a **close the line**. That appearance is defined by the [drawNaNAs](xref:com.scichart.charting.visuals.renderableSeries.BaseRenderableSeries.setDrawNaNAs(com.scichart.charting.visuals.renderableSeries.LineDrawMode)) property (Please see <xref:com.scichart.charting.visuals.renderableSeries.LineDrawMode> enumeration).

#### Add Point Markers onto a Mountain Series
Every data point of a **Mountain Series** can be marked with a <xref:com.scichart.charting.visuals.pointmarkers.IPointMarker>. To add Point Markers to a **Mountain Series** use the [pointMarker](xref:com.scichart.charting.visuals.renderableSeries.IRenderableSeries.setPointMarker(com.scichart.charting.visuals.pointmarkers.IPointMarker)) property. For more information and code examples, please refer to the [PointMarkers API](xref:chart2d.PointMarkerAPI) article.

#### Paint Area Parts with Different Colors
In SciChart, you can draw Area Parts of the **Mountain Series** with different colors using the [PaletteProvider API](xref:chart2d.PaletteProviderAPI). 
To Use palette provider for Mountain Area - a custom <xref:com.scichart.charting.visuals.renderableSeries.paletteProviders.IFillPaletteProvider> (or <xref:com.scichart.charting.visuals.renderableSeries.paletteProviders.IStrokePaletteProvider>) has to be provided to the [paletteProvider](xref:com.scichart.charting.visuals.renderableSeries.IRenderableSeries.setPaletteProvider(com.scichart.charting.visuals.renderableSeries.paletteProviders.IPaletteProvider)) property. Please refer to the [PaletteProvider API](xref:chart2d.PaletteProviderAPI) article for more info.
