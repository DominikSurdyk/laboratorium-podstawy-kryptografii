package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.aes;

import java.util.LinkedList;
import java.util.List;

public class StringConverter {

    private static final Integer CHAR_SIZE = 8;

    public List<Boolean> toBooleanArray(final int number) {
        String numberString = Integer.toBinaryString(number);
        numberString = addLeadingZeros(numberString);
        final List<Boolean> result = new LinkedList<>();
        for (char digit : numberString.toCharArray()) {
            if (digit == '1') {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        return result;
    }

    private String addLeadingZeros(String asciiCode) {
        while (CHAR_SIZE > asciiCode.length()) {
            asciiCode = "0" + asciiCode;
        }
        return asciiCode;
    }
}
