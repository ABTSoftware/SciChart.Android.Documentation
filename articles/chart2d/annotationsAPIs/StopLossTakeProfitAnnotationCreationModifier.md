---
uid: "annotationsAPIs.StopLossTakeProfitAnnotationCreationModifier"
---

# The StopLossTakeProfitAnnotationCreationModifier
The <xref:com.scichart.charting.modifiers.StopLossTakeProfitAnnotationCreationModifier> is a chart modifier that allows for interactive creation of <xref:com.scichart.charting.visuals.annotations.tradingAnnotations.StopLossTakeProfitAnnotation> instances using either a 2-tap or a single-drag workflow.

## Overview
When this modifier is enabled, users can place the 2 required anchor points - the opposite corners of the price zone - in one of two ways:
- **Tap to place**: Each tap confirms the position of the next anchor point. A "rubber-band" dashed line provides a preview of the segment between the last confirmed point and the current touch position.
- **Single drag**: If the finger moves more than **10 pixels** before the first touch-up, the gesture is classified as a drag - both anchor points are placed from the start and end of that drag, and the annotation is finalized on touch-up.

Once both points are placed, the annotation is finalized, the rubber-band preview is removed, and the modifier automatically resets to create the next one.

> [!NOTE]
> The zone is automatically colored as a **take-profit** or a **stop-loss** band depending on whether the second point ends up above or below the first. See the [StopLossTakeProfitAnnotation](xref:annotationsAPIs.StopLossTakeProfitAnnotation) article for details.

## Properties
The following properties can be used to configure the `StopLossTakeProfitAnnotationCreationModifier`:

| Property | Description |
| --- | --- |
| [xAxisId](xref:com.scichart.charting.modifiers.StopLossTakeProfitAnnotationCreationModifier.setXAxisId(java.lang.String)) | Sets the ID of the X-Axis that the created annotations should be measured against. |
| [yAxisId](xref:com.scichart.charting.modifiers.StopLossTakeProfitAnnotationCreationModifier.setYAxisId(java.lang.String)) | Sets the ID of the Y-Axis that the created annotations should be measured against. |
| [rubberBandStroke](xref:com.scichart.charting.modifiers.StopLossTakeProfitAnnotationCreationModifier.setRubberBandStroke(com.scichart.drawing.common.PenStyle)) | Sets the pen style for the preview line shown during creation. Must not be `null`. |

The following read-only properties allow to inspect the creation progress, e.g. from a custom subclass:

| Property | Description |
| --- | --- |
| [currentAnnotation](xref:com.scichart.charting.modifiers.StopLossTakeProfitAnnotationCreationModifier.getCurrentAnnotation()) | The annotation currently being created, or `null` if no creation is in progress. |
| [currentPointIndex](xref:com.scichart.charting.modifiers.StopLossTakeProfitAnnotationCreationModifier.getCurrentPointIndex()) | The index of the next anchor point to be placed - `0` for the start, `1` for the end. |
| [rubberBandAnnotation](xref:com.scichart.charting.modifiers.StopLossTakeProfitAnnotationCreationModifier.getRubberBandAnnotation()) | The rubber-band preview annotation, or `null` if it is not currently shown. |

## Event Listeners
You can receive a notification when an annotation is fully created by setting an <xref:com.scichart.charting.modifiers.OnAnnotationCreatedListener>:

- [setAnnotationCreationListener(OnAnnotationCreatedListener listener)](xref:com.scichart.charting.modifiers.StopLossTakeProfitAnnotationCreationModifier.setAnnotationCreationListener(com.scichart.charting.modifiers.OnAnnotationCreatedListener)): Passes the newly created annotation instance to the listener.

## Using StopLossTakeProfitAnnotationCreationModifier
The following code demonstrates how to add and configure a `StopLossTakeProfitAnnotationCreationModifier`:

# [Java](#tab/java)
[!code-java[AddStopLossTakeProfitAnnotationCreationModifier](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/annotationsAPIs/StopLossTakeProfitAnnotationCreationModifierFragment.java#AddStopLossTakeProfitAnnotationCreationModifier)]
# [Kotlin](#tab/kotlin)
[!code-swift[AddStopLossTakeProfitAnnotationCreationModifier](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/annotationsAPIs/StopLossTakeProfitAnnotationCreationModifierFragment.kt#AddStopLossTakeProfitAnnotationCreationModifier)]
***

## Customizing the Modifier
The `StopLossTakeProfitAnnotationCreationModifier` is designed for extensibility. You can customize its behavior by extending it and overriding its `protected` methods:

| Method | Description |
| --- | --- |
| `createAnnotation(Context)` | Replace the annotation type, or apply custom default styling to every created annotation. |
| `createRubberBandAnnotation(Context)` | Replace the rubber-band preview annotation type. |
| `configureRubberBandAnnotation(IAnnotation)` | Configure the rubber-band annotation after creation. |
| `updateRubberBandEndPoint(PointF)` | Change how the rubber-band tracks the finger. |
| `removeRubberBandAnnotation()` | Clean up the rubber-band annotation. |
| `onAnnotationCreated(IAnnotation)` | React to annotation completion. |

### [Java](#tab/java)
[!code-java[CustomStopLossTakeProfitAnnotationCreationModifier](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/annotationsAPIs/StopLossTakeProfitAnnotationCreationModifierFragment.java#CustomStopLossTakeProfitAnnotationCreationModifier)]
### [Kotlin](#tab/kotlin)
[!code-swift[CustomStopLossTakeProfitAnnotationCreationModifier](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/annotationsAPIs/StopLossTakeProfitAnnotationCreationModifierFragment.kt#CustomStopLossTakeProfitAnnotationCreationModifier)]
***

> [!NOTE]
> To learn more about other **Annotation Types**, available out of the box in SciChart, please find the comprehensive list in the [Annotation APIs](xref:annotationsAPIs.AnnotationsAPIs) article.
