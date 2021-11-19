package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.common;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Arrays;


import static org.junit.jupiter.api.Assertions.*;

class StringHelperTest {

    private final StringHelper uut = new StringHelper();

    @Test
    public void shouldParseCorrectly(){
        // given
        String message = "123 3 2 43 1";

        // when
        List<String> result = uut.toArray(message);

        // then
        assertEquals(Arrays.asList("123", "3", "2", "43", "1"), result);
    }

    @Test
    public void shouldParseCorrectlyOneWord(){
        // given
        String message = "123";

        // when
        List<String> result = uut.toArray(message);

        // then
        assertEquals(Arrays.asList("123"), result);
    }


}