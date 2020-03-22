package com.example.avalon;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

@SuppressLint("Registered")
public class howManyPlayers extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.how_many_players);
        final Button start = findViewById(R.id.start_playing);
        start.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v1) {
                final EditText number = findViewById(R.id.editText);
                String temp = number.getText().toString();
                int num = Integer.parseInt(temp);
                Intent i = new Intent(howManyPlayers.this, EnterName.class);
                i.putExtra("number", num);
                startActivity(i);
            }
        });
    }
}