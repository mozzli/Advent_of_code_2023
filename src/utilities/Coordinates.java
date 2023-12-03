package utilities;

import java.util.ArrayList;

public class Coordinates {
    private final ArrayList<Integer> coordinates = new ArrayList<>();
    private char value;

    public Coordinates(int x, int y, char value){
        coordinates.add(x);
        coordinates.add(y);
        this.value = value;
    }
    @Override
    public String toString() {
        return "[" + getX() + ", " + getY() + "]";
    }

    public int getX() {return coordinates.get(0);}

    public int getY() {return coordinates.get(1);}

    public char getValue(){return value;}
}
