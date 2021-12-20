package com.bridgelabz.gambler;

public class Gambler {

    public static final int INITIAL_STAKE = 100;
    public static final int BET_STAKE = 1;
    public static int finalSakeForDay, initialStakeForDay, LOWER_AMOUNT,
            UPPER_AMOUNT, winCountOfMonth, loseCountOfMonth;
    
    public static int makeBet() {

        int WIN = 1;
        int random = (int) (Math.random() * 2);

        if (random == WIN)
            initialStakeForDay++;
        else
            initialStakeForDay--;

        return initialStakeForDay;
    }

    public static int resignationForDay() {

        LOWER_AMOUNT = INITIAL_STAKE - INITIAL_STAKE / 2;
        UPPER_AMOUNT = INITIAL_STAKE + INITIAL_STAKE / 2;
        initialStakeForDay = 100;
        boolean run = true;

        while (run) {

            makeBet();
            if (initialStakeForDay <= LOWER_AMOUNT)
                run = false;
            if (initialStakeForDay >= UPPER_AMOUNT)
                run = false;
        }
        finalSakeForDay = initialStakeForDay;
        return finalSakeForDay;
    }

    public static int stakeAfterMonth() {

        int finalSakeAfterDay20 = 0;
        int profitOrloss;

        for (int i = 1; i <= 30; i++) {

            System.out.println("Day: " + i);
            resignationForDay();

            if (finalSakeForDay == LOWER_AMOUNT) {
                System.out.println("Lose for day");
                loseCountOfMonth++;
            } else if (finalSakeForDay == UPPER_AMOUNT) {
                System.out.println("Win for day");
                winCountOfMonth++;
            }
            finalSakeAfterDay20 += finalSakeForDay;
        }

        System.out.println("Total WINS in a month: " + winCountOfMonth + "\n"
                + "Total LOSES in a month: " + loseCountOfMonth);

        profitOrloss = finalSakeAfterDay20 - INITIAL_STAKE * 30;
        return profitOrloss;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Gambling Problem");

        System.out.println("Profit or loss after a month(30 days): " + stakeAfterMonth());
    }
}