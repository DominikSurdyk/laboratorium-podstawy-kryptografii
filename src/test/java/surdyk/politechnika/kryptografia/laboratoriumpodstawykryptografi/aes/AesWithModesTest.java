package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.aes;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AesWithModesTest {
    private final String ECB_MODE = "ECB";
    private final String CBC_MODE = "CBC";
    private final String CFB_MODE = "CFB";
    private final String OFB_MODE = "OFB";
    private final String CTR_MODE = "CTR";

    private final int KILOBYTE = 1024;
    private final int MEGABYTE = 1048576;
    private final int GIGABYTE = 1073741824;

    private final List<String> modes = Arrays.asList(ECB_MODE, CBC_MODE, CFB_MODE, OFB_MODE, CTR_MODE);
    private final List<Integer> sizes = Arrays.asList(KILOBYTE, MEGABYTE, GIGABYTE);

    private final String secret = "strong secret";

    Random random = new Random();


    private byte[] generateInput(final int size) {
        final byte[] result = new byte[size];
        for (int i = 0; i < size; i++) {
            result[i] = (byte) random.nextInt(256);
        }
        return result;
    }

    @Test
    public void runTest() {
        for (Integer size : sizes) {
            final byte[] message = generateInput(size);
            for (String mode : modes) {
                AesWithTimeResponse encrypted = AesWithModes.encrypt(getMode(mode), message, secret);
                System.out.println(" ENCRYPTION - size: [" + size + "], mode: [" + mode + "], time: [" + encrypted.getProcessTimeMiliSec() + "]");
                AesWithTimeResponse decrypted = AesWithModes.decrypt(getMode(mode), encrypted.getMessage(), secret);
                System.out.println(" DECRYPTION - size: [" + size + "], mode: [" + mode + "], time: [" + decrypted.getProcessTimeMiliSec() + "]");
                assertEquals(message, decrypted.getMessage());
            }
        }
    }

    @Test
    public void ecb() {
        final byte[] message = generateInput(128);

        AesWithTimeResponse encrypted = AesWithModes.encrypt("AES/ECB/PKCS5Padding", message, secret);
        AesWithTimeResponse decrypted = AesWithModes.decrypt("AES/ECB/PKCS5Padding", encrypted.getMessage(), secret);
    }


    private String getMode(final String mode) {
        return "AES/" + mode + "/NOPADDING";
    }

}