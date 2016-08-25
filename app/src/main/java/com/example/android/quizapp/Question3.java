package com.example.android.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Question3 extends AppCompatActivity {

    Button next,previous;
    int score=0;
    EditText answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);

        next = (Button)findViewById(R.id.Next);
        previous = (Button)findViewById(R.id.previous);

        Bundle bundle = getIntent().getExtras();
        score = bundle.getInt("score");

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer = (EditText)findViewById(R.id.editTextAnswer);
                String ans = answer.getText().toString().trim().toLowerCase();
                if(ans.equals("nazi party"))
                {
                    score++;
                }

                Intent nextScreen = new Intent(Question3.this, Question4.class);
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

                Intent previousScreen = new Intent(Question3.this, Question2.class);
                startActivity(previousScreen);
            }
        });

    }
}
