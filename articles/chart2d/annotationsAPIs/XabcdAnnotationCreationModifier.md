---
uid: "annotationsAPIs.XabcdAnnotationCreationModifier"
---

# The XabcdAnnotationCreationModifier
The <xref:com.scichart.charting.modifiers.XabcdAnnotationCreationModifier> is a chart modifier that allows for interactive creation of <xref:com.scichart.charting.visuals.annotations.tradingAnnotations.XabcdAnnotation> instances using a multi-tap workflow.

## Overview
When this modifier is enabled, users can place the 5 required points (X, A, B, C, D) by tapping on the chart. 
- Each tap confirms the position of the next point.
- A "rubber-band" dashed line provides a preview of the next segment between the last confirmed point and the current touch position.
- Once the fifth point (D) is placed, the annotation is finalized, and the modifier automatically resets to create the next one.

## Properties
The following properties can be used to configure the `XabcdAnnotationCreationModifier`:

| Property | Description |
| --- | --- |
| [xAxisId](xref:com.scichart.charting.modifiers.XabcdAnnotationCreationModifier.setXAxisId(java.lang.String)) | Sets the ID of the X-Axis that the created annotations should be measured against. |
| [yAxisId](xref:com.scichart.charting.modifiers.XabcdAnnotationCreationModifier.setYAxisId(java.lang.String)) | Sets the ID of the Y-Axis that the created annotations should be measured against. |

## Event Listeners
You can receive a notification when an annotation is fully created by setting an <xref:com.scichart.charting.modifiers.OnAnnotationCreatedListener>:

- [setAnnotationCreationListener(OnAnnotationCreatedListener listener)](xref:com.scichart.charting.modifiers.XabcdAnnotationCreationModifier.setAnnotationCreationListener(com.scichart.charting.modifiers.OnAnnotationCreatedListener)): Passes the newly created annotation instance to the listener.

## Using XabcdAnnotationCreationModifier
The following code demonstrates how to add and configure an `XabcdAnnotationCreationModifier`:

# [Java](#tab/java)
[!code-java[AddXabcdAnnotationCreationModifier](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/annotationsAPIs/XabcdAnnotationCreationModifierFragment.java#AddXabcdAnnotationCreationModifier)]
# [Kotlin](#tab/kotlin)
[!code-swift[AddXabcdAnnotationCreationModifier](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/annotationsAPIs/XabcdAnnotationCreationModifierFragment.kt#AddXabcdAnnotationCreationModifier)]
***

## Customizing the Modifier
The `XabcdAnnotationCreationModifier` is designed for extensibility. You can customize its behavior by extending it and overriding its `protected` methods. This allows you to change the annotation type, customize the rubber-band preview, or add post-creation logic.

### [Java](#tab/java)
[!code-java[CustomXabcdAnnotationCreationModifier](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/annotationsAPIs/XabcdAnnotationCreationModifierFragment.java#CustomXabcdAnnotationCreationModifier)]
### [Kotlin](#tab/kotlin)
[!code-swift[CustomXabcdAnnotationCreationModifier](../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/annotationsAPIs/XabcdAnnotationCreationModifierFragment.kt#CustomXabcdAnnotationCreationModifier)]
***

> [!NOTE]
> To learn more about other **Annotation Types**, available out of the box in SciChart, please find the comprehensive list in the [Annotation APIs](xref:annotationsAPIs.AnnotationsAPIs) article.
