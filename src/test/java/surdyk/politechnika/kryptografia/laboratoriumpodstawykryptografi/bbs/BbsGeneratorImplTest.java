package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.bbs;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.bbs.check.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.bbs.check.BbsConstants.TEST_LENGTH_20K;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BbsGeneratorImplTest {

    // 50000057, 60000009, 60000077
    final Long blumNumberN = Long.valueOf("60000077");
    // 2500011, 2500010, 2500010
    final Long naturalNumberA = Long.valueOf("2500010");

    BbsGeneratorImpl uut = new BbsGeneratorImpl();
    List<Boolean> request;

    @BeforeAll
    public void initSeries() {
        System.out.println("Generating 20k long series");
        request = uut.generate(blumNumberN, TEST_LENGTH_20K, naturalNumberA, true);
    }


    @Test
    public void simpleTest20K() {
        assertEquals(20000, request.size());
    }

    @Test
    public void bitsTest() {
        // given
        BitsVerifier bitsVerifier = new BitsVerifier();

        // when
        CheckResult result = bitsVerifier.check(request);

        System.out.println(result.getDetails());
        assertTrue(result.isPassed());
    }

    @Test
    public void longSeriesTest() {
        // given
        LongSeriesVerifier longSeriesVerifier = new LongSeriesVerifier();

        // when
        CheckResult result = longSeriesVerifier.check(request);

        // then
        assertTrue(result.isPassed());
    }

    @Test
    public void seriesTest() {
        // given
        SeriesVerifier seriesVerifier = new SeriesVerifier();

        // when
        CheckResult passed = seriesVerifier.check(request);

        // then
        assertTrue(passed.isPassed());

    }

    @Test
    public void pokerTest() {
        // given
        PokerVerifier pokerVerifier = new PokerVerifier();

        // when
        CheckResult result = pokerVerifier.check(request);

        // then
        assertTrue(result.isPassed());
    }
}