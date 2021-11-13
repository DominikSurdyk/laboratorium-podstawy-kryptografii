package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.writefile;

import java.util.List;

public interface SaveLocallyService {
    public void saveBbs(final Long blumNumber, final Integer length, final Long randomNumber, final List<Boolean> series);
    public void saveEncryptedMessage(final String messageFileName, final String keyFileName, final List<Boolean> encryptedMessage);
    }
