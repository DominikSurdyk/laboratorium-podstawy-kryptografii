package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.aes;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MessageBlocksParserTest {

    MessageBlocksParser uut = new MessageBlocksParser();

    @Test
    public void shouldGenerateOneBlock() {
        // given
        final String request = "0123456789123456";

        // when
        List<String> blocks = uut.to8CharBlocks(request);

        // then
        assertEquals(1, blocks.size());
        assertEquals(Arrays.asList("0123456789123456"), blocks);
    }

    @Test
    public void shouldGenerateTwoBlocks() {
        // given
        final String request = "01234567891234560";

        // when
        List<String> blocks = uut.to8CharBlocks(request);

        // then
        assertEquals(2, blocks.size());
        assertEquals(Arrays.asList("0123456789123456", "0"), blocks);
    }

    @Test
    public void shouldGenerateTwoFullBlocks() {
        // given
        final String request = "01234567891234560123456789123456";

        // when
        List<String> blocks = uut.to8CharBlocks(request);

        // then
        assertEquals(2, blocks.size());
        assertEquals(Arrays.asList("0123456789123456", "0123456789123456"), blocks);
    }

    @Test
    public void shouldNotFillFullBlock() {
        // given
        final List<Boolean> request = Arrays.asList(
                false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false
        );

        // when
        List<Boolean> block = uut.fillBlock(request);

        // then
        assertEquals(128, block.size());
        assertEquals(request, block);
    }

    @Test
    public void shouldAddOneNumberOneAtEnd() {
        // given
        final List<Boolean> request = new LinkedList<>(Arrays.asList(
                false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false
        ));

        // when
        List<Boolean> block = uut.fillBlock(request);

        // then
        assertEquals(128, block.size());
        assertEquals(
                Arrays.asList(
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, true
                ), block);
    }

    @Test
    public void shouldAddFifteenTimesFifteen() {
        // given
        final List<Boolean> request = new LinkedList<>(Arrays.asList(
                false, false, false, false, false, false, false, false
        ));

        // when
        List<Boolean> block = uut.fillBlock(request);

        // then
        assertEquals(128, block.size());
        assertEquals(
                Arrays.asList(
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, true, true, true, true,
                        false, false, false, false, true, true, true, true,
                        false, false, false, false, true, true, true, true,
                        false, false, false, false, true, true, true, true,
                        false, false, false, false, true, true, true, true,
                        false, false, false, false, true, true, true, true,
                        false, false, false, false, true, true, true, true,
                        false, false, false, false, true, true, true, true,
                        false, false, false, false, true, true, true, true,
                        false, false, false, false, true, true, true, true,
                        false, false, false, false, true, true, true, true,
                        false, false, false, false, true, true, true, true,
                        false, false, false, false, true, true, true, true,
                        false, false, false, false, true, true, true, true,
                        false, false, false, false, true, true, true, true
                ), block);
    }

    @Test
    public void shouldNotRemoveAnyPadding() {
        // given
        final List<Boolean> request = Arrays.asList(
                false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false,
                true, true, true, true, true, true, true, true
        );

        // when
        List<Boolean> block = uut.removePadding(request);

        // then
        assertEquals(128, block.size());
        assertEquals(
                Arrays.asList(
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        true, true, true, true, true, true, true, true
                ), block);
    }

    @Test
    public void shouldRemoveFifteenRows() {
        // given
        final List<Boolean> request = new LinkedList<>(Arrays.asList(
                false, false, false, false, false, false, false, false,
                false, false, false, false, true, true, true, true,
                false, false, false, false, true, true, true, true,
                false, false, false, false, true, true, true, true,
                false, false, false, false, true, true, true, true,
                false, false, false, false, true, true, true, true,
                false, false, false, false, true, true, true, true,
                false, false, false, false, true, true, true, true,
                false, false, false, false, true, true, true, true,
                false, false, false, false, true, true, true, true,
                false, false, false, false, true, true, true, true,
                false, false, false, false, true, true, true, true,
                false, false, false, false, true, true, true, true,
                false, false, false, false, true, true, true, true,
                false, false, false, false, true, true, true, true,
                false, false, false, false, true, true, true, true
        ));

        // when
        List<Boolean> block = uut.removePadding(request);

        // then
        assertEquals(8, block.size());
        assertEquals(
                Arrays.asList(
                        false, false, false, false, false, false, false, false
                ), block);
    }

    @Test
    public void shouldRemoveLastRow() {
        // given
        final List<Boolean> request = new LinkedList<>(Arrays.asList(
                false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, false,
                false, false, false, false, false, false, false, true));

        // when
        List<Boolean> block = uut.removePadding(request);

        // then
        assertEquals(120, block.size());
        assertEquals(
                Arrays.asList(
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false,
                        false, false, false, false, false, false, false, false
                ), block);
    }
}