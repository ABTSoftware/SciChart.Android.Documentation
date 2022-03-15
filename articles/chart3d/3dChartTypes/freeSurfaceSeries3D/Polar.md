---
uid: "chart3d.FreeSurfaceSeries3D-Polar"
---

# The Polar 3D Chart Type
In SciChart, **Polar 3D Charts** are provided by the combination of the [Free Surface 3D Series](xref:chart3d.FreeSurfaceSeries3D) and <xref:com.scichart.charting3d.model.dataSeries.freeSurface.PolarDataSeries3D> underlying DataSeries.

The ***location*** of the <xref:com.scichart.charting3d.model.dataSeries.freeSurface.PolarDataSeries3D> is defined by following properties:
- [offsetX](xref:com.scichart.charting3d.model.dataSeries.freeSurface.FreeSurfaceDataSeries3D.setOffsetX(TX)) – a location of the Polar by the `X-Axis`;
- [offsetY](xref:com.scichart.charting3d.model.dataSeries.freeSurface.FreeSurfaceDataSeries3D.setOffsetY(TY)) – a location of the Polar by the `Y-Axis`;
- [offsetZ](xref:com.scichart.charting3d.model.dataSeries.freeSurface.FreeSurfaceDataSeries3D.setOffsetZ(TZ)) – a location of the Polar by the `Z-Axis`;

The ***size*** of the <xref:com.scichart.charting3d.model.dataSeries.freeSurface.CylindroidDataSeries3D> is defined by following properties:
- [a](xref:com.scichart.charting3d.model.dataSeries.freeSurface.PolarDataSeries3D.getA()) – a distance from the origin to the ***internal*** edge of the cylindroid 3D Surface;
- [b](xref:com.scichart.charting3d.model.dataSeries.freeSurface.PolarDataSeries3D.getB()) – a distance from the origin to the ***external*** edge of the cylindroid 3D Surface;

![Polar Chart 3D](../images/free-surface-3d-polar.png)

> [!NOTE]
> Examples for the **Polar Series 3D** can be found in the [SciChart Android Examples Suite](https://www.scichart.com/examples/android-chart/) as well as on [GitHub](https://github.com/ABTSoftware/SciChart.Android.Examples):
> - [Native Example](https://www.scichart.com/example/android-3d-chart-example-simple-polar/)
> - [Xamarin Example](https://www.scichart.com/example/xamarin-3d-chart-example-simple-polar/)

## Create a Polar 3D Chart
To create a **Polar 3D Chart**, use the following code:

# [Java](#tab/java)
[!code-java[CreatePolar3DChart](../../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/series3d/FreeSurfaceSeries3DPolar.java#CreatePolar3DChart)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[CreatePolar3DChart](../../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/series3d/FreeSurfaceSeries3DPolar.java#CreatePolar3DChart)]
# [Kotlin](#tab/kotlin)
[!code-swift[CreatePolar3DChart](../../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/series3d/FreeSurfaceSeries3DPolar.kt#CreatePolar3DChart)]
***

> [!NOTE]
> See other [constrained](xref:chart3d.FreeSurfaceSeries3D#constrained-free-surface-3d-types) and [unconstrained](xref:chart3d.FreeSurfaceSeries3D#unconstrained-free-surface-3d-type) **Free Surface Series** types in the corresponding articles.
