package com.scichart.docsandbox.examples.javaBuilder.advanced2dTopics;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;

import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;
import com.scichart.drawing.canvas.RenderSurface;
import com.scichart.drawing.common.IRenderSurface;
import com.scichart.drawing.opengl.RenderSurfaceGL;

@ExampleDefinition()
public class RendererPlugins extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) { }

    void setRenderSurface(@NonNull SciChartSurface surface) {
        // <SetRenderSurface>
        // Assume a surface has been created and configured somewhere
        surface.setRenderSurface(new RenderSurfaceGL(getContext()));
        // </SetRenderSurface>
    }

    void createCanvasSciChartSurface() {
        // <CreateCanvasSciChartSurface>
        class CanvasSciChartSurface extends SciChartSurface {
            public CanvasSciChartSurface(Context context) {
                super(context);
            }
            public CanvasSciChartSurface(Context context, AttributeSet attrs) {
                super(context, attrs);
            }
            public CanvasSciChartSurface(Context context, AttributeSet attrs, int defStyleAttr) {
                super(context, attrs, defStyleAttr);
            }
            @Override
            protected IRenderSurface getDefaultRenderSurface(Context context) {
                return new RenderSurface(context); // return Canvas based IRenderSurface
            }
        }
        // </CreateCanvasSciChartSurface>
    }
}
