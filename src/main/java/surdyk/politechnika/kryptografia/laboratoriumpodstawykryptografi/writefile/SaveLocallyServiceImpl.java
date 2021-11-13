package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.writefile;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Service
public class SaveLocallyServiceImpl implements SaveLocallyService {

    @Value( "${series.generated.folder}" )
    private String generatedBbsSavePath;

    @Value( "${encrypted.folder}" )
    private String encryptedMessagesSavePath;

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
    public void saveEncryptedMessage(final String messageFileName, final String keyFileName, final List<Boolean> encryptedMessage) {
        try {
            FileWriter fileWriter = new FileWriter(new File(encryptedMessagesSavePath, generateEncryptedFileName(messageFileName, keyFileName)));
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(generateContent(encryptedMessage));
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String generateContent(final List<Boolean> content) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Boolean b : content){
            if (b){
                stringBuilder.append("1");
            }else {
                stringBuilder.append("0");
            }
        }
        return stringBuilder.toString();
    }

    private String generateBbsFileName(final Long blumNumber, final Integer length, final Long randomNumber) {
        return getDateString() + "_length-" + length + "_blumNumber-" + blumNumber + "_randomNumber-" + randomNumber + ".txt";
    }

    private String generateEncryptedFileName(final String messageFileName, final String keyFileName) {
        return getDateString() + "___messageFileName-" + messageFileName + "___keyFileName-" + keyFileName + ".txt";
    }

    private String getDateString(){
        return java.time.LocalDate.now() + "_" + java.time.LocalTime.now();
    }
}
