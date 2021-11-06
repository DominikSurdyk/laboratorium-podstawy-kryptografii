package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.bbs.check;

import surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.bbs.check.seriescounter.CountedSeries;
import surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.bbs.check.seriescounter.SeriesCounter;

import java.util.List;
import java.util.Optional;

public class LongSeriesVerifier {
    private final SeriesCounter seriesCounter = new SeriesCounter();

    public CheckResult check(final List<Boolean> request) {
        CountedSeries result = seriesCounter.count(request);
        Optional<Integer> tooLongSeries = result.getSeriesCounter().keySet().stream()
                .filter(seriesLength -> seriesLength >= 26)
                .findFirst();

        return tooLongSeries.isEmpty() ? new CheckResult(true, "") :
                new CheckResult(false, "Znaleziono ciąg dłuższy niż 26 znaków");
    }
}
