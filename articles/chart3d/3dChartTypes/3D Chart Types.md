---
uid: "chart3d.3DChartTypes"
---

# 3D Chart Types

All 3D Chart types in SciChart Android provided by the **RenderableSeries 3D API**.

The <xref:com.scichart.charting3d.visuals.renderableSeries.IRenderableSeries3D> is the visual representation of the `[X, Y, Z]` underlying data provided by the corresponding <xref:com.scichart.charting3d.model.dataSeries.IDataSeries3D>.

All **RenderableSeries** are inherited from <xref:com.scichart.charting3d.visuals.renderableSeries.BaseRenderableSeries3D> and are added to the <xref:com.scichart.charting.model.RenderableSeriesCollection> which is stored in [renderableSeries](xref:com.scichart.charting3d.visuals.ISciChartSurface3D.getRenderableSeries()) property. This collection supports multiple **RenderableSeries** instances of different types. Each RenderableSeries is rendered to the screen, displaying the data from an associated <xref:com.scichart.charting3d.model.dataSeries.IDataSeries3D>.

The list of **3D RenderableSeries** provided out of the box is available below:
- [The PointLine Series 3D](xref:chart3d.PointLineSeries3D)
- [The Scatter Series 3D](xref:chart3d.ScatterSeries3D)
- [The Bubble Series 3D](xref:chart3d.BubbleSeries3D)
- [The Column Series 3D](xref:chart3d.ColumnSeries3D)
- [The Impulse Series 3D](xref:chart3d.ImpulseSeries3D)
- [The Waterfall Series 3D](xref:chart3d.WaterfallSeries3D)
- [The Free Surface Series 3D](xref:chart3d.FreeSurfaceSeries3D)
- [The Surface Mesh Series 3D](xref:chart3d.SurfaceMeshSeries3D)

Read on to learn more about the features, that all [RenderableSeries 3D have in common](#common-renderableseries-3d-features). For specific features of any **RenderableSeries** - please refer to a corresponding article on this series type.

## Common RenderableSeries 3D Features
As mentioned above - all 3D series types in SciChart Android conforms to the <xref:com.scichart.charting3d.visuals.renderableSeries.IRenderableSeries3D> protocol. The list of some common features shared by all the series types can be found below:

| **Feature**                                  | **Description**                                                                            |
| -------------------------------------------- | ------------------------------------------------------------------------------------------ |
| [dataSeries](xref:com.scichart.charting3d.visuals.renderableSeries.IRenderableSeries3D.setDataSeries(com.scichart.charting3d.model.dataSeries.IDataSeries3D))          | A DataSeries is the ***data-source*** for a RenderableSeries 3D. Please see the <xref:com.scichart.charting3d.model.dataSeries.IDataSeries3D> API documentation for more info. |
| [isVisible](xref:com.scichart.charting.visuals.renderableSeries.IRenderableSeriesCore.setIsVisible(boolean))         | Allows to hide or show a series.                                                           |
| [isSelected](xref:com.scichart.charting.visuals.renderableSeries.IRenderableSeriesCore.setIsSelected(boolean))        | A series can be made Selected to be drawn on the top of other RenderableSeries.            |
| [pointMarker](xref:com.scichart.charting3d.visuals.renderableSeries.IRenderableSeries3D.setPointMarker(com.scichart.charting3d.visuals.pointMarkers.BasePointMarker3D))         | This feature lets you set an ***optional marker*** on data points, e.g. Ellipse, Square, Cube, etc.. Its usage is described minutely in the [PointMarker API](xref:chart3d.PointMarker3DAPI) article. |
| [metadataProvider](xref:com.scichart.charting3d.visuals.renderableSeries.IRenderableSeries3D.setMetadataProvider(com.scichart.charting3d.visuals.renderableSeries.metadataProviders.IMetadataProvider3D))    | The MetadataProvider API allows changing the color of a series on a ***per-point*** basis. Please see the [MetadataProvider 3D API](xref:chart3d.MetadataProvider3DAPI) article for more information. |
| [seriesInfoProvider](xref:com.scichart.charting3d.visuals.renderableSeries.IRenderableSeries3D.setSeriesInfoProvider(com.scichart.charting3d.visuals.renderableSeries.hitTest.ISeriesInfo3DProvider))  | Allows to customize the result of inspection of a series by [Chart Modifiers 3D](Chart Modifier 3D APIs.html). Also can be used to specify how modifiers tooltips have to appear for this series. Please refer to the [Cursors and Tooltips](xref:chartModifier3DAPIs.InteractivityTooltipModifier3D#customizing-tooltip-modifier-3d-tooltips) section for more info. |
| [seriesColor](xref:com.scichart.charting3d.visuals.renderableSeries.IRenderableSeries3D.getSeriesColor())         | Allows to specify the **color** which will be used while drawing this series.              |
| TODO: change link to IRenderableSeries3D after update SciChart lib [selectedVertexColor](xref:com.scichart.charting3d.visuals.renderableSeries.BaseRenderableSeries3D.setSelectedVertexColor(int)) | Allows to specify the **color** for **selected vertexes**. Please refer to the [Vertex Selection Modifier 3D](xref:chartModifier3DAPIs.InteractivityVertexSelectionModifier3D) article for more details. |
| [shininess](xref:com.scichart.charting3d.visuals.renderableSeries.IRenderableSeries3D.setShininess(float))           | Defines how much the surface material is shining. Expect value in `[0.0f...1024.0]` range. |
| [specularStrength](xref:com.scichart.charting3d.visuals.renderableSeries.IRenderableSeries3D.setSpecularStrength(float))    | Defines how bright and visible is the shining spot.                                        |
| [specularColor](xref:com.scichart.charting3d.visuals.renderableSeries.IRenderableSeries3D.setSpecularColor(int))       | Defines the material specular color.                                                       |
| [diffuseColor](xref:com.scichart.charting3d.visuals.renderableSeries.IRenderableSeries3D.setDiffuseColor(int))        | Defines the material diffuse color.                                                        |

> [!NOTE]
> You might want to visit our API documentation for the above properties, which is available on the <xref:com.scichart.charting3d.visuals.renderableSeries.IRenderableSeries3D> page.

For more comprehensive walkthrough into any feature or specifics of any series type please refer to articles on that series type. The list of the **series types available** out of the box can be found at the beginning of this article.