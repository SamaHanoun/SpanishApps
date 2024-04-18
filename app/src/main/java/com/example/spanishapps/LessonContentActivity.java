package com.example.spanishapps;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class LessonContentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson_content_activity);

        // Call method to save lesson content when LessonsActivity is created
        saveAllLessonContent();

        // Get lesson ID passed from LessonsActivity
        int lessonId = getIntent().getIntExtra("lessonId", -1);

        // Retrieve lesson content from SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("lesson_content", Context.MODE_PRIVATE);
        String lessonContent = sharedPreferences.getString("lesson" + lessonId + "_content", "Lesson not found.");

        // Display lesson content
        TextView lessonContentTextView = findViewById(R.id.lesson_content_text_view);
        lessonContentTextView.setText(lessonContent);
    }

    // Method to store lesson content in SharedPreferences
    private void storeLessonContent(int lessonId, String content) {
        SharedPreferences sharedPreferences = getSharedPreferences("lesson_content", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("lesson" + lessonId + "_content", content);
        editor.apply();
    }
    private void saveAllLessonContent() {
        storeLessonContent(1, "Lesson 1: Greetings and Introductions\n\nBasic greetings:\n- Hola (Hello)\n- Adiós (Goodbye)\n- Buenos días (Good morning)\n- Buenas tardes (Good afternoon)\n- Buenas noches (Good evening)\n\nCommon phrases:\n- Me llamo... (My name is...)\n- Mucho gusto (Nice to meet you)");
        storeLessonContent(2, "Lesson 2: Numbers and Counting\n\nNumbers from 1 to 10:\n1 - uno\n2 - dos\n3 - tres\n4 - cuatro\n5 - cinco\n6 - seis\n7 - siete\n8 - ocho\n9 - nueve\n10 - diez\n\nPractice exercises:\n- Counting objects\n- Telling time\n- Giving phone numbers");
        storeLessonContent(3, "Lesson 3: Common Phrases and Expressions\n\nIn this lesson, you will learn useful phrases and expressions for everyday situations. These phrases will help you communicate effectively in various contexts.\n\n1. Greeting Someone:\n- Hello! ¡Hola!\n- Good morning! ¡Buenos días!\n- Good afternoon! ¡Buenas tardes!\n- Good evening! ¡Buenas noches!\n- How are you? ¿Cómo estás?\n- Fine, thank you. ¿Bien, gracias?\n- And you? ¿Y tú?\n\n2. Ordering Food in a Restaurant:\n- I would like... Quisiera...\n- Can I have...? ¿Puedo tener...?\n- What do you recommend? ¿Qué recomienda?\n- I'm allergic to... Soy alérgico/a a...\n- The bill, please. La cuenta, por favor.\n\n3. Asking for Directions:\n- Excuse me, where is...? Perdón, ¿dónde está...?\n- Is it far from here? ¿Está lejos de aquí?\n- Can you show me on the map? ¿Puede mostrarme en el mapa?\n- Thank you very much. Muchas gracias.\n\n4. Expressing Feelings:\n- I'm happy/sad/excited/nervous. Estoy feliz/triste/emocionado/a/nervioso/a.\n- I love you. Te quiero.\n- I'm sorry. Lo siento.\n- Congratulations! ¡Felicidades!\n- Good luck! ¡Buena suerte!\n\n5. Making Requests:\n- Please... Por favor...\n- Could you...? ¿Podría...?\n- Would you mind...? ¿Le importaría...?\n- Can you help me? ¿Puede ayudarme?\n- Thank you for your help. Gracias por su ayuda.\n\nPractice using these phrases in different situations to improve your Spanish communication skills!");
        storeLessonContent(4, "Lesson 4: Colors and Descriptions\n\nIn this lesson, you will learn basic colors and adjectives to describe objects and people. Understanding colors and descriptions will help you better communicate and express yourself in Spanish.\n\n1. Basic Colors:\n   - Red - Rojo\n   - Blue - Azul\n   - Yellow - Amarillo\n   - Green - Verde\n   - Orange - Naranja\n   - Purple - Morado\n   - Pink - Rosa\n   - Brown - Marrón\n   - Black - Negro\n   - White - Blanco\n\n2. Describing Objects:\n   - This is a red apple. Esta es una manzana roja.\n   - The sky is blue. El cielo es azul.\n   - The sunflower is yellow. El girasol es amarillo.\n   - The grass is green. El césped es verde.\n   - The pumpkin is orange. La calabaza es naranja.\n   - The grapes are purple. Las uvas son moradas.\n   - The flamingo is pink. El flamenco es rosa.\n   - The chocolate is brown. El chocolate es marrón.\n   - The cat is black. El gato es negro.\n   - The snow is white. La nieve es blanca.\n\n3. Describing People:\n   - She has blue eyes. Ella tiene ojos azules.\n   - He wears a red shirt. Él lleva una camiseta roja.\n   - The girl's dress is yellow. El vestido de la niña es amarillo.\n   - Her hair is brown. Su pelo es marrón.\n   - His favorite color is green. Su color favorito es verde.\n   - They have purple shoes. Ellos tienen zapatos morados.\n   - She wears pink lipstick. Ella lleva lápiz labial rosa.\n   - He has a black hat. Él tiene un sombrero negro.\n   - The baby's blanket is white. La manta del bebé es blanca.\n\nPractice describing objects and people using these colors and adjectives to enhance your Spanish language skills!");
        storeLessonContent(5, "Lesson 5: Simple Grammar Concepts\n\nIn this lesson, you will learn basic grammar concepts that are essential for understanding Spanish sentence structure and communication.\n\n1. Gender (Masculine/Feminine):\n   - In Spanish, nouns are categorized as masculine or feminine.\n   - Masculine nouns often end in -o, while feminine nouns end in -a.\n   - For example:\n     - Masculine: el libro (the book), el perro (the dog), el gato (the cat)\n     - Feminine: la mesa (the table), la casa (the house), la silla (the chair)\n\n2. Singular/Plural:\n   - Nouns in Spanish can be singular (referring to one) or plural (referring to more than one).\n   - To form the plural of a noun:\n     - Add -s to nouns ending in a vowel.\n     - Add -es to nouns ending in a consonant.\n   - For example:\n     - Singular: el libro (the book), la mesa (the table)\n     - Plural: los libros (the books), las mesas (the tables)\n\n3. Verb Conjugation (Present Tense):\n   - Verbs in Spanish change their endings depending on the subject (yo, tú, él/ella, nosotros, vosotros, ellos/ellas).\n   - For regular verbs, the endings for each subject are:\n     - Yo -o\n     - Tú -as (or -es for -er and -ir verbs)\n     - Él/Ella -a (or -e for -er and -ir verbs)\n     - Nosotros/as -amos (or -emos for -er and -ir verbs)\n     - Vosotros/as -áis (or -éis for -er and -ir verbs)\n     - Ellos/Ellas -an (or -en for -er and -ir verbs)\n   - For example:\n     - Hablar (to speak):\n       - Yo hablo (I speak)\n       - Tú hablas (You speak)\n       - Él/Ella habla (He/She speaks)\n       - Nosotros/as hablamos (We speak)\n       - Vosotros/as habláis (You all speak)\n       - Ellos/Ellas hablan (They speak)\n\nUnderstanding these basic grammar concepts will help you build sentences correctly and communicate effectively in Spanish!");
    }
}

