package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.bbs;

import org.junit.jupiter.api.Test;
import surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.bbs.check.BitsVerifier;
import surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.bbs.check.LongSeriesVerifier;
import surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.bbs.check.SeriesVerifier;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BbsGeneratorTest {

    private static final Integer LENGTH_20K = 20000;
    private static final Integer LENGTH_1M = 1000000;
    final Long blumNumberN = Long.valueOf("789");
    final Long naturalNumberA = Long.valueOf("238470123486127834");

    BbsGenerator uut = new BbsGenerator();


    @Test
    public void simpleTest20K(){
        uut.generate(blumNumberN, LENGTH_20K, naturalNumberA, true);
    }

    @Test
    public void bitsTest() {
        // given
        List<Boolean> result = uut.generate(blumNumberN, LENGTH_20K, naturalNumberA, true);
        BitsVerifier bitsVerifier = new BitsVerifier();

        // when
        boolean passed = bitsVerifier.check(result);

        assertTrue( passed);
    }

    @Test
    public void longSeriesTest() {
        // given
        List<Boolean> result = uut.generate(blumNumberN, LENGTH_20K, naturalNumberA, true);
        LongSeriesVerifier longSeriesVerifier = new LongSeriesVerifier();

        // when
        boolean passed = longSeriesVerifier.check(result);

        // then
        assertTrue(passed);
    }

    @Test
    public void seriesTest() {
        // given
        List<Boolean> result = uut.generate(blumNumberN, LENGTH_20K, naturalNumberA, true);
        SeriesVerifier seriesVerifier = new SeriesVerifier();

        // when
        boolean passed = seriesVerifier.check(result);

        // then
        assertTrue(passed);

    }
}