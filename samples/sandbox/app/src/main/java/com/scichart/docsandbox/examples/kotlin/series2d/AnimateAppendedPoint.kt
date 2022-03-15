package com.scichart.docsandbox.examples.kotlin.series2d

import android.animation.FloatEvaluator
import android.view.animation.DecelerateInterpolator
import com.scichart.charting.model.dataSeries.IXyDataSeries
import com.scichart.charting.model.dataSeries.XyDataSeries
import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.animations.AnimationsHelper
import com.scichart.charting.visuals.animations.BaseRenderPassDataTransformation
import com.scichart.charting.visuals.animations.TransformationHelpers
import com.scichart.charting.visuals.renderableSeries.FastLineRenderableSeries
import com.scichart.charting.visuals.renderableSeries.data.LineRenderPassData
import com.scichart.core.model.FloatValues
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment
import java.util.*

@ExampleDefinition()
class AnimateAppendedPoint : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {}

    fun createAppendedPointTransformation() {
        // <CreateAppendedPointTransformation>
        class AppendedPointTransformation : BaseRenderPassDataTransformation<LineRenderPassData>(LineRenderPassData::class.java) {
            private val originalXCoordinates = FloatValues()
            private val originalYCoordinates = FloatValues()

            override fun saveOriginalData() {
                if (!renderPassData.isValid) return

                TransformationHelpers.copyData(renderPassData.xCoords, originalXCoordinates)
                TransformationHelpers.copyData(renderPassData.yCoords, originalYCoordinates)
            }

            override fun applyTransformation() {
                if (!renderPassData.isValid) return

                val count = renderPassData.pointsCount()
                val currentTransformationValue = currentTransformationValue

                val xStart: Float
                xStart = if (count <= 1) {
                    renderPassData.xCoordinateCalculator.getCoordinate(0.0)
                } else {
                    originalXCoordinates[count - 2]
                }
                val xFinish = originalXCoordinates[count - 1]
                val additionalX = xStart + (xFinish - xStart) * currentTransformationValue
                renderPassData.xCoords[count - 1] = additionalX

                val yStart: Float
                yStart = if (count <= 1) {
                    renderPassData.yCoordinateCalculator.getCoordinate(0.0)
                } else {
                    originalYCoordinates[count - 2]
                }
                val yFinish = originalYCoordinates[count - 1]
                val additionalY = yStart + (yFinish - yStart) * currentTransformationValue
                renderPassData.yCoords[count - 1] = additionalY
            }

            override fun discardTransformation() {
                TransformationHelpers.copyData(originalXCoordinates, renderPassData.xCoords)
                TransformationHelpers.copyData(originalYCoordinates, renderPassData.yCoords)
            }

            override fun onInternalRenderPassDataChanged() {
                applyTransformation()
            }
        }
        // </CreateAppendedPointTransformation>

        val rSeries = FastLineRenderableSeries()
        val dataSeries: IXyDataSeries<Double, Double> = XyDataSeries(Double::class.java, Double::class.java)
        val ANIMATION_DURATION: Long = 500
        val MAX_Y_VALUE = 100.0
        val random = Random()
        val currentXValue = 0.0
        var yValue = 0.0

        // <UseAppendedPointTransformation>

        // Append new value to our dataSeries in real-time
        yValue = random.nextDouble() * MAX_Y_VALUE
        dataSeries.append(currentXValue, yValue)

        // Animate renderable series with our custom transformation
        AnimationsHelper.createAnimator(
            rSeries,
            AppendedPointTransformation(),
            ANIMATION_DURATION,
            0,
            DecelerateInterpolator(),
            FloatEvaluator(),
            0f, 1f
        ).start()
        // </UseAppendedPointTransformation>
    }
}
