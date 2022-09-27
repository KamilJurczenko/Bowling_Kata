package org.example;

public class Main {
    public static void main(String[] args) {
        int frameCount = 1;
        int bonusRolls = 0;
        BowlingGame bowlingGame = new BowlingGame();
        do{
            if(frameCount > 10){
                if(bonusRolls == 0){
                    System.out.println("|||||||||||||||||||||| Your Score is " + bowlingGame.getScore() + " ||||||||||||||||||||||");
                    break;
                }
            }
            System.out.println("You are at Frame " + frameCount);

            System.out.println("Enter first pin number (0-10):\n");
            int firstRoll = Integer.parseInt(System.console().readLine());
            if(firstRoll < 0 || firstRoll > 10) // invalid input
                continue;

            if(frameCount > 10){
                bowlingGame.rollBonus(firstRoll);
                bonusRolls--;
                if(bonusRolls == 0)
                    continue;
            }
            else if(firstRoll == 10){
                frameCount++;
                bowlingGame.rollStrike();
                if(frameCount <= 10)
                    bonusRolls = 2;
                continue;
            }

            System.out.println("Enter second pin number (0-10):\n");
            int secondRoll = Integer.parseInt(System.console().readLine());
            if(secondRoll < 0 || secondRoll > 10) // invalid input
                continue;

            if(frameCount > 10) {
                bowlingGame.rollBonus(secondRoll);
                bonusRolls--;
            }
            else if(secondRoll + firstRoll == 10){
                bowlingGame.rollSpare(firstRoll, secondRoll);
                bonusRolls = 1;
            }
            else{
                bowlingGame.rollDefault(firstRoll, secondRoll);
                bonusRolls = 0;
            }
            frameCount++;
        }while(true);
    }
}