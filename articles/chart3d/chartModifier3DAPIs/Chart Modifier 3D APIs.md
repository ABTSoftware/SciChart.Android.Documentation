---
uid: "chartModifier3DAPIs.ChartModifier3DAPIs"
---

# Chart Modifier 3D APIs

Within the SciChart Android SDK, **ChartModifiers** are the classes which can be added to a chart to give it a **certain behaviour**.
In SciChart 3D, for instance, all **zooming, panning operations, tooltips, legends** and even **selection** of points or lines are handled by <xref:com.scichart.charting3d.modifiers.ChartModifierBase3D> derived classes in the SciChart codebase.

There are many different **3D Chart Modifiers** provided by SciChart and each one deserves an article by itself! 
This article is concerned with simply giving **an overview of the modifiers** and where you can find the examples in our [SciChart Android Examples Suite](https://www.scichart.com/examples/Android-chart/) which demonstrate them.

There are also several individual articles on the **ChartModifier's** and how to configure them in the SciChart Android.
Those could be grouped like the following:
- [Zoom and Pan Modifiers 3D](#zoom-and-pan-modifiers-3d)
- [Interactivity Modifiers 3D](#interactivity-modifiers-3d)
- [Miscellaneous Modifiers 3D](#miscellaneous-modifiers-3d)

#### Zoom and Pan Modifiers 3D
The following modifiers can be used if you want to add zooming or panning behavior to a chart:

| **Modifier Name**                                                        | **Description**                                                                                                                                                           |
| ------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| [ZoomExtentsModifier3D](xref:chartModifier3DAPIs.ZoomAndPanZoomExtentsModifier3D) | **Resets the zoom** to the data extents via the ***double-tapping***. Available almost everywhere, e.g. see the [Surface Mesh 3D Floor and Ceiling](https://www.scichart.com/example/android-3d-chart-example-surface-mesh-floor-and-ceiling/) example. |
| [PinchZoomModifier3D](xref:chartModifier3DAPIs.ZoomAndPanPinchZoomModifier3D)     | **Zooms** a chart in and out via the ***pinch and spread gestures*** correspondingly. Available almost everywhere, e.g. see the [Logarithmic Axis 3D](https://www.scichart.com/example/android-3d-example-logarithmic-axis/) example. |
| [OrbitModifier3D](xref:chartModifier3DAPIs.ZoomAndPanOrbitModifier3D)              | Performs the **orbital motion** of the camera performs giving the appearance of ***rotating*** the 3D world. Available almost everywhere, e,g. see the [Ellipsoid Free Surface Chart 3D](https://www.scichart.com/example/android-3d-chart-example-simple-ellipsoid/) example. |
| [FreeLookModifier3D](xref:chartModifier3DAPIs.ZoomAndPanFreeLookModifier3D)      | Allows simple movement - Left, Right, Up or Down - of the chart camera imitating the ***free-look*** motion. Available almost everywhere, e.g. see the [Bubble Chart 3D](https://www.scichart.com/example/android-3d-chart-example-simple-bubble/) example. |

#### Interactivity Modifiers 3D
These modifiers allow to interact with chart series or inspect them:

| **Modifier Name**                                                                 | **Description**                                                                                                                                            |
| --------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------- |
| [VertexSelectionModifier3D](xref:chartModifier3DAPIs.InteractivityVertexSelectionModifier3D) | Provides **selection** of points via tapping on them. See the [Select Scatter Point 3D Chart](https://www.scichart.com/example/android-3d-chart-example-select-scatter-point/) example. |
| [TooltipModifier3D](xref:chartModifier3DAPIs.InteractivityTooltipModifier3D)                  | Provides a **tooltip** for the nearest point on a series under the finger. See the [Series Tooltips 3D Chart](https://www.scichart.com/example/android-3d-chart-example-series-tooltips/) example. |

#### Miscellaneous Modifiers 3D
Modifiers below are used as helpers and can be a useful addition to a chart:

| **Modifier Name**                                  | **Description**                                                                                                                                            |
| -------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------- |
| [ModifierGroup3D](#modifiergroup3d-features) | Can be used to **group** chart modifiers together. This can useful in **multi-chart** scenarios, to unite ModifierGroups into one **EventGroup** of modifiers. If an **Event** occurs on a chart, it will be propagated to modifiers from other charts that are in the same **EventGroup**. |
| <xref:com.scichart.charting3d.modifiers.LegendModifier3D>                              | Allows to creates and configure a **Legend** for a 3D chart. See the [Add Remove Series](https://www.scichart.com/example/android-3d-chart-example-add-remove-series/) example. |

> [!NOTE]
> To learn more about **ChartModifiers 3D API**, please read the [Common ChartModifiers 3D Features](#common-chart-modifier-3d-features) section. 
> To find out more about a **specific** 3D ChartModifier, please refer to a corresponding article about this Modifier type.

## Adding a Chart Modifier 3D
All 3D **Chart Modifiers** are inherited from <xref:com.scichart.charting3d.modifiers.ChartModifierBase3D>, conforms to the <xref:com.scichart.charting3d.modifiers.IChartModifier3D> and are added to the <xref:com.scichart.charting3d.model.ChartModifier3DCollection> which is stored in the [chartModifiers](xref:com.scichart.charting3d.visuals.ISciChartSurface3D.getChartModifiers()) property. 
Please see the code below, to see how to add [PinchZoomModifier3D](xref:chartModifier3DAPIs.ZoomAndPanPinchZoomModifier3D) to your <xref:com.scichart.charting3d.visuals.SciChartSurface3D>:

# [Java](#tab/java)
[!code-java[AddPinchZoom](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/chartModifier3D/ChartModifier3D.java#AddPinchZoom)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[AddPinchZoom](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/chartModifier3D/ChartModifier3D.java#AddPinchZoom)]
# [Kotlin](#tab/kotlin)
[!code-swift[AddPinchZoom](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/chartModifier3D/ChartModifier3D.kt#AddPinchZoom)]
***

## Common Chart Modifier 3D Features
As mentioned [above](#adding-a-chart-modifier-3d) - all the **3D ChartModifiers** provided by SciChart conforms to the <xref:com.scichart.charting3d.modifiers.IChartModifier3D> protocol and derive from the <xref:com.scichart.charting3d.modifiers.ChartModifierBase3D> class. 
These provide a **powerful API** which gives the full access to internals of a ***chart***, ***axes*** and ***renderable series***. 
It is a must that Custom Modifier 3D implement <xref:com.scichart.charting3d.modifiers.IChartModifier3D>, and hence we recommend inheriting <xref:com.scichart.charting3d.modifiers.ChartModifierBase3D> in such cases as well to get some base implementation for free.

Please see the list of common features below:

| **Feature**                                | **Description**                                                                                                               |
| ------------------------------------------ | ----------------------------------------------------------------------------------------------------------------------------- |
| <xref:com.scichart.charting3d.visuals.ISciChartSurface3DProvider.getParentSurface()> | Provides the <xref:com.scichart.charting3d.visuals.ISciChartSurface3D> which the modifier is attached to. See the <xref:com.scichart.core.framework.IAttachable.isAttached()> method below.        |
| <xref:com.scichart.charting.modifiers.IChartModifierCore.getModifierSurface()>    | Returns the **ModifierSurface** from the parental <xref:com.scichart.charting3d.visuals.SciChartSurface3D>. It is used to place Views like tooltips, etc. onto it. |
| <xref:com.scichart.core.framework.IAttachable.isAttached()>                | Value which indicates whether a modifier is attached to a <xref:com.scichart.charting3d.visuals.SciChartSurface3D> or not. If it is - <xref:com.scichart.charting3d.visuals.ISciChartSurface3DProvider.getParentSurface()> property will return the corresponding instance of <xref:com.scichart.charting3d.visuals.SciChartSurface3D>. |
| <xref:com.scichart.charting.modifiers.IChartModifierCore.setIsEnabled(boolean)>          | Allows to specify if a modifier should be **available** for interaction **or not**.                                           |
| <xref:com.scichart.charting.modifiers.ChartModifierCore.setReceiveHandledEvents(boolean)>   | Allows to specify whether a modifier should receive events handled by another modifier.                                       |

#### ModifierGroup3D Features
The <xref:com.scichart.charting3d.modifiers.ModifierGroup3D> allows **grouping** of modifiers. This can be useful if modifiers create a logical group within which they are handled together. 
For example, all modifiers inside a <xref:com.scichart.charting3d.modifiers.ModifierGroup3D> can be **enabled/disabled** together via the <xref:com.scichart.charting.modifiers.IChartModifierCore.setIsEnabled(boolean)> method on the <xref:com.scichart.charting3d.modifiers.ModifierGroup3D> itself.

Also, this is useful in **multi-chart** scenarios. Several <xref:com.scichart.charting3d.modifiers.ModifierGroup3D>s can be united to share events between charts. 
This can be done by <xref:com.scichart.charting3d.modifiers.ModifierGroup3D.setMotionEventGroup(java.lang.String)> to be the same for **ModifierGroups** which belong to different <xref:com.scichart.charting3d.visuals.SciChartSurface3D>s.

| **Feature**                          | **Description**                                                                                                                               |
| ------------------------------------ | --------------------------------------------------------------------------------------------------------------------------------------------- |
| <xref:com.scichart.charting3d.modifiers.ModifierGroup3D.setMotionEventGroup(java.lang.String)>      | Allows to specify which **MotionEventGroup** this modifier goes in. It is used to share events between modifiers that belong to different surfaces. |
| <xref:com.scichart.charting3d.modifiers.ModifierGroup3D.setChildModifiers(com.scichart.charting3d.model.ChartModifier3DCollection)>  | Assigns a collection of modifiers to a **ModifierGroup 3D**. Also a collection can be passed into the class constructor during creation.      |