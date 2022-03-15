package com.scichart.docsandbox.examples.base;

import android.view.LayoutInflater;

import androidx.annotation.NonNull;

import com.scichart.charting.visuals.SciPieChartSurface;
import com.scichart.docsandbox.databinding.ExampleSinglePieChartBinding;

public abstract class SinglePieChart2DFragment extends ExampleBaseFragment<ExampleSinglePieChartBinding> {
    @NonNull
    @Override
    protected ExampleSinglePieChartBinding inflateBinding(@NonNull LayoutInflater inflater) {
        return ExampleSinglePieChartBinding.inflate(inflater);
    }

    @Override
    protected void initExample(@NonNull ExampleSinglePieChartBinding binding) {
       initExample(binding.surface);
    }

    protected abstract void initExample(@NonNull SciPieChartSurface surface);
}
