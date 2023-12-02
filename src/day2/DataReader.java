package day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class DataReader {
    public static ArrayList<String> getInput() throws IOException {
        BufferedReader text = new BufferedReader(new FileReader("src/day2/input/input.txt"));
        ArrayList<String> listOfCommands = new ArrayList<>();
        String line;
        while ((line = text.readLine()) != null) listOfCommands.add(line);
        return listOfCommands;
    }

    public static ArrayList<ArrayList<String>> getListOfGames(ArrayList<String> list) {
        ArrayList<ArrayList<String>> listOfGameValues = new ArrayList<>();
        Pattern pattern = Pattern.compile("[0-99]+ \\w+");
        for (String row : list) {
            ArrayList<String> gameValues = new ArrayList<>();
            Matcher matcher = pattern.matcher(row);
            while (matcher.find()) gameValues.add(matcher.group());
            listOfGameValues.add(gameValues);
        }
        return listOfGameValues;
    }
}
