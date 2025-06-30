---
uid: "chart2d.Accessibility"
---

# SciChart Accessibility Integration Guide

This guide helps you add accessibility support to SciChart. By following these steps, you will ensure that screen readers like **TalkBack** can interpret and vocalize chart interactions for visually impaired users.

---

## Step 1: Extend SciChartSurface for Accessibility

Create a custom surface that enables navigation and interaction through accessibility tools.

### Code Example


# [Java](#tab/java)
[!code-java[SettingResamplingMode](../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/series2d/AccessibilityCustomSurface.java#AccessibilityCustomSurface)]
# [Kotlin](#tab/kotlin)
[!code-swift[SettingResamplingMode](../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/series2d/AccessibilityCustomSurface.kt#AccessibilityCustomSurface)]
***

### What This Does

- Makes the chart surface visible and interactive for screen readers.
- Adds a verbal description: `"sci chart event"`.
- Supports accessible click actions.

---

## Step 2: Announce Zoom or Pan (Visible Range Change)

When the chart’s visible range changes due to scroll or zoom, notify the screen reader so users stay informed.

### Code Example

# [Java](#tab/java)
[!code-java[SettingResamplingMode](../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/series2d/Accessibility.java#AccessibilityEnable)]
# [Kotlin](#tab/kotlin)
[!code-swift[SettingResamplingMode](../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/series2d/Accessibility.kt#AccessibilityEnable)]
***

### What This Does

- Announces `"visible range changed"` when user interacts with the chart.
- Emits a window content change event for accessibility services.

---

## Step 3: Provide Accessible Custom Tooltips

Customize tooltips to announce the current data point (X, Y, and series name) using `announceForAccessibility()`.

### Code Example


# [Java](#tab/java)
[!code-java[SettingResamplingMode](../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/series2d/Accessibility.java#AccessibilitySeriesInfo)]
# [Kotlin](#tab/kotlin)
[!code-swift[SettingResamplingMode](../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/series2d/Accessibility.kt#AccessibilitySeriesInfo)]
***

### What This Does

- Announces chart data values (X, Y, series name) when the tooltip appears.
- Works with rollover modifiers and other dynamic interactions.
- Enhances accessibility for real-time data updates.

---

## Final Checklist

| Feature                 | Purpose                                 | Implemented In |
|------------------------|-----------------------------------------|----------------|
| Surface is accessible  | Lets users navigate chart surface       | Step 1         |
| Zoom/pan announcement  | Alerts user to visible range changes    | Step 2         |
| Tooltip speaks values  | Reads out data point details aloud      | Step 3         |

---

## Recommended Tools for Testing

- **TalkBack** (Android)
- **Accessibility Scanner** (Google)
- Manual screen reader interaction testing