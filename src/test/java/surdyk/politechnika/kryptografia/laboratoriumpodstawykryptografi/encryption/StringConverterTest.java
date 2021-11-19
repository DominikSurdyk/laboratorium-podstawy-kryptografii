package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.encryption;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringConverterTest {

    private final AsciiStringConverter uut = new AsciiStringConverter();

    @Test
    public void shouldParseCorrectlySimpleMessage() {
        // given
        final String message = "test";

        // when
        List<Boolean> result = uut.messageToAsciiSeries(message);

        // then
        assertEquals(Arrays.asList(
                false, true, true, true, false, true, false, false,
                false, true, true, false, false, true, false, true,
                false, true, true, true, false, false, true, true,
                false, true, true, true, false, true, false, false
        ), result);
    }

    @Test
    public void shouldParseCorrectlyMessageWithSpace() {
        // given
        final String message = "a a";

        // when
        List<Boolean> result = uut.messageToAsciiSeries(message);

        // then
        assertEquals(Arrays.asList(
                false, true, true, false, false, false, false, true,
                false, false, true, false, false, false, false, false,
                false, true, true, false, false, false, false, true
        ), result);
    }

    @Test
    public void shouldParseCorrectlyMessageWithOnlySpace() {
        // given
        final String message = " ";

        // when
        List<Boolean> result = uut.messageToAsciiSeries(message);

        // then
        assertEquals(Arrays.asList(
                false, false, true, false, false, false, false, false
        ), result);
    }

    @Test
    public void shouldParseCorrectlyListToString() {
        // given
        final List<Boolean> message = Arrays.asList(
                false, true, true, true, false, true, false, false,
                false, true, true, false, false, true, false, true,
                false, true, true, true, false, false, true, true,
                false, true, true, true, false, true, false, false
        );

        // when
        String result = uut.messageToString(message);

        // then
        assertEquals("test", result);
    }

}