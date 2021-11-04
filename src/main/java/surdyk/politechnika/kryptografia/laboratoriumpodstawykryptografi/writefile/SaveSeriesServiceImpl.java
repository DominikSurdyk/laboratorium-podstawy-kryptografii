package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.writefile;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Service
public class SaveSeriesServiceImpl implements SaveSeriesService{

    @Value( "${series.generated.folder}" )
    private String filesDirectoryPath;

    public void saveLocally(final Long blumNumber, final Integer length, final Long randomNumber, final List<Boolean> series) {

        try {
            FileWriter fileWriter = new FileWriter(new File(filesDirectoryPath, generateFileName(blumNumber, length, randomNumber)));
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.print(generateContent(series));
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private String generateContent(final List<Boolean> content) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Boolean b : content){
            if (b){
                stringBuffer.append("1");
            }else {
                stringBuffer.append("0");
            }
        }
        return stringBuffer.toString();
    }

    private String generateFileName(final Long blumNumber, final Integer length, final Long randomNumber) {
        return getDateString() + "_length-" + length + "_blumNumber-" + blumNumber + "_randomNumber-" + randomNumber + ".txt";
    }

    private String getDateString(){
        return java.time.LocalDate.now() + "_" + java.time.LocalTime.now();
    }
}
