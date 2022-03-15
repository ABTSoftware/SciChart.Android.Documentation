package com.scichart.docsandbox.examples.kotlin.chartModifier2D

import android.content.Context
import android.graphics.drawable.PaintDrawable
import com.scichart.charting.modifiers.SeriesValueModifier
import com.scichart.charting.modifiers.SeriesValueModifier.*
import com.scichart.charting.numerics.coordinateCalculators.ICoordinateCalculator
import com.scichart.charting.visuals.ISciChartSurface
import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.annotations.AnnotationLabel
import com.scichart.charting.visuals.annotations.HorizontalLineAnnotation
import com.scichart.charting.visuals.annotations.LabelPlacement
import com.scichart.charting.visuals.renderableSeries.IRenderableSeries
import com.scichart.core.IServiceContainer
import com.scichart.core.common.Predicate
import com.scichart.core.utility.Dispatcher
import com.scichart.core.utility.ListUtil
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment
import com.scichart.drawing.common.FontStyle
import com.scichart.drawing.common.SolidPenStyle
import com.scichart.drawing.utility.ColorUtil

@ExampleDefinition()
class SeriesValueModifierFragment : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {}

    fun createSeriesValueModifier(surface: SciChartSurface) {
        // <CreateSeriesValueModifier>
        // Assume a surface has been created and configured somewhere
        // Create a modifier
        var seriesValueModifier = SeriesValueModifier()

        // Add the modifier to the surface
        surface.chartModifiers.add(seriesValueModifier)
        // </CreateSeriesValueModifier>
    }

    fun excludingSeries(surface: SciChartSurface) {
        // <ExcludingSeries>
        // Assume renderable series with name "Blue Series" has been created and configured somewhere
        // Create a factory with a predicate
        val factory = DefaultSeriesValueMarkerFactory { series: IRenderableSeries ->
            series.dataSeries.seriesName === "Blue Series"
        }

        // Create seriesValueModifier with this factory
        val seriesValueModifier = SeriesValueModifier(factory)

        // Add the modifier to the surface
        surface.chartModifiers.add(seriesValueModifier)
        // </ExcludingSeries>
    }

    fun createSeriesValueModifierWithCustomFactory(surface: SciChartSurface) {
        // <CreateHorizontalLineSeriesValueMarkerAnnotation>
        class HorizontalLineSeriesValueMarkerAnnotation(
            context: Context,
            val seriesValueHelper: DefaultSeriesValueMarkerAnnotationHelper<HorizontalLineSeriesValueMarkerAnnotation>
        ) : HorizontalLineAnnotation(context) {
            override fun attachTo(services: IServiceContainer) {
                val renderableSeries = seriesValueHelper.renderableSeries
                xAxisId = renderableSeries.xAxisId
                yAxisId = renderableSeries.yAxisId

                super.attachTo(services)
            }

            override fun update(xCalc: ICoordinateCalculator, yCalc: ICoordinateCalculator) {
                seriesValueHelper.tryUpdateAnnotation(this)

                super.update(xCalc, yCalc)
            }
        }
        // </CreateHorizontalLineSeriesValueMarkerAnnotation>

        // <CreateHorizontalLineSeriesValueMarkerAnnotationHelper>
        class HorizontalLineSeriesValueMarkerAnnotationHelper(
            renderableSeries: IRenderableSeries,
            isValidRenderableSeriesPredicate: Predicate<IRenderableSeries?>
        ) : DefaultSeriesValueMarkerAnnotationHelper<HorizontalLineSeriesValueMarkerAnnotation>(
                renderableSeries,
                isValidRenderableSeriesPredicate
            ) {
            private val lineThickness = convertValueToDp(1f)
            private val dashPattern = floatArrayOf(convertValueToDp(4f), convertValueToDp(4f))

            override fun updateAnnotation(
                annotation: HorizontalLineSeriesValueMarkerAnnotation,
                lastValue: Comparable<*>,
                lastColor: Int
            ) {
                super.updateAnnotation(annotation, lastValue, lastColor)

                Dispatcher.postOnUiThread {
                    annotation.stroke = SolidPenStyle(lastColor, false, lineThickness, dashPattern)
                    val count = annotation.annotationLabels.size
                    for (i in 0 until count) {
                        val label = annotation.annotationLabels[i]
                        label.background = PaintDrawable(lastColor)
                        label.fontStyle = FontStyle(convertValueToDp(12f), ColorUtil.getInvertedColor(lastColor))
                    }
                }
            }
        }
        // </CreateHorizontalLineSeriesValueMarkerAnnotationHelper>

        // <CreateHorizontalLineSeriesValueMarker>
        class HorizontalLineSeriesValueMarker(
            renderableSeries: IRenderableSeries,
            isValidRenderableSeriesPredicate: Predicate<IRenderableSeries?>
        ) : SeriesValueMarkerBase(renderableSeries, isValidRenderableSeriesPredicate) {
            private var markerAnnotation: HorizontalLineSeriesValueMarkerAnnotation? = null

            override fun tryRemoveMarkerAnnotation(parentSurface: ISciChartSurface) {
                parentSurface.annotations.remove(markerAnnotation)
            }

            override fun tryAddMarkerAnnotation(parentSurface: ISciChartSurface) {
                ListUtil.safeAddExact(parentSurface.annotations, markerAnnotation)
            }

            override fun createMarkerAnnotation(context: Context) {
                markerAnnotation = HorizontalLineSeriesValueMarkerAnnotation(
                    context,
                    HorizontalLineSeriesValueMarkerAnnotationHelper(
                        renderableSeries,
                        isValidRenderableSeriesPredicate
                    )
                )
                val label = AnnotationLabel(context)
                label.labelPlacement = LabelPlacement.Axis
                markerAnnotation?.annotationLabels?.add(label)
            }

            override fun destroyMarkerAnnotation() {
                markerAnnotation = null
            }
        }
        // </CreateHorizontalLineSeriesValueMarker>

        // <CreateHorizontalLineSeriesValueMarkerFactory>
        class HorizontalLineSeriesValueMarkerFactory(private val isValidSeriesPredicate: Predicate<IRenderableSeries?>) :
            ISeriesValueMarkerFactory {
            override fun createMarkerFor(renderableSeries: IRenderableSeries): ISeriesValueMarker {
                return HorizontalLineSeriesValueMarker(renderableSeries, isValidSeriesPredicate)
            }
        }
        // </CreateHorizontalLineSeriesValueMarkerFactory>

        // <CreateSeriesValueModifierWithCustomFactory>
        val seriesValueModifier = SeriesValueModifier(
            HorizontalLineSeriesValueMarkerFactory { item: IRenderableSeries? -> true }
        )
        surface.chartModifiers.add(seriesValueModifier)
        // </CreateSeriesValueModifierWithCustomFactory>
    }
}
