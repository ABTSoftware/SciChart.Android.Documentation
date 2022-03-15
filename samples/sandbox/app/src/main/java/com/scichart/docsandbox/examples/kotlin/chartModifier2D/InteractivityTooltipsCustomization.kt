package com.scichart.docsandbox.examples.kotlin.chartModifier2D

import android.content.Context
import android.text.SpannableStringBuilder
import android.util.TypedValue
import com.scichart.charting.modifiers.CursorModifier
import com.scichart.charting.modifiers.RolloverModifier
import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.axes.*
import com.scichart.charting.visuals.renderableSeries.FastLineRenderableSeries
import com.scichart.charting.visuals.renderableSeries.hitTest.DefaultXySeriesInfoProvider
import com.scichart.charting.visuals.renderableSeries.hitTest.XySeriesInfo
import com.scichart.charting.visuals.renderableSeries.tooltips.ISeriesTooltip
import com.scichart.charting.visuals.renderableSeries.tooltips.XySeriesTooltip
import com.scichart.core.utility.StringUtil
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment
import com.scichart.drawing.utility.ColorUtil
import kotlin.math.roundToInt

@ExampleDefinition()
class InteractivityTooltipsCustomization : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {}

    fun useCustomSeriesInfoProvider(surface: SciChartSurface) {
        // <CustomSeriesInfoProvider>
        class CustomSeriesInfoProvider : DefaultXySeriesInfoProvider() {
            override fun getSeriesTooltipInternal(context: Context, seriesInfo: XySeriesInfo<*>?, modifierType: Class<*>): ISeriesTooltip {
                return when (modifierType) {
                    CursorModifier::class.java -> { CustomXySeriesTooltip(context, seriesInfo) }
                    else -> { super.getSeriesTooltipInternal(context, seriesInfo, modifierType) }
                }
            }

            inner class CustomXySeriesTooltip(context: Context?, seriesInfo: XySeriesInfo<*>?) : XySeriesTooltip(context, seriesInfo) {
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

                    setTooltipBackgroundColor(0xff6495ed.toInt())
                    setTooltipStroke(0xff4d81dd.toInt())
                    setTooltipTextColor(ColorUtil.White)
                }
            }
        }
        // </CustomSeriesInfoProvider>

        // <UseCustomSeriesInfoProvider>
        val line = FastLineRenderableSeries()
        line.seriesInfoProvider = CustomSeriesInfoProvider()
        // </UseCustomSeriesInfoProvider>
    }

    fun useCustomAxisInfoProvider(surface: SciChartSurface) {
        // <CreateCustomAxisInfoProvider>
        class CustomAxisInfoProvider : DefaultAxisInfoProvider() {
            override fun getAxisTooltipInternal(context: Context, axisInfo: AxisInfo, modifierType: Class<*>): IAxisTooltip {
                return when (modifierType) {
                    RolloverModifier::class.java -> { CustomAxisTooltip(context, axisInfo) }
                    else -> { super.getAxisTooltipInternal(context, axisInfo, modifierType) }
                }
            }

            inner class CustomAxisTooltip(context: Context?, axisInfo: AxisInfo?) : AxisTooltip(context, axisInfo) {
                override fun updateInternal(axisInfo: AxisInfo): Boolean {
                    val sb = SpannableStringBuilder()
                    sb.append("Axis ID: ").append(axisInfo.axisId).append(StringUtil.NEW_LINE)
                    sb.append("Value: ").append(axisInfo.axisFormattedDataValue)

                    text = sb

                    return true
                }

                init {
                    setTooltipBackground(0xff6495ed.toInt())
                }
            }
        }
        // </CreateCustomAxisInfoProvider>

        // <UseCustomAxisInfoProvider>
        val xAxis = NumericAxis(context)
        xAxis.axisInfoProvider = CustomAxisInfoProvider()
        // </UseCustomAxisInfoProvider>
    }
}

