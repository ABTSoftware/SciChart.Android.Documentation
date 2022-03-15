package com.scichart.docsandbox.examples.javaBuilder.chartModifier2D;

import android.content.Context;
import android.graphics.drawable.PaintDrawable;

import androidx.annotation.NonNull;

import com.scichart.charting.modifiers.ModifierGroup;
import com.scichart.charting.modifiers.SeriesValueModifier;
import com.scichart.charting.numerics.coordinateCalculators.ICoordinateCalculator;
import com.scichart.charting.visuals.ISciChartSurface;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.annotations.AnnotationLabel;
import com.scichart.charting.visuals.annotations.HorizontalLineAnnotation;
import com.scichart.charting.visuals.annotations.LabelPlacement;
import com.scichart.charting.visuals.renderableSeries.IRenderableSeries;
import com.scichart.core.IServiceContainer;
import com.scichart.core.common.Predicate;
import com.scichart.core.utility.Dispatcher;
import com.scichart.core.utility.ListUtil;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;
import com.scichart.drawing.common.FontStyle;
import com.scichart.drawing.common.SolidPenStyle;
import com.scichart.drawing.utility.ColorUtil;

@ExampleDefinition()
public class SeriesValueModifierFragment extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) {}

    void createSeriesValueModifier(@NonNull SciChartSurface surface) {
        // <CreateSeriesValueModifier>
        // Assume a surface has been created and configured somewhere
        // Create a modifier
        ModifierGroup seriesValueModifierGroup = sciChartBuilder.newModifierGroup()
                .withSeriesValueModifier()
                .build()
                .build();

        // Add the modifier to the surface
        surface.getChartModifiers().add(seriesValueModifierGroup);
        // </CreateSeriesValueModifier>
    }

    void excludingSeries(@NonNull SciChartSurface surface) {
        // <ExcludingSeries>
        // Assume renderable series with name "Blue Series" has been created and configured somewhere
        // Create a factory with a predicate
        ModifierGroup seriesValueModifierGroup = sciChartBuilder.newModifierGroup()
                .withSeriesValueModifier(series ->
                        series.getDataSeries().getSeriesName() == "Blue Series"
                )
                .build()
                .build();

        // Add the modifier to the surface
        surface.getChartModifiers().add(seriesValueModifierGroup);
        // </ExcludingSeries>
    }

    void createSeriesValueModifierWithCustomFactory(@NonNull SciChartSurface surface) {
        // <CreateHorizontalLineSeriesValueMarkerAnnotation>
        class HorizontalLineSeriesValueMarkerAnnotation extends HorizontalLineAnnotation {
            final SeriesValueModifier.DefaultSeriesValueMarkerAnnotationHelper<HorizontalLineSeriesValueMarkerAnnotation> seriesValueHelper;

            public HorizontalLineSeriesValueMarkerAnnotation(
                    Context context,
                    SeriesValueModifier.DefaultSeriesValueMarkerAnnotationHelper<HorizontalLineSeriesValueMarkerAnnotation> seriesValueHelper
            ) {
                super(context);

                this.seriesValueHelper = seriesValueHelper;
            }

            @Override
            public void attachTo(IServiceContainer services) {
                final IRenderableSeries renderableSeries = seriesValueHelper.renderableSeries;

                setXAxisId(renderableSeries.getXAxisId());
                setYAxisId(renderableSeries.getYAxisId());

                super.attachTo(services);
            }

            @Override
            protected void update(ICoordinateCalculator xCalc, ICoordinateCalculator yCalc) {
                seriesValueHelper.tryUpdateAnnotation(this);

                super.update(xCalc, yCalc);
            }
        }
        // </CreateHorizontalLineSeriesValueMarkerAnnotation>

        // <CreateHorizontalLineSeriesValueMarkerAnnotationHelper>
        class HorizontalLineSeriesValueMarkerAnnotationHelper extends SeriesValueModifier.DefaultSeriesValueMarkerAnnotationHelper<HorizontalLineSeriesValueMarkerAnnotation> {
            private float lineThickness = convertValueToDp(1);
            private float[] dashPattern = new float[] { convertValueToDp(4), convertValueToDp(4)};

            public HorizontalLineSeriesValueMarkerAnnotationHelper(IRenderableSeries renderableSeries, Predicate<IRenderableSeries> isValidRenderableSeriesPredicate) {
                super(renderableSeries, isValidRenderableSeriesPredicate);
            }

            @Override
            protected void updateAnnotation(HorizontalLineSeriesValueMarkerAnnotation annotation, Comparable<?> lastValue, int lastColor) {
                super.updateAnnotation(annotation, lastValue, lastColor);

                Dispatcher.postOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        annotation.setStroke(new SolidPenStyle(lastColor, false, lineThickness, dashPattern));

                        int count = annotation.annotationLabels.size();
                        for (int i = 0; i < count; i++) {
                            final AnnotationLabel label = annotation.annotationLabels.get(i);
                            label.setBackground(new PaintDrawable(lastColor));
                            label.setFontStyle(new FontStyle(convertValueToDp(12), ColorUtil.getInvertedColor(lastColor)));
                        }
                    }
                });
            }
        }
        // </CreateHorizontalLineSeriesValueMarkerAnnotationHelper>

        // <CreateHorizontalLineSeriesValueMarker>
        class HorizontalLineSeriesValueMarker extends SeriesValueModifier.SeriesValueMarkerBase {
            private HorizontalLineSeriesValueMarkerAnnotation markerAnnotation;

            protected HorizontalLineSeriesValueMarker(
                    IRenderableSeries renderableSeries,
                    Predicate<IRenderableSeries> isValidRenderableSeriesPredicate
            ) {
                super(renderableSeries, isValidRenderableSeriesPredicate);
            }

            @Override
            protected void tryRemoveMarkerAnnotation(ISciChartSurface parentSurface) {
                parentSurface.getAnnotations().remove(markerAnnotation);
            }

            @Override
            protected void tryAddMarkerAnnotation(ISciChartSurface parentSurface) {
                ListUtil.safeAddExact(parentSurface.getAnnotations(), markerAnnotation);
            }

            @Override
            protected void createMarkerAnnotation(Context context) {
                markerAnnotation = new HorizontalLineSeriesValueMarkerAnnotation(
                        context,
                        new HorizontalLineSeriesValueMarkerAnnotationHelper(
                                renderableSeries,
                                isValidRenderableSeriesPredicate
                        )
                );

                final AnnotationLabel label = new AnnotationLabel(context);
                label.setLabelPlacement(LabelPlacement.Axis);
                markerAnnotation.annotationLabels.add(label);
            }

            @Override
            protected void destroyMarkerAnnotation() {
                markerAnnotation = null;
            }
        }
        // </CreateHorizontalLineSeriesValueMarker>

        // <CreateHorizontalLineSeriesValueMarkerFactory>
        class HorizontalLineSeriesValueMarkerFactory implements SeriesValueModifier.ISeriesValueMarkerFactory {
            private Predicate<IRenderableSeries> isValidSeriesPredicate;

            protected HorizontalLineSeriesValueMarkerFactory(Predicate<IRenderableSeries> isValidSeriesPredicate) {
                super();

                this.isValidSeriesPredicate = isValidSeriesPredicate;
            }

            @Override
            public SeriesValueModifier.ISeriesValueMarker createMarkerFor(IRenderableSeries renderableSeries) {
                return new HorizontalLineSeriesValueMarker(renderableSeries, isValidSeriesPredicate);
            }
        }
        // </CreateHorizontalLineSeriesValueMarkerFactory>

        // <CreateSeriesValueModifierWithCustomFactory>
        final SeriesValueModifier seriesValueModifier = new SeriesValueModifier(
                new HorizontalLineSeriesValueMarkerFactory(item -> true)
        );
        surface.getChartModifiers().add(seriesValueModifier);
        // </CreateSeriesValueModifierWithCustomFactory>
    }
}
