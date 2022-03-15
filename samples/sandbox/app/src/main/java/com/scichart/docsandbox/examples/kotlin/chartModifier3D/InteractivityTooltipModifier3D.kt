package com.scichart.docsandbox.examples.kotlin.chartModifier3D

import android.content.Context
import android.text.SpannableStringBuilder
import com.scichart.charting3d.modifiers.TooltipModifier3D
import com.scichart.charting3d.visuals.SciChartSurface3D
import com.scichart.charting3d.visuals.renderableSeries.XyzRenderableSeries3DBase
import com.scichart.charting3d.visuals.renderableSeries.hitTest.DefaultXyzSeriesInfo3DProvider
import com.scichart.charting3d.visuals.renderableSeries.hitTest.XyzSeriesInfo3D
import com.scichart.charting3d.visuals.renderableSeries.scatter.ScatterRenderableSeries3D
import com.scichart.charting3d.visuals.renderableSeries.tooltips.ISeriesTooltip3D
import com.scichart.charting3d.visuals.renderableSeries.tooltips.XyzSeriesTooltip3D
import com.scichart.core.utility.StringUtil
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart3DFragment

@ExampleDefinition()
class InteractivityTooltipModifier3D : SingleChart3DFragment() {
    override fun initExample(surface: SciChartSurface3D) {}

    fun addTooltipModifier3D(surface: SciChartSurface3D) {
        // <AddTooltipModifier3D>
        // Assume a surface has been created and configured somewhere
        surface.chartModifiers.add(TooltipModifier3D())
        // </AddTooltipModifier3D>
    }

    fun useCustomSeriesInfoProvider(surface: SciChartSurface3D) {
        // <CreateCustomSeriesTooltip>
        class CustomXyzSeriesTooltip3D(context: Context?, seriesInfo: XyzSeriesInfo3D<*>) : XyzSeriesTooltip3D(context, seriesInfo) {
            override fun internalUpdate(seriesInfo: XyzSeriesInfo3D<*>) {
                val sb = SpannableStringBuilder()

                sb.append("This is Custom Tooltip").append(StringUtil.NEW_LINE)
                sb.append("VertexId: ").append(seriesInfo.vertexId.toString()).append(StringUtil.NEW_LINE)

                sb.append("X: ").append(seriesInfo.formattedXValue).append(StringUtil.NEW_LINE)
                sb.append("Y: ").append(seriesInfo.formattedYValue).append(StringUtil.NEW_LINE)
                sb.append("Z: ").append(seriesInfo.formattedZValue)

                text = sb
                setSeriesColor(seriesInfo.seriesColor)
                setTooltipBackgroundColor(0xffe2460c.toInt())
                setTooltipStroke(0xffff4500.toInt())
                setTooltipTextColor(0xffffffff.toInt())
            }
        }
        // </CreateCustomSeriesTooltip>

        // <CreateCustomSeriesInfoProvider>
        class CustomSeriesInfo3DProvider : DefaultXyzSeriesInfo3DProvider() {
            override fun getSeriesTooltipInternal(context: Context, seriesInfo: XyzSeriesInfo3D<out XyzRenderableSeries3DBase>, modifierType: Class<*>): ISeriesTooltip3D {
                return if (modifierType == TooltipModifier3D::class.java) {
                    CustomXyzSeriesTooltip3D(context, seriesInfo)
                } else {
                    super.getSeriesTooltipInternal(context, seriesInfo, modifierType)
                }
            }
        }
        // </CreateCustomSeriesInfoProvider>

        // <UseCustomSeriesInfoProvider>
        val scatterSeries3D = ScatterRenderableSeries3D()
        scatterSeries3D.seriesInfoProvider = CustomSeriesInfo3DProvider()
        // </UseCustomSeriesInfoProvider>
    }
}
