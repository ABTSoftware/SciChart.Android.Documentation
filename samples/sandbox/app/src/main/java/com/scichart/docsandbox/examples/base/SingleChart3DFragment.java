package com.scichart.docsandbox.examples.base;

import android.view.LayoutInflater;

import androidx.annotation.NonNull;

import com.scichart.charting3d.modifiers.ModifierGroup3D;
import com.scichart.charting3d.visuals.SciChartSurface3D;
import com.scichart.docsandbox.databinding.ExampleSingleChart3dBinding;

public abstract class SingleChart3DFragment extends ExampleBaseFragment<ExampleSingleChart3dBinding> {
    @NonNull
    @Override
    protected ExampleSingleChart3dBinding inflateBinding(@NonNull LayoutInflater inflater) {
        return ExampleSingleChart3dBinding.inflate(inflater);
    }

    @Override
    protected void initExample(@NonNull ExampleSingleChart3dBinding binding) {
       initExample(binding.surface);
    }

    protected abstract void initExample(@NonNull SciChartSurface3D surface);

    public ModifierGroup3D createDefaultModifiers3D() {
        return sciChart3DBuilder.newModifierGroupWithDefaultModifiers().build();
    }
}
