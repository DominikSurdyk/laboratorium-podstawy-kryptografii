package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.common;

import java.util.Arrays;
import java.util.List;

public class StringHelper {

    public String join(final List<String> strings) {
        final StringBuilder stringBuilder = new StringBuilder();
        for (String part : strings) {
            stringBuilder.append(part);
        }
        return stringBuilder.toString();
    }

    public List<String> toArray(final String message) {
        return Arrays.asList(message.split(" "));
    }
}
