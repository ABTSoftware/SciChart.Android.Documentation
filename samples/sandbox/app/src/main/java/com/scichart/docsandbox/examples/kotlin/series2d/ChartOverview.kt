package com.scichart.docsandbox.examples.kotlin.series2d

import android.graphics.Color
import android.view.Gravity
import android.view.LayoutInflater
import com.scichart.charting.model.dataSeries.IOhlcDataSeries
import com.scichart.charting.model.dataSeries.IXyDataSeries
import com.scichart.charting.model.dataSeries.XyDataSeries
import com.scichart.charting.visuals.annotations.AnnotationCoordinateMode
import com.scichart.charting.visuals.annotations.VerticalLineAnnotation
import com.scichart.charting.visuals.axes.IAxis
import com.scichart.charting.visuals.axes.NumericAxis
import com.scichart.charting.visuals.overview.ISciChartOverviewTransformation
import com.scichart.charting.visuals.renderableSeries.FastCandlestickRenderableSeries
import com.scichart.charting.visuals.renderableSeries.FastLineRenderableSeries
import com.scichart.charting.visuals.renderableSeries.IRenderableSeries
import com.scichart.core.framework.UpdateSuspender
import com.scichart.docsandbox.databinding.ExampleChartOverviewBinding
import com.scichart.docsandbox.examples.base.ExampleBaseFragment
import com.scichart.drawing.common.SolidPenStyle
import com.scichart.drawing.utility.ColorUtil
import java.util.Collections
import java.util.Date


class ChartOverview : ExampleBaseFragment<ExampleChartOverviewBinding?>() {
    override fun inflateBinding(inflater: LayoutInflater): ExampleChartOverviewBinding {
        return ExampleChartOverviewBinding.inflate(getLayoutInflater())
    }

    override fun initExample(binding: ExampleChartOverviewBinding) {
        val dataSeries: IXyDataSeries<Double, Double> = XyDataSeries(Double::class.javaObjectType, Double::class.javaObjectType)
        dataSeries.append(0.0, 0.0)
        dataSeries.append(1.0, 1.0)
        dataSeries.append(2.0, 4.0)

        val lineSeries = FastLineRenderableSeries()

        lineSeries.dataSeries = dataSeries
        lineSeries.strokeStyle = SolidPenStyle(Color.RED, true, 1f, null)

        UpdateSuspender.using(binding.surface, {
            Collections.addAll(binding.surface.xAxes, NumericAxis(requireContext()))
            Collections.addAll(binding.surface.yAxes, NumericAxis(requireContext()))
            Collections.addAll(binding.surface.renderableSeries, lineSeries)
        })

        // 2. Link Overview with Main Chart
        // <LinkOverviewChart>
        binding.overview.parentSurface = binding.surface
        // </LinkOverviewChart>

        // 3. Customize Grip Handles
        // <CustomizeOverviewGrip>
        binding.overview.setGrips(generateGrip(), generateGrip())
        // </CustomizeOverviewGrip>

        // 4. Apply Transformation to Renderable Series
        // <OverviewTransformation>
        binding.overview.setOverviewTransformation(object : ISciChartOverviewTransformation {
            override fun transformRenderableSeries(renderableSeries: IRenderableSeries?): IRenderableSeries? {
                if (renderableSeries is FastCandlestickRenderableSeries) {
                    val candleSeries = renderableSeries

                    val originalData =
                        candleSeries.getDataSeries() as IOhlcDataSeries<Date?, Double?>

                    val lineDataSeries =
                        XyDataSeries<Date, Double>(Date::class.javaObjectType, Double::class.javaObjectType)

                    val count = originalData.getCount()
                    for (i in 0..<count) {
                        val x = originalData.getXValues().get(i)
                        val high = (originalData.getHighValues().get(i) as Number).toDouble()
                        val low = (originalData.getLowValues().get(i) as Number).toDouble()
                        val average = (high + low) / 2.0
                        lineDataSeries.append(x, average)
                    }

                    val lineSeries = FastLineRenderableSeries()
                    lineSeries.dataSeries = lineDataSeries

                    return lineSeries
                } else {
                    return renderableSeries
                }
            }
        })
        // </OverviewTransformation>
    }

    private fun getXAxis(){
        // <OverviewGetAxis>
        val overviewAxis = binding.overview.getxAxis()
        // </OverviewGetAxis>
    }

    private fun setGripThreshold() {
        // <OverviewSetGripThreshold>
        binding.overview.setGripThreshold(20.0)
        // </OverviewSetGripThreshold>
    }


    // <GenerateOverviewGrip>
    private fun generateGrip(): VerticalLineAnnotation {
        val annotation = VerticalLineAnnotation(getContext())

        annotation.coordinateMode = AnnotationCoordinateMode.RelativeY
        annotation.verticalGravity = Gravity.CENTER_VERTICAL
        annotation.stroke = SolidPenStyle(ColorUtil.Grey, true, 7f, null)

        return annotation
    }
    // </GenerateOverviewGrip>
}