package com.scichart.docsandbox.examples.javaBuilder.series2d;

import android.view.Gravity;

import androidx.annotation.NonNull;

import com.scichart.charting.modifiers.PieChartLegendModifier;
import com.scichart.charting.modifiers.PieChartTooltipModifier;
import com.scichart.charting.modifiers.PieSegmentSelectionModifier;
import com.scichart.charting.visuals.SciPieChartSurface;
import com.scichart.charting.visuals.renderableSeries.DonutRenderableSeries;
import com.scichart.charting.visuals.renderableSeries.IPieSegment;
import com.scichart.charting.visuals.renderableSeries.PieRenderableSeries;
import com.scichart.charting.visuals.renderableSeries.PieSegmentLabelFormatterBase;
import com.scichart.core.framework.UpdateSuspender;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SinglePieChart2DFragment;

import java.util.Collections;

@ExampleDefinition()
public class PieChart2D extends SinglePieChart2DFragment {
    // <CreatePieChart>
    @Override
    protected void initExample(@NonNull SciPieChartSurface surface) {
        final PieRenderableSeries pieSeries = sciChartBuilder.newPieSeries().withSegments(
                sciChartBuilder.newPieSegment()
                        .withValue(40)
                        .withTitle("Green")
                        .withRadialGradientColors(0xff84BC3D, 0xff5B8829)
                        .build(),

                sciChartBuilder.newPieSegment()
                        .withValue(10)
                        .withTitle("Red")
                        .withRadialGradientColors(0xffe04a2f, 0xffB7161B)
                        .build(),

                sciChartBuilder.newPieSegment()
                        .withValue(20)
                        .withTitle("Blue")
                        .withRadialGradientColors(0xff4AB6C1, 0xff2182AD)
                        .build(),

                sciChartBuilder.newPieSegment()
                        .withValue(15)
                        .withTitle("Yellow")
                        .withRadialGradientColors(0xffFFFF00, 0xfffed325)
                        .build()
        ).build();

        UpdateSuspender.using(surface, () -> {
            Collections.addAll(surface.getRenderableSeries(), pieSeries);
        });
    }
    // </CreatePieChart>

    // <CreateCustomPieSegmentLabelFormatter>
    class CustomPieSegmentLabelFormatter extends PieSegmentLabelFormatterBase {
        @Override
        public CharSequence formatLabel(IPieSegment pieSegment) {
            return String.format("%.1f", pieSegment.getValue());
        }
    }
    // </CreateCustomPieSegmentLabelFormatter>

    void createPieChartLegend(PieRenderableSeries pieSeries, SciPieChartSurface pieChartSurface) {
        // <CreatePieChartLegend>
        final PieChartLegendModifier legendModifier = sciChartBuilder.newLegendModifier()
                .withSourceSeries(pieSeries)
                .withPosition(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 17)
                .build();

        pieChartSurface.getChartModifiers().add(legendModifier);
        // </CreatePieChartLegend>

        // <AddPieChartSelection>
        final PieSegmentSelectionModifier selectionModifier = new PieSegmentSelectionModifier();
        pieChartSurface.getChartModifiers().add(selectionModifier);
        // </AddPieChartSelection>

        // <AddPieChartTooltip>
        pieChartSurface.getChartModifiers().add(new PieChartTooltipModifier());
        // </AddPieChartTooltip>

        // <UseCustomPieSegmentLabelFormatter>
        // Assume a donutSeries has been created somewhere
        final DonutRenderableSeries donutSeries = sciChartBuilder.newDonutSeries().build();
        donutSeries.setPieSegmentLabelFormatter(new CustomPieSegmentLabelFormatter());
        // </UseCustomPieSegmentLabelFormatter>
    }
}
