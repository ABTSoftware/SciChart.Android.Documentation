package com.scichart.docsandbox.examples.java.chartModifier2D;

import android.content.Context;
import android.text.SpannableStringBuilder;

import androidx.annotation.NonNull;

import com.scichart.charting.modifiers.TooltipModifier;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.renderableSeries.FastLineRenderableSeries;
import com.scichart.charting.visuals.renderableSeries.hitTest.DefaultXySeriesInfoProvider;
import com.scichart.charting.visuals.renderableSeries.hitTest.XySeriesInfo;
import com.scichart.charting.visuals.renderableSeries.tooltips.ISeriesTooltip;
import com.scichart.charting.visuals.renderableSeries.tooltips.XySeriesTooltip;
import com.scichart.core.utility.StringUtil;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;
import com.scichart.drawing.utility.ColorUtil;

@ExampleDefinition()
public class InteractivityTooltipModifier extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) {}

    void addTooltipModifier(@NonNull SciChartSurface surface) {
        // <AddTooltipModifier>
        // Assume a surface has been created and configured somewhere
        surface.getChartModifiers().add(new TooltipModifier());
        // </AddTooltipModifier>
    }

    void useCustomTooltipModifier(@NonNull FastLineRenderableSeries fastLineRenderableSeries) {
        // <UseCustomTooltipModifier>
        // Assume a fastLineRenderableSeries has been created and configured somewhere
        fastLineRenderableSeries.setSeriesInfoProvider(new CustomSeriesInfoProvider());
        // </UseCustomTooltipModifier>
    }

    // <CustomTooltipModifier>
    private static class CustomSeriesInfoProvider extends DefaultXySeriesInfoProvider {
        @Override
        protected ISeriesTooltip getSeriesTooltipInternal(Context context, XySeriesInfo<?> seriesInfo, Class<?> modifierType) {
            if (modifierType == TooltipModifier.class) {
                return new CustomXySeriesTooltip(context, seriesInfo);
            } else {
                return super.getSeriesTooltipInternal(context, seriesInfo, modifierType);
            }
        }

        private static class CustomXySeriesTooltip extends XySeriesTooltip {
            public CustomXySeriesTooltip(Context context, XySeriesInfo<?> seriesInfo) {
                super(context, seriesInfo);
            }

            @Override
            protected void internalUpdate(XySeriesInfo seriesInfo) {
                final SpannableStringBuilder sb = new SpannableStringBuilder();
                sb.append("X: ").append(seriesInfo.getFormattedXValue()).append(StringUtil.NEW_LINE);
                sb.append("Y: ").append(seriesInfo.getFormattedYValue()).append(StringUtil.NEW_LINE);

                if (seriesInfo.seriesName != null) {
                    sb.append(seriesInfo.seriesName).append(StringUtil.NEW_LINE);
                }
                sb.append("TooltipModifier");
                setText(sb);

                setTooltipBackgroundColor(0xff47bde6);
                setTooltipStroke(0xff21a0d8);
                setTooltipTextColor(ColorUtil.White);
            }
        }
    }
    // </CustomTooltipModifier>
}
