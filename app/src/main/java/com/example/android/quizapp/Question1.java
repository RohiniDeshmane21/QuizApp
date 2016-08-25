package com.example.android.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Question1 extends AppCompatActivity {
    Button next,previous;
    RadioButton option1,option2,option3,option4;
    int score =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);

        next = (Button)findViewById(R.id.Next);
        previous = (Button)findViewById(R.id.previous);
        option1 = (RadioButton)findViewById(R.id.option1);
        option2 = (RadioButton)findViewById(R.id.option2);
        option3 = (RadioButton)findViewById(R.id.option3);
        option4 = (RadioButton)findViewById(R.id.option4);

        final int optionFlag = 0;

        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(radioGroup.getCheckedRadioButtonId() == R.id.option1)
                {
                    score++;
                    Toast.makeText(getApplicationContext(), "Correct Answer", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Wrong Answer", Toast.LENGTH_SHORT).show();
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(Question1.this,Question2.class);
                //Create the bundle
                Bundle bundle = new Bundle();

                //Add your data to bundle
                bundle.putInt("score",score);

                //Add the bundle to the intent
                nextScreen.putExtras(bundle);
                startActivity(nextScreen);
            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent previousScreen = new Intent(Question1.this, MainActivity.class);
                startActivity(previousScreen);
            }
        });

    }
}
