package ua.edu.ucu.tempseries;

import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Array;
import java.util.Arrays;

public class TemperaturesArray {
    public static double[] increaseArray(double[] array,
                                         int lengthOfAddedElements,
                                         double lowerBoundary) {
        int size = array.length;
        // if currently temperatures are empty, make them of size 1
        int availableFrom = ArrayUtils.indexOf(array, lowerBoundary);
        // increase the size until it is large enough to fit new data
        while (availableFrom != -1 && (size - availableFrom)<
                lengthOfAddedElements) {
            size = size * 2;
            double[] tempArray = new double[size];
            Arrays.fill(tempArray, lowerBoundary);
            for (int i = 0; i < array.length; i++) {
                Array.set(tempArray, i, Array.get(array, i));
            }
            array = tempArray;
            availableFrom = ArrayUtils.indexOf(array, lowerBoundary);
        }
        return array;
    }
}
