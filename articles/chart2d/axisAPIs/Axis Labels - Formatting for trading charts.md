---
uid: "axisAPIs.AxisLabelsFormattingForTradingCharts"
---

# Axis Labels - Formatting for trading charts

If you develop some trading application, most likely, your chart will display some OHLC prices and indicators along with the corresponding date labels on X-Axis. In SciChart [Axis Labels - LabelProvider API](xref:axisAPIs.AxisLabelsLabelProviderAPI#axis-labels---labelprovider-api) helps you to present these labels in the desired format. Quite a popular scenario in trading charts is when date labels formatting changes depending on the current zoom level, so the deeper zoom level is, the more detailed dates appear.

<video autoplay loop muted playsinline src="images/label-formatter-trade-chart.mp4"></video>

> [!NOTE]
> Example of the Trading Charts Label Formatter usage can be found in the **Multi-Pane Stock Chart** example in the [SciChart Android Examples Suite](https://www.scichart.com/examples/Android-chart/) as well as on [GitHub](https://github.com/ABTSoftware/SciChart.Android.Examples):
> - [Native Example](https://www.scichart.com/example/android-chart/android-chart-multi-pane-stock-charts-example/)
> - [Xamarin Example](https://www.scichart.com/example/xamarin-chart/xamarin-chart-multi-pane-stock-charts-example/)

The most suitable type of X-Axis for trading charts is <xref:com.scichart.charting.visuals.axes.CategoryDateAxis>. It uses <xref:com.scichart.charting.numerics.labelProviders.TradeChartAxisLabelProvider> to dynamically change its Text and Cursor Labels depending on Data-value and current zoom.

To format labels the <xref:com.scichart.charting.numerics.labelProviders.TradeChartAxisLabelProvider> class uses <xref:com.scichart.charting.numerics.labelProviders.TradeChartAxisLabelFormatter> which incapsulates two formatters: 
- <xref:com.scichart.charting.numerics.labelProviders.CalendarUnitDateFormatter> - for [axis labels](xref:axisAPIs.AxisStylingTitleAndLabels)
- <xref:com.scichart.charting.numerics.labelProviders.CursorCalendarUnitDateFormatter> - for [<xref:com.scichart.charting.modifiers.CursorModifier> with axis labels](xref:chartModifierAPIs.InteractivityCursorModifier). 

Each of them formats dates depending on the current granularity using <xref:com.scichart.charting.numerics.labelProviders.ICalendarUnitDateFormatter.format(java.util.Date,int)> method. By default, there are few predefined formatters, so you will get dynamically changing axis labels out-of-the-box. In case, the default one doesn't meet your requirements, you can provide your own and [customize your label provider](#custom-trade-chart-label-provider). Please, continue reading to find out, how to do it.

## Custom Trade Chart Label Provider
As an example of a Trade Chart Label Provider customization, let's create a custom one with some different formatters. 

First, we need to subclass <xref:com.scichart.charting.numerics.labelProviders.CalendarUnitDateFormatter> and implement a protected method <xref:com.scichart.charting.numerics.labelProviders.CalendarUnitDateFormatter.createFormatterForCalendarUnit(int)> which will return a formatter with the desired date format depending on the current calendar unit. Here is, how it might look in code:

# [Java](#tab/java)
[!code-java[CustomCalendarUnitDateFormatter](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/axisAPIs/AxisLabelsFormattingForTradingCharts.java#CustomCalendarUnitDateFormatter)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[CustomCalendarUnitDateFormatter](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/axisAPIs/AxisLabelsFormattingForTradingCharts.java#CustomCalendarUnitDateFormatter)]
# [Kotlin](#tab/kotlin)
[!code-swift[CustomCalendarUnitDateFormatter](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/axisAPIs/AxisLabelsFormattingForTradingCharts.kt#CustomCalendarUnitDateFormatter)]
***

> [!NOTE]
> In case using `createFormatterForCalendarUnit` method to return your custom formatter doesn’t fit your needs and you want to have full control on formatting your axis labels, use <xref:com.scichart.charting.numerics.labelProviders.CalendarUnitDateFormatter.format(java.util.Date,int)> method. Please, continue reading to see how you can use this method.

Let's also create some custom <xref:com.scichart.charting.modifiers.CursorModifier> axis label formatter which will format cursor axis label depending on current granularity. So, for example, by default we want our Cursor to show a date in a format, like **“2018 Jun 17”** but when we zoom close enough - it should become something like **“Monday, 10 June”**.

Similar to how we create our **CustomCalendarUnitDateFormatter**, we will subclass <xref:com.scichart.charting.numerics.labelProviders.CursorCalendarUnitDateFormatter> and create two formatters with different date formats. Then, we will use <xref:com.scichart.charting.numerics.labelProviders.ICalendarUnitDateFormatter.format(java.util.Date,int)> method to return a string for our Cursor axis label. Here is how it will look in code:

# [Java](#tab/java)
[!code-java[CustomCursorCalendarUnitDateFormatter](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/axisAPIs/AxisLabelsFormattingForTradingCharts.java#CustomCursorCalendarUnitDateFormatter)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[CustomCursorCalendarUnitDateFormatter](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/axisAPIs/AxisLabelsFormattingForTradingCharts.java#CustomCursorCalendarUnitDateFormatter)]
# [Kotlin](#tab/kotlin)
[!code-swift[CustomCursorCalendarUnitDateFormatter](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/axisAPIs/AxisLabelsFormattingForTradingCharts.kt#CustomCursorCalendarUnitDateFormatter)]
***

Next, we need to subclass <xref:com.scichart.charting.numerics.labelProviders.TradeChartAxisLabelFormatter> and pass our custom formatters to its init, like this:

# [Java](#tab/java)
[!code-java[CustomTradeChartLabelFormatter](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/axisAPIs/AxisLabelsFormattingForTradingCharts.java#CustomTradeChartLabelFormatter)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[CustomTradeChartLabelFormatter](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/axisAPIs/AxisLabelsFormattingForTradingCharts.java#CustomTradeChartLabelFormatter)]
# [Kotlin](#tab/kotlin)
[!code-swift[CustomTradeChartLabelFormatter](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/axisAPIs/AxisLabelsFormattingForTradingCharts.kt#CustomTradeChartLabelFormatter)]
***

Finally, create a <xref:com.scichart.charting.numerics.labelProviders.TradeChartAxisLabelProvider> subclass with our **CustomTradeChartLabelFormatter** and assign it to the [labelProvider](xref:com.scichart.charting.visuals.axes.IAxisCore.setLabelProvider(com.scichart.charting.numerics.labelProviders.ILabelProvider)). Also, you need to add to your surface <xref:com.scichart.charting.modifiers.PinchZoomModifier> to be able to zoom and <xref:com.scichart.charting.modifiers.CursorModifier> to see the Cursor axis labels formatting in action. See the code below:

# [Java](#tab/java)
[!code-java[CustomTradeChartLabelProvider](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/axisAPIs/AxisLabelsFormattingForTradingCharts.java#CustomTradeChartLabelProvider)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[CustomTradeChartLabelProvider](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/axisAPIs/AxisLabelsFormattingForTradingCharts.java#CustomTradeChartLabelProvider)]
# [Kotlin](#tab/kotlin)
[!code-swift[CustomTradeChartLabelProvider](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/axisAPIs/AxisLabelsFormattingForTradingCharts.kt#CustomTradeChartLabelProvider)]
***

Here are the results in the normal and slightly zoomed states: 
![TradeChartAxisLabelProvider](images/label-formatter-trade-chart-cursor-default.png)
![TradeChartAxisLabelProvider](images/label-formatter-trade-chart-cursor-zoomed.png)

In case such a customization doesn't fit your needs and you need some completely different Label Provider you can always create your own. You will find more details in [Axis Labels - LabelProvider API](xref:axisAPIs.AxisLabelsLabelProviderAPI#axis-labels---labelprovider-api) article.