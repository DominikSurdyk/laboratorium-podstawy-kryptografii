package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.encryption;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EncryptorServiceImpl implements EncryptorService {
    MessageProcessor messageProcessor = new MessageProcessor();
    AsciiStringConverter asciiStringConverter = new AsciiStringConverter();

    @Override
    public List<Boolean> encryptFromString(String message, List<Boolean> key) {
        final List<Boolean> messageAscii = asciiStringConverter.messageToAsciiSeries(message);
        return messageProcessor.xor(messageAscii, key);
    }

    @Override
    public List<Boolean> encryptFromAscii(List<Boolean> messageAscii, List<Boolean> key) {
        return messageProcessor.xor(messageAscii, key);
    }

    @Override
    public List<Boolean> decryptToAscii(List<Boolean> messageAscii, List<Boolean> key) {
        return messageProcessor.xor(messageAscii, key);

    }

    @Override
    public String decryptToString(List<Boolean> messageAscii, List<Boolean> key) {
        final List<Boolean> decryptedMessage = messageProcessor.xor(messageAscii, key);
        return asciiStringConverter.messageToString(decryptedMessage);
    }
}
