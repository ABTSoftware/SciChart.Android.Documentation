package com.scichart.docsandbox.examples.kotlin.series2d

import android.graphics.Color
import com.scichart.charting.model.dataSeries.XyDataSeries
import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.annotations.HorizontalLineAnnotation
import com.scichart.charting.visuals.annotations.IAnnotation
import com.scichart.charting.visuals.axes.NumericAxis
import com.scichart.charting.visuals.pointmarkers.EllipsePointMarker
import com.scichart.charting.visuals.renderableSeries.FastLineRenderableSeries
import com.scichart.charting.visuals.renderableSeries.FastMountainRenderableSeries
import com.scichart.charting.visuals.renderableSeries.XyRenderableSeriesBase
import com.scichart.charting.visuals.renderableSeries.XyScatterRenderableSeries
import com.scichart.charting.visuals.renderableSeries.data.XyRenderPassData
import com.scichart.charting.visuals.renderableSeries.paletteProviders.IFillPaletteProvider
import com.scichart.charting.visuals.renderableSeries.paletteProviders.IPointMarkerPaletteProvider
import com.scichart.charting.visuals.renderableSeries.paletteProviders.IStrokePaletteProvider
import com.scichart.charting.visuals.renderableSeries.paletteProviders.PaletteProviderBase
import com.scichart.core.framework.UpdateSuspender
import com.scichart.core.model.IntegerValues
import com.scichart.data.model.DoubleRange
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.DataManager
import com.scichart.docsandbox.examples.base.DoubleSeries
import com.scichart.docsandbox.examples.base.SingleChart2DFragment
import com.scichart.drawing.common.SolidBrushStyle
import com.scichart.drawing.common.SolidPenStyle
import java.util.*

@ExampleDefinition()
class PaletteProviderAPI : SingleChart2DFragment() {
    val dataManager = DataManager()
    
    override fun initExample(surface: SciChartSurface) {
        usePaletteProvider(surface)
    }

    // <CreatePaletteProvider>
    class SharedPaletteProvider(private val lowerLimit: IAnnotation, private val upperLimit: IAnnotation) : PaletteProviderBase<XyRenderableSeriesBase>(XyRenderableSeriesBase::class.java), IFillPaletteProvider, IStrokePaletteProvider, IPointMarkerPaletteProvider {
        private val strokeColors = IntegerValues()
        private val fillColors = IntegerValues()

        override fun update() {
            val y1 = lowerLimit.y1 as Double
            val y2 = upperLimit.y2 as Double

            val minimum = Math.min(y1, y2)
            val maximum = Math.max(y1, y2)

            val renderPassData = renderableSeries!!.currentRenderPassData as XyRenderPassData
            val size = renderPassData.pointsCount()
            strokeColors.setSize(size)
            fillColors.setSize(size)

            val yValues = renderPassData.yValues
            for (i in 0 until size) {
                val value = yValues[i]
                if (value > maximum) {
                    strokeColors[i] = -0x10000
                    fillColors[i] = -0x10000
                } else if (value < minimum) {
                    strokeColors[i] = -0xff0100
                    fillColors[i] = -0x66ff0100
                } else {
                    strokeColors[i] = -0x100
                    fillColors[i] = -0x66000100
                }
            }
        }

        override fun getStrokeColors(): IntegerValues {
            return strokeColors
        }

        override fun getFillColors(): IntegerValues {
            return fillColors
        }

        override fun getPointMarkerColors(): IntegerValues {
            return fillColors
        }
    }
    // </CreatePaletteProvider>

    fun usePaletteProvider(surface: SciChartSurface) {
        // <UsePaletteProvider>
        val xAxis = NumericAxis(requireContext())
        xAxis.growBy = DoubleRange(0.1, 0.1)

        val yAxis = NumericAxis(requireContext())
        yAxis.growBy = DoubleRange(0.1, 0.1)

        val upperLimit = HorizontalLineAnnotation(requireContext())
        upperLimit.setIsEditable(true)
        upperLimit.stroke = SolidPenStyle(Color.RED, false, 2f, null)
        upperLimit.y1 = 2.7

        val lowerLimit = HorizontalLineAnnotation(requireContext())
        lowerLimit.setIsEditable(true)
        lowerLimit.stroke = SolidPenStyle(Color.GREEN, false, 2f, null)
        lowerLimit.y1 = 2.5

        val data1: DoubleSeries = dataManager.getFourierSeries(1.0, 0.1, 5.02, 5.4, 5000)
        val data2: DoubleSeries = dataManager.getFourierSeries(1.0, 0.1, 6.02, 6.4, 5000)
        val data3: DoubleSeries = dataManager.getFourierSeries(1.0, 0.1, 7.02, 7.4, 5000)

        val dataSeries1: XyDataSeries<Double, Double> = XyDataSeries(Double::class.java, Double::class.java)
        val dataSeries2: XyDataSeries<Double, Double> = XyDataSeries(Double::class.java, Double::class.java)
        val dataSeries3: XyDataSeries<Double, Double> = XyDataSeries(Double::class.java, Double::class.java)

        dataSeries1.append(data1.xValues, data1.yValues)
        dataSeries2.append(data2.xValues, data2.yValues)
        dataSeries3.append(data3.xValues, data3.yValues)

        val sharedPaletteProvider = SharedPaletteProvider(lowerLimit, upperLimit)
        val lineSeries = FastLineRenderableSeries()
        lineSeries.paletteProvider = sharedPaletteProvider
        lineSeries.dataSeries = dataSeries1
        lineSeries.strokeStyle = SolidPenStyle(-0xd864d9, false, 1.0f, null)

        val marker = EllipsePointMarker()
        marker.setSize(20, 20)
        marker.strokeStyle = SolidPenStyle(Color.BLUE, false, 3.0f, null)
        marker.fillStyle = SolidBrushStyle(Color.BLUE)

        val scatterSeries = XyScatterRenderableSeries()
        scatterSeries.pointMarker = marker
        scatterSeries.paletteProvider = sharedPaletteProvider
        scatterSeries.dataSeries = dataSeries2
        scatterSeries.strokeStyle = SolidPenStyle(-0xd864d9, false, 1.0f, null)

        val mountainSeries = FastMountainRenderableSeries()
        scatterSeries.paletteProvider = sharedPaletteProvider
        mountainSeries.dataSeries = dataSeries3
        mountainSeries.strokeStyle = SolidPenStyle(-0xd864d9, false, 1.0f, null)

        UpdateSuspender.using(surface) {
            surface.xAxes.add(xAxis)
            surface.yAxes.add(yAxis)
            Collections.addAll(surface.renderableSeries, lineSeries, scatterSeries, mountainSeries)
            Collections.addAll(surface.annotations, lowerLimit, upperLimit)
            surface.chartModifiers.add(createDefaultModifiers())
        }
        // </UsePaletteProvider>
    }
}
