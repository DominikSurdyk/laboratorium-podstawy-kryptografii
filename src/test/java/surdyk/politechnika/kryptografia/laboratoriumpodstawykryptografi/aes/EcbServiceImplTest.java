package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.aes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EcbServiceImplTest {

    private EcbServiceImpl uut = new EcbServiceImpl();

    @Test
    public void shouldEncryptAndDecryptOneBlockMessageMessage() {
        //given
        final String message = "1234567890123456";
        final String secret = "1111222233334444";
        final String initVector = "9999888877776666";

        // when
        String encryptedMessage = uut.encrypt(message, secret);
        String decryptedMessage = uut.decrypt(encryptedMessage, secret);

        // then
        assertEquals(message, decryptedMessage);
    }

    @Test
    public void shouldEncryptAndDecryptTwoBlockMessageMessage() {
        //given
        final String message = "12345678901234561234567890123456";
        final String secret = "1111222233334444";
        final String initVector = "9999888877776666";

        // when
        String encryptedMessage = uut.encrypt(message, secret);
        String decryptedMessage = uut.decrypt(encryptedMessage, secret);

        // then
        assertEquals(message, decryptedMessage);
    }

    @Test
    public void shouldEncryptOneAndALittleMessage() {
        //given
        final String message = "12345678901234561";
        final String secret = "1111222233334444";
        final String initVector = "9999888877776666";

        // when
        String encryptedMessage = uut.encrypt(message, secret);
        String decryptedMessage = uut.decrypt(encryptedMessage, secret);

        // then
        assertEquals(message, decryptedMessage);
    }


}