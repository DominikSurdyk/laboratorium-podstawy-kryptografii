package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.bbs.check;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VerifierServiceImpl implements VerifierService {
    final private static String BITS_TEST = "bitsTest";
    final private static String SERIES_TEST = "seriesTest";
    final private static String LONG_SERIES_TEST = "longSeriesTest";
    final private static String POKER_TEST = "pokerTest";


    BitsVerifier bitsVerifier = new BitsVerifier();
    SeriesVerifier seriesVerifier = new SeriesVerifier();
    LongSeriesVerifier longSeriesVerifier = new LongSeriesVerifier();
    PokerVerifier pokerVerifier = new PokerVerifier();
    CountVerifier countVerifier = new CountVerifier();

    @Override
    public CheckResult check(String testName, List<Boolean> series) {
        return switch (testName) {
            case SERIES_TEST -> seriesVerifier.check(series);
            case LONG_SERIES_TEST -> longSeriesVerifier.check(series);
            case POKER_TEST -> pokerVerifier.check(series);
            case BITS_TEST -> bitsVerifier.check(series);
            default -> countVerifier.check(series);
        };
    }
}
