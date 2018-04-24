package com.example.android.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mammals(View v) {
        Intent moveToMammals = new Intent(this, mammals_activity.class);
        startActivity(moveToMammals);
    }

    public void fish(View v) {
        Intent moveToFish = new Intent(this, fish.class);
        startActivity(moveToFish);
    }

    public void amphibians(View v) {
        Toast.makeText(getBaseContext(), "We're sorry, department under construction", Toast.LENGTH_LONG).show();
    }

    public void reptiles(View v) {
        Toast.makeText(getBaseContext(), "We're sorry, department under construction", Toast.LENGTH_LONG).show();
    }
}
