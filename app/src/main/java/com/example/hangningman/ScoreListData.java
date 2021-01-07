package com.example.hangningman;

public class ScoreListData {
    private String score;
    private String word;


    public ScoreListData(String word, String score) {
        this.score = score;
        this.word = word;
    }

    public String getScore() {
        return score;
    }
    public String getWord() {
        return word;
    }
}