---
uid: "annotationsAPIs.FibonacciRetracementAnnotationCreationModifier"
---

# The FibonacciRetracementAnnotationCreationModifier
The <xref:com.scichart.charting.modifiers.FibonacciRetracementAnnotationCreationModifier> is a chart modifier that allows for interactive creation of <xref:com.scichart.charting.visuals.annotations.tradingAnnotations.FibonacciRetracementAnnotation> instances using either a 2-tap or a single-drag workflow.

## Overview
When this modifier is enabled, users can place the 2 required anchor points - the start and the end of the price move being retraced - in one of two ways:
- **Tap to place**: Each tap confirms the position of the next anchor point. A "rubber-band" dashed line provides a preview of the segment between the last confirmed point and the current touch position.
- **Single drag**: If the finger moves more than **10 pixels** before the first touch-up, the gesture is classified as a drag - both anchor points are placed from the start and end of that drag, and the annotation is finalized on touch-up.

Once both points are placed, the annotation is finalized, the rubber-band preview is removed, and the modifier automatically resets to create the next one.

## Configuring the Created Annotations
The modifier exposes the three label properties of the <xref:com.scichart.charting.visuals.annotations.tradingAnnotations.FibonacciRetracementAnnotation>. They are applied to every annotation the modifier creates, and assigning any of them also updates the annotation currently being created:

| Property | Description |
| --- | --- |
| [labelPlacement](xref:com.scichart.charting.modifiers.FibonacciRetracementAnnotationCreationModifier.setLabelPlacement(com.scichart.charting.visuals.annotations.tradingAnnotations.FibonacciRetracementAnnotation.LabelPlacement)) | Whether each level's label sits beside the left anchor point (`SIDE`) or centered between the two anchor points (`CENTER`). Defaults to **SIDE**. |
| [labelFormat](xref:com.scichart.charting.modifiers.FibonacciRetracementAnnotationCreationModifier.setLabelFormat(com.scichart.charting.visuals.annotations.tradingAnnotations.FibonacciRetracementAnnotation.LabelFormat)) | Whether the label text shows the raw ratio (`RATIO`) or a percentage (`PERCENT`). Pass `null` to auto-select based on `labelPlacement`. Defaults to `null`. |
| [labelVerticalPosition](xref:com.scichart.charting.modifiers.FibonacciRetracementAnnotationCreationModifier.setLabelVerticalPosition(com.scichart.charting.visuals.annotations.tradingAnnotations.FibonacciRetracementAnnotation.LabelVerticalPosition)) | Whether each label sits `ABOVE`, `ON_LINE` or `BELOW` its level line. Defaults to **ON_LINE**. |

> [!NOTE]
> The Fibonacci **levels** and their colors are not exposed on the modifier. To customize those for every created annotation, override `createAnnotation` as shown in the [Customizing the Modifier](#customizing-the-modifier) section below.

## Properties
The following properties can also be used to configure the `FibonacciRetracementAnnotationCreationModifier`:

| Property | Description |
| --- | --- |
| [xAxisId](xref:com.scichart.charting.modifiers.FibonacciRetracementAnnotationCreationModifier.setXAxisId(java.lang.String)) | Sets the ID of the X-Axis that the created annotations should be measured against. |
| [yAxisId](xref:com.scichart.charting.modifiers.FibonacciRetracementAnnotationCreationModifier.setYAxisId(java.lang.String)) | Sets the ID of the Y-Axis that the created annotations should be measured against. |
| [rubberBandStroke](xref:com.scichart.charting.modifiers.FibonacciRetracementAnnotationCreationModifier.setRubberBandStroke(com.scichart.drawing.common.PenStyle)) | Sets the pen style for the preview line shown during creation. Must not be `null`. |

The following read-only properties allow to inspect the creation progress, e.g. from a custom subclass:

| Property | Description |
| --- | --- |
| [currentAnnotation](xref:com.scichart.charting.modifiers.FibonacciRetracementAnnotationCreationModifier.getCurrentAnnotation()) | The annotation currently being created, or `null` if no creation is in progress. |
| [currentPointIndex](xref:com.scichart.charting.modifiers.FibonacciRetracementAnnotationCreationModifier.getCurrentPointIndex()) | The index of the next anchor point to be placed - `0` for the start, `1` for the end. |
| [rubberBandAnnotation](xref:com.scichart.charting.modifiers.FibonacciRetracementAnnotationCreationModifier.getRubberBandAnnotation()) | The rubber-band preview annotation, or `null` if it is not currently shown. |

## Event Listeners
You can receive a notification when an annotation is fully created by setting an <xref:com.scichart.charting.modifiers.OnAnnotationCreatedListener>:

- [setAnnotationCreationListener(OnAnnotationCreatedListener listener)](xref:com.scichart.charting.modifiers.FibonacciRetracementAnnotationCreationModifier.setAnnotationCreationListener(com.scichart.charting.modifiers.OnAnnotationCreatedListener)): Passes the newly created annotation instance to the listener.

## Using FibonacciRetracementAnnotationCreationModifier
The following code demonstrates how to add and configure a `FibonacciRetracementAnnotationCreationModifier`:

# [Java](#tab/java)
[!code-java[AddFibonacciRetracementAnnotationCreationModifier](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/annotationsAPIs/FibonacciRetracementAnnotationCreationModifierFragment.java#AddFibonacciRetracementAnnotationCreationModifier)]
# [Kotlin](#tab/kotlin)
[!code-swift[AddFibonacciRetracementAnnotationCreationModifier](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/annotationsAPIs/FibonacciRetracementAnnotationCreationModifierFragment.kt#AddFibonacciRetracementAnnotationCreationModifier)]
***

## Customizing the Modifier
The `FibonacciRetracementAnnotationCreationModifier` is designed for extensibility. You can customize its behavior by extending it and overriding its `protected` methods:

| Method | Description |
| --- | --- |
| `createAnnotation(Context)` | Replace the annotation type, or apply custom levels, colors and styling to every created annotation. |
| `createRubberBandAnnotation(Context)` | Replace the rubber-band preview annotation type. |
| `configureRubberBandAnnotation(IAnnotation)` | Configure the rubber-band annotation after creation. |
| `updateRubberBandEndPoint(PointF)` | Change how the rubber-band tracks the finger. |
| `removeRubberBandAnnotation()` | Clean up the rubber-band annotation. |
| `onAnnotationCreated(IAnnotation)` | React to annotation completion. |

The base implementation of `createAnnotation` already applies the modifier's three label properties, so call `super.createAnnotation(context)` first and then apply your own customizations on top:

### [Java](#tab/java)
[!code-java[CustomFibonacciRetracementAnnotationCreationModifier](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/annotationsAPIs/FibonacciRetracementAnnotationCreationModifierFragment.java#CustomFibonacciRetracementAnnotationCreationModifier)]
### [Kotlin](#tab/kotlin)
[!code-swift[CustomFibonacciRetracementAnnotationCreationModifier](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/annotationsAPIs/FibonacciRetracementAnnotationCreationModifierFragment.kt#CustomFibonacciRetracementAnnotationCreationModifier)]
***

> [!NOTE]
> To learn more about other **Annotation Types**, available out of the box in SciChart, please find the comprehensive list in the [Annotation APIs](xref:annotationsAPIs.AnnotationsAPIs) article.
