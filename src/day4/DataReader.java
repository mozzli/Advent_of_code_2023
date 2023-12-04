package day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class DataReader {
    public static ArrayList<String> getInput() throws IOException {
        String line;
        ArrayList<String> listOfCommands = new ArrayList<>();
        BufferedReader text = new BufferedReader(new FileReader("src/day4/input/input.txt"));
        while ((line = text.readLine()) != null) listOfCommands.add(line);
        return listOfCommands;
    }

    public static ArrayList<Card> getCards(ArrayList<String> list) {
        ArrayList<Card> cardList = new ArrayList<>();
        Pattern pattern = Pattern.compile("([0-99]+:)([\\d+\\s]+).([\\d+\\s]+)");
        for (String row : list) {
            ArrayList<Integer> winningNumbers = new ArrayList<>();
            ArrayList<Integer> playerNumbers = new ArrayList<>();
            Matcher matcher = pattern.matcher(row);
            while (matcher.find()) {
                winningNumbers.addAll(getNumbersFromString(matcher.group(2)));
                playerNumbers.addAll(getNumbersFromString(matcher.group(3)));
                cardList.add(new Card(winningNumbers, playerNumbers));
            }
        }
        return cardList;
    }

    public static ArrayList<Integer> getNumbersFromString(String input) {
        ArrayList<Integer> numberList = new ArrayList<>();
        Pattern pattern = Pattern.compile("[\\d]+");
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) numberList.add(Integer.parseInt(matcher.group()));
        return numberList;
    }
}
