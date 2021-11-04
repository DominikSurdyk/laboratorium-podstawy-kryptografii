package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.bbs.check;

import surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.bbs.check.seriescounter.CountedSeries;
import surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.bbs.check.seriescounter.SeriesCounter;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

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
    private static final String FAIL_COMMUNICATE_ONE_TO_FIVE = "Za dużo ciagów o długości: [%d], dla cyfry: [%d]. Zliczono: [%d]";
    private static final String FAIL_COMMUNICATE_SIX_AND_MORE = "Za dużo ciagów o długości: >=6, dla cyfry: [%d]. Zliczono: [%d]";


    private final SeriesCounter seriesCounter = new SeriesCounter();

    public CheckResult check(final List<Boolean> request) {
        final List<CheckResult> results = new LinkedList<>();
        CountedSeries result = seriesCounter.count(request);
        results.add(checkOneToFive(result));
        results.add(checkSixAndMore(result));
        return collectResults(results, "");
    }

    private CheckResult checkSixAndMore(CountedSeries result) {
        final List<CheckResult> results = new LinkedList<>();

        int series6AndMoreLengthTrueCount = result.getSeriesCounter().keySet().stream()
                .filter(seriesLength -> seriesLength >= 6).
                mapToInt(seriesLength -> result.getSeries(seriesLength, true))
                .sum();
        int series6AndMoreLengthFalseCount = result.getSeriesCounter().keySet().stream()
                .filter(seriesLength -> seriesLength >= 6).
                mapToInt(seriesLength -> result.getSeries(seriesLength, false))
                .sum();

        if (series6AndMoreLengthTrueCount < SERIES_6_LENGTH_OR_MORE_MIN_COUNT || series6AndMoreLengthTrueCount > SERIES_6_LENGTH_OR_MORE_MAX_COUNT) {
            results.add(new CheckResult(false, String.format(FAIL_COMMUNICATE_SIX_AND_MORE, 1, series6AndMoreLengthTrueCount)));
        }
        if (series6AndMoreLengthFalseCount < SERIES_6_LENGTH_OR_MORE_MIN_COUNT || series6AndMoreLengthFalseCount > SERIES_6_LENGTH_OR_MORE_MAX_COUNT) {
            results.add(new CheckResult(false, String.format(FAIL_COMMUNICATE_SIX_AND_MORE, 0, series6AndMoreLengthFalseCount)));
        }
        return collectResults(results, "");
    }


    private CheckResult checkOneToFive(CountedSeries result) {
        final List<CheckResult> results = new LinkedList<>();

        int series1LengthTrueCount = result.getSeries(1, true);
        int series1LengthFalseCount = result.getSeries(1, false);
        if (series1LengthTrueCount < SERIES_1_LENGTH_MIN_COUNT || series1LengthTrueCount > SERIES_1_LENGTH_MAX_COUNT) {
            results.add(new CheckResult(false, String.format(FAIL_COMMUNICATE_ONE_TO_FIVE, 1, 1, series1LengthTrueCount)));
        }
        if (series1LengthFalseCount < SERIES_1_LENGTH_MIN_COUNT || series1LengthFalseCount > SERIES_1_LENGTH_MAX_COUNT) {
            results.add(new CheckResult(false, String.format(FAIL_COMMUNICATE_ONE_TO_FIVE, 1, 0, series1LengthFalseCount)));
        }

        int series2LengthTrueCount = result.getSeries(2, true);
        int series2LengthFalseCount = result.getSeries(2, false);
        if (series2LengthTrueCount < SERIES_2_LENGTH_MIN_COUNT || series2LengthTrueCount > SERIES_2_LENGTH_MAX_COUNT) {
            results.add(new CheckResult(false, String.format(FAIL_COMMUNICATE_ONE_TO_FIVE, 2, 1, series2LengthTrueCount)));
        }
        if (series2LengthFalseCount < SERIES_2_LENGTH_MIN_COUNT || series2LengthFalseCount > SERIES_2_LENGTH_MAX_COUNT) {
            results.add(new CheckResult(false, String.format(FAIL_COMMUNICATE_ONE_TO_FIVE, 2, 0, series2LengthFalseCount)));
        }

        int series3LengthTrueCount = result.getSeries(3, true);
        int series3LengthFalseCount = result.getSeries(3, false);
        if (series3LengthTrueCount < SERIES_3_LENGTH_MIN_COUNT || series3LengthTrueCount > SERIES_3_LENGTH_MAX_COUNT) {
            results.add(new CheckResult(false, String.format(FAIL_COMMUNICATE_ONE_TO_FIVE, 3, 1, series3LengthTrueCount)));
        }
        if (series3LengthFalseCount < SERIES_3_LENGTH_MIN_COUNT || series3LengthFalseCount > SERIES_3_LENGTH_MAX_COUNT) {
            results.add(new CheckResult(false, String.format(FAIL_COMMUNICATE_ONE_TO_FIVE, 3, 0, series3LengthFalseCount)));
        }

        int series4LengthTrueCount = result.getSeries(4, true);
        int series4LengthFalseCount = result.getSeries(4, false);
        if (series4LengthTrueCount < SERIES_4_LENGTH_MIN_COUNT || series4LengthTrueCount > SERIES_4_LENGTH_MAX_COUNT) {
            results.add(new CheckResult(false, String.format(FAIL_COMMUNICATE_ONE_TO_FIVE, 4, 1, series4LengthTrueCount)));
        }
        if (series4LengthFalseCount < SERIES_4_LENGTH_MIN_COUNT || series4LengthFalseCount > SERIES_4_LENGTH_MAX_COUNT) {
            results.add(new CheckResult(false, String.format(FAIL_COMMUNICATE_ONE_TO_FIVE, 4, 0, series4LengthFalseCount)));

        }

        int series5LengthTrueCount = result.getSeries(5, true);
        int series5LengthFalseCount = result.getSeries(5, false);
        if (series5LengthTrueCount < SERIES_5_LENGTH_MIN_COUNT || series5LengthTrueCount > SERIES_5_LENGTH_MAX_COUNT) {
            results.add(new CheckResult(false, String.format(FAIL_COMMUNICATE_ONE_TO_FIVE, 5, 1, series5LengthTrueCount)));
        }
        if (series5LengthFalseCount < SERIES_5_LENGTH_MIN_COUNT || series5LengthFalseCount > SERIES_5_LENGTH_MAX_COUNT) {
            results.add(new CheckResult(false, String.format(FAIL_COMMUNICATE_ONE_TO_FIVE, 5, 0, series5LengthFalseCount)));
        }
        return collectResults(results, "");
    }


    private CheckResult collectResults(List<CheckResult> results, String errors) {
        AtomicReference<String> errorMessages = new AtomicReference<>(errors);

        Optional<CheckResult> errorResult = results.stream().filter(result -> !result.isPassed()).findFirst();

        if (errorResult.isEmpty()) {
            return new CheckResult(true, "");
        } else {
            results.stream()
                    .filter(result -> !result.isPassed())
                    .forEach(result -> errorMessages.set(errorMessages + result.getDetails() + "\n"));
            return new CheckResult(false, errorMessages.get());
        }
    }
}
