package com.example.avalon;

import Characters.Character;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class FivePlayers extends AppCompatActivity {

    ArrayList<Characters.Character> characters;
    int success;
    int fail;
    Character cap;
    int cap_num;
    private int[] flow = new int[]{2, 3, 2, 3, 3};
    private int[] accept = new int[]{0, 0, 0, 0, 0};

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.five_players);

        Intent intent = getIntent();
        characters = (ArrayList<Character>) intent.getSerializableExtra("characters");
        success = intent.getIntExtra("success", 0);
        fail = intent.getIntExtra("fail", 0);
        cap_num = intent.getIntExtra("cap", 0);
        cap = characters.get(cap_num%(characters.size()));

        final TextView yes = (TextView) findViewById(R.id.success);
        final TextView no = (TextView) findViewById(R.id.fail);
        final TextView captain = (TextView) findViewById(R.id.captain);
        final TextView howManyPeople = (TextView) findViewById(R.id.howManyPeople);
        final Button button = (Button) findViewById(R.id.GO);
        final CheckBox c1 = (CheckBox) findViewById(R.id.checkBox51);
        c1.setText(characters.get(0).getName());
        final CheckBox c2 = (CheckBox) findViewById(R.id.checkBox52);
        c2.setText(characters.get(1).getName());
        final CheckBox c3 = (CheckBox) findViewById(R.id.checkBox53);
        c3.setText(characters.get(2).getName());
        final CheckBox c4 = (CheckBox) findViewById(R.id.checkBox54);
        c4.setText(characters.get(3).getName());
        final CheckBox c5 = (CheckBox) findViewById(R.id.checkBox55);
        c5.setText(characters.get(4).getName());

        yes.setText("Success: " + success + " times");
        no.setText("Fail: " + fail + " times");
        captain.setText("The captain of this round is: " + cap.getName());
        howManyPeople.setText("This round, please bring " + flow[success+fail] + " people on the mission.");

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int check = 0;
                final ArrayList<Characters.Character> onMission = new ArrayList<Characters.Character>();
                if(c1.isChecked()){
                    check += 1;
                    onMission.add(characters.get(0));
                }
                if(c2.isChecked()){
                    check += 1;
                    onMission.add(characters.get(1));
                }
                if(c3.isChecked()){
                    check += 1;
                    onMission.add(characters.get(2));
                }
                if(c4.isChecked()){
                    check += 1;
                    onMission.add(characters.get(3));
                }
                if(c5.isChecked()){
                    check += 1;
                    onMission.add(characters.get(4));
                }
                if(check == flow[success+fail]){
                    AlertDialog.Builder builder = new AlertDialog.Builder(FivePlayers.this);

                    builder.setCancelable(false);
                    builder.setTitle("Check with Group");
                    builder.setMessage("Is there more than half of the party agreeing to this?");

                    builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            Intent i = new Intent(FivePlayers.this, Vote.class);
                            i.putExtra("index", 0);
                            i.putExtra("onMission", onMission);
                            i.putExtra("success", success);
                            i.putExtra("fail", fail);
                            i.putExtra("cap", cap_num);
                            i.putExtra("characters", characters);
                            i.putExtra("accept", accept[success+fail]);
                            i.putExtra("votes", 0);
                            startActivity(i);

                        }
                    });

                    builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(FivePlayers.this, FivePlayers.class);
                            intent.putExtra("characters", characters);
                            intent.putExtra("success", success);
                            intent.putExtra("fail", fail);
                            intent.putExtra("cap", cap_num+1);
                            startActivity(intent);
                        }
                    });

                    builder.show();
                }
                else{
                    AlertDialog.Builder builder = new AlertDialog.Builder(FivePlayers.this);

                    builder.setCancelable(true);
                    builder.setTitle("ERROR");
                    builder.setMessage("Please select the correct number of players.");

                    builder.show();
                }
            };
        });
        
    }
}
