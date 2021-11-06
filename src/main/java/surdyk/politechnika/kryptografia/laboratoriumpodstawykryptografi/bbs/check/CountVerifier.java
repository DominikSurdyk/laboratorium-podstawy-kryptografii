package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.bbs.check;

import java.util.List;

import static surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.bbs.check.BbsConstants.TEST_LENGTH_20K;

public class CountVerifier {

    public CheckResult check(List<Boolean> request) {
        final boolean passed = TEST_LENGTH_20K == request.size();
        final String details = passed ?
                "" : "Ciag nie ma odpowiedniej długości. Zliczono: [" + request.size() + "] znaków";
        return new CheckResult(passed, details);
    }
}
