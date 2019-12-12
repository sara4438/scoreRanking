package com.example.sara1126.item;


import com.example.sara1126.commonrecycler.BaseModel;

public class Student implements BaseModel {
    private String name;
    private int mathScore;
    private int engScore;
    private int seat;
    public static String TYPE = "STUDENT";

    public Student (String name, int seat, int engScore){
        this.name = name;
        this.seat= seat;
        this.mathScore = mathScore;
        this.engScore = engScore;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    @Override
    public String getType() {
        return TYPE;
    }

    @Override
    public String getCatName() {
        return null;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public int getMathScore() {
        return mathScore;
    }

    public void setMathScore(int mathScore) {
        this.mathScore = mathScore;
    }

    public int getEngScore() {
        return engScore;
    }

    public void setEngScore(int engScore) {
        this.engScore = engScore;
    }


}

