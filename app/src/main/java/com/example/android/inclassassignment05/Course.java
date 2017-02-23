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

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}