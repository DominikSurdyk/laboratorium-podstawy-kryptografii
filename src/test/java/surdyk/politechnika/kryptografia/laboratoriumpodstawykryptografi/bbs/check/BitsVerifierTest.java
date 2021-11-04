package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.bbs.check;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BitsVerifierTest {

    BitsVerifier uut = new BitsVerifier();

    @Test
    public void shouldBlameToManyOnes() {
        // given
        List<Boolean> request = generateInput(10276);

        // when
        CheckResult result = uut.check(request);

        // then
        assertFalse(result.isPassed());
    }

    @Test
    public void shouldBlameToLowOnes() {
        // given
        List<Boolean> request = generateInput(9724);

        // when
        CheckResult result = uut.check(request);

        // then
        assertFalse(result.isPassed());
        assertEquals("[Test bitów] Nieprawidłowa ilość cyfr [1]. Zliczono: [9724]", result.getDetails());
    }

    @Test
    public void shouldPassCountInRanges() {
        // given
        List<Boolean> request = generateInput(10000);

        // when
        CheckResult result = uut.check(request);

        // then
        assertTrue(result.isPassed());
    }

    private List<Boolean> generateInput(final int onesCount) {
        List<Boolean> response = new LinkedList<>();
        for (int i =0 ; i < onesCount; i++){
            response.add(true);
            response.add(false);
        }
        return response;
    }
}