package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.rsa;

import org.junit.jupiter.api.Test;

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
        final String message = "~~~~~";
        String dPrivatePartOfKey = "463";
        String ePublicPartOfKey = "7";
        String nCommonPart = "589";

        // when
        List<String> encrypted = uut.encrypt(message, ePublicPartOfKey, nCommonPart);
        System.out.println(encrypted);
        String result = uut.decrypt(encrypted, dPrivatePartOfKey, nCommonPart);

        // then
        assertEquals("~~~~~", result);
    }

}