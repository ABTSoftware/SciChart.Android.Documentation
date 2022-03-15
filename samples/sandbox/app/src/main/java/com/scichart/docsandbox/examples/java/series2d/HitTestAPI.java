package com.scichart.docsandbox.examples.java.series2d;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;

import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.renderableSeries.IRenderableSeries;
import com.scichart.charting.visuals.renderableSeries.hitTest.HitTestInfo;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;

@ExampleDefinition()
public class HitTestAPI extends SingleChart2DFragment {
    private final PointF touchPoint = new PointF();
    private final HitTestInfo hitTestInfo = new HitTestInfo();

    @Override
    protected void initExample(@NonNull SciChartSurface surface) { }

    // <PerformHitTest>
    boolean onTouch(View v, MotionEvent event) {
        final SciChartSurface surface = (SciChartSurface) v;

        // The touch point relative to the ChartSurface
        touchPoint.set(event.getX(), event.getY());
        // Translate the touch point relative to RenderableSeriesArea (or ModifierSurface)
        surface.translatePoint(touchPoint, surface.getRenderableSeriesArea());

        for (IRenderableSeries renderableSeries : surface.getRenderableSeries()) {
            // Perform `Hit-Test` which will be stored in the `_hitTestInfo`
            renderableSeries.hitTest(hitTestInfo, touchPoint.x, touchPoint.y);
        }

        return true;
    }
    // </PerformHitTest>
}
