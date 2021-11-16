package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.aes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AesEcbTest {

    @Test
    public void callEcb(){
        String encrypted = AesEcb.encrypt("lubie placki z batatow i tym podobne", "123456gsfdgsdfg789012345");
        System.out.println(encrypted);

        String decrypted = AesEcb.decrypt(encrypted, "123456gsfdgsdfg789012345");
        System.out.println(decrypted);

    }

}