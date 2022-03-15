package com.scichart.docsandbox.examples.javaBuilder.stylingAndTheming;

import androidx.annotation.NonNull;

import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.docsandbox.R;
import com.scichart.docsandbox.core.ExampleDefinition;
import com.scichart.docsandbox.examples.base.SingleChart2DFragment;

@ExampleDefinition()
public class StylingAndTheming extends SingleChart2DFragment {
    @Override
    protected void initExample(@NonNull SciChartSurface surface) {
        setTheme(surface);
        setCustomTheme(surface);
        setModifiedTheme(surface);
    }

    void setTheme(@NonNull SciChartSurface surface) {
        // <SetTheme>
        surface.setTheme(R.style.SciChart_SciChartv4DarkStyle);
        // </SetTheme>
    }

    void setCustomTheme(@NonNull SciChartSurface surface) {
        // <SetCustomTheme>
        surface.setTheme(R.style.SciChart_BerryBlue);
        // </SetCustomTheme>
    }

    void setModifiedTheme(@NonNull SciChartSurface surface) {
        // <SetModifiedTheme>
        surface.setTheme(R.style.MyModifiedTheme);
        // </SetModifiedTheme>
    }
}
