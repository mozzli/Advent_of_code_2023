package day6;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        System.out.println("The margin of error for first part of task is: " + solution.getMarginOfError(DataReader.getInput()));
        System.out.println("The margin of error for second part of task is: " + solution.getMarginOfError(DataReader.getInput2()));
    }
}
