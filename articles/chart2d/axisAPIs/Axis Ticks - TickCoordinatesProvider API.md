---
uid: "axisAPIs.AxisTicksTickCoordinatesProviderAPI"
---

# Axis Ticks - TickCoordinatesProvider API
TickCoordinatesProvider API is a part of Axis which is defined by [tickCoordinatesProvider](xref:com.scichart.charting.visuals.axes.IAxisCore.setTickCoordinatesProvider(com.scichart.charting.numerics.tickCoordinatesProviders.ITickCoordinatesProvider)) and is responsible for converting [ticks](xref:com.scichart.charting.numerics.tickProviders.ITickProvider.getTicks()) (provided by [TickProvider API](xref:axisAPIs.AxisTicksTickProviderAndDeltaCalculatorAPI)) into coordinates on a screen.

By default each axis uses <xref:com.scichart.charting.numerics.tickCoordinatesProviders.DefaultTickCoordinatesProvider> which just converts data ticks into pixel coordinates using <xref:com.scichart.charting.numerics.coordinateCalculators.ICoordinateCalculator> provided by axis. If you want to customize this process you can extend this class and override <xref:com.scichart.charting.numerics.IAxisProviderBase.update()> to update <xref:com.scichart.charting.numerics.tickCoordinatesProviders.TickCoordinates>:

# [Java](#tab/java)
[!code-java[CreateCustomTickCoordinatesProvider](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/axisAPIs/AxisTicksTickCoordinatesProviderAPI.java#CreateCustomTickCoordinatesProvider)]
[!code-java[UseCustomTickCoordinatesProvider](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/axisAPIs/AxisTicksTickCoordinatesProviderAPI.java#UseCustomTickCoordinatesProvider)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[CreateCustomTickCoordinatesProvider](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/axisAPIs/AxisTicksTickCoordinatesProviderAPI.java#CreateCustomTickCoordinatesProvider)]
[!code-java[UseCustomTickCoordinatesProvider](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/axisAPIs/AxisTicksTickCoordinatesProviderAPI.java#UseCustomTickCoordinatesProvider)]
# [Kotlin](#tab/kotlin)
[!code-swift[CreateCustomTickCoordinatesProvider](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/axisAPIs/AxisTicksTickCoordinatesProviderAPI.kt#CreateCustomTickCoordinatesProvider)]
[!code-swift[UseCustomTickCoordinatesProvider](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/axisAPIs/AxisTicksTickCoordinatesProviderAPI.kt#UseCustomTickCoordinatesProvider)]
***
