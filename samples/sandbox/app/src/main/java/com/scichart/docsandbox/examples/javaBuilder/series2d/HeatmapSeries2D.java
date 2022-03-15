package com.scichart.docsandbox.examples.javaBuilder.series2d;

import static com.scichart.drawing.utility.ColorUtil.Chartreuse;
import static com.scichart.drawing.utility.ColorUtil.CornflowerBlue;
import static com.scichart.drawing.utility.ColorUtil.DarkBlue;
import static com.scichart.drawing.utility.ColorUtil.DarkGreen;
import static com.scichart.drawing.utility.ColorUtil.Red;
import static com.scichart.drawing.utility.ColorUtil.Yellow;

import android.view.LayoutInflater;

import androidx.annotation.NonNull;

import com.scichart.charting.model.dataSeries.UniformHeatmapDataSeries;
import com.scichart.charting.modifiers.ModifierGroup;
import com.scichart.charting.visuals.SciChartHeatmapColourMap;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.axes.NumericAxis;
import com.scichart.charting.visuals.renderableSeries.ColorMap;
import com.scichart.charting.visuals.renderableSeries.FastUniformHeatmapRenderableSeries;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.databinding.ExampleHeatmapChartFragmentBinding;
import com.scichart.docsandbox.examples.base.ExampleBaseFragment;

import java.util.Collections;

@ExampleDefinition()
public class HeatmapSeries2D extends ExampleBaseFragment<ExampleHeatmapChartFragmentBinding> {
    private static final int WIDTH = 200, HEIGHT = 300;

    @NonNull
    @Override
    protected ExampleHeatmapChartFragmentBinding inflateBinding(@NonNull LayoutInflater inflater) {
        return ExampleHeatmapChartFragmentBinding.inflate(inflater);
    }

    protected void initExample(@NonNull ExampleHeatmapChartFragmentBinding binding) {
        initExample(binding.surface);
    }

    // <Example>
    protected void initExample(@NonNull SciChartSurface surface) {
        final NumericAxis xAxis = sciChartBuilder.newNumericAxis().build();
        final NumericAxis yAxis = sciChartBuilder.newNumericAxis().build();

        final UniformHeatmapDataSeries<Integer, Integer, Double> dataSeries = new UniformHeatmapDataSeries<>(Integer.class, Integer.class, Double.class, WIDTH, HEIGHT);

        final FastUniformHeatmapRenderableSeries heatmapRenderableSeries = sciChartBuilder.newUniformHeatmap()
                .withColorMap(new ColorMap(
                        new int[]{DarkBlue, CornflowerBlue, DarkGreen, Chartreuse, Yellow, Red},
                        new float[]{0f, 0.2f, 0.4f, 0.6f, 0.8f, 1})
                )
                .withMinimum(0)
                .withMaximum(200)
                .withDataSeries(dataSeries)
                .build();

        final SciChartHeatmapColourMap colourMap = binding.heatmapColourMap;
        colourMap.setMinimum(heatmapRenderableSeries.getMinimum());
        colourMap.setMaximum(heatmapRenderableSeries.getMaximum());
        colourMap.setColorMap(heatmapRenderableSeries.getColorMap());

        Collections.addAll(surface.getXAxes(), xAxis);
        Collections.addAll(surface.getYAxes(), yAxis);
        Collections.addAll(surface.getRenderableSeries(), heatmapRenderableSeries);

        ModifierGroup modifiers = sciChartBuilder.newModifierGroupWithDefaultModifiers()
                .withCursorModifier().withShowTooltip(true).withReceiveHandledEvents(true).build()
                .build();

        Collections.addAll(surface.getChartModifiers(), modifiers);
    }
    // </Example>
}
