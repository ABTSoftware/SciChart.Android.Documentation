package com.scichart.docsandbox.examples.java.series2d;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

import com.scichart.charting.visuals.SciChartSurface;

// <AccessibilityCustomSurface>
public class AccessibilityCustomSurface extends SciChartSurface {

    public AccessibilityCustomSurface(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
        // If the AccessibilityEvent isn't null, then add text to be announced when the SciChartSurface
        // is in focus in accessibility mode.
        if (event != null) {
            // This text will be announced when the SciChartSurface is in focus in accessibility mode
            event.getText().add("sci chart event");
        }
        return true;
    }

    @Override
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        if (info != null) {
            // Set the SciChartSurface to be Clickable, Focusable and Scrollable
            info.setClickable(true);
            info.setFocusable(true);
            info.setScrollable(true);

            // Add an action, so that it is possible to click on SciChartSurface
            info.addAction(new AccessibilityNodeInfo.AccessibilityAction(
                    AccessibilityNodeInfo.ACTION_CLICK, "Action click"
            ));
        }
    }

    @Override
    public boolean performAccessibilityAction(int action, Bundle arguments) {
        // If the action is a click event, then return true to handle the event.
        if (action == AccessibilityNodeInfo.ACTION_CLICK) {
            // Any custom code that you need will go here
            return true;
        } else {
            return super.performAccessibilityAction(action, arguments);
        }
    }
}
// </AccessibilityCustomSurface>
