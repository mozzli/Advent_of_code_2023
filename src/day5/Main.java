package day5;

import day5.helperClasses.Almanac;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Almanac almanac = DataReader.getProcess(DataReader.getInput());
        Almanac almanac2 = DataReader.getProcess(DataReader.getInput());
//        System.out.println(almanac.getLocation());
        Solution solution = new Solution(almanac, almanac2);
    }
}
