package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.bbs.check;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountedSeriesTest {

    CountedSeries uut;

    @BeforeEach
    public void init(){
        uut = new CountedSeries();
    }

    @Test
    public void saveCorrectlySimpleTrue() {
        // when
        uut.saveSeries(true, 1);

        // then
        assertEquals(uut.getSeries(1, true),1);
        assertEquals(uut.getSeries(1, false),0);
    }

    @Test
    public void saveCorrectlySimpleFalse() {
        // when
        uut.saveSeries(false, 1);

        // then
        assertEquals(uut.getSeries(1, true),0);
        assertEquals(uut.getSeries(1, false),1);
    }

    @Test
    public void saveCorrectlyFewSeries() {
        // when
        uut.saveSeries(false, 1);
        uut.saveSeries(false, 1);
        uut.saveSeries(false, 1);
        uut.saveSeries(true, 5);
        uut.saveSeries(true, 5);

        // then
        assertEquals(uut.getSeries(1, false),3);
        assertEquals(uut.getSeries(5, true),2);
    }

}