package com.scichart.docsandbox.examples.java.series2d;

import android.animation.Animator;
import android.animation.FloatEvaluator;
import android.view.animation.DecelerateInterpolator;

import androidx.annotation.NonNull;

import com.scichart.charting.model.dataSeries.IXyDataSeries;
import com.scichart.charting.model.dataSeries.XyDataSeries;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.animations.AnimationsHelper;
import com.scichart.charting.visuals.animations.BaseRenderPassDataTransformation;
import com.scichart.charting.visuals.animations.TransformationHelpers;
import com.scichart.charting.visuals.renderableSeries.StackedColumnRenderableSeries;
import com.scichart.charting.visuals.renderableSeries.data.StackedColumnRenderPassData;
import com.scichart.core.framework.UpdateSuspender;
import com.scichart.core.model.FloatValues;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;
import com.scichart.drawing.common.SolidPenStyle;

import java.util.Random;

@ExampleDefinition()
public class AnimateUpdatedPoint extends SingleChart2DFragment {

    private final IXyDataSeries<Double, Double> dataSeries1 = new XyDataSeries(Double.class, Double.class);
    private final IXyDataSeries<Double, Double> dataSeries2 = new XyDataSeries(Double.class, Double.class);

    private StackedColumnRenderableSeries rSeries1;
    private StackedColumnRenderableSeries rSeries2;

    private final static long ANIMATION_DURATION = 500;
    private final static int X_VALUES_COUNT = 12;
    private final static double MAX_Y_VALUE = 100.0;

    private final Random random = new Random();

    @Override
    protected void initExample(@NonNull SciChartSurface surface) {
        rSeries1 = new StackedColumnRenderableSeries();
        rSeries1.setDataSeries(dataSeries1);
        rSeries1.setStrokeStyle(new SolidPenStyle(0xff226fb7, false, 1f, null));

        rSeries2 = new StackedColumnRenderableSeries();
        rSeries2.setDataSeries(dataSeries2);
        rSeries2.setStrokeStyle(new SolidPenStyle(0xffff9a2e, false, 1f, null));
    }

    // <CreateUpdatedPointTransformationClass>
    class UpdatedPointTransformation extends BaseRenderPassDataTransformation<StackedColumnRenderPassData> {
        private final FloatValues previousYCoordinates = new FloatValues();
        private final FloatValues previousPrevSeriesYCoordinates = new FloatValues();

        private final FloatValues originalYCoordinates = new FloatValues();
        private final FloatValues originalPrevSeriesYCoordinates = new FloatValues();

        protected UpdatedPointTransformation() {
            super(StackedColumnRenderPassData.class);
        }

        @Override
        protected void saveOriginalData() {
            if (!renderPassData.isValid()) return;

            TransformationHelpers.copyData(renderPassData.yCoords, originalYCoordinates);
            TransformationHelpers.copyData(renderPassData.prevSeriesYCoords, originalPrevSeriesYCoordinates);
        }

        @Override
        protected void applyTransformation() {
            if (!renderPassData.isValid()) return;

            int count = renderPassData.pointsCount();
            float currentTransformationValue = getCurrentTransformationValue();

            if (previousPrevSeriesYCoordinates.size() != count ||
                    previousYCoordinates.size() != count ||
                    originalYCoordinates.size() != count ||
                    originalPrevSeriesYCoordinates.size() != count) return;

            for (int i = 0; i < count; i++) {
                float startYCoord = previousYCoordinates.get(i);
                float originalYCoordinate = originalYCoordinates.get(i);
                float additionalY = startYCoord + (originalYCoordinate - startYCoord) * currentTransformationValue;

                float startPrevSeriesYCoords = previousPrevSeriesYCoordinates.get(i);
                float originalPrevSeriesYCoordinate = originalPrevSeriesYCoordinates.get(i);
                float additionalPrevSeriesY = startPrevSeriesYCoords + (originalPrevSeriesYCoordinate - startPrevSeriesYCoords) * currentTransformationValue;

                renderPassData.yCoords.set(i, additionalY);
                renderPassData.prevSeriesYCoords.set(i, additionalPrevSeriesY);
            }
        }

        @Override
        protected void discardTransformation() {
            TransformationHelpers.copyData(originalYCoordinates, renderPassData.yCoords);
            TransformationHelpers.copyData(originalPrevSeriesYCoordinates, renderPassData.prevSeriesYCoords);
        }

        @Override
        protected void onInternalRenderPassDataChanged() {
            applyTransformation();
        }

        @Override
        public void onAnimationEnd() {
            super.onAnimationEnd();

            TransformationHelpers.copyData(originalYCoordinates, previousYCoordinates);
            TransformationHelpers.copyData(originalPrevSeriesYCoordinates, previousPrevSeriesYCoordinates);
        }
    }
    // </CreateUpdatedPointTransformationClass>

    // <UseUpdatedPointTransformation>
    // Since we have two Renderable Series in our `VerticallyStackedColumnsCollection`, we need to create separate animators for each series. Please refer to a complete example for more details.
    Animator animator1 = createAnimator(rSeries1);
    Animator animator2 = createAnimator(rSeries2);

    private Animator createAnimator(StackedColumnRenderableSeries rSeries) {
        return AnimationsHelper.createAnimator(
                rSeries,
                new UpdatedPointTransformation(),
                ANIMATION_DURATION,
                0,
                new DecelerateInterpolator(),
                new FloatEvaluator(),
                0f, 1f
        );
    }

    // this method is called in real time based on timer.
    private void refreshData() {
        requireActivity().runOnUiThread(() -> {
            //cancel animators in case they are in progress
            animator1.cancel();
            animator2.cancel();

            UpdateSuspender.using(binding.surface, () -> {
                for (int i = 0; i < X_VALUES_COUNT; i++) {
                    dataSeries1.updateYAt(i, getRandomYValue());
                    dataSeries2.updateYAt(i, getRandomYValue());
                }
            });

            // start animation
            animator1.start();
            animator2.start();
        });
    }

    // </UseUpdatedPointTransformation>

    private double getRandomYValue() {
        return random.nextDouble() * MAX_Y_VALUE;
    }
}
