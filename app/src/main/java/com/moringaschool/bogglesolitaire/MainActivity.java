package com.moringaschool.bogglesolitaire;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.button) Button mButton1;
    @BindView(R.id.textView3) TextView mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mButton1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Random randomIndexList = new Random();
        String[] alphabets = {"a","b","c","d","e","f","g","h","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        int numberOfLetters = 8;
        StringBuilder letters = new StringBuilder();

        for(int i=0; i <= numberOfLetters; i++) {
            int randomIndex = randomIndexList.nextInt(alphabets.length);
            String randomLetter = alphabets[randomIndex];
            letters.append(randomLetter);
        }

        String message = letters.toString();
        mText.setText(message);
    }
}