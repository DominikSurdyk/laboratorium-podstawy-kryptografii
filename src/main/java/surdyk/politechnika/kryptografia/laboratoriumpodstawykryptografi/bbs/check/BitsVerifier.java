package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.bbs.check;

import java.util.List;

import static surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.bbs.check.BbsConstants.TEST_LENGTH_20K;

public class BitsVerifier {

    private static int ONES_UPPER_BOUND = 10275;
    private static int ONES_LOWER_BOUND = 9725;


    public boolean check(final List<Boolean> request) {
        int counter = 0;
        for (int i = 0 ; i < TEST_LENGTH_20K; i++){
            if (request.get(i)){
                counter++;
            };
        }
        return inRange(counter);
    }

    private boolean inRange(final int counter) {
        return counter > ONES_LOWER_BOUND &&
                counter < ONES_UPPER_BOUND;
    }
}
