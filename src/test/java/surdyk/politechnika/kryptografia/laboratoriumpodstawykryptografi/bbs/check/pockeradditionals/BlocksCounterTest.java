package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.bbs.check.pockeradditionals;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BlocksCounterTest {

    BlocksCounter uut = new BlocksCounter();

    @Test
    public void shouldCountOneZeroNumber(){
        // given
        List<Boolean> request = Arrays.asList(false, false, false, false);

        // when
        int[] result = uut.count(request);

        // then
        assertEquals(1, result[0]);
    }

    @Test
    public void shouldCountTwoZeroNumbers(){
        // given
        List<Boolean> request = Arrays.asList(
                false, false, false, false,
                false, false, false, false
        );

        // when
        int[] result = uut.count(request);

        // then
        assertEquals(2, result[0]);
    }

    @Test
    public void shouldCountZeroAndFifteen(){
        // given
        List<Boolean> request = Arrays.asList(
                true, true, true, true,
                false, false, false, false
        );

        // when
        int[] result = uut.count(request);

        // then
        assertEquals(1, result[0]);
        assertEquals(1, result[15]);
        assertNotEquals(1, result[1]);
    }

}