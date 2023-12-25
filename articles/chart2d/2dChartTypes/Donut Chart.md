---
uid: "chart2d.renderableSeries.DonutChart"
---

# The Donut Chart Type
In SciChart, the **Donut Chart** type is represented by the <xref:com.scichart.charting.visuals.SciPieChartSurface> class.

The <xref:com.scichart.charting.visuals.renderableSeries.DonutRenderableSeries> is very similar to the [Pie Chart](xref:chart2d.renderableSeries.PieChart), except it has a round hole in its center.
A <xref:com.scichart.charting.visuals.renderableSeries.PieSegment> represents a percentage that corresponds to a particular value. 
This value appears drawn on every segment and can be set in code. 

![Donut Chart Type](images/donut-chart.example.png)

> [!NOTE]
> Examples for the **Donut Chart** can be found in the [SciChart Android Examples Suite](https://www.scichart.com/examples/android-chart/) as well as on [GitHub](https://github.com/ABTSoftware/SciChart.Android.Examples):
> - [Native Example](https://www.scichart.com/example/android-chart/android-chart-donut-chart-example/)
> - [Xamarin Example](https://www.scichart.com/example/xamarin-chart/xamarin-chart-donut-chart-example/)

The <xref:com.scichart.charting.visuals.renderableSeries.PieSegment> allows you to specify different styles to control rendering of the segments, e.g.:
- [fillStyle](xref:com.scichart.charting.visuals.renderableSeries.IPieSegment.setFillStyle(com.scichart.drawing.common.BrushStyle))
- [strokeStyle](xref:com.scichart.charting.visuals.renderableSeries.IPieSegment.setStrokeStyle(com.scichart.drawing.common.PenStyle))
- [titleStyle](xref:com.scichart.charting.visuals.renderableSeries.IPieSegment.setTitleStyle(com.scichart.drawing.common.FontStyle))
- [selectedSegmentStyle](xref:com.scichart.charting.visuals.renderableSeries.IPieSegment.setSelectedSegmentStyle(com.scichart.charting.visuals.renderableSeries.IStyle))

> [!NOTE]
> To learn more about **Pens** and **Brushes** and how to utilize them, please refer to the [PenStyle, BrushStyle and FontStyle](xref:stylingAndTheming.PenStyleBrushStyleAndFontStyle) article.

Also, you can control whether to draw labels on segments or not via the [drawLabels](xref:com.scichart.charting.visuals.renderableSeries.PieDonutRenderableSeriesBase.setDrawLabels(boolean)) property.

## Create a Donut Chart
To create a **Donut Chart**, you have to provide a <xref:com.scichart.charting.model.PieRenderableSeriesCollection> and assign it to [renderableSeries](xref:com.scichart.charting.visuals.SciPieChartSurface.setRenderableSeries(com.scichart.charting.model.PieRenderableSeriesCollection)) property. 
The data source is a collection of objects that conforms to the <xref:com.scichart.charting.visuals.renderableSeries.IPieRenderableSeries> protocol, which contains a list of <xref:com.scichart.charting.visuals.renderableSeries.PieSegment> instances to draw. 

# [Java](#tab/java)
[!code-java[CreateDonutChart](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/series2d/DonutChart2D.java#CreateDonutChart)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[CreateDonutChart](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/series2d/DonutChart2D.java#CreateDonutChart)]
# [Kotlin](#tab/kotlin)
[!code-swift[CreateDonutChart](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/series2d/DonutChart2D.kt#CreateDonutChart)]
***

## Changing the size of the Donut Chart
If you want to change the size of the **Donut Chart** you can use a combination of the following properties:
- [height](xref:com.scichart.charting.visuals.renderableSeries.IPieRenderableSeries.setHeight(float))
- [heightSizingMode](xref:com.scichart.charting.visuals.renderableSeries.IPieRenderableSeries.setHeightSizingMode(com.scichart.charting.SizingMode))

The above allows you to specify how much space the **Donut Chart** should use for its rendering. 
If you use **Absolute** mode then [height](xref:com.scichart.charting.visuals.renderableSeries.IPieRenderableSeries.setHeight(float)) accepts size in pixels, and if you use **Relative** mode, it expects value from 0 to 1, which tells how much of the available space it should use for rendering (e.g. 0.5 will tell Donut series to use 50% of available space).

Also, you can control the center hole size via the [holeRadius](xref:com.scichart.charting.visuals.SciPieChartSurface.setHoleRadius(float)) property.

## SCIPieChartSurface Modifiers
The <xref:com.scichart.charting.visuals.SciPieChartSurface> supports modifiers like [Legend](#donut-chart-legend), [Selection](#donut-chart-selection), and [Tooltip](#donut-chart-tooltip).

![Donut Chart Modifiers](images/donut-chart-modifiers-example.png)

**Legend** and **Selection** modifiers are synced if both are added. A <xref:com.scichart.charting.visuals.renderableSeries.PieSegment> can be selected by clicking on either of them (via the [Selection Modifier](#donut-chart-selection)) or the corresponding item in the [Legend](#donut-chart-legend). 
This action provides visual feedback on the chart and the Legend.

#### Donut Chart Legend
To add the <xref:com.scichart.charting.modifiers.PieChartLegendModifier>, use the following code:

# [Java](#tab/java)
[!code-java[CreatePieChartLegend](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/series2d/PieChart2D.java#CreatePieChartLegend)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[CreatePieChartLegend](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/series2d/PieChart2D.java#CreatePieChartLegend)]
# [Kotlin](#tab/kotlin)
[!code-swift[CreatePieChartLegend](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/series2d/PieChart2D.kt#CreatePieChartLegend)]
***

> [!NOTE] 
> <xref:com.scichart.charting.modifiers.PieChartLegendModifier> works similar to <xref:com.scichart.charting.modifiers.LegendModifier> and has a similar API. To learn more, please visit the [LegendModifier usage](xref:chartModifierAPIs.LegendModifier) article.

#### Donut Chart Selection
To add the <xref:com.scichart.charting.modifiers.PieSegmentSelectionModifier> please use the following code:

# [Java](#tab/java)
[!code-java[AddPieChartSelection](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/series2d/PieChart2D.java#AddPieChartSelection)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[AddPieChartSelection](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/series2d/PieChart2D.java#AddPieChartSelection)]
# [Kotlin](#tab/kotlin)
[!code-swift[AddPieChartSelection](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/series2d/PieChart2D.kt#AddPieChartSelection)]
***

> [!NOTE] 
> <xref:com.scichart.charting.modifiers.PieSegmentSelectionModifier> works similar to <xref:com.scichart.charting.modifiers.SeriesSelectionModifier> and has a similar API. To learn more, please visit the [SeriesSelectionModifier usage](xref:chartModifierAPIs.InteractivitySeriesSelectionModifier) article.

#### Donut Chart Tooltip

The <xref:com.scichart.charting.modifiers.PieChartTooltipModifier> allows inspecting [segmentCollection](xref:com.scichart.charting.visuals.renderableSeries.PieDonutRenderableSeriesBase.getSegmentsCollection()) at a touch point. To add the <xref:com.scichart.charting.modifiers.PieChartTooltipModifier>, use the following code:

# [Java](#tab/java)
[!code-java[AddPieChartTooltip](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/series2d/PieChart2D.java#AddPieChartTooltip)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[AddPieChartTooltip](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/series2d/PieChart2D.java#AddPieChartTooltip)]
# [Kotlin](#tab/kotlin)
[!code-swift[AddPieChartTooltip](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/series2d/PieChart2D.kt#AddPieChartTooltip)]
***

> [!NOTE]
> <xref:com.scichart.charting.modifiers.PieChartTooltipModifier> works similar to <xref:com.scichart.charting.modifiers.TooltipModifier> and has a similar API. To learn more, please visit [TooltipModifier Usage](xref:chartModifierAPIs.InteractivityTooltipModifier) article.

## Pie Segment Label Formatter
By default, the Pie Segment Label displays a relative percentage calculated on values of all segments in [segmentCollection](xref:com.scichart.charting.visuals.renderableSeries.PieDonutRenderableSeriesBase.getSegmentsCollection()). This behavior can be controlled and to do so you’ll need to subclass <xref:com.scichart.charting.visuals.renderableSeries.PieSegmentLabelFormatterBase> and provide your custom data in <xref:com.scichart.charting.visuals.renderableSeries.IPieSegmentLabelFormatter.formatLabel(com.scichart.charting.visuals.renderableSeries.IPieSegment)> method. As an example, let's create a label that displays a segment absolute value. Assume, we create a donutSeries and add four segments with values 40, 10, 20, and 15. Here is the code sample, how to do this:

# [Java](#tab/java)
[!code-java[CreateCustomPieSegmentLabelFormatter](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/series2d/PieChart2D.java#CreateCustomPieSegmentLabelFormatter)]
[!code-java[UseCustomPieSegmentLabelFormatter](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/series2d/PieChart2D.java#UseCustomPieSegmentLabelFormatter)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[CreateCustomPieSegmentLabelFormatter](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/series2d/PieChart2D.java#CreateCustomPieSegmentLabelFormatter)]
[!code-java[UseCustomPieSegmentLabelFormatter](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/series2d/PieChart2D.java#UseCustomPieSegmentLabelFormatter)]
# [Kotlin](#tab/kotlin)
[!code-swift[CreateCustomPieSegmentLabelFormatter](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/series2d/PieChart2D.kt#CreateCustomPieSegmentLabelFormatter)]
[!code-swift[UseCustomPieSegmentLabelFormatter](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/series2d/PieChart2D.kt#UseCustomPieSegmentLabelFormatter)]
***

This produces the following output:

![Donut Series with custom label formatter](images/donut-chart-custom-formatter.png)

## Multi Pie Donut Chart
In SciChart you can have both [Pie Chart](xref:com.scichart.charting.visuals.renderableSeries.PieRenderableSeries) and [Donut Chart](xref:com.scichart.charting.visuals.renderableSeries.DonutRenderableSeries) placed inside the <xref:com.scichart.charting.visuals.SciPieChartSurface> at the same time.

![Multi Pie Donut](images/pie-donut-modifiers-example.png)

> [!NOTE] 
> Examples of the **Multi Pie Donut Chart** can be found in the [SciChart Android Examples Suite](https://www.scichart.com/examples/android-chart/) as well as on [GitHub](https://github.com/ABTSoftware/SciChart.Android.Examples).
> - [Native Example](https://www.scichart.com/example/android-chart/android-chart-nested-chart-example/)
> - [Xamarin Example](https://www.scichart.com/example/xamarin-chart/xamarin-chart-nested-pie-chart-example/)
