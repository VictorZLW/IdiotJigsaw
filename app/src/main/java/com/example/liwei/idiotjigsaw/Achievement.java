package com.example.liwei.idiotjigsaw;

/**
 * Created by HCQIN on 2016/10/20.
 */
public class Achievement {
    private int score;
    private String datetime;

    public Achievement(int score,String datetime){
        this.datetime = datetime;
        this.score = score;
    }
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }
}
