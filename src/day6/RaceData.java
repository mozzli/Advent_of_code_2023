package day6;

public class RaceData {

    long time;
    long distance;

    public RaceData(long time, long distance){
        this.time = time;
        this.distance = distance;
    }

    public long getDistance() {
        return distance;
    }

    public long getTime() {
        return time;
    }
}
