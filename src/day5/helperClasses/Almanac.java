package day5.helperClasses;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Almanac {

    ArrayList<Seed> seeds = new ArrayList<>();
    Set<Long> everySeed = new HashSet<>();
    ArrayList<ArrayList<Long>> soil = new ArrayList<>();
    ArrayList<ArrayList<Long>> fertilizer = new ArrayList<>();
    ArrayList<ArrayList<Long>> water = new ArrayList<>();
    ArrayList<ArrayList<Long>> light = new ArrayList<>();
    ArrayList<ArrayList<Long>> temperature = new ArrayList<>();
    ArrayList<ArrayList<Long>> humidity = new ArrayList<>();
    ArrayList<ArrayList<Long>> location = new ArrayList<>();

    public Almanac(ArrayList<Long> seeds){
        for (long seed: seeds) {
            this.seeds.add(new Seed(seed));
        }
    }

    public void mapSeed(ArrayList<ArrayList<Long>> map){
        for (Seed seed: seeds) {
            getSeedValue(seed, map);
        }
    }

    public void getSeedValue(Seed seed, ArrayList<ArrayList<Long>> maps){
        long value = seed.value;
        for (ArrayList<Long> map: maps) {
            if (value >= map.get(1) && value < map.get(1) + map.get(2)){
                seed.value += (map.get(0) - map.get(1));
            }
        }
    }

    public long getSeedLocation(Seed seed){
        getSeedValue(seed, getSoil());
        getSeedValue(seed, getFertilizer());
        getSeedValue(seed, getWater());
        getSeedValue(seed, getLight());
        getSeedValue(seed, getTemperature());
        getSeedValue(seed, getHumidity());
        getSeedValue(seed, getLocation());
        return seed.value;
    }

    public void addSoil(ArrayList<Long> line){ soil.add(line);}
    public void addFertilizer(ArrayList<Long> line){ fertilizer.add(line);}
    public void addWater(ArrayList<Long> line){ water.add(line);}
    public void addLight(ArrayList<Long> line){ light.add(line);}
    public void addTemperature(ArrayList<Long> line){ temperature.add(line);}
    public void addHumidity(ArrayList<Long> line){ humidity.add(line);}
    public void addLocation(ArrayList<Long> line){ location.add(line);}

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
