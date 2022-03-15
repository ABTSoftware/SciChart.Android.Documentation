package com.scichart.tutorial;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.scichart.charting.model.dataSeries.XyDataSeries;
import com.scichart.charting.modifiers.PinchZoomModifier;
import com.scichart.charting.modifiers.RolloverModifier;
import com.scichart.charting.modifiers.XAxisDragModifier;
import com.scichart.charting.modifiers.YAxisDragModifier;
import com.scichart.charting.modifiers.ZoomExtentsModifier;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.annotations.HorizontalAnchorPoint;
import com.scichart.charting.visuals.annotations.TextAnnotation;
import com.scichart.charting.visuals.annotations.VerticalAnchorPoint;
import com.scichart.charting.visuals.axes.AxisAlignment;
import com.scichart.charting.visuals.axes.IAxis;
import com.scichart.charting.visuals.axes.NumericAxis;
import com.scichart.charting.visuals.pointmarkers.EllipsePointMarker;
import com.scichart.charting.visuals.renderableSeries.FastLineRenderableSeries;
import com.scichart.charting.visuals.renderableSeries.FastMountainRenderableSeries;
import com.scichart.charting.visuals.renderableSeries.XyScatterRenderableSeries;
import com.scichart.core.framework.UpdateSuspender;
import com.scichart.data.model.DoubleRange;
import com.scichart.drawing.common.FontStyle;
import com.scichart.drawing.common.SolidBrushStyle;
import com.scichart.drawing.common.SolidPenStyle;

