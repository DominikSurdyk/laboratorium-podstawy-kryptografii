package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.bbs.check;

import lombok.Getter;
import surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.bbs.check.pockeradditionals.BlocksCounter;
import surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.bbs.check.pockeradditionals.NumberBlock;

import java.util.List;


public class PokerVerifier {
    @Getter
    BlocksCounter blocksCounter = new BlocksCounter();

    public CheckResult check(final List<Boolean> request) {
        final int[] blocksCount = getBlocksCounter().count(request);
        final float expressionResult = expressionResult(blocksCount);
        return inRange(expressionResult);
    }

    private float expressionResult(final int[] blocksCount) {
        float sigma = 0;
        for (int i = 0; i <= NumberBlock.LAST_BLOCK_INDEX; i++) {
            sigma += Math.pow(blocksCount[i], 2);
        }
        return ((float) 16 / 5000) * sigma - 5000;
    }

    private CheckResult inRange(final float result) {
        return result > 2.16 &&
                result < 46.17 ?
                new CheckResult(true, "") :
                new CheckResult(false, "Współczynnik testu pokerowego jest poza dopuszczalnymi granicami. Wynosi: [" + result + "]");
    }

}
