package com.example.avalon;

import Characters.*;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class ShowToPerson extends AppCompatActivity {

    ArrayList<String> names;
    ArrayList<Characters.Character> characters;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_to_person);

        Intent i = getIntent();
        names = i.getStringArrayListExtra("names");

        characters = (new CharacterFactory(names)).construct();

        TextView tv = (TextView) findViewById(R.id.who);
        tv.setText("Please pass this phone to " + characters.get(0).getName());
    }
}
