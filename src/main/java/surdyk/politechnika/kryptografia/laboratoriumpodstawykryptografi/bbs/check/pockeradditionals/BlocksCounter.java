package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.bbs.check.pockeradditionals;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;


public class BlocksCounter {
    @Getter
    private final int[] result = new int[16];

    public int[] count(final List<Boolean> request) {
        Arrays.fill(result, 0);

        NumberBlock numberBlock = new NumberBlock();
        int i = 0;
        while (i < request.size()) {
            numberBlock.saveDigit(i, request.get(i));
            if (i % NumberBlock.LENGTH == NumberBlock.LAST_DIGIT_INDEX) {
                int decimalValue = numberBlock.toDecimal();
                result[decimalValue]++;
                numberBlock = new NumberBlock();
            }
            i++;
        }
        return result;
    }
}
