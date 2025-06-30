package com.scichart.docsandbox.examples.kotlin.series2d

import android.animation.FloatEvaluator
import android.content.Context
import android.text.SpannableStringBuilder
import android.view.View
import android.view.accessibility.AccessibilityEvent
import android.view.animation.DecelerateInterpolator
import com.scichart.charting.model.dataSeries.IXyDataSeries
import com.scichart.charting.model.dataSeries.XyDataSeries
import com.scichart.charting.modifiers.RolloverModifier
import com.scichart.charting.modifiers.ZoomExtentsModifier
import com.scichart.charting.modifiers.ZoomPanModifier
import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.animations.AnimationsHelper
import com.scichart.charting.visuals.animations.BaseRenderPassDataTransformation
import com.scichart.charting.visuals.animations.TransformationHelpers
import com.scichart.charting.visuals.renderableSeries.FastLineRenderableSeries
import com.scichart.charting.visuals.renderableSeries.data.LineRenderPassData
import com.scichart.charting.visuals.renderableSeries.hitTest.DefaultXySeriesInfoProvider
import com.scichart.charting.visuals.renderableSeries.hitTest.XySeriesInfo
import com.scichart.charting.visuals.renderableSeries.tooltips.ISeriesTooltip
import com.scichart.charting.visuals.renderableSeries.tooltips.XySeriesTooltip
import com.scichart.core.framework.UpdateSuspender
import com.scichart.core.model.FloatValues
import com.scichart.core.utility.StringUtil
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment
import com.scichart.drawing.utility.ColorUtil
import com.scichart.extensions.builders.SciChartBuilder
import java.util.*
import kotlin.math.sin

@ExampleDefinition()
class Accessibility : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {}

    private fun setChart() {
        SciChartBuilder.init(context)
        val sciChartBuilder = SciChartBuilder.instance()
        val xAxis = sciChartBuilder.newNumericAxis().build()
        val yAxis = sciChartBuilder.newNumericAxis().build()

        val dataSeries = XyDataSeries<Double, Double>(Double::class.javaObjectType, Double::class.javaObjectType)
        for (i in 0..10){
            dataSeries.append(
                i.toDouble(),
                sin(i.toDouble())
            )
        }
        val fcs = FastLineRenderableSeries()
        fcs.dataSeries = dataSeries
        fcs.seriesInfoProvider = FirstCustomSeriesInfoProvider()


        UpdateSuspender.using(binding.surface){
            Collections.addAll(binding.surface.xAxes, xAxis)
            Collections.addAll(binding.surface.yAxes, yAxis)
            Collections.addAll(binding.surface.renderableSeries, fcs)
            Collections.addAll(binding.surface.chartModifiers,
                RolloverModifier(),
                ZoomPanModifier(),
                ZoomExtentsModifier()
            )
        }

        // <AccessibilityEnable>
        binding.surface.importantForAccessibility = View.IMPORTANT_FOR_ACCESSIBILITY_YES
        xAxis.setVisibleRangeChangeListener { axis, oldRange, newRange, isAnimating -> // need to send this even to update position of rects on screen during scrolling
            binding.surface.announceForAccessibility("visible range changed")
            binding.surface.sendAccessibilityEvent(AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED)
        }
        // </AccessibilityEnable>

        yAxis.setVisibleRangeChangeListener { axis, oldRange, newRange, isAnimating -> // need to send this even to update position of rects on screen during scrolling
            binding.surface.sendAccessibilityEvent(AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED)
        }


    }

    // <AccessibilitySeriesInfo>
    private class FirstCustomSeriesInfoProvider() : DefaultXySeriesInfoProvider() {


        override fun getSeriesTooltipInternal(context: Context, seriesInfo: XySeriesInfo<*>, modifierType: Class<*>): ISeriesTooltip {
            return when (modifierType) {
                RolloverModifier::class.java -> { FirstCustomXySeriesTooltip(context, seriesInfo) }
                else -> { super.getSeriesTooltipInternal(context, seriesInfo, modifierType) }
            }
        }

        private class FirstCustomXySeriesTooltip(context: Context?, seriesInfo: XySeriesInfo<*>) :
            XySeriesTooltip(context, seriesInfo) {

            override fun internalUpdate(seriesInfo: XySeriesInfo<*>) {
                val sb = SpannableStringBuilder()
                sb.append("X is ").append(seriesInfo.formattedXValue).append(StringUtil.NEW_LINE)
                sb.append("Y is ").append(seriesInfo.formattedYValue).append(StringUtil.NEW_LINE)

                seriesInfo.seriesName?.run {
                    sb.append(this).append(StringUtil.NEW_LINE)
                }
                text = sb

                announceForAccessibility(sb.toString())

                setTooltipBackgroundColor(0xffe97064.toInt())
                setTooltipStroke(0xfff4840b.toInt())
                setTooltipTextColor(ColorUtil.White)
            }
        }
    }
    // </AccessibilitySeriesInfo>
}
