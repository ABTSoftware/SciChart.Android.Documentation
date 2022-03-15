package com.scichart.docsandbox.examples.java.series2d;

import android.animation.FloatEvaluator;
import android.view.animation.DecelerateInterpolator;

import androidx.annotation.NonNull;

import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.animations.AnimationsHelper;
import com.scichart.charting.visuals.animations.BaseRenderPassDataTransformation;
import com.scichart.charting.visuals.animations.CompositeTransformation;
import com.scichart.charting.visuals.animations.ScaleXyTransformation;
import com.scichart.charting.visuals.animations.SweepXyTransformation;
import com.scichart.charting.visuals.animations.TranslateXTransformation;
import com.scichart.charting.visuals.animations.TranslateXyTransformation;
import com.scichart.charting.visuals.animations.WaveOhlcTransformation;
import com.scichart.charting.visuals.animations.WaveXyTransformation;
import com.scichart.charting.visuals.renderableSeries.FastBandRenderableSeries;
import com.scichart.charting.visuals.renderableSeries.FastCandlestickRenderableSeries;
import com.scichart.charting.visuals.renderableSeries.FastColumnRenderableSeries;
import com.scichart.charting.visuals.renderableSeries.FastFixedErrorBarsRenderableSeries;
import com.scichart.charting.visuals.renderableSeries.FastLineRenderableSeries;
import com.scichart.charting.visuals.renderableSeries.IRenderableSeries;
import com.scichart.charting.visuals.renderableSeries.data.OhlcRenderPassData;
import com.scichart.charting.visuals.renderableSeries.data.XyRenderPassData;
import com.scichart.core.model.FloatValues;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;
import com.scichart.docsandbox.examples.utils.interpolator.ElasticOutInterpolator;

