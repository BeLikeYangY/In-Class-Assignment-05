package com.example.android.inclassassignment05;

import android.content.Intent;
import android.preference.EditTextPreference;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Course> cList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String key = getString(R.string.saved_username);

        SharedPreferences sharedPreference = getPreferences(MODE_PRIVATE);
        String username = sharedPreference.getString(key, getString(R.string.saved_username));

        TextView usernameDisplay = (TextView) findViewById(R.id.username);
        usernameDisplay.setText("Welcome, " + username + "!");
    }

    public void changeUsername(View view) {
        EditText setUsername = (EditText) findViewById(R.id.setUsername);
        String newUsername = setUsername.getText().toString();
        SharedPreferences sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(getString(R.string.saved_username), newUsername);
        editor.commit();

        setUsername.setText("");

        TextView usernameDisplay = (TextView) findViewById(R.id.username);
        usernameDisplay.setText("Welcome, " + newUsername + "!");


    }

    public void SaveInput(View view) {

        EditText course = (EditText) findViewById(R.id.course);
        String name = course.getText().toString();

        EditText credit = (EditText) findViewById(R.id.credit);
        double credits = Double.parseDouble(credit.getText().toString());

        EditText score = (EditText) findViewById(R.id.score);
        double scores = Double.parseDouble(score.getText().toString());

        Course c = new Course(name, credits, scores);
        cList.add(c);
        course.setText("");
        credit.setText("");
        score.setText("");

        Toast t = Toast.makeText(this, "Saved", Toast.LENGTH_SHORT);
        t.show();

    }

    public void displayResult(View view) {

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("CourseList", cList);
        startActivity(intent);
    }
}
