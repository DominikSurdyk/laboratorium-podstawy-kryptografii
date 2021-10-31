package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.bbs.check;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.bbs.check.seriescounter.CountedSeries;
import surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.bbs.check.seriescounter.SeriesCounter;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SeriesCounterTest {

    SeriesCounter uut;

    @BeforeEach
    public void init() {
        uut = new SeriesCounter();
    }

    @Test
    public void countOneTrue() {
        // given
        List<Boolean> series = Arrays.asList(true);

        // when
        CountedSeries result = uut.count(series);

        // then
        assertEquals(result.getSeries(1, true), 1);
    }

    @Test
    public void countOneFalse() {
        // given
        List<Boolean> series = Arrays.asList(false);

        // when
        CountedSeries result = uut.count(series);

        // then
        assertEquals(result.getSeries(1, false), 1);
    }

    @Test
    public void count3TruesSeries() {
        // given
        List<Boolean> series = Arrays.asList(true, true, true);

        // when
        CountedSeries result = uut.count(series);

        // then
        assertEquals(result.getSeries(3, true), 1);
    }

    @Test
    public void count3FalseSeries() {
        // given
        List<Boolean> series = Arrays.asList(false, false, false);

        // when
        CountedSeries result = uut.count(series);

        // then
        assertEquals(result.getSeries(3, false), 1);
    }

    @Test
    public void count3Trues3FalseSeries() {
        // given
        List<Boolean> series = Arrays.asList(false, false, false, true, true, true);

        // when
        CountedSeries result = uut.count(series);

        // then
        assertEquals(result.getSeries(3, true), 1);
        assertEquals(result.getSeries(3, false), 1);

    }

    @Test
    public void count1LongSeries() {
        // given
        List<Boolean> series = Arrays.asList(true, false, true, false, true, false);

        // when
        CountedSeries result = uut.count(series);

        // then
        assertEquals(result.getSeries(1, true), 3);
        assertEquals(result.getSeries(1, false), 3);

    }
}