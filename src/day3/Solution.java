package day3;

import utilities.Coordinates;
import utilities.CoordinatesTable;

import java.util.ArrayList;

class Solution {

    public Solution(CoordinatesTable input) {
        System.out.println("Solution to the first task is: " + getSolution1(input));
        System.out.println("Solution to the second task is: " + getSolution2(input));
    }

    private int getSolution1(CoordinatesTable table) {
        ArrayList<TableNumber> numbers = getNumberList(table);
        int sum = 0;
        for (TableNumber number : numbers) {
            if (number.hasSymbol()) sum += number.value;
        }
        return sum;
    }

    private int getSolution2(CoordinatesTable table) {
        ArrayList<TableNumber> numbers = getNumberList(table);
        ArrayList<TableNumber> gearedNumber = new ArrayList<>();
        int sum = 0;
        for (TableNumber number : numbers) {
            number.hasSymbol();
            if (number.gear != null) gearedNumber.add(number);
        }
        for (TableNumber number : gearedNumber) {
            for (TableNumber number1 : gearedNumber) {
                if (number.gear != null) {
                    int result = number.checkForOtherGear(number1);
                    if (result != 0) {
                        sum += result;
                        break;
                    }
                }
            }
        }
        return sum;
    }

    private ArrayList<TableNumber> getNumberList(CoordinatesTable table){
        ArrayList<TableNumber> numbers = new ArrayList<>();
        ArrayList<Coordinates> usedCoordinates = new ArrayList<>();
        for (Coordinates container : table.getCoordinatesList()) {
            if (container.getValue() >= '0' && container.getValue() <= '9' && !usedCoordinates.contains(container)) {
                TableNumber newNumber = new TableNumber(container, table);
                numbers.add(newNumber);
                usedCoordinates.addAll(newNumber.getCoordinateList());
            }
        }
        return numbers;
    }
}



