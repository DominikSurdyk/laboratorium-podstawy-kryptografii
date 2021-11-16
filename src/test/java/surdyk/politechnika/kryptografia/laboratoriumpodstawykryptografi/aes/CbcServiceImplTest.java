package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.aes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CbcServiceImplTest {

    private CbcServiceImpl uut = new CbcServiceImpl();

    @Test
    public void shouldEncryptAndDecryptOneBlockMessageMessage() {
        //given
        final String message = "1234567890123456";
        final String secret = "1111222233334444";
        final String initVector = "9999888877776666";

        // when
        String encryptedMessage = uut.encrypt(message, secret, initVector);
        System.out.println(encryptedMessage);
        String decryptedMessage = uut.decrypt(encryptedMessage, secret, initVector);

        // then
        assertEquals(message, decryptedMessage);
    }

}