package com.bridgelabz.gambler;

public class Gambler {

    public static final int INITIALSTAKE = 100;
    public static final int BET_PER_GAME = 1;

    public static void stakeWinOrLoss() {
        if(Math.random() > 0.5){
            int win = INITIALSTAKE + 1;
            System.out.println("Won the bet :"+win);
        }
        else{
            int loss = INITIALSTAKE -1;
            System.out.println("Lost the bet :"+loss);
        }
    }

    public static void main(String[] args) {
        System.out.println("The Gambler Starts Betting");
        stakeWinOrLoss();
    }

}
