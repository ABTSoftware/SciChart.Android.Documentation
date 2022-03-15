package com.scichart.docsandbox.examples.base;

import androidx.annotation.FloatRange;

import com.scichart.core.model.DoubleValues;
import com.scichart.data.model.SciListUtil;
import com.scichart.data.numerics.SearchMode;
import com.scichart.drawing.utility.ColorUtil;

import java.util.Random;

public class DataManager {
    private final Random random = new Random();

    public double getGaussianRandomNumber(double mean, double stdDev) {
        //these are uniform(0,1) random doubles
        final double u1 = random.nextDouble();
        final double u2 = random.nextDouble();

        //random normal(0,1)
        final double randStdNormal = Math.sqrt(-2.0 * Math.log(u1)) * Math.sin(2.0 * Math.PI * u2);

        //random normal(mean,stdDev^2)
        return mean * stdDev * randStdNormal;
    }

    public int getRandomColor() {
        final int red = random.nextInt(205) + 50;
        final int green = random.nextInt(205) + 50;
        final int blue = random.nextInt(205) + 50;

        return ColorUtil.argb(0xFF, red, green, blue);
    }

    public float getRandomScale() {
        return (getRandomFloat() + 0.5f) * 3f;
    }

    @FloatRange(from = 0f, to = 1f)
    public float getRandomFloat() {
        return random.nextFloat();
    }

    @FloatRange(from = 0d, to = 1d)
    public double getRandomDouble() {
        return random.nextDouble();
    }

    public DoubleSeries getFourierSeries(double amplitude, double phaseShift, double xStart, double xEnd, int count) {
        final DoubleSeries doubleSeries = new DoubleSeries(count);

        setFourierSeriesZoomed(doubleSeries.xValues, doubleSeries.yValues, amplitude, phaseShift, xStart, xEnd, count);

        return doubleSeries;
    }

    public void setFourierSeriesZoomed(DoubleValues xValues, DoubleValues yValues, double amplitude, double phaseShift, double xStart, double xEnd, int count) {
        setFourierSeries(xValues, yValues, amplitude, phaseShift, count);

        int startIndex = SciListUtil.instance().findIndex(xValues.getItemsArray(), 0, count, true, xStart, SearchMode.RoundDown);
        int endIndex = SciListUtil.instance().findIndex(xValues.getItemsArray(), startIndex, count - startIndex, true, xEnd, SearchMode.RoundUp);

        int size = endIndex - startIndex;
        System.arraycopy(xValues.getItemsArray(), startIndex, xValues.getItemsArray(), 0, size);
        System.arraycopy(yValues.getItemsArray(), startIndex, yValues.getItemsArray(), 0, size);

        xValues.setSize(size);
        yValues.setSize(size);
    }

    public void setFourierSeries(DoubleValues xValues, DoubleValues yValues, double amplitude, double phaseShift, int count) {
        final double[] xValuesArray = getValuesArray(xValues, count);
        final double[] yValuesArray = getValuesArray(yValues, count);

        for (int i = 0; i < count; i++) {
            double time = 10 * i / (double) count;
            double wn = 2 * Math.PI / (count / 10);
            double y = Math.PI * amplitude *
                    (Math.sin(i * wn + phaseShift) +
                            0.33 * Math.sin(i * 3 * wn + phaseShift) +
                            0.20 * Math.sin(i * 5 * wn + phaseShift) +
                            0.14 * Math.sin(i * 7 * wn + phaseShift) +
                            0.11 * Math.sin(i * 9 * wn + phaseShift) +
                            0.09 * Math.sin(i * 11 * wn + phaseShift));

            xValuesArray[i] = time;
            yValuesArray[i] = y;
        }
    }

    private static double[] getValuesArray(DoubleValues values, int count) {
        values.clear();

        values.setSize(count);

        return values.getItemsArray();
    }
}