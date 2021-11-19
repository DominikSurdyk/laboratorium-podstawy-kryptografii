package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.rsa;

import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class RsaEncryptServiceImpl implements RsaEncryptService {

    private final RsaEncryptor rsaEncryptor = new RsaEncryptor();

    @Override
    public List<String> encrypt(String message, String eParamPublic, String nParamCommon) {
        List<String> asciiValuesMessage = castToAsciValues(message);
        return rsaEncryptor.encryptAsNumber(asciiValuesMessage, eParamPublic, nParamCommon);
    }

    @Override
    public String decrypt(List<String> message, String dParamPrivate, String nParamCommon) {
        final List<String> decryptedChars = rsaEncryptor.decryptAsNumber(message, dParamPrivate, nParamCommon);
        return castToPlainText(decryptedChars);
    }

    private List<String> castToAsciValues(final String message) {
        List<String> result = new LinkedList<>();
        for (char c : message.toCharArray()) {
            result.add(String.valueOf((int) c));
        }
        return result;
    }

    private String castToPlainText(final List<String> decryptedChars) {
        StringBuilder result = new StringBuilder();
        for (String decrypted : decryptedChars) {
            char decryptedAsChar = (char) Integer.parseInt(decrypted);
            result.append(decryptedAsChar);
        }
        return result.toString();
    }
}
