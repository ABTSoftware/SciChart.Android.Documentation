package com.scichart.docsandbox.examples.java.advanced2dTopics;

import androidx.annotation.NonNull;

import com.scichart.charting.model.dataSeries.IXyDataSeries;
import com.scichart.charting.model.dataSeries.IXyyDataSeries;
import com.scichart.charting.model.dataSeries.XyDataSeries;
import com.scichart.charting.model.dataSeries.XyyDataSeries;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.axes.NumericAxis;
import com.scichart.charting.visuals.renderableSeries.FastBandRenderableSeries;
import com.scichart.charting.visuals.renderableSeries.FastLineRenderableSeries;
import com.scichart.core.framework.IUpdateSuspender;
import com.scichart.core.framework.UpdateSuspender;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;

import java.util.Collections;

@ExampleDefinition()
public class SuspendingUpdatesOfChart extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) { }

    void suspendingUpdates(@NonNull SciChartSurface surface) {
        final IXyDataSeries<Double, Double> dataSeries = new XyDataSeries(Double.class, Double.class);
        double x1 = 0;
        double y1 = 0;
        double x2 = 1;
        double y2 = 1;
        double x3 = 2;
        double y4 = 2;
        final NumericAxis xAxis = new NumericAxis(requireContext());
        final NumericAxis yAxis = new NumericAxis(requireContext());
        final FastLineRenderableSeries rSeries = new FastLineRenderableSeries();
        // <SuspendingUpdates>
        // use try-with-resources statement
        try(IUpdateSuspender suspender = surface.suspendUpdates()){
            dataSeries.append(x1, y1);
            dataSeries.append(x2, y2);
            dataSeries.append(x3, y4);
            Collections.addAll(surface.getXAxes(), xAxis);
            Collections.addAll(surface.getYAxes(), yAxis);
            Collections.addAll(surface.getRenderableSeries(), rSeries);
        } catch (Exception e) {

        }

        //or use UpdateSuspender.using() which does the same thing
        UpdateSuspender.using(surface, new Runnable() {
            @Override
            public void run() {
                dataSeries.append(x1, y1);
                dataSeries.append(x2, y2);
                dataSeries.append(x3, y4);
                Collections.addAll(surface.getXAxes(), xAxis);
                Collections.addAll(surface.getYAxes(), yAxis);
                Collections.addAll(surface.getRenderableSeries(), rSeries);
            }
        });
        // </SuspendingUpdates>
    }
}
