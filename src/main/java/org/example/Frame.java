package org.example;

// a frame has two rolls to knock down all pins
public class Frame {

    private int score = 0;
    private String scoreIndicator;

    public Frame() {
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}
