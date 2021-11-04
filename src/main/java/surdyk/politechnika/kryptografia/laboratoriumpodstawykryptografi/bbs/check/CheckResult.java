package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.bbs.check;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class CheckResult {
    private boolean passed;
    private String details;
}
