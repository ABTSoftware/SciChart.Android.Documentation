package com.scichart.docsandbox.examples.java.series2d;

import static androidx.compose.ui.semantics.SemanticsPropertiesKt.setText;

import android.animation.FloatEvaluator;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.DecelerateInterpolator;

import androidx.annotation.NonNull;

import com.scichart.charting.model.dataSeries.IXyDataSeries;
import com.scichart.charting.model.dataSeries.XyDataSeries;
import com.scichart.charting.modifiers.RolloverModifier;
import com.scichart.charting.modifiers.ZoomExtentsModifier;
import com.scichart.charting.modifiers.ZoomPanModifier;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.animations.AnimationsHelper;
import com.scichart.charting.visuals.animations.BaseRenderPassDataTransformation;
import com.scichart.charting.visuals.animations.TransformationHelpers;
import com.scichart.charting.visuals.axes.NumericAxis;
import com.scichart.charting.visuals.renderableSeries.FastLineRenderableSeries;
import com.scichart.charting.visuals.renderableSeries.data.LineRenderPassData;
import com.scichart.charting.visuals.renderableSeries.hitTest.DefaultXySeriesInfoProvider;
import com.scichart.charting.visuals.renderableSeries.hitTest.XySeriesInfo;
import com.scichart.charting.visuals.renderableSeries.tooltips.ISeriesTooltip;
import com.scichart.charting.visuals.renderableSeries.tooltips.XySeriesTooltip;
import com.scichart.core.framework.UpdateSuspender;
import com.scichart.core.model.FloatValues;
import com.scichart.core.utility.StringUtil;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;
import com.scichart.drawing.utility.ColorUtil;
import com.scichart.extensions.builders.SciChartBuilder;

import java.util.Collections;
import java.util.Random;

@ExampleDefinition()
public class Accessibility extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) {

    }

    public void setChart(Context context) {
        SciChartBuilder.init(context);
        SciChartBuilder sciChartBuilder = SciChartBuilder.instance();

        NumericAxis xAxis = sciChartBuilder.newNumericAxis().build();
        NumericAxis yAxis = sciChartBuilder.newNumericAxis().build();

        XyDataSeries<Double, Double> dataSeries = new XyDataSeries<>(Double.class, Double.class);
        for (int i = 0; i <= 10; i++) {
            dataSeries.append((double) i, Math.sin((double) i));
        }

        FastLineRenderableSeries fcs = new FastLineRenderableSeries();
        fcs.setDataSeries(dataSeries);
        fcs.setSeriesInfoProvider(new FirstCustomSeriesInfoProvider());

        UpdateSuspender.using(binding.surface, () -> {
            Collections.addAll(binding.surface.getXAxes(), xAxis);
            Collections.addAll(binding.surface.getYAxes(), yAxis);
            Collections.addAll(binding.surface.getRenderableSeries(), fcs);
            Collections.addAll(binding.surface.getChartModifiers(),
                    new RolloverModifier(),
                    new ZoomPanModifier(),
                    new ZoomExtentsModifier()
            );
        });

        // <AccessibilityEnable>
        binding.surface.setImportantForAccessibility(View.IMPORTANT_FOR_ACCESSIBILITY_YES);

        xAxis.setVisibleRangeChangeListener((axis, oldRange, newRange, isAnimating) -> {
            binding.surface.announceForAccessibility("visible range changed");
            binding.surface.sendAccessibilityEvent(AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED);
        });
        // </AccessibilityEnable>


        yAxis.setVisibleRangeChangeListener((axis, oldRange, newRange, isAnimating) -> {
            binding.surface.sendAccessibilityEvent(AccessibilityEvent.TYPE_WINDOW_CONTENT_CHANGED);
        });
    }

    // <AccessibilitySeriesInfo>
    private static class FirstCustomSeriesInfoProvider extends DefaultXySeriesInfoProvider {
        @Override
        public ISeriesTooltip getSeriesTooltipInternal(Context context, XySeriesInfo<?> seriesInfo, Class<?> modifierType) {
            if (modifierType == RolloverModifier.class) {
                return new FirstCustomXySeriesTooltip(context, seriesInfo);
            } else {
                return super.getSeriesTooltipInternal(context, seriesInfo, modifierType);
            }
        }

        private static class FirstCustomXySeriesTooltip extends XySeriesTooltip {

            public FirstCustomXySeriesTooltip(Context context, XySeriesInfo<?> seriesInfo) {
                super(context, seriesInfo);
            }

            @Override
            protected void internalUpdate(XySeriesInfo seriesInfo) {
                super.internalUpdate(seriesInfo);
                SpannableStringBuilder sb = new SpannableStringBuilder();
                sb.append("X is ").append(seriesInfo.getFormattedXValue()).append(StringUtil.NEW_LINE);
                sb.append("Y is ").append(seriesInfo.getFormattedYValue()).append(StringUtil.NEW_LINE);

                if (seriesInfo.seriesName != null) {
                    sb.append(seriesInfo.seriesName).append(StringUtil.NEW_LINE);
                }

                setText(sb);
                announceForAccessibility(sb.toString());

                setTooltipBackgroundColor(0xffe97064);
                setTooltipStroke(0xfff4840b);
                setTooltipTextColor(ColorUtil.White);
            }
        }
    }
    // </AccessibilitySeriesInfo>
}
