package com.scichart.docsandbox.examples.java.axisAPIs;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;

import com.scichart.charting.model.dataSeries.OhlcDataSeries;
import com.scichart.charting.numerics.indexDataProvider.DataSeriesIndexDataProvider;
import com.scichart.charting.numerics.indexDataProvider.IIndexDataProvider;
import com.scichart.charting.visuals.axes.IndexDateAxis;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;

import java.util.Calendar;
import java.util.Date;

@ExampleDefinition()
public class AxisAPIsIndexDateAxis extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) { }

    void indexDateAxis() {
        // <IndexDateAxis>
        IndexDateAxis indexDateAxis = new IndexDateAxis(getContext());

        OhlcDataSeries dataSeries = new OhlcDataSeries(Date.class, Double.class);
        IIndexDataProvider indexDataProvider = new DataSeriesIndexDataProvider(dataSeries);

        indexDateAxis.setIndexDataProvider(indexDataProvider);

        // </IndexDateAxis>
    }
}
