package com.scichart.docsandbox.examples.java.chartModifier2D;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.util.DisplayMetrics;
import android.util.TypedValue;

import androidx.annotation.NonNull;

import com.scichart.charting.modifiers.CursorModifier;
import com.scichart.charting.modifiers.RolloverModifier;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.axes.AxisInfo;
import com.scichart.charting.visuals.axes.AxisTooltip;
import com.scichart.charting.visuals.axes.DefaultAxisInfoProvider;
import com.scichart.charting.visuals.axes.IAxisTooltip;
import com.scichart.charting.visuals.axes.NumericAxis;
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
public class InteractivityTooltipsCustomization extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) {}

    void useCustomSeriesInfoProvider(@NonNull SciChartSurface surface) {
        // <CustomSeriesInfoProvider>
        class CustomSeriesInfoProvider extends DefaultXySeriesInfoProvider {
            @Override
            protected ISeriesTooltip getSeriesTooltipInternal(Context context, XySeriesInfo<?> seriesInfo, Class<?> modifierType) {
                if (modifierType == CursorModifier.class) {
                    return new CustomSeriesInfoProvider.CustomXySeriesTooltip(context, seriesInfo);
                } else {
                    return super.getSeriesTooltipInternal(context, seriesInfo, modifierType);
                }
            }

            class CustomXySeriesTooltip extends XySeriesTooltip {
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

                    setTooltipBackgroundColor(0xff6495ed);
                    setTooltipStroke(0xff4d81dd);
                    setTooltipTextColor(ColorUtil.White);
                }
            }
        }
        // </CustomSeriesInfoProvider>

        // <UseCustomSeriesInfoProvider>
        final FastLineRenderableSeries line = new FastLineRenderableSeries();
        line.setSeriesInfoProvider(new CustomSeriesInfoProvider());
        // </UseCustomSeriesInfoProvider>
    }

    void useCustomAxisInfoProvider(@NonNull SciChartSurface surface) {
        // <CreateCustomAxisInfoProvider>
        class CustomAxisInfoProvider extends DefaultAxisInfoProvider {
            @Override
            protected IAxisTooltip getAxisTooltipInternal(Context context, AxisInfo axisInfo, Class<?> modifierType) {
                if (modifierType == RolloverModifier.class) {
                    return new CustomAxisTooltip(context, axisInfo);
                } else {
                    return super.getAxisTooltipInternal(context, axisInfo, modifierType);
                }
            }

            class CustomAxisTooltip extends AxisTooltip {
                public CustomAxisTooltip(Context context, AxisInfo axisInfo) {
                    super(context, axisInfo);
                    setTooltipBackground(0xff6495ed);
                }

                @Override
                protected boolean updateInternal(AxisInfo axisInfo) {
                    final SpannableStringBuilder sb = new SpannableStringBuilder();
                    sb.append("Axis ID: ").append(axisInfo.axisId).append(StringUtil.NEW_LINE);
                    sb.append("Value: ").append(axisInfo.axisFormattedDataValue);

                    setText(sb);

                    return true;
                }
            }
        }
        // </CreateCustomAxisInfoProvider>

        // <UseCustomAxisInfoProvider>
        final NumericAxis xAxis = new NumericAxis(getContext());
        xAxis.setAxisInfoProvider(new CustomAxisInfoProvider());
        // </UseCustomAxisInfoProvider>
    }
}
