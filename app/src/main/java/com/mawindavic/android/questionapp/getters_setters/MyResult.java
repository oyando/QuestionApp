package com.mawindavic.android.questionapp.getters_setters;

/**
 * Created by Mawinda on 28-Feb-18.
 */

public class MyResult {
    private String yourAnswer,correctAnswer;
    private boolean youAreRight;

    public String getYourAnswer() {
        return yourAnswer;
    }

    public MyResult() {
    }

    public void setYourAnswer(String yourAnswer) {
        this.yourAnswer = yourAnswer;

    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public boolean isYouAreRight() {
        return youAreRight;
    }

    public void setYouAreRight(boolean youAreRight) {
        this.youAreRight = youAreRight;
    }
}
