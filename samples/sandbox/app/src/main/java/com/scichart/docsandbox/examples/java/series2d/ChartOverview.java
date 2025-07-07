package com.scichart.docsandbox.examples.java.series2d;

import android.graphics.Color;
import android.view.Gravity;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;

import com.scichart.charting.model.dataSeries.IDataSeries;
import com.scichart.charting.model.dataSeries.IOhlcDataSeries;
import com.scichart.charting.model.dataSeries.IXyDataSeries;
import com.scichart.charting.model.dataSeries.OhlcDataSeries;
import com.scichart.charting.model.dataSeries.XyDataSeries;
import com.scichart.charting.visuals.annotations.AnnotationCoordinateMode;
import com.scichart.charting.visuals.annotations.VerticalLineAnnotation;
import com.scichart.charting.visuals.axes.IAxis;
import com.scichart.charting.visuals.axes.NumericAxis;
import com.scichart.charting.visuals.overview.ISciChartOverviewTransformation;
import com.scichart.charting.visuals.renderableSeries.FastCandlestickRenderableSeries;
import com.scichart.charting.visuals.renderableSeries.FastLineRenderableSeries;
import com.scichart.charting.visuals.renderableSeries.IRenderableSeries;
import com.scichart.core.framework.UpdateSuspender;
import com.scichart.docsandbox.databinding.ExampleChartOverviewBinding;
import com.scichart.docsandbox.examples.base.ExampleBaseFragment;
import com.scichart.drawing.common.SolidPenStyle;
import com.scichart.drawing.utility.ColorUtil;

import java.util.Collections;
import java.util.Date;

public class ChartOverview extends ExampleBaseFragment<ExampleChartOverviewBinding> {

    @NonNull
    @Override
    protected ExampleChartOverviewBinding inflateBinding(@NonNull LayoutInflater inflater) {
        return ExampleChartOverviewBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void initExample(@NonNull ExampleChartOverviewBinding binding) {
        final IXyDataSeries<Double, Double> dataSeries = new XyDataSeries<>(Double.class, Double.class);
        dataSeries.append(0.0, 0.0);
        dataSeries.append(1.0, 1.0);
        dataSeries.append(2.0, 4.0);

        final FastLineRenderableSeries lineSeries = new FastLineRenderableSeries();

        lineSeries.setDataSeries(dataSeries);
        lineSeries.setStrokeStyle(new SolidPenStyle(Color.RED, true, 1f, null));

        UpdateSuspender.using(binding.surface, () -> {
            Collections.addAll(binding.surface.getXAxes(), new NumericAxis(requireContext()));
            Collections.addAll(binding.surface.getYAxes(), new NumericAxis(requireContext()));

            Collections.addAll(binding.surface.getRenderableSeries(), lineSeries);
        });

        // 2. Link Overview with Main Chart
        // <LinkOverviewChart>
        binding.overview.setParentSurface(binding.surface);
        // </LinkOverviewChart>

        // 3. Customize Grip Handles
        // <CustomizeOverviewGrip>
        binding.overview.setGrips(generateGrip(), generateGrip());
        // </CustomizeOverviewGrip>

        // 4. Apply Transformation to Renderable Series
        // <OverviewTransformation>
        binding.overview.setOverviewTransformation(new ISciChartOverviewTransformation() {
            @Override
            public IRenderableSeries transformRenderableSeries(IRenderableSeries renderableSeries) {
                if (renderableSeries instanceof FastCandlestickRenderableSeries) {
                    FastCandlestickRenderableSeries candleSeries = (FastCandlestickRenderableSeries) renderableSeries;

                    IOhlcDataSeries<Date, Double> originalData = (IOhlcDataSeries<Date, Double>) candleSeries.getDataSeries();

                    XyDataSeries<Date, Double> lineDataSeries = new XyDataSeries<>(Date.class, Double.class);

                    int count = originalData.getCount();
                    for (int i = 0; i < count; i++) {

                        Date x = (Date) originalData.getXValues().get(i);
                        double high = ((Number) originalData.getHighValues().get(i)).doubleValue();
                        double low = ((Number) originalData.getLowValues().get(i)).doubleValue();
                        double average = (high + low) / 2.0;
                        lineDataSeries.append(x, average);
                    }

                    FastLineRenderableSeries lineSeries = new FastLineRenderableSeries();
                    lineSeries.setDataSeries(lineDataSeries);

                    return lineSeries;
                } else {
                    return renderableSeries;
                }

            }
        });
        // </OverviewTransformation>
    }

    private void getXAxis(){
        // <OverviewGetAxis>
        IAxis overviewAxis = binding.overview.getxAxis();
        // </OverviewGetAxis>
    }

    private void setGripThreshold(){
        // <OverviewSetGripThreshold>
        binding.overview.setGripThreshold(20.0);
        // </OverviewSetGripThreshold>
    }


    // <GenerateOverviewGrip>
    private VerticalLineAnnotation generateGrip() {
        VerticalLineAnnotation annotation = new VerticalLineAnnotation(getContext());

        annotation.setCoordinateMode(AnnotationCoordinateMode.RelativeY);
        annotation.setVerticalGravity(Gravity.CENTER_VERTICAL);
        annotation.setStroke(new SolidPenStyle(ColorUtil.Grey, true, 7f, null));

        return annotation;
    }
    // </GenerateOverviewGrip>
}
