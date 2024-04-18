package com.example.spanishapps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.ListView;
        import androidx.appcompat.app.AppCompatActivity;

public class LessonsActivity extends AppCompatActivity {

    private ListView lessonsListView;

    // Define lesson names and IDs
    private String[] lessonNames = {
            "Greetings and Introductions",
            "Numbers and Counting",
            "Common Phrases and Expressions",
            "Colors and Descriptions",
            "Simple Grammar Concepts"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lessons);

        lessonsListView = findViewById(R.id.lessons_list_view);

        // Create an ArrayAdapter to populate the ListView with lesson names
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, lessonNames);

        // Set the ArrayAdapter on the ListView
        lessonsListView.setAdapter(adapter);

        // Set item click listener to handle lesson selection
        lessonsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Pass the lesson ID (position) to LessonContentActivity
                Intent intent = new Intent(LessonsActivity.this, LessonContentActivity.class);
                intent.putExtra("lessonId", position + 1); // Position starts from 0, lesson ID starts from 1
                startActivity(intent);
            }
        });
    }

    public void goBackToMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}

