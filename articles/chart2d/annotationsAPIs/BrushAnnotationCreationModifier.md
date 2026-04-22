---
uid: "annotationsAPIs.BrushAnnotationCreationModifier"
---

# The BrushAnnotationCreationModifier
The <xref:com.scichart.charting.modifiers.BrushAnnotationCreationModifier> is a chart modifier that allows for freehand creation of <xref:com.scichart.charting.visuals.annotations.tradingAnnotations.BrushAnnotation> instances.

## Overview
When this modifier is enabled and added to a <xref:com.scichart.charting.visuals.SciChartSurface>, users can draw freehand strokes directly on the chart using touch gestures. The modifier automatically creates a new `BrushAnnotation` and populates it with points based on the user's movement.

## Properties
The following properties can be used to configure the `BrushAnnotationCreationModifier`:

| Property | Description |
| --- | --- |
| [brushColor](xref:com.scichart.charting.modifiers.BrushAnnotationCreationModifier.setBrushColor(int)) | Sets the color of the brush stroke for the annotations created by this modifier. |
| [brushThickness](xref:com.scichart.charting.modifiers.BrushAnnotationCreationModifier.setBrushThickness(float)) | Sets the thickness of the brush stroke for the annotations created by this modifier. |
| [xAxisId](xref:com.scichart.charting.modifiers.BrushAnnotationCreationModifier.setXAxisId(java.lang.String)) | Sets the ID of the X-Axis that the created annotations should be measured against. |
| [yAxisId](xref:com.scichart.charting.modifiers.BrushAnnotationCreationModifier.setYAxisId(java.lang.String)) | Sets the ID of the Y-Axis that the created annotations should be measured against. |

## Event Listeners
You can receive a notification when an annotation is created by setting an <xref:com.scichart.charting.modifiers.OnAnnotationCreatedListener>:

- [setAnnotationCreationListener(OnAnnotationCreatedListener listener)](xref:com.scichart.charting.modifiers.BrushAnnotationCreationModifier.setAnnotationCreationListener(com.scichart.charting.modifiers.OnAnnotationCreatedListener)): Passes the newly created annotation instance to the listener.

## Using BrushAnnotationCreationModifier
The following code demonstrates how to add and configure a `BrushAnnotationCreationModifier`:

# [Java](#tab/java)
[!code-java[AddBrushAnnotationCreationModifier](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/annotationsAPIs/BrushAnnotationCreationModifierFragment.java#AddBrushAnnotationCreationModifier)]
# [Kotlin](#tab/kotlin)
[!code-swift[AddBrushAnnotationCreationModifier](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/annotationsAPIs/BrushAnnotationCreationModifierFragment.kt#AddBrushAnnotationCreationModifier)]
***

## Customizing the Modifier
You can customize the behavior of the `BrushAnnotationCreationModifier` by extending it and overriding its touch event methods. This allows you to add custom logic before or after an annotation is created.

### [Java](#tab/java)
[!code-java[CustomBrushAnnotationCreationModifier](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/annotationsAPIs/BrushAnnotationCreationModifierFragment.java#CustomBrushAnnotationCreationModifier)]
### [Kotlin](#tab/kotlin)
[!code-swift[CustomBrushAnnotationCreationModifier](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/annotationsAPIs/BrushAnnotationCreationModifierFragment.kt#CustomBrushAnnotationCreationModifier)]
***

> [!NOTE]
> To learn more about other **Annotation Types**, available out of the box in SciChart, please find the comprehensive list in the [Annotation APIs](xref:annotationsAPIs.AnnotationsAPIs) article.
