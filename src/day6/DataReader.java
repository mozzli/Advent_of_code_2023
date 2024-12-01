package day6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class DataReader {
    public static ArrayList<RaceData> getInput() throws IOException {
        String line;
        ArrayList<String> lines = new ArrayList<>();
        ArrayList<RaceData> raceData = new ArrayList<>();
        BufferedReader text = new BufferedReader(new FileReader("src/day6/input/input.txt"));
        while ((line = text.readLine()) != null) lines.add(line);
        Pattern pattern = Pattern.compile("([10-99]+)");
        ArrayList<Long> time = new ArrayList<>();
        ArrayList<Long> distance = new ArrayList<>();
        Matcher matcher = pattern.matcher(lines.get(0));
        while (matcher.find()) {
            time.add(Long.valueOf(matcher.group()));
        }
        matcher = pattern.matcher(lines.get(1));
        while (matcher.find()) {
            distance.add(Long.valueOf(matcher.group()));
        }
        for (long i = 0; i < time.size(); i++) {
            raceData.add(new RaceData(time.get((int) i), distance.get((int) i)));
        }
        return raceData;
    }

    public static RaceData getInput2() throws IOException {
        String line;
        ArrayList<String> lines = new ArrayList<>();
        ArrayList<RaceData> raceData = new ArrayList<>();
        BufferedReader text = new BufferedReader(new FileReader("src/day6/input/input.txt"));
        while ((line = text.readLine()) != null) lines.add(line);
        Pattern pattern = Pattern.compile("([10-99]+)");
        Matcher matcher = pattern.matcher(lines.get(0));
        StringBuilder time = new StringBuilder();
        StringBuilder distance = new StringBuilder();
        while (matcher.find()) {
            time.append(matcher.group());
        }
        matcher = pattern.matcher(lines.get(1));
        while (matcher.find()) {
            distance.append(matcher.group());
        }
        return new RaceData(Long.parseLong(time.toString()), Long.parseLong(distance.toString()));
    }
}
