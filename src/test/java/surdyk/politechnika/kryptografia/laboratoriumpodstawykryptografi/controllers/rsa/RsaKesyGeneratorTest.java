package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.controllers.rsa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RsaKesyGeneratorTest {

    RsaKesyGenerator uut = new RsaKesyGenerator();

    @Test
    public void findQ() {
        int result = uut.findKey(17, 3395088);
        System.out.println(result);
    }

}