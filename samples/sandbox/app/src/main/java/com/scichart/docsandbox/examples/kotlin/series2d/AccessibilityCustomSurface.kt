package com.scichart.docsandbox.examples.kotlin.series2d

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo
import com.scichart.charting.visuals.SciChartSurface


// <AccessibilityCustomSurface>
class AccessibilityCustomSurface(
    context: Context, attrs: AttributeSet?
) : SciChartSurface(context, attrs) {
    override fun dispatchPopulateAccessibilityEvent(event: AccessibilityEvent?): Boolean {
        // If the AccessibilityEvent isn't null, then add text to be announced when the SciChartSurface
        // is in focus in accessibility mode.
        event?.text?.add("sci chart event")
        return true
    }

    override fun onInitializeAccessibilityNodeInfo(info: AccessibilityNodeInfo?) {
        super.onInitializeAccessibilityNodeInfo(info)
        if (info != null) {
            // Set the SciChartSurface to be Clickable, Focusable and Scrollable
            info.isClickable = true
            info.isFocusable = true
            info.isScrollable = true

            // Add an action, so that it is possible to click on SciChartSurface
            info.addAction(
                AccessibilityNodeInfo.AccessibilityAction(
                    AccessibilityNodeInfo.ACTION_CLICK, "Action click"
                )
            )
        }
    }

    override fun performAccessibilityAction(action: Int, arguments: Bundle?): Boolean {
        // If the action is a click event, then return true to handle the event.
        return if (action == AccessibilityNodeInfo.ACTION_CLICK) {
            // Any custom code that you need will go here
            true
        } else {
            super.performAccessibilityAction(action, arguments)
        }
    }
}
// </AccessibilityCustomSurface>
