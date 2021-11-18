package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.rsa;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RsaEncryptorTest {

    private final RsaEncryptor uut = new RsaEncryptor();

    @Test
    public void shouldEncryptCorrectly() {
        // given
        String message = "8";
        String e = "7";
        String n = "589";

        // when
        String result = uut.encryptAsNumber(message, e, n);
        List<String> resultArray = uut.encryptAsNumber(Arrays.asList(message, message), e, n);

        // then
        assertEquals("312", result);
        assertEquals(Arrays.asList("312", "312"), resultArray);

    }

    @Test
    public void shouldDecryptCorrectly() {
        // given
        String message = "312";
        String d = "463";
        String n = "589";

        // when
        String result = uut.decryptAsNumber(message, d, n);
        List<String> resultArray = uut.encryptAsNumber(Arrays.asList(message, message), d, n);


        // then
        assertEquals("8", result);
        assertEquals(Arrays.asList("8", "8"), resultArray);


    }

    @Test
    public void shouldEncryptAndDecryptCorrectly() {
        // given
        List<String> message = Arrays.asList("1", "44", "34", "234", "105");
        String e = "7";
        String d = "463";
        String n = "589";

        // when
        List<String> encrypted = uut.encryptAsNumber(message, e, n);
        List<String> decrypted = uut.decryptAsNumber(encrypted, d, n);

        // then
        assertEquals(Arrays.asList("1", "44", "34", "234", "105"), decrypted);
    }
}