package com.example.spanishapps;

public class VocabularyItem {
    private String word;
    private String translation;
    private int imageResource;

    public VocabularyItem(String word, String translation, int imageResource) {
        this.word = word;
        this.translation = translation;
        this.imageResource = imageResource;
    }

    public String getWord() {
        return word;
    }

    public String getTranslation() {
        return translation;
    }

    public int getImageResource() {
        return imageResource;
    }
}
