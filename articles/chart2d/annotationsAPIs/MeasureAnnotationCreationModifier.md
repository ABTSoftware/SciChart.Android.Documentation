---
uid: "annotationsAPIs.MeasureAnnotationCreationModifier"
---

# The MeasureAnnotationCreationModifier
The <xref:com.scichart.charting.modifiers.MeasureAnnotationCreationModifier> is a chart modifier that allows for interactive creation of <xref:com.scichart.charting.visuals.annotations.tradingAnnotations.MeasureAnnotation> instances using either a 2-tap or a single-drag workflow.

## Overview
When this modifier is enabled, users can place the 2 required anchor points - the start and the end of the move being measured - in one of two ways:
- **Tap to place**: Each tap confirms the position of the next anchor point. A "rubber-band" dashed line provides a preview of the segment between the last confirmed point and the current touch position.
- **Single drag**: If the finger moves more than **10 pixels** before the first touch-up, the gesture is classified as a drag - both anchor points are placed from the start and end of that drag, and the annotation is finalized on touch-up.

Once both points are placed, the annotation is finalized, the rubber-band preview is removed, and the modifier automatically resets to create the next one.

## Snapping to Data Points
If a renderable series is assigned to [snapSeries](xref:com.scichart.charting.modifiers.MeasureAnnotationCreationModifier.setSnapSeries(com.scichart.charting.visuals.renderableSeries.IRenderableSeries)), the modifier passes it to every `MeasureAnnotation` it creates, so both anchor points snap to the nearest rendered data point while being placed.

> [!NOTE]
> The snap-distance threshold logic lives on the <xref:com.scichart.charting.visuals.annotations.tradingAnnotations.MeasureAnnotation> itself rather than on the modifier. This means snapping keeps working for vertex and body drags performed **after** creation, and it is configured through the annotation's own properties. See the [MeasureAnnotation](xref:annotationsAPIs.MeasureAnnotation) article for details.

Assigning `snapSeries` also affects the **bar count** reported by the annotation's label, since the series' X values are used to resolve the indices of the two anchor points on a value axis.

## Properties
The following properties can be used to configure the `MeasureAnnotationCreationModifier`:

| Property | Description |
| --- | --- |
| [snapSeries](xref:com.scichart.charting.modifiers.MeasureAnnotationCreationModifier.setSnapSeries(com.scichart.charting.visuals.renderableSeries.IRenderableSeries)) | Sets the renderable series that the created annotations should snap to. Pass `null` to disable snapping. Assigning it also updates the annotation currently being created. |
| [xAxisId](xref:com.scichart.charting.modifiers.MeasureAnnotationCreationModifier.setXAxisId(java.lang.String)) | Sets the ID of the X-Axis that the created annotations should be measured against. |
| [yAxisId](xref:com.scichart.charting.modifiers.MeasureAnnotationCreationModifier.setYAxisId(java.lang.String)) | Sets the ID of the Y-Axis that the created annotations should be measured against. |
| [rubberBandStroke](xref:com.scichart.charting.modifiers.MeasureAnnotationCreationModifier.setRubberBandStroke(com.scichart.drawing.common.PenStyle)) | Sets the pen style for the preview line shown during creation. Must not be `null`. |

The following read-only properties allow to inspect the creation progress, e.g. from a custom subclass:

| Property | Description |
| --- | --- |
| [currentAnnotation](xref:com.scichart.charting.modifiers.MeasureAnnotationCreationModifier.getCurrentAnnotation()) | The annotation currently being created, or `null` if no creation is in progress. |
| [currentPointIndex](xref:com.scichart.charting.modifiers.MeasureAnnotationCreationModifier.getCurrentPointIndex()) | The index of the next anchor point to be placed - `0` for the start, `1` for the end. |
| [rubberBandAnnotation](xref:com.scichart.charting.modifiers.MeasureAnnotationCreationModifier.getRubberBandAnnotation()) | The rubber-band preview annotation, or `null` if it is not currently shown. |

## Event Listeners
You can receive a notification when an annotation is fully created by setting an <xref:com.scichart.charting.modifiers.OnAnnotationCreatedListener>:

- [setAnnotationCreationListener(OnAnnotationCreatedListener listener)](xref:com.scichart.charting.modifiers.MeasureAnnotationCreationModifier.setAnnotationCreationListener(com.scichart.charting.modifiers.OnAnnotationCreatedListener)): Passes the newly created annotation instance to the listener.

## Using MeasureAnnotationCreationModifier
The following code demonstrates how to add and configure a `MeasureAnnotationCreationModifier`:

# [Java](#tab/java)
[!code-java[AddMeasureAnnotationCreationModifier](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/annotationsAPIs/MeasureAnnotationCreationModifierFragment.java#AddMeasureAnnotationCreationModifier)]
# [Kotlin](#tab/kotlin)
[!code-swift[AddMeasureAnnotationCreationModifier](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/annotationsAPIs/MeasureAnnotationCreationModifierFragment.kt#AddMeasureAnnotationCreationModifier)]
***

## Customizing the Modifier
The `MeasureAnnotationCreationModifier` is designed for extensibility. You can customize its behavior by extending it and overriding its `protected` methods:

| Method | Description |
| --- | --- |
| `createAnnotation(Context)` | Replace the annotation type, or apply custom default styling to every created annotation. |
| `createRubberBandAnnotation(Context)` | Replace the rubber-band preview annotation type. |
| `configureRubberBandAnnotation(IAnnotation)` | Configure the rubber-band annotation after creation. |
| `updateRubberBandEndPoint(PointF)` | Change how the rubber-band tracks the finger. |
| `removeRubberBandAnnotation()` | Clean up the rubber-band annotation. |
| `onAnnotationCreated(IAnnotation)` | React to annotation completion. |

### [Java](#tab/java)
[!code-java[CustomMeasureAnnotationCreationModifier](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/annotationsAPIs/MeasureAnnotationCreationModifierFragment.java#CustomMeasureAnnotationCreationModifier)]
### [Kotlin](#tab/kotlin)
[!code-swift[CustomMeasureAnnotationCreationModifier](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/annotationsAPIs/MeasureAnnotationCreationModifierFragment.kt#CustomMeasureAnnotationCreationModifier)]
***

> [!NOTE]
> The `snapSeries` assigned on the modifier is applied when the annotation is added to the surface, **after** `createAnnotation` returns. Assign it on the modifier rather than inside an overridden `createAnnotation`.

> [!NOTE]
> To learn more about other **Annotation Types**, available out of the box in SciChart, please find the comprehensive list in the [Annotation APIs](xref:annotationsAPIs.AnnotationsAPIs) article.
