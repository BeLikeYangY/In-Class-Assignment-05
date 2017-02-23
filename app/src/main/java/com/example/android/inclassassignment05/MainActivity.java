package com.example.android.inclassassignment05;

import android.content.Intent;
import android.preference.EditTextPreference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Course> cList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void SaveInput(View view){

        EditText course = (EditText)findViewById(R.id.course);
        String name = course.getText().toString();

        EditText credit = (EditText)findViewById(R.id.credit);
        double credits = Double.parseDouble(credit.getText().toString());

        EditText score = (EditText)findViewById(R.id.score);
        double scores = Double.parseDouble(score.getText().toString());

        Course c = new Course(name,credits,scores);
        cList.add(c);
        course.setText(null);
        credit.setText(null);
        score.setText(null);

        Toast t = Toast.makeText(this, "Saved", Toast.LENGTH_SHORT);
        t.show();

    }

    public void displayResult(View view){

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("CourseList",cList);
        startActivity(intent);
    }
}
