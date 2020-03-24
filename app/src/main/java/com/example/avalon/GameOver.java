package com.example.avalon;

import Characters.Character;
import Characters.CharacterFactory;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Collections;

public class GameOver extends AppCompatActivity {

    ArrayList<Characters.Character> characters;
    ArrayList<Characters.Character> new_characters;
    ArrayList<String> badGuys = new ArrayList<String>();
    ArrayList<String> names = new ArrayList<String>();

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_over);
        
        Intent ii = getIntent();
        characters = (ArrayList<Character>) ii.getSerializableExtra("test");
        int i = 0;
        while (i < characters.size()){
            names.add(characters.get(i).getName());
            if (!characters.get(i).check()){
                badGuys.add(characters.get(i).getName());
            }
            i += 1;
        }


        final TextView tv = (TextView) findViewById(R.id.gameOverText);
        tv.setText("The BAD GUYS are " + badGuys);

        final Button samePeople = (Button) findViewById(R.id.samePeople);
        final Button newGame = (Button) findViewById(R.id.newGame);

        newGame.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(GameOver.this, MainActivity.class));
            }
        });

        samePeople.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(GameOver.this, ShowToPerson.class);
                new_characters = (new CharacterFactory(names)).construct();
                Collections.shuffle(new_characters);
                intent.putExtra("characters", new_characters);
                intent.putExtra("index", names.size());
                startActivity(intent);
            }
        });
    }
}
