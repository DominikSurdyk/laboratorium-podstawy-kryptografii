package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.writefile;

import java.util.List;

public interface SaveLocallyService {
    public void saveBbs(final Long blumNumber, final Integer length, final Long randomNumber, final List<Boolean> series);
    public void saveEncryptedBbsMessage(final String messageFileName, final String keyFileName, final List<Boolean> encryptedMessage);
    public void saveEncryptedEcbMessage(final String encryptedMessage, final String secret);
    public void saveEncryptedCbcMessage(final String encryptedMessage, final String secret, final String initVector);
    public void saveEncryptedPbcMessage(final String encryptedMessage, final String secret, final String initVector);

}
