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

    @Override
    public CheckResult check(String testName, List<Boolean> series) {
        CheckResult checkResult;
        switch (testName) {
            default :
                checkResult = bitsVerifier.check(series);
        }
        return checkResult;
    }
}
