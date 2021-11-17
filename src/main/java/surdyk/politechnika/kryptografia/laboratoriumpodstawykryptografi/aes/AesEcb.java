package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.aes;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;


public class AesEcb {

    private static SecretKey getKey(String myKey) {
        byte[] key;
        MessageDigest sha = null;
        try {
            key = myKey.getBytes(StandardCharsets.UTF_8);
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            return new SecretKeySpec(key, "AES");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String castToString(byte[] input) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : input) {
            int unsignedInt = (int) b & 0xff;
            String number = Integer.toBinaryString(unsignedInt);
            while (number.length() < 8) {
                number = '0' + number;
            }
            stringBuilder.append(number);
        }
        return stringBuilder.toString();
    }

    public static String encrypt(String strToEncrypt, String secret) {
        try {

            Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");

            cipher.init(Cipher.ENCRYPT_MODE, getKey(secret));
            byte[] result = cipher.doFinal(strToEncrypt.getBytes(StandardCharsets.UTF_8));
            return castToString(result);
        } catch (Exception e) {
            System.out.println("Error while encrypting: " + e);
        }
        return null;
    }

    public static String decrypt(String strToDecrypt, String secret) {
        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
            cipher.init(Cipher.DECRYPT_MODE, getKey(secret));
            return new String(cipher.doFinal(castToByteArray(strToDecrypt)));
        } catch (Exception e) {
            System.out.println("Error while decrypting: " + e);
        }
        return null;
    }


    private static byte[] castToByteArray(final String message) {
        int blocks = message.length() / 128;
        byte[] result = new byte[16 * blocks];
        for (int i = 0; i < 16 * blocks; i++) {
            int currentDigit = 0;
            if (message.charAt(i * 8) == '1') {
                currentDigit += 128;
            }
            if (message.charAt(i * 8 + 1) == '1') {
                currentDigit += 64;
            }
            if (message.charAt(i * 8 + 2) == '1') {
                currentDigit += 32;
            }
            if (message.charAt(i * 8 + 3) == '1') {
                currentDigit += 16;
            }
            if (message.charAt(i * 8 + 4) == '1') {
                currentDigit += 8;
            }
            if (message.charAt(i * 8 + 5) == '1') {
                currentDigit += 4;
            }
            if (message.charAt(i * 8 + 6) == '1') {
                currentDigit += 2;
            }
            if (message.charAt(i * 8 + 7) == '1') {
                currentDigit += 1;
            }
            result[i] = (byte) currentDigit;
        }
        return result;
    }

}
