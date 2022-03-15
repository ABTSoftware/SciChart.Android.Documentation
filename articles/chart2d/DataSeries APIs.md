---
uid: "chart2d.DataSeriesAPIs"
---

# DataSeries Types in SciChart
SciChart features a proprietary **DataSeries API**, which internally uses the fastest possible data-structures to allow fast manipulation of data bound to charts.

Our DataSeries are highly optimized data-structures for **indexing**, **searching** and **iterating** over data, enabling SciChart to achieve its record performance!

The following DataSeries types exist in SciChart Android.

> [!NOTE]
> Allowable types in SciChart include Date, double, float, long, int, short, byte.

| **Data Series Type**                                           | **Series Applicable**                                           |
| -------------------------------------------------------------- | --------------------------------------------------------------- |
| <xref:com.scichart.charting.model.dataSeries.XyDataSeries> - stores X and Y Data                        | <xref:com.scichart.charting.visuals.renderableSeries.FastLineRenderableSeries>, <xref:com.scichart.charting.visuals.renderableSeries.FastMountainRenderableSeries>, <xref:com.scichart.charting.visuals.renderableSeries.XyScatterRenderableSeries>, <xref:com.scichart.charting.visuals.renderableSeries.FastColumnRenderableSeries>, <xref:com.scichart.charting.visuals.renderableSeries.FastImpulseRenderableSeries> and <xref:com.scichart.charting.visuals.renderableSeries.FastFixedErrorBarsRenderableSeries> |
| <xref:com.scichart.charting.model.dataSeries.XyyDataSeries> - stores X, Y and Y1 Data                   | **<xref:com.scichart.charting.visuals.renderableSeries.FastBandRenderableSeries> (required)**. Can also apply to <xref:com.scichart.charting.visuals.renderableSeries.FastLineRenderableSeries>, <xref:com.scichart.charting.visuals.renderableSeries.FastMountainRenderableSeries>, <xref:com.scichart.charting.visuals.renderableSeries.XyScatterRenderableSeries>, <xref:com.scichart.charting.visuals.renderableSeries.FastColumnRenderableSeries>, <xref:com.scichart.charting.visuals.renderableSeries.FastImpulseRenderableSeries> and <xref:com.scichart.charting.visuals.renderableSeries.FastFixedErrorBarsRenderableSeries>. In this case only the X and Y value are chosen |
| <xref:com.scichart.charting.model.dataSeries.XyzDataSeries> - stores X, Y and Z Data                    | **<xref:com.scichart.charting.visuals.renderableSeries.FastBubbleRenderableSeries> (required)**. Can also apply to <xref:com.scichart.charting.visuals.renderableSeries.FastLineRenderableSeries>, <xref:com.scichart.charting.visuals.renderableSeries.FastMountainRenderableSeries>, <xref:com.scichart.charting.visuals.renderableSeries.XyScatterRenderableSeries>, <xref:com.scichart.charting.visuals.renderableSeries.FastColumnRenderableSeries>, <xref:com.scichart.charting.visuals.renderableSeries.FastImpulseRenderableSeries> and <xref:com.scichart.charting.visuals.renderableSeries.FastFixedErrorBarsRenderableSeries>. In this case only the X and Z value are chosen |
| <xref:com.scichart.charting.model.dataSeries.HlDataSeries> - stores X, Y, High and Low Data             | **<xref:com.scichart.charting.visuals.renderableSeries.FastErrorBarsRenderableSeries> (required)**. Can also apply to <xref:com.scichart.charting.visuals.renderableSeries.FastLineRenderableSeries>, <xref:com.scichart.charting.visuals.renderableSeries.FastMountainRenderableSeries>, <xref:com.scichart.charting.visuals.renderableSeries.XyScatterRenderableSeries>, <xref:com.scichart.charting.visuals.renderableSeries.FastColumnRenderableSeries>, <xref:com.scichart.charting.visuals.renderableSeries.FastImpulseRenderableSeries> and <xref:com.scichart.charting.visuals.renderableSeries.FastFixedErrorBarsRenderableSeries>. In this case only the X and Y values are chosen |
| <xref:com.scichart.charting.model.dataSeries.OhlcDataSeries> - stores X, Open, High, Low and Close Data | **<xref:com.scichart.charting.visuals.renderableSeries.FastCandlestickRenderableSeries> or <xref:com.scichart.charting.visuals.renderableSeries.FastOhlcRenderableSeries> (required)**.  Can also apply to <xref:com.scichart.charting.visuals.renderableSeries.FastLineRenderableSeries>, <xref:com.scichart.charting.visuals.renderableSeries.FastMountainRenderableSeries>, <xref:com.scichart.charting.visuals.renderableSeries.XyScatterRenderableSeries>, <xref:com.scichart.charting.visuals.renderableSeries.FastColumnRenderableSeries>, <xref:com.scichart.charting.visuals.renderableSeries.FastImpulseRenderableSeries> and <xref:com.scichart.charting.visuals.renderableSeries.FastFixedErrorBarsRenderableSeries>. In this case only the X and Close values are chosen |
| <xref:com.scichart.charting.model.dataSeries.UniformHeatmapDataSeries> - stores TY values as array of TY, and TX, TZ values are computed from cell index, Start and Step values | **<xref:com.scichart.charting.visuals.renderableSeries.FastUniformHeatmapRenderableSeries> (required)**. This DataSeries type is not applicable to any other `RenderableSeries` |

