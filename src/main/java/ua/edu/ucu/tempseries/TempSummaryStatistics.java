package ua.edu.ucu.tempseries;


import lombok.Getter;

public final class TempSummaryStatistics {
    @Getter
    private final double avgTemp;
    @Getter
    private final double devTemp;
    @Getter
    private final double minTemp;
    @Getter
    private final double maxTemp;
    public TempSummaryStatistics(TemperatureSeriesAnalysis seriesAnalysis) {
        this.avgTemp = seriesAnalysis.average();
        this.devTemp = seriesAnalysis.deviation();
        this.minTemp = seriesAnalysis.min();
        this.maxTemp = seriesAnalysis.max();
    }
}
