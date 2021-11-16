package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.aes;

public interface EcbService {
    public String encrypt(final String message, final String secret);
    public String decrypt(final String encodedMessage, final String secret);
}
