package com.scichart.docsandbox.examples.javaBuilder.series2d;

import static com.scichart.drawing.utility.ColorUtil.Chartreuse;
import static com.scichart.drawing.utility.ColorUtil.CornflowerBlue;
import static com.scichart.drawing.utility.ColorUtil.DarkBlue;
import static com.scichart.drawing.utility.ColorUtil.DarkGreen;
import static com.scichart.drawing.utility.ColorUtil.Red;
import static com.scichart.drawing.utility.ColorUtil.Yellow;

import androidx.annotation.NonNull;

import com.scichart.charting.model.dataSeries.IUniformHeatmapDataSeries;
import com.scichart.charting.model.dataSeries.UniformHeatmapDataSeries;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.renderableSeries.ColorMap;
import com.scichart.charting.visuals.renderableSeries.FastUniformHeatmapRenderableSeries;
import com.scichart.core.framework.UpdateSuspender;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;

import java.util.Collections;

@ExampleDefinition()
public class UniformHeatmapSeries2D extends SingleChart2DFragment {
    // <Example>
    @Override
    protected void initExample(@NonNull SciChartSurface surface) {
        final IUniformHeatmapDataSeries<Integer, Integer, Integer> dataSeries = new UniformHeatmapDataSeries<>(Integer.class, Integer.class, Integer.class, 5, 5);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dataSeries.updateZAt(i, j, i*i + j*j);
            }
        }

        final ColorMap colorMap = new ColorMap(
                new int[]{DarkBlue, CornflowerBlue, DarkGreen, Chartreuse, Yellow, Red},
                new float[]{0f, 0.2f, 0.4f, 0.6f, 0.8f, 1});

        final FastUniformHeatmapRenderableSeries heatmapSeries = sciChartBuilder.newUniformHeatmap()
                .withDataSeries(dataSeries)
                .withColorMap(colorMap)
                .withMinimum(0)
                .withMaximum(50)
                .build();

        UpdateSuspender.using(surface, () -> {
            Collections.addAll(surface.getXAxes(), sciChartBuilder.newNumericAxis().build());
            Collections.addAll(surface.getYAxes(), sciChartBuilder.newNumericAxis().build());

            Collections.addAll(surface.getRenderableSeries(), heatmapSeries);
        });
    }
    // </Example>
}
