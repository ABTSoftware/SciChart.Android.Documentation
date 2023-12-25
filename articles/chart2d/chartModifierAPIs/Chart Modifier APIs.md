---
uid: "chartModifierAPIs.ChartModifierAPIs"
---

# Chart Modifier APIs

Within the SciChart SDK, **ChartModifiers** are the classes which can be added to a chart to give it a **certain behaviour**. For instance, all **zooming, panning operations, tooltips, legends** and even **selection** of points or lines are handled by <xref:com.scichart.charting.modifiers.ChartModifierBase> derived classes in the SciChart codebase.

There are many different **ChartModifiers** provided by SciChart and each one deserves an article by itself! 
This article is concerned with simply giving **an overview of the modifiers** and where you can find the examples in our [SciChart Android Examples Suite](https://www.scichart.com/examples/android-chart/) which demonstrate them.

There are also several individual articles on the **ChartModifier's** and how to configure them in the SciChart Android.
Those could be grouped like the following:
- [Zoom and Pan Modifiers](#zoom-and-pan-modifiers)
- [Interactivity Modifiers](#interactivity-modifiers)
- [Miscellaneous Modifiers](#miscellaneous-modifiers)
- [Custom Modifiers](xref:chartModifierAPIs.CustomModifiersTheChartModifierBaseAPI)

#### Zoom and Pan Modifiers
The following modifiers can be used if you want to add scrolling or zooming behavior to a chart:

| **Modifier Name**                                                    | **Description**                                                                                                                                                           |
| -------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| [ZoomExtentsModifier](<xref:chartModifierAPIs.ZoomAndPanZoomExtentsModifier>) | **Resets the zoom** to the data extents via double-tapping. Available almost everywhere, e.g. see the [Sync Multi Chart](https://www.scichart.com/example/android-chart/android-chart-example-sync-multi-chart/) example. |
| [PinchZoomModifier](xref:chartModifierAPIs.ZoomAndPanPinchZoomModifier)     | **Zooms** a chart in and out via the pinch and spread gestures correspondingly. Available almost everywhere, e.g. see the [Multiple X-Axes](https://www.scichart.com/example/android-chart/android-chart-example-multiple-xaxis/) example. |
| [ZoomPanModifier](xref:chartModifierAPIs.ZoomAndPanZoomPanModifier)         | **Pans** the chart in X, Y or both directions with inertia via finger sliding. Available almost everywhere, e,g. see the [Multiple X-Axes](https://www.scichart.com/example/android-chart/android-chart-example-multiple-xaxis/) example. |
| [RubberBandXyZoomModifier](xref:chartModifierAPIs.ZoomAndPanRubberBandXyZoomModifier)         | **Zooms** a chart via draggin rectangle on a chart. Available almost everywhere, e.g. see the [Drag Area to Zoom](https://www.scichart.com/example/android-chart/android-chart-drag-area-to-zoom-example/) example. |
| [XAxisDragModifier](xref:chartModifierAPIs.ZoomAndPanXAxisDragModifier)     | **Scales** or **pans an X Axis** via finger drag. See [Drag Axis to Scale a Chart](https://www.scichart.com/example/android-chart/android-chart-drag-axis-to-scale-a-chart-example/) example. |
| [YAxisDragModifier](xref:chartModifierAPIs.ZoomAndPanYAxisDragModifier)     | **Scales** or **pans an Y Axis** via finger drag. See [Drag Axis to Scale a Chart](https://www.scichart.com/example/android-chart/android-chart-drag-axis-to-scale-a-chart-example/) example. |

#### Interactivity Modifiers
These modifiers allow to interact with chart series or inspect them:

| **Modifier Name**                                                             | **Description**                                                                                                                                            |
| ----------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------- |
| [SeriesSelectionModifier](xref:chartModifierAPIs.InteractivitySeriesSelectionModifier) | Provides **selection** of a series via tapping on it. See the [Series Selection](https://www.scichart.com/example/android-chart/android-chart-example-series-selection/) example.          |
| [TooltipModifier](xref:chartModifierAPIs.InteractivityTooltipModifier)                 | Provides a **tooltip** for the nearest point on a series under the finger. See the [Using TooltipModifier](https://www.scichart.com/example/android-chart/android-chart-example-using-tooltipmodifier-tooltips/) example. |
| [RolloverModifier](xref:chartModifierAPIs.InteractivityRolloverModifier)               | Provides a **vertical slice** cursor **with tooltips** and markers rolling over a series. See the [Using RolloverModifier](https://www.scichart.com/example/android-chart/android-chart-example-using-rollovermodifier-tooltips/) example. |
| [CursorModifier](xref:chartModifierAPIs.InteractivityCursorModifier)                   | Provides a **crosshairs** with a tooltip and axis labels. See [Using CursorModifier](https://www.scichart.com/example/android-chart/android-chart-example-using-cursormodifier-tooltips/) example. |

#### Miscellaneous Modifiers  
Modifiers below are used as helpers and can be a useful addition to a chart:

| **Modifier&nbsp;Name**                              | **Description**                                                                                                                                            |
| ---------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------- |
| [ModifierGroup](#modifiergroup-features) | Can be used to **group** chart modifiers together. This can useful in **multi-chart** scenarAndroid, to unite ModifierGroups into one **EventGroup** of modifiers. If an **Event** occurs on a chart, it will be propagated to modifiers from other charts that are in the same **EventGroup**. See the [Multi-Pane Stock Chart](https://www.scichart.com/example/android-chart/android-chart-multi-pane-stock-charts-example/) example. |
| [LegendModifier](xref:chartModifierAPIs.LegendModifier)    | Allows to creates and configure a **Legend** for a chart. See the [Legend Chart](https://www.scichart.com/example/android-chart/android-chart-legends-api-example/) example. |
| [SeriesValueModifier](xref:chartModifierAPIs.SeriesValueModifier)    | A custom ChartModifier which places an <xref:com.scichart.charting.modifiers.SeriesValueModifier.SeriesValueMarkerAnnotation> on the YAxis for each RenderableSeries in the chart, showing the current <xref:com.scichart.charting.visuals.renderableSeries.IRenderableSeries> latest Y-value. E.g. for each series, place one axis-marker with the latest Y-value of the series. See the [SeriesValueModifier Chart](https://www.scichart.com/example/android-chart/android-chart-series-value-modifier-example/) example. |

> [!NOTE]
> To learn more about **ChartModifiers API**, please read the [Common ChartModifiers Features](#common-chart-modifier-features) section. 
> To find out more about a **specific** ChartModifier, please refer to a corresponding article about this Modifier type.

## Adding a Chart Modifier
All 2D **Chart Modifiers** are inherited from <xref:com.scichart.charting.modifiers.ChartModifierBase>, conforms to the <xref:com.scichart.charting.modifiers.IChartModifier> and are added to the <xref:com.scichart.charting.model.ChartModifierCollection> which is stored in [chartModifiers](xref:com.scichart.charting.visuals.ISciChartSurface.getChartModifiers()) property. 
Please see the code below, to see how to add [PinchZoomModifier](xref:chartModifierAPIs.ZoomAndPanPinchZoomModifier) to your <xref:com.scichart.charting.visuals.SciChartSurface>:

# [Java](#tab/java)
[!code-java[AddPinchZoomModifier](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/chartModifier2D/ChartModifier2D.java#AddPinchZoomModifier)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[AddPinchZoomModifier](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/chartModifier2D/ChartModifier2D.java#AddPinchZoomModifier)]
# [Kotlin](#tab/kotlin)
[!code-swift[AddPinchZoomModifier](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/chartModifier2D/ChartModifier2D.kt#AddPinchZoomModifier)]
***

## Common Chart Modifier Features
As mentioned [above](#adding-a-chart-modifier) - all the **ChartModifiers** provided by SciChart conforms to the <xref:com.scichart.charting.modifiers.IChartModifier> protocol and derive from the <xref:com.scichart.charting.modifiers.ChartModifierBase> class. 
These provide a **powerful API** which gives the full access to internals of a chart, axes, series, annotations. 
It is a must that Custom Modifiers implement <xref:com.scichart.charting.modifiers.IChartModifier>, and hence we recommend inheriting <xref:com.scichart.charting.modifiers.ChartModifierBase> in such cases as well to get some base implementation for free.

Please see the list of common features below:

| **Feature**                              | **Description**                                                                                                             |
| ---------------------------------------- | --------------------------------------------------------------------------------------------------------------------------- |
| <xref:com.scichart.charting.visuals.ISciChartSurfaceProvider.getParentSurface()> | Provides the <xref:com.scichart.charting.visuals.ISciChartSurface> which the modifier is attached to. See the <xref:com.scichart.core.framework.IAttachable.isAttached()> method below.        |
| <xref:com.scichart.charting.modifiers.IChartModifierCore.getModifierSurface()>  | Returns the **ModifierSurface** from the parental <xref:com.scichart.charting.visuals.SciChartSurface>. It is used to place Views like tooltips, etc. onto it. |
| <xref:com.scichart.core.framework.IAttachable.isAttached()>              | Value which indicates whether a modifier is attached to a <xref:com.scichart.charting.visuals.SciChartSurface> or not. If it is - <xref:com.scichart.charting.visuals.ISciChartSurfaceProvider.getParentSurface()> method will return the corresponding instance of <xref:com.scichart.charting.visuals.SciChartSurface>. |
| <xref:com.scichart.charting.modifiers.IChartModifierCore.setIsEnabled(boolean)>        | Allows to specify if a modifier should be **available** for interaction **or not**.                                         |
| <xref:com.scichart.charting.modifiers.ChartModifierCore.setReceiveHandledEvents(boolean)>  | Allows to specify whether a modifier should receive events handled by another modifier.                                     |

#### ModifierGroup Features
The <xref:com.scichart.charting.modifiers.ModifierGroup> allows **grouping** of modifiers. This can be useful if modifiers create a logical group within which they are handled together. 
For example, all modifiers inside a <xref:com.scichart.charting.modifiers.ModifierGroup> can be **enabled/disabled** together via the <xref:com.scichart.charting.modifiers.IChartModifierCore.setIsEnabled(boolean)> method on the <xref:com.scichart.charting.modifiers.ModifierGroup> itself.

Also, this is useful in **multi-chart** scenarios. Several <xref:com.scichart.charting.modifiers.ModifierGroup>s can be united to share events between charts. 
This can be done by <xref:com.scichart.charting.modifiers.ModifierGroup.setMotionEventGroup(java.lang.String)> method to be the same for **ModifierGroups** which belong to different <xref:com.scichart.charting.visuals.SciChartSurface>s.

| **Feature**                          | **Description**                                                                                                                               |
| ------------------------------------ | --------------------------------------------------------------------------------------------------------------------------------------------- |
| <xref:com.scichart.charting.modifiers.ModifierGroup.setMotionEventGroup(java.lang.String)>        | Allows to specify which **EventGroup** this modifier goes in. It is used to share events between modifiers that belong to different surfaces. |
| <xref:com.scichart.core.utility.touch.IReceiveMotionEventGroup.getEventsSource()> | Returns the **ModifierSurface** which is the source of the events.                                                                            |
| <xref:com.scichart.charting.modifiers.ModifierGroup.setChildModifiers(com.scichart.charting.model.ChartModifierCollection)>    | Assigns a collection of modifiers to a **ModifierGroup**. Also a collection can be passed into the class constructor during creation.         |
