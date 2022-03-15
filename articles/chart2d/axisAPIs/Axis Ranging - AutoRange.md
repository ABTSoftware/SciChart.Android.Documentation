---
uid: "axisAPIs.AxisRangingAutoRange"
---

# Axis Ranging - AutoRange
At the outset, the [VisibleRange](xref:axisAPIs.AxisRangingVisibleRangeAndDataRange) is adjusted to be equal to the [DataRange](xref:axisAPIs.AxisRangingVisibleRangeAndDataRange) of an axis. However, an axis won't adjust its **VisibleRange** automatically when data changes, unless it is configured to do this. The default behavior can be changed by applying different <xref:com.scichart.charting.visuals.axes.AutoRange> modes on <xref:com.scichart.charting.visuals.axes.IAxisCore.setAutoRange(com.scichart.charting.visuals.axes.AutoRange)>.

> [!NOTE]
> Setting an explicit <xref:com.scichart.charting.visuals.axes.IAxisCore.setVisibleRange(com.scichart.data.model.IRange)> on the axis will override this behaviour.

## AutoRange Once
This is the **default** setting. The axis will attempt to autorange once to fit the data as you start the chart. This is a **one-time** action - the <xref:com.scichart.charting.visuals.axes.IAxisCore.setVisibleRange(com.scichart.data.model.IRange)>  won't adjust to any data changes in future.

# [Java](#tab/java)
[!code-java[SetAutoRangeOnce](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/axisAPIs/AxisRangingAutoRange.java#SetAutoRangeOnce)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[SetAutoRangeOnce](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/axisAPIs/AxisRangingAutoRange.java#SetAutoRangeOnce)]
# [Kotlin](#tab/kotlin)
[!code-swift[SetAutoRangeOnce](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/axisAPIs/AxisRangingAutoRange.kt#SetAutoRangeOnce)]
***

## AutoRange Always
In this mode, the axis will attempt to autorange **always** to fit the data every time the chart is drawn. The **VisibleRange** will adjust to data changes correspondingly.

> [!NOTE]
> Please be aware that this setting **will override any other ranging**, including zooming and panning by modifiers, but is useful in situations where you always want to view the extents of the data.

# [Java](#tab/java)
[!code-java[SetAutoRangeAlways](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/axisAPIs/AxisRangingAutoRange.java#SetAutoRangeAlways)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[SetAutoRangeAlways](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/axisAPIs/AxisRangingAutoRange.java#SetAutoRangeAlways)]
# [Kotlin](#tab/kotlin)
[!code-swift[SetAutoRangeAlways](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/axisAPIs/AxisRangingAutoRange.kt#SetAutoRangeAlways)]
***

## AutoRange Never
The axis will **never** autorange. With this option, you would need to set the <xref:com.scichart.charting.visuals.axes.IAxisCore.setVisibleRange(com.scichart.data.model.IRange)> manually. The **VisibleRange** won't adjust to any data changes.

# [Java](#tab/java)
[!code-java[SetAutoRangeNever](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/axisAPIs/AxisRangingAutoRange.java#SetAutoRangeNever)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[SetAutoRangeNever](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/axisAPIs/AxisRangingAutoRange.java#SetAutoRangeNever)]
# [Kotlin](#tab/kotlin)
[!code-swift[SetAutoRangeNever](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/axisAPIs/AxisRangingAutoRange.kt#SetAutoRangeNever)]
***

## Using ViewportManager
The AutoRange behavior can be **completely overridden** if necessary. The <xref:com.scichart.charting.viewportManagers.IViewportManager> provides the full access to and control over axis ranges and viewport. The default implementation of <xref:com.scichart.charting.viewportManagers.IViewportManager> is the <xref:com.scichart.charting.viewportManagers.DefaultViewportManager> class. Custom ViewportManagers can be assigned via [viewportManager](xref:com.scichart.charting.visuals.ISciChartSurface.setViewportManager(com.scichart.charting.viewportManagers.IViewportManager)) property.

