package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.bbs;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BbsGeneratorImpl implements BbsGenerator{

    @Override
    public List<Boolean> generate(final Long n, final Integer r, final Long a, final boolean print) {

        final List<Long> numbers = new ArrayList<>();
        final List<Boolean> output = new ArrayList<>();

        numbers.add((long) Math.pow(a, 2) % n);

        for (int i = 1; i <= r; i++) {
            final Long x = ((long) Math.pow(numbers.get(i - 1), 2) % n);
            numbers.add(x);
            output.add(modulo2ToBoolean(x, print));
        }

        return output;
    }

    private Boolean modulo2ToBoolean(final Long number, final boolean print) {
        final Long b = number % 2;
        if (print) {
            System.out.print(b);
        }
        return b % 2 == 1;
    }
}