## Manipulating DataSeries Data
Data in <xref:com.scichart.charting.model.dataSeries.IDataSeries> may be manipulated using the **[Append, Insert, Update, Remove](#append-insert-update-remove)** functions. 

In addition, [xRange and yRange](#x-and-y-ranges) may be accessed as well as any of the [underlying data may be directly accessed](#accessing-x-y-other-values).

Also, DataSeries feature two modes: standard and [FIFO (First in first out)](#fifo-first-in-first-out-dataseries). In FIFO mode data may be streamed and old data-points discarded as new arrive.

Finally, you can control [Data Distribution](#dataseries-data-distribution) using <xref:com.scichart.charting.model.datadistributioncalculator.IDataDistributionCalculator>.

The following sections show how you can manipulate data in the **DataSeries** types in SciChart.

### Append, Insert, Update, Remove
All DataSeries types include **Append, Insert, Update, Remove** methods. Many of these also have overloads which accept a range of data, e.g. the <xref:com.scichart.charting.model.dataSeries.IXyDataSeries> protocol has the following:
  - <xref:com.scichart.charting.model.dataSeries.IXyDataSeries.append(TX,TY)>
  - <xref:com.scichart.charting.model.dataSeries.IXyDataSeries.append(TX[],TY[])>
  - <xref:com.scichart.charting.model.dataSeries.IXyDataSeries.append(com.scichart.core.model.IValues&lt;TX&gt;,com.scichart.core.model.IValues&lt;TY&gt;)>
  - <xref:com.scichart.charting.model.dataSeries.IXyDataSeries.append(java.lang.Iterable&lt;TX&gt;,java.lang.Iterable&lt;TY&gt;)>
  - <xref:com.scichart.charting.model.dataSeries.IXyDataSeries.insert(int,TX,TY)>
  - <xref:com.scichart.charting.model.dataSeries.IXyDataSeries.insertRange(int,TX[],TY[])>
  - <xref:com.scichart.charting.model.dataSeries.IXyDataSeries.insertRange(int,com.scichart.core.model.IValues&lt;TX&gt;,com.scichart.core.model.IValues&lt;TY&gt;)>
  - <xref:com.scichart.charting.model.dataSeries.IXyDataSeries.insertRange(int,java.lang.Iterable&lt;TX&gt;,java.lang.Iterable&lt;TY&gt;)>
  - <xref:com.scichart.charting.model.dataSeries.IXyDataSeries.updateRangeXAt(int,TX[])>
  - <xref:com.scichart.charting.model.dataSeries.IXyDataSeries.updateRangeXAt(int,com.scichart.core.model.IValues&lt;TX&gt;)>
  - <xref:com.scichart.charting.model.dataSeries.IXyDataSeries.updateRangeXAt(int,java.lang.Iterable&lt;TX&gt;)>
  - <xref:com.scichart.charting.model.dataSeries.IXyDataSeries.updateRangeXyAt(int,TX[],TY[])>
  - <xref:com.scichart.charting.model.dataSeries.IXyDataSeries.updateRangeXyAt(int,com.scichart.core.model.IValues&lt;TX&gt;,com.scichart.core.model.IValues&lt;TY&gt;)>
  - <xref:com.scichart.charting.model.dataSeries.IXyDataSeries.updateRangeXyAt(int,java.lang.Iterable&lt;TX&gt;,java.lang.Iterable&lt;TY&gt;)>
  - <xref:com.scichart.charting.model.dataSeries.IXyDataSeries.updateRangeYAt(int,TY[])>
  - <xref:com.scichart.charting.model.dataSeries.IXyDataSeries.updateRangeYAt(int,com.scichart.core.model.IValues&lt;TY&gt;)>
  - <xref:com.scichart.charting.model.dataSeries.IXyDataSeries.updateRangeYAt(int,java.lang.Iterable&lt;TY&gt;)>
  - <xref:com.scichart.charting.model.dataSeries.IXyDataSeries.updateXAt(int,TX)>
  - <xref:com.scichart.charting.model.dataSeries.IXyDataSeries.updateXyAt(int,TX,TY)>
  - <xref:com.scichart.charting.model.dataSeries.IXyDataSeries.updateYAt(int,TY)>

Other DataSeries have similar methods appropriate to underlying data which they hold.

> [!NOTE]
> It is highly recommended to use set of methods, which works with our <xref:com.scichart.core.model.IValues> data-structures, to achieve better performance and omit boxing/unboxing into Cocoa native types.

### X and Y Ranges
All DataSeries types expose the XRange and YRange of the underlying DataSeries as well as corresponding Max and Min values.
See the following methods:
- [xMin](xref:com.scichart.charting.model.dataSeries.IDataSeries.getXMin())
- [xMax](xref:com.scichart.charting.model.dataSeries.IDataSeries.getXMax())
- [xRange](xref:com.scichart.charting.model.dataSeries.IDataSeries.getXRange())
- [yMin](xref:com.scichart.charting.model.dataSeries.IDataSeries.getYMin())
- [yMax](xref:com.scichart.charting.model.dataSeries.IDataSeries.getYMax())
- [yRange](xref:com.scichart.charting.model.dataSeries.IDataSeries.getYRange())

> [!NOTE]
> These perform a calculation every time the property is accessed, so should be used sparingly.

# [Java](#tab/java)
[!code-java[XYRanges](../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/series2d/DataSeriesAPIs.java#XYRanges)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[XYRanges](../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/series2d/DataSeriesAPIs.java#XYRanges)]
# [Kotlin](#tab/kotlin)
[!code-swift[XYRanges](../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/series2d/DataSeriesAPIs.kt#XYRanges)]
***

### Accessing X, Y, [other] Values
All DataSeries types expose the lists of underlying data. There is a set of protocols, which provides an access for the underlying data, which names has a pattern as follows: `I[Something]DataSeriesValues`, e.g.:
- <xref:com.scichart.charting.model.dataSeries.IXDataSeriesValues> - provides an access to the `xValues`.
- <xref:com.scichart.charting.model.dataSeries.IXyDataSeriesValues> - provides an access to the `yValues` (in addition to `xValues`).

Those are read-only <xref:com.scichart.data.model.ISciList>s. Data can be accessed by casting to the underlying list type, e.g. <xref:com.scichart.data.model.ISciListDouble>.

# [Java](#tab/java)
[!code-java[AccessingValues](../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/series2d/DataSeriesAPIs.java#AccessingValues)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[AccessingValues](../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/series2d/DataSeriesAPIs.java#AccessingValues)]
# [Kotlin](#tab/kotlin)
[!code-swift[AccessingValues](../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/series2d/DataSeriesAPIs.kt#AccessingValues)]
***

### Fifo (First-In-First-Out) DataSeries
DataSeries allow **First-In-First-Out** behaviour, where a **maximum capacity** is set, once reached, old data-points **are discarded**. To declare a Fifo dataseries, simply set the [fifoCapacity](xref:com.scichart.charting.model.dataSeries.IDataSeries.setFifoCapacity(java.lang.Integer)) property.

# [Java](#tab/java)
[!code-java[SetFifoCapacity](../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/series2d/DataSeriesAPIs.java#SetFifoCapacity)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[SetFifoCapacity](../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/series2d/DataSeriesAPIs.java#SetFifoCapacity)]
# [Kotlin](#tab/kotlin)
[!code-swift[SetFifoCapacity](../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/series2d/DataSeriesAPIs.kt#SetFifoCapacity)]
***

Considering the code above, the behaviour will be the following. Once the **1001-st** point have been added, the **very first** point will be **discarded**. Appending **another 5 points**, the next **oldest 5 points will be discarded**. The window continues to scroll no matter how many points are appended and **memory never increases beyond 1000 points**.

Fifo DataSeries are a very memory and CPU efficient way of scrolling and discarding old data and creating scrolling, streaming charts.

### DataSeries Data Distribution
The <xref:com.scichart.charting.model.datadistributioncalculator.IDataDistributionCalculator> is a protocol which determines the distribution of your data (sorted in X or not, evenly spaced in X or not) and the flags are used to determine the correct algorithm(s) for [resampling](xref:chart2d.DataResampling), [hit-testing](xref:chart2d.HitTestAPI) and indexing of data.

By default, this all works automatically, however, if you want to **save a few CPU cycles** and you know in advance the distribution of your data, you can override the flags as follows:

# [Java](#tab/java)
[!code-java[SetDataDistribution](../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/series2d/DataSeriesAPIs.java#SetDataDistribution)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[SetDataDistribution](../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/series2d/DataSeriesAPIs.java#SetDataDistribution)]
# [Kotlin](#tab/kotlin)
[!code-swift[SetDataDistribution](../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/series2d/DataSeriesAPIs.kt#SetDataDistribution)]
***

#### DataSeries AcceptsUnsortedData
By default, DataSeries are designed to throw an exception if data is appended unsorted in X. This is because unsorted data is detrimental to performance, and many people were unintentionally appending data unsorted in the X-direction.

SciChart can however accept unsorted data, you just need to specify the flag [acceptsUnsortedData](xref:com.scichart.charting.model.dataSeries.IDataSeries.setAcceptsUnsortedData(boolean)) = true. This will signal to SciChart that your appending of unsorted data was intentional and the chart will then draw it.

# [Java](#tab/java)
[!code-java[SetAcceptsUnsortedData](../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/series2d/DataSeriesAPIs.java#SetAcceptsUnsortedData)]
# [Java with Builders API](#tab/javaBuilder)
[!code-java[SetAcceptsUnsortedData](../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/javaBuilder/series2d/DataSeriesAPIs.java#SetAcceptsUnsortedData)]
# [Kotlin](#tab/kotlin)
[!code-swift[SetAcceptsUnsortedData](../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/series2d/DataSeriesAPIs.kt#SetAcceptsUnsortedData)]
***
