package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.rsa;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.time.Duration;
import java.time.Instant;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RsaEncryptServiceImplTest {

    RsaEncryptServiceImpl uut = new RsaEncryptServiceImpl();

    @Test
    public void shouldEncryptAndDecryptMessage() {
        // given
        final String message = "Testowa wiadomosc";
        String dPrivatePartOfKey = "463";
        String ePublicPartOfKey = "7";
        String nCommonPart = "589";

        // when
        List<String> encrypted = uut.encrypt(message, ePublicPartOfKey, nCommonPart);
        System.out.println(encrypted);
        String result = uut.decrypt(encrypted, dPrivatePartOfKey, nCommonPart);

        // then
        assertEquals("Testowa wiadomosc", result);
    }

    @Test
    public void shouldEncryptAndDecryptMessagesECOND() {
        // given
        final String message = "w";
        String dPrivatePartOfKey = "7630543";
        String ePublicPartOfKey = "127";
        String nCommonPart = "96927587";

        // when
        List<String> encrypted = uut.encrypt(message, ePublicPartOfKey, nCommonPart);
        System.out.println(encrypted);
        String result = uut.decrypt(encrypted, dPrivatePartOfKey, nCommonPart);

        // then
        assertEquals("w", result);
    }

    @Test
    public void maxValue() {
        System.out.println(Integer.MAX_VALUE);
    }

    @Test
    public void shouldEncryptAndDecryptMessageThird() {
        // given
        final String message = "wiadomosc zawieraja 50 znakow. Zdanie dopelniajace";

        String dPrivatePartOfKey = "3195377";
        String ePublicPartOfKey = "17";
        String nCommonPart = "3398803";

        // when
        List<String> encrypted = uut.encrypt(message, ePublicPartOfKey, nCommonPart);
        System.out.println(encrypted);

        Instant start = Instant.now();
        String result = uut.decrypt(encrypted, dPrivatePartOfKey, nCommonPart);
        Instant stop = Instant.now();

        long timeElapsed = Duration.between(start, stop).toSeconds();
System.out.println("czas wykonania: " + timeElapsed);

        // then
        assertEquals("wiadomosc zawieraja 50 znakow. Zdanie dopelniajace", result);
    }

}