package com.myapp.learnfast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;

import java.util.Locale;
public class MainActivity extends AppCompatActivity {

    TextView welcome_msg;
    CardView course;
    CardView quiz;
    CardView flashcard;
    CardView progress;
    CardView award;
    CardView about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        course = findViewById(R.id.course);
        course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,study.class);
                startActivity(intent);
            }
        });

        quiz = findViewById(R.id.quiz);
        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,quiz.class);
                startActivity(intent);
            }
        });

        flashcard = findViewById(R.id.flashcard);
        flashcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,flashcard.class);
                startActivity(intent);
            }
        });

        progress = findViewById(R.id.progress);
        progress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,progress.class);
                startActivity(intent);
            }
        });

        award = findViewById(R.id.award);
        award.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,award.class);
                startActivity(intent);
            }
        });

        about = findViewById(R.id.about);
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,about.class);
                startActivity(intent);
            }
        });
        


    }

}