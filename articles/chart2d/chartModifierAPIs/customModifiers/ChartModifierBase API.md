---
uid: "chartModifierAPIs.CustomModifiersTheChartModifierBaseAPI"
---

# Custom Modifiers - the ChartModifierBase API
The **<xref:com.scichart.charting.modifiers.ChartModifierBase> API** is by far the **most powerful** API in the SciChart library. 
The <xref:com.scichart.charting.modifiers.ChartModifierBase> provides an abstract base class for all of the 2D **ChartModifiers** within SciChart, all of our built-in 2D modifiers inherit from it. 
Using this API, you can **create behaviours** which you can attach to a chart to perform custom Zooming, Panning, Annotation & Markers, Legend output and much much more.
Any time you want to do something to alter the behaviour of a <xref:com.scichart.charting.visuals.SciChartSurface> you should be thinking about creating **a custom modifier** to do it.

## Custom Chart Rotation Modifier
A simple example below shows how you can use <xref:com.scichart.charting.modifiers.ChartModifierBase> API to create a chart rotation modifier. 
Add it onto your chart like any other modifier to see how it works.

Let's get to the code:

> [!NOTE]
> It's highly recommended to inherit from <xref:com.scichart.charting.modifiers.ChartModifierBase> since it gives you some of the base implementation for free.

# [Java](#tab/java)
[!code-java[CreateCustomRotateChartModifier](../../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/chartModifier2D/CustomModifiersTheChartModifierBaseAPI.java#CreateCustomRotateChartModifier)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[CreateCustomRotateChartModifier](../../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/chartModifier2D/CustomModifiersTheChartModifierBaseAPI.java#CreateCustomRotateChartModifier)]
# [Kotlin](#tab/kotlin)
[!code-swift[CreateCustomRotateChartModifier](../../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/chartModifier2D/CustomModifiersTheChartModifierBaseAPI.kt#CreateCustomRotateChartModifier)]
***

 The **modifier** above allows to rotate a chart when added to its <xref:com.scichart.charting.model.ChartModifierCollection>.

 The common methods that are currently implemented and are not likely to be replaced can be found in the [Chart Modifier APIs](xref:chartModifierAPIs.ChartModifierAPIs#common-chart-modifier-features) article. 
 For more information - please read the <xref:com.scichart.charting.modifiers.IChartModifier> API documentation.

> [!NOTE]
> If you want to handle gestures in your custom **ChartModifier**, you could derive it from the <xref:com.scichart.charting.modifiers.GestureModifierBase> class, which provides base infrastructure for [GestureDetector](https://developer.android.com/reference/android/view/GestureDetector) usage.

## The ModifierTouchEventArgs Type
If your custom **ChartModifier** requires to handle touch events or gestures, you might need to override either the <xref:com.scichart.core.utility.touch.IReceiveMotionEvents.onTouch(com.scichart.core.utility.touch.ModifierTouchEventArgs)> or <xref:com.scichart.core.utility.touch.IReceiveMotionEvents.onGenericMotion(com.scichart.core.utility.touch.ModifierTouchEventArgs)> method. 
Both receive the only parameter of the <xref:com.scichart.core.utility.touch.ModifierTouchEventArgs> type. This type exposes the following information about an event that occurred:

| **Field**                               | **Description**                                                                                     |
| --------------------------------------- | --------------------------------------------------------------------------------------------------- |
| <xref:com.scichart.core.utility.touch.ModifierTouchEventArgs.source>           |  Provides the source of the event, of the <xref:com.scichart.core.utility.touch.IReceiveMotionEvents> type.                                 |
| <xref:com.scichart.core.utility.touch.ModifierTouchEventArgs.isEventWithinBounds(com.scichart.core.framework.IHitTestable)> |  Reports whether the event occurred within the **Source**.                                           |
| <xref:com.scichart.core.utility.touch.ModifierTouchEventArgs.isHandled>        |  Reports whether the event **has been already** passed to any other modifier and **handled** by it. |
| <xref:com.scichart.core.utility.touch.ModifierTouchEventArgs.e>                |  Returns the original [MotionEvent](https://developer.android.com/reference/android/view/MotionEvent) instance                                                                  |

> [!NOTE]
> To receive handled events, use <xref:com.scichart.charting.modifiers.ChartModifierCore.setReceiveHandledEvents(boolean)> on a modifier and set it to **`true`**.
