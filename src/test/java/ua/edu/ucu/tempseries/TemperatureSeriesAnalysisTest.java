package ua.edu.ucu.tempseries;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.InputMismatchException;

public class TemperatureSeriesAnalysisTest {

    @Test
    public void testAverageWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        // call tested method
        double actualResult = seriesAnalysis.average();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAverageWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.average();
    }

    @Test
    public void testAverage() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0;
        double actualResult = seriesAnalysis.average();
        assertEquals(expResult, actualResult, 0.00001);        
    }

    @Test
    public void testDeviationWithOneElement() {
        double [] temperatureSeries = {8.3};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 0.0;
        double actualResult = seriesAnalysis.deviation();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeviationWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.deviation();
    }

    @Test
    public void testDeviation() {
        double[] temperatureSeries = {32.4, 41.3, -20.5, 26.5, 41.2};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 23.030536250812748;
        double actualResult = seriesAnalysis.deviation();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testMinWithOneElement() {
        double [] temperatureSeries = {44};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 44;
        double actualResult = seriesAnalysis.min();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMinWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.min();
    }

    @Test
    public void testMin() {
        double[] temperatureSeries = {-48.5, 67.8, 32.1, 67.22, -50.9};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -50.9;
        double actualResult = seriesAnalysis.min();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testMaxWithOneElement() {
        double [] temperatureSeries = {44};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 44;
        double actualResult = seriesAnalysis.max();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMaxWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.max();
    }

    @Test
    public void testMax() {
        double[] temperatureSeries = {-48.5, 67.8, 32.1, 67.22, -50.9};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 67.8;
        double actualResult = seriesAnalysis.max();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempClosestToZeroWithOneElement() {
        double [] temperatureSeries = {44};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 44;
        double actualResult = seriesAnalysis.findTempClosestToZero();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempClosestToZeroWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.findTempClosestToZero();
    }

    @Test
    public void testFindTempClosestToZero() {
        double[] temperatureSeries = {-0.2, 0.2, -0.3, 0.3};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 0.2;
        double actualResult = seriesAnalysis.findTempClosestToZero();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempClosestToValueWithOneElement() {
        double [] temperatureSeries = {44};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 44;
        double actualResult = seriesAnalysis.findTempClosestToValue(44);
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempClosestToValueWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.findTempClosestToValue(0);
    }

    @Test
    public void testFindTempClosestToValue() {
        double[] temperatureSeries = {-0.2, 0.2, -0.3, 0.3};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 0.3;
        double actualResult = seriesAnalysis.findTempClosestToValue(0.26);
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempsLessThanWithOneElement() {
        double [] temperatureSeries = {44};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {44};
        double[] actualResult = seriesAnalysis.findTempsLessThan(45);
        assertArrayEquals(expResult, actualResult, 0.0);
    }

    @Test
    public void testFindTempsLessThanWithEmptyArray() {
        double [] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {};
        double[] actualResult = seriesAnalysis.findTempsLessThan(45);
        assertArrayEquals(expResult, actualResult, 0.0);
    }

    @Test
    public void testFindTempsLessThan() {
        double [] temperatureSeries = {-48.5, 67.8, 32.1, 67.22, -50.9};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {-48.5, 32.1, -50.9};
        double[] actualResult = seriesAnalysis.findTempsLessThan(60);
        assertArrayEquals(expResult, actualResult, 0.0);
    }

    @Test
    public void testFindGreaterThanWithOneElement() {
        double [] temperatureSeries = {44};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {44};
        double[] actualResult = seriesAnalysis.findTempsGreaterThan(44);
        assertArrayEquals(expResult, actualResult, 0.0);
    }

    @Test
    public void testFindGreaterThanWithEmptyArray() {
        double [] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {};
        double[] actualResult = seriesAnalysis.findTempsGreaterThan(44);
        assertArrayEquals(expResult, actualResult, 0.0);
    }

    @Test
    public void testFindGreaterThan() {
        double [] temperatureSeries = {-48.5, 67.8, 32.1, 67.22, -50.9};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {67.8, 67.22};
        double[] actualResult = seriesAnalysis.findTempsGreaterThan(60);
        assertArrayEquals(expResult, actualResult, 0.0);
    }

    @Test
    public void testSummaryStatistics() {
        double [] temperatureSeries = {-48.5, 67.8, 32.1, 67.22, -50.9};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        TempSummaryStatistics summaryStatistics = seriesAnalysis.summaryStatistics();
        assertEquals(summaryStatistics.getAvgTemp(), seriesAnalysis.average(), 0.00001);
        assertEquals(summaryStatistics.getDevTemp(), seriesAnalysis.deviation(), 0.00001);
        assertEquals(summaryStatistics.getMaxTemp(), seriesAnalysis.max(), 0.00001);
        assertEquals(summaryStatistics.getMinTemp(), seriesAnalysis.min(), 0.00001);
    }

    @Test(expected = InputMismatchException.class)
    public void testAddTempsLessThanAllowed() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis();
        seriesAnalysis.addTemps(45.6, -274, 68.9);
    }

    @Test
    public void testAddTemps() {
        TemperatureSeriesAnalysis seriesAnalysis1 = new TemperatureSeriesAnalysis();
        assertEquals(seriesAnalysis1.addTemps(-48.5, 67.8, 32.1, 67.22, -50.9), 5);
        double [] temperatureSeries = {-48.5, 67.8, 32.1, 67.22, -50.9};
        TemperatureSeriesAnalysis seriesAnalysis2 = new TemperatureSeriesAnalysis(temperatureSeries);
        assertEquals(seriesAnalysis1.average(), seriesAnalysis2.average(), 0.00001);
        assertEquals(seriesAnalysis1.deviation(), seriesAnalysis2.deviation(), 0.00001);
        assertEquals(seriesAnalysis1.min(), seriesAnalysis2.min(), 0.00001);
        assertEquals(seriesAnalysis1.max(), seriesAnalysis2.max(), 0.00001);
        assertEquals(seriesAnalysis1.findTempClosestToZero(), seriesAnalysis2.findTempClosestToZero(), 0.00001);
        assertArrayEquals(seriesAnalysis1.findTempsLessThan(50),
                seriesAnalysis2.findTempsLessThan(50), 0.0);
        assertArrayEquals(seriesAnalysis1.findTempsGreaterThan(50),
                seriesAnalysis2.findTempsGreaterThan(50), 0.0);

    }
}
