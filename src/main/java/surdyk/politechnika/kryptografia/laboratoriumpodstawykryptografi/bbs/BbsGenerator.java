package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.bbs;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BbsGenerator {
    List<Boolean> generate(final Long n, final Integer r, final Long a, final boolean print);
}
