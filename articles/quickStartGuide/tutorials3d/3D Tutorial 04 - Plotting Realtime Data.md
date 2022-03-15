---
uid: "tutorials3d.SciChartAndroidTutorial-PlottingRealtimeData"
---

# SciChart Android 3D Tutorial - Plotting Realtime Data

In Previous tutorials we've showed how to [Create a Simple 3D Chart](xref:tutorials3d.SciChartAndroidTutorial-CreateSimpleScatterChart3D) and add some [Zoom and Rotate](xref:tutorials3d.SciChartAndroidTutorial-ZoomingAndRotating) interaction as well as [3D Tooltips Inspection](xref:tutorials3d.SciChartAndroidTutorial-CursorsAndTooltips) via the [Chart Modifiers 3D API](xref:chartModifier3DAPIs.ChartModifier3DAPIs).

In this SciChart Android 3D tutorial we're going to go a little further and show how to **update data** displayed by 3D chart in **realtime**.

## Getting Started
This tutorial is suitable for **Java** and **Kotlin**.

> [!NOTE]
> Source code for this tutorial can be found at our Github Repository: [!include[Java and Kotlin Tutorials 3D Repository](JavaKotlinTutorials3DLink.md)]

Assuming you have completed previous tutorial, we will now make some changes to update the data dynamically.

## Updating Data Values
In our <xref:com.scichart.charting3d.model.dataSeries.IDataSeries3D>, we have some static data so far. Let's update them in ***real-time*** now.

We are going to add a Timer and schedule updating the data on timer tick.
To update data in a **3D DataSeries**, we have to call one of the available `Update` methods on that DataSeries.
Since we are using <xref:com.scichart.charting3d.model.dataSeries.xyz.XyzDataSeries3D>, we are going to use the <xref:com.scichart.charting.model.dataSeries.IXyzDataSeries.updateXyzAt(int,TX,TY,TZ)> method.

But first of all, we need to adjust some previously created code and save DataSeries instance and data used in private fields, which will affect initial setup of a DataSeries a bit:

# [Java](#tab/java)
[!code-java[DataSeriesSetup](../../../samples/tutorials-native/tutorials-3d/tutorial-4/java/src/main/java/com/scichart/tutorial/MainActivity.java#DataSeriesSetup)]
[!code-java[AppendDataSeries](../../../samples/tutorials-native/tutorials-3d/tutorial-4/java/src/main/java/com/scichart/tutorial/MainActivity.java#AppendDataSeries)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[DataSeriesSetup](../../../samples/tutorials-native/tutorials-3d/tutorial-4/javaBuilder/src/main/java/com/scichart/tutorial/MainActivity.java#DataSeriesSetup)]
[!code-java[AppendDataSeries](../../../samples/tutorials-native/tutorials-3d/tutorial-4/javaBuilder/src/main/java/com/scichart/tutorial/MainActivity.java#AppendDataSeries)]
# [Kotlin](#tab/kotlin)
[!code-swift[DataSeriesSetup](../../../samples/tutorials-native/tutorials-3d/tutorial-4/kotlin/src/main/java/com/scichart/tutorial/MainActivity.kt#DataSeriesSetup)]
[!code-swift[AppendDataSeries](../../../samples/tutorials-native/tutorials-3d/tutorial-4/kotlin/src/main/java/com/scichart/tutorial/MainActivity.kt#AppendDataSeries)]
# [Xamarin.Android](#tab/xamarin)
[!code-cs[DataSeriesSetup](../../../samples/tutorials-xamarin/tutorials-3d/tutorial-04/MainActivity.cs#DataSeriesSetup)]
[!code-cs[AppendDataSeries](../../../samples/tutorials-xamarin/tutorials-3d/tutorial-04/MainActivity.cs#AppendDataSeries)]
***

From here, we can initialize our Timer and create an `updateData` selector, with real-time updates, like follows:

# [Java](#tab/java)
[!code-java[CreateTimer](../../../samples/tutorials-native/tutorials-3d/tutorial-4/java/src/main/java/com/scichart/tutorial/MainActivity.java#CreateTimer)]
[!code-java[UpdateData](../../../samples/tutorials-native/tutorials-3d/tutorial-4/java/src/main/java/com/scichart/tutorial/MainActivity.java#UpdateData)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[CreateTimer](../../../samples/tutorials-native/tutorials-3d/tutorial-4/javaBuilder/src/main/java/com/scichart/tutorial/MainActivity.java#CreateTimer)]
[!code-java[UpdateData](../../../samples/tutorials-native/tutorials-3d/tutorial-4/javaBuilder/src/main/java/com/scichart/tutorial/MainActivity.java#UpdateData)]
# [Kotlin](#tab/kotlin)
[!code-swift[CreateTimer](../../../samples/tutorials-native/tutorials-3d/tutorial-4/kotlin/src/main/java/com/scichart/tutorial/MainActivity.kt#CreateTimer)]
[!code-swift[UpdateData](../../../samples/tutorials-native/tutorials-3d/tutorial-4/kotlin/src/main/java/com/scichart/tutorial/MainActivity.kt#UpdateData)]
# [Xamarin.Android](#tab/xamarin)
[!code-cs[CreateTimer](../../../samples/tutorials-xamarin/tutorials-3d/tutorial-04/MainActivity.cs#CreateTimer)]
[!code-cs[UpdateData](../../../samples/tutorials-xamarin/tutorials-3d/tutorial-04/MainActivity.cs#UpdateData)]
***

Which will result in the following Chart:

> [!NOTE]
> Despite the chart is now real-time, it's still fully interactive, you can use modifiers from **[previous](xref:tutorials3d.SciChartAndroidTutorial-CursorsAndTooltips)** tutorials with ease.

<video autoplay loop muted playsinline src="images/tutorials-3d-realtime.mp4"></video>

## Where to Go From Here?
You can download the final project from our [!include[Java and Kotlin Tutorials Repository](JavaKotlinTutorials3DLink.md)].

Of course, this is not the limit of what you can achieve with the SciChart Android 3D.
Our documentation contains lots of useful information, some of the articles you might want to read are listed below:
- [3D Axis Types](xref:axis3DAPIs.Axis3DAPIs)
- [3D Chart Types](xref:chart3d.3DChartTypes)
- [3D Chart Modifiers](xref:chartModifier3DAPIs.ChartModifier3DAPIs)

Finally, start exploring. The SciChart Android library and functionality is quite extensive. 
You can look into our [SciChart Android Examples Suite](https://www.scichart.com/examples/android-chart/) which are full of 2D and 3D examples, which are also available on our [GitHub](https://github.com/ABTSoftware/SciChart.Android.Examples)
