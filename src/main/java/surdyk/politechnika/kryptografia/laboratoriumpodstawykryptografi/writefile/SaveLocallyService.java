package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.writefile;

import java.util.List;

public interface SaveLocallyService {
    void saveBbs(final Long blumNumber, final Integer length, final Long randomNumber, final List<Boolean> series);

    void saveEncryptedBbsMessage(final String messageFileName, final String keyFileName, final List<Boolean> encryptedMessage);

    void saveEncryptedEcbMessage(final String encryptedMessage, final String secret);

    void saveEncryptedCbcMessage(final String encryptedMessage, final String secret, final String initVector);

    void saveEncryptedPbcMessage(final String encryptedMessage, final String secret, final String initVector);

    void saveEncryptedRsaMessage(final String message,
                                 final String eParamPublic,
                                 final String dParamPrivate,
                                 final String nParamCommon);
}
