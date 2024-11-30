package day5;

import day5.helperClasses.Almanac;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class DataReader {
    public static ArrayList<String> getInput() throws IOException {
        String line;
        ArrayList<String> listOfCommands = new ArrayList<>();
        BufferedReader text = new BufferedReader(new FileReader("src/day5/input/input.txt"));
        while ((line = text.readLine()) != null) listOfCommands.add(line);
        return listOfCommands;
    }

    public static Almanac getProcess(ArrayList<String> list) {
        Almanac almanac = null;
        Pattern pattern = Pattern.compile("[\\d]+");
        int mapNo = 0;
        for (String row : list) {
            Matcher matcher = pattern.matcher(row);
            if (almanac == null) {
                ArrayList<Long> seeds = new ArrayList<>();
                while (matcher.find()) {
                    seeds.add(Long.parseLong(matcher.group()));
                }
                almanac = new Almanac(seeds);
            } else {
                if (row.isEmpty()) mapNo++;
                else if (!row.contains("map")) {
                    ArrayList<Long> newLine = new ArrayList<>();
                    while (matcher.find()) {
                        newLine.add(Long.parseLong(matcher.group()));
                    }
                    switch (mapNo) {
                        case 1 -> almanac.addSoil(newLine);
                        case 2 -> almanac.addFertilizer(newLine);
                        case 3 -> almanac.addWater(newLine);
                        case 4 -> almanac.addLight(newLine);
                        case 5 -> almanac.addTemperature(newLine);
                        case 6 -> almanac.addHumidity(newLine);
                        case 7 -> almanac.addLocation(newLine);
                        default -> throw new RuntimeException("Wrong mapping");
                    }
                }
            }
        }
        return almanac;
    }
}
