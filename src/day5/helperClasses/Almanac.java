package day5.helperClasses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Almanac {

    ArrayList<Seed> seeds = new ArrayList<>();
    HashMap<Integer, ArrayList<Long>> ranges = new HashMap<>();
    ArrayList<ArrayList<Long>> soil = new ArrayList<>();
    ArrayList<ArrayList<Long>> fertilizer = new ArrayList<>();
    ArrayList<ArrayList<Long>> water = new ArrayList<>();
    ArrayList<ArrayList<Long>> light = new ArrayList<>();
    ArrayList<ArrayList<Long>> temperature = new ArrayList<>();
    ArrayList<ArrayList<Long>> humidity = new ArrayList<>();
    ArrayList<ArrayList<Long>> location = new ArrayList<>();

    public Almanac(ArrayList<Long> seeds) {
        for (long seed : seeds) {
            this.seeds.add(new Seed(seed));
        }
        ranges.put(1,new ArrayList<>(Arrays.asList(null,null)));
        ranges.put(2,new ArrayList<>(Arrays.asList(null,null)));
        ranges.put(3,new ArrayList<>(Arrays.asList(null,null)));
        ranges.put(4,new ArrayList<>(Arrays.asList(null,null)));
        ranges.put(5,new ArrayList<>(Arrays.asList(null,null)));
        ranges.put(6,new ArrayList<>(Arrays.asList(null,null)));
        ranges.put(7,new ArrayList<>(Arrays.asList(null,null)));

    }

    public void mapSeed(ArrayList<ArrayList<Long>> map) {
        for (Seed seed : seeds) {
            getSeedValue(seed, map);
        }
    }

    public void getSeedValue(Seed seed, ArrayList<ArrayList<Long>> maps) {
        long value = seed.value;
        for (ArrayList<Long> map : maps) {
            if (value >= map.get(1) && value < map.get(1) + map.get(2)) {
                seed.value += (map.get(0) - map.get(1));
                break;
            }
        }
    }

    public long getSeedLocation(Seed seed) {
        if (!(seed.value < ranges.get(1).get(0)) || !(seed.value > ranges.get(1).get(1)))getSeedValue(seed, getSoil());
        if (!(seed.value < ranges.get(2).get(0)) || !(seed.value > ranges.get(2).get(1)))getSeedValue(seed, getFertilizer());
        if (!(seed.value < ranges.get(3).get(0)) || !(seed.value > ranges.get(3).get(1)))getSeedValue(seed, getWater());
        if (!(seed.value < ranges.get(4).get(0)) || !(seed.value > ranges.get(4).get(1)))getSeedValue(seed, getLight());
        if (!(seed.value < ranges.get(5).get(0)) || !(seed.value > ranges.get(5).get(1)))getSeedValue(seed, getTemperature());
        if (!(seed.value < ranges.get(6).get(0)) || !(seed.value > ranges.get(6).get(1)))getSeedValue(seed, getHumidity());
        if (!(seed.value < ranges.get(7).get(0)) || !(seed.value > ranges.get(7).get(1)))getSeedValue(seed, getLocation());
        return seed.value;
    }

    public void setRanges(ArrayList<Long> line, int map){
        if (ranges.get(map).get(0) == null || ranges.get(map).get(0) > line.get(1)) ranges.get(map).set(0,line.get(1));
        if (ranges.get(map).get(1) == null ||ranges.get(map).get(1) < (line.get(1) + line.get(2)) -1) ranges.get(map).set(1,(line.get(1) + line.get(2)) -1);
    }

    public void addSoil(ArrayList<Long> line) {
        soil.add(line);
        setRanges(line,1);
    }

    public void addFertilizer(ArrayList<Long> line) {
        fertilizer.add(line);
        setRanges(line,2);
    }

    public void addWater(ArrayList<Long> line) {
        water.add(line);
        setRanges(line,3);
    }

    public void addLight(ArrayList<Long> line) {
        light.add(line);
        setRanges(line,4);
    }

    public void addTemperature(ArrayList<Long> line) {
        temperature.add(line);
        setRanges(line,5);
    }

    public void addHumidity(ArrayList<Long> line) {
        humidity.add(line);
        setRanges(line,6);
    }

    public void addLocation(ArrayList<Long> line) {
        location.add(line);
        setRanges(line,7);
    }

    public ArrayList<Seed> getSeeds() {
        return seeds;
    }

    public ArrayList<ArrayList<Long>> getSoil() {
        return soil;
    }

    public ArrayList<ArrayList<Long>> getFertilizer() {
        return fertilizer;
    }

    public ArrayList<ArrayList<Long>> getWater() {
        return water;
    }

    public ArrayList<ArrayList<Long>> getLight() {
        return light;
    }

    public ArrayList<ArrayList<Long>> getTemperature() {
        return temperature;
    }

    public ArrayList<ArrayList<Long>> getHumidity() {
        return humidity;
    }

    public ArrayList<ArrayList<Long>> getLocation() {
        return location;
    }
}
