package com.scichart.docsandbox.examples.java.series2d;

import android.view.Gravity;

import androidx.annotation.NonNull;

import com.scichart.charting.model.PieSegmentCollection;
import com.scichart.charting.modifiers.PieChartLegendModifier;
import com.scichart.charting.modifiers.PieChartTooltipModifier;
import com.scichart.charting.modifiers.PieSegmentSelectionModifier;
import com.scichart.charting.visuals.SciPieChartSurface;
import com.scichart.charting.visuals.renderableSeries.DonutRenderableSeries;
import com.scichart.charting.visuals.renderableSeries.IPieSegment;
import com.scichart.charting.visuals.renderableSeries.PieRenderableSeries;
import com.scichart.charting.visuals.renderableSeries.PieSegment;
import com.scichart.charting.visuals.renderableSeries.PieSegmentLabelFormatterBase;
import com.scichart.core.framework.UpdateSuspender;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SinglePieChart2DFragment;
import com.scichart.drawing.common.RadialGradientBrushStyle;

import java.util.Collections;

@ExampleDefinition()
public class PieChart2D extends SinglePieChart2DFragment {
    // <CreatePieChart>
    @Override
    protected void initExample(@NonNull SciPieChartSurface pieChartSurface) {
        final PieRenderableSeries pieSeries = new PieRenderableSeries();

        final PieSegmentCollection segmentsCollection = pieSeries.getSegmentsCollection();
        segmentsCollection.add(createSegment(40, "Green", 0xff84BC3D, 0xff5B8829));
        segmentsCollection.add(createSegment(10, "Red",0xffe04a2f, 0xffB7161B));
        segmentsCollection.add(createSegment(20, "Blue",0xff4AB6C1, 0xff2182AD));
        segmentsCollection.add(createSegment(15, "Yellow",0xff84BC3D, 0xff5B8829));

        UpdateSuspender.using(pieChartSurface, () -> {
            Collections.addAll(pieChartSurface.getRenderableSeries(), pieSeries);
        });
    }

    private PieSegment createSegment(double value, String title, int gradientStart, int gradientEnd) {
        final PieSegment pieSegment = new PieSegment();
        pieSegment.setValue(value);
        pieSegment.setTitle(title);
        pieSegment.setFillStyle(new RadialGradientBrushStyle(0.5F, 0.5F, 0.5F, 0.5F, gradientStart, gradientEnd));

        return pieSegment;
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
        final PieChartLegendModifier legendModifier = new PieChartLegendModifier(getContext());
        legendModifier.setSourceSeries(pieSeries);
        legendModifier.setLegendPosition(Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 17);

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
        final DonutRenderableSeries donutSeries = new DonutRenderableSeries();
        donutSeries.setPieSegmentLabelFormatter(new CustomPieSegmentLabelFormatter());
        // </UseCustomPieSegmentLabelFormatter>
    }
}
