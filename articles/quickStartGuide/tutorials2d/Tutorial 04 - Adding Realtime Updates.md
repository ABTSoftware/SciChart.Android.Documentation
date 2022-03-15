---
uid: "tutorials2d.SciChartAndroidTutorial-AddingRealtimeUpdates"
---

# SciChart Android Tutorial - Adding Realtime Updates
In the previous tutorials we've showed how to [Create a Simple Chart](xref:tutorials2d.SciChartAndroidTutorial-CreateSimple2DChart), add some [Zoom and Pan](xref:tutorials2d.SciChartAndroidTutorial-ZoomingAndPanningBehavior) interaction as well as [Tooltips Inspection](xref:tutorials2d.SciChartAndroidTutorial-TooltipsAndLegends) + [Legends](xref:chartModifierAPIs.LegendModifier) via the [Chart Modifiers API](xref:chartModifierAPIs.ChartModifierAPIs).

In this SciChart Android tutorial we're going to go a little further and show how to **update data** displayed by a chart in **real-time**.

## Getting Started
This tutorial is suitable for **Java** and **Kotlin**.

> [!NOTE]
> Source code for this tutorial can be found at our Github Repository: [!include[Java and Kotlin Tutorials Repository](JavaKotlinTutorialsLink.md)]

Assuming you have completed the [previous](xref:tutorials2d.SciChartAndroidTutorial-TooltipsAndLegends) tutorial, we will now make some changes to update the data dynamically.

## Updating Data Values
In our <xref:com.scichart.charting.model.dataSeries.IDataSeries>, we have some static data so far. Let's update them in ***real-time*** now.

We are going to add a Timer and schedule updating the data on timer tick.
To update data in a **DataSeries**, we will need to call one of the available `Update` methods on that DataSeries.
Since we are using <xref:com.scichart.charting.model.dataSeries.XyDataSeries>, we are going to use the <xref:com.scichart.charting.model.dataSeries.IXyDataSeries.updateXyAt(int,TX,TY)> method.

