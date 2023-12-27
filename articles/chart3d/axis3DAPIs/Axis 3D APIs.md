---
uid: "axis3DAPIs.Axis3DAPIs"
---

# Axis 3D APIs

There are several axis types in **SciChart Android 3D**. The <xref:com.scichart.charting3d.visuals.axes.IAxis3D> are the logical representation of the `XZ`, `ZY`, `YX` planes in the ***Axis Cube***.

Axes are required to measure the <xref:com.scichart.charting3d.visuals.renderableSeries.IRenderableSeries3D>, for instance, an axis is responsible for the transformation between **data-values** (provided by your code) and **world coordinates** (`X`, `Y`, `Z` values in 3D Space).

> [!NOTE]
> It is necessary to declare all **X, Y and Z** Axes in code before the 3D chart will draw. They are accessible via the following properties:
>
> - [xAxis](xref:com.scichart.charting3d.visuals.SciChartSurface3D.setXAxis(com.scichart.charting3d.visuals.axes.IAxis3D))
> - [yAxis](xref:com.scichart.charting3d.visuals.SciChartSurface3D.setYAxis(com.scichart.charting3d.visuals.axes.IAxis3D))
> - [zAxis](xref:com.scichart.charting3d.visuals.SciChartSurface3D.setZAxis(com.scichart.charting3d.visuals.axes.IAxis3D))

A list of the 3D axis types are found below:

- [NumericAxis3D](#numericaxis3d)
- [LogarithmicNumericAxis3D](#logarithmicnumericaxis3d)
- [DateAxis3D](#dateaxis3d)

All the 3D axis types in SciChart conforms to the <xref:com.scichart.charting3d.visuals.axes.IAxis3D> protocol.

## NumericAxis3D
The <xref:com.scichart.charting3d.visuals.axes.NumericAxis3D> is a **Value-Axis** and is suitable when the data type on that axis is numeric (e.g. **double, int, long, float, short**). It is not suitable for non-numeric data types such as [Android Date](https://developer.android.com/reference/java/util/Date).

To create and configure a <xref:com.scichart.charting3d.visuals.axes.NumericAxis3D>, use the following code:

# [Java](#tab/java)
[!code-java[AddNumericAxis3D](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/axis3DAPIs/Axis3DAPIs.java#AddNumericAxis3D)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[AddNumericAxis3D](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/axis3DAPIs/Axis3DAPIs.java#AddNumericAxis3D)]
# [Kotlin](#tab/kotlin)
[!code-swift[AddNumericAxis3D](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/axis3DAPIs/Axis3DAPIs.kt#AddNumericAxis3D)]
***

## LogarithmicNumericAxis3D
The <xref:com.scichart.charting3d.visuals.axes.LogarithmicNumericAxis3D> is a **Value axis** which uses non-linear (logarithmic) scale. It is suitable when the data is numeric (e.g. **double, int, long, float, short**). It is not suitable for non-numeric data types such as [Android Date](https://developer.android.com/reference/java/util/Date).

> [!NOTE]
> The <xref:com.scichart.charting3d.visuals.axes.LogarithmicNumericAxis3D> cannot render data values less than or equal to zero. Please ensure you append valid data to your DataSeries.

To create and configure a <xref:com.scichart.charting3d.visuals.axes.LogarithmicNumericAxis3D>, use the following code:

# [Java](#tab/java)
[!code-java[AddLogarithmicNumericAxis3D](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/axis3DAPIs/Axis3DAPIs.java#AddLogarithmicNumericAxis3D)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[AddLogarithmicNumericAxis3D](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/axis3DAPIs/Axis3DAPIs.java#AddLogarithmicNumericAxis3D)]
# [Kotlin](#tab/kotlin)
[!code-swift[AddLogarithmicNumericAxis3D](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/axis3DAPIs/Axis3DAPIs.kt#AddLogarithmicNumericAxis3D)]
***

## DateAxis3D
The <xref:com.scichart.charting3d.visuals.axes.DateAxis3D> is a **Value axis**, which is designed to work with **dates** only.
> [!NOTE]
> The <xref:com.scichart.charting3d.visuals.axes.DateAxis3D> is not suitable for *numeric data types*.

To create and configure a <xref:com.scichart.charting3d.visuals.axes.DateAxis3D>, use the following code:

# [Java](#tab/java)
[!code-java[AddDateAxis3D](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/axis3DAPIs/Axis3DAPIs.java#AddDateAxis3D)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[AddDateAxis3D](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/axis3DAPIs/Axis3DAPIs.java#AddDateAxis3D)]
# [Kotlin](#tab/kotlin)
[!code-swift[AddDateAxis3D](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/axis3DAPIs/Axis3DAPIs.kt#AddDateAxis3D)]
***

> [!NOTE]
> To learn more about how to convert values from Dates to Indexes and back, please refer to the [Convert Pixels to Data Coordinates](xref:axis3DAPIs.Axis3DAPIsConvertWorldToDataCoordinates) article.

## See the Axis 3D Types in action
Please take a look at the examples from the [Android Examples Suite](https://www.scichart.com/examples/Android-chart/) listed below to see these axis 3D types in action:
- [Android 3D Custom Free Surface Chart](https://www.scichart.com/example/android-chart/android-3d-chart-example-create-custom-free-surface/) with <xref:com.scichart.charting3d.visuals.axes.NumericAxis3D>
- [Android 3D Logarithmic Axis](https://www.scichart.com/example/android-chart/android-3d-example-logarithmic-axis/) with <xref:com.scichart.charting3d.visuals.axes.LogarithmicNumericAxis3D>
- [Android 3D Date Axis3D](https://www.scichart.com/example/android-chart/android-3d-chart-example-date-axis/) with <xref:com.scichart.charting3d.visuals.axes.DateAxis3D>
