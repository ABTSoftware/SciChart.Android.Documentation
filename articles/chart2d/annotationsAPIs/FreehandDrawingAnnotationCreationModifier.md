---
uid: "annotationsAPIs.FreehandDrawingAnnotationCreationModifier"
---

# The FreehandDrawingAnnotationCreationModifier
The <xref:com.scichart.charting.modifiers.FreehandDrawingModifier> is a chart modifier that allows for freehand creation of <xref:com.scichart.charting.visuals.annotations.tradingAnnotations.FreehandDrawingAnnotation> instances.

## Overview
When this modifier is enabled and added to a <xref:com.scichart.charting.visuals.SciChartSurface>, users can draw freehand strokes directly on the chart using touch gestures. The modifier automatically creates a new `FreehandDrawingAnnotation` and populates it with points based on the user's movement.

## Properties
The following properties can be used to configure the `FreehandDrawingModifier`:

| Property | Description |
| --- | --- |
| [brushColor](xref:com.scichart.charting.modifiers.FreehandDrawingModifier.setBrushColor(int)) | Sets the color of the brush stroke for the annotations created by this modifier. |
| [brushThickness](xref:com.scichart.charting.modifiers.FreehandDrawingModifier.setBrushThickness(float)) | Sets the thickness of the brush stroke for the annotations created by this modifier. |
| [xAxisId](xref:com.scichart.charting.modifiers.FreehandDrawingModifier.setXAxisId(java.lang.String)) | Sets the ID of the X-Axis that the created annotations should be measured against. |
| [yAxisId](xref:com.scichart.charting.modifiers.FreehandDrawingModifier.setYAxisId(java.lang.String)) | Sets the ID of the Y-Axis that the created annotations should be measured against. |

## Event Listeners
You can receive a notification when an annotation is created by setting an <xref:com.scichart.charting.modifiers.OnAnnotationCreatedListener>:

- [setAnnotationCreationListener(OnAnnotationCreatedListener listener)](xref:com.scichart.charting.modifiers.FreehandDrawingModifier.setAnnotationCreationListener(com.scichart.charting.modifiers.OnAnnotationCreatedListener)): Passes the newly created annotation instance to the listener.

## Using FreehandDrawingModifier
The following code demonstrates how to add and configure a `FreehandDrawingModifier`:

# [Java](#tab/java)
[!code-java[AddFreehandDrawingAnnotationCreationModifier](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/annotationsAPIs/FreehandDrawingAnnotationCreationModifierFragment.java#AddFreehandDrawingAnnotationCreationModifier)]
# [Kotlin](#tab/kotlin)
[!code-swift[AddFreehandDrawingAnnotationCreationModifier](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/annotationsAPIs/FreehandDrawingAnnotationCreationModifierFragment.kt#AddFreehandDrawingAnnotationCreationModifier)]
***

## Customizing the Modifier
You can customize the behavior of the `FreehandDrawingModifier` by extending it and overriding its touch event methods. This allows you to add custom logic before or after an annotation is created.

### [Java](#tab/java)
[!code-java[CustomFreehandDrawingAnnotationCreationModifier](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/annotationsAPIs/FreehandDrawingAnnotationCreationModifierFragment.java#CustomFreehandDrawingAnnotationCreationModifier)]
### [Kotlin](#tab/kotlin)
[!code-swift[CustomFreehandDrawingAnnotationCreationModifier](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/annotationsAPIs/FreehandDrawingAnnotationCreationModifierFragment.kt#CustomFreehandDrawingAnnotationCreationModifier)]
***

> [!NOTE]
> To learn more about other **Annotation Types**, available out of the box in SciChart, please find the comprehensive list in the [Annotation APIs](xref:annotationsAPIs.AnnotationsAPIs) article.
