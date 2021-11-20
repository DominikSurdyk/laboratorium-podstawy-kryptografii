package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.common;

import java.util.Arrays;
import java.util.List;

public class StringHelper {

    public String join(final List<String> strings) {
        final StringBuilder stringBuilder = new StringBuilder();
        for (int i =0 ; i < strings.size(); i ++) {
            stringBuilder.append(strings.get(i));
            if (i < strings.size() - 1){
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }

    public List<String> toArray(final String message) {
        return Arrays.asList(message.split(" "));
    }
}
