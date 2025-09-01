package com.scichart.docsandbox.examples.java.chartModifier2D;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.scichart.charting.model.dataSeries.XyDataSeries;
import com.scichart.charting.modifiers.RolloverModifier;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.renderableSeries.FastLineRenderableSeries;
import com.scichart.charting.visuals.renderableSeries.hitTest.DefaultXySeriesInfoProvider;
import com.scichart.charting.visuals.renderableSeries.hitTest.XySeriesInfo;
import com.scichart.charting.visuals.renderableSeries.tooltips.ISeriesTooltip;
import com.scichart.charting.visuals.renderableSeries.tooltips.XySeriesTooltip;
import com.scichart.core.utility.StringUtil;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;
import com.scichart.drawing.common.SolidPenStyle;
import com.scichart.drawing.utility.ColorUtil;

import java.util.Collections;

@ExampleDefinition
public class InteractivityChartModifierToViewModel extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) {
        XyDataSeries<Double, Double> dataSeries = new XyDataSeries<Double, Double>(Double.class, Double.class);
        ChartViewModel chartViewModel = new ChartViewModel();
        RolloverModifier rolloverModifier = new RolloverModifier();

        // <ChartModifierToViewModelUsage>

        // Use the custom series info provider class in your code as shown below
        FastLineRenderableSeries lineSeries = new FastLineRenderableSeries();
        lineSeries.setDataSeries(dataSeries);
        lineSeries.setStrokeStyle(new SolidPenStyle(0xffFF0010, true, 3, null));

        // Set custom series info provider
        lineSeries.setSeriesInfoProvider(new CustomSeriesInfoProvider(chartViewModel));

        Collections.addAll(surface.getRenderableSeries(), lineSeries);
        Collections.addAll(surface.getChartModifiers(), rolloverModifier);
        // </ChartModifierToViewModelUsage>
    }

    // <ChartModifierToViewModelInfoProvider>

    // Custom series info provider class to get the rollover modifier data points
    private static class CustomSeriesInfoProvider extends DefaultXySeriesInfoProvider {

        private final ChartViewModel chartViewModel;

        public CustomSeriesInfoProvider(ChartViewModel chartViewModel) {
            this.chartViewModel = chartViewModel;
        }

        @Override
        protected ISeriesTooltip getSeriesTooltipInternal(Context context, XySeriesInfo<?> seriesInfo, Class<?> modifierType) {
            return new CustomXySeriesTooltip(context, seriesInfo, "RolloverModifier",chartViewModel);
        }

        private static class CustomXySeriesTooltip extends XySeriesTooltip {
            private final String modifierName;
            private final ChartViewModel chartViewModel;

            public CustomXySeriesTooltip(Context context, XySeriesInfo<?> seriesInfo, String modifierName, ChartViewModel chartViewModel) {
                super(context, seriesInfo);
                this.modifierName = modifierName;
                this.chartViewModel = chartViewModel;
            }

            @Override
            protected void internalUpdate(XySeriesInfo seriesInfo) {
                final SpannableStringBuilder sb = new SpannableStringBuilder();
                sb.append("X: ").append(seriesInfo.getFormattedXValue()).append(StringUtil.NEW_LINE);
                sb.append("Y: ").append(seriesInfo.getFormattedYValue()).append(StringUtil.NEW_LINE);
                chartViewModel.onRolloverChanged("Series 1", seriesInfo.getFormattedXValue().toString(), seriesInfo.getFormattedYValue().toString());

                if (seriesInfo.seriesName != null) {
                    final int start = sb.length();

                    sb.append(seriesInfo.seriesName);
                    sb.setSpan(new ForegroundColorSpan(ColorUtil.White), start, sb.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    sb.append(StringUtil.NEW_LINE);
                }
                sb.append(modifierName);
                setText(sb);

                setSeriesColor(0xff6495ed);
            }
        }
    }
    // </ChartModifierToViewModelInfoProvider>
}

