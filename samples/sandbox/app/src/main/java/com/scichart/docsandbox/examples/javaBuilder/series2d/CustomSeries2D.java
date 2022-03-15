package com.scichart.docsandbox.examples.javaBuilder.series2d;

import android.content.Context;
import android.util.DisplayMetrics;

import androidx.annotation.NonNull;

import com.scichart.charting.model.dataSeries.IDataSeries;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.renderableSeries.FastColumnRenderableSeries;
import com.scichart.charting.visuals.renderableSeries.data.ColumnRenderPassData;
import com.scichart.charting.visuals.renderableSeries.data.ISeriesRenderPassData;
import com.scichart.charting.visuals.renderableSeries.hitTest.ColumnHitProvider;
import com.scichart.charting.visuals.renderableSeries.hitTest.NearestColumnPointProvider;
import com.scichart.core.model.FloatValues;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;
import com.scichart.drawing.common.BrushStyle;
import com.scichart.drawing.common.IAssetManager2D;
import com.scichart.drawing.common.IBrush2D;
import com.scichart.drawing.common.IRenderContext2D;
import com.scichart.drawing.common.SolidBrushStyle;

@ExampleDefinition()
public class CustomSeries2D extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) { }

    // <CreateCustomSeries>
    class RoundedColumnsRenderableSeries extends FastColumnRenderableSeries {

        private final FloatValues topEllipseBuffer = new FloatValues();
        private final FloatValues rectsBuffer = new FloatValues();
        private final FloatValues bottomEllipseBuffer = new FloatValues();

        public RoundedColumnsRenderableSeries() {
            super(new ColumnRenderPassData(), new ColumnHitProvider(), new NearestColumnPointProvider());
        }

        @Override
        protected void disposeCachedData() {
            super.disposeCachedData();

            topEllipseBuffer.disposeItems();
            rectsBuffer.disposeItems();
            bottomEllipseBuffer.disposeItems();
        }

        @Override
        protected void internalDraw(IRenderContext2D renderContext, IAssetManager2D assetManager, ISeriesRenderPassData renderPassData) {
            // Don't draw transparent series
            final float opacity = getOpacity();
            if (opacity == 0) return;

            final BrushStyle fillBrush = getFillBrushStyle();
            if (fillBrush == null || !fillBrush.isVisible()) return;

            final ColumnRenderPassData rpd = (ColumnRenderPassData) renderPassData;
            final float diameter = rpd.columnPixelWidth;
            updateDrawingBuffers(rpd, diameter, rpd.zeroLineCoord);

            final IBrush2D brush = assetManager.createBrush(fillBrush);
            renderContext.fillRects(rectsBuffer.getItemsArray(), 0, rectsBuffer.size(), brush);
            renderContext.drawEllipses(topEllipseBuffer.getItemsArray(), 0, topEllipseBuffer.size(), diameter, diameter, brush);
            renderContext.drawEllipses(bottomEllipseBuffer.getItemsArray(), 0, bottomEllipseBuffer.size(), diameter, diameter, brush);
        }

        private void updateDrawingBuffers(ColumnRenderPassData renderPassData, float columnPixelWidth, float zeroLine) {
            final float halfWidth = columnPixelWidth / 2;

            topEllipseBuffer.setSize(renderPassData.pointsCount() * 2);
            rectsBuffer.setSize(renderPassData.pointsCount() * 4);
            bottomEllipseBuffer.setSize(renderPassData.pointsCount() * 2);

            final float[] topArray = topEllipseBuffer.getItemsArray();
            final float[] rectsArray = rectsBuffer.getItemsArray();
            final float[] bottomArray = bottomEllipseBuffer.getItemsArray();

            final float[] xCoordsArray = renderPassData.xCoords.getItemsArray();
            final float[] yCoordsArray = renderPassData.yCoords.getItemsArray();
            for (int i = 0, count = renderPassData.pointsCount(); i < count; i++) {
                final float x = xCoordsArray[i];
                final float y = yCoordsArray[i];

                topArray[i * 2] = x;
                topArray[i * 2 + 1] = y - halfWidth;

                rectsArray[i * 4] = x - halfWidth;
                rectsArray[i * 4 + 1] = y - halfWidth;
                rectsArray[i * 4 + 2] = x + halfWidth;
                rectsArray[i * 4 + 3] = zeroLine + halfWidth;

                bottomArray[i * 2] = x;
                bottomArray[i * 2 + 1] = zeroLine + halfWidth;
            }
        }

        class Builder {
            private final DisplayMetrics displayMetrics;
            private final RoundedColumnsRenderableSeries renderableSeries;

            public Builder(Context context) {
                this.displayMetrics = context.getResources().getDisplayMetrics();
                this.renderableSeries = new RoundedColumnsRenderableSeries();
            }

            public Builder withDataSeries(IDataSeries<?,?> dataSeries) {
                renderableSeries.setDataSeries(dataSeries);
                return this;
            }

            public Builder withFillColor(int fillColor) {
                renderableSeries.setFillBrushStyle(new SolidBrushStyle(fillColor));
                return this;
            }

            public RoundedColumnsRenderableSeries build() {
                return renderableSeries;
            }
        }
    }
    // </CreateCustomSeries>
}
