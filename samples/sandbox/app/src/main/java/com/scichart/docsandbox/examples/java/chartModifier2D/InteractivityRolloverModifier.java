package com.scichart.docsandbox.examples.java.chartModifier2D;

import android.content.Context;
import android.text.SpannableStringBuilder;

import androidx.annotation.NonNull;

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
import com.scichart.drawing.utility.ColorUtil;

@ExampleDefinition()
public class InteractivityRolloverModifier extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) {}

    void addRolloverModifier(@NonNull SciChartSurface surface) {
        // <AddRolloverModifier>
        // Assume a surface has been created and configured somewhere
        surface.getChartModifiers().add(new RolloverModifier());
        // </AddRolloverModifier>
    }

    void useCustomRolloverModifier(@NonNull FastLineRenderableSeries fastLineRenderableSeries) {
        // <UseCustomRolloverModifier>
        // Assume a fastLineRenderableSeries has been created and configured somewhere
        fastLineRenderableSeries.setSeriesInfoProvider(new CustomSeriesInfoProvider());
        // </UseCustomRolloverModifier>
    }

    // <CustomRolloverModifier>
    private static class CustomSeriesInfoProvider extends DefaultXySeriesInfoProvider {
        @Override
        protected ISeriesTooltip getSeriesTooltipInternal(Context context, XySeriesInfo<?> seriesInfo, Class<?> modifierType) {
            if (modifierType == RolloverModifier.class) {
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
                sb.append("RolloverModifier");
                setText(sb);

                setTooltipBackgroundColor(0xffe97064);
                setTooltipStroke(0xfff4840b);
                setTooltipTextColor(ColorUtil.White);
            }
        }
    }
    // </CustomRolloverModifier>
}
