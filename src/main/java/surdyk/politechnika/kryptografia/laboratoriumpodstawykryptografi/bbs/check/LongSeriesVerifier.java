package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.bbs.check;

import java.util.List;

public class LongSeriesVerifier {
    private final SeriesCounter seriesCounter = new SeriesCounter();

    public boolean check(final List<Boolean> request) {
        CountedSeries result = seriesCounter.count(request);

        return result.getSeriesCounter().keySet().stream()
                .filter(seriesLength -> seriesLength >= 26)
                .findAny()
                .map(overTwentySix -> false)
                .orElse(true);
    }
}
