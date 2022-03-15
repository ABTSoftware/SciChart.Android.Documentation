package com.scichart.docsandbox.examples.kotlin.series2d

import android.animation.Animator
import android.animation.FloatEvaluator
import android.view.animation.DecelerateInterpolator
import com.scichart.charting.model.dataSeries.IXyDataSeries
import com.scichart.charting.model.dataSeries.XyDataSeries
import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.animations.AnimationsHelper
import com.scichart.charting.visuals.animations.BaseRenderPassDataTransformation
import com.scichart.charting.visuals.animations.TransformationHelpers
import com.scichart.charting.visuals.renderableSeries.StackedColumnRenderableSeries
import com.scichart.charting.visuals.renderableSeries.data.StackedColumnRenderPassData
import com.scichart.core.framework.UpdateSuspender
import com.scichart.core.model.FloatValues
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment
import com.scichart.drawing.common.SolidPenStyle
import java.util.*

@ExampleDefinition()
class AnimateUpdatedPoint : SingleChart2DFragment() {
    private val dataSeries1: IXyDataSeries<Double, Double> = XyDataSeries(Double::class.java, Double::class.java)
    private val dataSeries2: IXyDataSeries<Double, Double> = XyDataSeries(Double::class.java, Double::class.java)

    private lateinit var rSeries1: StackedColumnRenderableSeries
    private lateinit var rSeries2: StackedColumnRenderableSeries

    private val ANIMATION_DURATION: Long = 500
    private val X_VALUES_COUNT = 12
    private val MAX_Y_VALUE = 100.0

    private val random = Random()

    override fun initExample(surface: SciChartSurface) {
        rSeries1 = StackedColumnRenderableSeries()
        rSeries1.dataSeries = dataSeries1
        rSeries1.strokeStyle = SolidPenStyle(-0xdd9049, false, 1f, null)

        rSeries2 = StackedColumnRenderableSeries()
        rSeries2.dataSeries = dataSeries2
        rSeries2.strokeStyle = SolidPenStyle(-0x65d2, false, 1f, null)
    }

    // <CreateUpdatedPointTransformationClass>
    internal class UpdatedPointTransformation : BaseRenderPassDataTransformation<StackedColumnRenderPassData>(StackedColumnRenderPassData::class.java) {
        private val previousYCoordinates = FloatValues()
        private val previousPrevSeriesYCoordinates = FloatValues()

        private val originalYCoordinates = FloatValues()
        private val originalPrevSeriesYCoordinates = FloatValues()

        override fun saveOriginalData() {
            if (!renderPassData.isValid) return

            TransformationHelpers.copyData(renderPassData.yCoords, originalYCoordinates)
            TransformationHelpers.copyData(renderPassData.prevSeriesYCoords, originalPrevSeriesYCoordinates)
        }

        override fun applyTransformation() {
            if (!renderPassData.isValid) return

            val count = renderPassData.pointsCount()
            val currentTransformationValue = currentTransformationValue
            if (previousPrevSeriesYCoordinates.size() != count ||
                previousYCoordinates.size() != count ||
                originalYCoordinates.size() != count ||
                originalPrevSeriesYCoordinates.size() != count) return

            for (i in 0 until count) {
                val startYCoord = previousYCoordinates[i]
                val originalYCoordinate = originalYCoordinates[i]
                val additionalY = startYCoord + (originalYCoordinate - startYCoord) * currentTransformationValue

                val startPrevSeriesYCoords = previousPrevSeriesYCoordinates[i]
                val originalPrevSeriesYCoordinate = originalPrevSeriesYCoordinates[i]
                val additionalPrevSeriesY = startPrevSeriesYCoords + (originalPrevSeriesYCoordinate - startPrevSeriesYCoords) * currentTransformationValue

                renderPassData.yCoords[i] = additionalY
                renderPassData.prevSeriesYCoords[i] = additionalPrevSeriesY
            }
        }

        override fun discardTransformation() {
            TransformationHelpers.copyData(originalYCoordinates, renderPassData.yCoords)
            TransformationHelpers.copyData(originalPrevSeriesYCoordinates, renderPassData.prevSeriesYCoords)
        }

        override fun onInternalRenderPassDataChanged() {
            applyTransformation()
        }

        override fun onAnimationEnd() {
            super.onAnimationEnd()

            TransformationHelpers.copyData(originalYCoordinates, previousYCoordinates)
            TransformationHelpers.copyData(originalPrevSeriesYCoordinates, previousPrevSeriesYCoordinates)
        }
    }
    // </CreateUpdatedPointTransformationClass>

    // <UseUpdatedPointTransformation>
    // Since we have two Renderable Series in our `VerticallyStackedColumnsCollection`, we need to create separate animators for each series. Please refer to a complete example for more details.
    var animator1 = createAnimator(rSeries1)
    var animator2 = createAnimator(rSeries2)

    private fun createAnimator(rSeries: StackedColumnRenderableSeries?): Animator {
        return AnimationsHelper.createAnimator(
            rSeries,
            UpdatedPointTransformation(),
            ANIMATION_DURATION,
            0,
            DecelerateInterpolator(),
            FloatEvaluator(),
            0f, 1f
        )
    }

    // this method is called in real time based on timer.
    private fun refreshData() {
        requireActivity().runOnUiThread {
            //cancel animators in case they are in progress
            animator1.cancel()
            animator2.cancel()

            UpdateSuspender.using(binding.surface) {
                for (i in 0 until X_VALUES_COUNT) {
                    dataSeries1.updateYAt(i, getRandomYValue())
                    dataSeries2.updateYAt(i, getRandomYValue())
                }
            }

            // start animation
            animator1.start()
            animator2.start()
        }
    }
    // </UseUpdatedPointTransformation>

    private fun getRandomYValue(): Double {
        return random.nextDouble() * MAX_Y_VALUE
    }
}
