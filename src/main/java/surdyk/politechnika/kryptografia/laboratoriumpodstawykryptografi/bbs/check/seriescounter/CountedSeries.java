package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.bbs.check.seriescounter;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class CountedSeries {
    private final Map<Integer, List<Integer>> seriesCounter = new HashMap<>();


    public void saveSeries(final boolean value, final Integer seriesLength){

        List<Integer> seriesLengthCount = seriesCounter.get(seriesLength);

        if (seriesLengthCount == null){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(0);
            list.add(0);
            list.set(getIndex(value), 1);
            seriesCounter.put(seriesLength, list);
        } else {
            List<Integer> list = seriesCounter.get(seriesLength);
            list.set(getIndex(value), list.get(getIndex(value)) + 1);
            seriesCounter.put(seriesLength, list);
        }
    }

    public Integer getSeries(final Integer seriesLength, final boolean value) {
        List<Integer> series = seriesCounter.get(seriesLength);
        if (series == null){
            return 0;
        }
        return series.get(getIndex(value));
    }

    int getIndex(final boolean value){
        return value ? 1 : 0;
    }
}
