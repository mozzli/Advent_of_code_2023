package day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class DataReader {
    public static ArrayList<String> getInput() throws IOException {
        BufferedReader text = new BufferedReader(new FileReader("src/day1/input/input.txt"));
        ArrayList<String> listOfCommands = new ArrayList<>();
        String line;
        while ((line = text.readLine()) != null) {
            listOfCommands.add(line);
        }
        return listOfCommands;
    }
}
