package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.aes;

import java.util.LinkedList;
import java.util.List;

public class MessageBlocksParser {
    private static final Integer CHARS_IN_BLOCK = 16;
    private static final Integer CHAR_SIZE = 8;
    private static final Integer BLOCK_BYTES_SIZE = CHARS_IN_BLOCK * CHAR_SIZE;

    public List<String> to8CharBlocks(final String message) {
        final int blockNumbers = count8CharBlocks(message);
        final List<String> blocks = new LinkedList<>();
        for (int i = 0; i < blockNumbers; i++) {
            if (i == blockNumbers - 1) {
                blocks.add(message.substring(i * CHARS_IN_BLOCK));
            } else {
                blocks.add(message.substring(i * CHARS_IN_BLOCK, i * CHARS_IN_BLOCK + CHARS_IN_BLOCK));
            }
        }
        return blocks;
    }

    public List<String> to128BitBlocks(final String message) {
        final int blockNumbers = count128BitBlocks(message);
        final List<String> blocks = new LinkedList<>();
        for (int i = 0; i < blockNumbers; i++) {
            if (i == blockNumbers - 1) {
                blocks.add(message.substring(i * BLOCK_BYTES_SIZE));
            } else {
                blocks.add(message.substring(i * BLOCK_BYTES_SIZE, i * BLOCK_BYTES_SIZE + BLOCK_BYTES_SIZE));
            }
        }
        return blocks;
    }

    private int count8CharBlocks(final String message) {
        if (message.length() == 0) {
            return 0;
        }
        if (message.length() % CHARS_IN_BLOCK == 0) {
            return message.length() / CHARS_IN_BLOCK;
        } else {
            return 1 + message.length() / CHARS_IN_BLOCK;
        }
    }
    private int count128BitBlocks(final String message) {
        if (message.length() == 0) {
            return 0;
        }
        if (message.length() % BLOCK_BYTES_SIZE == 0) {
            return message.length() / BLOCK_BYTES_SIZE;
        } else {
            return 1 + message.length() / BLOCK_BYTES_SIZE;
        }
    }


    public List<Boolean> fillBlock(final List<Boolean> block) {
        if (block.size() == BLOCK_BYTES_SIZE) {
            return block;
        }
        final int missingChars = (BLOCK_BYTES_SIZE - block.size()) / CHAR_SIZE;
        final List<Boolean> digitToFill = toBooleanArray(missingChars);
        for (int i = 0; i < missingChars; i++) {
            block.addAll(digitToFill);
        }
        return block;
    }

    public List<Boolean> removePadding(List<Boolean> block) {
        int padding = getLastNumber(block);
        if (padding > CHARS_IN_BLOCK - 1 || padding == 0) {
            return block;
        }
        for (int i = 0 ; i < padding * CHAR_SIZE; i++){
            block.remove(block.size() -1);
        }
        return block;
    }

    private int getLastNumber(final List<Boolean> block) {
        int digitValue = 1;
        int result = 0;
        for (int i = BLOCK_BYTES_SIZE - 1; i >= BLOCK_BYTES_SIZE - CHAR_SIZE; i--){
            if( block.get(i)){
                result+=digitValue;
            }
            digitValue = digitValue * 2;
        }
        return result;
    }


    private List<Boolean> toBooleanArray(final int number) {
        String numberString = Integer.toBinaryString(number);
        numberString = addLeadingZeros(numberString);
        final List<Boolean> result = new LinkedList<>();
        for (char digit : numberString.toCharArray()) {
            if (digit == '1') {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        return result;
    }

    private String addLeadingZeros(String asciiCode) {
        while (CHAR_SIZE > asciiCode.length()) {
            asciiCode = "0" + asciiCode;
        }
        return asciiCode;
    }
}
