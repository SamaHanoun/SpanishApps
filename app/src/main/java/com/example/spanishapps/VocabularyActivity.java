package com.example.spanishapps;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class VocabularyActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private VocabularyAdapter adapter;
    private List<VocabularyItem> vocabularyItems;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocabulary);

        recyclerView = findViewById(R.id.recycler_view_vocabulary);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        sharedPreferences = getSharedPreferences("VocabularyData", Context.MODE_PRIVATE);
        vocabularyItems = loadVocabularyFromSharedPreferences();

        if (vocabularyItems == null || vocabularyItems.isEmpty()) {
            // If vocabulary data is null or empty in SharedPreferences, add sample data
            vocabularyItems = new ArrayList<>(); // Initialize with empty list
            addSampleVocabulary();
            saveVocabularyToSharedPreferences();
        }

        adapter = new VocabularyAdapter(this, vocabularyItems);
        recyclerView.setAdapter(adapter);

        setupSpinner();

        Button backButton = findViewById(R.id.back_to_main_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    private void setupSpinner() {
        String[] alphabetArray = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

        Spinner letterSpinner = findViewById(R.id.letter_spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, alphabetArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        letterSpinner.setAdapter(adapter);

        letterSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Filter vocabulary items based on selected letter
                String selectedLetter = parent.getItemAtPosition(position).toString();
                filterVocabularyByLetter(selectedLetter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });
    }

    private void filterVocabularyByLetter(String letter) {
        List<VocabularyItem> filteredList = new ArrayList<>();
        for (VocabularyItem item : vocabularyItems) {
            if (item.getWord().startsWith(letter)) {
                filteredList.add(item);
            }
        }
        adapter.updateData(filteredList);
    }

    private void addSampleVocabulary() {
        vocabularyItems.add(new VocabularyItem("Hola", "Hello", R.drawable.hola_image));
        vocabularyItems.add(new VocabularyItem("Adiós", "Goodbye", R.drawable.adios_image));
        // Add more sample vocabulary items
    }

    private void saveVocabularyToSharedPreferences() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String vocabularyJson = gson.toJson(vocabularyItems);
        editor.putString("vocabulary", vocabularyJson);
        editor.apply();
    }

    private List<VocabularyItem> loadVocabularyFromSharedPreferences() {
        String vocabularyJson = sharedPreferences.getString("vocabulary", "");
        if (vocabularyJson.isEmpty()) {
            return null;
        }
        Gson gson = new Gson();
        Type listType = new TypeToken<List<VocabularyItem>>() {}.getType();
        return gson.fromJson(vocabularyJson, listType);
    }
}
