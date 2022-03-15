---
uid: "tutorials3d.SciChartAndroidTutorial-ZoomingAndRotating"
---

# SciChart Android 3D Tutorial - Zooming and Rotating

So far, we have created a 3D chart, added XAxis, YAxis and ZAxis and 3D scatter series.

In this SciChart Android 3D tutorial we're going to add some **interactivity** for 3D chart, that at the end we should be able to **zoom** and **rotate** camera around the chart.

## Getting Started
This tutorial is suitable for **Java** and **Kotlin**.

> [!NOTE]
> Source code for this tutorial can be found at our Github Repository: [!include[Java and Kotlin Tutorials 3D Repository](JavaKotlinTutorials3DLink.md)]

First of all, make sure, you've read the [Tutorial 01 - Create a simple Scatter Chart 3D](xref:tutorials3d.SciChartAndroidTutorial-CreateSimpleScatterChart3D) and have a basic understanding of how to use SciChart 3D.

Now, let's give some definition for Zooming and Rotation:
- **zoom** — means to enlarge the chart by zooming in on a section. You use two fingers to do this. But it's more than just zooming into a 2D drawing, the **perspective** changes as you move throughout the 3D space, creating the illusion that you are moving inside the cube which is the chart.
- **rotate** — means to move rotate the camera and move it up and down. Remember that the **camera** is your perspective, or the projection from your eye of the chart onto the 2D surface of the screen.

## 3D ChartModifiers
In SciChart Amdroid 3D, chart interactions are defined by [3D ChartModifiers](xref:chartModifier3DAPIs.ChartModifier3DAPIs).
In addition to the default SciChart modifiers you can write custom modifiers or extends existing ones.

Here is the list of modifiers available out of the box in SciChart:
- [ZoomExtentsModifier3D](xref:chartModifier3DAPIs.ZoomAndPanZoomExtentsModifier3D)
- [PinchZoomModifier3D](xref:chartModifier3DAPIs.ZoomAndPanPinchZoomModifier3D)
- [OrbitModifier3D](xref:chartModifier3DAPIs.ZoomAndPanOrbitModifier3D)
- [FreeLookModifier3D](xref:chartModifier3DAPIs.ZoomAndPanFreeLookModifier3D)
- [VertexSelectionModifier3D](xref:chartModifier3DAPIs.InteractivityVertexSelectionModifier3D)
- [TooltipModifier3D](xref:chartModifier3DAPIs.InteractivityTooltipModifier3D)
- <xref:com.scichart.charting3d.modifiers.LegendModifier3D>
- <xref:com.scichart.charting3d.modifiers.ModifierGroup3D>

## Adding 3D Chart Modifiers
Now we are going to create and configure a couple of **modifiers** and add a set of them as modifier collection of the <xref:com.scichart.charting3d.visuals.SciChartSurface3D>:

# [Java](#tab/java)
[!code-java[AddModifiers](../../../samples/tutorials-native/tutorials-3d/tutorial-2/java/src/main/java/com/scichart/tutorial/MainActivity.java#AddModifiers)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[AddModifiers](../../../samples/tutorials-native/tutorials-3d/tutorial-2/javaBuilder/src/main/java/com/scichart/tutorial/MainActivity.java#AddModifiers)]
# [Kotlin](#tab/kotlin)
[!code-swift[AddModifiers](../../../samples/tutorials-native/tutorials-3d/tutorial-2/kotlin/src/main/java/com/scichart/tutorial/MainActivity.kt#AddModifiers)]
# [Xamarin.Android](#tab/xamarin)
[!code-cs[AddModifiers](../../../samples/tutorials-xamarin/tutorials-3d/tutorial-02/MainActivity.cs#AddModifiers)]
***

<video autoplay loop muted playsinline src="images/tutorials-3d-chart-modifiers.mp4"></video>

## Where to Go From Here?
You can download the final project from our [!include[Java and Kotlin Tutorials Repository](JavaKotlinTutorials3DLink.md)].

Also, you can found **next tutorial** from this series here - [SciChart Android 3D Tutorial - Cursors and Tooltips](xref:tutorials3d.SciChartAndroidTutorial-CursorsAndTooltips)

Of course, this is not the maximum of what you can achieve with the SciChart Android 3D.
You can find more information about modifiers which are used in this tutorial in the articles below:
- [Zoom Extents Modifier 3D](xref:chartModifier3DAPIs.ZoomAndPanZoomExtentsModifier3D)
- [Pinch Zoom Modifier 3D](xref:chartModifier3DAPIs.ZoomAndPanPinchZoomModifier3D)
- [Orbit Modifier 3D](xref:chartModifier3DAPIs.ZoomAndPanOrbitModifier3D)

Finally, start exploring. The SciChart Android library and functionality is quite extensive. 
You can look into our [SciChart Android Examples Suite](https://www.scichart.com/examples/android-chart/) which are full of 2D and 3D examples, which are also available on our [GitHub](https://github.com/ABTSoftware/SciChart.Android.Examples)
