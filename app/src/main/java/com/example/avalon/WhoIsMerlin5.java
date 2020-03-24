package com.example.avalon;

import Characters.Character;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class WhoIsMerlin5 extends AppCompatActivity {

    ArrayList<Characters.Character> characters;
    ArrayList<String> possibles = new ArrayList<String>();
    String merlin;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.who_is_merlin5);

        Intent ii = getIntent();
        characters = (ArrayList<Character>) ii.getSerializableExtra("test");

        int i = 0;
        while (i < characters.size()){
            if (characters.get(i).check()){
                possibles.add(characters.get(i).getName());
                if(characters.get(i).merlin()){
                    merlin = characters.get(i).getName();
                }
            }
            i += 1;
        }

        final TextView tv = (TextView) findViewById(R.id.assassin4);
        tv.setText("Assassin, consult with your teammates, and kill Merlin!");

        final RadioButton rb1 = (RadioButton) findViewById(R.id.merlin51);
        final RadioButton rb2 = (RadioButton) findViewById(R.id.merlin52);
        final RadioButton rb3 = (RadioButton) findViewById(R.id.merlin53);
        final RadioButton rb4 = (RadioButton) findViewById(R.id.merlin54);
        final RadioButton rb5 = (RadioButton) findViewById(R.id.merlin54);

        rb1.setText(possibles.get(0));
        rb2.setText(possibles.get(1));
        rb3.setText(possibles.get(2));
        rb4.setText(possibles.get(3));
        rb5.setText(possibles.get(4));

        final Button button = findViewById(R.id.submit);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (rb1.isChecked()) {
                    if (possibles.get(0).equals(merlin)) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(WhoIsMerlin5.this);

                        builder.setCancelable(false);
                        builder.setTitle("BAD GUYS WIN!");
                        builder.setMessage("The Assassin killed Merlin! BAD GUYS WIN");

                        builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent i = new Intent(WhoIsMerlin5.this, GameOver.class);
                                i.putExtra("test", characters);
                                startActivity(i);
                            }
                        });
                        builder.show();
                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(WhoIsMerlin5.this);

                        builder.setCancelable(false);
                        builder.setTitle("GOOD GUYS WIN!");
                        builder.setMessage("The Assassin killed the wrong Person! GOOD GUYS WIN");

                        builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent i = new Intent(WhoIsMerlin5.this, GameOver.class);
                                i.putExtra("test", characters);
                                startActivity(i);
                            }
                        });
                        builder.show();
                    }
                } else if (rb2.isChecked()) {
                    if (possibles.get(2).equals(merlin)) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(WhoIsMerlin5.this);

                        builder.setCancelable(false);
                        builder.setTitle("BAD GUYS WIN!");
                        builder.setMessage("The Assassin killed Merlin! BAD GUYS WIN");

                        builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent i = new Intent(WhoIsMerlin5.this, GameOver.class);
                                i.putExtra("test", characters);
                                startActivity(i);
                            }
                        });
                        builder.show();
                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(WhoIsMerlin5.this);

                        builder.setCancelable(false);
                        builder.setTitle("GOOD GUYS WIN!");
                        builder.setMessage("The Assassin killed the wrong Person! GOOD GUYS WIN");

                        builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent i = new Intent(WhoIsMerlin5.this, GameOver.class);
                                i.putExtra("test", characters);
                                startActivity(i);
                            }
                        });
                        builder.show();
                    }
                }
                else if (rb3.isChecked()){
                    if (possibles.get(2).equals(merlin)) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(WhoIsMerlin5.this);

                        builder.setCancelable(false);
                        builder.setTitle("BAD GUYS WIN!");
                        builder.setMessage("The Assassin killed Merlin! BAD GUYS WIN");

                        builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent i = new Intent(WhoIsMerlin5.this, GameOver.class);
                                i.putExtra("test", characters);
                                startActivity(i);
                            }
                        });
                        builder.show();
                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(WhoIsMerlin5.this);

                        builder.setCancelable(false);
                        builder.setTitle("GOOD GUYS WIN!");
                        builder.setMessage("The Assassin killed the wrong Person! GOOD GUYS WIN");

                        builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent i = new Intent(WhoIsMerlin5.this, GameOver.class);
                                i.putExtra("test", characters);
                                startActivity(i);
                            }
                        });
                        builder.show();
                    }
                }
                else if (rb4.isChecked()){
                    if (possibles.get(3).equals(merlin)) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(WhoIsMerlin5.this);

                        builder.setCancelable(false);
                        builder.setTitle("BAD GUYS WIN!");
                        builder.setMessage("The Assassin killed Merlin! BAD GUYS WIN");

                        builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent i = new Intent(WhoIsMerlin5.this, GameOver.class);
                                i.putExtra("test", characters);
                                startActivity(i);
                            }
                        });
                        builder.show();
                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(WhoIsMerlin5.this);

                        builder.setCancelable(false);
                        builder.setTitle("GOOD GUYS WIN!");
                        builder.setMessage("The Assassin killed the wrong Person! GOOD GUYS WIN");

                        builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent i = new Intent(WhoIsMerlin5.this, GameOver.class);
                                i.putExtra("test", characters);
                                startActivity(i);
                            }
                        });
                        builder.show();
                    }
                }
                else if (rb5.isChecked()){
                    if (possibles.get(3).equals(merlin)) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(WhoIsMerlin5.this);

                        builder.setCancelable(false);
                        builder.setTitle("BAD GUYS WIN!");
                        builder.setMessage("The Assassin killed Merlin! BAD GUYS WIN");

                        builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent i = new Intent(WhoIsMerlin5.this, GameOver.class);
                                i.putExtra("test", characters);
                                startActivity(i);
                            }
                        });
                        builder.show();
                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(WhoIsMerlin5.this);

                        builder.setCancelable(false);
                        builder.setTitle("GOOD GUYS WIN!");
                        builder.setMessage("The Assassin killed the wrong Person! GOOD GUYS WIN");

                        builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent i = new Intent(WhoIsMerlin5.this, GameOver.class);
                                i.putExtra("test", characters);
                                startActivity(i);
                            }
                        });
                        builder.show();
                    }
                }
                else{
                    AlertDialog.Builder builder = new AlertDialog.Builder(WhoIsMerlin5.this);

                    builder.setCancelable(true);
                    builder.setTitle("Please select one person");
                    builder.setMessage("You did not choose anyone.");

                    builder.show();
                }
            }
        });
    }
}
