package com.moringaschool.bogglesolitaire;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.button) Button mButton1;
    @BindView(R.id.button2) Button mButton2;
    @BindView(R.id.textView3) TextView mText;
    @BindView(R.id.editTextTextPersonName) EditText mWord;
    @BindView(R.id.textView5) TextView mTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mButton1.setOnClickListener(this);
        mButton2.setOnClickListener(this);

        new CountDownTimer(30000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                long secondsUntilFinished = millisUntilFinished / 1000;
                mTime.setText("Seconds remaining: " + secondsUntilFinished);
            }

            @Override
            public void onFinish() {
                mWord.setText(null);
                start();
                mTime.setText("Try again!");
            }
        }.start();
    }

    @Override
    public void onClick(View v) {
        StringBuilder letters = new StringBuilder();

        if(v == mButton1) {
            Random randomIndexList = new Random();
            String[] alphabets = {"a","b","c","d","e","f","g","h","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
            String[] vowels = {"a","e","i","o","u"};
            int numberOfLetters = 6;
            int numberOfVowels = 2;

            for(int i=0; i <= numberOfLetters; i++) {
                int randomIndex = randomIndexList.nextInt(alphabets.length);
                String randomLetter = alphabets[randomIndex];
                letters.append(randomLetter);
            }

            for(int i=0; i<= numberOfVowels; i++) {
                int randomIndex = randomIndexList.nextInt(vowels.length);
                String randomVowel = vowels[randomIndex];
                letters.append(randomVowel);
            }

            String message = letters.toString();
            mText.setText(message);
        }

        if(v == mButton2) {
            String word = mWord.getText().toString();
            String[] arrayLetters = letters.toString().split("");
            String[] arrayUserInput = word.split("");
            StringBuilder comparing = new StringBuilder();

            for(int i=0; i <= arrayLetters.length; i++) {
                for(int j=0; j <= arrayUserInput.length; j++){
                    if(arrayUserInput[j] != arrayUserInput[i]) {
                        i++;
                    }
                    else {
                        comparing.append(arrayUserInput[j]);
                    }
                }
            }
            if (comparing.equals(word)){
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("word", word);
                startActivity(intent);
            }
        }

    }
}