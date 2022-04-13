package com.scichart.docsandbox.examples.base;

import android.view.LayoutInflater;

import androidx.annotation.NonNull;

import com.scichart.charting.modifiers.ModifierGroup;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.docsandbox.databinding.ExampleSingleChartBinding;
import com.scichart.docsandbox.databinding.TestRenderSurfaceRendererFragmentBinding;

public abstract class TestRenderSurfaceRendererFragment extends ExampleBaseFragment<TestRenderSurfaceRendererFragmentBinding> {
    @NonNull
    @Override
    protected TestRenderSurfaceRendererFragmentBinding inflateBinding(@NonNull LayoutInflater inflater) {
        return TestRenderSurfaceRendererFragmentBinding.inflate(inflater);
    }

    @Override
    protected void initExample(@NonNull TestRenderSurfaceRendererFragmentBinding binding) {
       initExample();
    }

    protected abstract void initExample();
}
