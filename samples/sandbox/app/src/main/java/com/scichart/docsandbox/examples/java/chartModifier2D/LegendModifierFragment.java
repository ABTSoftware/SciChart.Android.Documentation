package com.scichart.docsandbox.examples.java.chartModifier2D;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.scichart.charting.modifiers.LegendModifier;
import com.scichart.charting.modifiers.SourceMode;
import com.scichart.charting.themes.IThemeProvider;
import com.scichart.charting.themes.ThemeManager;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.legend.DefaultLegendItemFactoryBase;
import com.scichart.charting.visuals.legend.LegendItemBase;
import com.scichart.charting.visuals.legend.SciChartLegend;
import com.scichart.charting.visuals.legend.SeriesInfoLegendAdapter;
import com.scichart.charting.visuals.renderableSeries.hitTest.SeriesInfo;
import com.scichart.core.annotations.Orientation;
import com.scichart.docsandbox.R;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;
import com.scichart.drawing.common.FontStyle;

@ExampleDefinition()
public class LegendModifierFragment extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) {}

    void createLegendModifier(@NonNull SciChartSurface surface) {
        // <CreateLegendModifier>
        LegendModifier legendModifier = new LegendModifier(getContext());
        legendModifier.setLegendPosition(Gravity.TOP | Gravity.START, 16);
        legendModifier.setSourceMode(SourceMode.AllSeries);
        legendModifier.setOrientation(Orientation.HORIZONTAL);
        // </CreateLegendModifier>

        // <AddLegendModifier>
        surface.getChartModifiers().add(legendModifier);
        // </AddLegendModifier>

        final LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.example_single_chart_with_legend, binding.getRoot());
        // <CreateLegendModifierOutsideSurface>
        final SciChartLegend legend = view.findViewById(R.id.legend);
        legendModifier = new LegendModifier(legend, false);
        // </CreateLegendModifierOutsideSurface>
    }

    void createLegendWithCustomItem(@NonNull SciChartSurface surface) {
        // <CreateCustomLegendItem>
        class CustomLegendItem extends LegendItemBase {
            protected final TextView name;

            protected CustomLegendItem(View itemView) {
                super(itemView);

                name = (TextView) itemView.findViewById(com.scichart.charting.R.id.name);
            }

            @Override
            public void applyThemeProvider(IThemeProvider themeProvider) {
                final FontStyle legendLabelTextStyle = themeProvider.getDefaultLabelTextStyle();
                legendLabelTextStyle.initTextView(name);
            }

            @Override
            public void bindSource(Object source, SciChartLegend legend) {
                final SeriesInfo<?> seriesInfo = (SeriesInfo) source;
                name.setText(seriesInfo.seriesName);
                name.setBackgroundColor(seriesInfo.seriesColor);

                ThemeManager.applyTheme(this, legend.getTheme(), legend.getContext());
            }
        }
        // </CreateCustomLegendItem>

        // <CreateCustomLegendItemsFactory>
        class CustomLegendItemsFactory extends DefaultLegendItemFactoryBase {
            @Override
            protected LegendItemBase createLegendItem(View legendItemView) {
                return new CustomLegendItem(legendItemView);
            }

            @Override
            protected View createLegendItemView(ViewGroup parent) {
                return LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_legend_item, null);
            }
        }
        // </CreateCustomLegendItemsFactory>

        // <CreateLegendWithCustomItem>
        final SciChartLegend legend = new SciChartLegend(requireContext());
        final CustomLegendItemsFactory factory = new CustomLegendItemsFactory();
        final SeriesInfoLegendAdapter adapter = new SeriesInfoLegendAdapter(factory);
        final LegendModifier legendModifier = new LegendModifier(legend, adapter, true);

        // Add LegendModifier to a surface
        surface.getChartModifiers().add(legendModifier);
        // </CreateLegendWithCustomItem>
    }
}
