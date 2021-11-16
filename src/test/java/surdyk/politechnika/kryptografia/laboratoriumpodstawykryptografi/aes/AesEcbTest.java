package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.aes;

import org.junit.jupiter.api.Test;

class AesEcbTest {


    private static final String SECRET = "a";

    @Test
    public void callEcb() {
        String encrypted = AesEcb.encrypt("Test  1234567890", SECRET);
        System.out.println(encrypted);

        String decrypted = AesEcb.decrypt(encrypted, SECRET);
        System.out.println(decrypted);

    }

}