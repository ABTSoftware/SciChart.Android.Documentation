---
uid: "chartModifierAPIs.ChartModifierToViewModel"
---

# Pass RolloverModifier data points to a ViewModel

## Overview

This documentation provides a complete working example showing how to:

1. Intercept RolloverModifier events
2. Extract Series info during hover interactions
3. Pass the Series info to another ViewModel

## Implementation

### 1. ViewModel

# [Kotlin](#tab/kotlin)
[!code-swift[AddCursorModifier](../../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/chartModifier2D/ChartViewModel.kt#ChartModifierToViewModel)]
# [Java](#tab/java)
[!code-java[AddCursorModifier](../../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/chartModifier2D/ChartViewModel.java#ChartModifierToViewModel)]
***

### 2. Activity


# [Kotlin](#tab/kotlin)
[!code-swift[AddCursorModifier](../../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/chartModifier2D/InteractivityChartModifierToViewModel.kt#ChartModifierToViewModelInfoProvider)]
# [Java](#tab/java)
[!code-java[AddCursorModifier](../../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/chartModifier2D/InteractivityChartModifierToViewModel.java#ChartModifierToViewModelInfoProvider)]
***

Use the custom series info provider class in your code as shown below


# [Kotlin](#tab/kotlin)
[!code-swift[AddCursorModifier](../../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/kotlin/chartModifier2D/InteractivityChartModifierToViewModel.kt#ChartModifierToViewModelUsage)]
# [Java](#tab/java)
[!code-java[AddCursorModifier](../../../../samples/sandbox/app/src/main/java/com/scichart/docsandbox/examples/java/chartModifier2D/InteractivityChartModifierToViewModel.java#ChartModifierToViewModelUsage)]
***

## How It Works: Key Concepts Explained

### 1. SeriesInfo Extraction Process

The solution works by intercepting the tooltip creation and update process:

1. **Custom SeriesInfoProvider**: Extends `DefaultXySeriesInfoProvider` to provide custom tooltip
2. **Custom Tooltip**: Extends `XySeriesTooltip` and overrides `internalUpdate(XySeriesInfo seriesInfo)`
3. **Data Extraction**: In `internalUpdate()`, extract data from `seriesInfo` parameter
4. **ViewModel Communication**: Call `chartViewModel.onRolloverChanged()` with extracted data

### 2. SeriesInfo Data Available

The `XySeriesInfo` object provides access to:

- `seriesInfo.getFormattedXValue()` - Formatted X value as shown in tooltip
- `seriesInfo.getFormattedYValue()` - Formatted Y value as shown in tooltip  
- `seriesInfo.getXValue()` - Raw X value
- `seriesInfo.getYValue()` - Raw Y value
- `seriesInfo.seriesName` - Series name if set

### 3. Event Flow

```
User hovers over chart
    ↓
RolloverModifier detects hover
    ↓
CustomSeriesInfoProvider.getSeriesTooltipInternal() called
    ↓
CustomXySeriesTooltip.internalUpdate() called
    ↓
SeriesInfo extracted and passed to ViewModel
    ↓
ViewModel updates LiveData
```

## Key Implementation Points

### ViewModel Integration
- `ChartViewModel` uses `MutableLiveData<String>` to hold rollover information
- `onRolloverChanged()` method receives formatted SeriesInfo data
- Exposes data through `LiveData` for UI components to observe

### Custom SeriesInfoProvider
- Extends `DefaultXySeriesInfoProvider` 
- Overrides `getSeriesTooltipInternal()` to return custom tooltip
- Passes `ChartViewModel` reference to custom tooltip

### Custom Tooltip
- Extends `XySeriesTooltip`
- Overrides `internalUpdate()` method where SeriesInfo is available
- Calls `chartViewModel.onRolloverChanged()` to pass data to ViewModel