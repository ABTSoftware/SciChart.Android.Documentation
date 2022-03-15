package com.scichart.docsandbox.examples.java.chartModifier3D;

import static com.scichart.core.utility.StringUtil.NEW_LINE;

import android.content.Context;
import android.text.SpannableStringBuilder;

import androidx.annotation.NonNull;

import com.scichart.charting3d.modifiers.TooltipModifier3D;
import com.scichart.charting3d.visuals.SciChartSurface3D;
import com.scichart.charting3d.visuals.renderableSeries.XyzRenderableSeries3DBase;
import com.scichart.charting3d.visuals.renderableSeries.hitTest.DefaultXyzSeriesInfo3DProvider;
import com.scichart.charting3d.visuals.renderableSeries.hitTest.XyzSeriesInfo3D;
import com.scichart.charting3d.visuals.renderableSeries.scatter.ScatterRenderableSeries3D;
import com.scichart.charting3d.visuals.renderableSeries.tooltips.ISeriesTooltip3D;
import com.scichart.charting3d.visuals.renderableSeries.tooltips.XyzSeriesTooltip3D;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart3DFragment;

@ExampleDefinition()
public class InteractivityTooltipModifier3D extends SingleChart3DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface3D surface) {}

    void addTooltipModifier3D(@NonNull SciChartSurface3D surface) {
        // <AddTooltipModifier3D>
        // Assume a surface has been created and configured somewhere
        surface.getChartModifiers().add(new TooltipModifier3D());
        // </AddTooltipModifier3D>
    }

    void useCustomSeriesInfoProvider(@NonNull SciChartSurface3D surface) {
        // <CreateCustomSeriesTooltip>
        class CustomXyzSeriesTooltip3D extends XyzSeriesTooltip3D {
            public CustomXyzSeriesTooltip3D(Context context, XyzSeriesInfo3D<?> seriesInfo) {
                super(context, seriesInfo);
            }

            @Override
            protected void internalUpdate(XyzSeriesInfo3D<?> seriesInfo) {
                final SpannableStringBuilder sb = new SpannableStringBuilder();

                sb.append("This is Custom Tooltip").append(NEW_LINE);
                sb.append("VertexId: ").append(Integer.toString(seriesInfo.vertexId)).append(NEW_LINE);

                sb.append("X: ").append(seriesInfo.getFormattedXValue()).append(NEW_LINE);
                sb.append("Y: ").append(seriesInfo.getFormattedYValue()).append(NEW_LINE);
                sb.append("Z: ").append(seriesInfo.getFormattedZValue());

                setText(sb);
                setSeriesColor(seriesInfo.seriesColor);
                setTooltipBackgroundColor(0xffe2460c);
                setTooltipStroke(0xffff4500);
                setTooltipTextColor(0xffffffff);
            }
        }
        // </CreateCustomSeriesTooltip>

        // <CreateCustomSeriesInfoProvider>
        class CustomSeriesInfo3DProvider extends DefaultXyzSeriesInfo3DProvider {
            @Override
            protected ISeriesTooltip3D getSeriesTooltipInternal(Context context, XyzSeriesInfo3D<? extends XyzRenderableSeries3DBase> seriesInfo, Class<?> modifierType) {
                if (modifierType == TooltipModifier3D.class) {
                    return new CustomXyzSeriesTooltip3D(context, seriesInfo);
                } else {
                    return super.getSeriesTooltipInternal(context, seriesInfo, modifierType);
                }
            }
        }
        // </CreateCustomSeriesInfoProvider>

        // <UseCustomSeriesInfoProvider>
        final ScatterRenderableSeries3D scatterSeries3D = new ScatterRenderableSeries3D();
        scatterSeries3D.setSeriesInfoProvider(new CustomSeriesInfo3DProvider());
        // </UseCustomSeriesInfoProvider>
    }
}
