package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.aes;

import org.springframework.stereotype.Service;
import surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.encryption.AsciiStringConverter;
import surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.encryption.MessageProcessor;

import java.util.List;

@Service
public class EcbServiceImpl implements EcbService {
    private final MessageBlocksParser messageBlocksParser = new MessageBlocksParser();
    private final AsciiStringConverter asciiStringConverter = new AsciiStringConverter();
    private final MessageProcessor messageProcessor = new MessageProcessor();

    public String encrypt(final String message, final String secret) {
        StringBuilder result = new StringBuilder();
        List<String> blocks = messageBlocksParser.to8CharBlocks(message);
        for (String block : blocks) {
            List<Boolean> messageAscii = asciiStringConverter.messageToAsciiSeries(block);
            messageBlocksParser.fillBlock(messageAscii);
            String toEncrypt = asciiStringConverter.messageToString(messageAscii);

            String encryptedBlock = AesEcb.encrypt(toEncrypt, secret);

            result.append(encryptedBlock);
        }
        return result.toString();
    }

    public String decrypt(final String message, final String secret) {

        StringBuilder result = new StringBuilder();
        List<String> blocks = messageBlocksParser.to128BitBlocks(message);

        for (String block : blocks) {
            String decryptedBlock = AesEcb.decrypt(block, secret);
            List<Boolean> decrypted = messageBlocksParser.removePadding(asciiStringConverter.messageToAsciiSeries(decryptedBlock));

            result.append(asciiStringConverter.messageToString(decrypted));
        }
        return result.toString();
    }
}
