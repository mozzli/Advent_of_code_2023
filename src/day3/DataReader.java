package day3;

import utilities.Coordinates;
import utilities.CoordinatesTable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class DataReader {
    public static ArrayList<String> getInput() throws IOException {
        String line;
        ArrayList<String> listOfCommands = new ArrayList<>();
        BufferedReader text = new BufferedReader(new FileReader("src/day3/input/input.txt"));
        while ((line = text.readLine()) != null) listOfCommands.add(line);
        return listOfCommands;
    }

    public static CoordinatesTable getEngineSchematics(ArrayList<String> list) {
        CoordinatesTable engineSchematics = new CoordinatesTable(list.size(), list.get(0).length());
        int lineNumber = 1;
        for (String line : list) {
            int columnNumber = 1;
            for (char character : line.toCharArray()) {
                engineSchematics.addCoordinatesContainer(new Coordinates(lineNumber, columnNumber, character));
                columnNumber++;
            }
            lineNumber++;
        }
        return engineSchematics;
    }
}
