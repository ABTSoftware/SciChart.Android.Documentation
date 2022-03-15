package com.scichart.docsandbox.examples.javaBuilder.series2d;

import androidx.annotation.NonNull;

import com.scichart.charting.visuals.SciPieChartSurface;
import com.scichart.charting.visuals.renderableSeries.DonutRenderableSeries;
import com.scichart.core.framework.UpdateSuspender;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SinglePieChart2DFragment;

import java.util.Collections;

@ExampleDefinition()
public class DonutChart2D extends SinglePieChart2DFragment {
    // <CreateDonutChart>
    @Override
    protected void initExample(@NonNull SciPieChartSurface surface) {
        final DonutRenderableSeries donutSeries = sciChartBuilder.newDonutSeries().withSegments(
                sciChartBuilder.newPieSegment()
                        .withValue(40)
                        .withTitle("Green")
                        .withRadialGradientColors(0xff84BC3D, 0xff5B8829).
                        build(),

                sciChartBuilder.newPieSegment()
                        .withValue(10)
                        .withTitle("Red")
                        .withRadialGradientColors(0xffe04a2f, 0xffB7161B).
                        build(),

                sciChartBuilder.newPieSegment()
                        .withValue(20)
                        .withTitle("Blue")
                        .withRadialGradientColors(0xff4AB6C1, 0xff2182AD).
                        build(),

                sciChartBuilder.newPieSegment()
                        .withValue(15)
                        .withTitle("Yellow")
                        .withRadialGradientColors(0xffFFFF00, 0xfffed325).
                        build()
        ).build();

        UpdateSuspender.using(surface, () -> {
            Collections.addAll(surface.getRenderableSeries(), donutSeries);
        });
    }
    // </CreateDonutChart>
}
