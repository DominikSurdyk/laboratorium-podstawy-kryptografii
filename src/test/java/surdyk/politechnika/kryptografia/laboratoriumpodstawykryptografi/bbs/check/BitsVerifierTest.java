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
        assertFalse(result.passed());
    }

    @Test
    public void shouldBlameToLowOnes() {
        // given
        List<Boolean> request = generateInput(9724);

        // when
        CheckResult result = uut.check(request);

        // then
        assertFalse(result.passed());
        assertEquals("[BitsTest] Ones counted: 9724", result.details());
    }

    @Test
    public void shouldPassCountInRanges() {
        // given
        List<Boolean> request = generateInput(10000);

        // when
        CheckResult result = uut.check(request);

        // then
        assertTrue(result.passed());
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