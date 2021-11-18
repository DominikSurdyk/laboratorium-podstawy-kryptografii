package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.rsa;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

public class RsaEncryptor {

    public List<String> encryptAsNumber(final List<String> messages, final String e, final String n) {
        List<String> result = new LinkedList<>();
        for (String message : messages) {
            result.add(encryptAsNumber(message, e, n));
        }
        return result;
    }

    public List<String> decryptAsNumber(final List<String> messages, final String e, final String n) {
        List<String> result = new LinkedList<>();
        for (String message : messages) {
            result.add(decryptAsNumber(message, e, n));
        }
        return result;
    }

    public String encryptAsNumber(final String message, final String e, final String n) {
        BigInteger messageEncoded = new BigInteger(message);
        int eEncoded = Integer.parseInt(e);
        messageEncoded = messageEncoded.pow(eEncoded);
        messageEncoded = messageEncoded.mod(new BigInteger(n));
        return messageEncoded.toString();
    }

    public String decryptAsNumber(final String message, final String d, final String n) {
        BigInteger messageEncoded = new BigInteger(message);
        int eEncoded = Integer.parseInt(d);
        messageEncoded = messageEncoded.pow(eEncoded);
        messageEncoded = messageEncoded.mod(new BigInteger(n));
        return messageEncoded.toString();
    }
}
