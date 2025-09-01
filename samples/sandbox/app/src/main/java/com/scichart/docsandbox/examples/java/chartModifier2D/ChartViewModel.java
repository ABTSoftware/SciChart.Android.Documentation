package com.scichart.docsandbox.examples.java.chartModifier2D;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

// <ChartModifierToViewModel>
public class ChartViewModel extends ViewModel {
    private final MutableLiveData<String> rolloverData = new MutableLiveData<>();

    public LiveData<String> getRolloverData() {
        return rolloverData;
    }

    // Call this method when you detect rollover changes
    public void onRolloverChanged(String seriesName, String xValue, String yValue) {
        String data = seriesName + ": X=" + xValue + ", Y=" + yValue;
        rolloverData.setValue(data);
    }
}
// </ChartModifierToViewModel>

