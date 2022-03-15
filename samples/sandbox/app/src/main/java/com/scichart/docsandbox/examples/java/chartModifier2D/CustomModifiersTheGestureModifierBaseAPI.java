package com.scichart.docsandbox.examples.java.chartModifier2D;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

import androidx.annotation.NonNull;

import com.scichart.charting.modifiers.GestureModifierBase;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.axes.IAxis;
import com.scichart.core.IServiceContainer;
import com.scichart.core.utility.touch.ModifierTouchEventArgs;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;

@ExampleDefinition()
public class CustomModifiersTheGestureModifierBaseAPI extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) {}

    void createCustomZoomGestureModifier(@NonNull SciChartSurface surface) {
        // <CreateCustomZoomGestureModifier>
        class CustomZoomGestureModifier extends GestureModifierBase {
            private boolean isScrolling = false;
            private boolean isZoomEnabled = false;

            private float touchSlop;
            private final PointF start = new PointF();
            private float lastY;

            @Override
            public void attachTo(IServiceContainer services) {
                super.attachTo(services);

                final Context context = getContext();
                if (context == null) return;

                this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop() * 2;
            }

            @Override
            public boolean onDoubleTap(MotionEvent e) {
                start.set(e.getX(), e.getY());
                lastY = e.getY();
                isZoomEnabled = true;

                return true;
            }

            @Override
            public void onTouch(ModifierTouchEventArgs args) {
                super.onTouch(args);

                final MotionEvent motionEvent = args.e;
                if (isZoomEnabled && motionEvent.getAction() == MotionEvent.ACTION_MOVE) {
                    onScrollInYDirection(motionEvent.getY());
                }
            }

            private void onScrollInYDirection(float y) {
                final float distance = Math.abs(y - start.y);
                if (distance < touchSlop || Math.abs(y - lastY) < 1f) return;

                this.isScrolling = true;

                final float prevDistance = Math.abs(lastY - start.y);
                final double diff = prevDistance > 0 ? distance / prevDistance - 1 : 0;

                growBy(start, getXAxis(), diff);

                this.lastY = y;
            }

            // zoom axis relative to the start point using fraction
            private void growBy(PointF point, IAxis axis, double fraction) {
                final int size = axis.getAxisViewportDimension();
                final float coord = size - point.y;

                double minFraction = (coord / size) * fraction;
                double maxFraction = (1 - coord / size) * fraction;

                axis.zoomBy(minFraction, maxFraction);
            }

            @Override
            protected void onUp(MotionEvent e) {
                // need to disable zoom after finishing scrolling
                if (isScrolling) {
                    isScrolling = isZoomEnabled = false;
                    start.set(Float.NaN, Float.NaN);
                    lastY = Float.NaN;
                }
            }
        }
        // </CreateCustomZoomGestureModifier>
    }
}
