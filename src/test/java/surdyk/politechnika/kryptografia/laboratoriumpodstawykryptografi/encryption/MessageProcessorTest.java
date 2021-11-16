package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.encryption;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MessageProcessorTest {

    final private MessageProcessor uut = new MessageProcessor();

    @Test
    public void shouldEncrypt() {
        // given
        final List<Boolean> key = Arrays.asList(true, true, false, false);
        final List<Boolean> message = Arrays.asList(true, false, true, false);
        final List<Boolean> encrypted = Arrays.asList(false, true, true, false);

        // when
        List<Boolean> result = uut.xor(key, message);

        // then
        assertEquals(encrypted, result);
    }

    @Test
    public void shoulDecrypt() {
        // given
        final List<Boolean> key = Arrays.asList(true, true, false, false);
        final List<Boolean> encryptedMessage = Arrays.asList(false, true, true, false);
        final List<Boolean> decryptedMessage = Arrays.asList(true, false, true, false);

        // when
        List<Boolean> result = uut.xor(key, encryptedMessage);

        // then
        assertEquals(decryptedMessage, result);
    }

}