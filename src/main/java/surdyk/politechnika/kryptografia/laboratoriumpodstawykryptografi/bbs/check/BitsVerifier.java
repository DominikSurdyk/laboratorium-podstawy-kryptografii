package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.bbs.check;

import java.util.List;

public class BitsVerifier {
    private static final int ONES_UPPER_BOUND = 10275;
    private static final int ONES_LOWER_BOUND = 9725;

    public CheckResult check(final List<Boolean> request) {
        int counter = 0;
        for (int i = 0; i < request.size(); i++) {
            if (request.get(i)) {
                counter++;
            }
        }
        return inRange(counter);
    }

    private CheckResult inRange(final int counter) {
        final boolean passed = counter > ONES_LOWER_BOUND &&
                counter < ONES_UPPER_BOUND;
        return new CheckResult(passed, "[Test bitów] Nieprawidłowa ilość cyfr [1]. Zliczono: [" + counter + "]");
    }
}
