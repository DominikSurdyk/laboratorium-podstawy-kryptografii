package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.encryption;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AsciiStringConverterTest {

    private final AsciiStringConverter uut = new AsciiStringConverter();

    @Test
    public void shouldParseCorrectlySimpleMessage() {
        // given
        final String message = "test";

        // when
        List<Boolean> result = uut.messageToAsciiSeries(message);

        // then
        assertEquals(Arrays.asList(
                true, true, true, false, true, false, false,
                true, true, false, false, true, false, true,
                true, true, true, false, false, true, true,
                true, true, true, false, true, false, false
                ), result);
    }

    @Test
    public void shouldParseCorrectlyListToString() {
        // given
        final List<Boolean> message = Arrays.asList(
                true, true, true, false, true, false, false,
                true, true, false, false, true, false, true,
                true, true, true, false, false, true, true,
                true, true, true, false, true, false, false
        );

        // when
        String result = uut.messageToString(message);

        // then
        assertEquals("test", result);
    }

}