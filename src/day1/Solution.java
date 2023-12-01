package day1;

import java.util.ArrayList;

import static utilities.Utilities.checkIfCharacterIsInt;
import static utilities.Utilities.sumIntInArrayList;

class Solution {

    public Solution(ArrayList<String> input) {
        System.out.println("Solution to the first task is: " + getSolution1(input));
        System.out.println("Solution to the second task is: " + getSolution2(input));
    }

    public int getSolution1(ArrayList<String> input) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (String line : input) {
            numbers.add(getValueNumber(line));
        }
        return sumIntInArrayList(numbers);
    }

    public int getSolution2(ArrayList<String> input) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (String line : input) {
            numbers.add(getValueNumbersFromString(line));
        }
        return sumIntInArrayList(numbers);
    }

    private int getValueNumber(String line) {
        String firstNumber = null;
        String lastNumber = null;
        for (Character character : line.toCharArray()) {
            if (firstNumber == null && checkIfCharacterIsInt(character)) {
                firstNumber = String.valueOf(character);
            } else if (checkIfCharacterIsInt(character)) {
                lastNumber = String.valueOf(character);
            }
        }
        if (lastNumber == null) lastNumber = firstNumber;
        return Integer.parseInt(firstNumber + lastNumber);
    }

    public int getValueNumbersFromString(String line) {
        String finalLine;
        finalLine = line.replace("one", "o1e")
                .replace("two", "t2o")
                .replace("three", "t3e")
                .replace("four", "f4r")
                .replace("five", "f5e")
                .replace("six", "s6x")
                .replace("seven", "s7n")
                .replace("eight", "e8t")
                .replace("nine", "n9e");
        return (getValueNumber(finalLine));
    }
}