@ExampleDefinition()
public class AnimationsAPI extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) { }

    void animateLineSeries() {
        // <AnimateLineSeries>
        // declare FastLineRenderableSeries to animate
        final FastLineRenderableSeries rSeries = new FastLineRenderableSeries();

        // Animate Line Series with Sweep Transformation
        AnimationsHelper.createAnimator(
                rSeries,
                new SweepXyTransformation<>(XyRenderPassData.class),
                3000,
                350,
                new DecelerateInterpolator(),
                new FloatEvaluator(),
                0f, 1f
        ).start();
        // </AnimateLineSeries>
    }

    void fadeInAnimation() {
        IRenderableSeries rSeries = new FastLineRenderableSeries();
        // <FadeInAnimation>
        AnimationsHelper.createOpacityAnimator(
                rSeries,
                2000,
                350,
                new DecelerateInterpolator(),
                new FloatEvaluator(),
                0f, 1f
        ).start();
        // </FadeInAnimation>
    }

    void scaleAnimation() {
        final FastBandRenderableSeries rSeries = new FastBandRenderableSeries();
        // <ScaleAnimation>
        AnimationsHelper.createAnimator(
                rSeries,
                new ScaleXyTransformation<>(XyRenderPassData.class, 0),
                3000,
                350,
                new ElasticOutInterpolator(),
                new FloatEvaluator(),
                0f, 1f
        ).start();
        // </ScaleAnimation>
    }

    void sweepAnimation() {
        final FastBandRenderableSeries rSeries = new FastBandRenderableSeries();
        // <SweepAnimation>
        AnimationsHelper.createAnimator(
                rSeries,
                new SweepXyTransformation(XyRenderPassData.class),
                3000,
                350,
                new DecelerateInterpolator(),
                new FloatEvaluator(),
                0f, 1f
        ).start();
        // </SweepAnimation>
    }

    void waveAnimation() {
        final FastColumnRenderableSeries rSeries = new FastColumnRenderableSeries();
        // <WaveAnimation>
        AnimationsHelper.createAnimator(
                rSeries,
                new WaveXyTransformation(XyRenderPassData.class, 0, 0.5f),
                3000,
                350,
                new DecelerateInterpolator(),
                new FloatEvaluator(),
                0f,
                1f
        ).start();
        // </WaveAnimation>
    }

    void translateXAnimation() {
        final FastColumnRenderableSeries rSeries = new FastColumnRenderableSeries();
        // <TranslateXAnimation>
        AnimationsHelper.createAnimator(
                rSeries,
                new TranslateXTransformation(XyRenderPassData.class, -500),
                3000,
                350,
                new DecelerateInterpolator(),
                new FloatEvaluator(),
                0f,
                1f
        ).start();
        // </TranslateXAnimation>
    }

    void translateYAnimation() {
        final FastFixedErrorBarsRenderableSeries rSeries = new FastFixedErrorBarsRenderableSeries();
        // <TranslateYAnimation>
        AnimationsHelper.createAnimator(
                rSeries,
                new TranslateXyTransformation<>(XyRenderPassData.class, -500),
                3000,
                350,
                new DecelerateInterpolator(),
                new FloatEvaluator(),
                0f,
                1f
        ).start();
        // </TranslateYAnimation>
    }

    void compositeTransformation() {
        // <CompositeTransformation>
        // declare Candlestick Series to animate
        final FastCandlestickRenderableSeries rSeries = new FastCandlestickRenderableSeries();

        // Create transformations and make a Composite one out of them
        final WaveOhlcTransformation wave = new WaveOhlcTransformation(OhlcRenderPassData.class, 0, 0.5f);
        final TranslateXTransformation translateX = new TranslateXTransformation(OhlcRenderPassData.class, -300);
        final CompositeTransformation composite = new CompositeTransformation(wave, translateX);

        // Animate Candlestick Series with Composite Transformation
        AnimationsHelper.createAnimator(
                rSeries,
                composite,
                3000,
                350,
                new DecelerateInterpolator(),
                new FloatEvaluator(),
                0f,
                1f
        ).start();
        // </CompositeTransformation>
    }

    void createCustomAnimation() {
        // <CreateCustomAnimation>
        class CustomXyTransformation extends BaseRenderPassDataTransformation<XyRenderPassData> {
            private final FloatValues originalXCoordinates = new FloatValues();
            private final FloatValues originalYCoordinates = new FloatValues();

            private final double centerX;
            private final double centerY;

            private float zeroXCoord, zeroYCoord;

            public CustomXyTransformation(double centerX, double centerY) {
                super(XyRenderPassData.class);

                this.centerX = centerX;
                this.centerY = centerY;
            }

            @Override
            protected void saveOriginalData() {
                final int count = renderPassData.pointsCount();

                // clear buffers
                originalXCoordinates.clear();
                originalYCoordinates.clear();

                // save initial xCoords and yCoords
                originalXCoordinates.add(renderPassData.xCoords.getItemsArray(), 0, count);
                originalYCoordinates.add(renderPassData.yCoords.getItemsArray(), 0, count);

                zeroXCoord = renderPassData.getXCoordinateCalculator().getCoordinate(centerX);
                zeroYCoord = renderPassData.getYCoordinateCalculator().getCoordinate(centerY);
            }

            @Override
            protected void applyTransformation() {
                // transform current render pass data
                transformValues(renderPassData.xCoords, originalXCoordinates, zeroXCoord);
                transformValues(renderPassData.yCoords, originalYCoordinates, zeroYCoord);
            }
            private void transformValues(FloatValues valuesToTransform, FloatValues originalCoordinates, float zeroCoord) {
                final float transformationValue = 1 - getCurrentTransformationValue();
                // calculate new values to display based on original value
                final float[] itemsArray = valuesToTransform.getItemsArray();
                final float[] originalValues = originalCoordinates.getItemsArray();
                for (int i = 0, size = renderPassData.pointsCount(); i < size; i++) {
                    final float originalValue = originalValues[i];
                    itemsArray[i] = originalValue - (originalValue - zeroCoord) * transformationValue;
                }
            }

            @Override
            protected void discardTransformation() {
                // clear coordinate buffers
                renderPassData.xCoords.clear();
                renderPassData.yCoords.clear();

                // save initial xCoords and yCoords
                renderPassData.xCoords.add(originalXCoordinates.getItemsArray(), 0, originalXCoordinates.size());
                renderPassData.yCoords.add(originalYCoordinates.getItemsArray(), 0, originalYCoordinates.size());
            }
            @Override
            protected void onInternalRenderPassDataChanged() { }
        }
        // </CreateCustomAnimation>

        final FastLineRenderableSeries rSeries = new FastLineRenderableSeries();
        // <UseCustomAnimation>
        AnimationsHelper.createAnimator(
                rSeries,
                new CustomXyTransformation(150, 300),
                3000,
                350,
                new DecelerateInterpolator(),
                new FloatEvaluator(),
                0f,
                1f
        ).start();
        // </UseCustomAnimation>
    }
}
