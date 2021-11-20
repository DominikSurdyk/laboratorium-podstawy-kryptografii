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

    @Test
    public void shouldJoinCorrectly(){
        // given
        List<String> message = Arrays.asList("123", "3", "2", "43", "1");

        // when
        String result = uut.join(message);

        // then
        assertEquals("123 3 2 43 1", result);
    }

    @Test
    public void shouldJoinCorrectlyOneWord(){
        // given
        List<String> message = List.of("21");

        // when
        String result = uut.join(message);

        // then
        assertEquals("21", result);
    }


}