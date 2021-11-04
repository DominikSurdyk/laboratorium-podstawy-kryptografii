package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.bbs.check;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BitsCheckResult implements CheckResult{
    private final boolean passed;
    private final String details;

    @Override
    public boolean passed() {
        return passed;
    }

    @Override
    public String details() {
        return details;
    }
}
