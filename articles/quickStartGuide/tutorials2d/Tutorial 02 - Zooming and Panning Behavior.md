---
uid: "tutorials2d.SciChartAndroidTutorial-ZoomingAndPanningBehavior"
---

# SciChart Android Tutorial - Zooming and Panning Behavior
So far, we have created a 2D chart, added X and Y Axes, asd well as [Line](xref:chart2d.renderableSeries.LineSeries) and [Scatter](xref:chart2d.renderableSeries.ScatterSeries) Series.

In this SciChart Android tutorial we're going to add some **interactivity** to a 2D chart, so at the end we should be able to **Zoom** and **Pan** a chart as well as Zooming the Chart to the Data Extents.

## Getting Started
This tutorial is suitable for **Java** and **Kotlin**.

> [!NOTE]
> Source code for this tutorial can be found at our Github Repository: [!include[Java and Kotlin Tutorials Repository](JavaKotlinTutorialsLink.md)]

First of all, make sure, you've read the [Tutorial 01 - Create a simple Chart 2D](xref:tutorials2d.SciChartAndroidTutorial-CreateSimple2DChart) and have a basic understanding of how to use SciChart.

Now, let's extend previous tutorial with some [Chart Modifiers](Chart Modifier APIs.html)

## ChartModifiers
In SciChart, chart interactions are defined by the [Chart Modifiers](xref:chartModifierAPIs.ChartModifierAPIs).
In addition to the SciChart modifiers available out of the box, you can write [custom modifiers](xref:chartModifierAPIs.CustomModifiersTheChartModifierBaseAPI) or extends existing ones.

Here is the list of modifiers available out of the box in SciChart:
- [ZoomExtentsModifier](xref:chartModifierAPIs.ZoomAndPanZoomExtentsModifier)
- [PinchZoomModifier](xref:chartModifierAPIs.ZoomAndPanPinchZoomModifier)
- [ZoomPanModifier](xref:chartModifierAPIs.ZoomAndPanZoomPanModifier)
- [XAxisDragModifier](xref:chartModifierAPIs.ZoomAndPanXAxisDragModifier)
- [YAxisDragModifier](xref:chartModifierAPIs.ZoomAndPanYAxisDragModifier)
- [SeriesSelectionModifier](xref:chartModifierAPIs.InteractivitySeriesSelectionModifier)
- [TooltipModifier](xref:chartModifierAPIs.InteractivityTooltipModifier)
- [RolloverModifier](xref:chartModifierAPIs.InteractivityRolloverModifier)
- [CursorModifier](xref:chartModifierAPIs.InteractivityCursorModifier)
- <xref:com.scichart.charting.modifiers.ModifierGroup>
- [LegendModifier](xref:chartModifierAPIs.LegendModifier)

## Adding Chart Modifiers
Now we are going to create and configure a couple of **modifiers** and add a set of them as modifier collection of the <xref:com.scichart.charting.visuals.SciChartSurface>:

# [Java](#tab/java)
[!code-java[AddModifiers](../../../samples/tutorials-native/tutorials-2d/tutorial-2/java/src/main/java/com/scichart/tutorial/MainActivity.java#AddModifiers)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[AddModifiers](../../../samples/tutorials-native/tutorials-2d/tutorial-2/javaBuilder/src/main/java/com/scichart/tutorial/MainActivity.java#AddModifiers)]
# [Kotlin](#tab/kotlin)
[!code-swift[AddModifiers](../../../samples/tutorials-native/tutorials-2d/tutorial-2/kotlin/src/main/java/com/scichart/tutorial/MainActivity.kt#AddModifiers)]
# [Xamarin.Android](#tab/xamarin)
[!code-cs[AddModifiers](../../../samples/tutorials-xamarin/tutorials-2d/tutorial-02/MainActivity.cs#AddModifiers)]
***

After running the application the chart should behave like below:

<video autoplay loop muted playsinline src="images/tutorials-2d-chart-modifiers.mp4"></video>

## Where to Go From Here?
You can download the final project from our [!include[Java and Kotlin Tutorials Repository](JavaKotlinTutorialsLink.md)].

Also, you can found **next tutorial** from this series here - [SciChart Android Tutorial - Tooltips and Legends](xref:tutorials2d.SciChartAndroidTutorial-TooltipsAndLegends)

Of course, this is not the maximum of what you can achieve with the SciChart Android.
You can find more information about modifiers which are used in this tutorial in the articles below:
- [Zoom Extents Modifier](xref:chartModifierAPIs.ZoomAndPanZoomExtentsModifier)
- [Pinch Zoom Modifier](xref:chartModifierAPIs.ZoomAndPanPinchZoomModifier)
- [Zoom Pan Modifier](xref:chartModifierAPIs.ZoomAndPanZoomPanModifier)

Also, you might want to read about Axes drag modifiers in the following articles:
- [X Axis Drag Modifier](xref:chartModifierAPIs.ZoomAndPanXAxisDragModifier)
- [Y Axis Drag Modifier](xref:chartModifierAPIs.ZoomAndPanYAxisDragModifier)

Finally, start exploring. The SciChart Android library and functionality is quite extensive. 
You can look into our [SciChart Android Examples Suite](https://www.scichart.com/examples/android-chart/) which are full of 2D and 3D examples, which are also available on our [GitHub](https://github.com/ABTSoftware/SciChart.Android.Examples)