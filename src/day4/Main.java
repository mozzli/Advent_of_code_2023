package day4;

import java.io.IOException;
import java.util.ArrayList;

import static day4.DataReader.getCards;
import static day4.DataReader.getInput;

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution(getCards(getInput()));
    }
}