More information about Updating DataSeries can be found in the [Manipulating DataSeries Data](xref:chart2d.DataSeriesAPIs#manipulating-dataseries-data) article. 

But first of all, we need to adjust some previously created code and save DataSeries instances to be able update them later.
And since we are going to change a DataSeries setup, it worth mentioning that the code from the previous tutorials works, but it wasn't very efficient:
- Calling any of the [Update methods](xref:chart2d.DataSeriesAPIs#append-insert-update-remove) triggers a chart update, which redraws the entire chart.
- The values are passed in as [Number](https://docs.oracle.com/javase/8/docs/api/java/lang/Number.html) objects, which require ***boxing/unboxing***, which slows down the process as well

No worries, in SciChart there is an easy way to improve that:
- Make sure to always ***Append*** or ***Update*** data in a DataSeries in **batches** instead of one at a time.
- Suspend updates on a <xref:com.scichart.charting.visuals.SciChartSurface> using <xref:com.scichart.core.framework.UpdateSuspender.using(com.scichart.core.framework.ISuspendable,java.lang.Runnable)> to prevent redrawing until you have updated the whole DataSeries.
- Use one of the <xref:com.scichart.core.model.IValues> implementation such as <xref:com.scichart.core.model.DoubleValues>. It stores data in an ***primitive array internally*** and doesn't requires ***boxing/unboxing***.

So we updated the code as follows:

# [Java](#tab/java)
[!code-java[DataSeriesSetup](../../../samples/tutorials-native/tutorials-2d/tutorial-4/java/src/main/java/com/scichart/tutorial/MainActivity.java#DataSeriesSetup)]
// ...
[!code-java[InitialDataSetup](../../../samples/tutorials-native/tutorials-2d/tutorial-4/java/src/main/java/com/scichart/tutorial/MainActivity.java#InitialDataSetup)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[DataSeriesSetup](../../../samples/tutorials-native/tutorials-2d/tutorial-4/javaBuilder/src/main/java/com/scichart/tutorial/MainActivity.java#DataSeriesSetup)]
// ...
[!code-java[InitialDataSetup](../../../samples/tutorials-native/tutorials-2d/tutorial-4/javaBuilder/src/main/java/com/scichart/tutorial/MainActivity.java#InitialDataSetup)]
# [Kotlin](#tab/kotlin)
[!code-swift[DataSeriesSetup](../../../samples/tutorials-native/tutorials-2d/tutorial-4/kotlin/src/main/java/com/scichart/tutorial/MainActivity.kt#DataSeriesSetup)]
// ...
[!code-swift[InitialDataSetup](../../../samples/tutorials-native/tutorials-2d/tutorial-4/kotlin/src/main/java/com/scichart/tutorial/MainActivity.kt#InitialDataSetup)]
# [Xamarin.Android](#tab/xamarin)
[!code-cs[DataSeriesSetup](../../../samples/tutorials-xamarin/tutorials-2d/tutorial-04/MainActivity.cs#DataSeriesSetup)]
// ...
[!code-cs[InitialDataSetup](../../../samples/tutorials-xamarin/tutorials-2d/tutorial-04/MainActivity.cs#InitialDataSetup)]
***

From here, we can initialize our Timer and create an `updateData` runnable, with real-time updates, like follows:

# [Java](#tab/java)
[!code-java[CreateTimer](../../../samples/tutorials-native/tutorials-2d/tutorial-4/java/src/main/java/com/scichart/tutorial/MainActivity.java#CreateTimer)]
// ...
[!code-java[UpdateData](../../../samples/tutorials-native/tutorials-2d/tutorial-4/java/src/main/java/com/scichart/tutorial/MainActivity.java#UpdateData)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[CreateTimer](../../../samples/tutorials-native/tutorials-2d/tutorial-4/javaBuilder/src/main/java/com/scichart/tutorial/MainActivity.java#CreateTimer)]
// ...
[!code-java[UpdateData](../../../samples/tutorials-native/tutorials-2d/tutorial-4/javaBuilder/src/main/java/com/scichart/tutorial/MainActivity.java#UpdateData)]
# [Kotlin](#tab/kotlin)
[!code-swift[CreateTimer](../../../samples/tutorials-native/tutorials-2d/tutorial-4/kotlin/src/main/java/com/scichart/tutorial/MainActivity.kt#CreateTimer)]
// ...
[!code-swift[UpdateData](../../../samples/tutorials-native/tutorials-2d/tutorial-4/kotlin/src/main/java/com/scichart/tutorial/MainActivity.kt#UpdateData)]
# [Xamarin.Android](#tab/xamarin)
[!code-cs[CreateTimer](../../../samples/tutorials-xamarin/tutorials-2d/tutorial-04/MainActivity.cs#CreateTimer)]
// ...
[!code-cs[UpdateData](../../../samples/tutorials-xamarin/tutorials-2d/tutorial-04/MainActivity.cs#UpdateData)]
***

Which will result in the following Chart:

> [!NOTE]
> Despite the chart is now real-time, it's still fully interactive, you can use modifiers from **[previous](xref:tutorials2d.SciChartAndroidTutorial-TooltipsAndLegends)** tutorials with ease.

<video autoplay loop muted playsinline src="images/tutorials-2d-realtime-update.mp4"></video>

## Adding New Data Values
As well as using <xref:com.scichart.charting.model.dataSeries.IXyDataSeries.updateXyAt(int,TX,TY)>, you can also use <xref:com.scichart.charting.model.dataSeries.IXyDataSeries.append(TX,TY)> (or any other available **Append** method) to add new **data-values** to a DataSeries.

The code from above can be updated as follows to **append** new data constantly to the dataSeries:

# [Java](#tab/java)
[!code-java[AppendData](../../../samples/tutorials-native/tutorials-2d/tutorial-4/java/src/main/java/com/scichart/tutorial/MainActivity.java#AppendData)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[AppendData](../../../samples/tutorials-native/tutorials-2d/tutorial-4/javaBuilder/src/main/java/com/scichart/tutorial/MainActivity.java#AppendData)]
# [Kotlin](#tab/kotlin)
[!code-swift[AppendData](../../../samples/tutorials-native/tutorials-2d/tutorial-4/kotlin/src/main/java/com/scichart/tutorial/MainActivity.kt#AppendData)]
# [Xamarin.Android](#tab/xamarin)
[!code-cs[AppendData](../../../samples/tutorials-xamarin/tutorials-2d/tutorial-04/MainActivity.cs#AppendData)]
***

<video autoplay loop muted playsinline src="images/tutorials-2d-realtime-append.mp4"></video>

## Scrolling Realtime Charts
What if you wanted to **scroll** as new data was appended? You have a few choices.
- If you want to be memory efficient, and you don't mind if you **discard** old data, you can use our **FIFO** (first-in-first-out) functionality.
- If you want to **preserve** old data, you can simply update the [visibleRange](xref:com.scichart.charting.visuals.axes.IAxisCore.getVisibleRange()). 

Since updating **VisibleRange** is fairly self-explanatory, we are going to explain the **FIFO** method.

#### Discarding Data when Scrolling using FifoCapacity
The most **memory efficient** way to achieve scrolling is to use [fifoCapacity](xref:com.scichart.charting.model.dataSeries.IDataSeries.setFifoCapacity(java.lang.Integer)) to set the maximum size of a DataSeries before old points are ***discarded***.
DataSeries in FIFO mode act as a circular - ***first-in-first-out*** - buffer. Once the capacity is exceeded, old points are discarded.
You cannot zoom back to see the old points, **once they are lost, they are lost**.

To make a **DataSeries** use the FIFO buffer, all you need to do is just set fifo capacity on the DataSeries, e.g.:

# [Java](#tab/java)
[!code-java[SetFifoCapacity](../../../samples/tutorials-native/tutorials-2d/tutorial-4/java/src/main/java/com/scichart/tutorial/MainActivity.java#SetFifoCapacity)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[SetFifoCapacity](../../../samples/tutorials-native/tutorials-2d/tutorial-4/javaBuilder/src/main/java/com/scichart/tutorial/MainActivity.java#SetFifoCapacity)]
# [Kotlin](#tab/kotlin)
[!code-swift[SetFifoCapacity](../../../samples/tutorials-native/tutorials-2d/tutorial-4/kotlin/src/main/java/com/scichart/tutorial/MainActivity.kt#SetFifoCapacity)]
# [Xamarin.Android](#tab/xamarin)
[!code-cs[SetFifoCapacity](../../../samples/tutorials-xamarin/tutorials-2d/tutorial-04/MainActivity.cs#SetFifoCapacity)]
***

> [!NOTE]
> After appending new data we call `zoomExtents` to make series to fit the viewport.

The following should be the result when you run the application:

<video autoplay loop muted playsinline src="images/tutorials-2d-realtime-fifo.mp4"></video>

## Where to Go From Here?
You can download the final project from our [!include[Java and Kotlin Tutorials Repository](JavaKotlinTutorialsLink.md)].

Also, you can found **next tutorial** from this series here - [SciChart Android Tutorial - Annotations](xref:tutorials2d.SciChartAndroidTutorial-Annotations)

Of course, this is not the limit of what you can achieve with the SciChart Android.
Our documentation contains lots of useful information, some of the articles you might want to read are listed below:
- [Axis Types](xref:axis.AxisAPIs)
- [2D Chart Types](xref:chart2d.2DChartTypes)
- [Chart Modifiers](xref:chartModifierAPIs.ChartModifierAPIs)

Finally, start exploring. The SciChart Android library and functionality is quite extensive. 
You can look into our [SciChart Android Examples Suite](https://www.scichart.com/examples/android-chart/) which are full of 2D and 3D examples, which are also available on our [GitHub](https://github.com/ABTSoftware/SciChart.Android.Examples)

In particular, you might want to take a look at our [Fifo Scrolling Chart](https://www.scichart.com/example/android-realtime-scrolling-charts-example/):

<video autoplay loop muted playsinline src="images/fifo-scrolling-chart-example.mp4"></video>
