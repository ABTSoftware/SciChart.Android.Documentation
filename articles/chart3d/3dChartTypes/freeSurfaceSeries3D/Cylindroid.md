---
uid: "chart3d.FreeSurfaceSeries3D-Cylindroid"
---

# The Cylindroid 3D Chart Type
In SciChart, **Cylindroid 3D Charts** are provided by the combination of the [Free Surface 3D Series](xref:chart3d.FreeSurfaceSeries3D) and <xref:com.scichart.charting3d.model.dataSeries.freeSurface.CylindroidDataSeries3D> underlying DataSeries.

The ***location*** of the <xref:com.scichart.charting3d.model.dataSeries.freeSurface.CylindroidDataSeries3D> is defined by following properties:
- [offsetX](xref:com.scichart.charting3d.model.dataSeries.freeSurface.IFreeSurfaceDataSeries3DValues.getOffsetX()) – a location of the Cylindroid by the `X-Axis`;
- [offsetY](xref:com.scichart.charting3d.model.dataSeries.freeSurface.IFreeSurfaceDataSeries3DValues.getOffsetY()) – a location of the Cylindroid by the `Y-Axis`;
- [offsetZ](xref:com.scichart.charting3d.model.dataSeries.freeSurface.IFreeSurfaceDataSeries3DValues.getOffsetZ()) – a location of the Cylindroid by the `Z-Axis`;

The ***size*** of the <xref:com.scichart.charting3d.model.dataSeries.freeSurface.CylindroidDataSeries3D> is defined by following properties:
- [a](xref:com.scichart.charting3d.model.dataSeries.freeSurface.CylindroidDataSeries3D.getA()) – a distance from the origin to the ***internal*** edge of the cylindroid 3D Surface;
- [b](xref:com.scichart.charting3d.model.dataSeries.freeSurface.CylindroidDataSeries3D.getB()) – a distance from the origin to the ***external*** edge of the cylindroid 3D Surface;
- [h](xref:com.scichart.charting3d.model.dataSeries.freeSurface.CylindroidDataSeries3D.getH()) – a height of the Cylindroid along the `Z-Axis`;

![Cylindroid Chart 3D](../images/free-surface-3d-cylindroid.png)

> [!NOTE]
> Examples for the **Cylindroid Series 3D** can be found in the [SciChart Android Examples Suite](https://www.scichart.com/examples/android-chart/) as well as on [GitHub](https://github.com/ABTSoftware/SciChart.Android.Examples):
> - [Native Example](https://www.scichart.com/example/android-3d-chart-example-simple-cylindroid/)
> - [Xamarin Example](https://www.scichart.com/example/xamarin-3d-chart-example-simple-cylindroid/)

## Create a Cylindroid 3D Chart
To create a **Cylindroid 3D Chart**, use the following code:

# [Java](#tab/java)
[!code-java[CreateCylindroid3DChart](../../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/series3d/FreeSurfaceSeries3DCylindroid.java#CreateCylindroid3DChart)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[CreateCylindroid3DChart](../../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/series3d/FreeSurfaceSeries3DCylindroid.java#CreateCylindroid3DChart)]
# [Kotlin](#tab/kotlin)
[!code-swift[CreateCylindroid3DChart](../../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/series3d/FreeSurfaceSeries3DCylindroid.kt#CreateCylindroid3DChart)]
***

> [!NOTE]
> See other [constrained](xref:chart3d.FreeSurfaceSeries3D#constrained-free-surface-3d-types) and [unconstrained](xref:chart3d.FreeSurfaceSeries3D#unconstrained-free-surface-3d-type) **Free Surface Series** types in the corresponding articles.
