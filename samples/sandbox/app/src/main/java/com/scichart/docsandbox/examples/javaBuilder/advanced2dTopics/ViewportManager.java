package com.scichart.docsandbox.examples.javaBuilder.advanced2dTopics;

import androidx.annotation.NonNull;

import com.scichart.charting.viewportManagers.DefaultViewportManager;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.axes.IAxisCore;
import com.scichart.data.model.IRange;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;

@ExampleDefinition()
public class ViewportManager extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) { }

    void setViewportManager(@NonNull SciChartSurface surface) {
        // <SetViewportManager>
        // Assume a surface has been created and configured somewhere
        surface.setViewportManager(new DefaultViewportManager());
        // </SetViewportManager>
    }

    void createCustomViewportManager() {
        // <CreateCustomViewportManager>
        class CustomViewportManager extends DefaultViewportManager {
            @Override
            protected void onUpdateXAxis(IAxisCore xAxis) {
                super.onUpdateXAxis(xAxis);
                // called before drawing of xAxis
                // here you can update visible range
                final IRange visibleRange = xAxis.getVisibleRange();
            }

            @Override
            protected void onUpdateYAxis(IAxisCore yAxis) {
                super.onUpdateYAxis(yAxis);
                // called before drawing of yAxis
                // here you can update visible range
                final IRange visibleRange = yAxis.getVisibleRange();
            }
            @Override
            protected void onApplyAutoRange(IAxisCore axis) {
                super.onApplyAutoRange(axis);
                // called when axis uses AutoRange.Always or AutoRange.Once
                // here you can update visible range when need to perform auto range
                final IRange visibleRange = axis.getVisibleRange();
            }
        }
        // </CreateCustomViewportManager>
    }
}
