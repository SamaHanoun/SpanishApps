package com.example.spanishapps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Method to navigate to LessonsActivity
    public void startLessons(View view) {
        Intent intent = new Intent(this, LessonsActivity.class);
        startActivity(intent);
    }

    // Method to navigate to VocabularyActivity
    public void startVocabulary(View view) {
        Intent intent = new Intent(this, VocabularyActivity.class);
        startActivity(intent);
    }
}
