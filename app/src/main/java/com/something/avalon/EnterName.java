package com.something.avalon;

import Characters.*;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Collections;

@SuppressLint("Registered")
public class EnterName extends AppCompatActivity {

    int number;
    ArrayList<Characters.Character> characters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_name);
        final ArrayList<String> names = new ArrayList<String>();
        Intent i = getIntent();
        number = i.getIntExtra("number", 0);
        final Button load = findViewById(R.id.load);

        load.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v2) {
                final EditText input = findViewById(R.id.editText2);
                String temp = (input.getText().toString()).trim();
                if (temp.equals("")){
                    AlertDialog.Builder builder = new AlertDialog.Builder(EnterName.this);

                    builder.setCancelable(true);
                    builder.setTitle("Failed");
                    builder.setMessage("Please Enter a real name.");

                    builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    builder.show();
                }

                else if (temp.length() > 15){
                    AlertDialog.Builder builder = new AlertDialog.Builder(EnterName.this);

                    builder.setCancelable(true);
                    builder.setTitle("Failed");
                    builder.setMessage("Please Enter a shorter name. (less than 15 characters)");

                    builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    builder.show();
                }

                else if(!names.contains(temp)) {
                    names.add(temp);
                    number -= 1;

                    if (number > 0) {

                        AlertDialog.Builder builder = new AlertDialog.Builder(EnterName.this);

                        builder.setCancelable(true);
                        builder.setTitle("Success!");
                        builder.setMessage(number + " more names to enter.");

                        builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                                input.setText("");
                            }
                        });

                        builder.show();
                    }
                    else if (number == 0){
                        Intent intent = new Intent(EnterName.this, ShowToPerson.class);
                        characters = (new CharacterFactory(names)).construct();
                        Collections.shuffle(characters);
                        intent.putExtra("characters", characters);
                        intent.putExtra("index", names.size());
                        startActivity(intent);
                    }
                    else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(EnterName.this);

                        builder.setCancelable(true);
                        builder.setTitle("Error");
                        builder.setMessage("Please don't go back when loading names. Please start over the game.");

                        builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                                startActivity(new Intent(EnterName.this, howManyPlayers.class));
                            }
                        });

                        builder.show();
                    }
                }
                else{
                    AlertDialog.Builder builder = new AlertDialog.Builder(EnterName.this);

                    builder.setCancelable(true);
                    builder.setTitle("Failed");
                    builder.setMessage("This name has already been entered. " + number + " more names to enter.");

                    builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    builder.show();
                }
            }
        });
    }
}