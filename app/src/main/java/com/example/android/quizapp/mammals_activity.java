package com.example.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class mammals_activity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mammals_activity);
    }

    public void final_score(View view) {

        int score=0;
        LinearLayout diploma = findViewById(R.id.diploma);
        TextView first_task = findViewById(R.id.diploma_first_task);
        TextView second_task = findViewById(R.id.diploma_second_task);
        TextView third_task = findViewById(R.id.diploma_third_task);
        TextView fourth_task = findViewById(R.id.diploma_fourth_task);
        TextView punctation = findViewById(R.id.diploma_punctation);
        RadioButton corect_answer_task1 = findViewById(R.id.rb1);


        if(corect_answer_task1.isChecked()){
            first_task.setText(R.string.diploma_task1_correct);
            score++;
        }else{
            first_task.setText(R.string.diploma_task1_incorrect);
        }

        EditText mouse_editText = findViewById(R.id.mouse_editText);
        String editText_check = mouse_editText.getText().toString();


        if(TextUtils.isEmpty(editText_check)){
            second_task.setText(R.string.diploma_empty_editText);
        }else if(editText_check.equals("mouse")){
            second_task.setText(R.string.diploma_task2_correct);
            score++;
        }else{
            second_task.setText(R.string.diploma_task2_incorrect);
        }

        CheckBox grain = findViewById(R.id.checkbox_grains);
        CheckBox wege = findViewById(R.id.checkbox_wege);
        CheckBox candy = findViewById(R.id.checkbox_candy);
        CheckBox meat = findViewById(R.id.checkbox_meat);

        Boolean grain_wege = grain.isChecked() && wege.isChecked();
        Boolean candy_meat = candy.isChecked() || meat.isChecked();

        if(grain_wege && candy_meat) {
            third_task.setText(R.string.diploma_task3_toomany);
        }else if(grain_wege){
            third_task.setText(R.string.diploma_task3_correct);
            score++;
        }else if(grain.isChecked() || wege.isChecked()){
            third_task.setText(R.string.diploma_task3_almost);
        }else{
            third_task.setText(R.string.diploma_task3_incorrect);
        }


        RadioButton radioButton = findViewById(R.id.radioButton4);

        if (radioButton.isChecked()){
            fourth_task.setText(R.string.task4_correct);
            score++;
        }else{
            fourth_task.setText(R.string.task4_incorrect);
        }


        String scor = String.valueOf(score) + "/4";
        punctation.setText(scor);
        diploma.setVisibility(View.VISIBLE);
    }

    public void menu(View view) {
        Intent moveToMenu = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(moveToMenu);
    }



    public void tryAgein(View view) {

        LinearLayout diploma = findViewById(R.id.diploma);
        diploma.setVisibility(View.INVISIBLE);
        ScrollView mScrollView = findViewById(R.id.mScrollView);
        mScrollView.scrollTo(0,0);

    }

}

