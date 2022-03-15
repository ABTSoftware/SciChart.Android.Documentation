---
uid: "axisAPIs.AxisAPIsProgrammaticallyZoomScroll"
---

# Axis APIs - Programmatically Zoom, Scroll

## Programmatically Scrolling an Axis
SciChart provides a clean and [simple APIs](Chart Modifier APIs.html) to interact with a single Axis programmatically, e.g. to **Zoom**, **Scroll** or **Pan** an axis. This can come in useful when creating custom <xref:com.scichart.charting.modifiers.ChartModifierBase> derived classes e.g. [custom zooming or panning](xref:chartModifierAPIs.CustomModifiersTheChartModifierBaseAPI) of the chart.

## IAxis Interactivity Methods
The following methods can be found on <xref:com.scichart.charting.visuals.axes.IAxis> and <xref:com.scichart.charting.visuals.axes.AxisBase>, a shared base-class for 2D Axis types in SciChart:
- <xref:com.scichart.charting.visuals.axes.IAxis.scroll(float,com.scichart.charting.ClipMode)>
- <xref:com.scichart.charting.visuals.axes.IAxis.scroll(float,com.scichart.charting.ClipMode,long)>
- <xref:com.scichart.charting.visuals.axes.IAxis.scroll(float,com.scichart.charting.ClipMode,com.scichart.charting.ClipModeTarget)>
- <xref:com.scichart.charting.visuals.axes.IAxis.scroll(float,com.scichart.charting.ClipMode,com.scichart.charting.ClipModeTarget,long)>
- <xref:com.scichart.charting.visuals.axes.IAxis.zoom(float,float)>
- <xref:com.scichart.charting.visuals.axes.IAxis.zoom(float,float,long)>
- <xref:com.scichart.charting.visuals.axes.IAxis.zoomBy(double,double)>
- <xref:com.scichart.charting.visuals.axes.IAxis.zoomBy(double,double,long)>

Using these methods you can programmatically **zoom, scroll (pan)** a specific axis.  You can read more information about the above methods in [API documentation](xref:com.scichart.charting.visuals.axes.IAxis).
