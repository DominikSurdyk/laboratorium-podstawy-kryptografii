package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.aes;

import org.springframework.stereotype.Service;

@Service
public class PbcServiceImpl implements PbcService{
    @Override
    public String encrypt(String message, String secret, String initVector) {
        return null;
    }

    @Override
    public String decrypt(String encodedMessage, String secret, String initVector) {
        return null;
    }
}
