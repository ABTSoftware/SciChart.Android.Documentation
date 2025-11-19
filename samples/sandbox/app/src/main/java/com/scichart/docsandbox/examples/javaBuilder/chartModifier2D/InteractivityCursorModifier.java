package com.scichart.docsandbox.examples.javaBuilder.chartModifier2D;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.util.DisplayMetrics;
import android.util.TypedValue;

import androidx.annotation.NonNull;

import com.scichart.charting.modifiers.CursorModifier;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.renderableSeries.FastLineRenderableSeries;
import com.scichart.charting.visuals.renderableSeries.hitTest.DefaultXySeriesInfoProvider;
import com.scichart.charting.visuals.renderableSeries.hitTest.XySeriesInfo;
import com.scichart.charting.visuals.renderableSeries.tooltips.ISeriesTooltip;
import com.scichart.charting.visuals.renderableSeries.tooltips.XySeriesTooltip;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;
import com.scichart.drawing.utility.ColorUtil;

@ExampleDefinition()
public class InteractivityCursorModifier extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) {}

    void addCursorModifier(@NonNull SciChartSurface surface) {
        // <AddCursorModifier>
        // Assume a surface has been created and configured somewhere
        surface.getChartModifiers().add(
                sciChartBuilder.newModifierGroup()
                        .withCursorModifier()
                        .build()
                        .build()
        );
        // </AddCursorModifier>
    }

    void useCustomCursorModifier(@NonNull FastLineRenderableSeries fastLineRenderableSeries) {
        // <UseCustomCursorModifier>
        // Assume a fastLineRenderableSeries has been created and configured somewhere
        fastLineRenderableSeries.setSeriesInfoProvider(new CustomSeriesInfoProvider());
        // </UseCustomCursorModifier>
    }

    void includeExcludeSeries(CursorModifier cursorModifier, FastLineRenderableSeries seriesX, FastLineRenderableSeries seriesY) {
        // <IncludeExcludeSeries>
        // Assume a cursorModifier has been created and configured somewhere

        // To include a series in the cursorModifier hit-test
        cursorModifier.includeRenderableSeries(seriesX, true);

        // To exclude a series from the cursorModifier hit-test
        cursorModifier.includeRenderableSeries(seriesY, false);
        // </IncludeExcludeSeries>
    }

    // <CustomCursorModifier>
    private static class CustomSeriesInfoProvider extends DefaultXySeriesInfoProvider {
        @Override
        protected ISeriesTooltip getSeriesTooltipInternal(Context context, XySeriesInfo<?> seriesInfo, Class<?> modifierType) {
            if (modifierType == CursorModifier.class) {
                return new CustomSeriesInfoProvider.CustomXySeriesTooltip(context, seriesInfo);
            } else {
                return super.getSeriesTooltipInternal(context, seriesInfo, modifierType);
            }
        }

        private static class CustomXySeriesTooltip extends XySeriesTooltip {
            public CustomXySeriesTooltip(Context context, XySeriesInfo<?> seriesInfo) {
                super(context, seriesInfo);

                final DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                final int padding = Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1f, displayMetrics));
                this.setPadding(padding, padding, padding, padding);
            }

            @Override
            protected void internalUpdate(XySeriesInfo seriesInfo) {
                final SpannableStringBuilder sb = new SpannableStringBuilder();
                if (seriesInfo.seriesName != null) {
                    sb.append(seriesInfo.seriesName).append(" - ");
                }

                sb.append("X: ").append(seriesInfo.getFormattedXValue());
                sb.append(" Y: ").append(seriesInfo.getFormattedYValue());
                setText(sb);

                setTooltipBackgroundColor(0xff4781ed);
                setTooltipStroke(0xff4781ed);
                setTooltipTextColor(ColorUtil.White);
            }
        }
    }
    // </CustomCursorModifier>
}
