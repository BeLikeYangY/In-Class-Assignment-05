package com.example.android.inclassassignment05;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    private String displayMessage = "";
    private double credit;
    private double score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        ArrayList<Course> courses = (ArrayList<Course>) intent.getSerializableExtra("CourseList");


        ScrollView displayView = (ScrollView) findViewById(R.id.displayView);


        for(int i = 0; i < courses.size(); i++){
            String n = courses.get(i).toString();
            displayMessage = displayMessage + n +'\n'+'\n';
        }

        TextView tv = new TextView(this);
        tv.setText(displayMessage);
        tv.setTextSize(30);
        displayView.addView(tv);

        for(int i = 0; i < courses.size(); i++){
            double a = courses.get(i).getCredit();
            credit += a;

            double b = courses.get(i).getScore();
            score += a*b;
        }

        double gpa = score/credit;

        TextView finalScore = (TextView)findViewById(R.id.result);
        finalScore.setText("Your GPA is:" + gpa);

    }
}
