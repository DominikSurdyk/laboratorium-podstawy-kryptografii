package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.aes;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class AesWithModes {

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

    public static AesWithTimeResponse encrypt(String mode, byte[] message, String secret) {
        try {

            Cipher cipher = Cipher.getInstance(mode);
            if (needsInitialVector(mode)){
                IvParameterSpec iv = new IvParameterSpec("1234567890123456".getBytes("UTF-8"));
                cipher.init(Cipher.DECRYPT_MODE, getKey(secret), iv);
            }else if ("AES/ECB/NOPADDING".equals(mode)){
                cipher.init(Cipher.DECRYPT_MODE, getKey(secret));
            } else {
                GCMParameterSpec ivSpec = new GCMParameterSpec(16 * Byte.SIZE, "1234567890123456".getBytes("UTF-8"));
                cipher.init(Cipher.DECRYPT_MODE, getKey(secret), ivSpec);

            }

            long start = System.currentTimeMillis();
            byte[] encrypted = cipher.doFinal(message);
            long stop = System.currentTimeMillis();

            return new AesWithTimeResponse(encrypted, stop - start);
        } catch (Exception e) {
            System.out.println("Error while encrypting: " + e);
        }
        return null;
    }

    public static AesWithTimeResponse decrypt(String mode, byte[] message, String secret) {
        try {
            Cipher cipher = Cipher.getInstance(mode);
            if (needsInitialVector(mode)){
                IvParameterSpec iv = new IvParameterSpec("1234567890123456".getBytes("UTF-8"));
                cipher.init(Cipher.DECRYPT_MODE, getKey(secret), iv);
            }else if ("AES/ECB/NOPADDING".equals(mode)){
                cipher.init(Cipher.DECRYPT_MODE, getKey(secret));
            } else {
                GCMParameterSpec ivSpec = new GCMParameterSpec(16 * Byte.SIZE, "1234567890123456".getBytes("UTF-8"));
                cipher.init(Cipher.DECRYPT_MODE, getKey(secret), ivSpec);
            }

            long start = System.currentTimeMillis();
            byte[] decrypted = cipher.doFinal(message);
            long stop = System.currentTimeMillis();

            return new AesWithTimeResponse(decrypted, stop - start);
        } catch (Exception e) {
            System.out.println("Error while decrypting: " + e);
        }
        return null;
    }

    private static boolean needsInitialVector(String mode) {
        return "AES/CBC/NOPADDING".equals(mode) ||
                "AES/CFB/NOPADDING".equals(mode) ||
                "AES/OFB/NOPADDING".equals(mode) ||
                "AES/CTR/NOPADDING".equals(mode);
    }
}
