package com.scichart.docsandbox.examples.kotlin.chartModifier2D

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.scichart.charting.modifiers.LegendModifier
import com.scichart.charting.modifiers.SourceMode
import com.scichart.charting.themes.IThemeProvider
import com.scichart.charting.themes.ThemeManager
import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.legend.DefaultLegendItemFactoryBase
import com.scichart.charting.visuals.legend.LegendItemBase
import com.scichart.charting.visuals.legend.SciChartLegend
import com.scichart.charting.visuals.legend.SeriesInfoLegendAdapter
import com.scichart.charting.visuals.renderableSeries.hitTest.SeriesInfo
import com.scichart.core.annotations.Orientation
import com.scichart.docsandbox.R
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment

@ExampleDefinition()
class LegendModifierFragment : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {}

    fun createLegendModifier(surface: SciChartSurface) {
        // <CreateLegendModifier>
        var legendModifier = LegendModifier(context)
        legendModifier.setLegendPosition(Gravity.TOP or Gravity.START, 16)
        legendModifier.setSourceMode(SourceMode.AllSeries)
        legendModifier.setOrientation(Orientation.HORIZONTAL)
        // </CreateLegendModifier>

        // <AddLegendModifier>
        surface.chartModifiers.add(legendModifier)
        // </AddLegendModifier>

        val inflater = requireContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view: View = inflater.inflate(R.layout.example_single_chart_with_legend, binding.root)
        // <CreateLegendModifierOutsideSurface>
        val legend: SciChartLegend = view.findViewById(R.id.legend)
        legendModifier = LegendModifier(legend, false)
        // </CreateLegendModifierOutsideSurface>
    }

    fun createLegendWithCustomItem(surface: SciChartSurface) {
        // <CreateCustomLegendItem>
        class CustomLegendItem(itemView: View) : LegendItemBase(itemView) {
            private lateinit var name: TextView

            override fun applyThemeProvider(themeProvider: IThemeProvider) {
                val legendLabelTextStyle = themeProvider.defaultLabelTextStyle
                legendLabelTextStyle.initTextView(name)
            }

            override fun bindSource(source: Any, legend: SciChartLegend) {
                val seriesInfo = source as SeriesInfo<*>
                name.text = seriesInfo.seriesName
                name.setBackgroundColor(seriesInfo.seriesColor)

                ThemeManager.applyTheme(this, legend.theme, legend.context)
            }

            init {
                name = itemView.findViewById<View>(com.scichart.charting.R.id.name) as TextView
            }
        }
        // </CreateCustomLegendItem>

        // <CreateCustomLegendItemsFactory>
        class CustomLegendItemsFactory : DefaultLegendItemFactoryBase() {
            override fun createLegendItem(legendItemView: View): LegendItemBase {
                return CustomLegendItem(legendItemView)
            }

            override fun createLegendItemView(parent: ViewGroup): View {
                return LayoutInflater.from(parent.context).inflate(R.layout.custom_legend_item, null)
            }
        }
        // </CreateCustomLegendItemsFactory>

        // <CreateLegendWithCustomItem>
        val legend = SciChartLegend(requireContext())
        val factory = CustomLegendItemsFactory()
        val adapter = SeriesInfoLegendAdapter(factory)
        val legendModifier = LegendModifier(legend, adapter, true)

        // Add LegendModifier to a surface
        surface.chartModifiers.add(legendModifier)
        // </CreateLegendWithCustomItem>
    }
}

