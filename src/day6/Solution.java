package day6;

import java.util.ArrayList;

public class Solution {

    public long getMarginOfError(ArrayList<RaceData> raceData) {
        ArrayList<Long> wins = new ArrayList<>();
        for (RaceData data : raceData) {
            wins.add(getWinsAmount(data));
        }
        long result = 1;
        for (long win : wins) {
            result = result * win;
        }
        return result;
    }

    public long getMarginOfError(RaceData raceData) {
        return getWinsAmount(raceData);
    }

    private long getWinsAmount(RaceData data) {
        long time = data.getTime();
        long distance = data.getDistance();
        if (time % 2 == 0) {
            for (long i = 0; ; i++) {
                if (!((time / 2 - i) * (time / 2 + i) > distance)) {
                    return (i * 2) - 1;
                }
            }
        } else {
            for (long i = 1; ; i++) {
                if (!((time / 2 - i) * (time / 2 + i + 1) > distance)) {
                    return (i * 2);
                }
            }
        }
    }
}
