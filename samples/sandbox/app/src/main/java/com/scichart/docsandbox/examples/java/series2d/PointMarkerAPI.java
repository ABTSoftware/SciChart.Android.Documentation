package com.scichart.docsandbox.examples.java.series2d;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;

import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.pointmarkers.DrawablePointMarker;
import com.scichart.charting.visuals.pointmarkers.EllipsePointMarker;
import com.scichart.charting.visuals.pointmarkers.IPointMarker;
import com.scichart.charting.visuals.pointmarkers.SpritePointMarker;
import com.scichart.charting.visuals.renderableSeries.FastLineRenderableSeries;
import com.scichart.docsandbox.R;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;
import com.scichart.drawing.common.IBrush2D;
import com.scichart.drawing.common.IPen2D;
import com.scichart.drawing.common.IRenderContext2D;
import com.scichart.drawing.common.SolidBrushStyle;
import com.scichart.drawing.common.SolidPenStyle;

@ExampleDefinition()
public class PointMarkerAPI extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) {

    }

    void createPointMarker() {
        // <CreatePointMarker>
        // Create an Ellipse PointMarker instance
        final EllipsePointMarker pointMarker = new EllipsePointMarker();
        pointMarker.setSize(40, 40);
        pointMarker.setStrokeStyle(new SolidPenStyle(Color.GREEN, false, 2.0f, null));
        pointMarker.setFillStyle(new SolidBrushStyle(Color.RED));

        // Apply the PointMarker to a LineSeries
        final FastLineRenderableSeries lineSeries = new FastLineRenderableSeries();
        lineSeries.setPointMarker(pointMarker);
        // </CreatePointMarker>
    }

    void extendDrawablePointMarker() {
        // <ExtendDrawablePointMarker>
        class EllipsePointMarker extends DrawablePointMarker {
            @Override
            protected void internalDraw(IRenderContext2D renderContext, float x, float y, IPen2D strokePen, IBrush2D fillBrush) {
                renderContext.drawEllipse(x, y, getWidth(), getHeight(), strokePen, fillBrush);
            }
        }
        // </ExtendDrawablePointMarker>
    }

    void createCustomPointMarkerDrawer() {
        // <CreateCustomPointMarkerDrawer>
        class CustomPointMarkerDrawer implements SpritePointMarker.ISpritePointMarkerDrawer {
            private final Drawable drawable;

            CustomPointMarkerDrawer(Context context, @DrawableRes int drawableId) {
                this.drawable = ResourcesCompat.getDrawable(context.getResources(), drawableId, null);
            }

            @Override
            public void onDraw(Canvas canvas, Paint stroke, Paint fill) {
                drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                drawable.draw(canvas);
            }
        }
        // </CreateCustomPointMarkerDrawer>

        // <UseCustomPointMarkerDrawer>
        final IPointMarker pointMarker = new SpritePointMarker(
                new CustomPointMarkerDrawer(requireContext(), R.drawable.example_weather_storm)
        );
        pointMarker.setSize(40, 40);

        // Apply the PointMarker to a LineSeries
        final FastLineRenderableSeries lineSeries = new FastLineRenderableSeries();
        lineSeries.setPointMarker(pointMarker);
        // </UseCustomPointMarkerDrawer>
    }
}
