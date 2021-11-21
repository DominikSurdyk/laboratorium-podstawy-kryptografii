package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.encryption;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EncryptorServiceImplTest {

    private EncryptorServiceImpl uut = new EncryptorServiceImpl();

    @Test
    public void shouldEncryptMessagesWithSameBitsNumber(){
        // given
        String message = "1234";
        List<Boolean> key = Arrays.asList(
                false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false);

        // when
        List<Boolean> result = uut.encryptFromString(message, key);

        // then
        assertEquals(24, result.size());
    }

}