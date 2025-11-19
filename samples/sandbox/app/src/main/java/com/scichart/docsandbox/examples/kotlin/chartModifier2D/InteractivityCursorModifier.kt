package com.scichart.docsandbox.examples.kotlin.chartModifier2D

import android.content.Context
import android.text.SpannableStringBuilder
import android.util.TypedValue
import com.scichart.charting.modifiers.CursorModifier
import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.renderableSeries.FastLineRenderableSeries
import com.scichart.charting.visuals.renderableSeries.hitTest.DefaultXySeriesInfoProvider
import com.scichart.charting.visuals.renderableSeries.hitTest.XySeriesInfo
import com.scichart.charting.visuals.renderableSeries.tooltips.ISeriesTooltip
import com.scichart.charting.visuals.renderableSeries.tooltips.XySeriesTooltip
import com.scichart.core.utility.StringUtil
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment
import com.scichart.docsandbox.examples.kotlin.chartModifier2D.InteractivityTooltipModifier.CustomSeriesInfoProvider
import com.scichart.drawing.utility.ColorUtil
import kotlin.math.roundToInt

@ExampleDefinition()
class InteractivityCursorModifier : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {}

    fun addCursorModifier(surface: SciChartSurface) {
        // <AddCursorModifier>
        // Assume a surface has been created and configured somewhere
        surface.chartModifiers.add(CursorModifier())
        // </AddCursorModifier>
    }

    fun useCustomCursorModifier(fastLineRenderableSeries: FastLineRenderableSeries) {
        // <UseCustomCursorModifier>
        // Assume a fastLineRenderableSeries has been created and configured somewhere
        fastLineRenderableSeries.seriesInfoProvider = CustomSeriesInfoProvider()
        // </UseCustomCursorModifier>
    }

    fun includeExcludeSeries(cursorModifier: CursorModifier, seriesX: FastLineRenderableSeries, seriesY: FastLineRenderableSeries) {
        // <IncludeExcludeSeries>
        // Assume a cursorModifier has been created and configured somewhere

        // To include series in the cursorModifier
        cursorModifier.includeRenderableSeries(seriesX, true)

        // To exclude series from the cursorModifier
        cursorModifier.includeRenderableSeries(seriesY, false)
        // </IncludeExcludeSeries>
    }

    // <CustomCursorModifier>
    private class CustomSeriesInfoProvider : DefaultXySeriesInfoProvider() {
        override fun getSeriesTooltipInternal(context: Context, seriesInfo: XySeriesInfo<*>?, modifierType: Class<*>): ISeriesTooltip {
            return when (modifierType) {
                CursorModifier::class.java -> { CustomXySeriesTooltip(context, seriesInfo) }
                else -> { super.getSeriesTooltipInternal(context, seriesInfo, modifierType) }
            }
        }

        private class CustomXySeriesTooltip(context: Context?, seriesInfo: XySeriesInfo<*>?) : XySeriesTooltip(context, seriesInfo) {
            init {
                val displayMetrics = resources.displayMetrics
                val padding = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1f, displayMetrics).roundToInt()
                setPadding(padding, padding, padding, padding)
            }

            override fun internalUpdate(seriesInfo: XySeriesInfo<*>) {
                val sb = SpannableStringBuilder()
                seriesInfo.seriesName?.run {
                    sb.append(this).append(StringUtil.NEW_LINE)
                }
                sb.append("X: ").append(seriesInfo.formattedXValue)
                sb.append(" Y: ").append(seriesInfo.formattedYValue)
                text = sb

                setTooltipBackgroundColor(0xff4781ed.toInt())
                setTooltipStroke(0xff4781ed.toInt())
                setTooltipTextColor(ColorUtil.White)
            }
        }
    }
    // </CustomCursorModifier>
}

