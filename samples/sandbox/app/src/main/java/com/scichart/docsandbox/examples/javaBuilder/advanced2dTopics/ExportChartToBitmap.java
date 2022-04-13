package com.scichart.docsandbox.examples.javaBuilder.advanced2dTopics;

import android.graphics.Bitmap;

import androidx.annotation.NonNull;

import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.rendering.SciChartSurfaceExportUtil;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;
import com.scichart.drawing.canvas.RenderSurface;

@ExampleDefinition()
public class ExportChartToBitmap extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) { }

    void exportToBitmap(@NonNull SciChartSurface surface) {
        // <ExportToBitmap>
        // Assume a surface has been created and configured somewhere
        final Bitmap screenshot = surface.exportToBitmap();
        // </ExportToBitmap>
    }

    void exportToBitmapInMemoryAtSize() {
        // <ExportToBitmapInMemoryAtSize>
        // create new SciChartSurface
        final SciChartSurface sciChartSurface = new SciChartSurface(getActivity());

        // init it with axes, series etc
        initSurface(sciChartSurface);

        // prepare it for export at specified size
        SciChartSurfaceExportUtil.prepareSurfaceForExport(sciChartSurface, 800, 600);

        // export it to Bitmap
        final Bitmap screenshot = sciChartSurface.exportToBitmap();
        // </ExportToBitmapInMemoryAtSize>
    }

    void setRenderSurface(@NonNull SciChartSurface surface) {
        // <SetRenderSurface>
        // Assume a surface has been created and configured somewhere
        surface.setRenderSurface(new RenderSurface(getContext()));
        // </SetRenderSurface>
    }

    private void initSurface(@NonNull SciChartSurface surface) { }
}
