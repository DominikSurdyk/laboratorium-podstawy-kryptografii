package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.writefile;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static java.time.format.DateTimeFormatter.ISO_LOCAL_TIME;

@Service
public class SaveLocallyServiceImpl implements SaveLocallyService {

    @Value("${series.generated.path}")
    private String generatedBbsSavePath;

    @Value("${encrypted.bbs.path}")
    private String encryptedBbsMessagesSavePath;

    @Value("${encrypted.ecb.path}")
    private String encryptedEcbMessagesSavePath;

    @Value("${encrypted.cbc.path}")
    private String encryptedCbcMessagesSavePath;

    @Value("${encrypted.pbc.path}")
    private String encryptedPbcMessagesSavePath;

    public void saveBbs(final Long blumNumber, final Integer length, final Long randomNumber, final List<Boolean> series) {
        try {
            FileWriter fileWriter = new FileWriter(new File(generatedBbsSavePath, generateBbsFileName(blumNumber, length, randomNumber)));
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(generateContent(series));
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveEncryptedBbsMessage(final String messageFileName, final String keyFileName, final List<Boolean> encryptedMessage) {
        try {
            FileWriter fileWriter = new FileWriter(new File(encryptedBbsMessagesSavePath, generateEncryptedBbsFileName(messageFileName, keyFileName)));
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(generateContent(encryptedMessage));
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveEncryptedEcbMessage(final String encryptedMessage, final String secret) {
        try {
            FileWriter fileWriter = new FileWriter(new File(encryptedEcbMessagesSavePath, generateEncryptedEcbFileName(secret)));
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(encryptedMessage);
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveEncryptedCbcMessage(final String encryptedMessage, final String secret, final String initVector) {
        try {
            FileWriter fileWriter = new FileWriter(new File(encryptedCbcMessagesSavePath, generateEncryptedCbcFileName(secret, initVector)));
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(encryptedMessage);
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveEncryptedPbcMessage(final String encryptedMessage, final String secret, final String initVector) {
        try {
            FileWriter fileWriter = new FileWriter(new File(encryptedPbcMessagesSavePath, generateEncryptedPbcFileName(secret, initVector)));
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(encryptedMessage);
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String generateContent(final List<Boolean> content) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Boolean b : content) {
            if (b) {
                stringBuilder.append("1");
            } else {
                stringBuilder.append("0");
            }
        }
        return stringBuilder.toString();
    }

    private String generateBbsFileName(final Long blumNumber, final Integer length, final Long randomNumber) {
        return getDateString() + "_length-" + length + "_blumNumber-" + blumNumber + "_randomNumber-" + randomNumber + ".txt";
    }

    private String generateEncryptedBbsFileName(final String messageFileName, final String keyFileName) {
        return getDateString() + "___messageFileName-" + messageFileName + "___keyFileName-" + keyFileName + ".txt";
    }

    private String generateEncryptedEcbFileName(final String secret) {
        return getDateString() + "_secret-" + secret + ".txt";
    }

    private String generateEncryptedCbcFileName(final String secret, final String initVector) {
        return getDateString() + "_secret-" + secret + "_initVector-" + initVector + ".txt";
    }

    private String generateEncryptedPbcFileName(final String secret, final String initVector) {
        return getDateString() + "_secret-" + secret + "_initVector-" + initVector + ".txt";
    }

    private String getDateString() {
        return java.time.LocalDate.now() + "_" + java.time.LocalTime.now().truncatedTo(ChronoUnit.SECONDS).format(ISO_LOCAL_TIME);
    }
}