import java.util.Collections;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    private int fifoCapacity = 300;
    private int pointsCount = 200;

    private ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
    private ScheduledFuture schedule;

    private XyDataSeries lineDataSeries;
    private XyDataSeries scatterDataSeries;
    private XyDataSeries mountainDataSeries;

    private SciChartSurface surface;
    private SciChartSurface surface2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            SciChartSurface.setRuntimeLicenseKey("");
        } catch (Exception e) {
            Log.e("SciChart", "Error during setting license key", e);
        }

        final LinearLayout chartLayout = findViewById(R.id.chart_layout);

        // <AddTwoSurfaces>
        surface = new SciChartSurface(this);
        surface2 = new SciChartSurface(this);
        chartLayout.addView(surface);
        chartLayout.addView(surface2);

        // Set layout parameters for both surfaces
        final LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT,
                1.0f
        );
        surface.setLayoutParams(layoutParams);
        surface2.setLayoutParams(layoutParams);
        // </AddTwoSurfaces>

        lineDataSeries = new XyDataSeries(Integer.class, Double.class);
        lineDataSeries.setSeriesName("Line Series");
        lineDataSeries.setFifoCapacity(fifoCapacity);

        scatterDataSeries = new XyDataSeries(Integer.class, Double.class);
        scatterDataSeries.setSeriesName("Scatter Series");
        scatterDataSeries.setFifoCapacity(fifoCapacity);

        mountainDataSeries = new XyDataSeries(Integer.class, Double.class);
        mountainDataSeries.setSeriesName("Mountain Series");
        mountainDataSeries.setFifoCapacity(fifoCapacity);

        for (int i = 0; i < pointsCount; i++) {
            lineDataSeries.append(i, Math.sin(i * 0.1));
            scatterDataSeries.append(i, Math.cos(i * 0.1));
            mountainDataSeries.append(i, Math.cos(i * 0.1));
            count += 1;
        }

        final FastLineRenderableSeries lineSeries = new FastLineRenderableSeries();
        lineSeries.setYAxisId("Primary Y-Axis");
        lineSeries.setDataSeries(lineDataSeries);

        final EllipsePointMarker pointMarker = new EllipsePointMarker();
        pointMarker.setFillStyle(new SolidBrushStyle(0xFF32CD32));
        pointMarker.setSize(10, 10);

        final XyScatterRenderableSeries scatterSeries = new XyScatterRenderableSeries();
        scatterSeries.setYAxisId("Secondary Y-Axis");
        scatterSeries.setDataSeries(scatterDataSeries);
        scatterSeries.setPointMarker(pointMarker);

        UpdateSuspender.using(surface, () -> {
            Collections.addAll(surface.getRenderableSeries(), lineSeries, scatterSeries);
        });

        // <AddMountainSeries>
        final FastMountainRenderableSeries mountainSeries = new FastMountainRenderableSeries();
        mountainSeries.setYAxisId("Primary Y-Axis");
        mountainSeries.setDataSeries(mountainDataSeries);
        mountainSeries.setStrokeStyle(new SolidPenStyle(0xFF0271B1, false, 1.0f, null));
        mountainSeries.setAreaStyle( new SolidBrushStyle(0xAAFF8D42));

        UpdateSuspender.using(surface2, () -> {
            Collections.addAll(surface2.getRenderableSeries(), mountainSeries);
        });
        // </AddMountainSeries>

        // <SetupSurfaces2>
        setupSurface(surface);
        setupSurface(surface2);
        // </SetupSurfaces2>

        schedule = scheduledExecutorService.scheduleWithFixedDelay(updateData, 0, 10, TimeUnit.MILLISECONDS);
    }

    private Integer count = 0;

    // <AddAnnotations>
    private final Runnable updateData = () -> {
        Integer x = count;
        UpdateSuspender.using(surface, () -> {
            lineDataSeries.append(x, Math.sin(x* 0.1));
            scatterDataSeries.append(x, Math.cos(x * 0.1));
            mountainDataSeries.append(x, Math.cos(x * 0.1));

            tryAddAnnotationAt(x);

            // zoom series to fit viewport size into X-Axis direction
            surface.zoomExtentsX();
            surface2.zoomExtentsX();
            count += 1;
        });
    };

    // <SetupSurfaces1>
    private void setupSurface(SciChartSurface surface) {
        // Create another numeric axis, right-aligned
        final IAxis yAxisRight = new NumericAxis(this);
        yAxisRight.setAxisTitle("Primary Y-Axis");
        yAxisRight.setAxisId("Primary Y-Axis");
        yAxisRight.setAxisAlignment(AxisAlignment.Right);

        // Create another numeric axis, left-aligned
        final IAxis yAxisLeft = new NumericAxis(this);
        yAxisLeft.setAxisTitle("Secondary Y-Axis");
        yAxisLeft.setAxisId("Secondary Y-Axis");
        yAxisLeft.setAxisAlignment(AxisAlignment.Left);
        yAxisLeft.setGrowBy(new DoubleRange(0.2, 0.2));

        final RolloverModifier rolloverModifier = new RolloverModifier();
        rolloverModifier.setReceiveHandledEvents(true);
        rolloverModifier.setEventsGroupTag("SharedEventGroup");

        UpdateSuspender.using(surface, () -> {
            Collections.addAll(surface.getXAxes(), new NumericAxis(this));
            Collections.addAll(surface.getYAxes(), yAxisLeft, yAxisRight);
            Collections.addAll(surface.getChartModifiers(),
                    new ZoomExtentsModifier(),
                    new PinchZoomModifier(),
                    rolloverModifier,
                    new XAxisDragModifier(),
                    new YAxisDragModifier());
        });
    }
    // </SetupSurfaces1>

    /*
        // <SynchronizeVisibleRanges>
        final DoubleRange sharedXRange = new DoubleRange();

        // Create an X axis and apply sharedXRange
        final NumericAxis xAxis = new NumericAxis(this);
        xAxis.setVisibleRange(sharedXRange);

        // Create another X axis and apply sharedXRange
        final NumericAxis xAxis2 = new NumericAxis(this);
        xAxis2.setVisibleRange(sharedXRange);
        // </SynchronizeVisibleRanges>
     */

    /*
        // <AddVerticalGroup>
        final SciChartVerticalGroup verticalGroup = new SciChartVerticalGroup();
        verticalGroup.addSurfaceToGroup(surface);
        verticalGroup.addSurfaceToGroup(surface2);
        // </AddVerticalGroup>
     */

    /*
        // <SetModifierGroup>
        final ModifierGroup modifierGroup = new ModifierGroup();
        modifierGroup.setMotionEventGroup("SharedEventGroup");
        modifierGroup.setReceiveHandledEvents(true);
        Collections.addAll(modifierGroup.getChildModifiers(),
                new ZoomExtentsModifier(),
                new PinchZoomModifier(),
                rolloverModifier,
                new XAxisDragModifier(),
                new YAxisDragModifier());
        // </SetModifierGroup>
     */

    private void tryAddAnnotationAt(int x) {
        // add label every 100 data points
        if (x % 100 == 0) {
            final TextAnnotation label = new TextAnnotation(this);
            label.setYAxisId(x % 200 == 0 ? "Primary Y-Axis" : "Secondary Y-Axis");
            label.setText("N");
            label.setX1(x);
            label.setY1(0);
            label.setHorizontalAnchorPoint(HorizontalAnchorPoint.Center);
            label.setVerticalAnchorPoint(VerticalAnchorPoint.Center);
            label.setFontStyle(new FontStyle(30f, Color.WHITE));

            // add label into annotation collection
            surface.getAnnotations().add(label);

            // if we add annotation and x > fifoCapacity
            // then we need to remove annotation which goes out of the screen
            if (x > fifoCapacity) {
                surface.getAnnotations().remove(0);
            }
        }
    }
}
