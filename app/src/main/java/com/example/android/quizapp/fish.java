package com.example.android.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class fish extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fish);
    }

    public void final_score(View view) {

        int score = 0;
        ScrollView diploma = findViewById(R.id.scroll_diploma);
        TextView first_task = findViewById(R.id.diploma_first_task);
        TextView second_task = findViewById(R.id.diploma_second_task);
        TextView third_task = findViewById(R.id.diploma_third_task);
        TextView fourth_task = findViewById(R.id.diploma_fourth_task);
        TextView punctation = findViewById(R.id.diploma_punctation);
        RadioButton corect_answer_task1 = findViewById(R.id.rb3);


        if (corect_answer_task1.isChecked()) {
            first_task.setText(R.string.diploma_task1_correct);
            score++;
        } else {
            first_task.setText(R.string.diploma_task1_incorrect);
        }

        EditText mouse_editText = findViewById(R.id.mouse_editText);
        String editText_check = mouse_editText.getText().toString();


        if (TextUtils.isEmpty(editText_check)) {
            second_task.setText(R.string.diploma_empty_editText);
        } else if (editText_check.equals("shark")) {
            second_task.setText(R.string.diploma_task2_correct);
            score++;
        } else {
            second_task.setText(R.string.diploma_task2_incorrect);
        }

        CheckBox grain = findViewById(R.id.checkbox_grains);
        CheckBox wege = findViewById(R.id.checkbox_wege);
        CheckBox candy = findViewById(R.id.checkbox_candy);
        CheckBox meat = findViewById(R.id.checkbox_meat);

        Boolean grain_wege_candy = grain.isChecked() || wege.isChecked() || candy.isChecked();


        if (meat.isChecked() && grain_wege_candy) {
            third_task.setText(R.string.diploma_task3_toomany);
        } else if (meat.isChecked()) {
            third_task.setText(R.string.diploma_task3_correct);
            score++;
        } else {
            third_task.setText(R.string.diploma_task3_incorrect);
        }

        RadioButton radioButton = findViewById(R.id.radioButton2);

        if (radioButton.isChecked()) {
            fourth_task.setText(R.string.task4_correct);
            score++;
        } else {
            fourth_task.setText(R.string.task4_incorrect);
        }

        String scor = String.valueOf(score) + "/4";
        diploma.setVisibility(View.VISIBLE);
        Toast.makeText(getBaseContext(), "You`v got " + scor, Toast.LENGTH_LONG).show();
    }

    public void menu(View view) {
        Intent moveToMenu = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(moveToMenu);
    }


    public void tryAgein(View view) {

        ScrollView diploma = findViewById(R.id.scroll_diploma);
        diploma.setVisibility(View.INVISIBLE);
        ScrollView mScrollView = findViewById(R.id.mScrollView);
        mScrollView.scrollTo(0, 0);

    }

}
