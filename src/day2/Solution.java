package day2;

import day2.enums.Colors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    public Solution(ArrayList<ArrayList<String>> input) {
        System.out.println("Solution to the first task is: " + getSolution1(input));
        System.out.println("Solution to the second task is: " + getSolution2(input));
    }

    private int getSolution1(ArrayList<ArrayList<String>> input) {
        int solution = 0, rowNumber = 1;
        for (ArrayList<String> row : input) {
            if (isGamePossible(row)) solution += rowNumber;
            rowNumber++;
        }
        return solution;
    }

    private int getSolution2(ArrayList<ArrayList<String>> input) {
        int solution = 0;
        for (ArrayList<String> row : input) {
            ArrayList<String> fewestCubeList = getFewestCubeList(row);
            solution += getCubePower(fewestCubeList);
        }
        return solution;
    }

    private boolean isGamePossible(ArrayList<String> row) {
        for (String value : row) {
            int i = Integer.parseInt(value.substring(0, value.indexOf(" ")));
            if (value.contains("green") && i > Colors.GREEN.value) return false;
            else if (value.contains("blue") && i > Colors.BLUE.value) return false;
            else if (value.contains("red") && i > Colors.RED.value) return false;
        }
        return true;
    }

    private ArrayList<String> getFewestCubeList(ArrayList<String> row) {
        ArrayList<String> fewestCubeList = new ArrayList<>();
        int fewestGreen = 0, fewestRed = 0, fewestBlue = 0;
        for (String value : row) {
            int i = Integer.parseInt(value.substring(0, value.indexOf(" ")));
            if (value.contains("green") && fewestGreen < i) fewestGreen = i;
            else if (value.contains("blue") && fewestBlue < i) fewestBlue = i;
            else if (value.contains("red") && fewestRed < i) fewestRed = i;
        }
        Collections.addAll(fewestCubeList, fewestGreen + " green", fewestBlue + " blue", fewestRed + " red");
        return fewestCubeList;
    }

    private int getCubePower(ArrayList<String> list) {
        int solution = 0;
        Pattern pattern = Pattern.compile("[0-99]+");
        for (String row : list) {
            Matcher matcher = pattern.matcher(row);
            while (matcher.find()) {
                int number = Integer.parseInt(matcher.group());
                solution = solution == 0 ? number : solution * number;
            }
        }
        return solution;
    }
}
