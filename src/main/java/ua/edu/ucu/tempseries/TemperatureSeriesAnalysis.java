package ua.edu.ucu.tempseries;

import lombok.Getter;
import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {
    @Getter
    private double[] temperatures;
    private final double lowerBoundary = -273;
    public TemperatureSeriesAnalysis() {
        this.temperatures = new double[]{};
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        for (double temp : temperatureSeries) {
            if (temp < lowerBoundary) {
                throw new InputMismatchException();
            }
        }
        this.temperatures = temperatureSeries;
    }

    public double average() {
        if (temperatures.length == 0) {
            throw new IllegalArgumentException();
        }
        double sum = 0;
        for (int i = 0; i < temperaturesQuantity(); i++) {
            sum += (double) Array.get(temperatures, i);
        }
        return sum / temperaturesQuantity();
    }

    public double deviation() {
        if (temperatures.length == 0) {
            throw new IllegalArgumentException();
        }
        double quadrants = 0;
        double avg = average();
        for (int i = 0; i < temperaturesQuantity(); i++) {
            quadrants += Math.pow((double) Array.get(temperatures, i) - avg, 2);
        }
        return Math.sqrt(quadrants / temperaturesQuantity());
    }

    public double min() {
        if (temperatures.length == 0) {
            throw new IllegalArgumentException();
        }
        return (double) Array.get(findMinMax(temperatures, 0,
                temperaturesQuantity()-1), 0);
    }

    public double max() {
        if (temperatures.length == 0) {
            throw new IllegalArgumentException();
        }
        return (double) Array.get(findMinMax(temperatures, 0,
                temperaturesQuantity()-1), 1);
    }

    private static double[] findMinMax(double[] temperatures,
                                        int low, int high) {
        double min;
        double max;
        if (low == high) {
            min = (double) Array.get(temperatures, low);
            return new double[]{min, min};
        }
        if (low == high - 1) {
            min = (double) Array.get(temperatures, low);
            max = (double) Array.get(temperatures, high);
            if (min < max) {
                return new double[]{min, max};
            }
            else {
                return new double[]{max, min};
            }
        }
        int mid = (low + high) / 2;
        double[] left = findMinMax(temperatures, low, mid);
        double[] right = findMinMax(temperatures, mid + 1, high);
        min = Math.min((double) Array.get(left, 0),
                (double) Array.get(right, 0));
        max = Math.max((double) Array.get(left, 1),
                (double) Array.get(right, 1));
        return new double[]{min, max};
    }

    public double findTempClosestToZero() {
        if (temperatures.length == 0) {
            throw new IllegalArgumentException();
        }
        return findTempClosestToValue(0);
    }

    public double findTempClosestToValue(double tempValue) {
        if (temperatures.length == 0) {
            throw new IllegalArgumentException();
        }
        double closestValue = Double.POSITIVE_INFINITY;
        for (int i = 0; i < temperaturesQuantity(); i++) {
            double temp = (double) Array.get(temperatures, i);
            if (Math.abs(temp - tempValue) <
                    Math.abs(closestValue - tempValue)) {
                closestValue = temp;
            }
            else if (Math.abs(temp - tempValue) ==
                    Math.abs(closestValue - tempValue)) {
                closestValue = Math.max(temp, closestValue);
            }
        }
        return closestValue;
    }

    public double[] findTempsLessThan(double tempValue) {
        return (double[]) Array.get(findTempsGreaterAndLessThan(tempValue), 0);
    }

    public double[] findTempsGreaterThan(double tempValue) {
        return (double[]) Array.get(findTempsGreaterAndLessThan(tempValue), 1);
    }

    private double[][] findTempsGreaterAndLessThan(double tempValue) {
        double[] greaterValues = new double[temperatures.length];
        Arrays.fill(greaterValues, lowerBoundary-1);
        double[] lessValues = new double[temperatures.length];
        Arrays.fill(lessValues, lowerBoundary-1);
        int i = 0;
        int j = 0;
        for (int k = 0; k < temperaturesQuantity(); k++) {
            double temp = (double) Array.get(temperatures, k);
            if (temp >= tempValue) {
                Array.set(greaterValues, i, temp);
                i += 1;
            }
            else {
                Array.set(lessValues, j, temp);
                j += 1;
            }
        }
        if (ArrayUtils.indexOf(lessValues, lowerBoundary-1) != -1) {
            lessValues = Arrays.copyOfRange(lessValues,
                    0, ArrayUtils.indexOf(lessValues, lowerBoundary-1));
        }
        if (ArrayUtils.indexOf(greaterValues, lowerBoundary-1) != -1) {
            greaterValues = Arrays.copyOfRange(greaterValues, 0,
                    ArrayUtils.indexOf(greaterValues, lowerBoundary-1));
        }
        return new double[][]{lessValues, greaterValues};
    }

    public TempSummaryStatistics summaryStatistics() {
        if (temperatures.length == 0) {
            throw new IllegalArgumentException();
        }
        return new TempSummaryStatistics(this);
    }
    private int temperaturesQuantity() {
        if (ArrayUtils.indexOf(temperatures, lowerBoundary-1) == -1) {
            return temperatures.length;
        }
        return ArrayUtils.indexOf(temperatures, lowerBoundary-1);
    }

    public int addTemps(double... temps) {
        for (double temp : temps) {
            if (temp < lowerBoundary) {
                throw new InputMismatchException();
            }
        }
        if (temperatures.length == 0) {
            temperatures = new double[]{lowerBoundary-1};
        }
        temperatures = TemperaturesArray.increaseArray(temperatures,
                temps.length, lowerBoundary-1);
        int availableFrom = ArrayUtils.indexOf(temperatures, lowerBoundary-1);
        // add new temperatures
        for (double temp : temps) {
            Array.set(temperatures, availableFrom, temp);
            availableFrom += 1;
        }
        return temperaturesQuantity();
    }
}
