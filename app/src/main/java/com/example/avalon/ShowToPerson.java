package com.example.avalon;

import Characters.Character;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class ShowToPerson extends AppCompatActivity {

    ArrayList<Characters.Character> characters;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_to_person);

        Intent i = getIntent();
        characters = (ArrayList<Characters.Character>) i.getSerializableExtra("characters");
        final int index_person = i.getIntExtra("index", 1);

        TextView tv = (TextView) findViewById(R.id.who);
        Button button = (Button) findViewById(R.id.showSkill);

        final Character c = characters.get(index_person-1);
        tv.setText("Please pass this phone to " + c.getName());

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v1) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ShowToPerson.this);

                builder.setCancelable(false);
                builder.setTitle("YOUR ROLE");
                builder.setMessage(c.skill());

                builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();

                        if(index_person == 1){
                            if (characters.size() == 5) {
                                Intent intent = new Intent(ShowToPerson.this, FivePlayers.class);
                                intent.putExtra("characters", characters);
                                intent.putExtra("success", 0);
                                intent.putExtra("fail", 0);
                                intent.putExtra("cap", 0);
                                startActivity(intent);
                            }
                            else if (characters.size() == 6){
                                Intent intent = new Intent(ShowToPerson.this, SixPlayers.class);
                                intent.putExtra("characters", characters);
                                intent.putExtra("success", 0);
                                intent.putExtra("fail", 0);
                                intent.putExtra("cap", 0);
                                startActivity(intent);
                            }
                        }
                        else{
                            Intent intent = new Intent(ShowToPerson.this, ShowToPerson.class);
                            intent.putExtra("characters", characters);
                            intent.putExtra("index", index_person - 1);
                            startActivity(intent);
                        }
                    }
                });
                builder.show();
            }
        });
    }
}
