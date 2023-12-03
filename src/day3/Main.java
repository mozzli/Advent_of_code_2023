package day3;

import java.io.IOException;

import static day3.DataReader.getEngineSchematics;
import static day3.DataReader.getInput;

public class Main {
    public static void main(String[] arg) throws IOException {
        new Solution(getEngineSchematics(getInput()));
    }
}
