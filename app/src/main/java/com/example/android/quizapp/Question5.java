package com.example.android.quizapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class Question5 extends AppCompatActivity {

    CheckBox checkBox1,checkBox2,checkBox3,checkBox4;
    int score=0;
    Button next,previous;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question5);

        Bundle bundle = getIntent().getExtras();
        score = bundle.getInt("score");

        next = (Button)findViewById(R.id.Next);
        previous = (Button)findViewById(R.id.previous);

        checkBox1 = (CheckBox)findViewById(R.id.checkBoxOpt1);
        checkBox2 = (CheckBox)findViewById(R.id.checkBox2Opt2);
        checkBox3 = (CheckBox)findViewById(R.id.checkBox3Opt3);
        checkBox4 = (CheckBox)findViewById(R.id.checkBox4Opt4);

        checkBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox2.isChecked() && checkBox4.isChecked())
                {
                    score++;
                }
            }
        });

        checkBox4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox2.isChecked() && checkBox4.isChecked())
                {
                    score++;
                }
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(Question5.this).create();
                alertDialog.setTitle("Game Completed");
                alertDialog.setMessage("Your Score" + score);
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent nextScreen = new Intent(Question5.this, MainActivity.class);
                                startActivity(nextScreen);
                                //dialog.dismiss();
                            }
                        });
                alertDialog.show();

            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent previousScreen = new Intent(Question5.this, Question4.class);
                startActivity(previousScreen);
            }
        });
    }
}
