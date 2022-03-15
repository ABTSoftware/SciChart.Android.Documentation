package com.scichart.docsandbox.examples.base;

import android.view.LayoutInflater;

import androidx.annotation.NonNull;

import com.scichart.charting.modifiers.ModifierGroup;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.docsandbox.databinding.ExampleSingleChartBinding;

public abstract class SingleChart2DFragment extends ExampleBaseFragment<ExampleSingleChartBinding> {
    @NonNull
    @Override
    protected ExampleSingleChartBinding inflateBinding(@NonNull LayoutInflater inflater) {
        return ExampleSingleChartBinding.inflate(inflater);
    }

    @Override
    protected void initExample(@NonNull ExampleSingleChartBinding binding) {
       initExample(binding.surface);
    }

    protected abstract void initExample(@NonNull SciChartSurface surface);

    public ModifierGroup createDefaultModifiers() {
        return sciChartBuilder.newModifierGroupWithDefaultModifiers().build();
    }
}
