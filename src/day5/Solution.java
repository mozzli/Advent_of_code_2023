package day5;

import day5.helperClasses.Almanac;
import day5.helperClasses.Seed;

import java.util.ArrayList;

class Solution {

    public Solution(Almanac input, Almanac input2) {
        System.out.println("Solution to the first task is: " + getSolution1(input));
        System.out.println("Solution to the second task is: " + getSolution2(input2));
    }

    public long getSolution1(Almanac almanac) {
        Long lowestLocation = null;
        almanac.mapSeed(almanac.getSoil());
        almanac.mapSeed(almanac.getFertilizer());
        almanac.mapSeed(almanac.getWater());
        almanac.mapSeed(almanac.getLight());
        almanac.mapSeed(almanac.getTemperature());
        almanac.mapSeed(almanac.getHumidity());
        almanac.mapSeed(almanac.getLocation());
        for (Seed seed : almanac.getSeeds()) {
            if (lowestLocation == null) {
                lowestLocation = seed.value;
            } else if (lowestLocation > seed.value) {
                lowestLocation = seed.value;
            }
        }
        return lowestLocation;
    }

    public long getSolution2(Almanac almanac) {
        Long lowestLocation = null;
        ArrayList<Seed> seeds = almanac.getSeeds();
        for (int i = 0; i < seeds.size(); i += 2) {
            System.out.println(i);
            for (long j = 0; j < seeds.get(i+1).value; j++) {
                long seedLocation = almanac.getSeedLocation(new Seed(seeds.get(i).value + j));
                if (lowestLocation == null) {
                    lowestLocation = seedLocation;
                } else if (lowestLocation > seedLocation) {
                    lowestLocation = seedLocation;
                }
            }
        }
        return lowestLocation;
    }
}
