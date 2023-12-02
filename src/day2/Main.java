package day2;

import java.io.IOException;

import static day2.DataReader.getInput;
import static day2.DataReader.getListOfGames;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution(getListOfGames(getInput()));
    }
}
