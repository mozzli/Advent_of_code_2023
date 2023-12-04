package day4;

import java.util.ArrayList;

class Card {

    ArrayList<Integer> winningNumbers = new ArrayList<>();
    ArrayList<Integer> playerNumbers = new ArrayList<>();
    private int points = 0, amount = 1, wins = 0;

    public Card(ArrayList<Integer> winningNumbers, ArrayList<Integer> playerNumbers){
        this.playerNumbers = playerNumbers;
        this.winningNumbers = winningNumbers;
        checkForWin();
    }

    public void addPoints(){
        points = points == 0 ? 1 : points*2;
    }

    public void checkForWin(){
        for (int winningNumber : winningNumbers){
            if (playerNumbers.contains(winningNumber)){
                wins++;
                addPoints();
            }
        }
    }

    public int getPoints() { return points;}

    public int getAmount(){ return amount;}

    public int getWins(){ return wins;}

    public void addAmount(int amount){
        this.amount += amount;
    }
}
