package com.example.android.inclassassignment05;
import java.io.Serializable;


public class Course implements Serializable {
    private String courseName;
    private double credit;
    private double score;

    public Course(String courseName, double credit, double score) {
        this.courseName = courseName;
        this.credit = credit;
        this.score = score;
    }


    @Override
    public String toString() {
        return "Course: " + courseName
                +'\n'+ "Credit: " + credit
                +'\n'+ "Score: " + score;
    }

    public double getCredit() {
        return credit;
    }

    public double getScore() {
        return score;
    }
}