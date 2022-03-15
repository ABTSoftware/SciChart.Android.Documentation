package com.scichart.docsandbox.examples.kotlin

import com.scichart.docsandbox.examples.kotlin.annotationsAPIs.*
import com.scichart.docsandbox.examples.kotlin.axis3DAPIs.Axis3DAPIs
import com.scichart.docsandbox.examples.kotlin.axisAPIs.AxisAPIs
import com.scichart.docsandbox.examples.kotlin.chartModifier2D.ChartModifier2D
import com.scichart.docsandbox.examples.kotlin.chartModifier3D.ChartModifier3D
import com.scichart.docsandbox.examples.kotlin.series2d.*

val ExamplesKotlin = listOf<Class<*>>(
    // region series2D
    BandSeries2D::class.java,
    BubbleSeries2D::class.java,
    CandlestickSeries2D::class.java,
    ColumnSeries2D::class.java,
    DonutChart2D::class.java,
    ErrorBarSeries2D::class.java,
    FixedErrorBarSeries2D::class.java,
    ImpulseSeries2D::class.java,
    LineSeries2D::class.java,
    MountainSeries2D::class.java,
    OhlcSeries2D::class.java,
    PieChart2D::class.java,
    ScatterSeries2D::class.java,
    SplineBandSeries2D::class.java,
    SplineLineSeries2D::class.java,
    SplineLineSeriesWithPointMarkers2D::class.java,
    StackedColumnSeries2D::class.java,
    StackedMountainSeries2D::class.java,
    UniformHeatmapSeries2D::class.java,
    // endregion

    // region chartModifier3D
    ChartModifier2D::class.java,
    // endregion

    // region chartModifier3D
    ChartModifier3D::class.java,
    // endregion

    // region annotationsAPIs
    AxisLabelAnnotationFragment::class.java,
    AxisMarkerAnnotationFragment::class.java,
    BoxAnnotationFragment::class.java,
    CustomAnnotationFragment::class.java,
    HorizontalLineAnnotationFragment::class.java,
    LineAnnotationFragment::class.java,
    LineArrowAnnotationFragment::class.java,
    TextAnnotationFragment::class.java,
    VerticalLineAnnotationFragment::class.java,
    // endregion

    // region annotationsAPIs
    Axis3DAPIs::class.java,
    // endregion

    // region annotationsAPIs
    AxisAPIs::class.java
    // endregion
)

