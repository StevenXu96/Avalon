package com.example.avalon;

import Characters.*;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class ShowToPerson extends AppCompatActivity {

    ArrayList<String> names;
    ArrayList<Characters.Character> characters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_to_person);

        Intent i = getIntent();
        names = i.getStringArrayListExtra("names");

        characters = (new CharacterFactory(names)).construct();
    }
}
