package utilities;

import java.util.ArrayList;

public class Utilities {

    public static boolean checkIfCharacterIsInt(char character){
        return character >= '0' && character <= '9';
    }

    public static int sumIntInArrayList(ArrayList<Integer> numbers){
        int sum = 0;
        for (int number: numbers){
            sum += number;
        }
        return sum;
    }
}
