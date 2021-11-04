package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.bbs.check;

import java.util.List;

public interface VerifierService {
    public CheckResult check(String testName, List<Boolean> series);
}
