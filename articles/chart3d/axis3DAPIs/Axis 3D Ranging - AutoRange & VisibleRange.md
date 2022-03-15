---
uid: "axis3DAPIs.Axis3DRangingAutoRangeAndVisibleRange"
---

# Axis 3D Ranging - AutoRange & VisibleRange
**[Axes in SciChart 3D](xref:axis3DAPIs.Axis3DAPIs)** shares the same <xref:com.scichart.charting.visuals.axes.AxisCore> base class with **[SciChart 2D Axes](xref:axis.AxisAPIs)**.
Many of the **AxisCore** features are shared. 
For your convenience, some of the documentation has been duplicated here, with some referring to other sections of the user manual.

## Axis 3D AutoRange
<xref:com.scichart.charting3d.visuals.axes.AxisBase3D> derived Types also have **AutoRanging** behaviour as per the 2D axis types. 
The [autoRange](xref:com.scichart.charting.visuals.axes.IAxisCore.setAutoRange(com.scichart.charting.visuals.axes.AutoRange)) property defines how the axis will auto-range when data is changed.

There are 3 possible auto-range modes, which are listed below:
- <xref:com.scichart.charting.visuals.axes.AutoRange.Once> - axis will attempt to fit the data only **when you start the chart**.
- <xref:com.scichart.charting.visuals.axes.AutoRange.Always> - axis will attempt to fit the data **every time** the chart is drawn .
- <xref:com.scichart.charting.visuals.axes.AutoRange.Never> - axis will **never** auto-range.

In a 3D Axis, AutoRanging means, ***given a fixed size of Axis in 3D world coordinates, change the VisibleRange Max/Min to fit the data***. 
Dynamically positioning the [Camera](xref:axis3DAPIs.SciChart3DBasicsCamera3DAPI) to view all of the 3D Chart is known as ***Zoom to Fit*** and is performed by [zoomToFit](xref:com.scichart.charting3d.visuals.camera.ICameraController.zoomToFit(com.scichart.charting3d.common.math.Vector3)).

> [!NOTE]
> The **AutoRanging** are shared between SciChart 2D and SciChart 3D. For a full walk-through, including code-samples, please see the [Axis Ranging - AutoRange](xref:axisAPIs.AxisRangingAutoRange) article.

## Axis 3D VisibleRange
Every 3D Axis type can work with a specific range type that conforms to the <xref:com.scichart.data.model.IRange> protocol. It depends on the data type that the axis can work with. Please review the article on [3D Axis Types](Axis 3D APIs.html) to learn more.

The [visibleRange](xref:com.scichart.charting.visuals.axes.IAxisCore.setVisibleRange(com.scichart.data.model.IRange)) is an actual axis range, measured in chart units. This is a part of a chart that is currently visible in a viewport.
This property allows you to **set or get** the `visibleRange` on the axis.

> [!NOTE]
> The **VisibleRange APIs** are shared between SciChart 2D and SciChart 3D. For a full walk-through of VisibleRange API, including code-samples, please see the following articles:
> 
> - [Axis Ranging - VisibleRange and DataRange](xref:axisAPIs.AxisRangingVisibleRangeAndDataRange)
> - [Axis Ranging - Restricting VisibleRange](xref:axisAPIs.AxisRangingRestrictingVisibleRange)
