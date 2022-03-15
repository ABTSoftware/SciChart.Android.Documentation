---
uid: "axisAPIs.AxisRangingHowToListenToVisibleRangeChanges"
---

# Axis Ranging - How to listen to VisibleRange Changes
It is possible to subscribe to listening to the <xref:com.scichart.charting.visuals.axes.IAxisCore.setVisibleRange(com.scichart.data.model.IRange)> changes using a <xref:com.scichart.charting.visuals.axes.VisibleRangeChangeListener>:

# [Java](#tab/java)
[!code-java[SetVisibleRangeChangeListener](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/axisAPIs/AxisRangingHowToListenToVisibleRangeChanges.java#SetVisibleRangeChangeListener)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[SetVisibleRangeChangeListener](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/axisAPIs/AxisRangingHowToListenToVisibleRangeChanges.java#SetVisibleRangeChangeListener)]
# [Kotlin](#tab/kotlin)
[!code-swift[SetVisibleRangeChangeListener](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/axisAPIs/AxisRangingHowToListenToVisibleRangeChanges.kt#SetVisibleRangeChangeListener)]
***

> [!NOTE]
> You can differentiate between changes that were part of an animation by checking the **isAnimating** parameter. For example, an animated zoom to extents operation will fire the callback many times with `isAnimating = true`, then once at the end with `isAnimating = false`.

The most typical use for this callback is to perform some kind of operation when the <xref:com.scichart.charting.visuals.axes.IAxisCore.setVisibleRange(com.scichart.data.model.IRange)> changes, such as updating UI.

It is also possible to use this callback to restrict the VisibleRange in some way, e.g set a bounded or clipped range onto Axis.VisibleRange when the range changes outside of a desired area.

> [!NOTE]
> We've already used this technique in [Advanced VisibleRange Clipping](xref:axisAPIs.AxisRangingRestrictingVisibleRange#advanced-visiblerange-clipping)

## See Also
- [Axis Types in SciChart](xref:axis.AxisAPIs)
- [Axis Ranging - AutoRange](xref:axisAPIs.AxisRangingAutoRange)
- [Axis Ranging - Get or Set VisibleRange](xref:axisAPIs.AxisRangingGetOrSetVisibleRange)
- [Axis Ranging - Restricting VisibleRange](xref:axisAPIs.AxisRangingRestrictingVisibleRange)
- [Axis Ranging - VisibleRange and DataRange](xref:axisAPIs.AxisRangingVisibleRangeAndDataRange)