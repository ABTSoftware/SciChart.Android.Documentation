package com.scichart.docsandbox.examples.base;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;

import com.scichart.extensions.builders.SciChartBuilder;
import com.scichart.extensions3d.builders.SciChart3DBuilder;

public abstract class ExampleBaseFragment<TViewBinding extends ViewBinding> extends Fragment {
    @NonNull
    protected TViewBinding binding;

    protected final SciChartBuilder sciChartBuilder = SciChartBuilder.instance();
    protected final SciChart3DBuilder sciChart3DBuilder = SciChart3DBuilder.instance();

    @NonNull
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = inflateBinding(inflater);

        initExample(binding);

        return binding.getRoot();
    }

    @NonNull
    protected abstract TViewBinding inflateBinding(@NonNull LayoutInflater inflater);

    protected abstract void initExample(@NonNull TViewBinding binding);

    public float convertValueToDp(float value) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, Resources.getSystem().getDisplayMetrics());
    }
}
