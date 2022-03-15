package com.scichart.docsandbox.examples.java.series2d;

import android.animation.FloatEvaluator;
import android.view.animation.DecelerateInterpolator;

import androidx.annotation.NonNull;

import com.scichart.charting.model.dataSeries.IXyDataSeries;
import com.scichart.charting.model.dataSeries.XyDataSeries;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.animations.AnimationsHelper;
import com.scichart.charting.visuals.animations.BaseRenderPassDataTransformation;
import com.scichart.charting.visuals.animations.TransformationHelpers;
import com.scichart.charting.visuals.renderableSeries.FastLineRenderableSeries;
import com.scichart.charting.visuals.renderableSeries.data.LineRenderPassData;
import com.scichart.core.model.FloatValues;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;

import java.util.Random;

@ExampleDefinition()
public class AnimateAppendedPoint extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) { }

    void createAppendedPointTransformation() {
        // <CreateAppendedPointTransformation>
        class AppendedPointTransformation extends BaseRenderPassDataTransformation<LineRenderPassData> {
            private final FloatValues originalXCoordinates = new FloatValues();
            private final FloatValues originalYCoordinates = new FloatValues();

            protected AppendedPointTransformation() {
                super(LineRenderPassData.class);
            }

            @Override
            protected void saveOriginalData() {
                if (!renderPassData.isValid()) return;

                TransformationHelpers.copyData(renderPassData.xCoords, originalXCoordinates);
                TransformationHelpers.copyData(renderPassData.yCoords, originalYCoordinates);
            }

            @Override
            protected void applyTransformation() {
                if (!renderPassData.isValid()) return;

                int count = renderPassData.pointsCount();
                float currentTransformationValue = getCurrentTransformationValue();

                float xStart;
                if (count <= 1) {
                    xStart = renderPassData.getXCoordinateCalculator().getCoordinate(0.0);
                } else {
                    xStart = originalXCoordinates.get(count - 2);
                }
                float xFinish = originalXCoordinates.get(count - 1);
                float additionalX = xStart + (xFinish - xStart) * currentTransformationValue;
                renderPassData.xCoords.set(count - 1, additionalX);

                float yStart;
                if (count <= 1) {
                    yStart = renderPassData.getYCoordinateCalculator().getCoordinate(0.0);
                } else {
                    yStart = originalYCoordinates.get(count - 2);
                }
                float yFinish = originalYCoordinates.get(count - 1);
                float additionalY = yStart + (yFinish - yStart) * currentTransformationValue;
                renderPassData.yCoords.set(count - 1, additionalY);
            }

            @Override
            protected void discardTransformation() {
                TransformationHelpers.copyData(originalXCoordinates, renderPassData.xCoords);
                TransformationHelpers.copyData(originalYCoordinates, renderPassData.yCoords);
            }

            @Override
            protected void onInternalRenderPassDataChanged() {
                applyTransformation();
            }
        }
        // </CreateAppendedPointTransformation>

        final FastLineRenderableSeries rSeries = new FastLineRenderableSeries();
        final IXyDataSeries<Double, Double> dataSeries = new XyDataSeries<>(Double.class, Double.class);
        final long ANIMATION_DURATION = 500;
        final double MAX_Y_VALUE = 100.0;
        final Random random = new Random();
        double currentXValue = 0;
        double yValue = 0;

        // <UseAppendedPointTransformation>
        // Append new value to our dataSeries in real-time
        yValue = random.nextDouble() * MAX_Y_VALUE;
        dataSeries.append(currentXValue, yValue);

        // Animate renderable series with our custom transformation
        AnimationsHelper.createAnimator(
                rSeries,
                new AppendedPointTransformation(),
                ANIMATION_DURATION,
                0,
                new DecelerateInterpolator(),
                new FloatEvaluator(),
                0f, 1f
        ).start();
        // </UseAppendedPointTransformation>
    }
}
