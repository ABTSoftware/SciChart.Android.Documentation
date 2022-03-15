package com.scichart.docsandbox.examples.kotlin.series2d

import android.view.LayoutInflater
import com.scichart.charting.model.dataSeries.UniformHeatmapDataSeries
import com.scichart.charting.modifiers.CursorModifier
import com.scichart.charting.modifiers.ModifierGroup
import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.axes.NumericAxis
import com.scichart.charting.visuals.renderableSeries.ColorMap
import com.scichart.charting.visuals.renderableSeries.FastUniformHeatmapRenderableSeries
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.databinding.ExampleHeatmapChartFragmentBinding
import com.scichart.docsandbox.examples.base.ExampleBaseFragment
import com.scichart.drawing.utility.ColorUtil
import java.util.*

@ExampleDefinition()
class HeatmapSeries2D : ExampleBaseFragment<ExampleHeatmapChartFragmentBinding>() {
    private val WIDTH = 200
    private val HEIGHT = 300

    override fun inflateBinding(inflater: LayoutInflater): ExampleHeatmapChartFragmentBinding {
        return ExampleHeatmapChartFragmentBinding.inflate(inflater)
    }

    override fun initExample(binding: ExampleHeatmapChartFragmentBinding) {
        initExample(binding.surface)
    }

    fun createDefaultModifiers(): ModifierGroup {
        return sciChartBuilder.newModifierGroupWithDefaultModifiers().build()
    }

    // <Example>
    fun initExample(surface: SciChartSurface) {
        val xAxis = NumericAxis(requireContext())
        val yAxis = NumericAxis(requireContext())

        val dataSeries = UniformHeatmapDataSeries(Int::class.java, Int::class.java, Double::class.java, WIDTH, HEIGHT)

        val heatmapRenderableSeries = FastUniformHeatmapRenderableSeries()
        heatmapRenderableSeries.colorMap = ColorMap(
            intArrayOf(ColorUtil.DarkBlue, ColorUtil.CornflowerBlue, ColorUtil.DarkGreen, ColorUtil.Chartreuse, ColorUtil.Yellow, ColorUtil.Red),
            floatArrayOf(0f, 0.2f, 0.4f, 0.6f, 0.8f, 1f)
        )

        heatmapRenderableSeries.minimum = 0.0
        heatmapRenderableSeries.maximum = 200.0
        heatmapRenderableSeries.dataSeries = dataSeries

        val colourMap = binding.heatmapColourMap
        colourMap.minimum = heatmapRenderableSeries.minimum
        colourMap.maximum = heatmapRenderableSeries.maximum
        colourMap.colorMap = heatmapRenderableSeries.colorMap

        Collections.addAll(surface.xAxes, xAxis)
        Collections.addAll(surface.yAxes, yAxis)
        Collections.addAll(surface.renderableSeries, heatmapRenderableSeries)

        val cursor = CursorModifier()
        cursor.showTooltip = true
        cursor.receiveHandledEvents = true

        val modifiers = createDefaultModifiers()
        modifiers.childModifiers.add(cursor)

        Collections.addAll(surface.chartModifiers, modifiers)
    }
    // </Example>
}
