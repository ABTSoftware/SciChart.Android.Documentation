package com.scichart.tutorial;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.scichart.charting.model.dataSeries.XyDataSeries;
import com.scichart.charting.modifiers.ModifierGroup;
import com.scichart.charting.modifiers.PinchZoomModifier;
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
import com.scichart.drawing.common.SolidPenStyle;
import com.scichart.extensions.builders.SciChartBuilder;

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

    private SciChartBuilder sciChartBuilder;

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

        SciChartBuilder.init(this);
        sciChartBuilder = SciChartBuilder.instance();

        LinearLayout chartLayout = findViewById(R.id.chart_layout);

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

        lineDataSeries = sciChartBuilder.newXyDataSeries(Integer.class, Double.class)
                .withSeriesName("Line Series")
                .withFifoCapacity(fifoCapacity)
                .build();
        scatterDataSeries = sciChartBuilder.newXyDataSeries(Integer.class, Double.class)
                .withSeriesName("Scatter Series")
                .withFifoCapacity(fifoCapacity)
                .build();

        mountainDataSeries = sciChartBuilder.newXyDataSeries(Integer.class, Double.class)
                .withSeriesName("Mountain Series")
                .withFifoCapacity(fifoCapacity)
                .build();

        for (int i = 0; i < pointsCount; i++) {
            lineDataSeries.append(i, Math.sin(i * 0.1));
            scatterDataSeries.append(i, Math.cos(i * 0.1));
            mountainDataSeries.append(i, Math.cos(i * 0.1));
            count += 1;
        }

        final FastLineRenderableSeries lineSeries = sciChartBuilder.newLineSeries()
                .withYAxisId("Primary Y-Axis")
                .withDataSeries(lineDataSeries)
                .build();

        final EllipsePointMarker pointMarker = sciChartBuilder
                .newPointMarker(new EllipsePointMarker())
                .withFill(0xFF32CD32)
                .withSize(10)
                .build();

        final XyScatterRenderableSeries scatterSeries = sciChartBuilder.newScatterSeries()
                .withYAxisId("Secondary Y-Axis")
                .withDataSeries(scatterDataSeries)
                .withPointMarker(pointMarker)
                .build();

        UpdateSuspender.using(surface, () -> {
            Collections.addAll(surface.getRenderableSeries(), lineSeries, scatterSeries);
        });

        // <AddMountainSeries>
        final FastMountainRenderableSeries mountainSeries = sciChartBuilder.newMountainSeries()
                .withYAxisId("Primary Y-Axis")
                .withDataSeries(mountainDataSeries)
                .withStrokeStyle(new SolidPenStyle(0xFF0271B1, false, 1.0f, null))
                .withAreaFillColor(0xAAFF8D42)
                .build();

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
        final IAxis yAxisRight = sciChartBuilder.newNumericAxis()
                .withAxisTitle("Primary Y-Axis")
                .withAxisId("Primary Y-Axis")
                .withAxisAlignment(AxisAlignment.Right)
                .build();

        // Create another numeric axis, left-aligned
        final IAxis yAxisLeft = sciChartBuilder.newNumericAxis()
                .withAxisTitle("Secondary Y-Axis")
                .withAxisId("Secondary Y-Axis")
                .withAxisAlignment(AxisAlignment.Left)
                .withGrowBy(new DoubleRange(0.2, 0.2))
                .build();

        ModifierGroup rolloverModifier = sciChartBuilder.newModifierGroup()
                .withRolloverModifier()
                .build()
                .withReceiveHandledEvents(true)
                .withMotionEventsGroup("SharedEventGroup")
                .build();

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
        final NumericAxis xAxis = sciChartBuilder.newNumericAxis()
                .withVisibleRange(sharedXRange)
                .build();

        // Create another X axis and apply sharedXRange
        final NumericAxis xAxis2 = sciChartBuilder.newNumericAxis()
                .withVisibleRange(sharedXRange)
                .build();
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
        final ModifierGroup modifierGroup = sciChartBuilder.newModifierGroup()
                .withMotionEventsGroup("SharedEventGroup")
                .withReceiveHandledEvents(true)
                .build();

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
            final TextAnnotation label = sciChartBuilder.newTextAnnotation()
                    .withYAxisId(x % 200 == 0 ? "Primary Y-Axis" : "Secondary Y-Axis")
                    .withText("N")
                    .withX1(x)
                    .withY1(0)
                    .withHorizontalAnchorPoint(HorizontalAnchorPoint.Center)
                    .withVerticalAnchorPoint(VerticalAnchorPoint.Center)
                    .withFontStyle(30f, Color.WHITE)
                    .build();

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
