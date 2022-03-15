package com.scichart.docsandbox.examples.kotlin.series2d

import android.animation.FloatEvaluator
import android.view.animation.DecelerateInterpolator
import com.scichart.charting.visuals.SciChartSurface
import com.scichart.charting.visuals.animations.*
import com.scichart.charting.visuals.renderableSeries.*
import com.scichart.charting.visuals.renderableSeries.data.OhlcRenderPassData
import com.scichart.charting.visuals.renderableSeries.data.XyRenderPassData
import com.scichart.core.model.FloatValues
import com.scichart.docsandbox.core.ExampleDefinition
import com.scichart.docsandbox.examples.base.SingleChart2DFragment
import com.scichart.docsandbox.examples.utils.interpolator.ElasticOutInterpolator

@ExampleDefinition()
class AnimationsAPI : SingleChart2DFragment() {
    override fun initExample(surface: SciChartSurface) {}

    fun animateLineSeries() {
        // <AnimateLineSeries>
        // declare FastLineRenderableSeries to animate
        val rSeries = FastLineRenderableSeries()

        // Animate Line Series with Sweep Transformation
        AnimationsHelper.createAnimator(
            rSeries,
            SweepXyTransformation(XyRenderPassData::class.java),
            3000,
            350,
            DecelerateInterpolator(),
            FloatEvaluator(),
            0f, 1f
        ).start()
        // </AnimateLineSeries>
    }

    fun fadeInAnimation() {
        val rSeries: IRenderableSeries = FastLineRenderableSeries()
        // <FadeInAnimation>
        AnimationsHelper.createOpacityAnimator(
            rSeries,
            2000,
            350,
            DecelerateInterpolator(),
            FloatEvaluator(),
            0f, 1f
        ).start()
        // </FadeInAnimation>
    }

    fun scaleAnimation() {
        val rSeries = FastBandRenderableSeries()
        // <ScaleAnimation>
        AnimationsHelper.createAnimator(
            rSeries,
            ScaleXyTransformation(XyRenderPassData::class.java, 0.0),
            3000,
            350,
            ElasticOutInterpolator(),
            FloatEvaluator(),
            0f, 1f
        ).start()
        // </ScaleAnimation>
    }

    fun sweepAnimation() {
        val rSeries = FastBandRenderableSeries()
        // <SweepAnimation>
        AnimationsHelper.createAnimator(
            rSeries,
            SweepXyTransformation(XyRenderPassData::class.java),
            3000,
            350,
            DecelerateInterpolator(),
            FloatEvaluator(),
            0f, 1f
        ).start()
        // </SweepAnimation>
    }

    fun waveAnimation() {
        val rSeries = FastColumnRenderableSeries()
        // <WaveAnimation>
        AnimationsHelper.createAnimator(
            rSeries,
            WaveXyTransformation(XyRenderPassData::class.java, 0.0, 0.5f),
            3000,
            350,
            DecelerateInterpolator(),
            FloatEvaluator(),
            0f, 1f
        ).start()
        // </WaveAnimation>
    }

    fun translateXAnimation() {
        val rSeries = FastColumnRenderableSeries()
        // <TranslateXAnimation>
        AnimationsHelper.createAnimator(
            rSeries,
            TranslateXTransformation(XyRenderPassData::class.java, -500f),
            3000,
            350,
            DecelerateInterpolator(),
            FloatEvaluator(),
            0f, 1f
        ).start()
        // </TranslateXAnimation>
    }

    fun translateYAnimation() {
        val rSeries = FastFixedErrorBarsRenderableSeries()
        // <TranslateYAnimation>
        AnimationsHelper.createAnimator(
            rSeries,
            TranslateXyTransformation(XyRenderPassData::class.java, -500f),
            3000,
            350,
            DecelerateInterpolator(),
            FloatEvaluator(),
            0f, 1f
        ).start()
        // </TranslateYAnimation>
    }

    fun compositeTransformation() {
        // <CompositeTransformation>
        // declare Candlestick Series to animate
        val rSeries = FastCandlestickRenderableSeries()

        // Create transformations and make a Composite one out of them
        val wave = WaveOhlcTransformation(OhlcRenderPassData::class.java, 0.0, 0.5f)
        val translateX = TranslateXTransformation(OhlcRenderPassData::class.java, -300f)
        val composite = CompositeTransformation(wave, translateX)

        // Animate Candlestick Series with Composite Transformation
        AnimationsHelper.createAnimator(
            rSeries,
            composite,
            3000,
            350,
            DecelerateInterpolator(),
            FloatEvaluator(),
            0f, 1f
        ).start()
        // </CompositeTransformation>
    }

    fun createCustomAnimation() {
        // <CreateCustomAnimation>
        class CustomXyTransformation(private val centerX: Double, private val centerY: Double) : BaseRenderPassDataTransformation<XyRenderPassData>(XyRenderPassData::class.java) {
            private val originalXCoordinates = FloatValues()
            private val originalYCoordinates = FloatValues()

            private var zeroXCoord = 0f
            private var zeroYCoord = 0f

            override fun saveOriginalData() {
                val count = renderPassData.pointsCount()

                // clear buffers
                originalXCoordinates.clear()
                originalYCoordinates.clear()

                // save initial xCoords and yCoords
                originalXCoordinates.add(renderPassData.xCoords.itemsArray, 0, count)
                originalYCoordinates.add(renderPassData.yCoords.itemsArray, 0, count)
                zeroXCoord = renderPassData.xCoordinateCalculator.getCoordinate(centerX)
                zeroYCoord = renderPassData.yCoordinateCalculator.getCoordinate(centerY)
            }

            override fun applyTransformation() {
                // transform current render pass data
                transformValues(renderPassData.xCoords, originalXCoordinates, zeroXCoord)
                transformValues(renderPassData.yCoords, originalYCoordinates, zeroYCoord)
            }

            private fun transformValues(
                valuesToTransform: FloatValues,
                originalCoordinates: FloatValues,
                zeroCoord: Float
            ) {
                val transformationValue = 1 - currentTransformationValue
                // calculate new values to display based on original value
                val itemsArray = valuesToTransform.itemsArray
                val originalValues = originalCoordinates.itemsArray

                var i = 0
                val size = renderPassData.pointsCount()
                while (i < size) {
                    val originalValue = originalValues[i]
                    itemsArray[i] = originalValue - (originalValue - zeroCoord) * transformationValue
                    i++
                }
            }

            override fun discardTransformation() {
                // clear coordinate buffers
                renderPassData.xCoords.clear()
                renderPassData.yCoords.clear()

                // save initial xCoords and yCoords
                renderPassData.xCoords.add(originalXCoordinates.itemsArray, 0, originalXCoordinates.size())
                renderPassData.yCoords.add(originalYCoordinates.itemsArray, 0, originalYCoordinates.size())
            }

            override fun onInternalRenderPassDataChanged() {}
        }
        // </CreateCustomAnimation>
        val rSeries = FastLineRenderableSeries()
        // <UseCustomAnimation>
        AnimationsHelper.createAnimator(
            rSeries,
            CustomXyTransformation(150.0, 300.0),
            3000,
            350,
            DecelerateInterpolator(),
            FloatEvaluator(),
            0f, 1f
        ).start()
        // </UseCustomAnimation>
    }
}
