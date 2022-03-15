---
uid: "chartModifierAPIs.CustomModifiersTheGestureModifierBaseAPI"
---

# Custom Modifiers - the GestureModifierBase API
The <xref:com.scichart.charting.modifiers.GestureModifierBase> provides an abstract base class for all **Gesture-Based Modifiers** within SciChart. 
Using this API, you can **create gestures** that you can attach to a chart to perform any gesture you like. 
Any time you want to do something to alter the behavior of any built-in gesture modifiers, you should be thinking about creating a **custom gesture-based modifier** to do it.

<video autoplay loop muted playsinline src="../images/custom-gesture-based-modifier.mp4"></video>

> [!NOTE]
> Example of the Custom Gesture-Based Modifier can be found in the [SciChart Android Examples Suite](https://www.scichart.com/examples/android-chart/) as well as on [GitHub](https://github.com/ABTSoftware/SciChart.android.Examples):

## Custom Gesture-Based Modifier
An example below shows how to use <xref:com.scichart.charting.modifiers.GestureModifierBase> API to create a chart custom gesture-based modifier.

As an example, we will implement a single finger vertical pinch-zoom gesture-based modifier to zoom our chart on X-Axis.
Also, we want to enable it by double-tap (similar to how it works in Google Maps App).

> [!NOTE]
> It's highly recommended to inherit from <xref:com.scichart.charting.modifiers.GestureModifierBase> since it gives you some of the base implementations for free.

Let's get into the code.

# [Java](#tab/java)
[!code-java[CreateCustomZoomGestureModifier](../../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/chartModifier2D/CustomModifiersTheGestureModifierBaseAPI.java#CreateCustomZoomGestureModifier)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[CreateCustomZoomGestureModifier](../../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/chartModifier2D/CustomModifiersTheGestureModifierBaseAPI.java#CreateCustomZoomGestureModifier)]
# [Kotlin](#tab/kotlin)
[!code-swift[CreateCustomZoomGestureModifier](../../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/chartModifier2D/CustomModifiersTheGestureModifierBaseAPI.kt#CreateCustomZoomGestureModifier)]
***

Add it onto your chart like any other modifier to see how it works.

## Common Gesture Modifier Properties
As mentioned [above](#custom-modifiers---the-gesturemodifierbase-api), all **GestureModifiers** within SciChart derive from the abstract <xref:com.scichart.charting.modifiers.GestureModifierBase> class, which conforms to [OnGestureListener](https://developer.android.com/reference/android/view/GestureDetector.OnGestureListener), [OnDoubleTapListener](https://developer.android.com/reference/android/view/GestureDetector.OnDoubleTapListener) interfaces and uses a [GestureDetector](https://developer.android.com/reference/android/view/GestureDetector.html) internally.

Please see the list of common properties below:

> [!NOTE]
> To learn more about common **ChartModifier** features - please read the [Chart Modifier APIs](xref:chartModifierAPIs.ChartModifierAPIs#common-chart-modifier-features) article. 
Also visit related <xref:com.scichart.charting.modifiers.IChartModifier> API documentation.