---
uid: "userManual.ChartBuildersHelperClasses"
---

# Chart Builders Helper Classes

To simplify creation and configuring of a SciChartSurface, SciChart Android provides a bunch of helper classes. They follow the **XXXBuilder** naming pattern and allow to initialize virtually anything in an easier and more convenient way. Different property of classes can be preset via the **withXXX(…)** methods of the helpers, a.k.a. *"chart builders"*.

## Referencing SciChart Builders

SciChart builders for 2D and 3D charts provided as seperate library which is called 'extensions'. If you want to use then you'll need to add it into your project as dependency. This is available from our [Maven feed](https://www.myget.org/feed/abtsoftware/package/maven/com.scichart.library/extensions), or in the Android Charts SDK at [www.scichart.com/downloads](http://www.scichart.com/downloads).

[!code-gradle[MavenRepositories](../../samples/sandbox/settings.gradle#AddSciChartMavenRepositories)]

## Using Chart Builders in Code

The main chart builder class is called **SciChartBuilder**. It acts as a factory of builders of other types, representing different chart aspects.

Using chart builders, the code snippet for chart initialization from the section above can be rewritten as follows:

[!code-java[UseChartBuilders](../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/chartBuilders/ChartBuilderHelpers.java#UseChartBuilders)]

Usually this approach to chart initialization results in more concise and elegent code. It is preferred for the vast majority of examples from the [Android Examples Suite](https://www.scichart.com/examples/android-chart/). We would recommend using it in applications too. However, it doesn't give any other benefits except those stated above, so the standard way of objects initialization is equally fine.

