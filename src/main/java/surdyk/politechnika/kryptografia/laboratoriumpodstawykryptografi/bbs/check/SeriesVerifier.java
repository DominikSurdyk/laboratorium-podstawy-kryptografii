package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.bbs.check;

import surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.bbs.check.seriescounter.CountedSeries;
import surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.bbs.check.seriescounter.SeriesCounter;

import java.util.List;

public class SeriesVerifier {
    private static final int SERIES_1_LENGTH_MIN_COUNT = 2315;
    private static final int SERIES_1_LENGTH_MAX_COUNT = 2685;
    private static final int SERIES_2_LENGTH_MIN_COUNT = 1114;
    private static final int SERIES_2_LENGTH_MAX_COUNT = 1386;
    private static final int SERIES_3_LENGTH_MIN_COUNT = 527;
    private static final int SERIES_3_LENGTH_MAX_COUNT = 723;
    private static final int SERIES_4_LENGTH_MIN_COUNT = 240;
    private static final int SERIES_4_LENGTH_MAX_COUNT = 384;
    private static final int SERIES_5_LENGTH_MIN_COUNT = 103;
    private static final int SERIES_5_LENGTH_MAX_COUNT = 209;
    private static final int SERIES_6_LENGTH_OR_MORE_MIN_COUNT = 103;
    private static final int SERIES_6_LENGTH_OR_MORE_MAX_COUNT = 209;
    private final SeriesCounter seriesCounter = new SeriesCounter();

    public boolean check(final List<Boolean> request) {
        CountedSeries result = seriesCounter.count(request);
        return checkOneToFive(result) && checkSixAndMore(result);
    }

    private boolean checkSixAndMore(CountedSeries result) {

        int series6AndMoreLengthTrueCount = result.getSeriesCounter().keySet().stream()
                .filter(seriesLength -> seriesLength >= 6).
                mapToInt(seriesLength -> result.getSeries(seriesLength, true))
                .sum();
        int series6AndMoreLengthFalseCount = result.getSeriesCounter().keySet().stream()
                .filter(seriesLength -> seriesLength >= 6).
                mapToInt(seriesLength -> result.getSeries(seriesLength, false))
                .sum();

        if (series6AndMoreLengthTrueCount < SERIES_6_LENGTH_OR_MORE_MIN_COUNT || series6AndMoreLengthTrueCount > SERIES_6_LENGTH_OR_MORE_MAX_COUNT) {
            return false;
        }
        if (series6AndMoreLengthFalseCount < SERIES_6_LENGTH_OR_MORE_MIN_COUNT || series6AndMoreLengthFalseCount > SERIES_6_LENGTH_OR_MORE_MAX_COUNT) {
            return false;
        }
        return true;
    }


    private boolean checkOneToFive(CountedSeries result) {
        int series1LengthTrueCount = result.getSeries(1, true);
        int series1LengthFalseCount = result.getSeries(1, false);
        if (series1LengthTrueCount < SERIES_1_LENGTH_MIN_COUNT || series1LengthTrueCount > SERIES_1_LENGTH_MAX_COUNT) {
            return false;
        }
        if (series1LengthFalseCount < SERIES_1_LENGTH_MIN_COUNT || series1LengthFalseCount > SERIES_1_LENGTH_MAX_COUNT) {
            return false;
        }

        int series2LengthTrueCount = result.getSeries(2, true);
        int series2LengthFalseCount = result.getSeries(2, false);
        if (series2LengthTrueCount < SERIES_2_LENGTH_MIN_COUNT || series2LengthTrueCount > SERIES_2_LENGTH_MAX_COUNT) {
            return false;
        }
        if (series2LengthFalseCount < SERIES_2_LENGTH_MIN_COUNT || series2LengthFalseCount > SERIES_2_LENGTH_MAX_COUNT) {
            return false;
        }

        int series3LengthTrueCount = result.getSeries(3, true);
        int series3LengthFalseCount = result.getSeries(3, false);
        if (series3LengthTrueCount < SERIES_3_LENGTH_MIN_COUNT || series3LengthTrueCount > SERIES_3_LENGTH_MAX_COUNT) {
            return false;
        }
        if (series3LengthFalseCount < SERIES_3_LENGTH_MIN_COUNT || series3LengthFalseCount > SERIES_3_LENGTH_MAX_COUNT) {
            return false;
        }

        int series4LengthTrueCount = result.getSeries(4, true);
        int series4LengthFalseCount = result.getSeries(4, false);
        if (series4LengthTrueCount < SERIES_4_LENGTH_MIN_COUNT || series4LengthTrueCount > SERIES_4_LENGTH_MAX_COUNT) {
            return false;
        }
        if (series4LengthFalseCount < SERIES_4_LENGTH_MIN_COUNT || series4LengthFalseCount > SERIES_4_LENGTH_MAX_COUNT) {
            return false;
        }

        int series5LengthTrueCount = result.getSeries(5, true);
        int series5LengthFalseCount = result.getSeries(5, false);
        if (series5LengthTrueCount < SERIES_5_LENGTH_MIN_COUNT || series5LengthTrueCount > SERIES_5_LENGTH_MAX_COUNT) {
            return false;
        }
        return series5LengthFalseCount >= SERIES_5_LENGTH_MIN_COUNT && series5LengthFalseCount <= SERIES_5_LENGTH_MAX_COUNT;
    }

}
