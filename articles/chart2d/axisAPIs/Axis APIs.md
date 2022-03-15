---
uid: "axis.AxisAPIs"
---

## Axis APIs

There are several axis types in SciChart Android. Although they all differ in types of data values that can be rendered, the most fundamental difference is in their behavior. By that, the axes can be divided into two groups, Category and Value axis types. Please read the [Value Axis vs. Category Axis](xref:axisAPIs.AxisAPIsValueAxisVSCategoryAxis) article elaborating on what the difference is.

A list of the axis types are found below:

| **Axis Type**                                           | **Value or Category Axis** |
| ------------------------------------------------------- | -------------------------- |
| [NumericAxis](#numericaxis)                          | Value Axis                 |
| [LogarithmicNumericAxis](#logarithmicnumericaxis)    | Value Axis                 |
| [DateAxis](#dateaxis)                                | Value Axis                 |
| [CategoryDateAxis](#categorydateaxis)                | Category Axis              |

All the axis types in SciChart conforms to the <xref:com.scichart.charting.visuals.axes.IAxis> protocol.

## NumericAxis
The <xref:com.scichart.charting.visuals.axes.NumericAxis> is a **Value-Axis** and is suitable for **X and Y Axis** when the data type on that axis is numeric (e.g. **double, int, long, float, short**). It is not suitable for non-numeric data types.

To create and configure a <xref:com.scichart.charting.visuals.axes.NumericAxis>, use the following code:

# [Java](#tab/java)
[!code-java[AddNumericAxis](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/axisAPIs/AxisAPIs.java#AddNumericAxis)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[AddNumericAxis](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/axisAPIs/AxisAPIs.java#AddNumericAxis)]
# [Kotlin](#tab/kotlin)
[!code-swift[AddNumericAxis](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/axisAPIs/AxisAPIs.kt#AddNumericAxis)]
***

## LogarithmicNumericAxis
The <xref:com.scichart.charting.visuals.axes.LogarithmicNumericAxis> is a **Value axis** which uses non-linear (logarithmic) scale. It is suitable for **X and Y Axis** when the data is numeric (e.g. **double, int, long, float, short**). It is not suitable for non-numeric data types.

> [!NOTE]
> The <xref:com.scichart.charting.visuals.axes.LogarithmicNumericAxis> cannot render data values less than or equal to zero. Please ensure you append valid data to your DataSeries.

To create and configure a <xref:com.scichart.charting.visuals.axes.LogarithmicNumericAxis>, use the following code:

# [Java](#tab/java)
[!code-java[AddLogarithmicNumericAxis](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/axisAPIs/AxisAPIs.java#AddLogarithmicNumericAxis)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[AddLogarithmicNumericAxis](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/axisAPIs/AxisAPIs.java#AddLogarithmicNumericAxis)]
# [Kotlin](#tab/kotlin)
[!code-swift[AddLogarithmicNumericAxis](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/axisAPIs/AxisAPIs.kt#AddLogarithmicNumericAxis)]
***

## DateAxis
The <xref:com.scichart.charting.visuals.axes.DateAxis> is a **Value axis**, which is suitable for **X and Y Axis** and is designed to work with dates only. 
> [!NOTE]
> The <xref:com.scichart.charting.visuals.axes.DateAxis> is not suitable for *numeric data types*.

To create and configure a <xref:com.scichart.charting.visuals.axes.DateAxis>, use the following code:

# [Java](#tab/java)
[!code-java[AddDateAxis](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/axisAPIs/AxisAPIs.java#AddDateAxis)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[AddDateAxis](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/axisAPIs/AxisAPIs.java#AddDateAxis)]
# [Kotlin](#tab/kotlin)
[!code-swift[AddDateAxis](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/axisAPIs/AxisAPIs.kt#AddDateAxis)]
***

## CategoryDateAxis
The <xref:com.scichart.charting.visuals.axes.CategoryDateAxis> is a **Category axis** and is suitable for the **XAxis only**. It is designed to handle a special case when **data is discontinuous** or contains breaks at regular intervals. Unlike the other axis types, it works with with **data indices, not actual data values**.

> [!NOTE]
> The <xref:com.scichart.charting.visuals.axes.CategoryDateAxis> is not suitable for *YAxis* or *numeric data types*.

To create and configure a <xref:com.scichart.charting.visuals.axes.CategoryDateAxis>, use the following code:

# [Java](#tab/java)
[!code-java[AddCategoryDateAxis](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/axisAPIs/AxisAPIs.java#AddCategoryDateAxis)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[AddCategoryDateAxis](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/axisAPIs/AxisAPIs.java#AddCategoryDateAxis)]
# [Kotlin](#tab/kotlin)
[!code-swift[AddCategoryDateAxis](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/axisAPIs/AxisAPIs.kt#AddCategoryDateAxis)]
***

> [!NOTE]
> Note the <xref:com.scichart.charting.visuals.axes.CategoryDateAxis> is treated as a special case. 
> Although it is intended to show Dates, it doesn't allow setting <xref:com.scichart.data.model.DateRange> as VisibleRange. 
> The reason for this is that this axis type works with with **data indices**, not actual **data values**. 
> So a <xref:com.scichart.data.model.DoubleRange> should be applied instead, with lower data index as Min and Upper data index as Max.
> 
> To learn more about how to convert values from Dates to Indexes and back, please refer to the [Convert Pixels to Data Coordinates](xref:axisAPIs.AxisAPIsConvertPixelToDataCoordinates) article.

## See the Axis Types in action
Please take a look at the examples from the Android Examples Suite listed below to see these axis types in action:
- [Column Chart](https://www.scichart.com/example/android-column-chart-example/) with <xref:com.scichart.charting.visuals.axes.NumericAxis>
- [Logarithmic Axis](https://www.scichart.com/example/android-chart-example-logarithmic-axis/) with <xref:com.scichart.charting.visuals.axes.LogarithmicNumericAxis>
- [Fan Chart](https://www.scichart.com/example/android-chart-example-fan-chart/) with <xref:com.scichart.charting.visuals.axes.DateAxis>
- [Candlestick Chart](https://www.scichart.com/example/android-candlestick-chart-example/) with <xref:com.scichart.charting.visuals.axes.CategoryDateAxis>