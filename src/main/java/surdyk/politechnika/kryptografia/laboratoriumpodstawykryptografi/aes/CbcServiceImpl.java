package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.aes;

import org.springframework.stereotype.Service;
import surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.encryption.AsciiStringConverter;
import surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.encryption.MessageProcessor;

import java.util.List;

@Service
public class CbcServiceImpl implements CbcService {
    private final MessageBlocksParser messageBlocksParser = new MessageBlocksParser();
    private final AsciiStringConverter asciiStringConverter = new AsciiStringConverter();
    private final MessageProcessor messageProcessor = new MessageProcessor();

    @Override
    public String encrypt(final String message, final String secret, final String initVector) {
        StringBuilder result = new StringBuilder();
        List<String> blocks = messageBlocksParser.to8CharBlocks(message);
        List<Boolean> currentVector = asciiStringConverter.messageToAsciiSeries(initVector);
        for (String block : blocks) {
            List<Boolean> messageAscii = asciiStringConverter.messageToAsciiSeries(block);
            messageBlocksParser.fillBlock(messageAscii);
            String toEncrypt = asciiStringConverter.messageToString(messageProcessor.xor(messageAscii, currentVector));

            String encryptedBlock = AesEcb.encrypt(toEncrypt, secret);

            result.append(encryptedBlock);
            currentVector = asciiStringConverter.messageToAsciiSeries(encryptedBlock);
        }
        return result.toString();
    }

    @Override
    public String decrypt(final String encodedMessage, final String secret, final String initVector) {
        StringBuilder result = new StringBuilder();
        List<String> blocks = messageBlocksParser.to128BitBlocks(encodedMessage);
        List<Boolean> currentVector = asciiStringConverter.messageToAsciiSeries(initVector);

        for (String block : blocks) {
            String decryptedBlock = AesEcb.decrypt(block, secret);

            List<Boolean> decryptedBlockAscii = asciiStringConverter.messageToAsciiSeries(decryptedBlock);
            List<Boolean> decryptedAndXorBlock = messageProcessor.xor(decryptedBlockAscii, currentVector);
            decryptedAndXorBlock = messageBlocksParser.removePadding(decryptedAndXorBlock);
            result.append(asciiStringConverter.messageToString(decryptedAndXorBlock));
            currentVector = asciiStringConverter.messageToAsciiSeries(block);
        }
        return result.toString();
    }
}
