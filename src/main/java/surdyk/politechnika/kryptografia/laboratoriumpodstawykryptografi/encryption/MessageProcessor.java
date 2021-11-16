package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.encryption;

import java.util.LinkedList;
import java.util.List;

public class MessageProcessor {

    public List<Boolean> xor(final List<Boolean> message, final List<Boolean> key) {
        final List<Boolean> result = new LinkedList<>();
        for (int i = 0; i < message.size(); i++) {
            result.add(Boolean.logicalXor(message.get(i), key.get(i)));
        }
        return result;
    }
}
