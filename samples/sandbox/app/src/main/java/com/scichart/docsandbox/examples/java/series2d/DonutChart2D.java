package com.scichart.docsandbox.examples.java.series2d;

import androidx.annotation.NonNull;

import com.scichart.charting.model.PieSegmentCollection;
import com.scichart.charting.visuals.SciPieChartSurface;
import com.scichart.charting.visuals.renderableSeries.DonutRenderableSeries;
import com.scichart.charting.visuals.renderableSeries.PieSegment;
import com.scichart.core.framework.UpdateSuspender;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SinglePieChart2DFragment;
import com.scichart.drawing.common.RadialGradientBrushStyle;

import java.util.Collections;

@ExampleDefinition()
public class DonutChart2D extends SinglePieChart2DFragment {
    // <CreateDonutChart>
    @Override
    protected void initExample(@NonNull SciPieChartSurface surface) {
        final DonutRenderableSeries donutSeries = new DonutRenderableSeries();

        final PieSegmentCollection segmentsCollection = donutSeries.getSegmentsCollection();
        segmentsCollection.add(createSegment(40, "Green", 0xff84BC3D, 0xff5B8829));
        segmentsCollection.add(createSegment(10, "Red",0xffe04a2f, 0xffB7161B));
        segmentsCollection.add(createSegment(20, "Blue",0xff4AB6C1, 0xff2182AD));
        segmentsCollection.add(createSegment(15, "Yellow",0xff84BC3D, 0xff5B8829));

        UpdateSuspender.using(surface, () -> {
            Collections.addAll(surface.getRenderableSeries(), donutSeries);
        });
    }

    private PieSegment createSegment(double value, String title, int gradientStart, int gradientEnd) {
        final PieSegment pieSegment = new PieSegment();

        pieSegment.setValue(value);
        pieSegment.setTitle(title);
        pieSegment.setFillStyle(new RadialGradientBrushStyle(0.5F, 0.5F, 0.5F, 0.5F, gradientStart, gradientEnd));

        return pieSegment;
    }
    // </CreateDonutChart>
}
