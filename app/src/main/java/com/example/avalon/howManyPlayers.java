package com.example.avalon;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import androidx.appcompat.app.AppCompatActivity;

@SuppressLint("Registered")
public class howManyPlayers extends AppCompatActivity {

    int num;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.how_many_players);
        final Button start = findViewById(R.id.start_playing);
        start.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v1) {
                final RadioButton rb5 = (RadioButton) findViewById(R.id.fivePlayers);
                final RadioButton rb6 = (RadioButton) findViewById(R.id.sixPlayers);
                final RadioButton rb7 = (RadioButton) findViewById(R.id.sevenPlayers);
                final RadioButton rb8 = (RadioButton) findViewById(R.id.eightPlayers);

                if (rb5.isChecked()){
                    num = 5;
                }
                else if (rb6.isChecked()){
                    num = 6;
                }
                else if (rb7.isChecked()){
                    num = 7;
                }
                else if (rb8.isChecked()){
                    num = 8;
                }
                Intent i = new Intent(howManyPlayers.this, EnterName.class);
                i.putExtra("number", num);
                startActivity(i);
            }
        });
    }
}