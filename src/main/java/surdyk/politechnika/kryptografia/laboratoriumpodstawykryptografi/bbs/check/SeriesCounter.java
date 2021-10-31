package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.bbs.check;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeriesCounter {

    public CountedSeries count(final List<Boolean> input) {
        CountedSeries countedSeries = new CountedSeries();
        Boolean seriesValue = null;
        int seriesLength = 0;
        for (int i = 0; i < input.size(); i++) {
            boolean currentValue = input.get(i);
            if (seriesValue == null) {
                seriesValue = currentValue;
                seriesLength = 1;
            } else {
                if (currentValue == seriesValue) {
                    seriesLength++;
                } else {
                    countedSeries.saveSeries(seriesValue, seriesLength);
                    seriesValue = currentValue;
                    seriesLength = 1;
                }
            }

            if (i == input.size() - 1) {
                if (seriesLength != 0) {
                    countedSeries.saveSeries(currentValue, seriesLength);
                }
            }
        }
        return countedSeries;
    }
}
