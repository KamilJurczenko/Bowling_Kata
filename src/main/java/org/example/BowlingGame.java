package org.example;

// plays a game (line)
// each has ten frames (turns)
// each frame has two tries to knock down all pins
// if failed to knock down all -> score = total num of pins for this frame
// if first try all pins -> strike, score = 10 + next frame additionally
// if second try all pins -> spare, score = 10 + next roll
// if spare/strike on tenth frame -> additional throw
//-----------------------------------
// We will not check for valid rolls.
// We will not check for correct number of rolls and frames.
// We will not provide scores for intermediate frames!
public class BowlingGame {

    // Int List for memorizing spares/strike frames and total score
    public Frame frames[];
    private int frameCount;

    private int rolls[];
    private int rollCount;

    private int bonusRolls[];
    private int bonusRollsCount;

    public BowlingGame() {
        frameCount = 0;
        bonusRollsCount = 0;
        rollCount = 0;
        rolls = new int[21];
        bonusRolls = new int[2];
        frames = new Frame[10];
    }

    // collects raw score
    public void roll(int numPins){
        rolls[rollCount] = numPins;
        rollCount++;
    }

    // game score = total score of all frames
    public int getScore(){
        int score = 0;
        for(int i = 0; i < frames.length; i++){
            score += frames[i].getScore();
        }
        return score;
    }

}
