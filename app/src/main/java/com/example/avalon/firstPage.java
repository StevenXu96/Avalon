package com.example.avalon;

import Characters.Character;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class firstPage extends AppCompatActivity {

    ArrayList<Characters.Character> characters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_page);

        Intent intent = getIntent();
        characters = (ArrayList<Character>) intent.getSerializableExtra("characters");

        
    }
}
