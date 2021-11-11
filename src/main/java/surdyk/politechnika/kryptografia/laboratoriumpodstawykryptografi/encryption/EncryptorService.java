package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.encryption;

import java.util.List;

public interface EncryptorService {
    List<Boolean> encryptFromString(final String message, final List<Boolean> series);
    List<Boolean> encryptFromAscii(final List<Boolean> messageAscii, final List<Boolean> seriesKey);

    List<Boolean> decryptToAscii(final List<Boolean> messageAsci, final List<Boolean> series);
    String decryptToString(final List<Boolean> messageAsci, final List<Boolean> seriesKey);
}
