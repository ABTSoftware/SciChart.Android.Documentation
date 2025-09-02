package com.scichart.docsandbox.examples.kotlin.chartModifier2D

import android.content.Context
import android.text.SpannableStringBuilder
import com.scichart.charting.modifiers.TooltipModifier
import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.renderableSeries.FastLineRenderableSeries
import com.scichart.charting.visuals.renderableSeries.hitTest.DefaultXySeriesInfoProvider
import com.scichart.charting.visuals.renderableSeries.hitTest.XySeriesInfo
import com.scichart.charting.visuals.renderableSeries.tooltips.ISeriesTooltip
import com.scichart.charting.visuals.renderableSeries.tooltips.XySeriesTooltip
import com.scichart.core.utility.StringUtil
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment
import com.scichart.drawing.utility.ColorUtil

@ExampleDefinition()
class InteractivityTooltipModifier : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {}

    fun addTooltipModifier(surface: SciChartSurface) {
        // <AddTooltipModifier>
        // Assume a surface has been created and configured somewhere
        surface.chartModifiers.add(TooltipModifier())
        // </AddTooltipModifier>
    }

    fun useCustomTooltipModifier(fastLineRenderableSeries: FastLineRenderableSeries) {
        // <UseCustomTooltipModifier>
        // Assume a fastLineRenderableSeries has been created and configured somewhere
        fastLineRenderableSeries.seriesInfoProvider = CustomSeriesInfoProvider()
        // </UseCustomTooltipModifier>
    }

    // <CustomTooltipModifier>
    private class CustomSeriesInfoProvider : DefaultXySeriesInfoProvider() {
        override fun getSeriesTooltipInternal(context: Context, seriesInfo: XySeriesInfo<*>?, modifierType: Class<*>): ISeriesTooltip {
            return when (modifierType) {
                TooltipModifier::class.java -> { CustomXySeriesTooltip(context, seriesInfo) }
                else -> { super.getSeriesTooltipInternal(context, seriesInfo, modifierType) }
            }
        }

        private class CustomXySeriesTooltip(context: Context?, seriesInfo: XySeriesInfo<*>?) :
            XySeriesTooltip(context, seriesInfo) {
            override fun internalUpdate(seriesInfo: XySeriesInfo<*>) {
                val sb = SpannableStringBuilder()
                sb.append("X: ").append(seriesInfo.formattedXValue).append(StringUtil.NEW_LINE)
                sb.append("Y: ").append(seriesInfo.formattedYValue).append(StringUtil.NEW_LINE)

                seriesInfo.seriesName?.run {
                    sb.append(this).append(StringUtil.NEW_LINE)
                }
                sb.append("TooltipModifier")
                text = sb

                setTooltipBackgroundColor(0xff47bde6.toInt())
                setTooltipStroke(0xff21a0d8.toInt())
                setTooltipTextColor(ColorUtil.White)
            }
        }
    }
    // </CustomTooltipModifier>
}

