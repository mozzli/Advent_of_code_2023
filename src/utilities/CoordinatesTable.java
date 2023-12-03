package utilities;

import java.util.ArrayList;

public class CoordinatesTable {
    private ArrayList<Coordinates> coordinatesList = new ArrayList<>();
    private final int lowXBound, lowYBound, highXBound, highYBound;

    public CoordinatesTable(int xBound, int yBound){
        lowXBound = 1;
        lowYBound = 1;
        highXBound = xBound;
        highYBound = yBound;
    }

    public boolean outOfBounds(int x, int y){
        if (x < lowXBound || x > highXBound) return true;
        return (y < lowYBound || y > highYBound);
    }

    public Coordinates getCoordinatesContainer(int x, int y){
        for (Coordinates coordinates: coordinatesList) {
            if (coordinates.getX() == x && coordinates.getY() == y){
                return coordinates;
            }
        }
        throw new RuntimeException(" There is no point with coordinates [" + x + ", " + y + "]");
    }

    public void addCoordinatesContainer(Coordinates coordinates){
        coordinatesList.add(coordinates);
    }

    public ArrayList<Coordinates> getCoordinatesList(){
        return coordinatesList;
    }
}
