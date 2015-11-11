package com.example.makarov.snakegame.initialized.score;


/**
 * Класс набраных очков в игре
 */
public class ScoreManager {

    private int mScore = 0;

    /**
     * добавление, уменьшение, обнуление и сет методы очков набранные в игре
     */
    public void addScore(int addScore) {
        int newScore = this.mScore + addScore;
        setScore(newScore);
    }

    public void reduceScore(int reduceScore){
        int newScore = this.mScore - reduceScore;
        setScore(newScore);
    }

    public void clearScore(){
        setScore(0);
    }

    private void setScore(int newScore) {
        this.mScore = newScore;
    }

    public int getScore() {
        return this.mScore;
    }

}
