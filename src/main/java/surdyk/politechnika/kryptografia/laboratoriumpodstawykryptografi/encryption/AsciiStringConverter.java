package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.encryption;

import java.util.LinkedList;
import java.util.List;

public class AsciiStringConverter {
    private static int ASCII_CHAR_LENGTH = 8;

    public List<Boolean> messageToAsciiSeries(final String message) {
        final List<Boolean> result = new LinkedList<>();
        for (int i = 0; i < message.length(); i++) {
            result.add(false);
            addChar(result, message.charAt(i));
        }
        return result;
    }

    public String messageToString(final List<Boolean> message) {
        final StringBuilder result = new StringBuilder();
        for (int i = 1; i < message.size(); i = i + ASCII_CHAR_LENGTH) {
            int charValue = 0;
            if (message.get(i)) {
                charValue += 64;
            }
            if (message.get(i + 1)) {
                charValue += 32;
            }
            if (message.get(i + 2)) {
                charValue += 16;
            }
            if (message.get(i + 3)) {
                charValue += 8;
            }
            if (message.get(i + 4)) {
                charValue += 4;
            }
            if (message.get(i + 5)) {
                charValue += 2;
            }
            if (message.get(i + 6)) {
                charValue += 1;
            }
            result.append((char) charValue);
        }
        return result.toString();
    }

    private void addChar(final List<Boolean> asciiMessage, final char sign) {
        String asciiCode = Integer.toBinaryString(sign);
        asciiCode = addLeadingZeros(asciiCode);
        for (int i = 0; i < asciiCode.length(); i++) {
            if ('1' == asciiCode.charAt(i)) {
                asciiMessage.add(true);
            } else {
                asciiMessage.add(false);
            }
        }
    }

    private String addLeadingZeros(String asciiCode) {
        while ( ASCII_CHAR_LENGTH - 1 > asciiCode.length()){
            asciiCode = "0" + asciiCode;
        }
        return asciiCode;
    }
}
