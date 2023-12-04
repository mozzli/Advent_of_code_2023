package day4;

import utilities.CoordinatesTable;

import java.util.ArrayList;

class Solution {

    public Solution(ArrayList<Card> input) {
        System.out.println("Solution to the first task is: " + getSolution1(input));
        System.out.println("Solution to the second task is: " + getSolution2(input));
    }

    private int getSolution1(ArrayList<Card> input){
        int sum = 0;
        for (Card card: input){
            sum += card.getPoints();
        }
        return sum;
    }

    private int getSolution2(ArrayList<Card> input){
        int scratchCards = 0;
        for (int i= 0; i != input.size(); i++){
            scratchCards += input.get(i).getAmount();
            for (int j = 1; j<= input.get(i).getWins(); j++){
                if (i+j < input.size()){
                    input.get(i+j).addAmount(input.get(i).getAmount());
                } else scratchCards += input.get(i).getWins();
            }
        }
        return scratchCards;
    }
}
