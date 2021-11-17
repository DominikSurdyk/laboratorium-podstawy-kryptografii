package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.aes;

import org.springframework.stereotype.Service;
import surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.encryption.AsciiStringConverter;
import surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.encryption.MessageProcessor;

import java.util.List;

@Service
public class PbcServiceImpl implements PbcService{

    private final MessageBlocksParser messageBlocksParser = new MessageBlocksParser();
    private final AsciiStringConverter asciiStringConverter = new AsciiStringConverter();
    private final MessageProcessor messageProcessor = new MessageProcessor();

    @Override
    public String encrypt(String message, String secret, String initVector) {
        StringBuilder result = new StringBuilder();
        List<String> blocks = messageBlocksParser.to8CharBlocks(message);
        List<Boolean> currentVector = asciiStringConverter.messageToAsciiSeries(initVector);
        for (String block : blocks) {
            List<Boolean> messageAscii = asciiStringConverter.messageToAsciiSeries(block);
            messageBlocksParser.fillBlock(messageAscii);
            List<Boolean> toEncrypt = messageProcessor.xor(messageAscii, currentVector);
            currentVector = asciiStringConverter.messageToAsciiSeries(block);
            String encryptedBlock = AesEcb.encrypt(asciiStringConverter.messageToString(toEncrypt), secret);
            result.append(encryptedBlock);
        }
        return result.toString();
    }

    @Override
    public String decrypt(String encodedMessage, String secret, String initVector) {
        StringBuilder result = new StringBuilder();
        List<String> blocks = messageBlocksParser.to128BitBlocks(encodedMessage);
        List<Boolean> currentVector = asciiStringConverter.messageToAsciiSeries(initVector);
        for (String block : blocks) {
            String decryptedBlock = AesEcb.decrypt(block, secret);

            List<Boolean> decryptedBlockAscii = asciiStringConverter.messageToAsciiSeries(decryptedBlock);
            List<Boolean> decryptedAndXorBlock = messageProcessor.xor(decryptedBlockAscii, currentVector);
            decryptedAndXorBlock = messageBlocksParser.removePadding(decryptedAndXorBlock);
            result.append(asciiStringConverter.messageToString(decryptedAndXorBlock));
            currentVector = decryptedAndXorBlock;
        }
        return result.toString();
    }
}
