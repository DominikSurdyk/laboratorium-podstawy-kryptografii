package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.aes;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;


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

    private static String castToString( byte[] input){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < input.length; i ++){
            int unsignedInt = (int) input[i] & 0xff;
            String number  = Integer.toBinaryString(unsignedInt);
            while (number.length() < 8) {
                number = '0' + number;
            }
            stringBuilder.append(number);
        }
        return stringBuilder.toString();
    }

    public static String encrypt(String strToEncrypt, String secret) {
        try {
//            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");

            cipher.init(Cipher.ENCRYPT_MODE, getKey(secret));
//            System.out.println(Arrays.toString(strToEncrypt.getBytes(StandardCharsets.UTF_8)));
//            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes(StandardCharsets.UTF_8)));
            byte[] result = cipher.doFinal(strToEncrypt.getBytes(StandardCharsets.UTF_8));
            return castToString(result);
        } catch (Exception e) {
            System.out.println("Error while encrypting: " + e);
        }
        return null;
    }

    public static String decrypt(String strToDecrypt, String secret) {
        try {
//            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");

            cipher.init(Cipher.DECRYPT_MODE, getKey(secret));
//            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
            return new String(cipher.doFinal(castToByteArray(strToDecrypt)));
        } catch (Exception e) {
            System.out.println("Error while decrypting: " + e);
        }
        return null;
    }


    private static byte[] castToByteArray(final String message) {
        byte[] result = new byte[16];
        for (int i = 0 ; i < 16; i++){
            int currentDigit = 0;
            if (message.charAt(i * 8) == '1'){
                currentDigit+=128;
            }
            if (message.charAt(i * 8 + 1) == '1'){
                currentDigit+=64;
            }
            if (message.charAt(i * 8 + 2) == '1'){
                currentDigit+=32;
            }
            if (message.charAt(i * 8 + 3) == '1'){
                currentDigit+=16;
            }
            if (message.charAt(i * 8 + 4) == '1'){
                currentDigit+=8;
            }
            if (message.charAt(i * 8 + 5) == '1'){
                currentDigit+=4;
            }
            if (message.charAt(i * 8 + 6) == '1'){
                currentDigit+=2;
            }
            if (message.charAt(i * 8 + 7) == '1'){
                currentDigit+=1;
            }
            result[i] = (byte) currentDigit;
        }
        return result;
    }

}
