package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.bbs.check;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LongSeriesVerifierTest {

    LongSeriesVerifier uut = new LongSeriesVerifier();

    @Test
    public void shouldPass25LongSeries(){
        // given
        List<Boolean> testValue = Arrays.asList(
                true, true, true, true, true,
                true, true, true, true, true,
                true, true, true, true, true,
                true, true, true, true, true,
                true, true, true, true, true);

        // when
        CheckResult result = uut.check(testValue);

        // then
        assertTrue(result.isPassed());
    }

    @Test
    public void shouldNotPass25LongSeries(){
        // given
        List<Boolean> testValue = Arrays.asList(
                true, true, true, true, true,
                true, true, true, true, true,
                true, true, true, true, true,
                true, true, true, true, true,
                true, true, true, true, true, true);

        // when
        CheckResult result = uut.check(testValue);

        // then
        assertFalse(result.isPassed());
    }
}