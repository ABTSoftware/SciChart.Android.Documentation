package com.scichart.docsandbox.examples.kotlin.chartModifier2D

import android.content.Context
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import com.scichart.charting.model.dataSeries.XyDataSeries
import com.scichart.charting.modifiers.RolloverModifier
import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.renderableSeries.FastLineRenderableSeries
import com.scichart.charting.visuals.renderableSeries.hitTest.DefaultXySeriesInfoProvider
import com.scichart.charting.visuals.renderableSeries.hitTest.XySeriesInfo
import com.scichart.charting.visuals.renderableSeries.tooltips.ISeriesTooltip
import com.scichart.charting.visuals.renderableSeries.tooltips.XySeriesTooltip
import com.scichart.core.utility.StringUtil
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment
import com.scichart.drawing.common.SolidPenStyle
import com.scichart.drawing.utility.ColorUtil

@ExampleDefinition()
class InteractivityChartModifierToViewModel : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {
        val dataS = XyDataSeries(
            Double::class.java,
            Double::class.java
        )
        val chartViewModel = ChartViewModel()
        val rolloverModifier = RolloverModifier()

        // Use the custom series info provider class in your code as shown below
        // <ChartModifierToViewModelUsage>
        val lineSeries = FastLineRenderableSeries().apply {
            dataSeries = dataS
            strokeStyle = SolidPenStyle(0xffFF0010.toInt(), true, 3f, null)

            // Set custom series info provider
            seriesInfoProvider = CustomSeriesInfoProvider(chartViewModel)
        }

        surface.renderableSeries.add(lineSeries)
        surface.chartModifiers.add(rolloverModifier)
        // </ChartModifierToViewModelUsage>
    }

    // <ChartModifierToViewModelInfoProvider>
    // Custom series info provider class to get the rollover modifier data points
    private class CustomSeriesInfoProvider(
        private val chartViewModel: ChartViewModel
    ) : DefaultXySeriesInfoProvider() {

        override fun getSeriesTooltipInternal(
            context: Context,
            seriesInfo: XySeriesInfo<*>,
            modifierType: Class<*>
        ): ISeriesTooltip {
            return CustomXySeriesTooltip(context, seriesInfo, "RolloverModifier", chartViewModel)
        }

        private class CustomXySeriesTooltip(
            context: Context,
            seriesInfo: XySeriesInfo<*>,
            private val modifierName: String,
            private val chartViewModel: ChartViewModel
        ) : XySeriesTooltip(context, seriesInfo) {

            override fun internalUpdate(seriesInfo: XySeriesInfo<*>) {
                val sb = SpannableStringBuilder()
                sb.append("X: ").append(seriesInfo.formattedXValue).append(StringUtil.NEW_LINE)
                sb.append("Y: ").append(seriesInfo.formattedYValue).append(StringUtil.NEW_LINE)

                chartViewModel.onRolloverChanged("Series 1", seriesInfo.formattedXValue.toString(), seriesInfo.formattedYValue.toString())

                seriesInfo.seriesName?.let { name ->
                    val start = sb.length
                    sb.append(name)
                    sb.setSpan(
                        ForegroundColorSpan(ColorUtil.White),
                        start,
                        sb.length,
                        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                    )
                    sb.append(StringUtil.NEW_LINE)
                }

                sb.append(modifierName)
                text = sb
                setSeriesColor(0xff6495ed.toInt())
            }
        }
    }
    // </ChartModifierToViewModelInfoProvider>

}

