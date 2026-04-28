---
uid: "annotationsAPIs.PitchforkAnnotationCreationModifier"
---

# The PitchforkAnnotationCreationModifier
The <xref:com.scichart.charting.modifiers.PitchforkAnnotationCreationModifier> is a chart modifier that allows for interactive creation of <xref:com.scichart.charting.visuals.annotations.tradingAnnotations.PitchforkAnnotation> instances using a 3-tap workflow.

## Overview
When this modifier is enabled, users can place the 3 required points (Handle, High, Low) by tapping on the chart.
- Each tap confirms the position of the next point.
- A "rubber-band" dashed line provides a preview of the next segment between the last confirmed point and the current touch position.
- Once the third point is placed, the annotation is finalized, and the modifier automatically resets to create the next one.

## Properties
The following properties can be used to configure the `PitchforkAnnotationCreationModifier`:

| Property | Description |
| --- | --- |
| [xAxisId](xref:com.scichart.charting.modifiers.PitchforkAnnotationCreationModifier.setXAxisId(java.lang.String)) | Sets the ID of the X-Axis that the created annotations should be measured against. |
| [yAxisId](xref:com.scichart.charting.modifiers.PitchforkAnnotationCreationModifier.setYAxisId(java.lang.String)) | Sets the ID of the Y-Axis that the created annotations should be measured against. |
| [rubberBandStroke](xref:com.scichart.charting.modifiers.PitchforkAnnotationCreationModifier.setRubberBandStroke(com.scichart.drawing.common.PenStyle)) | Sets the pen style for the preview line shown during creation. |

## Event Listeners
You can receive a notification when an annotation is fully created by setting an <xref:com.scichart.charting.modifiers.OnAnnotationCreatedListener>:

- [setAnnotationCreationListener(OnAnnotationCreatedListener listener)](xref:com.scichart.charting.modifiers.PitchforkAnnotationCreationModifier.setAnnotationCreationListener(com.scichart.charting.modifiers.OnAnnotationCreatedListener)): Passes the newly created annotation instance to the listener.

## Using PitchforkAnnotationCreationModifier
The following code demonstrates how to add and configure a `PitchforkAnnotationCreationModifier`:

# [Java](#tab/java)
[!code-java[AddPitchforkAnnotationCreationModifier](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/annotationsAPIs/PitchforkAnnotationCreationModifierFragment.java#AddPitchforkAnnotationCreationModifier)]
# [Kotlin](#tab/kotlin)
[!code-swift[AddPitchforkAnnotationCreationModifier](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/annotationsAPIs/PitchforkAnnotationCreationModifierFragment.kt#AddPitchforkAnnotationCreationModifier)]
***

## Customizing the Modifier
The `PitchforkAnnotationCreationModifier` is designed for extensibility. You can customize its behavior by extending it and overriding its `protected` methods.

### [Java](#tab/java)
[!code-java[CustomPitchforkAnnotationCreationModifier](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/annotationsAPIs/PitchforkAnnotationCreationModifierFragment.java#CustomPitchforkAnnotationCreationModifier)]
### [Kotlin](#tab/kotlin)
[!code-swift[CustomPitchforkAnnotationCreationModifier](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/annotationsAPIs/PitchforkAnnotationCreationModifierFragment.kt#CustomPitchforkAnnotationCreationModifier)]
***

> [!NOTE]
> To learn more about other **Annotation Types**, available out of the box in SciChart, please find the comprehensive list in the [Annotation APIs](xref:annotationsAPIs.AnnotationsAPIs) article.
