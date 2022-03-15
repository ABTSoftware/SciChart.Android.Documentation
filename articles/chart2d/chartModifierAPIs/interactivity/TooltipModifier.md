---
uid: "chartModifierAPIs.InteractivityTooltipModifier"
---

# TooltipModifier
Tooltips may be added to the <xref:com.scichart.charting.visuals.SciChartSurface> using the <xref:com.scichart.charting.modifiers.TooltipModifier>.

> [!NOTE]
> The  <xref:com.scichart.charting.modifiers.TooltipModifier> is specifically suited for scatter `X-Y` data, although it may be used for any type of data in SciChart.

![Tooltip Modifier](../images/tooltip-modifier-example.png)

> [!NOTE]
> Examples of the **TooltipModifier usage** can be found in the [SciChart Android Examples Suite](https://www.scichart.com/examples/Android-chart/) as well as on [GitHub](https://github.com/ABTSoftware/SciChart.Android.Examples):
> - [Native Example](https://www.scichart.com/example/android-chart-example-using-tooltipmodifier-tooltips/)
> - [Xamarin Example](https://www.scichart.com/example/xamarin-chart-using-tooltipmodifier-tooltips-example/)

## TooltipModifier Usage
The <xref:com.scichart.charting.modifiers.TooltipModifier> allows inspecting [RenderableSeries](xref:chart2d.2DChartTypes) at a touch point. 
For convenience, the actual **hit-test point** is located a bit upper. It is marked with a small "X" sign. 
Tooltips will appear to the side of it, showing the hit-test result for all RenderableSeries at the "X" location:

![Tooltip Modifier Usage](../images/tooltip-modifier-usage.png)

For hit-testing series parts that are close to the chart boundaries, a multi-touch finger drag can be used:

![Tooltip Modifier Usage Near Edge](../images/tooltip-modifier-usage-near-edge.png)

## TooltipModifier Features
Besides the TooltipModifier [specific features](#specific-features), there are some [common features](#common-features) which are shared between [TooltipModifier](xref:chartModifierAPIs.InteractivityTooltipModifier), [RolloverModifier](xref:chartModifierAPIs.InteractivityRolloverModifier) and [CursorModifier](xref:chartModifierAPIs.InteractivityCursorModifier) via common <xref:com.scichart.charting.modifiers.TooltipModifierBase> class.

#### Common Features

| **Feature**                               | **Description**                                                                                                                                                 |
| ----------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| <xref:com.scichart.charting.modifiers.TooltipModifierBase.setShowTooltip(boolean)>      | Allows to **hide or show** modifier's Tooltips.                                                                                                                 |
| <xref:com.scichart.charting.modifiers.TooltipModifierBase.setUseInterpolation(boolean)> | Allows to show **interpolated** values between data points. It is a `true` by default. If `false` - modifier's Tooltips will report the info about **closest** data points. |
| <xref:com.scichart.charting.modifiers.TooltipModifierBase.setSourceMode(com.scichart.charting.modifiers.SourceMode)>       | Allows to specify which <xref:com.scichart.charting.visuals.renderableSeries.IRenderableSeries> are to be inspected by a modifier, e.g. **Visible**, **Selected**, etc. Other will be ignored by the modifier. Expects a member of the <xref:com.scichart.charting.modifiers.SourceMode> enumeration. |

#### Specific Features

| **Feature**                                       | **Description**                                                                                                                                                                           |
| ------------------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| <xref:com.scichart.charting.modifiers.TooltipModifier.setOffset(float)>                       | Specifies **how far** the hit-test point is **from** the actual **touch point**. This value will be used for either `X` or `Y` coordinate, or both, depending on `markerPlacement`.       |
| <xref:com.scichart.charting.modifiers.TooltipModifier.setCustomPointOffset(android.graphics.PointF)>            | Specifies **how far** the hit-test point is **from** the actual **touch point**. As opposed to `offset`, both `X` and `Y` coordinate will always be applied.                              |
| <xref:com.scichart.charting.modifiers.TooltipModifier.setMarkerPlacement(com.scichart.charting.modifiers.Placement)>              | Allows to specify the **position** of the hit-test point relative to the **touch point**, e.g. Left, Top, etc... Expects a member of the <xref:com.scichart.charting.modifiers.Placement> enumeration.                      |
| <xref:com.scichart.charting.modifiers.TooltipModifier.setTooltipPosition(com.scichart.charting.modifiers.TooltipPosition)>              | Allows to specify the **position** of modifier's Tooltips relative to the **hit-test point**, e.g. TopLeft, BottomRight, etc.... Expects a member of the <xref:com.scichart.charting.modifiers.TooltipPosition> enumeration. |
| <xref:com.scichart.charting.modifiers.TooltipModifier.getTooltipPointMarkerPaint()> | Returns the [Paint](https://developer.android.com/reference/android/graphics/Paint.html) object that is responsible for the "X" marker drawing (marking the hit-test point). Can be used to change style and color properties of the marker. |

## Adding a TooltipModifier to a Chart
Any [Chart Modifier](xref:chartModifierAPIs.ChartModifierAPIs) can be [added to a <xref:com.scichart.charting.visuals.SciChartSurface>](xref:chartModifierAPIs.ChartModifierAPIs#adding-a-chart-modifier) via the [chartModifiers](xref:com.scichart.charting.visuals.ISciChartSurface.getChartModifiers()) property and <xref:com.scichart.charting.modifiers.TooltipModifier> is no difference:

# [Java](#tab/java)
[!code-java[AddTooltipModifier](../../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/chartModifier2D/InteractivityTooltipModifier.java#AddTooltipModifier)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[AddTooltipModifier](../../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/chartModifier2D/InteractivityTooltipModifier.java#AddTooltipModifier)]
# [Kotlin](#tab/kotlin)
[!code-swift[AddTooltipModifier](../../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/chartModifier2D/InteractivityTooltipModifier.kt#AddTooltipModifier)]
***

> [!NOTE]
> To learn more about features available, please visit the [Chart Modifier APIs](xref:chartModifierAPIs.ChartModifierAPIs#common-chart-modifier-features) article.
