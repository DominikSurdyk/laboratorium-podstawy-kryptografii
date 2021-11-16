package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.aes;

public interface CbcService {
    public String encrypt(final String message, final String secret, final String initVector);
    public String decrypt(final String encodedMessage, final String secret, final String initVector);
}
