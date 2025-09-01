package com.scichart.docsandbox.examples.kotlin.chartModifier2D

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

// <ChartModifierToViewModel>
class ChartViewModel : ViewModel() {
    private val _rolloverData = MutableLiveData<String>()
    val rolloverData: LiveData<String> = _rolloverData

    // Call this method when you detect rollover changes
    fun onRolloverChanged(seriesName: String, xValue: String, yValue: String) {
        val data = "$seriesName: X=$xValue, Y=$yValue"
        _rolloverData.value = data
    }
}
// </ChartModifierToViewModel>