package com.scichart.docsandbox.examples.java.series2d;

import static com.scichart.drawing.utility.ColorUtil.Chartreuse;
import static com.scichart.drawing.utility.ColorUtil.CornflowerBlue;
import static com.scichart.drawing.utility.ColorUtil.DarkBlue;
import static com.scichart.drawing.utility.ColorUtil.DarkGreen;
import static com.scichart.drawing.utility.ColorUtil.Red;
import static com.scichart.drawing.utility.ColorUtil.Yellow;

import android.view.LayoutInflater;

import androidx.annotation.NonNull;

import com.scichart.charting.model.dataSeries.UniformHeatmapDataSeries;
import com.scichart.charting.modifiers.CursorModifier;
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

    public ModifierGroup createDefaultModifiers() {
        return sciChartBuilder.newModifierGroupWithDefaultModifiers().build();
    }

    // <Example>
    protected void initExample(@NonNull SciChartSurface surface) {
        final NumericAxis xAxis = new NumericAxis(requireContext());
        final NumericAxis yAxis = new NumericAxis(requireContext());

        final UniformHeatmapDataSeries<Integer, Integer, Double> dataSeries = new UniformHeatmapDataSeries<>(Integer.class, Integer.class, Double.class, WIDTH, HEIGHT);

        final FastUniformHeatmapRenderableSeries heatmapRenderableSeries = new FastUniformHeatmapRenderableSeries();
        heatmapRenderableSeries.setColorMap(
                new ColorMap(
                        new int[]{DarkBlue, CornflowerBlue, DarkGreen, Chartreuse, Yellow, Red},
                        new float[]{0f, 0.2f, 0.4f, 0.6f, 0.8f, 1}
                )
        );

        heatmapRenderableSeries.setMinimum(0);
        heatmapRenderableSeries.setMaximum(200);
        heatmapRenderableSeries.setDataSeries(dataSeries);

        final SciChartHeatmapColourMap colourMap = binding.heatmapColourMap;
        colourMap.setMinimum(heatmapRenderableSeries.getMinimum());
        colourMap.setMaximum(heatmapRenderableSeries.getMaximum());
        colourMap.setColorMap(heatmapRenderableSeries.getColorMap());

        Collections.addAll(surface.getXAxes(), xAxis);
        Collections.addAll(surface.getYAxes(), yAxis);
        Collections.addAll(surface.getRenderableSeries(), heatmapRenderableSeries);

        final CursorModifier cursor = new CursorModifier();
        cursor.setShowTooltip(true);
        cursor.setReceiveHandledEvents(true);

        ModifierGroup modifiers = createDefaultModifiers();
        modifiers.getChildModifiers().add(cursor);

        Collections.addAll(surface.getChartModifiers(), modifiers);
    }
    // </Example>
}
