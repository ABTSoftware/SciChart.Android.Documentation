---
uid: "stylingAndTheming.CreateACustomTheme"
---

# Create a Custom Theme
As well as built in themes provided by the ThemeManager, in SciChart you can also define your own [custom theme](https://www.scichart.com/example/android-chart-example-create-a-custom-theme/).

![Custom Theme](images/custom-theme-example.png)

> [!NOTE]
> **Custom Theme** example can be found in the [SciChart Android Examples Suite](https://www.scichart.com/examples/Android-chart/) as well as on [GitHub](https://github.com/ABTSoftware/SciChart.Android.Examples):
> - [Native Example](https://www.scichart.com/example/android-chart-example-create-a-custom-theme/)

First of all you'll need to define style with new theme in styles.xml:

# [XML](#tab/xml)
[!code-xml[CreateCustomTheme](../../../samples/sandbox/app/src/main/res/values/styles.xml#CreateCustomTheme)]
***

That's it. Now you can apply it to your <xref:com.scichart.charting.visuals.SciChartSurface> as [usual](xref:stylingAndTheming.StylingAndTheming#applying-a-theme-to-the-scichartsurface):

# [Java](#tab/java)
[!code-java[SetCustomTheme](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/stylingAndTheming/StylingAndTheming.java#SetCustomTheme)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[SetCustomTheme](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/stylingAndTheming/StylingAndTheming.java#SetCustomTheme)]
# [Kotlin](#tab/kotlin)
[!code-swift[SetCustomTheme](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/stylingAndTheming/StylingAndTheming.kt#SetCustomTheme)]
***
