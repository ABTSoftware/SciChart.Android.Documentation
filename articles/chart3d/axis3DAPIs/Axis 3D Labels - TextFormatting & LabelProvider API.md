---
uid: "axis3DAPIs.Axis3DLabelsTextFormattingAndLabelProviderAPI"
---

# Axis 3D Labels - TextFormatting & LabelProvider API
**[Axes in SciChart 3D](xref:axis3DAPIs.Axis3DAPIs)** shares the same <xref:com.scichart.charting.visuals.axes.AxisCore> base class with **[SciChart 2D Axes](xref:axis.AxisAPIs)**. 
Many of the **AxisCore** features are shared. 
For your convenience, some of the documentation has been duplicated here, with some referring to other sections of the user manual.

## Axis 3D TextFormatting
All the axis classes obey standard Java formatting strings, calling methods of the [Java Format API](https://docs.oracle.com/javase/7/docs/api/java/text/Format.html) internally. Thus, standard [Date and Time](https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html) and [Numeric](https://docs.oracle.com/javase/7/docs/api/java/text/DecimalFormat.html) pattern strings can be applied to format axis labels. There are the [textFormatting](xref:com.scichart.charting.visuals.axes.IAxisCore.setTextFormatting(java.lang.String)) and [cursorTextFormatting](xref:com.scichart.charting.visuals.axes.IAxisCore.setCursorTextFormatting(java.lang.String)) properties for this purpose. 

> [!NOTE]
> [Date and Time](https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html) and [Numeric](https://docs.oracle.com/javase/7/docs/api/java/text/DecimalFormat.html) relies on [Unicode Technical Standard #35](http://www.unicode.org/reports/tr35/tr35-31/tr35-numbers.html#Number_Format_Patterns)

See possible string patterns provided by [UTS#35](https://unicode.org/reports/tr35/tr35-31/)
- [Number Format Patterns](https://www.unicode.org/reports/tr35/tr35-31/tr35-numbers.html#Number_Format_Patterns)
- [Date Format Patterns](https://www.unicode.org/reports/tr35/tr35-31/tr35-dates.html#Date_Format_Patterns)

> [!NOTE]
> The **TextFormatting** is a shared API between SciChart 2D and SciChart 3D. For a full walk-through including code-samples, please see the [Axis Labels - TextFormatting and CursorTextFormatting](xref:axisAPIs.AxisLabelsTextFormattingAndCursorTextFormatting) article.

## Axis 3D LabelProvider API
The [LabelProvider API](xref:axisAPIs.AxisLabelsLabelProviderAPI) allows full control over the formatting of <xref:com.scichart.charting.visuals.axes.AxisCore> text labels, over and above what you can achieve using [TextFormatting](xref:axis3DAPIs.Axis3DLabelsTextFormattingAndLabelProviderAPI).

Use a **LabelProvider** when you want to:

- Have fine grained control over Axis Text or Cursor Labels, depending on numeric (or date) values.
- Display strings on the XAxis, e.g. “Bananas”, “Oranges”, “Apples” and not “1”, “2”, “3”.
- Dynamically change the [textFormatting](xref:com.scichart.charting.visuals.axes.IAxisCore.setTextFormatting(java.lang.String)) as you zoom in or out.
- Dynamically change the [textFormatting](xref:com.scichart.charting.visuals.axes.IAxisCore.setTextFormatting(java.lang.String)) depending on Data-value.

> [!NOTE]
> The **LabelProvider API** is a shared API between SciChart 2D and SciChart 3D. For a full walk-through of the AxisCore LabelProvider API, including code-samples, please see [Axis Labels - LabelProvider API](xref:axisAPIs.AxisLabelsLabelProviderAPI) article.
