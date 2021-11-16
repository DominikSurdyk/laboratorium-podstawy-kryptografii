package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.aes;

import org.springframework.stereotype.Service;

@Service
public class EcbServiceImpl implements EcbService{

    public String encrypt(final String message, final String secret){
        return AesEcb.encrypt(message, secret);
    }

    public String decrypt(final String message, final String secret) {
        return AesEcb.decrypt(message, secret);
    }
}
