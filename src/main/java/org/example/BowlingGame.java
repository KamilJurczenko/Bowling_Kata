package org.example;

import org.example.Frame.*;

// plays a game (line)
// each has ten frames (turns)
// each frame has two tries to knock down all pins
// if failed to knock down all -> score = total num of pins for this frame
// if first try all pins -> strike, score = 10 + next frame additionally
// if second try all pins -> spare, score = 10 + next roll
// if spare/strike on tenth frame -> additional throw
//-----------------------------------
// We will not check for correct number of rolls and frames.
public class BowlingGame {

    // Int List for memorizing spares/strike frames and total score
    // We will not provide scores for intermediate frames.
    public Frame[] frames;
    public static int framesCount;

    public static int[] rolls;
    public static int rollCount;

    public BowlingGame() {
        rollCount = 0;
        framesCount = 0;
        rolls = new int[21];
        frames = new Frame[10];
    }

    // We will not check for valid rolls.
    public void rollSpare(int firstPinNum, int secondPinNum){
        frames[framesCount] = new SpareFrame(firstPinNum, secondPinNum);
    }

    public void rollStrike(){
        frames[framesCount] = new StrikeFrame();
    }

    public void rollDefault(int firstPinNum, int secondPinNum){
        frames[framesCount] = new DefaultFrame(firstPinNum, secondPinNum);
    }

    public void rollBonus(int pinNum){
        frames[framesCount-1].addRoll(pinNum);
    }

    // game score = total score of all frames
    public int getScore(){
        int score = 0;
        for(Frame f : frames){
            f.setScore();
            score += f.getScore();
        }
        return score;
    }

}
