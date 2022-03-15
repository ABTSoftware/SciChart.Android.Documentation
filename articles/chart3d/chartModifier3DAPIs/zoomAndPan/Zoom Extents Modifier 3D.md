---
uid: "chartModifier3DAPIs.ZoomAndPanZoomExtentsModifier3D"
---

# Zoom Extents Modifier 3D
SciChart Android 3D provides the ability to **zoom-to-fit** the entire 3D chart by ***double-tapping*** it via the <xref:com.scichart.charting3d.modifiers.ZoomExtentsModifier3D>, available out of the box.

<video autoplay loop muted playsinline src="../images/zoom-extents-modifier-3d.mp4"></video>

Besides [common features](xref:chartModifier3DAPIs.ChartModifier3DAPIs#common-chart-modifier-3d-features) which are inherited from the <xref:com.scichart.charting3d.modifiers.ChartModifierBase3D> class, the <xref:com.scichart.charting3d.modifiers.ZoomExtentsModifier3D> allows to control its specific features via the following properties:
- <xref:com.scichart.charting3d.modifiers.ZoomExtentsModifier3D.setResetTarget(com.scichart.charting3d.common.math.Vector3)> - defines the <xref:com.scichart.charting3d.common.math.Vector3> target where the <xref:com.scichart.charting3d.visuals.camera.ICameraController.setTarget(com.scichart.charting3d.common.math.Vector3)> is moved on reset.
- <xref:com.scichart.charting3d.modifiers.ZoomExtentsModifier3D.setResetPosition(com.scichart.charting3d.common.math.Vector3)> - defines the <xref:com.scichart.charting3d.common.math.Vector3> target where the <xref:com.scichart.charting3d.visuals.camera.ICameraController.setPosition(com.scichart.charting3d.common.math.Vector3)> is moved on reset.
- <xref:com.scichart.charting3d.modifiers.ZoomExtentsModifier3D.setExecuteOn(com.scichart.charting.modifiers.ExecuteOn)> - allows to specify the trigger action for the modifier via the <xref:com.scichart.charting.modifiers.ExecuteOn> enumeration.
- <xref:com.scichart.charting3d.modifiers.ZoomExtentsModifier3D.setAutoFitRadius(boolean)> - When `true`, attempts to ***auto-fit*** the camera radius to fit the scene. When `false` - uses the <xref:com.scichart.charting3d.modifiers.ZoomExtentsModifier3D.setResetPosition(com.scichart.charting3d.common.math.Vector3)> and <xref:com.scichart.charting3d.modifiers.ZoomExtentsModifier3D.setResetTarget(com.scichart.charting3d.common.math.Vector3)> instead.
- <xref:com.scichart.charting3d.modifiers.ZoomExtentsModifier3D.setAnimationDuration(long)> - defines the animation duration in `long` for any zoom operations.

> [!NOTE]
> There are several modes defined by the <xref:com.scichart.charting.modifiers.ExecuteOn> enumeration, such as **Single Tap, Double Tap, Long Press**, and **Fling**.

There are two modes of operation for the <xref:com.scichart.charting3d.modifiers.ZoomExtentsModifier3D> - ***AutoFit*** and ***Manual***:

| **Operation Mode**    | **Description**                                                                                                                                      |
| --------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------- |
| `autoFitRadius = true` | Tries to automatically fit the 3D scene into the viewport. <xref:com.scichart.charting3d.visuals.camera.ICameraController.getTarget()> and <xref:com.scichart.charting3d.visuals.camera.ICameraController.getPosition()> methods are ignored. |
| `autoFitRadius = false`  | You should specify the precise coordinates in the <xref:com.scichart.charting3d.visuals.camera.ICameraController.setTarget(com.scichart.charting3d.common.math.Vector3)> and <xref:com.scichart.charting3d.visuals.camera.ICameraController.setPosition(com.scichart.charting3d.common.math.Vector3)> methods.                    |

## Adding a ZoomExtentsModifier to a Chart
Any [Chart Modifier 3D](xref:chartModifier3DAPIs.ChartModifier3DAPIs) can be [added to a <xref:com.scichart.charting3d.visuals.SciChartSurface3D>](xref:chartModifier3DAPIs.ChartModifier3DAPIs#adding-a-chart-modifier-3d) via the [chartModifiers](xref:com.scichart.charting3d.visuals.ISciChartSurface3D.getChartModifiers()) property and <xref:com.scichart.charting3d.modifiers.ZoomExtentsModifier3D> is no difference:

# [Java](#tab/java)
[!code-java[AddZoomExtentsModifier](../../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/chartModifier3D/ZoomAndPanZoomExtentsModifier3D.java#AddZoomExtentsModifier)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[AddZoomExtentsModifier](../../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/chartModifier3D/ZoomAndPanZoomExtentsModifier3D.java#AddZoomExtentsModifier)]
# [Kotlin](#tab/kotlin)
[!code-swift[AddZoomExtentsModifier](../../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/chartModifier3D/ZoomAndPanZoomExtentsModifier3D.kt#AddZoomExtentsModifier)]
***

> [!NOTE]
> To learn more about features available, please visit the [Chart Modifier 3D APIs](xref:chartModifier3DAPIs.ChartModifier3DAPIs#common-chart-modifier-3d-features) article.

## Programmatically Zoom to Extents
You can also run **Zoom to Extents** functionality programmatically without adding <xref:com.scichart.charting3d.modifiers.ZoomExtentsModifier3D>.
The <xref:com.scichart.charting3d.visuals.camera.Camera3D> object which is associated with <xref:com.scichart.charting3d.visuals.SciChartSurface3D> provides the following methods which you can call whenever you need to zoom the chart to fit:
- <xref:com.scichart.charting3d.visuals.camera.ICameraController.zoomToFit()>
- <xref:com.scichart.charting3d.visuals.camera.ICameraController.animateZoomToFit(long)>
- <xref:com.scichart.charting3d.visuals.camera.ICameraController.zoomToFit(com.scichart.charting3d.common.math.Vector3)>
- <xref:com.scichart.charting3d.visuals.camera.ICameraController.animateZoomToFit(com.scichart.charting3d.common.math.Vector3,long)>
- <xref:com.scichart.charting3d.visuals.camera.ICameraController.animate(com.scichart.charting3d.common.math.Vector3,com.scichart.charting3d.common.math.Vector3,long)>