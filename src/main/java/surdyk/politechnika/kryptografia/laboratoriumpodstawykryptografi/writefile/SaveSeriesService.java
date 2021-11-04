package surdyk.politechnika.kryptografia.laboratoriumpodstawykryptografi.writefile;

import java.util.List;

public interface SaveSeriesService {
    public void saveLocally(final Long blumNumber, final Integer length, final Long randomNumber, final List<Boolean> series);
    }
