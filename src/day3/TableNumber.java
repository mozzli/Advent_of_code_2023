package day3;

import utilities.Coordinates;
import utilities.CoordinatesTable;

import java.util.ArrayList;

class TableNumber {
    int value, length;
    ArrayList<Coordinates> coordinates = new ArrayList<>();
    CoordinatesTable table;
    Coordinates gear;

    public TableNumber(Coordinates coordinates, CoordinatesTable table) {
        this.table = table;
        createNumber(coordinates);
    }

    private void createNumber(Coordinates coor) {
        coordinates.add(coor);
        StringBuilder number = new StringBuilder();
        number.append(coor.getValue());
        for (int i = 1; ; i++) {
            Coordinates newContainer;
            if (!table.outOfBounds(coor.getX(), coor.getY() + i)) {
                newContainer = table.getCoordinatesContainer(coor.getX(), coor.getY() + i);
            } else break;
            if (newContainer.getValue() >= '0' && newContainer.getValue() <= '9') {
                number.append(newContainer.getValue());
                coordinates.add(newContainer);
            } else break;
        }
        value = Integer.parseInt(String.valueOf(number));
        length = number.length();
    }

    public boolean hasSymbol() {
        if (checkForSymbolLeft(coordinates.get(0))) return true;
        if (checkForSymbolDiagonally(coordinates.get(0))) return true;
        if (checkForSymbolRight(coordinates.get(coordinates.size() - 1))) return true;
        if (checkForSymbolDiagonally(coordinates.get(coordinates.size() - 1))) return true;
        for (Coordinates coor : coordinates) {
            if (checkForSymbolUpDown(coor)) return true;
        }
        return false;
    }

    private boolean checkForSymbolUpDown(Coordinates coordinates) {
        if (checkPoint(coordinates.getX() - 1, coordinates.getY())) return true;
        if (checkPoint(coordinates.getX() + 1, coordinates.getY())) return true;
        return false;
    }

    private boolean checkForSymbolDiagonally(Coordinates coordinates) {
        if (checkPoint(coordinates.getX() - 1, coordinates.getY() - 1)) return true;
        if (checkPoint(coordinates.getX() - 1, coordinates.getY() + 1)) return true;
        if (checkPoint(coordinates.getX() + 1, coordinates.getY() - 1)) return true;
        if (checkPoint(coordinates.getX() + 1, coordinates.getY() + 1)) return true;
        return false;
    }

    private boolean checkForSymbolLeft(Coordinates coordinates) {
        return checkPoint(coordinates.getX(), coordinates.getY() - 1);
    }

    private boolean checkForSymbolRight(Coordinates coordinates) {
        return checkPoint(coordinates.getX(), coordinates.getY() + 1);
    }

    private boolean checkPoint(int x, int y) {
        return !table.outOfBounds(x, y) && isSymbol(table.getCoordinatesContainer(x, y).getValue(), table.getCoordinatesContainer(x, y));
    }

    private boolean isSymbol(char character, Coordinates coor) {
        if (!(character >= '0' && character <= '9' || character == '.')) {
            if (character == '*') gear = coor;
            return true;
        }
        return false;
    }

    public int checkForOtherGear(TableNumber secondNumber) {
        if (secondNumber != this && gear == secondNumber.gear) {
            int result = value * secondNumber.value;
            secondNumber.gear = null;
            return result;
        }
        return 0;
    }

    public ArrayList<Coordinates> getCoordinateList() {
        return coordinates;
    }
}